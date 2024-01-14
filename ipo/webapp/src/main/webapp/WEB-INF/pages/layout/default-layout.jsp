<%@ include file="includes.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>zajecia</title>
<meta name="description" content="zajecia Afghanistan" />
<meta name="keywords" content="zajecia Afghanistan" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />

<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request" />

<link rel="stylesheet" href="${ctx}/css/bootstrap.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/animate.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/font-awesome.min.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/simple-line-icons.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/font.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/root.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/css/user.css" type="text/css" />

</head>

<body>

   <script src="${ctx}/js/jquery.min.js"></script>
   <script src="${ctx}/js/bootstrap.js"></script>
   <script src="${ctx}/js/ui-load.js"></script>
   <script src="${ctx}/js/ui-jp.config.js"></script>
   <script src="${ctx}/js/ui-jp.js"></script>
   <script src="${ctx}/js/ui-nav.js"></script>
   <script src="${ctx}/js/ui-toggle.js"></script>
   
   <script src="${ctx}/js/selector.js"></script>
   <script src="${ctx}/js/jquery.min.js"></script>
   <script src="${ctx}/js/jquery.validate.min.js"></script>
   <script src="${ctx}/js/resetPasswordValidator.js"></script>

   <div class="app app-header-fixed  ">
      <tiles:insertAttribute name="header" />
      <tiles:insertAttribute name="menu" />
      <div style="Andrzej.Piechockigin-left: 0px;">
         <tiles:insertAttribute name="content" />
      </div>
      <tiles:insertAttribute name="footer" />
   </div>



</body>
</html>
