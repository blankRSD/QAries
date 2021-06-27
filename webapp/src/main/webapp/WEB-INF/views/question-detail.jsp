<%@ include file="../layouts/header.jsp"%>

<%@ include file="../layouts/navbar.jsp"%>

<div class="container-lg my-2">

	<h2>Question: ${question.getQuestionId() }</h2>
	
	<div class="card">
	  <div class="card-body">
	    <h5 class="card-title">
			${question.getTitle()}
	    </h5>
	    <p class="card-text">
	    	${question.getDescription()}
	    </p>
	    <p>
	    	<form action='question-detail' method='post'>
	    		
	    		<div class="my-3">	    		
	    			<input type='text' name='answerdescription' class="form-control" placeholder="answer" />
	    		</div>
				<button class="btn btn-primary">Submit</button>
			</form>
	    </p>
	  </div>
	</div>
	
	<ul class="list-group my-4">
		<sap:forEach items="${answers}" var="answer" >
		
			<li class="list-group-item list-group-item-action">
				${ answer.getDescription() }
			</li>
			
		</sap:forEach>
	</ul>

</div>
	
<%@ include file="../layouts/footer.jsp"%>
