<%@page import="br.edu.infnet.model.domain.Personagem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="pt-BR">
<head>
	<title>Title</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
		integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
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

	<div class="container-fluid" style="width: 80%;">
		<form action="/personagem" method="get">
			<h3>Pensonagens</h3>
			<button type="submit" class="btn btn-dark">Criar</button>
		</form>
	<c:if test="${not empty lista}">
		<c:if test="${not empty msg}">
			<div class="alert alert-success">
				<strong>cadastrado com sucesso</strong> ${msg}
			</div>
		</c:if>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">id</th>
					<th scope="col">Nome</th>
					<th scope="col">Raça</th>
					<th scope="col">Classe</th>
					<th scope="col">Data de Criação</th>
					<th scope="col">Equipe</th>
					<th scope="col">Usuario</th>
					<th scope="col">Acoes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="p" items="${lista}">
					<tr>
						<td scope="row">${p.id}</td>
						<td scope="row">${p.nome}</td>
						<td scope="row">${p.raca}</td>
						<td scope="row">${p.classe}</td>
						<td scope="row">${p.dataCriacaoWeb}</td>
						<td scope="row">${p.equipe}</td>
						<td scope="row">${p.usuario.nome}</td>
						<td><a href="/personagem/${p.id}/excluir"><span class="fas fa-trash-alt"></span> Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	</div>
</body>

</html>