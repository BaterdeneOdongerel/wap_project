function initial() {
    $("button[event='edit']").on("click", function() {
        alert("Clickin");
        const eventid = $(this).attr("data-event");
        const userid = $(this).attr("data-user");
        window.location.href = "/edit_event?event_id=" + eventid + "&user_id=" + userid;
    });

    $("button[event='join']").on("click", function(){
       ajaxJoinEvent( this , $(this).attr("data-event")  , $(this).attr("data-user") );
    } );

    $("button[event='leave']").on("click", function(){
        ajaxLeaveEvent( this , $(this).attr("data-event")  , $(this).attr("data-user") );
    } );

    $(document).ajaxStart(function() { $(".loader").show(); })
        .ajaxStop(function() { $(".loader").hide(); });

    $("#signup").click(function () {
        if (!checkValidation()) {
            return false;
        }
    });
}

function checkValidation() {
    var username = $("#username");
    var fname = $("#firstname");
    var lname = $("#lastname");
    var pass = $("#password");
    var rpass = $("#rpassword");
    var email = $("#email");
    $("form div").removeClass("has-error");

    if ( username.val().toString().length == 0) {
        username.parent().parent().addClass("has-error");
        return false;
    }
    if ( fname.val().toString().length == 0) {
        fname.parent().parent().addClass("has-error");
        return false;
    }

    if ( pass.val().toString().length == 0 || pass.val() != rpass.val() ) {
        pass.parent().parent().addClass("has-error");
        rpass.parent().parent().addClass("has-error");
        return false;
    }

    if ( email.val().toString().length == 0) {
        email.parent().parent().addClass("has-error");
        return false;
    }
    return true;
}

function ajaxJoinEvent(elem,eventid,userid){
    $.ajax("/joinAjax"
        , { "type": "POST",
            "data": { "eventid": eventid,
                "userid": userid },
        }) .done( function(data){
                $(elem).parent().parent().find("span[event='notjoined']").addClass("hidden");
                $(elem).parent().parent().find("span[event='joined']").removeClass("hidden");
                $(elem).parent().parent().find("button[event='join']").addClass("hidden");
                $(elem).parent().parent().find("button[event='leave']").removeClass("hidden");
                console.log(data);
            }
    ).fail(function(){
    });
}


function ajaxLeaveEvent(elem,eventid,userid){
    $.ajax("/leaveAjax"
        , { "type": "POST",
            "data": { "eventid": eventid,
                "userid": userid },
        }) .done( function(data){
            $(elem).parent().parent().find("span[event='notjoined']").removeClass("hidden");
            $(elem).parent().parent().find("span[event='joined']").addClass("hidden");
            $(elem).parent().parent().find("button[event='join']").removeClass("hidden");
            $(elem).parent().parent().find("button[event='leave']").addClass("hidden");
            console.log(data);
        }
    ).fail(function(){
    });
}


$( document ).ready(function() {
    initial();
});