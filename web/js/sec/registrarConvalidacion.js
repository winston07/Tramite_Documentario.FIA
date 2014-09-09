/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function() {
    inicio1();
};
function inicio1() {
    var vali = $("#validacion1").val();
    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        url: "../ControlValidacion?opc=listar&validacion=" + vali + "",
        //url: "../ControlCurso",
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
    var x = $("#resultados");
    x.html('<img src="../img/loading.gif" alt="" height="50px" width="50px" />');
}
function llegada2(datos)
{
    $("#resultados").html(datos);

}
function problemas2()
{
    $("#resultados").text('Problemas en el servidor.');
}
function enviarDatos()
{

    var ciclo = $("#ciclo1").val();
    var curso = $("#curso1").val();
    var cr = $("#cr1").val();
   /*
    var ht = $("#ht1").val();
    var hnp = $("#hnp1").val();
    var th = $("#th1").val();*/
    var nota = $("#nota1").val();
    var vali = $("#validacion1").val();

    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        url: "../ControlValidacion?opc=addcurso&ciclo=" + ciclo + "&&curso=" + curso + "&&cr=" + cr + /*"&&ht=" + ht + "&&hnp=" + hnp + "&&th=" + th + */"&&nota=" + nota + "&&validacion=" + vali + "",
        //url: "../ControlCurso",
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


function registarConvalidacion()
{


    var cod = $("#codigo").val();
    var ped = $("#pedido").val();
    var tra = $("#tramite").val();
    var oldplan = $("#plan_in1").val();
    var newplan = $("#plan_out").val();
    var vali = $("#validacion").val();
    var inst_in = $("#inst_in").val();
    var inst_out = $("#inst_out").val();
    var uni_in = $("#unversidad").val();
     var fac_in = $("#facultad").val();

    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlValidacion?opc=cabecera&&pedido=" + ped + "&&codigo=" + cod + "&&tramite=" + tra + "&&oldplan=" + oldplan + "&&newplan=" + newplan + "&&validacion=" + vali + "&&inst_in=" + inst_in + "&&inst_out="+inst_out+"&&uni="+uni_in+"&&fac="+fac_in+"",
        beforeSend: inicioEnvio1,
        success: llegada1,
        timeout: 4000,
        error: problemas1
    });
    return false;
}
function inicioEnvio1()
{
    // toogle('block', 'modal', 'ventana');
    var x = $("#res");
    x.html('<img src="../img/loading.gif" alt="" height="50px" width="50px" />');
}
function llegada1(datos)
{
    //toogle('block', 'modal', 'ventana');
    $("#res").html(datos);


}
function problemas1(datos)
{

    $("#res").html(datos);
    //toogle('block', 'modal', 'ventana');
}
function enviarCursos1(){
    
    var vali = $("#validacion1").val();

    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        url: "../ControlValidacion?opc=enviocursos&&validacion=" + vali + "",
        //url: "../ControlCurso",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        //data: "id=" + id,
        beforeSend: inicioEnvioCursos1,
        success: llegadaCursos1,
        timeout: 4000,
        error: problemasCursos1
    });
    return false;
}
function inicioEnvioCursos1()
{
    var x = $("#res");
   x.html('<img src="../img/loading.gif" alt="" height="50px" width="50px" />');
}
function llegadaCursos1(datos)
{
    $("#res").html(datos);
}
function problemasCursos1()
{
    $("#res").text('Problemas en el servidor.');
}
function toogle5(a, b, c)
{
    document.getElementById(b).style.display = a;
    document.getElementById(c).style.display = a;
}
