/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function registrarSolicitante(codigo,nombre,ap_paterno,ap_materno,email,telefono,sexo,direccion)
{

   if(codigo===""|| nombre==="" || ap_paterno ==="" ||ap_materno==="" ||email==="" ||telefono==="" ||sexo==="" || direccion===""){
       
        vaciar();
   }else{
    
    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlPedido?opc=registrarSolicitante&codigo="+codigo+"&nombre="+nombre+"&ap_p="+ap_paterno+"&ap_m="+ap_materno+"&email="+email+"&tel="+telefono+"&sexo="+sexo+"&direccion="+direccion+"",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        //data: "id=" + id,
        beforeSend: inicioEnvio,
        success: llegada,
        timeout: 4000,
        error: problemas
    });}
    return false;
}
function inicioEnvio()
{
    var x = $(".modal-body");
    x.html('<img src="../img/loading.gif" alt="" height="50px" width="50px" />');
}
function llegada(datos)
{
    $(".modal-body").html(datos);
}
function problemas()
{
    $(".modal-body").text('Problemas en el servidor.');
}
function  vaciar(){
    
}


