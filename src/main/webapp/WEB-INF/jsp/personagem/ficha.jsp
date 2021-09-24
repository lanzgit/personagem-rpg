<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="pt-BR">

<head>
	<title>Ficha do Personagem</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
			<h1 class="fw-bolder">Ficha do Personagem</h1>
		</div>
	</header>

	<main role="main" class="container">
		<div class="row my-3 p-3 rounded shadow-lg">
			<div class="col-md">
				<h2>Caracteristicas</h2>
				<p><strong>Nome: </strong>${personagem.nome}</p>
				<p><strong>Criacao: </strong>${personagem.dataCriacaoWeb}</p>
				<p><strong>Raca: </strong>${personagem.raca}</p>
				<p><strong>Classe: </strong>${personagem.classe}</p>
			</div>
			<div class="col-md"></div>
			<div class="col-md">
				<h2>Equipe</h2>
				<p><strong>Nome: </strong>${personagem.equipe.nome}</p>
				<p><strong>Descricao: </strong>${personagem.equipe.descricao}</p>
				<p><strong>Fundacao: </strong>${personagem.equipe.dataFundacaoWeb}</p>
			</div>
		</div>
		<div class="my-3 p-3 rounded shadow-lg bg-white">
			<form action="" method="">
				<h2>Equipamentos</h2>
				<table class="table table-hover table-sm">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Nivel</th>
							<th>Peso</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${meusEquipamentos}">
							<tr>
								<td scope="row">${e.nome}</td>
								<td>${e.nivel}</td>
								<td>${e.peso}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<button type="submit" class="btn btn-dark">Alterar</button>
			</form>
		</div>
	</main>

</body>

</html>