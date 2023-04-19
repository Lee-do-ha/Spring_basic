<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/WEB-INF/views/include/head.jsp" %>
    </head>
    <body>
        <%@ include file="/WEB-INF/views/include/nav.jsp" %> <%-- 페이지만의 내용 --%>
        <div class="container p-4">
            <h2>상품 조회</h2>

            <table class="table">
                <tbody>
                    <tr>
                        <th>고유번호:</th>
                        <td>${product.code}</td>
                    </tr>
                    <tr>
                        <th>모델명:</th>
                        <td>${product.model}</td>
                    </tr>
                    <tr>
                        <th>가격:</th>
                        <td>${product.price}</td>
                    </tr>
                </tbody>
            </table>
            <a class="btn btn-outline-primary" href="${root}/list">목록</a>
            
            <a
                class="btn btn-outline-success"
                href="${root}/modify?code=${product.code}"
                >수정</a
            >
            <a
                class="btn btn-outline-danger"
                href="${root}/delete?code=${product.code}"
                >삭제</a
            >
        </div>
        <%-- --%> <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    </body>
</html>
