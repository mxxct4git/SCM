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
                            <p>
								<#if Session.user?exists>
									${Session.user.name}
								<#else>
                        未登录
								</#if>
                            </p>
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
						<li class="active treeview menu-open">
							<a href="#">
								<i class="fa fa-exchange"></i> <span>出入库管理</span>
								<span class="pull-right-container">
									<span class="label label-primary pull-right">1</span>
								</span>
							</a>
							<ul class="treeview-menu">
								<li><a href="index.html"><i class="fa fa-circle-o"></i> 入库管理</a></li>
								<li><a href="index2.html"><i class="fa fa-circle-o"></i> 出库管理</a></li>
								<li class="active"><a href="/waterList/queryWaterList"><i class="fa fa-circle-o"></i> 流水管理</a></li>
							</ul>
						</li>
						<li class="treeview">
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
								<li><a href="pages/layout/collapsed-sidebar.html"><i class="fa fa-circle-o"></i> 调配管理</a></li>
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
						出库流水单信息详情
						<small>Version 1.0</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-exchange"></i> 出入库管理</a></li>
						<li><a href="/waterList/queryWaterList">流水单管理</a></li>
						<li class="active">出库流水单信息详情</li>
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
										<div class="col-md-8">
											<!--startprint-->
											<form class="form-horizontal">
												<div class="box-body">
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">出库ID</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" name="id" value="${outList.id}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">出库单号</label>
														<div class="col-sm-8">
															<input type="text" class="form-control" name="out_timestamp" value="${outList.out_timestamp}" readonly="readonly">
														</div>
													</div>

                                                    <div class="form-group col-md-6">
                                                        <label class="col-sm-4 control-label">客户名称</label>

                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" name="customer_name" value="${outList.customer_name!""}" readonly="readonly">
                                                        </div>

                                                    </div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">所属工厂</label>

														<div class="col-sm-8">
                                                            <input type="text" class="form-control" name="factory_name" value="${outList.factory_name!""}" readonly="readonly">
														</div>

													</div>

													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">仓库名称</label>

														<div class="col-sm-8">
															<input type="text" class="form-control" name="repository_name" value="${outList.repository_name!""}" readonly="readonly">
														</div>
													</div>

													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">出库时间</label>

														<div class="col-sm-8">
															<input type="text" class="form-control" name="out_date" value="${outList.out_date!""}" readonly="readonly">
														</div>

													</div>

													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品主编码</label>

														<div class="col-sm-8">
															<input type="tel" class="form-control" name="product_main_code" value="${outList.product_main_code!""}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品编码</label>
														
														<div class="col-sm-8">
															<input type="text" class="form-control" name="product_code" value="${outList.product_code!""}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品颜色</label>
														
														<div class="col-sm-8">
															<input type="text" class="form-control" name="product_color" value="${outList.product_color!""}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品尺寸</label>
														
														<div class="col-sm-8">
															<input type="text" class="form-control" name="product_size" value="${outList.product_size!""}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品密度</label>
														
														<div class="col-sm-8">
															<input type="text" class="form-control" name="product_density" value="${outList.product_density!""}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品码口</label>
														
														<div class="col-sm-8">
															<input type="text" class="form-control" name="product_makou" value="${outList.product_makou!""}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品码数</label>
														
														<div class="col-sm-8">
															<input type="text" class="form-control" name="product_mashu" value="${outList.product_mashu!""}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品单价</label>
														
														<div class="col-sm-8">
															<input type="text" class="form-control" name="product_price" value="${outList.product_price!""}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">合计总价</label>
														
														<div class="col-sm-8">
															<input type="text" class="form-control" name="total_price" value="${outList.total_price!""}" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">退货订单</label>
														
														<div class="col-sm-8">
                                                            <input type="text" class="form-control" name="is_callback" value="<#if outList.is_callback==1>已退货<#else >未退货</#if>" readonly="readonly">
														</div>
													</div>
													
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">备注</label>
														
														<div class="col-sm-8">
															<input type="text" class="form-control" name="comment" value="${outList.comment!""}" readonly="readonly">
														</div>
													</div>

                                                    <div class="form-group col-md-6">
                                                        <label class="col-sm-4 control-label">结算状态</label>

                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control" name="is_income_complete" value="<#if income.is_income_complete == 1>已完结<#else >未完结</#if>" readonly="readonly">
                                                        </div>
                                                    </div>
													
												</div>
												<!-- /.box-body -->
												<div class="box-footer">
													<a href="javascript:window.close();" class="btn btn-default">返回</a>
													<button class="btn btn-default" onclick="doPrint()">打印</button>
												</div>
												<!-- /.box-footer -->
											</form>
											<!--endprint-->
											<!-- /.chart-responsive -->
										</div>
										<!-- /.col -->
									</div>
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
