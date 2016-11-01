<%@ include file="Common-Header.jsp" %>
<div class="container" id="contactus">

	<form class="well form-horizontal" action=" " method="post" id="contact_form">
		
		<fieldset>

			
			<legend>Contact Us Now!</legend>


			<div class="form-group">
				<label class="col-md-4 control-label">First Name</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="first_name"
							placeholder="First Name" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Last Name</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input name="last_name"
							placeholder="Last Name" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label">E-Mail</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-envelope"></i></span> <input name="email"
							placeholder="E-Mail Address" class="form-control" type="text">
					</div>
				</div>
			</div>


			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Phone No</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-earphone"></i></span> <input name="phone"
							placeholder="(+91)9967452030" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Address</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span> <input name="address"
							placeholder="Address" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">City and State</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span> <input name="city"
							placeholder="city , state" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->

			<div class="form-group">
				<label class="col-md-4 control-label">Zip Code</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-home"></i></span> <input name="zip"
							placeholder="Zip Code" class="form-control" type="text">
					</div>
				</div>
			</div>


			<!-- Text area -->

			<div class="form-group">
				<label class="col-md-4 control-label">Message</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-pencil"></i></span>
						<textarea class="form-control" name="comment"
							placeholder="Type your message to Quickart"></textarea>
					</div>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<button type="submit" class="btn btn-warning">
						Send <span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>

		</fieldset>
	</form>
</div>
<!-- /.container -->
<%@ include file="Common-Footer.jsp" %>