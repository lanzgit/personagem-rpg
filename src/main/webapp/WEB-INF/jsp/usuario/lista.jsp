<!-- <%@page import="br.edu.infnet.model.domain.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Usuarios</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
		integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<body class="bg-light">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<c:import url="/WEB-INF/resources/templates/menu.jsp" />

	<header class="bg-primary bg-gradient text-white" style="padding-top: 5rem; padding-bottom: 6rem;">
		<div class="container px-4 text-center">
			<h1 class="fw-bolder">Usuarios</h1>
			<h6>Quantidade de usuarios existentes: ${lista.size()}</h6>
		</div>
	</header>

	<main role="main" class="container">
		<div class="my-3 p-3 bg-white rounded shadow-lg">
			<h5 class="border-bottom border-dark pb-2 mb-0">Lista de Personagens</h5>
			<c:if test="${not empty lista}">
				<c:if test="${not empty msg}">
					<div class="alert alert-success">
						<strong>Sucesso!</strong> ${msg}
					</div>
				</c:if>
				<table class="table table-hover table-sm">
					<thead class="thead-dark">
						<tr>
							<th>Id</th>
							<th>Nome</th>
							<th>E-mail</th>
							<th>Personagens</th>
							<c:if test="${user.admin}">
								<th>Acoes</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${lista}">
							<tr>
								<td>${u.id}</td>
								<td>${u.nome}</td>
								<td>${u.email}</td>
								<td>${u.personagens.size()}</td>
								<c:if test="${user.admin}">
									<td>
										<c:choose>
											<c:when test="${user.id != u.id}">
												<a href="/usuario/${u.id}/excluir"><span
														class="fas fa-trash-alt"></span> Excluir</a>
											</c:when>
										</c:choose>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>

			<c:if test="${empty lista}">
				<h4>Nao existem usuarios cadastrados!!!</h4>
			</c:if>
		</div>
	</main>
</body>

</html>