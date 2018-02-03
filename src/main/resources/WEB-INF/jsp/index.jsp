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
	    	
	    	carregaTabelaItens();
	    });
	    
	    var carregaTabelaItens = function(){
	    	$("#itens tbody").empty();
	    	$.get( "http://localhost:8080/item/listar", function( data ) {
	    		  console.log(data);
	    		  for(idx in data){
	    			  $("#itens tbody").append("<tr><td>" + data[idx].id + "</td><td>" + data[idx].nome + "</td><td>" + data[idx].tipoUnidade + "</td><td>" + data[idx].custo + 
	    					  "</td><td><a href='#' onclick='editarItem(" + data[idx].id + ")'>Editar</a></td></tr>");
	    		  }
	    		});
	    }
	    
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
	    
	    var criaItem = function(){
	    	console.log('{"id": ' + $('#formItem').find('input[name="id"]').val() + ', "nome": "' + $('#formItem').find('input[name="nome"]').val() + 
	    	    	'", "tipoUnidade": "' + $('#formItem').find('#tipoUnidadeItem option:selected').val() + '", "custo": ' + $('#formItem').find('input[name="custo"]').val() + '}');
	    	$.ajax({
	    	    type: 'POST',
	    	    url: 'http://localhost:8080/item/criar',
	    	    data: '{"id": ' + $('#formItem').find('input[name="id"]').val() + ', "nome": "' + $('#formItem').find('input[name="nome"]').val() + 
	    	    	'", "tipoUnidade": "' + $('#formItem').find('#tipoUnidadeItem option:selected').val() + '", "custo": ' + $('#formItem').find('input[name="custo"]').val() + '}', // or JSON.stringify ({name: 'jonas'}),
	    	    success: function(data) { 
	    	    	console.log(data);
	    	    	carregaTabelaItens();
	    	    	 limparItem();
	    	    	
	    	    },
	    	    contentType: "application/json",
	    	    dataType: 'json'
	    	});
	    	
	    };
	    
	    var limparItem = function(){
	    	$('#formItem').find("input[type=text], textarea, select").val("");
	    };
	    
	    var editarItem = function(id){
	    	$.get( "http://localhost:8080/item/getById?id=" + id, function( data ) {
		    		  console.log(data);
		    		  $('#formItem').find('input[name="id"]').val(data.id);
		    		  $('#formItem').find('input[name="nome"]').val(data.nome); 
		  	    	  $('#formItem').find('#tipoUnidadeItem').val(data.tipoUnidade);
		  	    	  $('#formItem').find('input[name="custo"]').val(data.custo);
	    		});
	    };
	    
	    function getFormData($form){
	        var unindexed_array = $form.serializeArray();
	        var indexed_array = {};

	        $.map(unindexed_array, function(n, i){
	            indexed_array['"'+n['name']+'"'] = n['value'];
	        });

	        return indexed_array;
	    }
    </script>
    </head>
    <body>
        <h1>C�lcula Produtos</h1>
       	<div>
       		<span><label for="horaTrabalhada">Valor da hora Trabalhada:</label></span>
       		<input type="text" name="horaTrabalhada" id="horaTrabalhada">
       	</div>
       	<div>
       		<input type="button" value="Atualizar custo hora" onclick="atualizaHora()" />
       	</div>
       	<div>
	       	<h2>Itens</h2>
	       	<table id="itens" border="1">
	       		<thead>
	       			<tr>
			       		<th>ID</th>
			       		<th>nome</th>
			       		<th>unidade</th>
			       		<th>custo</th>
			       		<th>Editar</th>
		       		</tr>
	       		</thead>
	       		<tbody>
	       		
	       		</tbody>
	       	</table>
	       	<br /><br />
	       	<div>
	       	<form id="formItem">
	       		<label>Cadastro Item</label><br />
	       		<label>Id Item</label>
	       		<div><input type="text" name="id" id="idItem" /></div>
	       		<label>Nome</label>
	       		<div><input type="text" name="nome" id="nomeItem" /></div>
	       		<label>Tipo Unidade</label>
	       		<div><select name="tipoUnidade" id="tipoUnidadeItem"><option>METRO</option><option>UNIDADE</option> </select></div>
	       		<label>Custo</label>
	       		<div><input type="text" name="custo" id="custoItem" /></div>
	       			<div>
		       		<input type="button" value="Cria Item" onclick="criaItem()" />
		       		<input type="button" value="Limpar Item" onclick="limparItem()" />
		       	</div>
	       	</form>
	       	</div>
       	</div>
    </body>
</html>