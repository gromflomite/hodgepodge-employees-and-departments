<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>

<html lang="en">

<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>UF2176 - Exercice 2</title>
<!-- Datatables plugin -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<!-- CSS normalize (https://necolas.github.io/normalize.css/) -->
<link rel="stylesheet" href="./css/normalize.css">
<!-- Bootstrap -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Google fonts -->
<link href="https://fonts.googleapis.com/css2?family=Spartan&display=swap" rel="stylesheet">
<!-- Own CSS -->
<link rel="stylesheet" href="css/style.css">

</head>

<body>

	<main class="container">

		<h1 class="my-5">UF2176 - Exercice 2</h1>

		<h2 class="my-5">Employees table list</h2>

		<table id="table" class="tabla table table-striped">

			<thead>

				<tr>
					<td>Employee ID</td>
					<td>Name</td>
					<td>First surname</td>
					<td>Second surname</td>
					<td>N.I.F.</td>
					<td>
						Department (
						<span class="badge badge-success budget-badges">Budget</span>
						<span class="badge badge-warning budget-badges">Expenses</span>
						<span class="badge badge-danger budget-badges">Overbudget</span>
						)
					</td>					
				</tr>

			</thead>

			<tbody>

				<c:forEach items="${dbRegisters}" var="dbe">
					<tr>
						<td>${dbe.idEmployee}</td>
						<td>${dbe.nameEmployee}</td>
						<td>${dbe.firstSurnameEmployee}</td>
						<td>${dbe.secondSurnameEmployee}</td>
						<td>${dbe.nif}</td>
						<td>
							${dbe.department.departmentName}

							<div class="budget-badges float-right">								
								<span class="badge badge-success budget-badges">${dbe.department.departmentBudget}</span>								
								<span class="badge badge-${(dbe.department.departmentExpenses > dbe.department.departmentBudget) ? 'danger' : 'warning'} budget-badges">${dbe.department.departmentExpenses}</span>
							</div>

						</td>
					</tr>
				</c:forEach>

			</tbody>

		</table>
		
		<h2 class="my-5">Create new employee</h2>
		
		<form id="new-employee" action="newemployee" method="post">
		
		<div class="form-group">
			<label for="nameEmployee">Name: </label>
			<input type="text" name="nameEmployee" class="form-control" id="nameEmployee" placeholder="Employee name" required>
		</div>
		
		<div class="form-group">
			<label for="firstSurnameEmployee">First surname: </label>
			<input type="text" name="firstSurnameEmployee" class="form-control" id="firstSurnameEmployee" placeholder="Employee first surname" required>			
		</div>
		
		<div class="form-group">
			<label for="secondSurnameEmployee">Second surname: </label>
			<input type="text" name="secondSurnameEmployee" class="form-control" id="secondSurnameEmployee" placeholder="Employee second surname" required>						
		</div>
		
		<div class="form-group">
			<label for="nifEmployee">Tax identification number: </label>
			<input type="text" name="nifEmployee" class="form-control" id="nifEmployee" placeholder="Employee N.I.F." required>			
		</div>
		
		<div class="form-group">
			<label for="departmentEmployee">Department: </label>
			<select class="form-control" name="departmentEmployee" id="departmentEmployee">				
				<option selected>Choose...</option>
				<option value="1">Education</option>
				<option value="2">Computing systems</option>
				<option value="3">Hosting</option>
				<option value="4">Research and development</option>
				<option value="5">Advertising</option>
				<option value="0">No department</option>												
			</select>
		</div>
		
		<button type="submit" class="btn btn-warning">Create employee</button>	

	</form>
		

		<h2 class="my-5">Raw complete list</h2>

		<ol>
			<c:forEach items="${dbRegisters}" var="db">
				<li>${db}</li>
			</c:forEach>
		</ol>

	</main>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<!-- Datatables plug in -->
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
	<!-- Own custom JS's (includes Datatables function) -->
	<script src="js/custom.js"></script>

</body>

</html>