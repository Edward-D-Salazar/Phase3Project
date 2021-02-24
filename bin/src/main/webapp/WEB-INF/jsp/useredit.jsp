<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<html>
<head>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<title>Update Page</title>
</head>
<%--
<form action='' method='POST'>
	<label>Enter new First Name: <input type='text'
		name='firstName'></input></label> <label>Enter new Last name: <input
		type='text' name='lastName'></input></label> <label>Enter new userid:
		<input type='text' name='username'></input>
	</label> <label>Enter new password: <input type='password'
		name='password'></input></label> <input type='submit' value='UPDATE'>

	<div>${update}</div>
</form>
 --%>

<div class="container h-40" align='center'>
	<article class="card-body">
		<h4 class="card-title text-center mb-4 mt-1">Update a user</h4>
		<hr>
		<p class="text-success text-center">Please provide info</p>
		<form action='' method='POST'>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-user"></i>
						</span>
					</div>
					<input name="firstName" class="form-control"
						placeholder="First Name" type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-user"></i>
						</span>
					</div>
					<input name="lastName" class="form-control" placeholder="Last Name"
						type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-user"></i>
						</span>
					</div>
					<input name="username" class="form-control" placeholder="User Name"
						type="text">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-prepend">
						<span class="input-group-text"> <i class="fa fa-lock"></i>
						</span>
					</div>
					<input name="password" class="form-control" placeholder="********"
						type="password">
				</div>
			</div>
			<!-- input-group.// -->

			<!-- form-group// -->
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">
					Submit</button>
			</div>
		</form>
		<div>${update}</div>
	</article>
</div>

</html>