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
        <li class="breadcrumb-item active" aria-current="page">AsiaPay</li>
      </ol>
    </nav>
    
	<div class="container">

		<div class="starter-template">
			<h2>Welcome</h2>
			
			<p>This site will house various clients that will consume AsiaPay APIs.</p>
		</div>

	</div>
	
	<script src="/asiapay/webjars/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="/asiapay/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>