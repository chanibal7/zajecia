<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/resetPasswordValidator.js"></script>

<!-- content -->
<div id="content" class="app-content" role="main">
	<div class="app-content-body ">
		<div class="hbox hbox-auto-xs hbox-auto-sm"
			ng-init="
    app.settings.asideFolded = false; 
    app.settings.asideDock = false;
  ">
			<!-- main -->
			<div class="col-sm-12">
				<!-- main header -->
				<!-- breadcrumb -->
				<div>
					<h4></h4>
					<ul class="breadcrumb bg-white b-a">
						<li><a href="${ctx}/welcome.htm"><i class="fa fa-home"></i>
								Home</a></li>
						<li><a href>Profile</a></li>
						<li class="active">Change Password</li>
					</ul>
				</div>
			</div>

			<form:form modelAttribute="dto" action="set-new-password.htm"
				class="form-validation selector" method="POST">
				<!-- / breadcrumb -->

				<div class="col-sm-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<strong><spring:message
									code="change.password.current.password" /></strong>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-3 control-label"><spring:message
										code="change.password.current.password" /></label>
								<div class="col-sm-9">
									<form:input path="currentPassword" type="text"
										autocomplete="off" autofocus="true" name="masked"
										ui-mask="(999) 999-9999" ng-model="aa"
										class="form-control m-b" />
								</div>
								<div class="form-group has-error">
									<label class="col-sm-3 control-label"><spring:message
											code="change.password.new.password" /></label>
									<div class="col-sm-9">
										<form:input path="newPassword" name="masked"
											autocomplete="off"
											ui-mask="Examples: welcome2zajecia!, aBc123(4)" ng-model="bb"
											placeholder="Examples: welcome2zajecia!, aBc123(4)"
											class="form-control m-b" />
									</div>
								</div>
								<div class="form-group has-success">
									<label class="col-sm-3 control-label"><spring:message
											code="change.password.retype.new.password" /></label>
									<div class="col-sm-9">
										<form:input path="confirmedNewPassword" autocomplete="off"
											name="masked" ui-mask="**:AAA-999" ng-model="cc"
											placeholder="" class="form-control m-b" />
									</div>
								</div>
								<c:if test="${not empty error}">
									<spring:message code="${error}" />
								</c:if>
								<label class="col-sm-3 control-label"><spring:message
										code="change.password.requirements.password" /></label>
								<div class="col-sm-9">
									<p class="m-b">
									<div id="rule1">
										<spring:message
											code="change.password.requirements.password.8char" />
										<code>8</code>
									</div>
									<div id="rule2">
										<spring:message
											code="change.password.requirements.password.upper" />
										<code class="text-success">ABC</code>
									</div>
									<div id="rule3">
										<spring:message
											code="change.password.requirements.password.lower" />
										<code>abc</code>
									</div>
									<div id="rule4">
										<spring:message
											code="change.password.requirements.password.special" />
										<code class="text-success">(^°!"§$%&/()=?`´\}][{+*~#'-.,;:_<>|)</code>
									</div>
									<div id="rule5">
										<spring:message
											code="change.password.requirements.password.digit" />
										<code>123</code>
									</div>
									</p>
								</div>

							</div>
						</div>
						<footer class="panel-footer text-right bg-light lter">
							<a href="${ctx}/login.htm"><button
									class="btn m-b-xs w-xs disabled">
									<spring:message code="cancel" />
								</button></a>
							<button type="submit" class="btn m-b-xs w-xs btn-success"
								id="changePassSave">
								<spring:message code="save" />
							</button>
						</footer>
					</div>



				</div>
			</form:form>



		</div>
		<!-- / main -->
	</div>


</div>
</div>
<!-- / content -->