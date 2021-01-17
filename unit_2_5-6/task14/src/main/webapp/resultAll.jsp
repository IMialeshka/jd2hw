<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>
<h1>Result</h1>
<table style="width:80%" border="1">
  <tr>
     <th>num</th>
     <th>paydate</th>
     <th>receiver</th>
      <th>value</th>
  </tr>
    <c:forEach items="${result}" var="item">
      <tr>
      <td>${item.num}</td>
      <td>${item.paydate}</td>
      <td>${item.receiver}</td>
      <td>${item.value}</td>
    </tr>
    </c:forEach>
</table>
<br/>
</body>
</html>