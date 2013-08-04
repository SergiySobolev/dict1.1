<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>	
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>	
<%@ taglib uri="/tags/request" prefix="req"%>

<HTML>
<HEAD>
<html:base />
<LINK rel="stylesheet" type="text/css" href="<html:rewriteforward= 'baseStyle'/>

<TITLE>Artimus - Article</TITLE>
</HEAD>
<BODY>
	<TABLE class="outer">
		<TR>
			<TD><TABLE class="inner">
					<!-- MESSAGE -->
					<TR>
						<TD class="message" colspan="3" width="100%"><html:errors /></TD>
					</TR>
					<TR>
						<TD class="heading" colspan="3"><H2>
								<bean:write name="articleForm" property="title"/>
							
							</H2></TD>
					</TR>
					<TR>
						<TD class="author" colspan="3">by <bean:write
								name="articleForm" property="creator" /></TD>
					</TR>
					<TR>
						<TD class="article" colspan="3"><bean:write
								name="articleForm" property="content" filter="false" /></TD>
					</TR>
					<%-- CONTRIBUTOR PANEL --%>
					<req:isUserInRole role="contributor">
						<TR>
							<TD colspan="3"><HR /></TD>
						</TR>
						<TR>
							<%-- DELETE --%>
							<logic:equal name="articleForm" property="marked" value="0">
								<html:form action="/admin/article/Delete">
									<TD class="input"><html:submit>DELETE</html:submit></TD>
									<html:hidden property="article" />
								</html:form>
							</logic:equal>
							<%-- RESTORE --%>
							<logic:equal name="articleForm" property="marked" value="1">
								<html:form action="/admin/article/Restore">
									<TD class="input"><html:submit>RESTORE</html:submit></TD>
									<html:hidden property="article" />
								</html:form>
							</logic:equal>
							<html:form action="/admin/article/Edit">
								<TD class="button" colspan="2"><html:hidden
										property="article" /> <html:submit>EDIT</html:submit> <html:cancel>CANCEL</html:cancel></TD>
							</html:form>
						</TR>
					</req:isUserInRole>
					<!-- NAVBAR -->
				</TABLE></TD>
		</TR>
		<TR>
			<TD class="navbar"><html:link forward="done">DONE</html:link></TD>
		</TR>
	</TABLE>
</BODY>
</HTML>