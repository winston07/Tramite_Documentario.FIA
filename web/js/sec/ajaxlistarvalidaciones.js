
var x;
x = $(document);
x.ready(enviar());
function enviar()
{

    //var id = $("#revisar").val();

    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlPedido?opc=sync&&id=TRM00001",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        //data: "id=" + id,
        beforeSend: inicioEnvio,
        success: llegada,
        timeout: 4000,
        error: problemas
    });
    return false;
}
function inicioEnvio()
{
    var x = $("#resultados");
    //x.html('Cargando...');
}
function llegada(datos)
{
    $("#resultados").html(datos);
}
function problemas()
{
    $("#resultados").text('Problemas en el servidor.');
}




