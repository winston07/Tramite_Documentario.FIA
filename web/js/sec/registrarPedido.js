/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function registarPedido()
            {

               
                var cod = $("#cod").val();
                var tiptra=$("#tra").val();

                $.ajax({
                    async: true,
                    type: "POST",
                    dataType: "html",
                    contentType: "text/html",
                    //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
                    //url: "../ControlCurso?opc='ajax'&id="+id+"&curso="+curso+"&cr="cr"&ht="+ht+"&hnp="+hnp+"&th="th"&nota="+nota+"",
                    //url: "../ControlSolicitante?opc=s&id=" + id,
                    url: "../ControlPedido?opc=Guardar&&codigo="+cod+"&&tipotramite="+tiptra+"",
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
                var x = $("#res");
                 x.html('<img src="../img/loading.gif"  class="btn-circle"/>');
            }
            function llegada(datos)
            {
                $("#res").html(datos);
            }
            function problemas()
            {
                $("#res").text('Problemas en el servidor.');
            }


