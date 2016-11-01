<%@ include file="/WEB-INF/views/Common-Header.jsp"%>

<table width="50%" align="center"
	style="margin-top: 3%; box-shadow: 0px 9px 30px #888888;">
	<tr>
		<td><hr />
			<div class="container text-center">
				<div class="row">
					<h3 style="color: tomato">Add Category</h3>
					<br />
					<div class="col-sm-12">
						<div>
							<form:form class="form-inline" method="post" action="addCategory"
								commandName="Category">
								<div class="form-group">
									<form:label for="categoryId" path="categoryId">Category Id&nbsp;:</form:label>
									<form:input type="text" class="form-control"
										Style="background-color: orange;" name="categoryId"
										path="categoryId" placeholder="Enter Category Id" />
								</div>
								<div class="form-group">
									<form:label for="categoryName" path="categoryName">Category Name&nbsp;:</form:label>
									<form:input type="text" class="form-control"
										Style="background-color: orange;" name="categoryName"
										path="categoryName" placeholder="Enter Category Name" />
								</div>	
									&nbsp;&nbsp;&nbsp;&nbsp;
									<div class="form-group">
									<form:label for="description" path="description"> Description&nbsp;:</form:label>
									<form:input type="text" class="form-control"
										Style="background-color: orange;" name="description"
										path="description" placeholder="Description" />
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
					<h3 style="color: tomato">Categories
						&nbsp;&nbsp;&nbsp;&nbsp;</h3>
				</div>
				<table class="table table-striped" align="center">
					<thead>
						<tr>
							<th>Category Id</th>
							<th>Category Name</th>
							<th>Category Description</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${CategoryList}" var="category">
							<tr>
								<td>${category.categoryId}</td>
								<td>${category.categoryName}</td>
								<td>${category.description}</td>
								<td><a href="deleteC/${category.categoryId}"
									value="${category.categoryId}" style="color: red">Delete</a></td>
								<td><button type="button" class="btn btn-primary btn-xs"
										data-toggle="modal" data-target="#${category.categoryId}"
										style="padding: 5px;">Edit</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div></td>
	</tr>
</table>
<c:forEach items="${CategoryList}" var="category">
	<div class="modal fade" id="${category.categoryId}" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-body">
					<h3 style="color: green">Update Category</h3>
					<form method="post" action="editC/${category.categoryId}">
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<label for="name" class="control-label">Provide the
										Category Id</label> <input type="text" class="form-control"
										value="${category.categoryId}" name="categoryId"
										placeholder="${category.categoryId}" readonly="true">
								</div>
								<div class="form-group">
									<label for="name" class="control-label">Category Name</label> <input
										type="text" class="form-control" name="categoryName"
										value="${category.categoryName}" placeholder="Enter New Name">
								</div>
								
								<div class="form-group">
									<label for="name" class="control-label">Description</label> <input
										type="text" class="form-control" name="description"
										value="${category.description}" placeholder="Enter Description">
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