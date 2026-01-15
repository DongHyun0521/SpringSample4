<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// SpringSample4 - message.jsp
	String message = (String)request.getAttribute("message");

	if (message != null && message.equals("") == false){
		if (message.equals("MEMBER_YES")) {
			%><script type="text/javascript">
			alert("[ 회원가입 성공 ]");
			location.href = "login.do";
			</script><%
		} else {
			%><script type="text/javascript">
			alert("[ 회원가입 실패 ]");
			location.href = "regi.do";
			</script><%
		}
	}
	
	String loginMsg = (String)request.getAttribute("loginMsg");

	if (loginMsg != null && loginMsg.equals("") == false){
		if (loginMsg.equals("LOGIN_YES")) {
			%><script type="text/javascript">
			alert("[ 로그인 성공 ]");
			location.href = "bbsList.do";
			</script><%
		} else {
			%><script type="text/javascript">
			alert("[ 로그인 실패 ]");
			location.href = "login.do";
			</script><%
		}
	}
	
	String bbsWriteMsg = (String)request.getAttribute("bbsWriteMsg");
	if (bbsWriteMsg != null && !bbsWriteMsg.equals("")){
		if (bbsWriteMsg.equals("BBSWRITE_YES")){
			%>
			<script type="text/javascript">
		   	alert("[ 글 작성 성공 ]");
		   	location.href = "bbsList.do";
		   	</script>
			<%	
		} else {
			%>
			<script type="text/javascript">
		   	alert("[ 글 작성 실패 ]");
		   	location.href = "bbsWrite.do";
		   	</script>
			<%
		}
	}
	
	String bbsUpdateMsg = (String)request.getAttribute("bbsUpdateMsg");
	if (bbsUpdateMsg != null && bbsUpdateMsg.equals("") == false){
		if (bbsUpdateMsg.equals("UPDATE_YES")){
			%>
			<script type="text/javascript">
			alert("[ 글 수정 성공 ]");
			location.href = "bbsList.do";
			</script>
			<%
		} else {
			Integer seq = (Integer)request.getAttribute("seq");
			%>
			<script type="text/javascript">
			alert("[ 글 수정 실패 ]");
			location.href = "bbsUpdate.do?seq=" + seq;
			</script>
			<%
		}
	}
	
	String bbsDeleteMsg = (String)request.getAttribute("bbsDeleteMsg");
	if(bbsDeleteMsg != null && bbsDeleteMsg.equals("") == false){
		if(bbsDeleteMsg.equals("DELETE_YES")){
			%>
			<script type="text/javascript">
			alert("[ 글 삭제 성공 ]");
			location.href = "bbsList.do";
			</script>
			<%
		}else{
			Integer seq = (Integer)request.getAttribute("seq");
			%>
			<script type="text/javascript">
			alert("[ 글 삭제 실패 ]");
			location.href = "bbsDetail.do?seq=" + <%=seq%>;
			</script>
			<%
		}	
	}
	
	String answerMsg = (String)request.getAttribute("answerMsg");
	if(answerMsg != null && answerMsg.equals("") == false){
		if(answerMsg.equals("ANSWER_YES")){
			%>
			<script type="text/javascript">
			alert("[ 답글 작성 성공 ]");
			location.href = "bbsList.do";
			</script>
			<%
		}else{
			Integer seq = (Integer)request.getAttribute("seq");
			%>
			<script type="text/javascript">
			alert("[ 답글 작성 실패 ]");
			location.href = "answer.do?seq=" + <%=seq%>;
			</script>
			<%
		}
	}
%>