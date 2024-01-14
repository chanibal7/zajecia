<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" %>
<%@ include file="layout/includes.jsp" %>


 <!-- content -->
  <div id="content" class="app-content" role="main">
    <div class="app-content-body ">
<div class="hbox hbox-auto-xs hbox-auto-sm" ng-init="
    app.settings.asideFolded = false; 
    app.settings.asideDock = false;
  ">
  <!-- main -->
  <div class="col">
    <!-- main header -->
    <div class="bg-light lter b-b wrapper-md">
      <div class="row">
        <div class="col-sm-12 col-xs-12">
          <h1 class="m-n font-normal h3 text-black">Welcome to zajecia Afghanistan</h1>
          <h1 class="m-n font-thin h4 text-black">General Information Text</h1>
                    <small class="text-muted">Lorem ipsum Nisi veniam fugiat id pariatur ex irure ullamco voluptate reprehenderit qui ut qui ex fugiat Ut nulla sed et labore ullamco est non officia adipisicing Duis aliquip ut ut incididunt exercitation ex nostrud est et fugiat officia elit adipisicing deserunt ex in aute officia sunt est cupidatat labore ad ullamco aliqua proident incididunt in minim sit aliqua in Duis elit ex in non culpa magna aute laboris eu dolor esse dolore incididunt anim et magna ex sint est et nisi aliqua sit cillum ut Excepteur elit cillum laboris adipisicing pariatur in cillum incididunt proident officia nulla in incididunt nostrud aliqua proident laboris cillum dolor tempor quis minim dolore ex cupidatat amet Duis eu culpa esse in non reprehenderit irure adipisicing consectetur ullamco incididunt dolor qui nostrud veniam id ut eu esse reprehenderit laborum sunt non officia aliquip id aute et nostrud ut sunt incididunt ea aliquip qui minim magna Duis commodo sed deserunt mollit commodo irure in cillum nulla eu deserunt qui Ut reprehenderit consectetur elit in exercitation Ut Ut esse laboris ullamco culpa id nulla id et Excepteur laborum in commodo ea Duis est velit nostrud sit magna laboris sunt.</small>
        </div>
       
      </div>
    </div>
  

<div class="wrapper-md">
  <div class="row">
    <div class="col-sm-6 connected" ui-jq="sortable" ui-options="{items:'.panel', handle:'.panel-heading', connectWith:'.connected'}">
      
      <div class="panel panel-default">
        <div class="panel-heading">
          Lates Security information <span class="badge">3</span>                    
        </div>
        <div class="panel-body">
          <article class="media">
            <div class="pull-left">
              <span class="fa-stack fa-lg">
                <i class="fa fa-circle fa-stack-2x"></i>
                <i class="fa fa-mobile fa-stack-1x text-white"></i>
              </span>
            </div>
            <div class="media-body">                        
              <a href class="h4">Information 1</a>
              <small class="block m-t-xs">esse reprehenderit laborum sunt non officia aliquip id aute et nostrud ut sunt incididunt ea aliquip qui minim magna </small>
              <em class="text-xs">Posted on <span class="text-danger">Feb 23, 2023</span></em>
            </div>
          </article>
          <div class="line pull-in"></div>
          <article class="media">
            <div class="pull-left">
              <span class="fa-stack fa-lg">
                <i class="fa fa-circle fa-stack-2x"></i>
                <i class="fa fa-mobile fa-stack-1x text-white"></i>
              </span>
            </div>
            <div class="media-body">
              <a href class="h4">Information 2</a>
              <small class="block m-t-xs">Duis commodo sed deserunt mollit commodo irure in cillum nulla eu deserunt qui Ut reprehenderit consectetur elit in exercitation Ut Ut esse laboris ullamco culpa id nulla id </small>
              <em class="text-xs">Posted on <span class="text-danger">Feb 12, 2023</span></em>
            </div>
          </article>
          <div class="line pull-in"></div>
          <article class="media">
            <div class="pull-left">
              <span class="fa-stack fa-lg">
                <i class="fa fa-circle fa-stack-2x"></i>
                <i class="fa fa-mobile fa-stack-1x text-white"></i>
              </span>
            </div>
            <div class="media-body">
              <a href class="h4 text-success">Information 3</a>
              <small class="block m-t-xs">et Excepteur laborum in commodo ea Duis est velit nostrud sit magna laboris sunt.</small>
              <em class="text-xs">Posted on <span class="text-danger">Feb 05, 2023</span></em>
            </div>
          </article>
        </div>
      </div>
    </div>
    <div class="col-sm-6 connected" ui-jq="sortable" ui-options="{items:'.panel', handle:'.panel-heading', connectWith:'.connected'}">
      <div class="panel panel-default">
        <div class="panel-heading">                    
          Link to RM Documents
        </div>
        <div class="panel-body">
          <article class="media">
            <span class="pull-left thumb-sm"><img src="img/a1.jpg" alt="..." class="img-circle"></span>
            <div class="media-body">
              <div class="pull-right text-center text-muted">
                <strong class="h4">12:18</strong><br>
                <small class="label bg-light">pm</small>
              </div>
              <a href class="h4">RM Document 1</a>
              <small class="block"><a href class="">Peter Müller</a> <span class="label label-success">Label1</span></small>
              <small class="block m-t-sm">Lorem ipsum Nisi veniam fugiat id pariatur ex irure ullamco voluptate reprehenderit qui ut qui ex fugiat Ut nulla sed et labore ullamco est non officia </small>
            </div>
          </article>
          <div class="line pull-in"></div>
          <article class="media">
            <span class="pull-left thumb-sm"><i class="fa fa-file-o fa-3x"></i></span>                
            <div class="media-body">
              <div class="pull-right text-center text-muted">
                <strong class="h4">17</strong><br>
                <small class="label bg-light">feb</small>
              </div>
              <a href class="h4">RM Document 2</a>
              <small class="block"><a href class="">Peter Müller</a> <span class="label label-info">Label2</span></small>
              <small class="block m-t-sm">adipisicing Duis aliquip ut ut incididunt exercitation ex nostrud est et fugiat officia elit adipisicing deserunt ex in aute officia sunt est cupidatat labore ad ullamco aliqua proident incididunt in minim sit aliqua in Duis elit ex in non culpa magna aute laboris</small>
            </div>
          </article>
        </div>
      </div>    
    </div>
  </div>
</div>

<div class="wrapper-md">
  <div class="row">
    <div class="col-md-4">
      <div class="panel b-a">
        <div class="panel-heading no-border bg-priAndrzej.Piechockiy">          
          <span class="text-lt">Whitelisted</span>
        </div>
        <div class="item m-l-n-xxs m-r-n-xxs">
          <div ng-init="x = 3" class="top text-right padder m-t-xs w-full">
            <rating ng-model="x" max="5" state-on="'fa fa-star text-white'" state-off="'fa fa-star-o text-white'"></rating>
          </div>
          <div class="bottom wrapper bg-gd-dk text-white">            
            <div class="text-u-c h3 m-b-sm text-priAndrzej.Piechockiy-lter">Coffee</div>
            <div>Restaurant</div>
          </div>
          <img src="img/c0.jpg" class="img-full">
        </div>
        <div class="hbox text-center b-b b-light text-sm">          
          <a href class="col padder-v text-muted b-r b-light">
            <i class="icon-call-end block m-b-xs fa-2x"></i>
            <span>Call</span>
          </a>
          <a href class="col padder-v text-muted b-r b-light">
            <i class="icon-pointer block m-b-xs fa-2x"></i>
            <span>Location</span>
          </a>
          <a href class="col padder-v text-muted b-r b-light">
            <i class="icon-plus block m-b-xs fa-2x"></i>
            <span>Add</span>
          </a>
        </div>
      </div>
    </div>
    <div class="col-md-4">
      <div class="panel b-a">
        <div class="panel-heading no-border bg-priAndrzej.Piechockiy">          
          <span class="text-lt">RMO Emergency Phone for current Duty Station</span>
        </div>
        <div class="item m-l-n-xxs m-r-n-xxs">
          <div ng-init="x = 3" class="top text-right padder m-t-xs w-full">
            <rating ng-model="x" max="5" state-on="'fa fa-star text-white'" state-off="'fa fa-star-o text-white'"></rating>
          </div>
          <div class="bottom wrapper-100 wrapper-xs bg-dark text-white">            
            <div class="text-u-c h3">123-456-789-0</div>
          </div>
          <img src="img/afg1.jpg" class="img-full">
        </div>
        <div class="hbox text-center b-b b-light text-sm">          
          <a href class="col padder-v text-muted b-r b-light">
            <i class="icon-call-end block m-b-xs fa-2x"></i>
            <span>Call</span>
          </a>
          <a href class="col padder-v text-muted b-r b-light">
            <i class="icon-pointer block m-b-xs fa-2x"></i>
            <span>Location</span>
          </a>
          <a href class="col padder-v text-muted b-r b-light">
            <i class="icon-plus block m-b-xs fa-2x"></i>
            <span>Add</span>
          </a>
        </div>
      </div>
    </div>

    <div class="col-md-4">
      <div class="panel b-a">
        <div class="panel-heading no-border bg-priAndrzej.Piechockiy">          
          <span class="text-lt">Number of Dispatch + RMO Emergency Phone</span>
        </div>
        <div class="item m-l-n-xxs m-r-n-xxs">
          <div ng-init="x = 3" class="top text-right padder m-t-xs w-full">
            <rating ng-model="x" max="5" state-on="'fa fa-star text-white'" state-off="'fa fa-star-o text-white'"></rating>
          </div>
          <div class="bottom wrapper-100 wrapper-xs bg-dark text-white">            
            <div class="text-u-c h3">123-456-789-1</div>
          </div>
          <img src="img/afg1.jpg" class="img-full">
        </div>
        <div class="hbox text-center b-b b-light text-sm">          
          <a href class="col padder-v text-muted b-r b-light">
            <i class="icon-call-end block m-b-xs fa-2x"></i>
            <span>Call</span>
          </a>
          <a href class="col padder-v text-muted b-r b-light">
            <i class="icon-pointer block m-b-xs fa-2x"></i>
            <span>Location</span>
          </a>
          <a href class="col padder-v text-muted b-r b-light">
            <i class="icon-plus block m-b-xs fa-2x"></i>
            <span>Add</span>
          </a>
        </div>
      </div>
    </div>


  </div>
  </div> 

<div class="wrapper-md">
  <div class="panel panel-default">
    <div class="panel-heading">
      Current or upcoming travels
    </div>
    <div class="panel-body b-b b-light">
      Search: <input id="filter" type="text" class="form-control input-sm w-sm inline m-r"/>
    </div>
    <div>
      <table class="table m-b-none" ui-jq="footable" data-filter="#filter" data-page-size="5">
        <thead>
          <tr>
              <th data-toggle="true">
                  First Name
              </th>
              <th>
                  Last Name
              </th>
              <th data-hide="phone,tablet">
                  Travel Location
              </th>
              <th data-hide="phone,tablet" data-name="Date Of Travel">
                  Date of Travel
              </th>
              <th data-hide="phone">
                  Status
              </th>
          </tr>
        </thead>
        <tbody>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="78025368997">2 Feb 2023</td>
              <td data-value="1"><span class="label bg-success" title="Active">Active</span></td>
          </tr>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="370961043292">3 Feb 2023</td>
              <td data-value="2"><span class="label bg-light" title="Disabled">Disabled</span></td>
          </tr>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="-22133780420">4 Feb 2023</td>
              <td data-value="3"><span class="label bg-warning" title="Suspended">Suspended</span>
              </td>
          </tr>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="-22133780423">5 Feb 2023</td>
              <td data-value="1"><span class="label bg-success" title="Active">Active</span></td>
          </tr>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="694116650726">6 Feb 2023</td>
              <td data-value="3"><span class="label bg-warning" title="Suspended">Suspended</span>
              </td>
          </tr>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="561440464855">7 Feb 2023</td>
              <td data-value="2"><span class="label bg-light" title="Disabled">Disabled</span></td>
          </tr>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="437400551390">8 Feb 2023</td>
              <td data-value="2"><span class="label bg-light" title="Disabled">Disabled</span></td>
          </tr>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="-257733999319">9 Feb 2023</td>
              <td data-value="3"><span class="label bg-warning" title="Suspended">Suspended</span>
              </td>
          </tr>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="362134712000">10 Feb 2023</td>
              <td data-value="1"><span class="label bg-success" title="Active">Active</span></td>
          </tr>
          <tr>
              <td>Peter</td>
              <td><a href>Müller</a></td>
              <td>Kabul</td>
              <td data-value="500874333932">11 Feb 2023</td>
              <td data-value="3"><span class="label bg-warning" title="Suspended">Suspended</span>
              </td>
          </tr>
        </tbody>
        <tfoot class="hide-if-no-paging">
          <tr>
              <td colspan="5" class="text-center">
                  <ul class="pagination"></ul>
              </td>
          </tr>
        </tfoot>
      </table>
    </div>
  </div>
</div>

<div class="wrapper-md">
  <form action="#" class="m-b-md">
    <div class="input-group">
      <input type="text" class="form-control input-lg" placeholder="Type keyword">
      <span class="input-group-btn">
        <button class="btn btn-lg btn-default" type="button">Search</button>
      </span>
    </div>
  </form>
  <p class="m-b-md"><strong>34</strong> Results found for: <strong>Keyword</strong></p>
  <div class="tab-container">
    <ul class="nav nav-tabs" role="tablist">
      <li class="active"><a href="#tab1" data-toggle="tab">Hotels <span class="badge badge-sm m-l-xs">16</span></a></li>
      <li><a href="#tab2" data-toggle="tab">Restaurants <span class="badge bg-danger badge-sm m-l-xs">6</span></a></li>
      <li><a href="#tab3" data-toggle="tab">SuperAndrzej.Piechockikets <span class="badge bg-priAndrzej.Piechockiy badge-sm m-l-xs">9</span></a></li><li><a href="#tab4" data-toggle="tab">Other <span class="badge bg-priAndrzej.Piechockiy badge-sm m-l-xs">3</span></a></li>
    </ul>
    <div class="tab-content">
      <div class="tab-pane active" id="tab1">
        <ul class="list-group no-borders pull-in m-b-none">
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Morbi id neque quam. Aliquam sollicitudin venenatis ipsum ac </a>
            <p>Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-priAndrzej.Piechockiy pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-priAndrzej.Piechockiy"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Vestibulum ullamcorper sodales nisi nec condimentum</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Mauris convallis mauris at pellentesque volutpat</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Phasellus at ultricies neque, quis malesuada augu</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Morbi nec nunc condimentum, egestas dui nec, fermentum diam</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Vestibulum ullamcorper sodales nisi nec condimentum Mauris convallis</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
        </ul>
      </div>
      <div class="tab-pane active" id="tab2">
        <ul class="list-group no-borders pull-in m-b-none">
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Morbi id neque quam. Aliquam sollicitudin venenatis ipsum ac </a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-priAndrzej.Piechockiy pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-priAndrzej.Piechockiy"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Vestibulum ullamcorper sodales nisi nec condimentum</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Mauris convallis mauris at pellentesque volutpat</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Phasellus at ultricies neque, quis malesuada augu</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Morbi nec nunc condimentum, egestas dui nec, fermentum diam</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Vestibulum ullamcorper sodales nisi nec condimentum Mauris convallis</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
        </ul>
      </div>
      <div class="tab-pane active" id="tab3">
        <ul class="list-group no-borders pull-in m-b-none">
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Aliquam sollicitudin venenatis ipsum ac </a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-priAndrzej.Piechockiy pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-priAndrzej.Piechockiy"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Vestibulum ullamcorper sodales nisi nec condimentum</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Mauris convallis mauris at pellentesque volutpat</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Phasellus at ultricies neque, quis malesuada augu</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Morbi nec nunc condimentum, egestas dui nec, fermentum diam</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Vestibulum ullamcorper sodales nisi nec condimentum Mauris convallis</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
        </ul>
      </div>
      <div class="tab-pane active" id="tab4">
        <ul class="list-group no-borders pull-in m-b-none">
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Morbi id neque quam. Aliquam sollicitudin venenatis ipsum ac </a>
            <p>Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-priAndrzej.Piechockiy pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-priAndrzej.Piechockiy"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Vestibulum ullamcorper sodales nisi nec condimentum</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Mauris convallis mauris at pellentesque volutpat</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Phasellus at ultricies neque, quis malesuada augu</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Morbi nec nunc condimentum, egestas dui nec, fermentum diam</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
          <li class="list-group-item">
            <a href="#" class="h4 text-priAndrzej.Piechockiy m-b-sm m-t-sm block">Vestibulum ullamcorper sodales nisi nec condimentum Mauris convallis</a>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi id neque quam. Aliquam sollicitudin egestas dui nec, fermentum diam. Vivamus vel tincidunt libero, vitae elementum ligula venenatis ipsum ac feugiat. Vestibulum ullamcorper sodales nisi nec condimentum</p>
            <p><span class="label bg-info pos-rlt m-r inline wrapper-xs"><i class="arrow right arrow-info"></i> Tags:</span> <a href class="m-r-sm">Hotel</a> <a href>Restaurant</a>
            </p>
          </li>
        </ul>
      </div>
    </div>
  </div>
</div>

        
    
    <!-- / main header -->
    <div class="wrapper-md" ng-controller="FlotChartDemoCtrl">
      <!-- stats -->
    
    </div>
  </div>
  <!-- / main -->
</div>


    </div>
  </div>
  <!-- / content -->


