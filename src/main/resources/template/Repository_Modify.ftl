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

        <script>
            $(function() {
                $("#fac_type").empty();
                var tmp = ${repository.factory_id};
                var res = false;
                $.ajax({
                    async : true,
                    dataType : "json",
                    url : "/factory/ajax_queryFactory",
                    error : function(xhr, status) {
                        console.log(status);
                    },
                    success : function(data) {
                        for (var i = 0; i < data.length ; i++) {
                            if(tmp == data[i].id){
                                res = true;
                            }
                        };
                        if(res == false){
                            $("#fac_type").append("<option></option>");
                            $(data).each(
                                function(i, d) {
                                    var id = d.id;
                                    var name = d.name;
                                    $("#fac_type").append("<option value="+id+">" + name + "</option>");
                                });
                        }else {
                            $(data).each(
                                function(i, d) {
                                    var id = d.id;
                                    var name = d.name;
                                    if(id == tmp){
                                        $("#fac_type").append("<option value="+id+" selected>" + name + "</option>");
                                    }else {
                                        $("#fac_type").append("<option value="+id+">" + name + "</option>");
                                    }
                                });
                        }


                    }
                });
            })
        </script>
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
								<li><a href="index.html"><i class="fa fa-circle-o"></i> 入库管理</a></li>
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
								<li class="active"><a href="Repository_Management.html"><i class="fa fa-circle-o"></i> 仓库管理</a></li>
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
						修改仓库信息
						<small>Version 1.0</small>
					</h1>
					<ol class="breadcrumb">
						<li><i class="fa fa-database"></i> 仓储管理</li>
						<li><a href="/repository/queryRepository">仓库管理</a></li>
						<li class="active">修改仓库信息</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<!-- Info boxes -->
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title">仓库信息</h3>
								</div>
								<!-- /.box-header -->
								<!-- form start -->
								<form class="form-horizontal" action="/repository/update" method="post">
									<div class="box-body">
										<div class="form-group">
											<label class="col-sm-2 control-label">仓库ID</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" name="id" value="${repository.id}" readonly="readonly">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">仓库名称</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" name="name" value="${repository.name!""}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">所属工厂</label>

											<div class="col-sm-10">
												<select class="form-control" name="factory_id" id="fac_type">
												</select>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">仓库地址</label>


											<div class="col-sm-10">
												<input type="text" class="form-control" name="address" value="${repository.address!""}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">仓库负责人</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" name="manager" value="${repository.manager!""}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">负责人电话</label>

											<div class="col-sm-10">
												<input type="tel" class="form-control" name="manager_phone" value="${repository.manager_phone!""}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">负责人邮箱</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" name="manager_email" value="${repository.manager_email!""}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">仓库最大容量</label>

											<div class="col-sm-10">
												<input type="text" class="form-control" name="volume" value="${repository.volume!""}">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">备注</label>

											<div class="col-sm-10">
												<input type="" class="form-control" name="comment" value="${repository.comment!""}">
											</div>
										</div>
									</div>
									<!-- /.box-body -->
									<div class="box-footer">
                                        <a href="/repository/queryRepository" class="btn btn-default">取消</a>
                                        <input type="submit" value="修改" class="btn btn-info"/>
									</div>
									<!-- /.box-footer -->
								</form>
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
		<!-- ./wrapper -->


	</body>
</html>
