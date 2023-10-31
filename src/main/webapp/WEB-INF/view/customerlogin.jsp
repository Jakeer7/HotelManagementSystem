<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Darbarhotel | home</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href= "/welcome">Home</a></li>
					<!--<li><a href="/adminreg">Add Admin</a></li>-->
					<li><a href="/login-cust">Login</a></li>
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
	<c:when test="${mode=='MODE_LOGIN-CUST' }">
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-custs">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Customername</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Password</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="password"
								value="${user.password }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
					</form>
					</div>
					</c:when>
					
			</c:choose>
			<div class="container" id="homediv">
		<div class="jumbotron text-center">
			<h1>Welcome to Darbar-Hotel</h1>
		</div>
	</div>
			
</body>
</html>