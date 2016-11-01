<%@ include file="Common-Header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<h3 style="color: green">Update Your Items</h3>
					<form method="post" commandName="Product" action="199">
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<label for="name" class="control-label">Give your
										Item Id</label> <input type="text" class="form-control"
										name="productId" placeholder="Enter Product ID">
								</div>

								<div class="form-group">
									<label for="name" class="control-label">Item Name</label> <input
										type="text" class="form-control" name="productName"
										placeholder="Enter New Name">
								</div>

								<div class="form-group">
									<label for="name" class="control-label">Item
										Category</label> <select class="form-control" name="productCategory">
										<option>Electronics</option>
										<option>Men's Wearing</option>
										<option>Girl's Wearing</option>
										<option>Furniture</option>
										<option>Other</option>
									</select>

								</div>

								<div class="form-group">
									<label for="name" class="control-label">Quantity</label> <select
										class="form-control" name="quantity">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
									</select>
								</div>

								<div class="form-group">
									<label for="name" class="control-label">Price</label> <input
										type="text" class="form-control" name="price"
										placeholder="Enter New Price">
								</div>
							</div>

						</div>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Update</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	</body>
	</html>