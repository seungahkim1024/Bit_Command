<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="../home/top.jsp"/>
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
    grid-template-columns: auto auto auto auto;
    grid-gap: 1px;
    background-color: white;
    padding: 50px;
    width: 300px;
    margin: auto;
    
}
.myphotoin{
    grid-column-start:2; 
    grid-column-end:4;
}
</style>
<div class="grid-item" id="navi_bar">
	<ul class="ul_navi_bar">
                 <li ><a href="home.do">홈으로</a></li>
                 <li ><a href="#">카테고리</a></li>
                 <li ><a href="#">사원</a></li>
                 <li ><a href="#">주문</a></li>
                 <li ><a href="#">상품</a></li>
                 <li ><a href="#">선박</a></li>
                 <li ><a href="#">공급업체</a></li>
     </ul>
</div>
<div class="grid-item" id= "side_bar">
<div class= "myphoto">
<div class= "myphotoin"><img src="${img}/default-user-image.png"  style="height: 250px; width: 150%; align : middle;"></div>
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
	<span id="update_btn" class="label label-warning">수 정</span>
</div>
<jsp:include page="../home/bottom.jsp"/>

<script>
$('#update_btn').click(function(){
	location.assign('${ctx}/customer.do?cmd=CUS_RETRIEVE&page=update&customerID=${cus.customerID}');
});
</script>    