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
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>

<body class="bg-light">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
	<c:import url="/WEB-INF/resources/templates/menu.jsp" />

	<header class="bg-primary bg-gradient text-white" style="padding-top: 5rem; padding-bottom: 6rem;">
		<div class="container px-4 text-center">
			<h1 class="fw-bolder">Criação de Equipamento</h1>
			<h5 class="fw-bolder">Consumível</h5>
		</div>
	</header>

	<main role="main" class="container">
		<div class="my-3 p-3 bg-white rounded shadow-lg">
			<h5 class="border-bottom border-dark pb-2 mb-0">Dados do Item Consumível</h5><br>
			<form action="/consumivel/incluir" method="POST">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label>Nome</label>
						<input type="text" class="form-control" name="nome" placeholder="Nome" value="BatPoção">
					</div>

					<div class="form-group col-md-4">
						<label>Efeito</label>
						<div class="form-check">
							<input type="radio" value="true" class="form-check-input" name="efeito" id="positivo"
								autocomplete="on">
							<label class="form-check-label" for="postivo">Positivo</label>
						</div>
						<div class="form-check">
							<input type="radio" value="false" class="form-check-input" name="efeito" id="negativo">
							<label class="form-check-label" for="negativo">Negativo</label>
						</div>
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
					<div class="form-group col-md-6">
						<label>Status</label>
						<select class="form-control" name="status">
							<option selected="selected">1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
						<p class="text-black-50"><span class="small">* dependendo do efeito o status pode ser positivo ou negativo.</span></p>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label>Quantidade de Usos</label>
						<input type="text" class="form-control" name="qntUso" placeholder="quantidade de usos" value="2">
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