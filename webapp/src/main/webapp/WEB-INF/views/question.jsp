<%@ include file="../layouts/header.jsp"%>

<%@ include file="../layouts/navbar.jsp"%>

<div class="container-lg my-2">

	<h2>All Questions</h2>
	
	<div class="card">
	  <div class="card-body">
	    <p>
	    	<form action='insert-question' method='post'>
	    		
	    		<div class="my-3">	    		
	    			<input type='text' name='questiontitle' class="form-control" placeholder="Question Title" />
	    		</div>
	    		<div class="my-3">	    		
	    			<input type='text' name='questiondescription' class="form-control" placeholder="Question Description" />
	    		</div>
				<button class="btn btn-primary">Submit</button>
			</form>
	    </p>
	  </div>
	</div>
	
	<div class="list-group my-5">
		<sap:forEach items="${questions}" var="question" >
		
			<a href="question-detail?qid=${ question.getQuestionId() }" 
				class="list-group-item list-group-item-action">
		
				${ question.getTitle() }
			
			</a>
			
		</sap:forEach>
	</div>
	
</div>
	
<%@ include file="../layouts/footer.jsp"%>
