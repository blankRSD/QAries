<%@ include file="../layouts/header.jsp"%>

<%@ include file="../layouts/navbar.jsp"%>

<div class="container-lg my-2">

	<h2>Login</h2>
		
	<form action="login" method="post">
	
		<div class="my-3">
			<input type="text" name="email" placeholder="emailID" class="form-control">
		</div>
	
		<div class="my-3">
			<input type ="password" name="password" placeholder="Password" class="form-control">
		</div>	
		
		<button type="submit" class="btn btn-primary">Login</button>
	</form>
	
</div>
	
<%@ include file="../layouts/footer.jsp"%>



