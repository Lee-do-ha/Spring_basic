<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/WEB-INF/views/include/head.jsp" %>
    </head>
    <body>
        <%@ include file="/WEB-INF/views/include/nav.jsp" %> <%-- 페이지만의 내용 --%>
        <div class="container p-4">
            <h2>로그인</h2>
            <form id="loginForm" method="POST" action="login">
                <input type="hidden" name="action" value="" />
                <div class="form-group">
                    <label for="productCode">아이디</label>
                    <input
                        type="text"
                        class="form-control"
                        id="userId"
                        name="userId"
                        placeholder="아이디 입력"
                    />
                </div>
                <div class="form-group">
                    <label for="model">비밀번호</label>
                    <input
                        type="text"
                        class="form-control"
                        id="userPwd"
                        name="userPwd"
                        placeholder="비밀번호 입력"
                    />
                </div>

                <button type="submit" class="btn btn-primary" id="btn-login">로그인</button>
                <a class="btn btn-secondary" href="${root}/">취소</a>
            </form>
        </div>
        <%-- --%>
        <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    </body>
</html>
