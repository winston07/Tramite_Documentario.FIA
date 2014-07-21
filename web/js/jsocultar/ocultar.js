$(document).ready(function() {
    $("#mos").click(function() {
        $("#div").show("slow");
        $("#ocultar").hide("slow");
    });
    $("#ocu").click(function() {
        $("#div").hide("slow")
        $("#ocultar").show("slow");
    });
    $("#mos2").click(function() {
        $("#div").show("slow");
        $("#nomostrar").hide("slow");
        $("#div2").show("slow");

    });
    $("#ocu2").click(function() {
        $("#div").hide("slow");
        $("#nomostrar").show("slow");
    });
    //aqui para el modal
    $('#openBtn').click(function() {
        $('#myModal').modal({show: true})
    });
});
