function registerEvents() {
    $( "#error-box" ).hide();
    $( "#start_date" ).datepicker({ dateFormat: 'yy-mm-dd' });
    $("#start_time").timepicker({
        timeFormat: 'h:mm p',
        interval: 60,
        minTime: '10',
        maxTime: '6:00pm',
        defaultTime: '11',
        startTime: '10:00',
        dynamic: false,
        dropdown: true,
        scrollbar: true
    });
    $("#cancel").click(function () {
        $('#create_form')[0].reset();
    })
    $("#submit").click(function () {
        const errorMessage = validate();
        if (!errorMessage) {
            postEvent();
        } else {
            $("#error-box" ).show();
            $("#notification" ).text(errorMessage);
        }
    })

    $("#raise").click(function () {
        $("#raise_modal").modal();
    })

    $("#raise_event").click(function () {
        const id = $("#id").val();
        alert(id);
        const location = $("#accident_location").val();
        const description = $("#accident_location").text();
        raiseEvent(id, location, description);
    })

}

function validate() {
    const title = $("#title");
    const start_date = $("#start_date");
    const start_time = $("#start_time");
    const start_location = $("#begin_location");
    const end_location = $("#end_location");
    const distance = $("#distance");
    var missing = required(title) || required(start_date) ||  required(start_time) || required(end_location) || required(start_location) || required(distance);
    return missing ? "Please fill out missing information!" : undefined;

}

function required(element) {
    if (!element.val()) {
        element.closest(".form-group").addClass("has-error");
        return true;
    } else {
        element.closest(".form-group").removeClass("has-error");
        return false;
    }
}

function raiseEvent(id, location, description) {
    const data = {id: id, accident_location: location, accident_description: description}
    $.ajax("/raise_event"
        , {
            "type": "POST",
            "date": data,
        }).done(function (data) {
            window.location.reload;
        }
    ).fail(function () {

    });
}

function postEvent() {
    const data = $('#create_form').serialize();
    const id = $('#id').val();
    if (id) {
        $.ajax("/edit_event"
            , {
                "type": "POST",
                "data": data,
            }).done(function (data) {
                $("#error-box" ).show();
                $("#notification" ).text("Cool! Event Updated");
            }
        ).fail(function () {

        });
    } else {
        $.ajax("/create_event"
            , {
                "type": "POST",
                "data": data,
            }).done(function (data) {
                $( "#error-box" ).hide();
                $('#create_form')[0].reset();
                $("#error-box" ).show();
                $("#notification" ).text("Cool! Event Created");
            }
        ).fail(function () {

        });
    }
}

$(document).ready(function () {
    registerEvents();
});