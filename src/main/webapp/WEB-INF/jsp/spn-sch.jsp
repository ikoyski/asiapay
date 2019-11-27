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
        <li class="breadcrumb-item active" aria-current="page">Client Post Through Browser w/ SchedulePay</li>
      </ol>
    </nav>
    
	<div class="container">

		<div class="starter-template">
			<form action="/spn-process" method="post" target="_blank">
			
			  <div class="form-group">
                <label for="gatewayUrl">Gateway URL:</label>
                <jsp:include page="common/select-gateway-url.jsp"/>
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
                <label for="appId">appId:</label>
                <input type="text" class="form-control" id="appId" name="appId" value="SP" />
              </div>
              
              <div class="form-group">
                <label for="schType">schType:</label>
                <select class="form-control" id="schType" name="schType">
                    <option value="Day">Day</option>
                	<option value="Month">Month</option>
                	<option value="Year">Year</option>
                </select>
              </div>
              
              <div class="form-group">
                <label for="nSch">nSch:</label>
                <input type="text" class="form-control" id="nSch" name="nSch" value="1" />
              </div>
              
              <div class="form-group">
                <label for="sMonth">sMonth:</label>
                <input type="text" class="form-control" id="sMonth" name="sMonth" value="${month}" />
              </div>
              
              <div class="form-group">
                <label for="sDay">sDay:</label>
                <input type="text" class="form-control" id="sDay" name="sDay" value="${day}" />
              </div>
              
              <div class="form-group">
                <label for="sYear">sYear:</label>
                <input type="text" class="form-control" id="sYear" name="sYear" value="${year}" />
              </div>
              
              <div class="form-group">
                <label for="name">name:</label>
                <input type="text" class="form-control" id="name" name="name" value="Test Test" />
              </div>
              
              <div class="form-group">
                <label for="email">email:</label>
                <input type="text" class="form-control" id="email" name="email" value="test@test.com" />
              </div>
              
              <div class="form-group">
                <label for="schStatus">schStatus:</label>
                <input type="text" class="form-control" id="schStatus" name="schStatus" value="Active" />
              </div>
              
              <button type="submit" class="btn btn-default">Submit</button>
              
            </form>
		</div>

	</div>
	
	<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>