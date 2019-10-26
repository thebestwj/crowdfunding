$(function () {
    $("#rightBtn").click(function(){
        $("#leftSelect>option:selected").appendTo("#rightSelect");
    });
    $("#leftBtn").click(function(){
        $("#rightSelect>option:selected").appendTo("#leftSelect");
    });


    $("#submitBtn").click(function(){

        $("#rightSelect>option").prop("selected","selected");

    });


})