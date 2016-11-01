<%@ include file="/WEB-INF/views/Common-Header.jsp"%>


<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="text-center">
				<i class="fa fa-search-plus pull-left icon"></i>
				<h2>Invoice for purchase #33221</h2>
			</div>
			<hr>
			<div class="row">
				<div class="col-xs-12 col-md-3 col-lg-3 pull-left">
					<div class="panel panel-default height">
						<div class="panel-heading">Billing Details</div>
						<div class="panel-body">
							<strong>${billingAddress.fullName} </strong><br>
							${billingAddress.addressLine}<br>
							${billingAddress.city_Town}<br>
							${billingAddress.state_Province_RegionNumber }<br> <strong>${billingAddress.zip_PostalCode }</strong><br>
							<strong>${billingAddress.country }</strong>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-md-3 col-lg-3">
					<div class="panel panel-default height">
						<div class="panel-heading">Payment Information</div>
						<div class="panel-body">
							<strong>Card Name:</strong> Visa<br> <strong>Card
								Number:</strong>${cardDetails.cardNumber }<br> <strong>Exp
								Date:</strong> ${cardDetails.mM }/${cardDetails.yY }<br>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-md-3 col-lg-3">
					<div class="panel panel-default height">
						<div class="panel-heading">Order Preferences</div>
						<div class="panel-body">
							<strong>Gift:</strong> No<br> <strong>Express
								Delivery:</strong> Yes<br> <strong>Insurance:</strong> No<br> <strong>Coupon:</strong>
							No<br>
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-md-3 col-lg-3 pull-right">
					<div class="panel panel-default height">
						<div class="panel-heading">Shipping Address</div>
						<div class="panel-body">
							<strong>${shippingAddress.fullName} </strong><br>
							${shippingAddress.addressLine}<br>
							${shippingAddress.city_Town}<br>
							${shippingAddress.state_Province_RegionNumber }<br> <strong>${shippingAddress.zip_PostalCode }</strong><br>
							<strong>${shippingAddress.country }</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="text-center">
						<strong>Order summary</strong>
					</h3>
				</div>
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-condensed">
							<thead>
								<tr>
									<td><strong>Item Name</strong></td>
									<td class="text-center"><strong>Item Price</strong></td>
									<td class="text-center"><strong>Item Quantity</strong></td>
									<td class="text-right"><strong>Total</strong></td>
								</tr>
							</thead>
							<tbody>

								<c:forEach var="cart" items="${order.cartList}">

									<tr>
										<td>${cart.productName }</td>
										<td class="text-center">${cart.price}</td>
										<td class="text-center">${cart.quantity}</td>
										<td class="text-right">${cart.price * cart.quantity}</td>
									</tr>

								</c:forEach>
						
								<tr>
									<td class="highrow"></td>
									<td class="highrow"></td>
									<td class="highrow text-center"><strong>Subtotal</strong></td>
									<td class="highrow text-right">${order.totalRs }</td>
								</tr>
								<tr>
									<td class="emptyrow"></td>
									<td class="emptyrow"></td>
									<td class="emptyrow text-center"><strong>Shipping</strong></td>
									<td class="emptyrow text-right">30</td>
								</tr>
								<tr>
									<td class="emptyrow"><form:form role="form">

											<div class="form-group">
												<div class="col-sm-9 col-sm-offset-3"
													style="text-align: center">
													<input type="submit" name="_eventId_goToCardDetails" value="Back"
														class="btn btn-primary btn-block">
													<input type="submit" name="_eventId_goToIndex" value="Confirm Order and Continue Shopping"
														class="btn btn-primary btn-block">
												</div>
											</div>
										</form:form></td>
									<td class="emptyrow"></td>
									<td class="emptyrow text-center"><strong>Total</strong></td>
									<td class="emptyrow text-right">&#8377;${order.totalRs +30}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<style>
.height {
	min-height: 200px;
}

.icon {
	font-size: 47px;
	color: #5CB85C;
}

.iconbig {
	font-size: 77px;
	color: #5CB85C;
}

.table>tbody>tr>.emptyrow {
	border-top: none;
}

.table>thead>tr>.emptyrow {
	border-bottom: none;
}

.table>tbody>tr>.highrow {
	border-top: 3px solid;
}
</style>




<%@ include file="/WEB-INF/views/Common-Footer.jsp"%>