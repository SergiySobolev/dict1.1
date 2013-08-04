<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<tiles:importAttribute />
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link rel="stylesheet" type="text/css" href="<html:rewrite forward='dictStyle'/>" />		
	<link rel="stylesheet" type="text/css" href="<html:rewrite forward='chosenStyle'/>" />		
	<title><bean:message key="dict.title.general" bundle="commonMsg" /></title>			
</head>
<body>
	<table id="base">
		<tr>
			<td><tiles:insert attribute="langbar" /></td>
		</tr>
		<tr>
			<td><tiles:insert attribute="header" /></td>
		</tr>
		<tr>
			<td><tiles:insert attribute="body"/></td>
		</tr>
		<tr>
			<td><tiles:insert attribute="footer" /></td>
		</tr>
	</table>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/chosen/chosen.jquery.min.js"></script>
	<script type="text/javascript" src="js/dict.js"></script>
	<script type="text/javascript" src="js/showHide.js"></script>
</body>
</html>