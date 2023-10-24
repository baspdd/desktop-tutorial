﻿var currentIndex = 0;
var questions = {};
var acc = localStorage.getItem('accountId');
var key = localStorage.getItem('key');
var student;
$(document).ready(() => {
    getQuestions();
    getStudent();
});

var getStudent = () => {
    $.ajax({
        url: `http://localhost:5024/api/Accounts/${acc}`,
        type: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => { student = data; $('#student').text('Student Name : ' + data.fullName) },
        error: () => alert("Error"),
    });
}


var getQuestions = () => {
    $.ajax({
        url: `http://localhost:5024/api/Questions?filter=keyId eq '${key}'`,
        type: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => { loadDataTable(data); questions = data; },
        error: () => alert("Error"),
    });
}

var loadDataTable = (questions) => {
    var currentQuestion = questions[currentIndex];

    $("#numberAnswer").text(`There are ${questions.length} questions and your progress of answering is`);
    $("#idAnswers").text('Questions ' + (currentIndex + 1));
    $("#numberAnswers").text(currentQuestion.numberRightAnswer);
    $("#questionContent").text(currentQuestion.content);
    $("#checkboxList").empty();

    $.each(currentQuestion.listAnswer, (index, item) => {
        var checkbox = $("<input>").attr({
            type: 'checkbox',
            id: item.content,
            checked: item.ticked,
        }).change(function (event) {
            item.ticked = event.target.checked;
        });
        var label = $("<label>").attr({
            for: item.content,
        }).text(item.content);
        $("#checkboxList").append(checkbox, label, $("<br>"));
    });
}

function handleBackButtonClick() {
    if (currentIndex > 0) {
        currentIndex--;
        loadDataTable(questions);
        $("#nextButton").prop("disabled", false);
    }
    if (currentIndex === 0)
        $("#backButton").prop("disabled", true);
}

function handleNextButtonClick() {
    if (currentIndex < questions.length - 1) {
        currentIndex++;
        loadDataTable(questions);
        $("#backButton").prop("disabled", false);
    }
    if (currentIndex === questions.length - 1)
        $("#nextButton").prop("disabled", true);
}