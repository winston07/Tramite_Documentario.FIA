/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function enviardatos(idCursoV, a, b, c, d, e, f, g, ciclo, nombre, cr, ht, hnp, th, nota) {
    document.getElementById(ciclo).value = a;
    document.getElementById(nombre).value = b;
    document.getElementById(cr).value = c;
    document.getElementById(ht).value = d;
    document.getElementById(hnp).value = e;
    document.getElementById(th).value = f;
    document.getElementById(nota).value = g;
    //alert(idCursoV);

    guardarCursos(a, b, c, d, e, f, g, idCursoV);
}
function guardarCursos(ciclo, curso, cr, ht, hnp, th, nota, idCursoV)
{
    /*
    //alert(ciclo+curso+cr+ht+hnp+th+nota+idCursoV);
    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlValidacionD?opc=guardarCursos&ciclo=" + ciclo + "&curso=" + curso + "&cr=" + cr + "&ht=" + ht + "&hnp=" + hnp + "&th=" + th + "&nota=" + nota + "&idcursov=" + idCursoV + "",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        //data: "id=" + id,
        beforeSend: iniE,
        success: llega,
        timeout: 4000,
        error: errores
    });*/
    guardarIndividual('CUR_CICLO',idCursoV,ciclo);
    guardarIndividual('CUR_NOMBRE',idCursoV,curso);
    guardarIndividual('CUR_CR',idCursoV,cr);
    guardarIndividual('CUR_HT',idCursoV,ht);
    guardarIndividual('CUR_HNP',idCursoV,hnp);
    guardarIndividual('CUR_TH',idCursoV,th);
    guardarIndividual('CUR_NOTA',idCursoV,nota);
}
function iniE() {

}
function llega(datos) {

}
function errores() {

}
function guardarIndividual(columna, idCurso, valor)
{
    $.ajax({
        async: true,
        type: "POST",
        dataType: "html",
        contentType: "text/html",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
        //url: "../ControlSolicitante?opc=s&id=" + id,
        url: "../ControlValidacionD?opc=guardarIndividual&columna=" + columna + "&idcurso=" + idCurso + "&valor=" + valor + "",
        // data: "id=" + id & "curso=" + curso & "cr=" + cr & "ht=" + ht & "hnp=" + hnp & "th=" + th & "nota=" + nota & "opc=" + "ajax",
        //data: "id=" + id,
        beforeSend: iniEIndividual,
        success: llegaIndividual,
        timeout: 4000,
        error: erroresIndividual
    });
}
function iniEIndividual() {
    $("#pr").css("background-color", "yelow");
    $("#pr").css("color", "#fff");
    $("#pr").text('Guardando...');
}
function llegaIndividual(e) {
    if (e !== "") {
        $("#pr").css("background-color", "green");
        $("#pr").css("color", "#fff");
        $("#pr").text(e);

    } else {
        $("#pr").css("background-color", "red");
        $("#pr").css("color", "#fff");
        $("#pr").text("Hubo un Error con los Datos de Entrada");

    }
}
function erroresIndividual() {
    $("#pr").css("background-color", "red");
    $("#pr").css("color", "#fff");
    $("#pr").text("Hubo un Error con el Servidor");
}

