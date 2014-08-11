
            function enviar()
            {

                var id = $("#cod").val();

                $.ajax({
                    async: true,
                    type: "POST",
                    dataType: "html",
                    contentType: "text/html",
                    //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
                    //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
                    //url: "../ControlSolicitante?opc=s&id=" + id,
                    url: "../ControlSolicitante?opc=s&&id="+id+"",
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
                 x.html('<img src="../img/loading.gif"  class="btn-circle"/>');
            }
            function llegada(datos)
            {
                $("#resultados").html(datos);
            }
            function problemas()
            {
                $("#resultados").text('Problemas en el servidor.');
            }
       

