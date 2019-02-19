<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    
<jsp:include page="../home/top.jsp"/>
<jsp:include page="../employee/nav.jsp"/>

<style>
.mypage{
    display: grid;
    grid-template-columns: auto auto auto auto;
    grid-gap: 1px;
    background-color: white;
    padding: 50px;
    width: 600px;
    margin: auto;
}
.mypage1 {
grid-column-start:1; 
grid-column-end:3;
}
.mypage2 {
grid-column-start:3; 
grid-column-end:5;
}
.myphoto {
    display: grid;
    grid-gap: 1px;
    background-color: white;
    padding: 20px;
    width: 300px;
    margin: auto;
    
}
.myphotoin{
    grid-column-start:2; 
    grid-column-end:4;
}
</style>

<div class="grid-item" id= "side_bar">
<div class= "myphoto">
	<div class= "myphotoin">
		<form id="file_form">
			<img src="${img}${image.imgName}.${image.imgExtention}" style="height: 200px; width: 200%;">
			<input type="file" name="file_upload"/>
			<input type="submit" id="file_upload_btn"/>
			<!-- <input type="hidden" name="cmd" value="cust_file_upload"/>
			<input type="hidden" name="page" value="detail"/> -->
		</form>
	</div>
		
</div>
</div>
<div class="grid-item" id= "content">
	<div class ="mypage">
		<div class ="mypage1">
		아이디:<br />
		이름: <br />
		생년월일:<br />
		성별:<br />
		전화번호:<br />
		주소:<br />
		상세주소:<br />
		우편번호:<br />
		</div>
		<div class ="mypage2">
		${cus.customerID} <br />
		${cus.customerName} <br />
		${cus.ssn} <br />
		남 <br />
		${cus.phone} <br />
		${cus.city} <br />
		${cus.address} <br />
		${cus.postalCode} <br />
		</div>
	</div>
</div>
<div class="grid-item">
	<span id="update_btn" class="label label-warning">${cus.customerName}</span>
</div>
<div class="grid-item1">
	<span id="photo_btn" class="label label-warning">사진수정</span>
</div>
<jsp:include page="../home/bottom.jsp"/>

<script>
$('#update_btn').click(function(){
	location.assign('${ctx}/customer.do?cmd=CUS_RETRIEVE&page=update&customerID=${cus.customerID}');
});
$('#file_upload_btn').attr('style','cursor:pointer').click(function(){
	$('#file_form')
	.attr('method','post')
	.attr('action','${ctx}/customer.do?cmd=CUST_FILE_UPLOAD&page=detail&customer_id=${cus.customerID}')
	.attr('enctype','multipart/form-data')
	.submit();
});
</script>    