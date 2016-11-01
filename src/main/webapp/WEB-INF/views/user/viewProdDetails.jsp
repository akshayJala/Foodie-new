

<%@ include file="/WEB-INF/views/Common-Header.jsp"%>
<br>

<div class="row text-center">
	<div class="col-lg-5 " style="margin-left:10%">
		<div class="panel panel-default">
			<div class="panel-body">
				
				<img src="<c:url value="/images/Quickart.jpg"></c:url>"
					class="image-responsive" alt="Quickartlogo" />
					<h4>${product.productName}</h4>
			</div>

		</div>
	</div>
	<div class="col-lg-5" style="margin-right:5%">
		<div class="panel panel-default">
			<div class="panel-body">
				<h4>${product.productName}from ${product.category.categoryName}
					Category</h4>
				<h4>${product.price}Rs.</h4>
				<h3>${product.description}</h3>
				<br> <br> <br>
				
				<a href="addToCart/${product.productId}" style="margin-right:3%" class="btn btn-primary  " role="button" aria-pressed="true">Add to Cart</a>
				<!-- <a href="buyNow" style="margin-left:3%" class="btn btn-primary  " role="button" aria-pressed="true">Buy Now</a> -->
				<a class="btn btn-md btn-success" style="text-decoration: none"
							href="buyNow/${product.productId}">Buy Now</a>
			</div>

		</div>
	</div>
</div>

<hr style="border-color: white">
<%@ include file="/WEB-INF/views/Common-Footer.jsp"%>