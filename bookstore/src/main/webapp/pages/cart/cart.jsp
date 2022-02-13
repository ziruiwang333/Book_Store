<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function (){
			$("a.deleteItemClass").click(function (){
				return confirm("确定要删除["+$(this).parent().parent().find("td:first").text()+"]?");
			});

			$("#clear").click(function (){
				return confirm("确定要清空购物车?");
			});

			// 绑定内容发生改变事件
			$("input.updateCountClass").change(function (){
				var name = $(this).parent().parent().find("td:first").text();
				var count = this.value;
				if(confirm("确定要将["+name+"]的数量修改为"+count+"?")){
					var id = $(this).attr("bookId");
					location.href = "http://localhost:8080/bookstore/cartServlet?action=updateCount&count="+count+"&id="+id;
				}else {
					this.value = this.defaultValue;
				}
			});

		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<div>
				<span>欢迎<span class="um_span">韩总</span>光临尚硅谷书城</span>
				<a href="pages/order/order.jsp">我的订单</a>
				<a href="index.jsp">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<%--购物车为空--%>
			<c:if test="${empty sessionScope.cart.items}">
				<td colspan="5">当前购物车为空!</td>
			</c:if>
			<%--购物车非空--%>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry">
					<tr>
						<td>${entry.value.name}</td>
						<td>
							<input class="updateCountClass" bookId="${entry.value.id}" style="text-align:center; width: 50px" type="text" value="${entry.value.count}">
						</td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItemClass" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>

		</table>

		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clear" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	
	</div>
	
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>