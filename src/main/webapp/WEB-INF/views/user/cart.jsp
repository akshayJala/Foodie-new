<%@ include file="/WEB-INF/views/Common-Header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span class="glyphicon glyphicon-shopping-cart"></span> Cart
					</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive" style="width: 100%">
						<table class="table table-condensed table-striped table-hover">
							<thead>
								<tr>
									<th>Product</th>
									<th>Price</th>
									<th>Quantity</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="cart" items="${cartList}">
									<tr>
										<td>${cart.productName}</td>
										<td>&#8377;${cart.price}</td>
										<td>${cart.quantity}</td>
<%-- <c:url value="/css/MyStyleSheet.css" /> --%>
<%-- href="cart/delete/${cart.cartId}" --%>

										<td><a href="<c:url value="/cart/delete/${cart.cartId}" />"
											style="text-decoration: none"
											class="button btn-sm btn-danger pull-right">Remove from
												cart</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="pull-right">
							<h3>
								<strong>Total amount:</strong> Rs. ${TotalRs}
							</h3>
						</div>
					</div>
				</div>
				<div class="panel-footer">
					<div class="text-right">
						<a class="btn btn-md btn-success" style="text-decoration: none"
							href="/quickart/viewProds/checkout">Check-out</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/Common-Footer.jsp"%>