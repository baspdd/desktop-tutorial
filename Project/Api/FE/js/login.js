var check1 = check2 = false;

$(document).ready(() => {

});

var notice = (id, content) => $(`#${id}`).text(content);

var anyKey = (key) => {
    $.ajax({
        url: `http://localhost:5024/api/Keys/key?key=${key}`,
        type: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => { check1 = data; if (!data) $('#key_danger').text("Key is not valid"); },
        error: () => { alert("Error"); },
    });
}

var anyAccount = (acc, pass) => {
    $.ajax({
        url: `http://localhost:5024/api/Accounts?acc=${acc}&pass=${pass}`,
        type: "GET",
        headers: {
            "Content-Type": "application/json",
        },
        success: (data) => { check2 = data; if (!data) $('#account_danger').text("Account is not valid"); },
        error: () => { alert("Error"); },
    });
}

var testAsign = () => {
    notice('key_danger', '');
    notice('account_danger', '');

    anyKey($('#key').val());
    anyAccount($('#account').val(), $('#pass').val())
    if (check1 && check2) {
        localStorage.setItem("key", $('#key').val());
        localStorage.setItem("accountId", $('#account').val());
        location.href = 'index.html';
    }
}

