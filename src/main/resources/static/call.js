$(document).ready(function () {
    var count = document.getElementsByTagName("table")
        .item(0)
        .getElementsByTagName('tr').length-1;
    document.getElementById('count').value = 'Записей всего: ' + count;

    $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        $("#myTable2 tr").filter(function () {
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
        });
    });

    $(".edit").click(function () {
        $("#mid").val($(this).closest("tr").find('.mid').text());
        $("#mdir").val($(this).closest("tr").find(".mdir").text());
        $("#mnum").val($(this).closest("tr").find(".mnum").text());
        $("#mabon").val($(this).closest("tr").find(".mabon").text());
        $("#mdate").val($(this).closest("tr").find(".mdate").text());
        $("#mcom").val($(this).closest("tr").find(".mcom").text());
    });
});