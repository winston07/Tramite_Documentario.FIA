/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validar() {
        

    var usu = $("#usu").val();
    var clave = $("#cla").val();
    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        url: "ControlUsuarios?usuario=" + usu + "&&clave="+clave+"",
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
    x.html('<img src="img/loading.gif"  />');
}
function llegada2(datos)
{
    if(datos){
        alert("exito"+datos);
    }
    else{
        alert("no"+datos);
    }
    //$("#resultados").html('<img src="img/loading.gif"  />');

}
function problemas2()
{
    $("#resultados").html('<img src="img/loading.gif"  />');
}


