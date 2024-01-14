<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>zajecia</title>
    <meta name="description" content="zajecia Afghanistan"/>
    <meta name="keywords" content="zajecia Afghanistan"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>

    <c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>

    <link rel="stylesheet" href="${ctx}/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/font-awesome.min.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/font.css" type="text/css"/>
    <link rel="stylesheet" href="${ctx}/css/root.css" type="text/css"/>

    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/bootstrap.js"></script>

</head>
<body>

<div class="app app-header-fixed  ">
    <tiles:insertAttribute name="content"/>
</div>

<div class="text-center" ng-include="'tpl/blocks/page_footer.html'">
    <p>
        <small class="text-muted">GODmbH<br>&copy; 2023</small>
    </p>
</div>

</body>
</html>