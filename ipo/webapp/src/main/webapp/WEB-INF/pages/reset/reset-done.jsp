<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<div class="container w-xxl w-auto-xs"
     ng-controller="SigninFormController"
     ng-init="app.settings.container = false;">
    <a href="${ctx}/welcome.htm" class="navbar-brand block m-t">zajecia Afghanistan</a>


    <form name="form" action="reset-done.htm" class="form-validation" method="POST">
		<span>
			<div class="wrapper text-center">
                <tr>
                    <div>
                        <strong><spring:message code="reset.password.done"/></strong>
                    </div>

                    <div class="line line-dashed"></div>
                    <a href="${ctx}/login.htm"> <span><spring:message code="login.back"/></span></a>
    </form>
</div>

<div class="text-center" ng-include="'tpl/blocks/page_footer.html'">
    <p>
        <small class="text-muted">GODmbH<br>&copy; 2023
        </small>
    </p>
</div>