<?php 
 require('../conexion.php');
		if($_POST['Caso']=="Veo"){

		$prof = $_POST['Id'];

		$sql =mysqli_query($con,"SELECT p.NOMBRE, m.NOMBRE,hg.HORA, d.NOMBRE_DIA  from horarios_grupos hg inner join personal as p on hg.CVE_PERSONAL = p.CVE_PERSONAL inner join materias as m on hg.CVE_MATERIAS = m.CVE_MATERIAS inner join dias as d on hg.DIA = d.CVE_DIA where hg.CVE_PERSONAL = '".$prof."' and hg.CVE_CAUTRIMESTRES =2");
		//$req = mysql_query($sql)or die ('error en sql'.mysql_error());

		if(mysqli_fetch_row($sql)>0)
		{
			while ($row = mysqli_fetch_array($sql)){
				echo $row['NOMBRE_DIA'].''.$row['HORA'].'<br>';
			}
		}else{
			echo "no existe su horario";
		}


	}
?>