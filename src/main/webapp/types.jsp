<%@ page language="java" contentType="text/html; charset=windows-1256"
 pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Liste des types</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
 <div class="card-header">
 Liste des types
 </div>
 <div class="card-body">
 
 <table class="table table-striped">
 <tr>
 <th>ID</th><th>Type</th><th>Date 
Création</th><th>Suppression<th>Edition</th>
 </tr>
 <c:forEach items="${model.types}" var="cat">
 <tr> 
 <td>${cat.idType }</td>
 <td>${cat.nomType }</td>
 <td><fmt:formatDate pattern="dd/MM/yyyy" value="${cat.dateCreation}"
/></td>
 <td><a onclick="return confirm('Etes-vous sûr ?')"
href="supprimerCat?id=${cat.idType }">Supprimer</a></td>
 <td><a href="editerCat?id=${cat.idType }">Edit</a></td>
 </tr>
 </c:forEach> 
 </table>
 </div>
</div>
</div>
</body>
</html>