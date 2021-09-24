<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="pt-BR">

<head>
	<title>Criaçao de Equipamento</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
		integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body class="bg-light">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<c:import url="/WEB-INF/resources/templates/menu.jsp" />

	<header class="bg-primary bg-gradient text-white" style="padding-top: 5rem; padding-bottom: 6rem;">
		<div class="container px-4 text-center">
			<h1 class="fw-bolder">Criação de Equipamento</h1>
			<h5 class="fw-bolder">Arma</h5>
		</div>
	</header>

	<main role="main" class="container">
		<div class="my-3 p-3 bg-white rounded shadow-lg">
			<h5 class="border-bottom border-dark pb-2 mb-0">Dados da Arma</h5><br>
			<form action="/arma/incluir" method="POST">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label>Nome</label>
						<input type="text" class="form-control" name="nome" placeholder="Nome" value="BatEspada">
					</div>
					<div class="form-group col-md-6">
						<label>Tipo</label>
						<select class="form-control" name="tipo">
							<option selected="selected">Espada</option>
							<option>Machado</option>
							<option>Cajado</option>
							<option>Faca</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label>Nivel</label>
						<select class="form-control" name="nivel">
							<option selected="selected">1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label>Material</label>
						<input type="text" class="form-control" name="material" placeholder="tipo de material" value="nobre">
					</div>
					<div class="form-group col-md-6">
						<label>Peso</label>
						<input type="text" class="form-control" name="peso" placeholder="peso em kg" value="1">
					</div>
				</div>
				<button class="btn btn-primary" type="submit">Salvar</button>
			</form>
		</div>
	</main>
</body>

</html>