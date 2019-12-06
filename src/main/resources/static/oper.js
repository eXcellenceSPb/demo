$(document).ready(function () {
    $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#myTable2 tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });

    $(".edit").click(function () {
        $("#mid").val($(this).closest("tr").find('.mid').text());
        $("#mname").val($(this).closest("tr").find(".mname").text());
    });
});