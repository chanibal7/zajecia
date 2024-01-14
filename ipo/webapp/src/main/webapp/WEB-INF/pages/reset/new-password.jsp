<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="${ctx}/js/jquery.validate.min.js"></script>
<script src="${ctx}/js/resetPasswordValidator.js"></script>

<!-- content -->
  <div id="content" class="app-content" role="main">
    <div class="app-content-body ">
<div class="hbox hbox-auto-xs hbox-auto-sm" ng-init="
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
          <li><a href><i class="fa fa-home"></i> Home</a></li>
          <li><a href>Profile</a></li>
          <li class="active">Reset Password</li>
        </ul>
      </div>
  </div>
      <!-- / breadcrumb -->
      <div class="col-sm-6">
      
      <form:form modelAttribute="dto" action="set-password.htm" class="form-validation selector"  method="POST">
            <div class="panel panel-default">
            <div class="panel-heading">
              <strong><spring:message code="reset.password"/></strong>
            </div>
            <div class="panel-body">
              <div class="form-group">
             
              <div class="form-group has-error">
                <label class="col-sm-3 control-label"><spring:message code="change.password.new.password"/></label>
                <div class="col-sm-9">  
                  <form:input path="newPassword" autocomplete="off" name="masked" ui-mask="Examples: welcome2zajecia!, aBc123(4)" ng-model="bb" placeholder="Examples: welcome2zajecia!, aBc123(4)" class="form-control m-b"/>
                </div>
               </div>
               <div class="form-group has-success">
                <label class="col-sm-3 control-label"><spring:message code="change.password.retype.new.password"/></label>
                <div class="col-sm-9">  
                  <form:input path="confirmedNewPassword" autocomplete="off" name="masked" ui-mask="**:AAA-999" ng-model="cc" placeholder="" class="form-control m-b"/>
                  <form:input path="token" type="hidden" name="token"/>
                </div>
               </div>
                <label class="col-sm-3 control-label"><spring:message code="change.password.requirements.password"/></label>
                <div class="col-sm-9">  
                  <p class="m-b">
                    <div id="rule1"><spring:message code="change.password.requirements.password.8char"/><code>8</code></div>
                     <div id="rule2"><spring:message code="change.password.requirements.password.upper"/><code class="text-success">ABC</code></div>
                     <div id="rule3"><spring:message code="change.password.requirements.password.lower"/><code>abc</code></div>
                     <div id="rule4"><spring:message code="change.password.requirements.password.special"/><code class="text-success">(^°!"§$%&/()=?`´\}][{+*~#'-.,;:_<>|)</code></div>
                     <div id="rule5"><spring:message code="change.password.requirements.password.digit"/><code>123</code></div>
                </p>
                </div> 

                </div>
                
              </div>
             <footer class="panel-footer text-right bg-light lter">
                <a href="${ctx}/login.htm"><form:button type="button" class="btn m-b-xs w-xs disabled"><spring:message code="cancel"/></form:button></a>
              <form:button type="submit" class="btn m-b-xs w-xs btn-success" id="changePassSave"><spring:message code="save"/></form:button>
            </footer>
            
            </div>

      </form:form>

         
          </div>
        

        
  </div>
  <!-- / main -->
</div>


    </div>
  </div>
  <!-- / content -->