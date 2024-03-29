function updateFeed(response, divElement, divPrise) {
    let htmlElement = '';
    for (let i = 0; i < response['time'].length; i++) {
        htmlElement += '<p><input name="time" type="radio" value="' + response['time'][i] + '" required> ' + response['time'][i] + ':00 </p>';
    }

    divPrise.html(response['prise']);

    divElement.html(htmlElement);
}

function sendAjax(table_number, id) {
    let hours = document.getElementById("table-" + table_number + "-hours").value;
    let day = document.getElementById("table-" + table_number + "-day").value;

    if (day === "---") {
        return;
    }

    let data = {
        "id": id,
        "day": day,
        "hours": hours
    };

    $.ajax({
        type: "POST",
        url: "/ajaxTable?id=" + id,
        data: JSON.stringify(data),
        success: function (response) {
            updateFeed(response, $('#table-' + table_number + '-time'), $('#table-' + table_number + '-prise'))
        },
        dataType: "json",
        contentType: "application/json"
    });
}