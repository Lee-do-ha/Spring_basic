<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/WEB-INF/views/include/head.jsp" %>
    </head>
    <body>
        <%@ include file="/WEB-INF/views/include/nav.jsp" %> <%-- 페이지만의 내용 --%>
        <div class="container p-4">
            <h2>상품 목록</h2>

            <table class="table">
                <thead>
                    <tr>
                        <th>고유번호</th>
                        <th>모델명</th>
                        <th>가격</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>
                                <a href="${root}/view?code=${product.code}"
                                    >${product.code}</a
                                >
                            </td>
                            <td>${product.model}</td>
                            <td>${product.price}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <%-- --%>
        <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    </body>
</html>
