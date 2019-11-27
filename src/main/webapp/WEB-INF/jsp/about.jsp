<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>

    <jsp:include page="common/header.jsp"/>
    
    <nav aria-label="breadcrumb">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="/">AsiaPay</a></li>
        <li class="breadcrumb-item active" aria-current="page">${currentPage}</li>
      </ol>
    </nav>
    
	<div class="container">

		<div class="starter-template">
			<h2>About</h2>
			
			<h3>Some Test Services</h3>
			<p>
			 The <a href="/actuator/health" target="_blank">/actuator/health</a> endpoint provides basic information about the application&apos;s health.
			 The status will be UP as long as the application is healthy. It will show DOWN if the application gets unhealthy due to any issue like connectivity with the database or lack of disk space etc.
			</p>
			<p>
			 The build and version information can be checked by calling the <a href="/actuator/info" target="_blank">/actuator/info</a> endpoint. This allows checking of the git tags, maven version, build date etc.
			</p>			
		</div>

	</div>
	
	<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>