<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>통계</title>
</head>
<body>

<a href="stat.xls">엑셀다운, 확장자(stat.xls)</a> |
<a href="stat?format=xls">엑셀다운, 파라미터(stat?format=xls)</a>
<!-- 
<table border="1">
    <thead>
    <tr>
        <th>이름</th>
        <th>값1</th>
        <th>값2</th>
    </tr>
    </thead>
    <tbody>
    <tr th:each="row : ${rows}">
        <td th:text="${row.name}"></td>
        <td th:text="${#numbers.formatInteger(row.value1, 1, 'COMMA')}"></td>
        <td th:text="${#numbers.formatInteger(row.value2, 1, 'COMMA')}"></td>
    </tr>
    </tbody>
</table>
 -->
</body>
</html>