<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="/asiapay/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

    <jsp:include page="common/header.jsp"/>
    
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/asiapay">AsiaPay</a></li>
        <li class="breadcrumb-item"><a href="#">Integrations</a></li>
        <li class="breadcrumb-item active" aria-current="page">${currentPage}</li>
      </ol>
    </nav>
    
	<div class="container">

		<div class="starter-template">
			<p class="text-center">Redirecting to ${gatewayUrl}...</p>

            <form id="paymentForm" method="post" action="${gatewayUrl}"> 
            <c:forEach var="entry" items="${params}"> 
            	<input type="hidden" name="${entry.key}" value="${entry.value}" />
            </c:forEach>
            </form>
            <script type="text/javascript">
            	function submitForm(){
            		document.getElementById('paymentForm').submit();
            	}
            	setTimeout('submitForm();', 1000);
            </script>
		</div>

	</div>
	
	<script src="/asiapay/webjars/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="/asiapay/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>