<%@page import="com.mbc.pro.util.Util"%>
<%@page import="com.mbc.pro.dto.BbsParam"%>
<%@page import="com.mbc.pro.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mbc.pro.dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BbsDto> list = (List<BbsDto>)request.getAttribute("list");
	int pageBbs = (Integer)request.getAttribute("pageBbs");
	
	BbsParam param = (BbsParam)request.getAttribute("param");
	int pageNumber = param.getPageNumber();
	String category = param.getCategory();
	String keyword = param.getKeyword();
	if(keyword == null || keyword.equals("")){
		keyword = "";
		category = "start";
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>SpringSample4: bbsList.jsp</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
	<script type="text/javascript" src="jquery/jquery.twbsPagination.min.js"></script>
	
	<style type="text/css">
		.center {
			margin: auto;
			width: 1000px;
			text-align: center;
		}
		th {
			background-color: royalblue;
			color: white;
		}
		tr {
			line-height: 16px;
		}
		td {
			text-align: center;
			line-height: 16px;
		}
	</style>
</head>
<body>
	<h1><a href="bbsList.do" style="text-decoration:none; color:black;">
		[ 게시판 ]
	</a></h1>
	<div class="center">
		<table border="1">
		<col width="70"/><col width="600"/><col width="100"/><col width="150"/>
			<thead>
			<tr>
				<th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
			</tr>
			</thead>
			<tbody>
				<% if (list == null || list.size() == 0) { %>
				<tr>
					<td colspan="4">[ 작성된 글이 없습니다 ]</td>
				</tr>
				<% } else {
					for (int i = 0; i < list.size(); i++) {
						BbsDto bbs = list.get(i); %>
						<tr>
							<td><%=i + 1 %></td>
							<td style="text-align: left;">
							<%if (bbs.getDel() == 1) {%>
								<span style="color:red">= 삭제된 글입니다 =</span>
							<%} else {%>
								<a href="bbsDetail.do?seq=<%=bbs.getSeq() %>">
									<%=Util.arrow(bbs.getDepth()) %>
									<%=Util.dot3(bbs.getTitle()) %>
								</a>
							<%}%>
							</td>
							<td><%=bbs.getReadcount() %></td>
							<td><%=bbs.getId() %></td>
						</tr>
					<% }
				} %>
			</tbody>
		</table>
		<br/>

		<div class="container">
		    <nav aria-label="Page navigation">
		        <ul class="pagination" id="pagination" style="justify-content: center;"></ul>
		    </nav>
		</div>
		<br/>
		
		<div class="form-row align-items-center d-flex justify-content-center align-items-center container">
			<select id="category" class="form-control" style="width: auto;">
				<option value="start">검색</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="writer">작성자</option>
			</select>
			
			<div class="col-sm-3 my-1" style="width:auto;">
				<input type="text" class="form-control" id="keyword" value="<%=keyword %>"/>
			</div>
			
			<button type="button" onclick="searchBtn()">검색</button>
		</div>
		<br/>
		<a href="bbsWrite.do">글 작성</a>
	</div>
	
	<script type="text/javascript">
		let keyword = "<%=keyword %>";
		
		if (keyword != null){
			let category = document.getElementById("category");
			category.value = "<%=category %>";
			category.setAttribute("selected", "selected");
		}
		
		function searchBtn() {
			let category = document.getElementById("category").value;
			let keyword = document.getElementById("keyword").value;
			location.href = "bbsList.do?category=" + category + "&keyword=" + keyword;
		}
		
		$("#pagination").twbsPagination({
			startPage : <%=pageNumber+1 %>,
			totalPages : <%=pageBbs %>,
			visiblePages : 10,
			first : '<span srid-hidden="true">«</span>',	// 처음페이지로 이동
			prev : "이전",
			next : "다음",
			last : '<span srid-hidden="true">»</span>',
			initiateStartPageClick : false,	// 처음 실행시에 자동실행되지 않도록
			onPageClick : function(event, page){
				//alert(page);
				location.href = "bbsList.do?pageNumber=" + (page - 1)+ "&category=" + $("#category").val() + "&keyword=" + $("#keyword").val();
			}
		});
	</script>
</body>
</html>