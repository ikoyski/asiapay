<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="request_uri" value="${requestScope['javax.servlet.forward.request_uri']}" />

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">AsiaPay</a>
    </div>
    
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav"> 
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Integration <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li ${request_uri.endsWith('/spn') ? 'class="active"' : ''} ><a href="/spn">Client Post Through Browser</a></li>
			<li ${request_uri.endsWith('/spn_promo') ? 'class="active"' : ''} ><a href="/spn_promo">Client Post Through Browser w/ PromoPay</a></li>
			<li ${request_uri.endsWith('/spn_sch') ? 'class="active"' : ''} ><a href="/spn_sch">Client Post Through Browser w/ SchedulePay</a></li>
			<li ${request_uri.endsWith('/dpc') ? 'class="active"' : ''} ><a href="/dpc">Direct Client Side</a></li>
			<li ${request_uri.endsWith('/dps') ? 'class="active"' : ''} ><a href="/dps">Direct Server Side</a></li>
			<li ${request_uri.endsWith('/ref') ? 'class="active"' : ''} ><a href="/ref">Reference Payment</a></li>				
            <li ${request_uri.endsWith('/hosted_mpi') ? 'class="active"' : ''} ><a href="/hosted_mpi">Hosted MPI</a></li>
          </ul>
        </li>
        <li ${request_uri.equals('/about') ? 'class="active"' : ''} ><a href="/about">About</a></li>
      </ul>      
    </div>
    
</nav>