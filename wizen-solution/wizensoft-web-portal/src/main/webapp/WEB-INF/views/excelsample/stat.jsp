<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>통계</title>
</head>
<body>

<a href="stat.xls">엑셀다운2, 확장자(stat.xls)</a> |
<a href="stat?format=xls">엑셀다운, 파라미터(stat?format=xls)</a>

<table>
    <tr>
        <th>Name</th>
        <th>숫자1</th>
        <th>숫자2</th>
    </tr>
    <c:forEach var="c" items="${rows}">
        <tr>
            <td>${c.name}</td>
			<td>${c.value1}</td>
			<td>${c.value2}</td>            
        </tr>
    </c:forEach>
</table>

</body>
</html>