<%@ page import="java.util.List" %>
<%@ page import="com.springapp.mvc.domain.MarketingMainEntity" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Hashtable" %>
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
<div class="wrapper" style="min-height: 300px">


    <%--Mainheader is added--%>
    <jsp:include page="../general/mainHeader.jsp"/>

    <%
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    %>

    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <jsp:include page="../general/SidebarUser.jsp"/>
            <!-- Sidebar Menu -->
            <ul class="sidebar-menu">
                <li class="header">Control Panel</li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-money"></i> <span>Daniel</span> <i
                            class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="our-client-search-otherthan-com"><i class="fa fa fa-users"></i>Daniel Clients</a></li>
                        <li><a href="get-payroll"><i class="fa fa-tasks"></i>Payroll</a></li>
                        <li><a href="get-arr-abb-finance"><i class="fa fa-tasks"></i>Financial Accounts</a></li>
                    </ul>
                </li>
                <li class="active treeview">
                    <a href="#"><i class="fa fa-globe"></i> <span>Marketing</span> <i
                            class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="add-to-marketing"><i class="fa fa-file-excel-o"></i>Add to Marketing</a></li>
                        <li><a href="companyHouseClients"><i class="fa fa fa-users"></i>Company House Clients</a></li>
                        <li class="active"><a href="appointment-overview"><i class="fa fa-tasks"></i>Appointments</a>
                        </li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-user"></i> <span>My Account</span> <i
                            class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="#"><i class="fa fa-user-secret"></i>View Profile</a></li>
                        <li><a href="get-user-edit-page"><i class="fa fa-gear"></i>Manage Account</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-wrench"></i> <span>Admin</span> <i
                            class="fa fa-angle-left pull-right"></i></a>
                    <ul class="treeview-menu">
                        <li><a href="create-user-accounts"><i class="fa fa-user-plus"></i>Create User</a></li>
                        <li><a href="manage-user-accounts"><i class="fa fa fa-users"></i>Manage User Accounts</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>


    <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper" style="min-height: 303px; max-height: 500px";>
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
                            <h3 class="col-sm-3 box-title">
                                <button class="btn btn-block btn-primary" onclick="location.href='get-overdue-csv'">
                                    Generate overdue list
                                </button>
                            </h3>
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
                                                <th hidden=""></th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <%
                                                List clients = (List) request.getAttribute("clients");
                                                Hashtable<String, String> registeredOfficeHashtable= (Hashtable<String, String>) request.getAttribute("registeredOfficeHashtable");
                                                for (int i = 0; i < clients.size(); i++) {
                                                    MarketingMainEntity marketingMainEntity = (MarketingMainEntity) clients.get(i);
                                                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                                                    Date date = new Date();
                                                    String dateCurrentString = format.format(date);
                                                    boolean val = true;
                                                    try {
                                                        val = format.parse(dateCurrentString).before(format.parse(marketingMainEntity.getNextAccountsDue()));
                                                    } catch (Exception e) {
                                                    }

                                                    if (val) {
                                            %>
                                            <tr>
                                                <td>
                                                    <a href="company-client-detail?companyRegNumber=<% out.print(marketingMainEntity.getCompanyRegNo()); %>"><%
                                                        out.print(marketingMainEntity.getTradingNameAtLocation()); %></a>
                                                </td>
                                                <td><% out.print(marketingMainEntity.getCompanyRegNo()); %></td>
                                                <td><% out.print(marketingMainEntity.getAddressLine1()); %></td>
                                                <td><% out.print(marketingMainEntity.getStatus()); %></td>
                                                <td><% out.print(marketingMainEntity.getDateOfIncorporation()); %></td>
                                                <td><% out.print(marketingMainEntity.getNextAccountsDue()); %></td>
                                                <td><% out.print(marketingMainEntity.getNextReturnDue()); %></td>
                                                <%if (marketingMainEntity.getAddedToPotentialClient().equals("False")) {%>
                                                <td><span class="label label-danger" id="stateofclient"
                                                          onclick="changeState(this,'<%=marketingMainEntity.getCompanyRegNo().toString() %>')"><%
                                                    out.print(marketingMainEntity.getAddedToPotentialClient()); %></span>
                                                </td>
                                                <%} else if (marketingMainEntity.getAddedToPotentialClient().equals("True")) {%>
                                                <td><span class="label label-success" id="stateofclient"
                                                          onclick="changeState(this,'<%=marketingMainEntity.getCompanyRegNo().toString() %>')"><%
                                                        out.print(marketingMainEntity.getAddedToPotentialClient());} %></span>
                                                </td>
                                                <td><% out.print(registeredOfficeHashtable.get(marketingMainEntity.getCompanyRegNo())); %></td>
                                                <td style="display:none;"><% out.print("Renewed"); %></td>
                                            </tr>
                                            <%
                                            } else {
                                            %>
                                            <tr bgcolor="#B0E0E6">
                                                <td>
                                                    <a href="company-client-detail?companyRegNumber=<% out.print(marketingMainEntity.getCompanyRegNo()); %>"><%
                                                        out.print(marketingMainEntity.getTradingNameAtLocation()); %></a>
                                                </td>
                                                <td><% out.print(marketingMainEntity.getCompanyRegNo()); %></td>
                                                <td><% out.print(marketingMainEntity.getAddressLine1()); %></td>
                                                <td><% out.print(marketingMainEntity.getStatus()); %></td>
                                                <td><% out.print(marketingMainEntity.getDateOfIncorporation()); %></td>
                                                <td><% out.print(marketingMainEntity.getNextAccountsDue()); %></td>
                                                <td><% out.print(marketingMainEntity.getNextReturnDue()); %></td>
                                                <%if (marketingMainEntity.getAddedToPotentialClient().equals("False")) {%>
                                                <td><span class="label label-danger" id="stateofclient"
                                                          onclick="changeState(this,'<%=marketingMainEntity.getCompanyRegNo().toString() %>')"><%
                                                    out.print(marketingMainEntity.getAddedToPotentialClient()); %></span>
                                                </td>
                                                <%} else if (marketingMainEntity.getAddedToPotentialClient().equals("True")) {%>
                                                <td><span class="label label-success" id="stateofclient"
                                                          onclick="changeState(this,'<%=marketingMainEntity.getCompanyRegNo().toString()%>')"><%
                                                        out.print(marketingMainEntity.getAddedToPotentialClient());
                                                    } %></span>
                                                </td>
                                                <td><% out.print(registeredOfficeHashtable.get(marketingMainEntity.getCompanyRegNo()));%></td>
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
                                                <th></th>
                                            </tr>
                                            </tfoot>
                                        </table>
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
            <!-- /.row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <%--footer is added--%>
    <jsp:include page="../general/mainfooter.jsp"/>


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
                <!-- /.control-sidebar-menu -->
                <!-- /.control-sidebar-menu -->

            </div>
            <!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">

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


    function changeState(cell, comid) {

        "use strict";
        if (cell.className == "label label-success") {
            cell.innerHTML = "False";
            cell.className = "label label-danger";
        }
        else if (cell.className == "label label-danger") {
            cell.innerHTML = "True";
            cell.className = "label label-success";
        }

        // get the form values
        var value = cell.innerHTML;
        var comid = comid;

        event.preventDefault();
        $.ajax({

            type: "POST",
            url: "update-potential-client",
            data: "comid=" + comid + "&value=" + value,
            success: function (response) {
                // we have the response
                $('#info').html(response);
                $('#comid').val('');
                $('#value').val('');
            },
            error: function (e) {
                alert('Error: ' + e + comid + "  " + value);
            }
        });

    }


    $(function () {
        $("#example1").DataTable();
    });
</script>
</body>
</html>
