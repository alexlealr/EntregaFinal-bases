
$(document).ready(inicio)
function inicio(){

	$(".menu").click(anade)
	//$(".content").load("verProducto.php");
}
function anade(){
	$("#content").load("listas.php?id="+$(this).val());
	//$("#content").append($(this).val());
}
