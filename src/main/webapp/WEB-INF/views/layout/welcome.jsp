<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-md-12">
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">Monthly Recap Report</h3>
				<div class="box-tools pull-right">
					<button class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
					<div class="btn-group">
						<button class="btn btn-box-tool dropdown-toggle"
							data-toggle="dropdown">
							<i class="fa fa-wrench"></i>
						</button>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>
					<button class="btn btn-box-tool" data-widget="remove">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<div class="row">
					<div class="col-md-8">
						<p class="text-center">
							<strong>Sales: 1 Jan, 2014 - 30 Jul, 2014</strong>
						</p>
						<div class="chart-responsive">
							<!-- Sales Chart Canvas -->
							<canvas id="salesChart" height="190" width="703"
								style="width: 703px; height: 190px;"></canvas>
						</div>
						<!-- /.chart-responsive -->
					</div>
					<!-- /.col -->
					<div class="col-md-4">
						<p class="text-center">
							<strong>Goal Completion</strong>
						</p>
						<div class="progress-group">
							<span class="progress-text">Add Products to Cart</span> <span
								class="progress-number"><b>160</b>/200</span>
							<div class="progress sm">
								<div class="progress-bar progress-bar-aqua" style="width: 80%"></div>
							</div>
						</div>
						<!-- /.progress-group -->
						<div class="progress-group">
							<span class="progress-text">Complete Purchase</span> <span
								class="progress-number"><b>310</b>/400</span>
							<div class="progress sm">
								<div class="progress-bar progress-bar-red" style="width: 80%"></div>
							</div>
						</div>
						<!-- /.progress-group -->
						<div class="progress-group">
							<span class="progress-text">Visit Premium Page</span> <span
								class="progress-number"><b>480</b>/800</span>
							<div class="progress sm">
								<div class="progress-bar progress-bar-green" style="width: 80%"></div>
							</div>
						</div>
						<!-- /.progress-group -->
						<div class="progress-group">
							<span class="progress-text">Send Inquiries</span> <span
								class="progress-number"><b>250</b>/500</span>
							<div class="progress sm">
								<div class="progress-bar progress-bar-yellow" style="width: 80%"></div>
							</div>
						</div>
						<!-- /.progress-group -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- ./box-body -->
			<div class="box-footer">
				<div class="row">
					<div class="col-sm-3 col-xs-6">
						<div class="description-block border-right">
							<span class="description-percentage text-green"><i
								class="fa fa-caret-up"></i> 17%</span>
							<h5 class="description-header">$35,210.43</h5>
							<span class="description-text">TOTAL REVENUE</span>
						</div>
						<!-- /.description-block -->
					</div>
					<!-- /.col -->
					<div class="col-sm-3 col-xs-6">
						<div class="description-block border-right">
							<span class="description-percentage text-yellow"><i
								class="fa fa-caret-left"></i> 0%</span>
							<h5 class="description-header">$10,390.90</h5>
							<span class="description-text">TOTAL COST</span>
						</div>
						<!-- /.description-block -->
					</div>
					<!-- /.col -->
					<div class="col-sm-3 col-xs-6">
						<div class="description-block border-right">
							<span class="description-percentage text-green"><i
								class="fa fa-caret-up"></i> 20%</span>
							<h5 class="description-header">$24,813.53</h5>
							<span class="description-text">TOTAL PROFIT</span>
						</div>
						<!-- /.description-block -->
					</div>
					<!-- /.col -->
					<div class="col-sm-3 col-xs-6">
						<div class="description-block">
							<span class="description-percentage text-red"><i
								class="fa fa-caret-down"></i> 18%</span>
							<h5 class="description-header">1200</h5>
							<span class="description-text">GOAL COMPLETIONS</span>
						</div>
						<!-- /.description-block -->
					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.box-footer -->
		</div>
		<!-- /.box -->
	</div>
	<!-- /.col -->
</div>
<div class='row'>
	<div class='col-md-4'>
		<!-- DIRECT CHAT -->
		<div class="box box-warning direct-chat direct-chat-warning">
			<div class="box-header with-border">
				<h3 class="box-title">Direct Chat</h3>
				<div class="box-tools pull-right">
					<span data-toggle="tooltip" title="3 New Messages"
						class='badge bg-yellow'>3</span>
					<button class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
					<button class="btn btn-box-tool" data-toggle="tooltip"
						title="Contacts" data-widget="chat-pane-toggle">
						<i class="fa fa-comments"></i>
					</button>
					<button class="btn btn-box-tool" data-widget="remove">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<!-- Conversations are loaded here -->
				<div class="direct-chat-messages">
					<!-- Message. Default to the left -->
					<div class="direct-chat-msg">
						<div class='direct-chat-info clearfix'>
							<span class='direct-chat-name pull-left'>Alexander Pierce</span>
							<span class='direct-chat-timestamp pull-right'>23 Jan 2:00
								pm</span>
						</div>
						<!-- /.direct-chat-info -->
						<img class="direct-chat-img" src="dist/img/user1-128x128.jpg"
							alt="message user image" />
						<!-- /.direct-chat-img -->
						<div class="direct-chat-text">Is this template really for
							free? That's unbelievable!</div>
						<!-- /.direct-chat-text -->
					</div>
					<!-- /.direct-chat-msg -->

					<!-- Message to the right -->
					<div class="direct-chat-msg right">
						<div class='direct-chat-info clearfix'>
							<span class='direct-chat-name pull-right'>Sarah Bullock</span> <span
								class='direct-chat-timestamp pull-left'>23 Jan 2:05 pm</span>
						</div>
						<!-- /.direct-chat-info -->
						<img class="direct-chat-img" src="dist/img/user3-128x128.jpg"
							alt="message user image" />
						<!-- /.direct-chat-img -->
						<div class="direct-chat-text">You better believe it!</div>
						<!-- /.direct-chat-text -->
					</div>
					<!-- /.direct-chat-msg -->

					<!-- Message. Default to the left -->
					<div class="direct-chat-msg">
						<div class='direct-chat-info clearfix'>
							<span class='direct-chat-name pull-left'>Alexander Pierce</span>
							<span class='direct-chat-timestamp pull-right'>23 Jan 5:37
								pm</span>
						</div>
						<!-- /.direct-chat-info -->
						<img class="direct-chat-img" src="dist/img/user1-128x128.jpg"
							alt="message user image" />
						<!-- /.direct-chat-img -->
						<div class="direct-chat-text">Working with AdminLTE on a
							great new app! Wanna join?</div>
						<!-- /.direct-chat-text -->
					</div>
					<!-- /.direct-chat-msg -->

					<!-- Message to the right -->
					<div class="direct-chat-msg right">
						<div class='direct-chat-info clearfix'>
							<span class='direct-chat-name pull-right'>Sarah Bullock</span> <span
								class='direct-chat-timestamp pull-left'>23 Jan 6:10 pm</span>
						</div>
						<!-- /.direct-chat-info -->
						<img class="direct-chat-img" src="dist/img/user3-128x128.jpg"
							alt="message user image" />
						<!-- /.direct-chat-img -->
						<div class="direct-chat-text">I would love to.</div>
						<!-- /.direct-chat-text -->
					</div>
					<!-- /.direct-chat-msg -->

				</div>
				<!--/.direct-chat-messages-->


				<!-- Contacts are loaded here -->
				<div class="direct-chat-contacts">
					<ul class='contacts-list'>
						<li><a href='#'> <img class='contacts-list-img'
								src='dist/img/user1-128x128.jpg' />
								<div class='contacts-list-info'>
									<span class='contacts-list-name'> Count Dracula <small
										class='contacts-list-date pull-right'>2/28/2015</small>
									</span> <span class='contacts-list-msg'>How have you been? I
										was...</span>
								</div> <!-- /.contacts-list-info -->
						</a></li>
						<!-- End Contact Item -->
						<li><a href='#'> <img class='contacts-list-img'
								src='dist/img/user7-128x128.jpg' />
								<div class='contacts-list-info'>
									<span class='contacts-list-name'> Sarah Doe <small
										class='contacts-list-date pull-right'>2/23/2015</small>
									</span> <span class='contacts-list-msg'>I will be waiting
										for...</span>
								</div> <!-- /.contacts-list-info -->
						</a></li>
						<!-- End Contact Item -->
						<li><a href='#'> <img class='contacts-list-img'
								src='dist/img/user3-128x128.jpg' />
								<div class='contacts-list-info'>
									<span class='contacts-list-name'> Nadia Jolie <small
										class='contacts-list-date pull-right'>2/20/2015</small>
									</span> <span class='contacts-list-msg'>I'll call you back
										at...</span>
								</div> <!-- /.contacts-list-info -->
						</a></li>
						<!-- End Contact Item -->
						<li><a href='#'> <img class='contacts-list-img'
								src='dist/img/user5-128x128.jpg' />
								<div class='contacts-list-info'>
									<span class='contacts-list-name'> Nora S. Vans <small
										class='contacts-list-date pull-right'>2/10/2015</small>
									</span> <span class='contacts-list-msg'>Where is your new...</span>
								</div> <!-- /.contacts-list-info -->
						</a></li>
						<!-- End Contact Item -->
						<li><a href='#'> <img class='contacts-list-img'
								src='dist/img/user6-128x128.jpg' />
								<div class='contacts-list-info'>
									<span class='contacts-list-name'> John K. <small
										class='contacts-list-date pull-right'>1/27/2015</small>
									</span> <span class='contacts-list-msg'>Can I take a look at...</span>
								</div> <!-- /.contacts-list-info -->
						</a></li>
						<!-- End Contact Item -->
						<li><a href='#'> <img class='contacts-list-img'
								src='dist/img/user8-128x128.jpg' />
								<div class='contacts-list-info'>
									<span class='contacts-list-name'> Kenneth M. <small
										class='contacts-list-date pull-right'>1/4/2015</small>
									</span> <span class='contacts-list-msg'>Never mind I found...</span>
								</div> <!-- /.contacts-list-info -->
						</a></li>
						<!-- End Contact Item -->
					</ul>
					<!-- /.contatcts-list -->
				</div>
				<!-- /.direct-chat-pane -->
			</div>
			<!-- /.box-body -->
			<div class="box-footer">
				<form action="#" method="post">
					<div class="input-group">
						<input type="text" name="message" placeholder="Type Message ..."
							class="form-control" /> <span class="input-group-btn">
							<button type="button" class="btn btn-warning btn-flat">Send</button>
						</span>
					</div>
				</form>
			</div>
			<!-- /.box-footer-->
		</div>
		<!--/.direct-chat -->
	</div>
	<!-- /.col -->
	<div class='col-md-4'>
		<!-- USERS LIST -->
		<div class="box box-danger">
			<div class="box-header with-border">
				<h3 class="box-title">Latest Members</h3>
				<div class="box-tools pull-right">
					<span class="label label-danger">8 New Members</span>
					<button class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
					<button class="btn btn-box-tool" data-widget="remove">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</div>
			<!-- /.box-header -->
			<div class="box-body no-padding">
				<ul class="users-list clearfix">
					<li><img src="dist/img/user1-128x128.jpg" alt="User Image" />
						<a class="users-list-name" href="#">Alexander Pierce</a> <span
						class="users-list-date">Today</span></li>
					<li><img src="dist/img/user8-128x128.jpg" alt="User Image" />
						<a class="users-list-name" href="#">Norman</a> <span
						class="users-list-date">Yesterday</span></li>
					<li><img src="dist/img/user7-128x128.jpg" alt="User Image" />
						<a class="users-list-name" href="#">Jane</a> <span
						class="users-list-date">12 Jan</span></li>
					<li><img src="dist/img/user6-128x128.jpg" alt="User Image" />
						<a class="users-list-name" href="#">John</a> <span
						class="users-list-date">12 Jan</span></li>
					<li><img src="dist/img/user2-160x160.jpg" alt="User Image" />
						<a class="users-list-name" href="#">Alexander</a> <span
						class="users-list-date">13 Jan</span></li>
					<li><img src="dist/img/user5-128x128.jpg" alt="User Image" />
						<a class="users-list-name" href="#">Sarah</a> <span
						class="users-list-date">14 Jan</span></li>
					<li><img src="dist/img/user4-128x128.jpg" alt="User Image" />
						<a class="users-list-name" href="#">Nora</a> <span
						class="users-list-date">15 Jan</span></li>
					<li><img src="dist/img/user3-128x128.jpg" alt="User Image" />
						<a class="users-list-name" href="#">Nadia</a> <span
						class="users-list-date">15 Jan</span></li>
				</ul>
				<!-- /.users-list -->
			</div>
			<!-- /.box-body -->
			<div class="box-footer text-center">
				<a href="javascript::" class="uppercase">View All Users</a>
			</div>
			<!-- /.box-footer -->
		</div>
		<!--/.box -->
	</div>
	<!-- /.col -->
	<div class='col-md-4'>
		<div class="box box-default">
			<div class="box-header with-border">
				<h3 class="box-title">Browser Usage</h3>
				<div class="box-tools pull-right">
					<button class="btn btn-box-tool" data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
					<button class="btn btn-box-tool" data-widget="remove">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<div class="row">
					<div class="col-md-8">
						<div class="chart-responsive">
							<canvas id="pieChart" height="150"></canvas>
						</div>
						<!-- ./chart-responsive -->
					</div>
					<!-- /.col -->
					<div class="col-md-4">
						<ul class="chart-legend clearfix">
							<li><i class="glyphicon glyphicon-comment text-red"></i>
								Chrome</li>
							<li><i class="glyphicon glyphicon-comment text-green"></i>
								IE</li>
							<li><i class="glyphicon glyphicon-comment text-yellow"></i>
								FireFox</li>
							<li><i class="glyphicon glyphicon-comment text-aqua"></i>
								Safari</li>
							<li><i class="glyphicon glyphicon-comment text-light-blue"></i>
								Opera</li>
							<li><i class="glyphicon glyphicon-comment text-gray"></i>
								Navigator</li>
						</ul>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.box-body -->
			<div class="box-footer no-padding">
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#">United States of America <span
							class="pull-right text-red"><i
								class="glyphicon glyphicon-user"></i> 12%</span></a></li>
					<li><a href="#">India <span class="pull-right text-green"><i
								class="glyphicon glyphicon-comment"></i> 4%</span></a></li>
					<li><a href="#">China <span class="pull-right text-yellow"><i
								class="fa fa-angle-left"></i> 0%</span></a></li>
				</ul>
			</div>
			<!-- /.footer -->
		</div>
		<!-- /.box -->
	</div>
	<!-- /.col -->
</div>
<!-- /.row -->