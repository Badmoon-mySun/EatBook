function updateFeed(response, divElement) {
    let htmlElement = '';
    for (let i = 0; i < response['time'].length; i++) {
        htmlElement += '<p><input name="time" type="radio" value="' + response['time'][i] + '"> ' + response['time'][i] + ':00 </p>';
    }
    console.log(htmlElement);

    divElement.html(htmlElement);
}

function sendAjax(table_number, id) {
    let hours = document.getElementById("table-" + table_number + "-hours").value;
    let day = document.getElementById("table-" + table_number + "-day").value;

    let data = {
        "id": id,
        "day": day,
        "hours": hours
    };

    $.ajax({
        type: "POST",
        url: "/tables?id=" + id,
        data: JSON.stringify(data),
        success: function (response) {
            updateFeed(response, $('#table-' + table_number + '-time'))
        },
        dataType: "json",
        contentType: "application/json"
    });
}