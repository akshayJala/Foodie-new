<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%-- <meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" /> --%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset='utf-8' />
<title>Foodie</title>



<meta name="viewport" content=content= "width=device-width,
	initial-scale=1">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

<link href="<c:url value="/css/MyStyleSheet.css" />" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.navbar {
      padding-top: 15px;
      padding-bottom: 15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 18px;
	  font-family: josefin slab;
      letter-spacing: 5px;
	  background-color: orange;
	  color: white;
	  opacity: 0.9;
	  alpha: filter (opacity=40);
  }
  .navbar li a, .navbar .navbar-brand { 
      color: white !important;
  }
  .navbar-brand{
  font-size: 40px;
  }
  .navbar-nav  li a:hover {
      color: teal !important;
	  font-size: 18px;
  }
</style>
</head>
<body data-spy="scroll" data-target="#my-navbar">
	<!--navbar-->
	<nav class="navbar navbar-fixed-top" id="my-navbar">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-collapse">
				<!--navbar toggle button start-->
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<!--navbar toggle button ends-->
			<b><a href="<c:url value="/index"/>" class="navbar-brand">Foodie</a></b>
		</div>
		<!--navbar header ends-->
		<div class="collapse nav nav-collapse navbar-collapse"
			id="navbar-collapse">

			<ul class="nav navbar-nav navbar-right">

				<c:if test="${empty pageContext.request.userPrincipal}">

					<li><a href="ContactUs"><span
							class="glyphicon glyphicon-earphone"></span> Contact Us</a></li>
					<li><a href="addUser"><span
							class="glyphicon glyphicon-user" id="signupbutton"></span> Sign
							Up</a></li>
					<li><a href="login"><span
							class="glyphicon glyphicon-log-in" id="loginbutton"></span> Login</a></li>
				</c:if>

				<c:if test="${not empty pageContext.request.userPrincipal}">

					<li><a href="ContactUs"><span
							class="glyphicon glyphicon-earphone"></span> Contact Us</a></li>

					<!--<c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">-->

						<li><a style="color: white" href="viewCartItems" id="cart"> <span
								class="glyphicon glyphicon-shopping-cart"></span>Cart<span
								class="badge">${cartItemSize}</span></a></li>

					</c:if>


					<li class="dropdown dropdown clearfix"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							${user}<b class="caret"></b>
							<li class="dropdown dropdown clearfix"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							${admin}<b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="logout">Logout</a></li>

						</ul></li>
						</a></li>
						
				</c:if>
			</ul>

			<ul style="font-size: 1.3vw" class="nav navbar-nav">
				<li><a href="/foodiespot">Home</a>
				<li><a href="/foodiespot">About Us</a>
			</ul>
		</div>
		<!--navbar collapse items ends-->
	</div>
	<!--end container--> </nav>
	<!--navbar end-->


	<div class="jumbotron" id="home">
		<!--Jumbotron starts from here-->
		<div class="container text-center" id="home-container">
			
				
					<h1>Order Online!</h1>
	<p>We have the best chefs around India to make 
	your tummy full with fresh and delicious food!</p>
	<a href="#About" class="btn btn-lg btn-info">More info</a>
					<c:if test="${ empty pageContext.request.userPrincipal}">
					</c:if>
					<c:if test="${not empty pageContext.request.userPrincipal}">
						<!--<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">-->
							<c:choose>
								<c:when test="${isProductClicked == true}">
									<div class="btn-group" id="selector">
										<button id="b1" onclick="location.href='addCategory'"
											class="btn btn-primary ">Categories</button>
										<button id="b2" onclick="location.href='admin/addProduct'"
											class="btn btn-primary active">Products</button>
										<button id="b3" onclick="location.href='addSupplier'"
											class="btn btn-primary ">Suppliers</button>
									</div>
								</c:when>
								<c:when test="${isSupplierClicked == true}">
									<div class="btn-group" id="selector">
										<button id="b1" onclick="location.href='addCategory'"
											class="btn btn-primary ">Categories</button>
										<button id="b2" onclick="location.href='addProduct'"
											class="btn btn-primary ">Products</button>
										<button id="b3" onclick="location.href='admin/addSupplier'"
											class="btn btn-primary active">Suppliers</button>
									</div>
								</c:when>
								<c:when test="${isCategoryClicked == true}">
									<div class="btn-group" id="selector">
										<button id="b1" onclick="location.href='admin/addCategory'"
											class="btn btn-primary active">Categories</button>
										<button id="b2" onclick="location.href='addProduct'"
											class="btn btn-primary ">Products</button>
										<button id="b3" onclick="location.href='addSupplier'"
											class="btn btn-primary ">Suppliers</button>
									</div>
								</c:when>
							</c:choose>
						</c:if>

						<!--<c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">-->
							
						</c:if>

					</c:if>

				</div>
			</div>
		</div>
		<!--container ends-->
	</div>
	<!--jumbotron ends -->