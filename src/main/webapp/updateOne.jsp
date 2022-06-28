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
<title>게시글 수정 페이지</title>
</head>
<body>
	<%
	p

		String id = request.getParameter("id");

		BoardItemService boardItemService = new BoardItemServiceImpl();
		String cPage = boardItemService.checkcPage(id);

		StockItem boardItem = boardItemService.readOne(id);
		String newDate = boardItemService.newDate();
		pageContext.setAttribute("newDate", newDate);

		ServletContext context = getServletContext();
		context.setAttribute("boardItem", boardItem);
	%>
	<form action="updateDone.jsp" method="post">
		<table cellspacing=1 width=600 border=1>
			<tr>
				<td width=100px>번호</td>
				<td><input type="text" value="${boardItem.id}" name="id"
					readonly></td>
			</tr>
			<tr>
				<td width=100px>제목</td>
				<td><input type="text" value="${boardItem.title}"
					name="newTitle" pattern='^[가-힣a-zA-Z\s?~!@#$%^&*()/]+$' required></td>
			</tr>
			<tr>
				<td width=100px>일자</td>
				<td><input type="text" value="${newDate}" readonly></td>
			</tr>
			<tr>
				<td width=100px>내용</td>
				<td><textarea style="width: 500px; height: 300px;"
						name="newContent" pattern='^[가-힣a-zA-Z]+$' required>${boardItem.content}</textarea></td>
			</tr>
		</table>
		<c:if test="${boardItem.id != 0}">
			<table cellspacing=1 width=400 border=0>
				<tr>
					<td width="200"></td>
					<td width="100"><p align="center">
							<input type="submit" value="수정">
						</p></td>
					<td width="100"><p align="center">
							<input type="button" value="취소"
								onclick="location.href='readOne.jsp?id=${boardItem.id}'">
						</p></td>
				</tr>
			</table>
		</c:if>
	</form>
	<p align="center">
		<input type="submit" value="삭제"
			onclick="location.href='deleteOne.jsp?id=${boardItem.id}'">
</body>
</html>