<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/employee/register.css" />
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">사원 등록</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
	<div class="grid-container">
	    <div class="grid-item" id="item_1">사원번호</div>
	    <div class="grid-item" id="item_2"><input type="text" id="empno" name="empno" ></div>
	    <div class="grid-item" id="item_3">이 름</div>
	    <div class="grid-item" id="item_4"><input type="text" id="name" name="name" ></div>
	    <div class="grid-item" id="item_5">매니저</div>
	    <div class="grid-item" id="item_6"><input type="text" id="manager" name="manager" ></div>
	    <div class="grid-item" id="item_7">생년월일</div>
	    <div class="grid-item" id="item_8"><input type="text" id="birthday" name="birthday" ></div>
	    <div class="grid-item" id="item_9">상 세</div>
	    <div class="grid-item" id="item_10"><input type="text" id="desc" name="desc" ></div>
	    <div class="grid-item" id="item_11"><input type="submit" id="confirm_btn" value='확 인'></div>
	    <div class="grid-item" id="item_12"><input type="reset" id="cancel_btn" value='취 소'> </div>
	    <input type="hidden" name="cmd" value="move" />
	    <input type="hidden" name="page" value="access" />
	</div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	var empno = $('#empno').val();
	var name = $('#name').val();
	var manager = $('#manager').val();
	var birthday = $('#birthday').val();
	var desc = $('#desc').val();
	$('#form')
	.attr('action', '${ctx}/employee.do')
	.submit();
});
</script>
