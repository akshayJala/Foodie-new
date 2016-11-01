<%@ include file="/WEB-INF/views/Common-Header.jsp"%>

<table width="50%" align="center"
	style="margin-top: 3%; box-shadow: 0px 9px 30px #888888;">
	<tr>
		<td><hr />
			<div class="container text-center">
				<div class="row">
					<h3 style="color: #1E90FF">Add Products</h3>
					<br />
					<div class="col-sm-12">
						<div>
							<form:form class="form-inline" method="post" action="addProduct"
								 commandName="Product" enctype="multipart/form-data">
								<table style="width: 100%">
									<tr>
										<td>
											<div class="form-group" style="padding: 20px">
												<form:label for="productId" path="productId">&nbsp;&nbsp;Product Id&nbsp;&nbsp;:</form:label>
												<form:input type="text" class="form-control"
													Style="background-color: #cce6ff;" 
													path="productId" placeholder=" Product Id" />
											</div>
										</td>
										<td><div class="form-group" style="padding: 20px">
												<form:label for="productName" path="productName">Product Name&nbsp;:</form:label>
												<form:input type="text" class="form-control"
													Style="background-color: #cce6ff;" 
													path="productName" placeholder="Enter Product" />
											</div></td>
										<td>
											<div class="form-group" style="padding: 20px">
												<form:label for="quantity" path="quantity">Quantity&nbsp;:</form:label>
												<form:input type="text" class="form-control"
													Style="background-color: #cce6ff;" 
													path="quantity" placeholder="00" />
											</div>
										</td>
									</tr>

									<tr>
										<td><div class="form-group" style="padding: 20px">
												<form:label for="category" path="category"> &nbsp;&nbsp;Category &nbsp;&nbsp;: </form:label>
												<form:select class="form-control"
													Style="background-color: #cce6ff;" 
													path="category">
													<form:option value="NONE" 
														label=" Select" />
													<form:options path="category" items="${categorylist}" />
												</form:select>
											</div></td>
										<td><div class="form-group" style="padding: 20px">
												<form:label for="supplier" path="supplier"> Supplier Name&nbsp;: </form:label>
												<form:select class="form-control"
													Style="background-color: #cce6ff;" 
													path="supplier">
													<form:option value="Select"/>
													<form:options path="supplier" items="${supplierlist}"></form:options>

												</form:select>
											</div></td>
										<td><div class="form-group" style="padding: 20px">
												<form:label for="price" path="price">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Price&nbsp;: </form:label>
												<form:input type="text" class="form-control"
													Style="background-color: #cce6ff;" 
													placeholder="Enter Price" path="price" />
											</div></td>
									</tr>
									<tr>
										<td><div class="form-group" style="padding: 20px">
												<form:label for="description" path="description">Description&nbsp;: </form:label>
												<form:input type="text" class="form-control"
													Style="background-color: #cce6ff;" 
													placeholder="description" path="description" />
											</div></td>
										<td>

											 <div class="form-group" style="padding: 20px">
												<label for="image"> </label>
												<input type="file" class="form-control"
													Style="background-color: #cce6ff;" name="image"/>
											</div> 

										</td>
									</tr>


								</table>
								<form:button type="submit" class="btn btn-primary">Submit</form:button>

								<hr>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div style="text-align: center;">
					<h3 style="color: #1E90FF">Your Products
						&nbsp;&nbsp;&nbsp;&nbsp;</h3>
				</div>
				<table class="table table-striped" align="center">
					<thead>
						<tr>
							<th>Product Id</th>
							<th>Product Name</th>
							<th>Supplier</th>
							<th>Category</th>
							<th>Quantity</th>
							<th>Price</th>

							<th>Delete</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ProductList}" var="product">
							<tr>

								<td>${product.productId}</td>
								<td>${product.productName}</td>
								<td>${product.supplier.supplierName }</td>
								<td>${product.category.categoryName}</td>
								<td>${product.quantity}</td>
								<td>${product.price}</td>
								<td><a href="delete/${product.productId}"
									value="${product.productId}" style="color: red">Delete</a></td>
								<td><button type="button" class="btn btn-primary btn-xs"
										data-toggle="modal" data-target="#${product.productId}"
										style="padding: 5px;">Edit</button></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>


			</div></td>
	</tr>
</table>
<c:forEach items="${ProductList}" var="product">
	<div class="modal fade" id="${product.productId}" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<h3 style="color: green">Update Your Products</h3>
					<form method="post" action="edit/${product.productId}">
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<label for="name" class="control-label">Provide the
										Product Id</label> <input type="text" class="form-control"
										value="${product.productId}" name="productId"
										placeholder="${product.productId}" readonly="true">
								</div>

								<div class="form-group">
									<label for="name" class="control-label">Product Name</label> <input
										type="text" class="form-control" name="productName"
										value="${product.productName}" placeholder="Enter New Name">
								</div>


								<div class="form-group">
									<label for="name" class="control-label">Quantity</label> <input
										type="text" class="form-control" name="quantity"
										value="${product.quantity}">

								</div>

								<div class="form-group">
									<label for="name" class="control-label">Price</label> <input
										type="text" class="form-control" name="price"
										value="${product.price}" placeholder="Enter New Price">
								</div>
								
								<div class="form-group">
									<label for="description" class="control-label">Description</label> <input
										type="text" class="form-control" name="description"
										value="${product.description}" placeholder="New Description">
								</div>
								
								<div class="form-group">
									 <label for="supplier" class="control-label">Supplier</label>  <input
										type="text" class="form-control" name="supplier"
										value="${product.supplier}" placeholder="Enter Supplier" readonly="true">
								</div>
								
								<div class="form-group">
									 <label for="category" class="control-label">Category</label>  <input
										type="text" class="form-control" name="category"
										value="${product.category}" placeholder="Enter Category" readonly="true">
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
</c:forEach>

<hr style="border-color: white">
<%@ include file="/WEB-INF/views/Common-Footer.jsp"%>