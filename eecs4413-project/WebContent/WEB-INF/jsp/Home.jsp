<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet"
      href="${pageContext.servletContext.contextPath}/test/css/styleSheet.css"
      type="text/css" />
    <link rel="icon" type="image/png"
      href="${pageContext.servletContext.contextPath}/test/img/logo-small.png" />
    <title>Food R Us</title>
  </head>
  <body>
    <div class="center">
      <a href="action/login"> Login </a>
      <a href="action/addItem"> Items </a>
    </div>
    <c:if test="${not empty items}">
    <table>
      <c:forEach items="${items}" var="item">
        <tr>
          <td>${item.name}</td>
        </tr>
      </c:forEach>
    </table>
    </c:if>
  </body>
</html>