<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" 
	href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">고객 목록</font>
 	</h1>
</div>
<div class="grid-item" id="content">
	<table id="cust_tab">
	  <tr>
	    <th>No.</th>
	    <th>I D</th>
	    <th>이 름</th>
	    <th>생년월일</th>
	    <th>성 별</th>
	    <th>전화번호</th>
	    <th>우편번호</th>
	    <th>지번주소</th>
	    <th>상세주소</th>
	  </tr>
	  <c:forEach items="${list}" var="cus">
	  <tr>
	    <td>${cus.no}</td>
	    <td>${cus.customerID}</td>
	    <td><a href="${ctx}/customer.do?cmd=cus_retrieve&page=detail&customerID=${cus.customerID}">${cus.customerName}</a></td>
	    <td>${cust.ssn}</td>
	    <td>남</td>
	    <td>${cus.phone}</td>
	    <td>${cus.postalCode}</td>
	    <td>${cus.city}</td>
	    <td>${cus.address}</td>
	  </tr>
	  </c:forEach>
	  
	</table>
	<div style="height: 50px"></div>    
	<div class="center">
	  <div class="pagination" >
	  <c:if test="${pagination.existPrev}">
		  <a href='${ctx}/customer.do?cmd=cus_list&page=list&page_num=${pagination.prevBlock}'>&laquo;</a>
	  </c:if>
	  <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" varStatus="status">
	  <c:choose>
	  	<c:when test="${pagination.pageNum eq status.index}">
	  		<a href="#" class="page active">${status.index}</a>	
	  	</c:when>
	  	<c:otherwise>
	  		<a href="#" class="page">${status.index}</a>
	  	</c:otherwise>
	  </c:choose>
	  
	  </c:forEach>
	  <c:if test="${pagination.existNext}">
		  <a href="${ctx}/customer.do?cmd=cus_list&page=list&page_num=${pagination.nextBlock}">&raquo;</a>
	  </c:if>
	  </div>
	</div>
</div>

<jsp:include page="../home/bottom.jsp"/>

<script>
$('.page').click(function(){ //$옆엔 id를 줄 수 없다. 이유는 요소들이 여러가지여야하는데 아이디는 유니크하니까.
	location.assign('${ctx}/customer.do?cmd=cus_list&page=list&page_num='+$(this).text());
});
</script>