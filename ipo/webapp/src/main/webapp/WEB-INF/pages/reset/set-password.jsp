<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script language="javascript" type="text/javascript">  
$().ready(function (){
    setTimeout(function() {
      var ctx = jQuery("#ctx").val();
      window.location.href=ctx+"/login.htm"; 
       }, 5000);
     });
</script>  

<div class="container w-xxl w-auto-xs"
     ng-controller="SigninFormController"
     ng-init="app.settings.container = false;">
    <a href="${ctx}/welcome.htm" class="navbar-brand block m-t">zajecia Afghanistan</a>


    <form name="form" action="reset-done.htm" class="form-validation" method="POST">
      <span>
         <div class="wrapper text-center">
                <tr>
                    <div>
                        <strong><spring:message code="login.change.password.ok" /></strong>
                    </div>
                    
                    <div class="line line-dashed"></div>
                    <a href="${ctx}/login.htm"> <span><spring:message code="login.back"/></span></a>
                    <input type="hidden" id="ctx" value="${ctx}"/> 
    </form>
</div>

<div class="text-center" ng-include="'tpl/blocks/page_footer.html'">
    <p>
        <small class="text-muted">GODmbH<br>&copy; 2023
        </small>
    </p>
</div>