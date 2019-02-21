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
 	<h1><font style="font-size: 30px">상품 목록</font>
 	</h1>
</div>
<div class="grid-item" id="content">
	<table id="cust_tab">
	  <tr>
	    <th>상품 번호</th>
	    <th>상품 이름</th>
	    <th>제조사</th>
	    <th>카테고리</th>
	    <th>상세설명</th>
	    <th>가격</th>
	  </tr>
	  <c:forEach items="${proList}" var="pro">
	  <tr>
	    <td>${pro.productId}</td>
	    <td><a href="${ctx}/product.do?cmd=PRO_LIST&page=detail&productId=${pro.productId}">${pro.productName}</a></td>
	    <td>${pro.supplierId}</td>
	    <td>${pro.categoryId}</td>
	    <td>${pro.unit}</td>
	    <td>${pro.price}</td>
	  </tr>
	  </c:forEach>
	  
	</table>
	<div style="height: 50px"></div>    
	<div class="center">
	  <div class="pagination" >
	  <c:if test="${pagination.existPrev}">
		  <a href='${ctx}/product.do?cmd=PRO_LIST&page=list&page_num=${pagination.prevBlock}'>&laquo;</a>
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
		  <a href="${ctx}/product.do?cmd=PRO_LIST&page=list&page_num=${pagination.nextBlock}">&raquo;</a>
	  </c:if>
	  </div>
	</div>
</div>

<jsp:include page="../home/bottom.jsp"/>

<script>
$('.page').click(function(){ //$옆엔 id를 줄 수 없다. 이유는 요소들이 여러가지여야하는데 아이디는 유니크하니까.
	location.assign('${ctx}/product.do?cmd=PRO_LIST&page=list&page_num='+$(this).text());
});
</script>