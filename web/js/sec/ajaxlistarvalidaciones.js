
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
function toogle3(a, b, c)
{
    document.getElementById(b).style.display = a;
    document.getElementById(c).style.display = a;
}

function elimanarValidacion(id, cod, nom, apell)
{



    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlPedido?opc=verpro&idpedido=" + id + "&codigo=" + cod + "&nombre=" + nom + "&apellido=" + apell + "&tramite=TRM00001",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        //data: "id=" + id,
        beforeSend: inicioEnvio2,
        success: llegada2,
        timeout: 4000,
        error: problemas2
    });
    return false;
}
function inicioEnvio2()
{
    var x = $("#res");
    x.html('Cargando...');
}
function llegada2(datos)
{
    $("#res").html(datos);
}
function problemas2()
{
    $("#res").text('Problemas en el servidor.');
}

function elimanarValidacion1(id, idvali)
{



    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlPedido?opc=eliminarvalidacion&idpedido=" + id + "&idvali=" + idvali +"",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        //data: "id=" + id,
        beforeSend: inicioEnvio3,
        success: llegada3,
        timeout: 4000,
        error: problemas3
    });
    return false;
}
function inicioEnvio3()
{
    var x = $("#res");
    x.html('Cargando...');
}
function llegada3(datos)
{
    $("#ex").html(datos);
}
function problemas3()
{
    $("#ex").text('Problemas en el servidor.');
}

