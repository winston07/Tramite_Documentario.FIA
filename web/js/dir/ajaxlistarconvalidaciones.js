
window.onload = function() {
    enviar2();

};
function anularNull() {
    var e = 900;
    for (var i = 0; i < e; i++) {
        var ciclo = $("." + i + "ciclo").val();
        var curso = $("." + i + "curso").val();
        var cr = $("." + i + "cr").val();
        var ht = $("." + i + "ht").val();
        var hnp = $("." + i + "hnp").val();
        var th = $("." + i + "th").val();
        var nota = $("." + i + "nota").val();
        if(ciclo==="null") {
            $("." + i + "ciclo").val("");
        }if(curso==="null"){
            $("." + i + "curso").val("");
        }if(cr==="null"){
            $("." + i + "cr").val("");
        }if(ht==="null"){
            $("." + i + "ht").val("");
        }if(hnp==="null"){
            $("." + i + "hnp").val("");
        }if(th==="null"){
            $("." + i + "th").val("");
        }if(nota==="null"){
            $("." + i + "nota").val("");
        }
    }
    
}
function enviar2()
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
        url: "../ControlPedidoD?opc=synconvalidacion&&id=TRM00002&estado=Validando",
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
    x.html('<img src="../img/loading.gif" alt="" height="50px" width="50px" />');
}
function llegada(datos)
{
    $("#resultados").html(datos);
}
function problemas()
{
    $("#resultados").html('<img src="../img/loading.gif" alt="" height="50px" width="50px" />');
}
function toogle3(a, b, c)
{
    document.getElementById(b).style.display = a;
    document.getElementById(c).style.display = a;
}
function tooglevalidar(a, b, c, idva, idPed)
{
    document.getElementById(b).style.display = a;
    document.getElementById(c).style.display = a;
    validarValidacion(idva, idPed);
}

function validarValidacion(idvali, idPed)
{



    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlPedidoD?opc=validar&idvali=" + idvali + "&idPed=" + idPed + "",
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
    x.html('<img src="../img/loading.gif" alt="" height="50px" width="50px" />');
}
function llegada2(datos)
{
    $("#res").html(datos);
    anularNull();
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
        url: "../ControlPedido?opc=eliminarvalidacion&idpedido=" + id + "&idvali=" + idvali + "",
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
    var x = $("#ex");
    x.html('<img src="../img/loading.gif" alt="" height="50px" width="50px" />');
}
function llegada3(datos)
{
    $("#ex").html(datos);
}
function problemas3()
{
    $("#ex").text('Problemas en el servidor.');
}



function cambiarcolor(a, b) {
    document.getElementById(a).style.background = "red";
    document.getElementById(b).style.background = "red";
}
function cambiarcolor2(a, b) {
    document.getElementById(a).style.background = "#fff";
    document.getElementById(b).style.background = "#fff";
}


