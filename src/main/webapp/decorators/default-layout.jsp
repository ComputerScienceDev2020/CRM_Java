<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	 <title>
	    	<dec:title />
	    </title>
	    
		<jsp:include page="/decorators/components/head-link.jsp" />
		<dec:head />
	</head>
	
<body class="layout-fixed">
 <div class="preloader"></div>
 
 	<!-- Header Layout -->
    <div class="mdk-header-layout js-mdk-header-layout">
    	<!--Header -->
    	<jsp:include page="/decorators/components/header.jsp"></jsp:include>
    	<!-- End Header -->
    	
    	 <!-- Header Layout Content -->
	        <div class="mdk-header-layout__content page">
		<jsp:include page="/decorators/components/navigation-bar.jsp"></jsp:include>
		<dec:body />
	</div>
		
		<!-- // END Header Layout Content -->
		</div>
		 <!-- // END Header Layout -->
		

<jsp:include page="/decorators/components/body-script.jsp"></jsp:include>
</body>
</html>