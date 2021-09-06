<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="pt-BR">

<head>
	<title>Criaçao de Personagem</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
		integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>
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

	<div class="container-fluid" style="width: 75%;">
	<h3>Criação de Personagem</h3>
	<form action="/personagem/incluir" method="POST">
		<div class="form-row">
			<div class="form-group col-md-6">
				<label>Nome</label>
				<input type="text" class="form-control" name="nome" placeholder="Nome">
			</div>
			<div class="form-group col-md-6">
				<label>Raça</label>
				<select class="form-control" name="raca">
					<option selected="selected">Humano</option>
					<option>Orc</option>
					<option>Elfo</option>
					<option>Anão</option>
				</select>
			</div>
		</div>
		<div class="form-row">
			<div class="form-group col-md-6">
				<label>Classe</label>
				<input type="text" class="form-control" name="classe" placeholder="Classe">
			</div>
			<div class="form-group col-md-6">
				<label>Equipe</label>
				<input type="text" class="form-control" name="equipe" placeholder="Equipe" disabled>
			</div>
		</div>
		<div class="container-fluid">
			<button class="btn btn-primary" type="submit">Salvar</button>
		</div>
	</form>
	</div>
</body>

</html>