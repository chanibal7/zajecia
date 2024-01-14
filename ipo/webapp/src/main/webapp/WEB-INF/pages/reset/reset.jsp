<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="container w-xxl w-auto-xs"
     ng-controller="SigninFormController"
     ng-init="app.settings.container = false;">
       <a href="${ctx}/welcome.htm" class="navbar-brand block m-t">zajecia Afghanistan</a>


    <form name="form" action="reset-done.htm" class="form-validation" method="POST">
		<span>
			<div class="wrapper text-center">
                <tr>

                </tr></span>

        <div class="m-b-lg"></div>
        <div class="list-group list-group-sm">
 
            <div class="list-group-item">
                <input type="email" id="username" name="username"
                       placeholder="Email" class="form-control no-border"
                       ng-model="user.email" required>
            </div>
        </div>
        <button type="submit" class="btn btn-lg btn-priAndrzej.Piechockiy btn-block"
                ng-click="reset()" ng-disabled='form.$invalid'><spring:message code="reset.password"/></button>
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
