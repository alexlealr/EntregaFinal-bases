$(document).ready(function(){
	$(".ver").click(function(){
	$.post('../js/ver.php',{
			Caso:'Veo',
			Id:$(this).attr('data-id')	
		},function(e){
			//alert(e);
			
		})
	});
});