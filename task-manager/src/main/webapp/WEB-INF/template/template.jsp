 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
 
<html>
    <head>
 
    </head>
    <body>
        <div id="banner">
            <tiles:insertAttribute name="header" />
        </div>
        <div></div>
        <tiles:insertAttribute name="navigation_bar" />
        <div></div>
        <div id="page">
            <tiles:insertAttribute name="content" />
        </div>
        <div></div>
        <div id="footer_wrapper">
            <tiles:insertAttribute name="footer" />
        </div>
    </body>
</html>