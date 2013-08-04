<%@ taglib uri="/tags/struts-html" prefix="html"%><%@ taglib
	uri="/tags/tiles" prefix="tiles"%><HTML>
<HEAD>
<html:base />
<LINK rel="stylesheet" type="text/css"
	href="<html:rewrite      forward='baseStyle'/>">
<TITLE><tiles:getAsString name="title" /></TITLE>
</HEAD>
<BODY onload="document.forms[0].elements[0].focus();">
	<!-- OUTER TABLE -->
	<TABLE class="outer">
		<TR>
			<TD align="center">
				<!-- INNER TABLE -->
				<TABLE class="inner">
					<TR>
						<TD class="navbar" colspan="3"><tiles:getAsString
								name="subtitle" /></TD>
					</TR>