
    $(document).ready(function() {
     $("#add").click(function() {

      
        var intId = $("#buildyourform  div").length + 1; 
        var fieldWrapper = $("<div  class = \"form-group\" class =\"col-md-10 fieldwrapper\" role=\"list\" id=\"field" + intId + "\"/>");
        var fName = $("<input type=\"text\" name = \" pregunta"+intId+"\" class=\"fieldname form-control\" placeholder=\" Preguna\" required />");
        var subWrapper = $("<fieldset id=\"subwrapper"+intId+"\"/>");

        var newButton = $("<button type=\"button\" class=\"new btn btn-success btn-sm\" id=\"new"+intId+"\"><span class=\"glyphicon glyphicon-plus\"></span></button");
        newButton.click(function() {

          
            var Id = $("#subwrapper"+intId+" aside").length + 1;

            var subfield = $("<aside class =\"col-md-12 subfield\" id=\"subfield" + Id + "\"/>");
            var Name = $("<input type=\"text\" name =\"opcion"+Id+""+intId+"\" class=\"opcion form-control\" placeholder=\" Opción\" required />");
            var value = $("<input type=\"number\" name = \"valor"+Id+""+intId+"\" class=\"valor form-control\" placeholder=\" Valor\"  required />");
            
            var removeButton1 = $("<button type=\"button\" class=\"remove btn btn-danger btn-sm\"><span class=\"glyphicon glyphicon-trash\"></span></button");

            removeButton1.click(function() {
                $(this).parent().remove();
            });
            var subdato = $("<input type=\"hidden\" name = \"numero1\" class=\"fieldname form-control\" value=\""+Id+"\" required />");
           // var subdato = $("<input type=\"hidden\" name = \"numero[]\" class=\"fieldname form-control\" value=\""+Id+"\" required />");



            subfield.append(Name);
            subfield.append(value);
            subfield.append(removeButton1);
            subfield.append(subdato);

            $("#subwrapper"+intId).append(subfield);
       
      });
          
          var removeButton = $("<button type=\"button\" id=\"remove\" class=\"remove btn btn-danger btn-sm\"><span class=\"glyphicon glyphicon-trash\"></span></button");
           removeButton.click(function() {
            $(this).parent().remove();
        });

        var dato = $("<input type=\"hidden\" name = \"numero\" class=\"fieldname form-control\" value=\""+intId+"\" required />");

       
        fieldWrapper.append(fName);
        fieldWrapper.append(newButton);
        fieldWrapper.append(removeButton);
        fieldWrapper.append(subWrapper);
        fieldWrapper.append(dato);
      
        $("#buildyourform").append(fieldWrapper);

       


     });


       $(".remove").click(function(){

        //alert("hola");
       $(this).parent().remove();
        
      });

    });