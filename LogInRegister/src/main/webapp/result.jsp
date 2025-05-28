<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="com.test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		String val=(String)request.getAttribute("status");
		Student std=(Student)request.getAttribute("stObj");

		if(val.equals("succuss"))
		{
%>
	<p>Welcome &nbsp; <%=std.getName() %> </p>
<%
}
		else
		{
%>
	<p>Sorry </p>
<%
		}
%>		
</body>
</html>