<%--
  Created by IntelliJ IDEA.
  User: zirui
  Date: 2022/1/11
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <c:choose>
        <%-- 情况1: 页码小于5, 页码范围:1-总页码 --%>
        <c:when test="${requestScope.page.pageTotal<=5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
            <%--					<c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">--%>
            <%--						<c:if test="${i!=requestScope.page.pageTotal}">--%>
            <%--							【${i}】--%>
            <%--						</c:if>--%>
            <%--						<c:if test="${i!=requestScope.page.pageNo}">--%>
            <%--							<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>--%>
            <%--						</c:if>--%>
            <%--					</c:forEach>--%>
        </c:when>

        <%-- 情况2: 总页码大于5 &ndash;%&gt;--%>
        <c:when test="${requestScope.page.pageTotal > 5}">
            <c:choose>
                <%-- 情况2.1: 当前页码为前三个, 页码范围1-5 --%>
                <c:when test="${requestScope.page.pageNo<=3}">
                    <c:set var="begin" value="1"></c:set>
                    <c:set var="end" value="5"></c:set>
                    <%--							<c:forEach begin="1" end="5" var="i">--%>
                    <%--								<c:if test="${i==requestScope.page.pageNo}">--%>
                    <%--									【${i}】--%>
                    <%--								</c:if>--%>
                    <%--								<c:if test="${i!=requestScope.page.pageNo}">--%>
                    <%--									<a href="manager/bookServlet?action=page&pageNo=${i}"> ${i} </a>--%>
                    <%--								</c:if>--%>
                    <%--							</c:forEach>--%>
                </c:when>
                <%-- 情况2.2: 当前页码为最后三个 --%>
                <c:when test="${requestScope.page.pageNo>requestScope.page.pageTotal-3}">
                    <c:set var="begin" value="${requestScope.page.pageTotal-4}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageTotal}"></c:set>
                    <%--							<c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">--%>
                    <%--								<c:if test="${i==requestScope.page.pageNo}">--%>
                    <%--									【${i}】--%>
                    <%--								</c:if>--%>
                    <%--								<c:if test="${i!=requestScope.page.pageNo}">--%>
                    <%--									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>--%>
                    <%--								</c:if>--%>
                    <%--							</c:forEach>--%>
                </c:when>
                <%-- 情况2.3: 当前页码为为中间页码 --%>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo-2}"></c:set>
                    <c:set var="end" value="${requestScope.page.pageNo+2}"></c:set>
                    <%--							<c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">--%>
                    <%--								<c:if test="${i==requestScope.page.pageNo}">--%>
                    <%--									【${i}】--%>
                    <%--								</c:if>--%>
                    <%--								<c:if test="${i!=requestScope.page.pageNo}">--%>
                    <%--									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>--%>
                    <%--								</c:if>--%>
                    <%--							</c:forEach>--%>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>

    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i==requestScope.page.pageNo}">
            【${i}】
        </c:if>
        <c:if test="${i!=requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
        </c:if>
    </c:forEach>

    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.totalItemCount}条记录 到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPageBtn" type="button" value="确定">
    <script type="text/javascript">
        $(function (){
            $("#searchPageBtn").click(function (){
                var pageNo = $("#pn_input").val();
                var pageTotal = ${requestScope.page.pageTotal};
                if (pageNo<1||pageNo>pageTotal){
                    alert("页码输入不正确");
                    return;
                }
                location.href = "${pageScope.basePath}${requestScope.page.url}&pageNo=" + pageNo;
            });
        });
    </script>
</div>