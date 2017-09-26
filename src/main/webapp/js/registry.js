$(function(){


    $("#serviceTableContent").append("<img width='32' height='32' src=\"img/loading.gif\"/>");
    $("#internalTableContent").append("<img width='32' height='32' src=\"img/loading.gif\"/>");

    $.get( "api/service/web", function( data ) {
        $("#serviceTableContent").empty();
        for(var i = 0; i < data.length; i++){
            $("#serviceTableContent").append(renderServiceRow(data[i]));
        }
    });

    $.get( "api/service/lib", function( data ) {
        $("#internalTableContent").empty();
        for(var i = 0; i < data.length; i++){
            $("#internalTableContent").append(renderLibraryRow(data[i]));
        }
    });

    function renderServiceRow(item){
        var url = (item.dns) ? item.dns : item.url;

        var row = $("<tr />")
        row.append($("<td>" + item.id + "</td>"));
        row.append($("<td>" + item.name + "</td>"));
        row.append($("<td><a href='" + url + "'>" + url + "</a></td>"));
        row.append($("<td><a href='" + item.giturl + "'>" + item.giturl + "</a></td>"));
        row.append($("<td><a href='" + item.host + "'>" + "<img src='img/go.png' width='16' height='16'/>" + "</a></td>"));

        return row;
    }

    function renderLibraryRow(item){
        var row = $("<tr />")
        row.append($("<td>" + item.id + "</td>"));
        row.append($("<td>" + item.name + "</td>"));
        row.append($("<td><a href='" + item.giturl + "'>" + item.giturl + "</a></td>"));
        return row;
    }

});