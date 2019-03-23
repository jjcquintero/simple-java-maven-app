<%@ page import="com.springapp.mvc.domain.MarketingMainEntity" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%--
  Created by IntelliJ IDEA.
  User: prakhash
  Date: 26/08/15
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../general/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">


    <%--Mainheader is added--%>
    <jsp:include page="../general/mainHeader.jsp"/>


    <%

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    %>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p><%=auth.getName()%>
                    </p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- search form (Optional) -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
                </div>
            </form>
            <!-- /.search form -->

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li class="header">Control Panel</li>
                <li class="active treeview">
                    <a href="#"><i class="fa fa-globe"></i> <span>Marketing</span> <i
                            class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-file-excel-o"></i>Add to Marketing</a></li>
                        <li class="active"><a href="companyHouseClients"><i class="fa fa fa-users"></i>Company House
                            Clients</a></li>
                        <li><a href="#"><i class="fa fa-tasks"></i>Appointments</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-globe"></i> <span>Users</span> <i
                            class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-file-excel-o"></i>My profile</a></li>
                        <li><a href="get-user-edit-page"><i class="fa fa fa-users"></i>Manage my account</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-globe"></i> <span>Admin</span> <i
                            class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa fa-users"></i>Create user accounts</a></li>
                        <li><a href="#"><i class="fa fa fa-users"></i>Manage user accounts</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>Company House Clients</h1>
            <ol class="breadcrumb">
                <li><a></a><i class="fa fa-home"></i> Home</li>
                <li><a></a><i class="fa fa-globe"></i> Marketing</li>
                <li class="active"><a></a><i class="fa fa-users"></i> Company House Clients</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">

            <!-- Your Page Content Here -->
            <div class="row">
                <div class="col-xs-12">

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Data Table With Full Features</h3>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body">
                            <div id="example1_wrapper" class="dataTables_wrapper from-inlite dt-bootstrap">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <table id="example1" class="table table-bordered table-striped">
                                            <thead>
                                            <tr>
                                                <th>Trading Name At Location</th>
                                                <th>Company Reg Number</th>
                                                <th>Address Line 1</th>
                                                <th>Status</th>
                                                <th>Date Of Incorporation</th>
                                                <th>Next Account Due</th>
                                                <th>Next Return Due</th>
                                                <th>Added To Potential Client</th>
                                                <th>Registered Office</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                                List clients = (List) request.getAttribute("clients");
                                                for (int i = 0; i < clients.size(); i++) {
                                                    MarketingMainEntity marketingMainEntity = (MarketingMainEntity) clients.get(i);
                                                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                                                    Date date = new Date();
                                                    String dateCurrentString = format.format(date);

                                                    if (format.parse(dateCurrentString).before(format.parse(marketingMainEntity.getNextAccountsDue()))) {
                                            %>
                                            <tr>
                                                <td><%
                                                    out.print(marketingMainEntity.getTradingNameAtLocation()); %></td>
                                                <td><% out.print(marketingMainEntity.getCompanyRegNo()); %></td>
                                                <td><% out.print(marketingMainEntity.getAddressLine1()); %></td>
                                                <td><% out.print(marketingMainEntity.getStatus()); %></td>
                                                <td><% out.print(marketingMainEntity.getDateOfIncorporation()); %></td>
                                                <td><% out.print(marketingMainEntity.getNextAccountsDue()); %></td>
                                                <td><% out.print(marketingMainEntity.getNextReturnDue()); %></td>
                                                <td><%
                                                    out.print(marketingMainEntity.getAddedToPotentialClient()); %></td>
                                                <td><% out.print(marketingMainEntity.getRegisteredOffice()); %></td>
                                                <td style="display:none;"><% out.print("False"); %></td>
                                            </tr>
                                            <%
                                            } else {
                                            %>
                                            <tr bgcolor="#B0E0E6">
                                                <td><%
                                                    out.print(marketingMainEntity.getTradingNameAtLocation()); %></td>
                                                <td><% out.print(marketingMainEntity.getCompanyRegNo()); %></td>
                                                <td><% out.print(marketingMainEntity.getAddressLine1()); %></td>
                                                <td><% out.print(marketingMainEntity.getStatus()); %></td>
                                                <td><% out.print(marketingMainEntity.getDateOfIncorporation()); %></td>
                                                <td><% out.print(marketingMainEntity.getNextAccountsDue()); %></td>
                                                <td><% out.print(marketingMainEntity.getNextReturnDue()); %></td>
                                                <td><%
                                                    out.print(marketingMainEntity.getAddedToPotentialClient()); %></td>
                                                <td><% out.print(marketingMainEntity.getRegisteredOffice()); %></td>
                                                <td style="display:none;"><% out.print("Overdue"); %></td>
                                            </tr>
                                            <%
                                                    }

                                                }
                                            %>
                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th>Trading Name At Location</th>
                                                <th>Company Reg Number</th>
                                                <th>Address Line 1</th>
                                                <th>Status</th>
                                                <th>Date Of Incorporation</th>
                                                <th>Next Account Due</th>
                                                <th>Next Return Due</th>
                                                <th>Added To Potential Client</th>
                                                <th>Registered Office</th>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-5">
                                        <div class="dataTables_info" id="example1_info" role="status"
                                             aria-live="polite">Showing 1 to 10 of 57 entries
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
    </div>
    <!-- /.row -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<!-- Main Footer -->
<footer class="main-footer">
    <strong>Copyright &copy; 2015 <a href="http://dccaccountants.co.uk/">Daniel</a>.</strong> All rights reserved.
</footer>

<!-- Control Sidebar -->
<aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
        <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
        <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <!-- Home tab content -->
        <div class="tab-pane active" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Recent Activity</h3>
            <ul class="control-sidebar-menu">
                <li>
                    <a href="javascript::;">
                        <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                        <div class="menu-info">
                            <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                            <p>Will be 23 on April 24th</p>
                        </div>
                    </a>
                </li>
            </ul>
            <!-- /.control-sidebar-menu -->

            <h3 class="control-sidebar-heading">Tasks Progress</h3>
            <ul class="control-sidebar-menu">
                <li>
                    <a href="javascript::;">
                        <h4 class="control-sidebar-subheading">
                            Custom Template Design
                            <span class="label label-danger pull-right">70%</span>
                        </h4>

                        <div class="progress progress-xxs">
                            <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                        </div>
                    </a>
                </li>
            </ul>
            <!-- /.control-sidebar-menu -->

        </div>
        <!-- /.tab-pane -->
        <!-- Stats tab content -->
        <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
        <!-- /.tab-pane -->
        <!-- Settings tab content -->
        <div class="tab-pane" id="control-sidebar-settings-tab">
            <form method="post">
                <h3 class="control-sidebar-heading">General Settings</h3>

                <div class="form-group">
                    <label class="control-sidebar-subheading">
                        Report panel usage
                        <input type="checkbox" class="pull-right" checked>
                    </label>

                    <p>
                        Some information about this general settings option
                    </p>
                </div>
                <!-- /.form-group -->
            </form>
        </div>
        <!-- /.tab-pane -->
    </div>
</aside>
<!-- /.control-sidebar -->
<!-- Add the sidebar's background. This div must be placed
     immediately after the control sidebar -->
<div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->


<!-- jQuery 2.1.4 -->
<script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<!-- DataTables -->
<script src="resources/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="resources/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- SlimScroll -->
<script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="resources/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="resources/dist/js/demo.js"></script>
<!-- page script -->
<script>
    $(function () {
        $("#example1").DataTable();
    });
</script>
</body>
</html>
