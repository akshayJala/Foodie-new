<hr>

<c:forEach items="${productByCategoryList}" var="catProducts">

	<div class="container" id="shopping">
		<h2>${category}</h2>
		<div class="row text-center">

			<c:forEach items="${catProducts}" var="prod">
				
					<div class="col-lg-2 ">
						<div class="panel panel-default">
							<div class="panel-body">
								<h4>${prod.productName}</h4>
								<h6>${prod.category.categoryName}</h6>
								<a href="viewProds/${ prod.productId}"
									value="${product.productId}"><img
									src="<c:url value="images/${prod.productId}.jpeg"></c:url>"
									class="img-responsive" alt="${prod.productName}"></a>
								<h6>${prod.price}Rs.</h6>
							</div>

						</div>
					</div>
				
			</c:forEach>

		</div>


	</div>

	<hr>

</c:forEach>
<!--Furniture idems ends here-->