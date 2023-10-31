
var check;
$(document).ready(() => {
    getCourse();
    get();
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

var getKeys = (key) => {
    $.ajax({
        url: `http://localhost:5024/api/Keys?$filter=CourseId eq ${key}`,
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
        var html = `<div onclick="" class="course">${item.keyId}</div>`;
        $('#listKey').append(html);
    });
};