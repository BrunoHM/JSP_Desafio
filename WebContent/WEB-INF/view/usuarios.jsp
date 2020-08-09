<%@page import="org.apache.catalina.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="../includes/header.html" />
		<%@ page isELIgnored="false" %>
	</head>
		<div class="row">
			<jsp:include page="../includes/menu.jsp" />
		</div>
	<body>
		<div class="row divCli">
			<div class="col-12">
				<div class="text-center bg-secondary text-white">
					<form action="usuario" method="post">
						<div class="form-group cadCli">
							<div class="row col-12">
							   <label class="col-1 pt-2" for="nome">Nome: </label>
							   <input class="form-control col-3 ml-3 mr-3" id="nome" placeholder="Insira seu nome">
							   
							   <label class="col-1 pt-2" for="sobrenome">Sobrenome: </label>
							   <input class="form-control col-3 ml-3 mr-3" id="sobrenome" placeholder="Insira seu Sobrenome">
							   
							   <label class="col-1 pt-2" for="cpf">Cpf: </label>
							   <input class="form-control col-2 ml-3 mr-3" id="cpf" placeholder="Insira seu cpf">
						   </div>
						   <div class="row col-12 p-0">
							   <div class="col-4 divTel p-0 ml-3 d-inline-flex">
								   <label class="col-3 p-0 pt-2 ml-1" for="telefone">Telefone: </label>
								   <input class="form-control col-6 ml-2" name="telefone" id="telefone" placeholder="Insira seu telefone">
							   </div>
							   <div class="col-5 divEmail p-0 d-inline-flex">
								   <label class="col-3 p-0 pt-2" for="email">E-mail: </label>
								   <input class="form-control col-5 ml-2" name="email" id="email" placeholder="Insira seu e-mail">
							   </div>
							   <div class="col-4"></div>
						  </div>

						   <div class="row col-11 offset-1">
						   	<button class="btn btn-primary" name="addTel" type="button">Adicionar outro telefone</button>
						   </div>
						 </div>
						 
						<button name="insUsuario" type="submit">Concluir</button>
						<label><span class="error">${err}</span></label>
					</form>
				</div>
			</div>
		</div>
		
		<div class="row listClientes mt-3">
			<div class="table-responsive">
				<% 
			        if (request.getAttribute("queryResults") != null) {
				%>
				<table class="table table-hover table-dark text-center">
				  <thead>
				    <tr>
				      <th scope="col">Id</th>
				      <th scope="col">Nome</th>
				      <th scope="col">Sobrenome</th>
				      <th scope="col">Cpf</th>
				      <th scope="col">Ativo</th>
				    </tr>
				  </thead>
				  <tbody>
					<c:forEach var="user" items="${queryResults}">
						<tr scope="row">
							<th><span> ${user.id} </span></th>
							<th>
								<span> ${user.nome} </span>
							</th>
							<th>
								<span> ${user.sobrenome} </span>
							</th>
							<th>
								<span> ${user.cpf} </span>
							</th>
							<th>
								<span> ${user.ativo} </span>
							</th>
							<th>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
		  							<path fill-rule="evenodd" d="M11.293 1.293a1 1 0 0 1 1.414 0l2 2a1 1 0 0 1 0 1.414l-9 9a1 1 0 0 1-.39.242l-3 1a1 1 0 0 1-1.266-1.265l1-3a1 1 0 0 1 .242-.391l9-9zM12 2l2 2-9 9-3 1 1-3 9-9z" />
		  							<path fill-rule="evenodd" d="M12.146 6.354l-2.5-2.5.708-.708 2.5 2.5-.707.708zM3 10v.5a.5.5 0 0 0 .5.5H4v.5a.5.5 0 0 0 .5.5H5v.5a.5.5 0 0 0 .5.5H6v-1.5a.5.5 0 0 0-.5-.5H5v-.5a.5.5 0 0 0-.5-.5H3z" />
								</svg>
							</th>
							<th>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
								<path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z" />
								<path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z" />
								</svg>
							</th>
						</tr>
					</c:forEach>
					</tbody>
				</table>

					<% 
			        } else { 
			    %>
					    <h1>No student record found.</h1>
			         
			    <% } %>
			</div>
		</div>
	</body>
</html>