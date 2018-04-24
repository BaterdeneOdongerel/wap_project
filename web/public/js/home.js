function initial() {

    $("button[event='join']").on("click", function(){
       ajaxJoinEvent( this , $(this).attr("data-event")  , $(this).attr("data-user") );
    } );

    $("button[event='leave']").on("click", function(){
        ajaxLeaveEvent( this , $(this).attr("data-event")  , $(this).attr("data-user") );
    } );

    $(document).ajaxStart(function() { $(".loader").show(); })
        .ajaxStop(function() { $(".loader").hide(); });

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