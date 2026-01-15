<%@page import="com.mbc.pro.dto.BbsComment"%>
<%@page import="java.util.List"%>
<%@page import="com.mbc.pro.dto.MemberDto"%>
<%@page import="com.mbc.pro.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	BbsDto dto = (BbsDto)request.getAttribute("dto");

	List<BbsComment> commentList = (List<BbsComment>)request.getAttribute("commentList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SpringSample4: bbsDetail.jsp</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<style type="text/css">
		table, th, td {
			border: 2px solid black;
			border-collapse: collapse;
		}
	</style>
</head>
<body>
	<div align="center">
		<h1>[ 글 상세 ]</h1>
		<table>
		<col width="200px"/><col width="400px"/> 
			<tr>
				<th>작성자</th><td><%=dto.getId()%></td>
			</tr>
			<tr>
				<th>작성일</th><td><%=dto.getWdate()%></td>
			</tr>
			<tr>
				<th>조회수</th><td><%=dto.getReadcount()%></td>
			</tr>
			<tr>
				<th>제목</th><td><%=dto.getTitle()%></td>
			</tr>
			<tr>
				<th>내용</th>
				<th><textarea rows="15" cols="90" readonly="readonly"><%=dto.getContent()%></textarea></th>
			</tr>
		</table>
		<br/>
		
		<button type="button" onclick="answer(<%=dto.getSeq()%>)">답글 달기</button>
		
		<button type="button" onclick="location.href='bbsList.do'">글 목록</button>
		<%
			MemberDto mem = (MemberDto)session.getAttribute("login");
			
			if (mem.getId().equals(dto.getId())) {%>
			<button type="button" onclick="bbsUpdate(<%=dto.getSeq()%>)">글 수정</button>
			<button type="button" onclick="bbsDelete(<%=dto.getSeq()%>)">글 삭제</button>
		<%}%>
		<br/><br/>
		
		<!-- 댓글 작성 칸 -->
		<div>
		<form action="commentWriteAf.do" method="POST">
			<input type="hidden" name="bbsSeq" value="<%=dto.getSeq() %>">
	        <input type="hidden" name="id" value="<%=mem.getId()%>">
			<table>
				<tr>
					<th>작성자: <%=dto.getId()%></th>
					<td rowspan="2">
						<button type="submit">
							<br/>댓글 작성 완료<br/><br/>
						</button>
					</td>
				</tr>
				<tr>
					<td>
						<textarea rows="5" cols="50" name="content" placeholder="댓글 입력..."></textarea>
					</td>
				</tr>
			</table>
		</form>
		</div>
		<br/>
		
		<!-- 댓글 목록 -->
		<div>
		<%if(commentList != null && commentList.size() > 0){
			for (BbsComment comm: commentList) {%>
			<table>
				<tr>
					<th>작성자: <%=comm.getId()%></th>
					<td>작성시간: <%=comm.getWdate()%></td>
				</tr>
				<tr>
					<td><%=comm.getContent()%></td>
				</tr>
			</table>
			<br/>
			<%}
		} else {%>
			<br/><h4>첫번째 댓글을 작성해보세요!</h4>
		<%}%>
		</div>
	</div>
	
	<script type="text/javascript">
		function bbsUpdate(seq) {
			location.href = "bbsUpdate.do?seq=" + seq;
		}
		function bbsDelete(seq) {
			location.href = "bbsDelete.do?seq=" + seq;
		}
		function answer(seq) {
		    location.href = "answer.do?seq=" + seq;
		}
	</script>
</body>
</html>