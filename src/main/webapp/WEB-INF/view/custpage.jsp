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
			<a href="/welcome" class="navbar-brand">Log-Out</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<!--<li><a href= "/registers">Add New Customer</a></li>-->
					<li><a href="/show-usersss">Customer Update</a></li>
					<li><a href="/show-roomss">Room Details </a></li>
					<li><a href="/show-avail-rooms">Room Booking</a></li>
					<li><a href="/to-build">Billing Details</a></li>
					<!--<li><a href="/show-user">Check Out</a></li>-->
				</ul>
			</div>
		</div>
	</div>

	<c:choose>
	<c:when test="${mode=='MODE_Recp_LOGIN' }">
			<div class="container text-center">
				<h3>Receptionist Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-users">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
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
	
	
	<c:when test="${mode=='ALL_ROOMS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Rooms</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>RoomCategory</th>
								<th>RoomNo</th>
								<th>RoomStatus</th>
								<!--<th>Delete</th>
									<th>Edit</th>
								-->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users }">
								<tr>
									<td>${user.id}</td>
									<td>${user.roomcategory}</td>
									<td>${user.roomno}</td>
									<td>${user.status }
									<!-- <td><a href="/delete-room?id=${user.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="/edit-room?id=${user.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									-->
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			
			
		</c:when>
		<c:when test="${mode=='AVAIL_ROOMS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>Available Rooms</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>RoomCategory</th>
								<th>RoomNo</th>
								<th>RoomStatus</th>
								<th>Action</th>
								<!--<th>Delete</th>
									<th>Edit</th>
								-->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users }">
								<tr>
									<td>${user.id}</td>
									<td>${user.roomcategory}</td>
									<td>${user.roomno}</td>
									<td><a href="/show-avail-rooms?status=${user.status}"></a></td>
                            <td>
                                <c:if test="${user.status ne 'Book'}">
                                     <form action="/book-room" method="post">
                                        <input type="hidden" name="roomid" value="${user.roomno}" required>
                                         <input type="text" name="customerName" placeholder="Customer Name" required>
                                        <input type="text" name="customerId" placeholder="Customer ID" required>
                                        <input type="date" name="fromDate" placeholder="From Date" required>
                                        <input type="date" name="toDate" placeholder="To Date" required>
                                        <button type="submit" class="btn btn-primary">Book</button>
                                    </form>
                                </c:if>
                                
                            </td>
                            </td>
									<!-- <td><a href="/delete-room?id=${user.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									<td><a href="/edit-room?id=${user.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
									-->
								</tr>
							</c:forEach>
							
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_HOME' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Welcome to Darbar-Hotel</h1>
					<h3>Hotels to celebrate life</h3>
				</div>
			</div>

		</c:when>
		
		
		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
				<h3>New Customer Registration</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-users">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstname"
								value="${user.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastname"
								value="${user.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Age </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="age"
								value="${user.age }" />
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
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		<c:when test="${mode=='ALL_USERS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All Customers</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>UserName</th>
								<th>First Name</th>
								<th>LastName</th>
								<th>Age</th>
								<!--<th>Delete</th>-->
								<th>Edit</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="user" items="${users }">
								<tr>
									<td>${user.id}</td>
									<td>${user.username}</td>
									<td>${user.firstname}</td>
									<td>${user.lastname}</td>
									<td>${user.age}</td>
									<!-- <td><a href="/delete-user?id=${user.id }"><span
											class="glyphicon glyphicon-trash"></span></a></td>
									-->
									<td><a href="/edit-user?id=${user.id }"><span
											class="glyphicon glyphicon-pencil"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_UPDATE' }">
			<div class="container text-center">
				<h3>Update Customer</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="save-users">
					<input type="hidden" name="id" value="${user.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="username"
								value="${user.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">First Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="firstname"
								value="${user.firstname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Last Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lastname"
								value="${user.lastname }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Age </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="age"
								value="${user.age }" />
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
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
				</form>
			</div>
		</c:when>

		<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3>User Login</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-user">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Username</label>
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
	<div class="container text-center">
        <c:if test="${not empty message}">
            <p>${message}</p>
        </c:if>
    </div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>