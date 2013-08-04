<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%-- 	pageEncoding="UTF-8"%> --%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%-- <%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%-- <html> --%>
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <link rel="stylesheet" type="text/css" href="css/chosen.css"> -->
<!-- <link rel="stylesheet" type="text/css" href="css/dict.css"> -->
<!-- <title><bean:message key="indexPage.title" /></title> -->
<!-- </head> -->
<!-- <body> -->

<!-- <html><head></head> -->
<!-- <body> -->
<!-- <bean:message key="search.title" /> -->
<!-- </body> -->
<!-- </html> -->
<!-- <div style="padding:16px;"> -->
	<input type="hidden" name="method" value="search" />
	<html:form action="/DictionaryAction">
	<input type="hidden" name="method" value="search">
		<table align="center">
			<thead>
				<tr>
					<td>
						<html:select property="lastName" styleClass="chzn-select-deselect">
							<html:option value=""></html:option>	
							<html:option value="" style="display:none"><bean:message key="select.lastname.title"/></html:option>						
							<html:optionsCollection name="dictReqForm"
								property="subsciberList" label="subscrLastName"
								value="subscrLastName" />
						</html:select>
					</td>
					<td>
						<html:select property="firstName" styleClass="chzn-select-deselect" >
							<html:option value=""/>							
							<html:optionsCollection name="dictReqForm"
								property="subsciberList" label="subscrFirstName"
								value="subscrFirstName" />
						</html:select>
					</td>
					<td>
						<html:select property="departament" styleClass="chzn-select-deselect" >
							<html:option value=""/>							
							<html:optionsCollection name="dictReqForm"
								property="subsciberList" label="departament"
								value="departament" />
						</html:select>
					</td>
					<td>
						<html:select property="position" styleClass="chzn-select-deselect" >
							<html:option value=""/>							
							<html:optionsCollection name="dictReqForm"
								property="subsciberList" label="position"
								value="position" />
						</html:select>
					</td>
				<tr>
			</thead>
			<tbody>
				<logic:iterate id="row" collection="${requestScope.resList}">
					<tr>
						<td><bean:write name="row" property="subscrLastName" /></td>
						<td><bean:write name="row" property="subscrFirstName" /></td>
						<td><bean:write name="row" property="departament" /></td>
						<td><bean:write name="row" property="position" /></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
		<html:submit property="method">
			<bean:message key="search.title" />
		</html:submit>
		<html:submit property="method">
			<bean:message key="add.title" />
		</html:submit>
	</html:form>	
<!-- </div>	 -->
<!-- 	<script type="text/javascript" src="js/jquery.js"></script> -->
<!-- 	<script type="text/javascript" src="js/chosen/chosen.jquery.min.js"></script>	 -->
<!-- 	<script type="text/javascript" src="js/dict.js"></script> -->
<!-- </body> -->
<%-- </html> --%>