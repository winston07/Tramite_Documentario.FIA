/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function enviardatos(idCursoV,idPedido,a, b, c, d, e, f, g, ciclo, nombre, cr, ht, hnp, th, nota) {
    document.getElementById(ciclo).value = a;
    document.getElementById(nombre).value = b;
    document.getElementById(cr).value = c;
    document.getElementById(ht).value = d;
    document.getElementById(hnp).value = e;
    document.getElementById(th).value = f;
    document.getElementById(nota).value = g;
    guardarCursos(a,b,c,d,e,f,g,idPedido);
}
function guardarCursos(ciclo, curso, cr, ht, hnp, th, nota,idvalidacion,idCursoV)
{
    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlValidacionD?opc=guardarCursos&ciclo=" + ciclo + "&curso=" + curso + "&cr="+cr+"&ht="+ht+"&hnp="+hnp+"&th="+th+"&nota="+nota+"&idvalidacion="+idvalidacion+"&idcursov="+idCursoV+"",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        //data: "id=" + id,
        beforeSend: iniE,
        success: llega,
        timeout: 4000,
        error: errores
    });
}
function iniE(){
    
}
function llega(){
    
}
function errores(){
    
}

