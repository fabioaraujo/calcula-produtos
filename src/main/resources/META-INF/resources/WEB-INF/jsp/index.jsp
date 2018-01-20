<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    <script src="http://localhost:8080/js/jquery-3.2.1.js"></script>
    <script>
	    $(document).ready(function(){
	    	$.get( "http://localhost:8080/hora/get", function( data ) {
	    		  console.log(data);
	    		  if(data){
	    			  $("#horaTrabalhada").val(data.custo);
	    		  }
	    		});
	    });
    </script>
    </head>
    <body>
        <h1>Cálcula Produtos</h1>
       	<div>
       		<span><label>Valor da hora Trabalhada</label></span>
       		<input type="text" name="horaTrabalhada" id="horaTrabalhada">
       	</div>
    </body>
</html>