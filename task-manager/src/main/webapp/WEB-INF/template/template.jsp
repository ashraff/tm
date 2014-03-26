<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />

<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Ubuntu"/>

<link href="<c:url value="/resources/jquery/css/start/ui.jqgrid.css" />"
	rel="stylesheet" />

<link
	href="<c:url value="/resources/jquery/css/start/jquery-ui-1.10.4.custom.min.css" />"
	rel="stylesheet" />


<script src="<c:url value="/resources/jquery/js/jquery-1.10.2.js" />"
	type="text/javascript"></script>

<script
	src="<c:url value="/resources/jquery/js/jquery-ui-1.10.4.custom.min.js" />"
	type="text/javascript"></script>

<script
	src="<c:url value="/resources/jquery/js/i18n/grid.locale-en.js" />"
	type="text/javascript"></script>

<script
	src="<c:url value="/resources/jquery/js/jquery.jqGrid.min.js" />"
	type="text/javascript"></script>

<script type="text/javascript"
	src="<c:url value="/resources/dojo/dojo.js" />">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/spring/Spring.js" />">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/spring/Spring-Dojo.js" />">
	
</script>
<script type="text/javascript"
	src="<c:url value="/resources/r10/js/treemenu.js" />">
	
</script>

<!--[if lt IE 9]><link href="<c:url value="/resources/r10/damnyouGJ.css" />" rel="stylesheet"><script src="<c:url value="/resources/r10/js/html5shiv.js" />"></script><![endif]-->

</head>

<body>
	<div id="banner">
		<t:insertAttribute name="header" />
	</div>
	<div></div>
	<t:insertAttribute name="navigation_bar" />
	<div></div>
	<div id="page">
		<t:insertAttribute name="content" />
	</div>
	<div></div>
	<div id="footer_wrapper">
		<t:insertAttribute name="footer" />
	</div>
</body>

</html>

