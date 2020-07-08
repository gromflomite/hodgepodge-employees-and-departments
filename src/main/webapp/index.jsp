<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Datatables plugin -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- Own CSS -->
<link rel="stylesheet" href="css/style.css">

<title>UF2176 - Exercice 2</title>

</head>

<body>

	<main class="container">

		<br>

		<h1>UF2176 - Exercice 2 (08-07-2020)</h1>

		<br>

		<h2>Raw list</h2>

		<br>

		<ol>
			<c:forEach items="${dbRegisters}" var="db">
				<li>${db}</li>
			</c:forEach>
		</ol>

		<h2>Table list</h2>

		<br>

		<table id="table" class="tabla table table-striped">

			<thead>

				<tr>
					<td>Employee ID</td>
					<td>Name</td>
					<td>First surname</td>
					<td>Second surname</td>
					<td>Department</td>
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${dbRegisters}" var="dbr">
					<tr>
						<td>${dbr.idEmployee}</td>
						<td>${dbr.nameEmployee}</td>
						<td>${dbr.firstSurnameEmployee}</td>
						<td>${dbr.secondSurnameEmployee}</td>
						<td>${dbr.idDepartmentEmployee}</td>
					</tr>
				</c:forEach>


			</tbody>

		</table>

		<h3 class="todo">TODO: Complete the table including department values - Fix Datatables</h3>

	</main>

	<!-- Datatables plug in -->
	<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

</body>
</html>