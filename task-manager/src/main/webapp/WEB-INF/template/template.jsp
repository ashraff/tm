<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t1" uri="http://tiles.apache.org/tags-tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">



<!--[if lt IE 9]><link href="<c:url value="/resources/r10/damnyouGJ.css" />" rel="stylesheet"><script src="<c:url value="/resources/r10/js/html5shiv.js" />"></script><![endif]-->


</head>
<body>
	<div id="banner">
		<t1:insertAttribute name="header" />
	</div>
	<div></div>
	<t1:insertAttribute name="navigation_bar" />
	<div></div>
	<div id="page">
		<t1:insertAttribute name="content" />
	</div>
	<div></div>
	<div id="footer_wrapper">
		<t1:insertAttribute name="footer" />
	</div>
</body>
</html>

