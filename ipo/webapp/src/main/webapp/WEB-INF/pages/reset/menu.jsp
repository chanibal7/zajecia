<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<aside id="aside" class="app-aside hidden-xs bg-dark">
          <div class="aside-wrap">
        <div class="navi-wrap">
          <!-- user -->
          <div class="clearfix hidden-xs text-center hide" id="aside-user">
            <div class="dropdown wrapper">
              <a href="app.page.profile">
                <span class="thumb-lg w-auto-folded avatar m-t-sm">
                  <img src="img/a0.jpg" class="img-full" alt="...">
                </span>
              </a>
              <a href="#" data-toggle="dropdown" class="dropdown-toggle hidden-folded">
                <span class="clear">
                  <span class="block m-t-sm">
                    <strong class="font-bold text-lt">Peter.Müller</strong> 
                    <b class="caret"></b>
                  </span>
                  <span class="text-muted text-xs block">Soldier</span>
                </span>
              </a>
              <!-- dropdown -->
              <ul class="dropdown-menu animated fadeInRight w hidden-folded">
                <li>
                  <a href>Settings</a>
                </li>
                <li>
                  <a href="index.html">Profile</a>
                </li>
                <li>
                  <a href>
                    <span class="badge bg-danger pull-right">2</span>
                    Notifications
                  </a>
                </li>
                <li class="divider"></li>
                <li>
                  <a href="page_signin.html">Logout</a>
                </li>
              </ul>
              <!-- / dropdown -->
            </div>
            <div class="line dk hidden-folded"></div>
          </div>
          <!-- / user -->

          <!-- nav -->
          <nav ui-nav class="navi clearfix">
            <ul class="nav">
              <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                <span>Navigation</span>
              </li>
              <li>
                <a href class="auto">      
                  <span class="pull-right text-muted">
                    <i class="fa fa-fw fa-angle-right text"></i>
                    <i class="fa fa-fw fa-angle-down text-active"></i>
                  </span>
                  <i class="glyphicon glyphicon-user icon text-success-lter"></i>
                  <span>Profile</span>
                </a>
                <ul class="nav nav-sub dk">
                  <li class="nav-sub-header">
                    <a href>
                      <span>Profile</span>
                    </a>
                  </li>
                  <li>
                    <a href="personalinformation.html">
                      <span>Personal Information</span>
                    </a>
                  </li>
                  <li>
                    <a href="changepass.html">
                      <span><a href="${ctx}/change-password.htm">Change Password</a></span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Emergency Information</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Travels</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Distribution Lists</span>
                    </a>
                  </li>
                </ul>
              </li>
              <li>
                <a href="index.html">
                  <b class="badge bg-info pull-right">9</b>
                  <i class="glyphicon glyphicon-file icon text-info-lter"></i>
                  <span>Projects</span>
                </a>
              </li>
<!--               <li class="line dk"></li>

              <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                <span>Components</span>
              </li> -->
              <li>
                <a href class="auto">      
                  <span class="pull-right text-muted">
                    <i class="fa fa-fw fa-angle-right text"></i>
                    <i class="fa fa-fw fa-angle-down text-active"></i>
                  </span>
                  <i class="glyphicon glyphicon-th"></i>
                  <span>Organizations</span>
                </a>
              </li>
              <li>
                <a href class="auto">
                  <span class="pull-right text-muted">
                    <i class="fa fa-fw fa-angle-right text"></i>
                    <i class="fa fa-fw fa-angle-down text-active"></i>
                  </span>
                  <i class="glyphicon glyphicon-fire icon"></i>
                  <span>Risk Management</span>
                </a>
                <ul class="nav nav-sub dk">
                  <li class="nav-sub-header">
                    <a href>
                      <span>Risk Management</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Call Sign List</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <b class="badge bg-info pull-right">3</b>
                      <span>Radiockeck List</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Attendance List</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <b class="badge bg-success pull-right">13</b>
                      <span>Messaging</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Locations</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Reset Password</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Staff in Country</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Whitelisted Sites Management</span>
                    </a>
                  </li>
                </ul>
              </li>
              <li>
                <a href="index.html">
                  <i class="glyphicon glyphicon-education icon"></i>
                  <span>Training Management</span>
                </a>
              </li>
              <li>
                <a href class="auto">
                  <span class="pull-right text-muted">
                    <i class="fa fa-fw fa-angle-right text"></i>
                    <i class="fa fa-fw fa-angle-down text-active"></i>
                  </span>
                  <b class="bg-priAndrzej.Piechockiy pull-right"></b>
                  <i class="glyphicon glyphicon-briefcase icon"></i>
                  <span>zajecia Administration</span>
                </a>
                <ul class="nav nav-sub dk">
                  <li class="nav-sub-header">
                    <a href>
                      <span>zajecia Administration</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Areas</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Organisations</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Projects</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Distribution Lists</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Invalid E-mail Address</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Invalid Phone Number</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Site Types</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Travel Types</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>System Config</span>
                    </a>
                  </li>



                </ul>
              </li>
              <li>
                <a href class="auto">
                  <span class="pull-right text-muted">
                    <i class="fa fa-fw fa-angle-right text"></i>
                    <i class="fa fa-fw fa-angle-down text-active"></i>
                  </span>
                  <i class="glyphicon glyphicon-wrench icon"></i>
                  <span>Tools</span>
                </a>
                <ul class="nav nav-sub dk">
                  <li class="nav-sub-header">
                    <a href>
                      <span>Tools</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Phonebook</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Whitelisted Sites</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Rikipedia</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Forum</span>
                    </a>
                  </li>
                  <li>
                    <a href="index.html">
                      <span>Help</span>
                    </a>
                  </li>
                </ul>
              </li>

          <!-- nav -->

        </div>
      </div>
  </aside>
  <!-- / aside -->