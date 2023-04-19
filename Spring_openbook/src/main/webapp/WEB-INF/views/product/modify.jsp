<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/WEB-INF/views/include/head.jsp" %>
    </head>
    <body>
        <%@ include file="/WEB-INF/views/include/nav.jsp" %> <%-- 페이지만의 내용 --%>
        <div class="container p-4">
            <h2>상품 정보 수정</h2>
            <form id="modifyForm" method="POST" action="modify">
                <div class="form-group">
                    <label for="productCode">고유번호</label>
                    <input
                        type="text"
                        class="form-control"
                        id="code"
                        name="code"
                        value="${product.code}"
                        placeholder="고유번호 입력"
                        readonly
                    />
                </div>
                <div class="form-group">
                    <label for="model">모델명</label>
                    <input
                        type="text"
                        class="form-control"
                        id="model"
                        name="model"
                        value="${product.model}"
                        placeholder="모델명 입력"
                    />
                </div>
                <div class="form-group">
                    <label for="price">가격</label>
                    <input
                        type="number"
                        class="form-control"
                        id="price"
                        name="price"
                        value="${product.price}"
                        placeholder="가격 입력"
                    />
                </div>

                <button type="submit" class="btn btn-primary" id="btn-modify">수정</button>
                <a class="btn btn-secondary" href="${root}/view?code=${product.code}"
                    >취소</a
                >
            </form>
        </div>
        <%-- --%>
        <%@ include file="/WEB-INF/views/include/footer.jsp" %>
    </body>
</html>
