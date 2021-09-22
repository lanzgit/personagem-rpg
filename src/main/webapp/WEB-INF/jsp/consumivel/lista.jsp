<!-- <%@page import="br.edu.infnet.model.domain.Arma"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
<!doctype html>
<html lang="pt-BR">

<head>
	<title>Consumível</title>
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
			<h1 class="fw-bolder">Consumível</h1>
			<form action="/consumivel" method="get">
				<button type="submit" class="btn btn-dark">Criar</button>
			</form>
		</div>
	</header>

	<main role="main" class="container">
		<div class="my-3 p-3 bg-white rounded shadow-lg">
			<c:if test="${not empty lista}">
				<c:if test="${not empty msg}">
					<div class="alert alert-success">
						<strong></strong> ${msg}
					</div>
				</c:if>
				<h5 class="border-bottom border-dark pb-2 mb-0">Lista de Armas</h5>
				<table class="table table-hover table-sm">
					<thead class="thead-dark">
						<tr>
							<th scope="col">id</th>
							<th scope="col">Nome</th>
							<th scope="col">Nivel</th>
							<th scope="col">Peso</th>
							<th scope="col">Qnt. de Usos</th>
							<th scope="col">Status</th>
							<th scope="col">Efeito</th>
							<th scope="col">Acoes</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${lista}">
							<tr>
								<td scope="row">${a.id}</td>
								<td scope="row">${a.nome}</td>
								<td scope="row">${a.nivel}</td>
								<td scope="row">${a.peso}</td>
								<td scope="row">${a.qntUso}</td>
								<td scope="row">${a.status}</td>
								<td scope="row">
									<c:if test="${a.efeito}">
										<span class="fas fa-plus-circle"> positivo</span>
									</c:if>
									<c:if test="${!a.efeito}">
										<span class="fas fa-skull-crossbones"> negativo</span>
									</c:if>
								</td>

								<td><a href="/arma/${a.id}/excluir"><span class="fas fa-trash-alt"></span> Excluir</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
		</div>
	</main>
</body>

</html>