<%@page import="com.mbc.pro.dto.BbsDto"%>
<%@page import="com.mbc.pro.dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	//BbsDao dao = BbsDao.getInstance();
	BbsDto dto = new BbsDto();
	
	dto.setSeq(seq);
	//dto = dao.bbsDetail(dto);
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSPModelOne - bbsDelete.jsp</title>
</head>
<body>
	<div align="center">
        <h2>= 글 삭제 =</h2>
        <p>정말 삭제하시겠습니까?</p>

        <form action="./bbs" method="post" style="display:inline;">
            <input type="hidden" name="param" value="bbsDeleteAf">
            <input type="hidden" name="seq" value="<%=seq%>">
            <button type="submit">삭제</button>
        </form>

        <button type="button" onclick="location.href='./bbs?param=bbsDetail&seq=<%=seq%>'">삭제 취소</button>
        <button type="button" onclick="location.href='./bbs?param=bbsList'">글 목록</button>
    </div>
</body>
</html>