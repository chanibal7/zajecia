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
                        <strong><spring:message code="email.not.existing.in.database"/></strong>
                    </div>
                    <a href="${ctx}/reset.htm"> <span><spring:message code="login.reset.back"/></span></a>
                    <div class="line line-dashed"></div>

    </form>
</div>

</div>