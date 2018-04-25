function initial() {

    $("#btnsearch").click( function () {
        ajaxRetrieveUser( $("#search").val() );
    } );

    $(document).ajaxStart(function() { $(".loader").show(); })
        .ajaxStop(function() { $(".loader").hide(); });
}

function ajaxRetrieveUser(username){
    $.ajax("/userAjax"
        , { "type": "get",
            "data": { "username": username},
        }) .done( function(data){
            console.log(data);
            drawtable(data);
        }
    ).fail(function(){

    });
}
function createLinktd(link) {

    var td = $("<td>");
    var button = $("<button>" , {
        "type":"button",
        "class":"btn btn-info",
    });
    button.append( $("<span>", {"class":"glyphicon glyphicon-search" } ) );
    td.append(button);
    return td;
}
function  drawtable(json) {
    $("#mytable > tbody > tr").remove();
    var table = $("#mytable > tbody ");
    for ( var i = 0; i < json.length; i ++) {
        var tr = $("<tr>");
        tr.append( $("<td>").html(json[i]["username"]));
        tr.append($("<td>").html(json[i]["firstName"]));
        tr.append($("<td>").html(json[i]["lastName"]));
        tr.append($("<td>").html(json[i]["email"]));
        tr.append( createLinktd("wwwww"));
        table.append(tr);
    }
}
$( document ).ready(function() {
    initial();
    ajaxRetrieveUser("");
});