$(document).ready(function(){


$(".deshabilita").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'Deshabilitar',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});

$(".habilitaAlumno").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'habilitarAl',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});

$(".elimina").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'Eliminar',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});





$(".deshabilitaEV").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'DeshabilitarEV',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});

$(".habilitaEV").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'habilitarEV',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});

$(".eliminaEV").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'EliminarEV',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});



$(".eliminaEvado").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'EliminarEdo',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});


$(".deshabilitaDDC").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'desDDC',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});


$(".habilitaDDC").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'habDDC',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});

$(".eliminaDDC").click(function(){

		$(this).parent('td').parent('tr').remove();
	
		$.post('ejecuta.php',{
			Caso:'elimDDC',
			Id:$(this).attr('data-id')
		},function(e){
			alert(e);
		});
	});

});