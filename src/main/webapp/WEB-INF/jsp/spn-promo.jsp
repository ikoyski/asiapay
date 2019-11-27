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
        <li class="breadcrumb-item"><a href="#">Integrations</a></li>
        <li class="breadcrumb-item active" aria-current="page">${currentPage}</li>
      </ol>
    </nav>
    
	<div class="container">

		<div class="starter-template">
			<form action="/redirect" method="post" target="_blank">
			
			  <input type="hidden" class="form-control" name="currentPage" value="${currentPage}" />
			
			  <div class="form-group">
                <label for="gatewayUrl">Gateway URL:</label>
                <jsp:include page="common/select-gateway-url-spn.jsp"/>
              </div>
			
              <div class="form-group">
                <label for="secureHashSecret">secureHashSecret:</label>
                <input type="text" class="form-control" id="secureHashSecret" name="secureHashSecret" />
              </div>
              
              <div class="form-group">
                <label for="merchantId">merchantId:</label>
                <input type="text" class="form-control" id="merchantId" name="merchantId" />
              </div>
              
              <div class="form-group">
                <label for="currCode">currCode:</label>
                <jsp:include page="common/select-curr-code.jsp"/>
              </div>
              
              <div class="form-group">
                <label for="amount">amount:</label>
                <input type="text" class="form-control" id="amount" name="amount" value="1.00" />
              </div>
              
              <div class="form-group">
                <label for="payType">payType:</label>
                <jsp:include page="common/select-pay-type.jsp"/>
              </div>
              
              <div class="form-group">
                <label for="lang">lang:</label>
                <jsp:include page="common/select-lang.jsp"/>
              </div>
              
              <div class="form-group">
                <label for="payMethod">payMethod:</label>
                <input type="text" class="form-control" id="payMethod" name="payMethod" value="ALL" />
              </div>
              
              <div class="form-group">
                <label for="orderRef">orderRef:</label>
                <input type="text" class="form-control" id="orderRef" name="orderRef" value="${orderRef}" />
              </div>
              
              <div class="form-group">
                <label for="promotion">promotion:</label>
                <input type="text" class="form-control" id="promotion" name="promotion" value="T" />
              </div>
              
              <div class="form-group">
                <label for="promotionCode">promotionCode:</label>
                <input type="text" class="form-control" id="promotionCode" name="promotionCode" value="" />
              </div>
              
              <div class="form-group">
                <label for="promotionRuleCode">promotionRuleCode:</label>
                <input type="text" class="form-control" id="promotionRuleCode" name="promotionRuleCode" value="" />
              </div>
              
              <div class="form-group">
                <label for="promotionOriginalAmt">promotionOriginalAmt:</label>
                <input type="text" class="form-control" id="promotionOriginalAmt" name="promotionRuleCode" value="" />
              </div>
              
              <button type="submit" class="btn btn-default">Submit</button>
              
            </form>
		</div>

	</div>
	
	<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>