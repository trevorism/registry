$(function(){

    $.get( "api/service/web", function( data ) {

        for(var i = 0; i < data.length; i++){
            $("#serviceTableContent").append(renderRow(data[i]));
        }

        alert("blah1");
    });

    function renderRow(item){
        var row = $("<tr />")
        row.append($("<td>" + item.id + "</td>"));
        row.append($("<td>" + item.name + "</td>"));
        row.append($("<td>" + item.url + "</td>"));
        row.append($("<td>" + item.giturl + "</td>"));
        row.append($("<td>" + true + "</td>"));
        return row;
    }

});