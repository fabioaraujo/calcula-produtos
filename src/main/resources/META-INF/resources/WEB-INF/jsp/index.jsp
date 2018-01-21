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
	    
	    var atualizaHora = function(){
	    	$.ajax({
	    	    type: 'POST',
	    	    url: 'http://localhost:8080/hora/atualizar',
	    	    data: '{"id" : 0, "custo": ' + $("#horaTrabalhada").val() + '}', // or JSON.stringify ({name: 'jonas'}),
	    	    success: function(data) { 
	    	    	console.log(data);
		    		  if(data){
		    			  $("#horaTrabalhada").val(data.custo);
		    		  }
	    	    },
	    	    contentType: "application/json",
	    	    dataType: 'json'
	    	});
	    	
	    };
    </script>
    </head>
    <body>
        <h1>Cálcula Produtos</h1>
       	<div>
       		<span><label for="horaTrabalhada">Valor da hora Trabalhada:</label></span>
       		<input type="text" name="horaTrabalhada" id="horaTrabalhada">
       	</div>
       	<div>
       		<input type="button" value="Atualizar custo hora" onclick="atualizaHora()" />
       	</div>
    </body>
</html>