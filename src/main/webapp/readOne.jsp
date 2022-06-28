<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.BoardItemServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.BoardItemService"%>
<%@page import="kr.ac.kopo.ctc.kopo44.domain.StockItem"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.Pagination"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	p

		String id = request.getParameter("id");

		BoardItemService boardItemService = new BoardItemServiceImpl();
		String cPage = boardItemService.checkcPage(id);

		StockItem boardItem = boardItemService.readOne(id);

		ServletContext context = getServletContext();
		context.setAttribute("boardItem", boardItem);
	%>
	<table cellspacing=1 width=600 border=1>
		<tr>
			<td width=100px>번호</td>
			<td>${boardItem.id}</td>
		</tr>
		<tr>
			<td width=100px>제목</td>
			<td>${boardItem.title}</td>
		</tr>
		<tr>
			<td width=100px>일자</td>
			<td>${boardItem.date}</td>
		</tr>
		<tr>
			<td width=100px>내용</td>
			<td>${boardItem.content}</td>
		</tr>
	</table>
	<c:if test="${scoreItem.id != 0}">
		<table cellspacing=1 width=400 border=0>
			<tr>
				<td width="200"></td>
				<td width="100"><p align="center">
						<input type="submit" value="수정"
							onclick="location.href='updateOne.jsp?id=${boardItem.id}'">
					</p></td>
				<td width="100"><p align="center">
						<input type="submit" value="삭제"
							onclick="location.href='deleteOne.jsp?id=${boardItem.id}'">
					</p></td>
			</tr>
		</table>
	</c:if>

</body>
</html>