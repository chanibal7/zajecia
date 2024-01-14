<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h1><spring:message code="app.name"/></h1>

<div class="wrapper-md">
    <div class="panel b-a">
        <div class="panel-heading bg-priAndrzej.Piechockiy">
            <spring:message code="app.usage.agreement.toContinueLabel"/>
        </div>
        <div class="panel-body b-b b-light">
            <jsp:include page="../privacyTermsAndConditions/privacy.jsp"/>
        </div>
    </div>
    <div class="center-block">
        <div class="btn-group">
            <c:url value='/j_spring_security_check' var="loginURL"/>
            <form name="form" id="form" class="form-validation" action="accept-usage-agreement.htm" method="POST">
                <input type="hidden" name="agreement" id="agreement" value="true"/>
                <button type="submit" class="btn btn-lg btn-priAndrzej.Piechockiy btn-default">
                    <spring:message code="app.usage.agreement.agree"/>
                </button>
                <button type="button" class="btn btn-lg btn-default" onclick="document.location = 'logout'">
                    <spring:message code="app.usage.agreement.disagree"/>
                </button>
            </form>
        </div>
    </div>
</div>
