<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">RPG</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#"> Home </a>
      </li>
      <c:if test="${not empty user}">
      <li class="nav-item">
        <a class="nav-link" href="/usuario/lista"> Usuarios </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/personagem/lista"> Personagem </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Equipamento
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="/arma/lista">Arma</a>
          <a class="dropdown-item" href="#">Armadura</a>
          <a class="dropdown-item" href="#">Consumivel</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Todos</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user}">
	      <li><a class="nav-link" href="/usuario"><span class="fas fa-user"></span> Sign Up</a></li>
	      <li><a class="nav-link" href="/login"><span class="fas fa-sign-in-alt"></span> Login</a></li>
      </c:if>
      <c:if test="${not empty user}">
      	  <li><a href="/logout"><span class="fas fa-sign-out-alt"></span> Logout, ${user.nome}</a></li>
      </c:if>
    </ul>
  </div>
</nav>