<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barra de Progress</title>

<style type="text/css">

/* Fundo da barra de progresso */
#myProgress {
width: 100%;
background-color:#fff; 
}

/* cor da barra de progresso */
#myBar{
width: 0.5%;
height: 30px;
background: #24292e;
}
</style>

</head>
<body>
<h1>Exemplo com JavaScript</h1>

<div id="myProgress">
<div id="myBar"></div>

</div>
<br/>
<button onclick="exibirBarra()">Iniciar a barra de Progresso</button>

<script type="text/javascript">

function exibirBarra() {
	
	var elem = document.getElementById("myBar");
	var width = 1;
	var id = setInterval(frame, 10);
	
	function frame () {
		if (width >= 100) {
		
			clearInterval(id);
		} else  {
			
			width ++;
			elem.style.width = width + "%";
		}
	}
}

</script>

</body>
</html>