<%@ include file="/WEB-INF/views/Common-Header.jsp"%>

<table width="50%" align="center"
	style="margin-top: 3%; box-shadow: 0px 9px 30px #888888;">
	<tr>
		<td><hr />
			<div class="container text-center">
				<div class="row">
					<h3 style="color: #1E90FF">Add Supplier</h3>
					<br />
					<div class="col-sm-12">
						<div>
							<form:form class="form-inline" method="post" action="addSupplier"
								commandName="Supplier">
								<div class="form-group">
									<form:label for="supplierId" path="supplierId">Supplier Id&nbsp;:</form:label>
									<form:input type="text" class="form-control"
										Style="background-color: #cce6ff;" name="supplierId"
										path="supplierId" placeholder="Enter Supplier Id" />
								</div>
								<div class="form-group">
									<form:label for="supplierName" path="supplierName">Supplier Name&nbsp;:</form:label>
									<form:input type="text" class="form-control"
										Style="background-color: #cce6ff;" name="supplierName"
										path="supplierName" placeholder="Enter Supplier Name" />
								</div>	
									&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
									<form:label for="supplierAddress" path="supplierAddress">Supplier Address&nbsp;:</form:label>
									<form:input type="text" class="form-control"
										Style="background-color: #cce6ff;" name="supplierAddress"
										path="supplierAddress" placeholder="Enter Supplier Address" />
								</div>
								<br />
								<br />
								<form:button type="submit" class="btn btn-primary">Submit</form:button>
							</form:form>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div style="text-align: center;">
					<h3 style="color: #1E90FF">Suppliers
						&nbsp;&nbsp;&nbsp;&nbsp;</h3>
				</div>
				<table class="table table-striped" align="center">
					<thead>
						<tr>
							<th>Supplier Id</th>
							<th>Supplier Name</th>
							<th>Supplier Address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${SupplierList}" var="supplier">
							<tr>

								<td>${supplier.supplierId}</td>
								<td>${supplier.supplierName}</td>
								<td>${supplier.supplierAddress}</td>
								<td><a href="deleteS/${supplier.supplierId}"
									value="${supplier.supplierId}" style="color: red">Delete</a></td>
								<td><button type="button" class="btn btn-primary btn-xs"
										data-toggle="modal" data-target="#${supplier.supplierId}"
										style="padding: 5px;">Edit</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div></td>
	</tr>
</table>
<c:forEach items="${SupplierList}" var="supplier">
	<div class="modal fade" id="${supplier.supplierId}" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<h3 style="color: green">Update Supplier</h3>
					<form method="post" action="editS/${supplier.supplierId}">
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<label for="name" class="control-label">Provide the
										Supplier Id</label> <input type="text" class="form-control"
										value="${supplier.supplierId}" name="supplierId"
										placeholder="${supplier.supplierId}" readonly="true">
								</div>

								<div class="form-group">
									<label for="name" class="control-label">Supplier Name</label> <input
										type="text" class="form-control" name="supplierName"
										value="${supplier.supplierName}" placeholder="Enter New Name">
								</div>
								
								<div class="form-group">
									<label for="name" class="control-label">Supplier Address</label> <input
										type="text" class="form-control" name="supplierAddress"
										value="${supplier.supplierAddress}" placeholder="Enter New Address">
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