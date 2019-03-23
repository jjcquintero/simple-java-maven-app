<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.springapp.mvc.domain.ClientReminderResponse" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Editors</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="resources/dist/css/skins/_all-skins.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="resources/plugins/datatables/dataTables.bootstrap.css">
    <!-- daterange picker -->
    <link rel="stylesheet" href="resources/plugins/daterangepicker/daterangepicker-bs3.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <link rel="stylesheet" href="resources/plugins/iCheck/all.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%--Mainheader is added--%>
    <jsp:include page="../general/mainHeader.jsp"/>

    <%

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ArrayList<ClientReminderResponse> finalAccounts= (ArrayList<ClientReminderResponse>) request.getAttribute("finalAccounts");
        ArrayList<ClientReminderResponse> abbreviatedAccounts= (ArrayList<ClientReminderResponse>) request.getAttribute("abbreviatedAccounts");
        ArrayList<ClientReminderResponse> annualAccounts=(ArrayList<ClientReminderResponse>) request.getAttribute("annualAccounts");

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
                        <li class="active"><a href="companyHouseClients"><i class="fa fa fa-users"></i>Company House
                            Clients</a></li>
                        <li><a href="appointment-overview"><i class="fa fa-tasks"></i>Appointments</a></li>
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
                        <li><a href="#"><i class="fa fa-user-plus"></i>Create User</a></li>
                        <li><a href="#"><i class="fa fa fa-users"></i>Manage User Accounts</a></li>
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
            <h1>
                Reminders
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header">
                            <!-- tools box -->
                            <div class="pull-right box-tools">
                                <button class="btn btn-info btn-sm" data-widget="collapse" data-toggle="tooltip"
                                        title="Collapse"><i class="fa fa-minus"></i></button>
                                <button class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip"
                                        title="Remove"><i class="fa fa-times"></i></button>
                            </div>
                            <!-- /. tools -->
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body pad">

                            <div class="box-header">
                                <h4 class="box-title">Final Accounts</h4>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <table id="table1" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Clients Ref</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Due Date</th>
                                        <th>Responsible to</th>
                                        <th>Status</th>
                                        <th>Remarks</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%for(int i=0;i<finalAccounts.size();i++){%>
                                    <tr>
                                        <td><% out.print(finalAccounts.get(i).getClientRef());%></td>
                                        <td><%out.print(finalAccounts.get(i).getDetails());%></td>
                                        <td><%out.print(finalAccounts.get(i).getCompanyRegNo());%></td>
                                        <td><%out.print(finalAccounts.get(i).getDueDate());%></td>
                                        <td><%out.print(finalAccounts.get(i).getResponsilbeTo());%></td>
                                        <td><%out.print(finalAccounts.get(i).getStatus());%></td>
                                        <td><%out.print(finalAccounts.get(i).getRemarks());%></td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Clients Ref</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Due Date</th>
                                        <th>Responsible to</th>
                                        <th>Status</th>
                                        <th>Remarks</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.box-body -->
                            <!-- /.box -->


                            <div class="box-header">
                                <h4 class="box-title">Abbriviated Accounts</h4>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <table id="table2" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Clients Ref</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Due Date</th>
                                        <th>Responsible to</th>
                                        <th>Status</th>
                                        <th>Remarks</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%for(int i=0;i<finalAccounts.size();i++){%>
                                    <tr>
                                        <td><%out.print(abbreviatedAccounts.get(i).getClientRef());%></td>
                                        <td><%out.print(abbreviatedAccounts.get(i).getDetails());%></td>
                                        <td><%out.print(abbreviatedAccounts.get(i).getCompanyRegNo());%></td>
                                        <td><%out.print(abbreviatedAccounts.get(i).getDueDate());%></td>
                                        <td><%out.print(abbreviatedAccounts.get(i).getResponsilbeTo());%></td>
                                        <td><%out.print(abbreviatedAccounts.get(i).getStatus());%></td>
                                        <td><%out.print(abbreviatedAccounts.get(i).getRemarks());%></td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Clients Ref</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Due Date</th>
                                        <th>Responsible to</th>
                                        <th>Status</th>
                                        <th>Remarks</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.box-body -->


                            <div class="box-header">
                                <h4 class="box-title">Annual Return</h4>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <table id="table3" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Clients Ref</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Due Date</th>
                                        <th>Responsible to</th>
                                        <th>Status</th>
                                        <th>Remarks</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%for(int i=0;i<finalAccounts.size();i++){%>
                                    <tr>
                                        <td><%out.print(annualAccounts.get(i).getClientRef());%></td>
                                        <td><%out.print(annualAccounts.get(i).getDetails());%></td>
                                        <td><%out.print(annualAccounts.get(i).getCompanyRegNo());%></td>
                                        <td><%out.print(annualAccounts.get(i).getDueDate());%></td>
                                        <td><%out.print(annualAccounts.get(i).getResponsilbeTo());%></td>
                                        <td><%out.print(annualAccounts.get(i).getStatus());%></td>
                                        <td><%out.print(annualAccounts.get(i).getRemarks());%></td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Clients Ref</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Due Date</th>
                                        <th>Responsible to</th>
                                        <th>Status</th>
                                        <th>Remarks</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.box-body -->


                            <div class="box-header">
                                <h4 class="box-title">Vat</h4>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <table id="table4" class="table table-bordered table-hover">
                                    <thead>
                                    <tr>
                                        <th>Clients Ref</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Due Date</th>
                                        <th>Responsible to</th>
                                        <th>Status</th>
                                        <th>Remarks</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>Gecko</td>
                                        <td>Firefox 2.0</td>
                                        <td>Win 98+ / OSX.2+</td>
                                        <td>Win 98+ / OSX.2+</td>
                                        <td>1.8</td>
                                        <td>A</td>
                                        <td>A</td>
                                    </tr>
                                    <tr>
                                        <td>Gecko</td>
                                        <td>Firefox 3.0</td>
                                        <td>Win 2k+ / OSX.3+</td>
                                        <td>Win 2k+ / OSX.3+</td>
                                        <td>1.9</td>
                                        <td>A</td>
                                        <td>A</td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Clients Ref</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Due Date</th>
                                        <th>Responsible to</th>
                                        <th>Status</th>
                                        <th>Remarks</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.box-body -->
                        </div>

                        </form>
                    </div>
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col-->
    </div>
    <!-- ./row -->
    </section><!-- /.content -->
</div>
<!-- /.content-wrapper -->


<%--footer is added--%>
<jsp:include page="../general/mainfooter.jsp"/>

<!-- Control Sidebar -->

<!-- Add the sidebar's background. This div must be placed
     immediately after the control sidebar -->
<div class="control-sidebar-bg"></div>
</div><!-- ./wrapper -->
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
<script>
    $(function () {
        $('#table1').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });

        $('#table2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });

        $('#table3').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });

        $('#table4').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false
        });
    });

    function addEmailBox() {
        var div = document.getElementById("emailBox");
        div.innerHTML += "</br><input type='text' class='form-control' placeholder='Email'>";

        var div1 = document.getElementById("divBox");
        div1.innerHTML = "";
    }
</script>
</body>
</html>