$(function(){

    $.get( "api/service/web", function( data ) {
        for(var i = 0; i < data.length; i++){
            $("#serviceTableContent").append(renderRow(data[i]));
        }
    });

    function renderRow(item){
        var row = $("<tr />")
        row.append($("<td>" + item.id + "</td>"));
        row.append($("<td>" + item.name + "</td>"));
        row.append($("<td><a href='" + item.url + "'>" + item.url + "</a></td>"));
        row.append($("<td><a href='" + item.giturl + "'>" + item.giturl + "</a></td>"));
        row.append($("<td>" + true + "</td>"));
        return row;
    }

});