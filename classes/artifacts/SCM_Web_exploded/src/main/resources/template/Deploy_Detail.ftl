<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <link rel="shortcut icon" href="/static/img/favicon.ico" />
		<title>SCM | 系统</title>
		<!-- Tell the browser to be responsive to screen width -->
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="/static/css/bootstrap.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="/static/css/dataTables.bootstrap.min.css">
        <!-- bootstrap datepicker -->
        <link rel="stylesheet" href="/static/css/bootstrap-datepicker.min.css">
        <!-- iCheck for checkboxes and radio inputs -->
        <link rel="stylesheet" href="/static/iCheck/all.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="/static/font-awesome/css/font-awesome.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="/static/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="/static/css/skin-blue.css">

		<!-- jQuery 3 -->
        <script src="/static/js/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="/static/js/bootstrap.min.js"></script>
        <!-- bootstrap datepicker -->
        <script src="/static/js/bootstrap-datepicker.min.js"></script>
        <!-- iCheck 1.0.1 -->
        <script src="/static/iCheck/icheck.min.js"></script>
        <!-- AdminLTE App -->
        <script src="/static/js/adminlte.min.js"></script>

		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

		<!-- Google Font -->
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
	</head>
	<body class="hold-transition skin-blue sidebar-mini">
		<div class="wrapper">
			<#include "header.ftl" encoding="UTF-8"/>
			<aside class="main-sidebar">
				<!-- sidebar: style can be found in sidebar.less -->
				<section class="sidebar">
					<!-- Sidebar user panel -->
					<div class="user-panel">
						<div class="pull-left image">
							<img src="/static/img/user2-160x160.jpg" class="img-circle" alt="User Image">
						</div>
						<div class="pull-left info">
							<p>
								<#if Session.user?exists>
									${Session.user.name}
								<#else>
                        未登录
								</#if>
							</p>
							<a href="#"><i class="fa fa-circle text-success"></i>
                            <#if Session.user?exists>
                                <#if Session.user.authority == 1>
                            管理员
                                </#if>
                            <#elseif Session.user.authority == 2>
                            普通用户
                            <#else>
                        未登录
                            </#if>
                            </a>
						</div>
					</div>
					<!-- sidebar menu: : style can be found in sidebar.less -->
					<ul class="sidebar-menu" data-widget="tree">
						<li class="header">主菜单</li>
						<li class="treeview">
							<a href="#">
								<i class="fa fa-exchange"></i> <span>出入库管理</span>
								<span class="pull-right-container">
									<span class="label label-primary pull-right">1</span>
								</span>
							</a>
							<ul class="treeview-menu">
								<li class="active"><a href="index.html"><i class="fa fa-circle-o"></i> 入库管理</a></li>
								<li><a href="index2.html"><i class="fa fa-circle-o"></i> 出库管理</a></li>
								<li><a href="#"><i class="fa fa-circle-o"></i> 流水管理</a></li>
							</ul>
						</li>
						<li class="active treeview menu-open">
							<a href="#">
								<i class="fa fa-database"></i>
								<span>仓储管理</span>
								<span class="pull-right-container">
									<span class="label label-primary pull-right">4</span>
								</span>
							</a>
							<ul class="treeview-menu">
								<li><a href="Factory_Management.html"><i class="fa fa-circle-o"></i> 工厂管理</a></li>
								<li><a href="Repository_Management.html"><i class="fa fa-circle-o"></i> 仓库管理</a></li>
								<li><a href="pages/layout/fixed.html"><i class="fa fa-circle-o"></i> 商品管理</a></li>
								<li><a href=""><i class="fa fa-circle-o"></i> 库存管理</a></li>
								<li><a href=""><i class="fa fa-circle-o"></i> 调配管理</a></li>
								<li class="active"><a href=""><i class="fa fa-circle-o"></i> 调配管理</a></li>
							</ul>
						</li>
						<li class="treeview">
							<a href="#">
								<i class="fa fa-rmb"></i> <span>资金管理</span>
								<span class="pull-right-container">
									<small class="label pull-right bg-green">new</small>
								</span>
							</a>
							<ul class="treeview-menu">
								<li><a href="pages/widgets.html"><i class="fa fa-circle-o"></i> 成本管理</a></li>
								<li><a href="pages/layout/boxed.html"><i class="fa fa-circle-o"></i> 收入管理</a></li>
							</ul>
						</li>
						<li class="treeview">
							<a href="#">
								<i class="fa fa-pie-chart"></i>
								<span>其他数据</span>
								<span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
							</a>
							<ul class="treeview-menu">
								<li><a href="pages/charts/chartjs.html"><i class="fa fa-circle-o"></i> 用户管理</a></li>
								<li><a href="pages/charts/morris.html"><i class="fa fa-circle-o"></i> 客户管理</a></li>
							</ul>
						</li>
						<li class="treeview">
							<a href="#">
								<i class="fa fa-laptop"></i>
								<span>数据分析</span>
								<span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
							</a>
							<ul class="treeview-menu">
								<li><a href="IntegratedPanel.html"><i class="fa fa-circle-o"></i> 综合面板</a></li>
								<li><a href="pages/UI/icons.html"><i class="fa fa-circle-o"></i> 成本收入</a></li>
								<li><a href="pages/UI/buttons.html"><i class="fa fa-circle-o"></i> 客户分析</a></li>
							</ul>
						</li>
						<li class="header">LABELS</li>
						<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li>
						<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>Warning</span></a></li>
						<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li>
					</ul>
				</section>
				<!-- /.sidebar -->
			</aside>

			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>
						调配信息详情
						<small>Version 1.0</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-database"></i> 仓储管理</a></li>
						<li><a href="/deploy/queryDeploy">调配管理</a></li>
						<li class="active">调配信息详情</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<!-- Info boxes -->
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<div class="box-body">
									<div class="row">
										<div class="col-md-10">
											<!--startprint-->
											<form class="form-horizontal" action="/deploy/editDeploy" method="post">
												<div class="box-body">
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">调配单号</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.id}" name="id" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">调配时间</label>
														<div class="col-sm-8">
															<input type="text" class="form-control pull-right" value="${deploy.deploy_date}" id="datepicker" placeholder="yyyy-mm-dd" data-date-format='yyyy-mm-dd' readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">调出：</label>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">原工厂名称</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.source_factory_name}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">原仓库名称</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.source_repository_name}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">原商品主编码</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.source_product_main_code}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">原商品编码</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.source_product_code}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">调入：</label>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">目标工厂名称</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.aim_factory_name}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">目标仓库名称</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.aim_repository_name}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">目标商品主编码</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.aim_product_main_code}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">目标商品编码</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.aim_product_code}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">商品信息：</label>
													</div>
													
													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">商品颜色</label>

														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.product_color!""}" readonly="readonly">
														</div>
													</div>

													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">商品尺寸</label>

														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.product_size!""}" readonly="readonly">
														</div>
													</div>

													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">商品密度</label>

														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.product_density!""}" readonly="readonly">
														</div>
													</div>

													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">商品码口</label>

														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.product_makou!""}" readonly="readonly">
														</div>
													</div>

													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">商品码数</label>

														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.product_mashu!""}" readonly="readonly">
														</div>
													</div>

													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">调出数量</label>

														<div class="col-sm-8">
															<input type="number" class="form-control" value="${deploy.deploy_quantity!""}" readonly="readonly">
														</div>
													</div>

													<div class="form-group col-md-8">
														<label class="col-sm-4 control-label">备注</label>

														<div class="col-sm-8">
															<input type="text" class="form-control" value="${deploy.comment!""}" readonly="readonly">
														</div>
													</div>



												</div>
												<!-- /.box-body -->
												<div class="box-footer">
													<a href="javascript:window.close();" class="btn btn-default">返回</a>
													<input type="submit" class="btn btn-info" value="修改" />
                                                    <button class="btn btn-default" onclick="doPrint()">打印</button>
                                                </div>
												<!-- /.box-footer -->
											</form>
											<!--endprint-->
											<!-- /.chart-responsive -->
										</div>
										<!-- /.col -->
										<!-- <div class="form-group col-md-4" style="border: 1px solid red;">
											<form class="form-horizontal">
												<div class="box-body">
													<div class="form-group col-md-12">
														<label class="col-sm-4 control-label">入库单号</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" placeholder="入库单号" readonly="readonly">
														</div>
													</div>
												</div>
											</form>
										</div> -->
										<!-- /.row -->
									</div>
									<!-- ./box-body -->
								</div>
								<!-- /.box -->
							</div>
							<!-- /.col -->
						</div>
				</section>
				<!-- /.content -->
			</div>
			<!-- /.content-wrapper -->

			<footer class="main-footer">
				<div class="pull-right hidden-xs">
					<b>Version</b> 1.0
				</div>
				<strong>Copyright &copy; 2018 <a>猫熊小才天</a>.</strong> All rights
				reserved.
			</footer>

		</div>
		<script>
			$("#in_header").load("header.html");
		</script>
		<script>
            function doPrint() {
                bdhtml=window.document.body.innerHTML;
                sprnstr="<!--startprint-->";
                eprnstr="<!--endprint-->";
                prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17);
                prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));
                window.document.body.innerHTML=prnhtml;
                window.print();
            }
		</script>
		<!-- ./wrapper -->


	</body>
</html>
