$(document).ready(function () {

});


var courseID;
var check;

var getCourse = (courseName) => {
    $.ajax({
        url: `http://localhost:5024/api/Courses/${courseName}`,
        type: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => { courseID = data },
        error: () => alert("Error"),
    });
}


function handleFileChange(input) {
    var file = input.files[0];
    readXlsxFile(file).then(function (data) {


        const hash_data = ['Question', 'Answer', 'RightAnswer']
        const indices = [];
        var rowStart = 0;

        data.forEach((row, rowIndex) => {
            if (row[0] == 'Stt') rowStart = rowIndex;
            row.forEach((item, celIndex) => {
                if (hash_data.includes(item)) indices.push(celIndex);
            });
        });

        var question = {
            examId: data[0][1],
            courseId: courseID,
        };
        console.log(question);

        data.forEach((row, rowIndex) => {
            row.forEach((cell, celIndex) => {
                if (rowIndex > rowStart && celIndex >= indices[0]) {
                    if (cell) {
                        if (celIndex == indices[0])
                            console.log(cell);
                    }
                }
            });
        });

    });
}



// {
//     "keyId": "string",
//     "courseId": 0,
//     "questions": [
//       {
//         "questionId": 0,
//         "keyId": "string",
//         "content": "string",
//         "answer": "string",
//         "rightAnswer": "string",
//         "numberRightAnswer": 0
//       }
//     ]
//   }
function compare(cell, title) {

}