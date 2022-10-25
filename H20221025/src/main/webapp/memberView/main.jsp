<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<% String id= (String)session.getAttribute("id"); 
		String auth= (String)session.getAttribute("auth");
	%>
	<%if (id!=null){%>
		<p>아이디:<%=id %></p>
		<%}else{ %>
		<p>손님</p>
		<%} %>
	
	<h2>Member의 첫페이지 입니다.</h2>
	<%if (auth.equals("admin")){ %>
	<a href="./memberAddForm.do">회원정보생성페이지</a><br>
	<%} %>
	<a href="./memberModifyForm.do">회원정보수정페이지.</a><br>
	<a href="./memberRemoveForm.do">회원정보삭제페이지</a><br>
	<a href="./memberSearchForm.do">회원정보상세페이지</a><br>
	<a href="./memberList.do">회원정보목록페이지</a><br>
	
	<%if (id==null){ %>
	<a href="./loginForm.do">로그인화면</a>
	<%}else{ %>
	<a href="./logoutForm.do">아이디 <%=id %>로그아웃</a>
	<%} %>
</body>
</html>