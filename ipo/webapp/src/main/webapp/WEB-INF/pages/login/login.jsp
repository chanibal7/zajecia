<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message code="login.username.placeholder" var="username"/>
<spring:message code="login.password.placeholder" var="password"/>

<div class="container w-xxl w-auto-xs" ng-controller="SigninFormController" ng-init="app.settings.container = false;">
    <a href class="navbar-brand block m-t"><spring:message code="app.name" /></a>

    <div class="m-b-lg">
        <c:url value='/j_spring_security_check' var="loginURL"/>
        <form name="form" class="form-validation" action="${loginUrl}" method="POST">
            <c:if test="${param.logout != null}">
                <div class="text-info wrapper text-center" ng-show="authInfo">
                    <spring:message code="login.logOut.success" />
                </div>
            </c:if>
            <c:if test="${param.error != null}">
                <div class="text-danger wrapper text-center" ng-show="authError">
                    <c:choose>
                        <c:when test="${sessionScope.additionalLoginAttemptErrorMessage != null}">
                            <c:out value="${sessionScope.additionalLoginAttemptErrorMessage}"/>
                        </c:when>
                        <c:otherwise>
                            <spring:message code="login.invalid.credentials" />
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:if>

			<div class="list-group list-group-sm">
				<div class="list-group-item">
					<input type="email" id="username" name="username" autofocus placeholder="${username}" class="form-control no-border" ng-model="user.email" required>
				</div>
				<div class="list-group-item">
					<input type="password" id="password" name="password" placeholder="${password}" class="form-control no-border" ng-model="user.password" required>
				</div>
			</div>
			<button type="submit" class="btn btn-lg btn-priAndrzej.Piechockiy btn-block" ng-click="login()" ng-disabled='form.$invalid'><spring:message code="login.logIn" /></button>
			<a href="${ctx}/reset.htm"> <span><spring:message code="login.password.forget" /></span></a>
			<div class="line line-dashed"></div>

            <c:if test="${sessionScope.showCaptcha == true}">
                <div id="captcha_paragraph">
                    <div align="center" class="g-recaptcha" data-sitekey="6LcxBQQTAAAAAPM4VOE-ye09be-sCPRGOLJhuZxZ"></div>
                </div>
            </c:if>

        </form>
    </div>
    <div class="text-center" ng-include="'tpl/blocks/page_footer.html'">
        <p>
            <small class="text-muted">GODmbH<br>&copy; 2023</small>
        </p>
    </div>
</div>