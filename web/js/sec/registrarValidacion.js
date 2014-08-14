/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ocultarBotton(){
    document.getElementById("opc").style.visibility="hidden";
}
function enviar()
{

    var idCu = $("#curso").val();
    var vali = $("#validacion").val();

    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        url: "../ControlValidacion?opc=addcurso&id=" + idCu + "&validacion=" + vali + "",
        //url: "../ControlCurso",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        data: "id=" + id,
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
    // x.html('<img src="../img/loading.gif"  class="btn-circle"/>');
}
function llegada(datos)
{
    $("#resultados").html(datos);
   
}
function problemas()
{
    $("#resultados").text('Problemas en el servidor.');
}


function registarValidacion()
{


    var cod = $("#codigo").val();
    var ped = $("#pedido").val();
    var tra = $("#tramite").val();
    var oldplan = $("#plan_in").val();
    var newplan = $("#plan_out").val();
    var vali = $("#validacion").val();
    var inst_in = $("#inst_in").val();

    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlValidacion?opc=cabecera&&pedido=" + ped + "&&codigo=" + cod + "&&tramite=" + tra + "&&oldplan=" + oldplan + "&&newplan=" + newplan + "&&validacion=" + vali + "&&escuela="+inst_in+"",
        beforeSend: inicioEnvio1,
        success: llegada1,
        timeout: 4000,
        error: problemas1
    });
    return false;
} 