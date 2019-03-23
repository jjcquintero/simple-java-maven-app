<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.util.List" %>
<%@ page import="com.springapp.mvc.domain.OurClientsNewEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
        ArrayList<OurClientsNewEntity> ourClientsNewEntityList = (ArrayList<OurClientsNewEntity>) request.getAttribute("ourClientsNewEntityList");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

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
                        <li><a href="our-client-search-otherthan-com"><i class="fa fa fa-users"></i>Daniel Clients</a>
                        </li>
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
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Accounts Details
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
                                <h4 class="box-title">ARR, ABB & Final Accounts</h4>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <table id="table1" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Clients</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Final Accounts</th>
                                        <th>Abbreviated</th>
                                        <th>Anual Return</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%for (int i = 0; i < ourClientsNewEntityList.size(); i++) {%>
                                    <%
                                        Date date2=null;
                                        Date date3=null;
                                        if(ourClientsNewEntityList.get(i).getAccountNextAcDue1()!=null && !ourClientsNewEntityList.get(i).getAccountNextAcDue1().equals("")) {
                                            String date2Strng=ourClientsNewEntityList.get(i).getAccountNextAcDue1().toString();
                                            date2 = dateFormat.parse(date2Strng);
                                        }
                                        if(ourClientsNewEntityList.get(i).getAccountNextAcDue1()!=null && !ourClientsNewEntityList.get(i).getAccountNextAcDue1().equals("")) {
                                            String date3String=ourClientsNewEntityList.get(i).getAnnualNextArDue().toString();
                                            date3 = dateFormat.parse(date3String);
                                        }
                                        if ( date2!=null && date2.before(date) || date3!=null && date3.before(date)) {
                                    %>
                                    <tr>
                                        <td bgcolor="#dc143c"><%out.print(ourClientsNewEntityList.get(i).getClientRef());%></td>
                                        <td bgcolor="#dc143c"><%out.print(ourClientsNewEntityList.get(i).getCompanyName());%></td>
                                        <td bgcolor="#dc143c"><%out.print(ourClientsNewEntityList.get(i).getComRegNo());%></td>
                                        <td bgcolor="#dc143c"><%
                                            out.print(ourClientsNewEntityList.get(i).getAccountReferrenceDate());%></td>
                                        <td bgcolor="#dc143c"><%out.print(ourClientsNewEntityList.get(i).getAccountNextAcDue1());%></td>
                                        <td bgcolor="#dc143c"><%out.print(ourClientsNewEntityList.get(i).getAnnualNextArDue());%></td>
                                    </tr>
                                    <%} else {%>
                                    <tr>
                                        <td><%out.print(ourClientsNewEntityList.get(i).getClientRef());%></td>
                                        <td><%out.print(ourClientsNewEntityList.get(i).getCompanyName());%></td>
                                        <td><%out.print(ourClientsNewEntityList.get(i).getComRegNo());%></td>
                                        <td><%
                                            out.print(ourClientsNewEntityList.get(i).getAccountReferrenceDate());%></td>
                                        <td><%out.print(ourClientsNewEntityList.get(i).getAccountNextAcDue1());%></td>
                                        <td><%out.print(ourClientsNewEntityList.get(i).getAnnualNextArDue());%></td>
                                    </tr>
                                    <%}%>

                                    <%}%>
                                    <tr>
                                        <td>Gecko</td>
                                        <td>Netscape Browser 8</td>
                                        <td>Win 98SE+</td>
                                        <td>Win 98SE+</td>
                                        <td>1.7</td>
                                        <td>A</td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Clients</th>
                                        <th>Details</th>
                                        <th>Reg No</th>
                                        <th>Final Accounts</th>
                                        <th>Abbreviated</th>
                                        <th>Anual Return</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.box-body -->
                            <!-- /.box -->


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
        $("#table1").DataTable();

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