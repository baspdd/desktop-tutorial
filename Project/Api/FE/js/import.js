$(document).ready(function () {

});

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
       
        data.forEach((row, rowIndex) => {
            row.forEach((cell, celIndex) => {
                if (rowIndex > rowStart && celIndex >= indices[0]) {
                        console.log(cell);
                }
            });
        });

    });
}

function compare(cell, title) {

}