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
        <li class="breadcrumb-item active" aria-current="page">Client Post Through Browser</li>
      </ol>
    </nav>
    
	<div class="container">

		<div class="starter-template">
			<form action="/spnProcess" method="post">
			
			  <div class="form-group">
                <label for="gatewayUrl">Gateway URL:</label>
                <select class="form-control" id="gatewayUrl" name="gatewayUrl">
                    <optgroup label="PesoPay">
                     	<option>https://www.pesopay.com/b2c2/eng/payment/payForm.jsp</option>
                     	<option selected="selected">https://test2.pesopay.com/b2cDemo/eng/payment/payForm.jsp</option>
                     	<option>https://sit.pesopay.com/b2cDemo/eng/payment/payForm.jsp</option>
                    </optgroup>
                    <optgroup label="PayDollar">
                     	<option>https://www.paydollar.com/b2c2/eng/payment/payForm.jsp</option>
                     	<option>https://test.paydollar.com/b2cDemo/eng/payment/payForm.jsp</option>
                     	<option>https://sit.paydollar.com/b2cDemo/eng/payment/payForm.jsp</option>
                	</optgroup>
                    <optgroup label="SiamPay">
                     	<option>https://www.siampay.com/b2c2/eng/payment/payForm.jsp</option>
                     	<option>https://test.siampay.com/b2cDemo/eng/payment/payForm.jsp</option>
                     	<option>https://sit.siampay.com/b2cDemo/eng/payment/payForm.jsp</option>
                    </optgroup>
                </select>
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
                <select class="form-control" id="currCode" name="currCode">
                    <option value="608">PHP</option>
                	<option value="840">USD</option>
                	<option value="764">THB</option>
                	<option value="344">HKD</option>                            	
                	<option value="702">SGD</option>
                	<option value="156">CNY</option>
                	<option value="392">JPY</option>
                	<option value="901">TWD</option>
                	<option value="036">AUD</option>
                	<option value="978">EUR</option>
                	<option value="826">GBP</option>
                	<option value="124">CAD</option>
                	<option value="446">MOP</option>
                	<option value="458">MYR</option>
                	<option value="360">IDR</option>
                	<option value="410">KRW</option>
                	<option value="682">SAR</option>
                	<option value="554">NZD</option>
                	<option value="784">AED</option>
                	<option value="096">BND</option>
                	<option value="704">VND</option>
                	<option value="356">INR</option>
                </select>
              </div>
              
              <div class="form-group">
                <label for="amount">amount:</label>
                <input type="text" class="form-control" id="amount" name="amount" value="1.00" />
              </div>
              
              <div class="form-group">
                <label for="payType">payType:</label>
                <select class="form-control" id="payType" name="payType">
                    <option value="N">Sale (Normal)</option>
                    <option value="H">Authorize (Hold)</option>
                </select>
              </div>
              
              <div class="form-group">
                <label for="lang">lang:</label>
                <select class="form-control" id="lang" name="lang">
                    <option value="E">English</option>
                	<option value="C">Traditional Chinese</option>
                	<option value="X">Simplified Chinese</option>
                	<option value="K">Korean</option>                            	
                	<option value="J">Japanese</option>
                	<option value="T">Thai</option>
                	<option value="F">French</option>
                	<option value="G">German</option>
                	<option value="R">Russian</option>
                	<option value="S">Spanish</option>
                	<option value="V">Vietnamese</option>
                </select>
              </div>
              
              <div class="form-group">
                <label for="payMethod">payMethod:</label>
                <input type="text" class="form-control" id="payMethod" name="payMethod" value="ALL" />
              </div>
              
              <div class="form-group">
                <label for="orderRef">orderRef:</label>
                <input type="text" class="form-control" id="orderRef" name="orderRef" value="${orderRef}" />
              </div>
              
              <button type="submit" class="btn btn-default">Submit</button>
              
            </form>
		</div>

	</div>
	
	<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>