<%@ include file="/WEB-INF/views/Common-Header.jsp"%>

<div class="container" style="margin-left: 38%">
	<div class="row">
		<h3 style="color: green">Please provide card details for payment.</h3>
		<div class="col-xs-12 col-md-4" style="align: center">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Payment Details</h3>
				</div>
				<div class="panel-body">
					<form:form role="form" commandName="cardDetails">
						<div class="form-group">
							<form:label for="cardNumber" path="cardNumber"> CARD NUMBER</form:label>
							<div class="input-group">
								<form:input type="text" path="cardNumber" class="form-control"
									id="cardNumber" placeholder="Valid Card Number" />
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-lock"></span></span>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-7 col-md-7">
								<div class="form-group">
									<form:label for="mM" path="mM"> EXPIRY Month</form:label>
									<div class="col-xs-6 col-lg-6 pl-ziro">
										<form:input type="text" class="form-control" path="mM" id="mM"
											placeholder="MM" />
									</div>
									<form:label for="yY" path="yY"> Year</form:label>
									<div class="col-xs-6 col-lg-6 pl-ziro">
										<form:input path="yY" type="text" class="form-control" id="yY"
											placeholder="YY" />
									</div>
								</div>
							</div>
							<div class="col-xs-5 col-md-5 pull-right">
								<div class="form-group">
									<form:label path="cV" for="cV"> CV CODE</form:label>
									<form:input path="cV" type="password" class="form-control"
										id="cV" placeholder="CV" />
								</div>
							</div>

							<div class="col-sm-9 col-sm-offset-3">
								<input type="submit" name="_eventId_submitCardDetails"
									value="Pay and Confirm Order" class="btn btn-success btn-block">
									<br>
								<div class="btn-group">
									<button type="submit" name="_eventId_goToShippingAddress"
										class="btn btn-primary">Back</button>
									<a type="button" href="viewCartItems"
										class="btn btn-warning">Cancel</a>

								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<br>
<br>

<%@ include file="/WEB-INF/views/Common-Footer.jsp"%>
