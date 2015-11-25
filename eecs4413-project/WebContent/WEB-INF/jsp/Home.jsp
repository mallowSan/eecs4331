<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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

    <div class="header">
      <!-- Logo image -->
      <div class="inline" style="margin:10px">
        <h2>Food For Us</h2>
      </div>
      <!-- navBar -->
      <div >
        <ul>
          <li><a href="">Home</a></li>
          <li><a href="action/addItem">Add Item</a></li>
          <li><a href="action/removeItem">Remove Item</a></li>
          <li><a href="action/login">Login</a></li>
        </ul>
      </div>
    </div>
  </div>
    <form action="action/login" method="post">
      <input type="submit" name="submit" value="submit" /> 
      <input type="text"name="name"  value="name" />
    </form>
 </body>
</html>