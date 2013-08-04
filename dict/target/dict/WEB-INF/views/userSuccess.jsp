<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
    <title>Dispatch Action Example - viralpatel.net</title>
</head>
<body>
    <h3>User Message (Dispatch Action Example)</h3>
    <center>
    <font color="blue"><h3><%= request.getAttribute("message") %></h3></font>
    <center>
</body>
</html>