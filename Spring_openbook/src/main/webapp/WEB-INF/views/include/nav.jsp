<%@page import="com.ssafy.openbook.model.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="userInfo" value="${userInfo}"></c:set>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav me-auto ms-5">
    	<c:if test="${not empty userInfo}">
	       <li class="nav-item">
	           <a class="nav-link" href="${root}/list">상품 목록</a>
	       </li>
	       <li class="nav-item">
	           <a class="nav-link" href="${root}/register">상품 정보 등록</a>
	       </li>
        </c:if>
    </ul>
    <ul class="navbar-nav me-5">
    	<c:if test="${empty userInfo}">
        	<li class="nav-item"><a class="nav-link" href="${root}/login">로그인</a></li>
       	</c:if>
        <c:if test="${not empty userInfo}">
	        <li class="nav-item">
	            <a class="nav-link" href="${root}/logout">로그아웃</a>
	        </li>
	    </c:if>
    </ul>
</nav>
