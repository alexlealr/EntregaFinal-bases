          function requerir(){
            try {

                req = new XMLHttpRequest();
                
            } catch (err1) {
                try {

                    req = new ActiveXObject("Microsoft.XMLHTTP");
                    
                } catch (err2) {
                    try {

                        req = new ActiveXObject("Msxml2.XMLHTTP");
                        
                    } catch (err3) {
                        req = false;
                    }
                    
                }
                
            }

            return req;
        }
/************************************************************

es para que se actibe el listbox y se muestre el personal que se encuestra en la hola personal.php*/
        var peticion = requerir();

        function llamarAjaxGETper(){
            var aleatorio = parseInt(Math.random()* 9999999999);
            valor= document.getElementById("periodo").value;
            var url="materias.php?valor="+valor+"&r="+aleatorio;
            peticion.open("GET",url,true);
            peticion.onreadystatechange=respuestaAjarper;
            peticion.setRequestHeader('Content-type','application/x-www-form-urlencoded');
            peticion.send(null);
        }

        function respuestaAjarper(){
        if(peticion.readyState == 4){
            if(peticion.status == 200){
                document.getElementById("per").innerHTML = peticion.responseText;
            }else{
                alert("ha ocurrido un herror"+peticion.statusText);
            }
        }
    }