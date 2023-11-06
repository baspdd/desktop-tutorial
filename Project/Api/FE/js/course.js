
var check;
$(document).ready(() => {
    getCourse();

});

var getCourse = () => {
    $.ajax({
        url: `http://localhost:5024/api/Courses?$filter=contains(CourseName, '${$('#search').val()}')`,
        type: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => loadCourse(data),
        error: () => alert("Error"),
    });
}

//courseId
var loadCourse = (data) => {
    $('#listCourse').empty();
    data.forEach(item => {
        var html = `<div onclick="getKeys(${item.courseId})" class="course">${item.courseName}</div>`;
        $('#listCourse').append(html);
    });
};

var getKeys = (id) => {
    $.ajax({
        url: `http://localhost:5024/api/Keys?$filter=CourseId eq ${id}&select=keyId`,
        type: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => { loadKey(data); },
        error: () => alert("Error"),
    });
}

var loadKey = (data) => {
    $('#keys').fadeIn();
    $('#listKey').empty();
    data.forEach(item => {
        var html = `<div onclick="getExam('${item.KeyId}')" class="course">${item.KeyId}</div>`;
        $('#listKey').append(html);
    });
};


var getExam = (id) => {
    $('#generate').val(id);
    $.ajax({
        url: `http://localhost:5024/api/Questions/${id}`,
        type: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => { loadTable(data); },
        error: () => alert("Error"),
    });
}


var loadTable = (data) => {
    $('#score').fadeIn();
    $('#table').empty();
    data.forEach(item => {
        var html = `
        <tr>
            <td>${item.examId}</td>
            <td>${item.accountName}</td>
            <td>${item.score}</td>
        </tr>`;
        $('#table').append(html);
    });
};


var generate = () => {
    $.ajax({
        url: `http://localhost:5024/api/Questions/gen/${$('#generate').val()}`,
        type: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => { exportExcel(data); },
        error: () => alert("Error"),
    });
}


var exportExcel = (formal) => {
    var header = [
        {
            type: String,
            value: 'Student ID',
            fontWeight: 'bold'
        },
        {
            type: String,
            value: 'Student Name',
            fontWeight: 'bold'
        },
        {
            type: String,
            value: 'Key of Course',
            fontWeight: 'bold'
        },
        {
            type: String,
            value: 'Score',
            fontWeight: 'bold'
        }
    ];
    var arrayOfArrays = formal.map(item => [
        {
            type: String,
            value: item.accountId,
        },
        {
            type: String,
            value: item.accountName,
        },
        {
            type: String,
            value: item.keyId,
        },
        {
            type: String,
            value: item.score
        },
        // item.examAnswers.map(answer => answer.rightRightAnswer)
    ]);

    arrayOfArrays.unshift(header);
    check = arrayOfArrays;
    writeXlsxFile(arrayOfArrays, {
        fileName: 'file.xlsx'
    })
}

