<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.BoardItemServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.BoardItemService"%>
<%@page import="kr.ac.kopo.ctc.kopo44.domain.BoardItem"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.Pagination"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시글 전체 삭제 완료</title>
</head>
<body>
	<%
	BoardItemService boardItemService = new BoardItemServiceImpl();

	Boolean result = boardItemService.boardItemDeleteAll();

	ServletContext context = getServletContext();
	context.setAttribute("result", result);
	%>
	<script>
	if(${result}){
		if (window.confirm("게시글이 전체 삭제되었습니다.")) {
			window.location.href = "index.jsp";
		}
	} else {
		window.confirm("게시글 전체 삭제 실패.")
	}
	
	</script>
</body>
</html>