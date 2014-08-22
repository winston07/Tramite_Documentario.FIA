
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
        url: "../ControlPedido?opc=synconvalidacion&&id=TRM00002",
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
function toogle4(a, b, c)
{
    document.getElementById(b).style.display = a;
    document.getElementById(c).style.display = a;
}

function elimanarConvalidacion(id, cod, nom, apell)
{



    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlPedido?opc=eliminarpedido&idpedido=" + id + "&codigo=" + cod + "&nombre=" + nom + "&apellido=" + apell + "&tramite=TRM00002",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        //data: "id=" + id,
        beforeSend: inicioEnvioc,
        success: llegadac,
        timeout: 4000,
        error: problemasc
    });
    return false;
}
function inicioEnvioc()
{
    var x = $("#res");
    x.html('Cargando...');
}
function llegadac(datos)
{
    $("#res").html(datos);
}
function problemasc()
{
    $("#res").text('Problemas en el servidor.');
}








