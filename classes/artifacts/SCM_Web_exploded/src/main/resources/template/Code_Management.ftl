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
        <!-- DataTables -->
        <script src="/static/js/jquery.dataTables.min.js"></script>
        <script src="/static/js/dataTables.bootstrap.min.js"></script>
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
                $("#fac_type1").empty();
                $.ajax({
                    async : true,
                    dataType : "json",
                    url : "/factory/ajax_queryFactory",
                    error : function(xhr, status) {
                        console.log(status);
                    },
                    success : function(data) {
                        console.log("1",data)
                        $("#fac_type1").append("<option></option>");
                        $(data).each(
                                function(i, d) {
                                    var id = d.id;
                                    var name = d.name;
                                    $("#fac_type1").append("<option value="+id+">" + name + "</option>");
                                });
                    }
                });
            })
        </script>
        <script>
            $(function() {
                $("#main_code_type1").empty();
                $.ajax({
                    async : true,
                    dataType : "json",
                    url : "/product/ajax_queryMainCode",
                    error : function(xhr, status) {
                        console.log(status);
                    },
                    success : function(data) {
                        console.log("2",data)
                        $("#main_code_type1").append("<option></option>");
                        $(data).each(
                                function(i, d) {
                                    var main_code = d.main_code;
                                    $("#main_code_type1").append("<option value="+main_code+">" + main_code + "</option>");
                                });
                    }
                });
            })
        </script>
        <script>
            $(function() {
                $("#code_type1").empty();
                $.ajax({
                    async : true,
                    dataType : "json",
                    url : "/product/ajax_queryCodes",
                    error : function(xhr, status) {
                        console.log(status);
                    },
                    success : function(data) {
                        console.log("3",data);
                        $("#code_type1").append("<option></option>");
                        $(data).each(
                                function(i, d) {
                                    var code = d.code;
                                    $("#code_type1").append("<option value="+code+">" + code + "</option>");
                                });
                    }
                });
            })
        </script>
        <script>
            $(function() {
                $("#main_fac_type").empty();
                $.ajax({
                    async : true,
                    dataType : "json",
                    url : "/factory/ajax_queryMainFactory",
                    error : function(xhr, status) {
                        console.log(status);
                    },
                    success : function(data) {
                        console.log("4",data);
                        $("#main_fac_type").append("<option></option>");
                        $(data).each(
                                function(i, d) {
                                    var id = d.id;
                                    var name = d.name;
                                    $("#main_fac_type").append("<option value="+id+">" + name + "</option>");
                                });
                    }
                });
            })
        </script>
        <script>
            $(function() {
                $("#fac_type").empty();
                $.ajax({
                    async : true,
                    dataType : "json",
                    url : "/factory/ajax_queryOtherFactory",
                    error : function(xhr, status) {
                        console.log(status);
                    },
                    success : function(data) {
                        console.log("5",data);
                        $("#fac_type").append("<option></option>");
                        $(data).each(
                                function(i, d) {
                                    var id = d.id;
                                    var name = d.name;
                                    $("#fac_type").append("<option value="+id+">" + name + "</option>");
                                });
                    }
                });
            })
        </script>
        <script>
            function jump_query_main_code() {
                var myselect = document.getElementById("main_fac_type");
                var index = myselect.selectedIndex;
                var fac_val = myselect.options[index].value;
                $("#main_code_type").empty();
                $.ajax({
                    async : true,
                    dataType : "json",
                    url : "/product/ajax_queryMainCode?id="+fac_val,
                    error : function(xhr, status) {
                        console.log(status);
                    },
                    success : function(data) {
                        console.log("6",data)
                        $("#main_code_type").append("<option></option>");
                        $(data).each(
                                function(i, d) {
                                    var main_code = d.main_code;
                                    $("#main_code_type").append("<option value="+main_code+">" + main_code + "</option>");
                                });
                    }
                });
            }
        </script>
        <script>
            function jump_query_code() {
                var myselect = document.getElementById("fac_type");
                var index = myselect.selectedIndex;
                var fac_val = myselect.options[index].value;
                $("#code_type").empty();
                $.ajax({
                    async : true,
                    dataType : "json",
                    url : "/product/ajax_queryCodes?id="+fac_val,
                    error : function(xhr, status) {
                        console.log(status);
                    },
                    success : function(data) {
                        console.log("7",data);
                        $("#code_type").append("<option></option>");
                        $(data).each(
                                function(i, d) {
                                    var code = d.code;
                                    $("#code_type").append("<option value="+code+">" + code + "</option>");
                                });
                    }
                });
            }
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
								<li><a href="Repository_Management.html"><i class="fa fa-circle-o"></i> 仓库管理</a></li>
								<li><a href="Product_Management.html"><i class="fa fa-circle-o"></i> 商品管理</a></li>
								<li class="active"><a href=""><i class="fa fa-circle-o"></i> 编码管理</a></li>
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
						编码管理
						<small>Version 1.0</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-database"></i> 仓储管理</a></li>
						<li class="active">编码管理</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<!-- Info boxes -->
					<div class="row">
						<div class="col-md-6 col-sm-6 col-xs-12">
							<div class="info-box">
								<span class="info-box-icon bg-yellow"><i class="fa fa-anchor"></i></span>

								<div class="info-box-content">
									<span class="info-box-text">???</span>
									<span class="info-box-number">???</span>
								</div>
								<!-- /.info-box-content -->
							</div>
							<!-- /.info-box -->
						</div>
						<!-- /.col -->
						<div class="col-md-6 col-sm-6 col-xs-12">
							<div class="info-box">
								<span class="info-box-icon bg-aqua"><i class="fa fa-rebel"></i></span>

								<div class="info-box-content">
									<span class="info-box-text">???</span>
									<span class="info-box-number">??<small>?</small></span>
								</div>
								<!-- /.info-box-content -->
							</div>
							<!-- /.info-box -->
						</div>
						<!-- /.col -->

						<!-- fix for small devices only -->
						<div class="clearfix visible-sm-block"></div>

					</div>
					<!-- /.row -->

					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-body">
									<div class="row">
										<div class="col-md-8">
											<form class="form-horizontal" action="/product/queryCodes" method="post">
												<div class="box-body">
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">所属工厂</label>

														<div class="col-sm-8">
															<select class="form-control" name="factory_id" id="fac_type1" onchange="jump_query_rep()">
															</select>
														</div>

													</div>

													<div class="form-group col-md-6" style="visibility: hidden;">
														<label class="col-sm-4 control-label"></label>

														<div class="col-sm-8">
															<select class="form-control">
															</select>
														</div>
													</div>

													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品主编码</label>

														<div class="col-sm-8">
                                                            <select class="form-control" name="main_code" id="main_code_type1">
                                                            </select>
														</div>
													</div>

													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品编码</label>

														<div class="col-sm-8">
                                                            <select class="form-control" name="code" id="code_type1">
                                                            </select>
														</div>
													</div>
												</div>
												<!-- /.box-body -->
												<!-- <div class="box-footer">
													<button type="submit" class="btn btn-default">Cancel</button>
													<button type="submit" class="btn btn-info pull-right">Sign in</button>
												</div> -->
												<!-- /.box-footer -->

											<!-- /.chart-responsive -->
										</div>
										<!-- /.col -->
										<div class="col-md-4">
											<div class="box-body">
                                                <input type="submit" value="查询" class="btn btn-primary col-md-5 col-sm-5 col-xs-5" />
											</div>
										</div>
                                        </form>
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

					<div class="row">
						<div class="col-md-12">
							<div class="box box-primary">
								<div class="box-body">
									<div class="row">
										<div class="col-md-8">
											<form class="form-horizontal" action="/product/insert_main_code_update" method="post">
												<div class="box-body">
													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">主工厂</label>

														<div class="col-sm-8">
															<select class="form-control" id="main_fac_type" onchange="jump_query_main_code()">
															</select>
														</div>

													</div>

													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品主编码</label>

														<div class="col-sm-8">
															<select class="form-control" name="main_code" id="main_code_type">
															</select>
														</div>
													</div>

													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">分工厂</label>

														<div class="col-sm-8">
															<select class="form-control" name="factory_id" id="fac_type" onchange="jump_query_code()">
															</select>
														</div>
													</div>

													<div class="form-group col-md-6">
														<label class="col-sm-4 control-label">商品编码</label>

														<div class="col-sm-8">
															<select class="form-control" name="code" id="code_type">
															</select>
														</div>
													</div>
												</div>
												<!-- /.box-body -->
												<!-- <div class="box-footer">
																		<button type="submit" class="btn btn-default">Cancel</button>
																		<button type="submit" class="btn btn-info pull-right">Sign in</button>
																	</div> -->
												<!-- /.box-footer -->
											<!-- /.chart-responsive -->
										</div>
										<!-- /.col -->
										<div class="col-md-4">
											<div class="box-body">
                                                <input type="submit" class="btn btn-primary col-md-5 col-sm-5 col-xs-5" value="添加">
											</div>
										</div>
                                        </form>
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

					<div class="row">
						<div class="col-md-12 col-xs-12">
							<div class="box box-primary">
								<div class="box-header">
									<h3 class="box-title">编码信息</h3>
								</div>
								<!-- /.box-header -->
								<div class="box-body table-responsive">
									<table id="example1" class="table table-bordered table-striped">
										<thead>
											<tr>
												<th>商品ID</th>
												<th>所属工厂</th>
												<th>商品主编码</th>
												<th>商品编码</th>
												<th>商品名称</th>
												<th>备注</th>
                                                <th>删除</th>
											</tr>
										</thead>
										<tbody>
                                        <#list products as item>
											<tr>
                                                <td>${item.id!""}</td>
                                                <td>${item.factory_name!""}</td>
                                                <td>${item.main_code!""}</td>
                                                <td>${item.code!""}</td>
                                                <td>${item.name!""}</td>
                                                <td>${item.comment!""}</td>
                                                <td style="text-align: center;"><a href="javascript:deleteById('${item.id}')"><i class="fa fa-remove"></i></a></td>
											</tr>
                                        </#list>
											</tfoot>
									</table>
								</div>
								<!-- /.box-body -->
							</div>
						</div>
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
            $(function () {
                $('#example1').DataTable()
            });
            function deleteById(id) {
                if (confirm("确定删除该条编码信息吗？")) {
                    //删除药品
                    location.href = "/product/delete_main_code_update?id=" + id;
                }
            }
		</script>
		<!-- ./wrapper -->


	</body>
</html>
