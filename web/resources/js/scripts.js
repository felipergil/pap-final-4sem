$(document).ready( function(){
   $("#item-1").click( function(){
       var img = $("#img-item-1").prop("src");
       var destino = $("#item-display").prop("src");
       
       $('#img-item-1').attr("src",destino);
       $('#item-display').attr("src",img);
       
   }); 
   
   $("#item-2").click( function(){
       var img = $("#img-item-2").prop("src");
       var destino = $("#item-display").prop("src");
       
       $('#img-item-2').attr("src",destino);
       $('#item-display').attr("src",img);
   });
   
   $("#item-3").click( function(){
       var img = $("#img-item-3").prop("src");
       var destino = $("#item-display").prop("src");
       
       $('#img-item-3').attr("src",destino);
       $('#item-display').attr("src",img);
   });
   
});
