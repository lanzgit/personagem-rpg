<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">

<head>
	<meta charset="UTF-8">
	<title>Personagem de RPG</title>
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

	<c:if test="${not empty user}">
		<header class="bg-primary bg-gradient text-white" style="padding-top: 5rem; padding-bottom: 6rem;">
			<div class="container px-4 text-center">
				<h1 class="fw-bolder">${user.nome}</h1>
				<h6>${user.email}</h6>
				<h5>Bem vindo!</h5>
			</div>
		</header>
	</c:if>

	<c:if test="${empty user}">
		<header class="bg-primary bg-gradient text-white" style="padding-top: 5rem; padding-bottom: 6rem;">
			<div class="container px-4 text-center">
				<h1 class="fw-bolder">Assessment</h1>
				<h5>Desenvolvimento Web com Java EE</h5>
				<h3>
					<a href="https://github.com/lanzgit/personagem-rpg">
						<button class="btn btn-light"><span class="fab fa-github"></span>
							github
						</button>
					</a>

				</h3>
			</div>
		</header>
	</c:if>

	<main role="main" class="container">
		<div class="my-3 p-3 bg-white rounded shadow-lg">
			<blockquote class="wp-block-quote">
				<p>
				</p>
				<cite>Vinicius Vianna</cite><br>
				<cite>vinicius.vianna@al.infnet.edu.br</cite>
			</blockquote>
		</div>
	</main>
</body>

</html>