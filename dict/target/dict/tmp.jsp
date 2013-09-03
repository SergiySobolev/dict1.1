<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
        <title>Say Hello!</title>
    </head>
    <body>
        <%
        String name = request.getParameter("NAME");
        if (name == null || name.length() == 0) {
            name = "World";
        }
        %>
        Hello, <%= name %> <br>    
        <form action="index.do">
            <label for='NAME'>Name</label><input type="text" id="NAME" name="NAME"/>
            <button type="submit">Submit</button> 
        </form>    
    </body>
</html>