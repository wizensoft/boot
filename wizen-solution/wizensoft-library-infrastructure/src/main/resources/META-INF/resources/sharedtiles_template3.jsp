<html xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:tiles="http://tiles.apache.org/tags-tiles" xmlns:c="http://java.sun.com/jsp/jstl/core" version="2.0">
<jsp:output doctype-root-element="HTML" doctype-system="about:legacy-compat" />
<jsp:directive.page contentType="text/html;charset=UTF-8" />
<jsp:directive.page pageEncoding="UTF-8" />
<jsp:output omit-xml-declaration="true" />
<head>
<c:url var="rootUrl" value="/resources/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<link rel="stylesheet" type="text/css" href="/resources/css/screen.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/openid.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/openid-shadow.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"/>
<script type="text/javascript" src="/resources/js/openid-jquery.js"/>
<script type="text/javascript" src="/resources/js/openid-en.js"/>
<script type="text/javascript">
//<![CDATA[
    $(document).ready(function() {
        openid.init('openid_identifier');
    });
//]]>   
</script>
<title>Mystery Shopping</title>
</head>
<body>
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
</body>
</html>