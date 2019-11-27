<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<p>Redirecting to ${gatewayUrl}...</p>

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
