<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.dm.common.*"%>
<%@page import="java.util.*"%>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 회원목록 </h1>
<%	
	ArrayList<ResisterDTO> vlist=(ArrayList<ResisterDTO>)session.getAttribute("vlist");
	for(int j=0; j<4 ; j++){
		ResisterDTO regBean=(ResisterDTO)vlist.get(j);
		out.println( regBean.getMemberid()+ ",");
	    out.println( regBean.getPassword()+ ",");
	    out.println( regBean.getName()+ ",");
	    out.println( regBean.getEmail()+ "<br>");
	}
%>
</body>
</html>