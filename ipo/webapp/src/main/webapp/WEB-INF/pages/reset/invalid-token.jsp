<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="container w-xxl w-auto-xs" ng-controller="SigninFormController" ng-init="app.settings.container = false;">
       <a href="${ctx}/welcome.htm" class="navbar-brand block m-t"><spring:message code="invalid.token"/></a>
</div>
