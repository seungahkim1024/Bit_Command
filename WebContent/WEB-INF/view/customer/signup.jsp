<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/signup.css" />
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">회원가입</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
<div class="input-group">
  <span class="input-group-addon" id="id">ID</span>
  <input type="text" class="form-control" placeholder="10자이내" aria-describedby="basic-addon1" name = "id">
</div>
<div class="input-group">
  <span class="input-group-addon" id="pass">비밀번호</span>
  <input type="text" class="form-control" placeholder="PASSWORD" aria-describedby="basic-addon1" name="pass">
</div>
<div class="input-group">
  <span class="input-group-addon" id="name" >이름</span>
  <input type="text" class="form-control" placeholder="Username" aria-describedby="basic-addon1" name="name">
</div>
<div class="input-group">
  <span class="input-group-addon" id="ssn" >주민번호</span>
  <input type="text" class="form-control" placeholder="예: 911024-2" aria-describedby="basic-addon1" name="ssn">
</div>
<div class="input-group">
  <span class="input-group-addon" id="address" >도로명</span>
  <input type="text" class="form-control" placeholder="예: 길음로33" aria-describedby="basic-addon1" name="address">
</div>
<div class="input-group">
  <span class="input-group-addon" id="city" >도시</span>
  <input type="text" class="form-control" placeholder="예: 서울" aria-describedby="basic-addon1" name="city">
</div>
<div class="input-group">
  <span class="input-group-addon" id="postalCode" >우편번호</span>
  <input type="text" class="form-control" placeholder="postalCode" aria-describedby="basic-addon1" name="postalCode">
</div>
<button type="button" class="btn btn-default btn-lg" id="cancel_btn">
  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> CANCLE
</button>
<button type="button" class="btn btn-default btn-lg" id="confirm_btn">
  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span> OK
</button>
		<input type="hidden" name="cmd" value="signup" />
	    <input type="hidden" name="page" value="signin" />
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	var id = $('#id').val();
	var name = $('#name').val();
	var pass = $('#pass').val();
	var ssn = $('#ssn').val();
	var address = $('#address').val();
	var city = $('#city').val();
	var postalCode = $('#postalCode').val();
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
</script>
