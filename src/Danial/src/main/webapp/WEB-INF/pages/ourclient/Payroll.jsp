<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.util.List" %>
<%@ page import="com.springapp.mvc.domain.OurClientsNewEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.springapp.mvc.domain.PayrollEntity" %>
<%@ page import="java.util.Calendar" %>
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
        ArrayList<PayrollEntity> PayrollEntityList = (ArrayList<PayrollEntity>) request.getAttribute("payrollList");

        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = (now.get(Calendar.MONTH) + 1);
    %>
    <%!
        public String getClassLable(String param) {
            //
            if (param.equals("Pending")) {
                return "label label-warning";
            } else if (param.equals("Denied")) {
                return "label label-danger";
            } else {
                return "label label-success";
            }
        }
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
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">Payroll</h3>

                            <div class="box-tools">
                                <div class="input-group" style="width: 150px;">
                                    <input type="text" name="table_search" class="form-control input-sm pull-right"
                                           placeholder="Search">

                                    <div class="input-group-btn">
                                        <button class="btn btn-sm btn-default"><i class="fa fa-search"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding">
                            <table class="table table-bordered table-hover">
                                <tr>
                                <tr>
                                    <th>Clients Ref</th>
                                    <th>Name of the Client</th>
                                    <th>Payment Method</th>
                                    <th>Email</th>
                                    <th>Upto Period</th>
                                    <th>PS/PR EX</th>
                                    <th>LETTER</th>
                                    <th>Checked</th>
                                    <th>PS PRI</th>
                                    <th>LET.PR</th>
                                    <th>e.Mail</th>
                                    <th>Post</th>


                                    <%if (month == 1) {%>
                                    <th>RTI Nov</th>
                                    <th>RTI Dec</th>
                                    <th>RTI Jan</th>
                                    <%} else if (month == 2) {%>
                                    <th>RTI Dec</th>
                                    <th>RTI Jan</th>
                                    <th>RTI Feb</th>
                                    <%} else if (month == 3) {%>
                                    <th>RTI Jan</th>
                                    <th>RTI Feb</th>
                                    <th>RTI Mar</th>
                                    <%} else if (month == 4) {%>
                                    <th>RTI Feb</th>
                                    <th>RTI Mar</th>
                                    <th>RTI Apr</th>
                                    <%} else if (month == 5) {%>
                                    <th>RTI Mar</th>
                                    <th>RTI Apr</th>
                                    <th>RTI May</th>
                                    <%} else if (month == 6) {%>
                                    <th>RTI Apr</th>
                                    <th>RTI May</th>
                                    <th>RTI Jun</th>
                                    <%} else if (month == 7) {%>
                                    <th>RTI May</th>
                                    <th>RTI Jun</th>
                                    <th>RTI Jul</th>
                                    <%} else if (month == 8) {%>
                                    <th>RTI Jun</th>
                                    <th>RTI Jul</th>
                                    <th>RTI Aug</th>
                                    <%} else if (month == 9) {%>
                                    <th>RTI Jul</th>
                                    <th>RTI Aug</th>
                                    <th>RTI Sep</th>
                                    <%} else if (month == 10) {%>
                                    <th>RTI Aug</th>
                                    <th>RTI Sep</th>
                                    <th>RTI Oct</th>
                                    <%} else if (month == 11) {%>
                                    <th>RTI Sep</th>
                                    <th>RTI Oct</th>
                                    <th>RTI Nov</th>
                                    <%} else if (month == 12) {%>
                                    <th>RTI Oct</th>
                                    <th>RTI Nov</th>
                                    <th>RTI Dec</th>
                                    <%}%>
                                    <th>Comments</th>
                                    <th></th>
                                </tr>
                                </tr>
                                <%for (int i = 0; i < PayrollEntityList.size(); i++) {%>
                                <tr>
                                    <td><span id="comRef" name="comRef"><%
                                        out.print(PayrollEntityList.get(i).getComRef()); %></span></td>
                                    <td><span id="nameOfTheClient" name="nameOfTheClient"><%
                                        out.print(PayrollEntityList.get(i).getNameOfTheClient());%></span></td>
                                    <td><span id="paymentMethod" name="paymentMethod"><%
                                        out.print(PayrollEntityList.get(i).getPaymentMethod());%></span></td>
                                    <td><span id="email" name="email"><%
                                        out.print(PayrollEntityList.get(i).getEmail());%></span></td>
                                    <td><span id="upToPeriod" name="upToPeriod"><%
                                        out.print(PayrollEntityList.get(i).getUpToPeriod());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getPsPrEx().toString())%>"
                                            id="psPrEx" name="psPrEx"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','psPrEx')"><%
                                        out.print(PayrollEntityList.get(i).getPsPrEx());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getLetter().toString())%>"
                                            id="letter" name="letter"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','letter')"><%
                                        out.print(PayrollEntityList.get(i).getLetter());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getChecked().toString())%>"
                                            id="checked" name="checked"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','checked')"><%
                                        out.print(PayrollEntityList.get(i).getChecked());%></span></td>
                                    <td><span class="<%=getClassLable(PayrollEntityList.get(i).getPsPri().toString())%>"
                                              id="psPri" name="psPri"
                                              onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','psPri')"><%
                                        out.print(PayrollEntityList.get(i).getPsPri());%></span></td>
                                    <td><span class="<%=getClassLable(PayrollEntityList.get(i).getLetPr().toString())%>"
                                              id="letPr" name="letPr"
                                              onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','letPr')"><%
                                        out.print(PayrollEntityList.get(i).getLetPr());%></span></td>
                                    <td><span class="<%=getClassLable(PayrollEntityList.get(i).geteMail().toString())%>"
                                              id="eMail" name="eMail"
                                              onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','eMail')"><%
                                        out.print(PayrollEntityList.get(i).geteMail());%></span></td>
                                    <td><span class="<%=getClassLable(PayrollEntityList.get(i).getPost().toString())%>"
                                              id="post" name="post"
                                              onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','post')"><%
                                        out.print(PayrollEntityList.get(i).getPost());%></span></td>
                                    <%if (month == 1) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiNov().toString())%>"
                                            id="rtiNov" name="rtiNov"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiNov')"><%
                                        out.print(PayrollEntityList.get(i).getRtiNov());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiDec().toString())%>"
                                            id="rtiDec" name="rtiDec"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiDec')"><%
                                        out.print(PayrollEntityList.get(i).getRtiDec());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiJan().toString())%>"
                                            id="rtiJan" name="rtiJan"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiJan')"><%
                                        out.print(PayrollEntityList.get(i).getRtiJan());%></span></td>
                                    <%} else if (month == 2) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiDec().toString())%>"
                                            id="rtiDec" name="rtiDec"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiDec')"><%
                                        out.print(PayrollEntityList.get(i).getRtiDec());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiJan().toString())%>"
                                            id="rtiJan" name="rtiJan"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiJan')"><%
                                        out.print(PayrollEntityList.get(i).getRtiJan());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiFeb().toString())%>"
                                            id="rtiFeb" name="rtiFeb"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiFeb')"><%
                                        out.print(PayrollEntityList.get(i).getRtiFeb());%></span></td>
                                    <%} else if (month == 3) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiJan().toString())%>"
                                            id="rtiJan" name="rtiJan"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiJan')"><%
                                        out.print(PayrollEntityList.get(i).getRtiJan());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiFeb().toString())%>"
                                            id="rtiFeb" name="rtiFeb"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiFeb')"><%
                                        out.print(PayrollEntityList.get(i).getRtiFeb());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiMar().toString())%>"
                                            id="rtiMar" name="rtiMar"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiMar')"><%
                                        out.print(PayrollEntityList.get(i).getRtiMar());%></span></td>
                                    <%} else if (month == 4) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiFeb().toString())%>"
                                            id="rtiFeb" name="rtiFeb"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiFeb')"><%
                                        out.print(PayrollEntityList.get(i).getRtiFeb());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiMar().toString())%>"
                                            id="rtiMar" name="rtiMar"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiMar')"><%
                                        out.print(PayrollEntityList.get(i).getRtiMar());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiApr().toString())%>"
                                            id="rtiApr" name="rtiApr"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiApr')"><%
                                        out.print(PayrollEntityList.get(i).getRtiApr());%></span></td>
                                    <%} else if (month == 5) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiMar().toString())%>"
                                            id="rtiMar" name="rtiMar"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiMar')"><%
                                        out.print(PayrollEntityList.get(i).getRtiMar());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiApr().toString())%>"
                                            id="rtiApr" name="rtiApr"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiApr')"><%
                                        out.print(PayrollEntityList.get(i).getRtiApr());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiMay().toString())%>"
                                            id="rtiMay" name="rtiMay"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiMay')"><%
                                        out.print(PayrollEntityList.get(i).getRtiMay());%></span></td>
                                    <%} else if (month == 6) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiApr().toString())%>"
                                            id="rtiApr" name="rtiApr"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiApr')"><%
                                        out.print(PayrollEntityList.get(i).getRtiApr());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiMay().toString())%>"
                                            id="rtiMay" name="rtiMay"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiMay')"><%
                                        out.print(PayrollEntityList.get(i).getRtiMay());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiJun().toString())%>"
                                            id="rtiJun" name="rtiJun"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiJun')"><%
                                        out.print(PayrollEntityList.get(i).getRtiJun());%></span></td>
                                    <%} else if (month == 7) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiMay().toString())%>"
                                            id="rtiMay" name="rtiMay"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiMay')"><%
                                        out.print(PayrollEntityList.get(i).getRtiMay());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiJun().toString())%>"
                                            id="rtiJun" name="rtiJun"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiJun')"><%
                                        out.print(PayrollEntityList.get(i).getRtiJun());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiJul().toString())%>"
                                            id="rtiJul" name="rtiJul"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiJul')"><%
                                        out.print(PayrollEntityList.get(i).getRtiJul());%></span></td>
                                    <%} else if (month == 8) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiJun().toString())%>"
                                            id="rtiJun" name="rtiJun"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiJun')"><%
                                        out.print(PayrollEntityList.get(i).getRtiJun());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiJul().toString())%>"
                                            id="rtiJul" name="rtiJul"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiJul')"><%
                                        out.print(PayrollEntityList.get(i).getRtiJul());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiAug().toString())%>"
                                            id="rtiAug" name="rtiAug"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiAug')"><%
                                        out.print(PayrollEntityList.get(i).getRtiAug());%></span></td>
                                    <%} else if (month == 9) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiJul().toString())%>"
                                            id="rtiJul" name="rtiJul"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiJul')"><%
                                        out.print(PayrollEntityList.get(i).getRtiJul());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiAug().toString())%>"
                                            id="rtiAug" name="rtiAug"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiAug')"><%
                                        out.print(PayrollEntityList.get(i).getRtiAug());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiSep().toString())%>"
                                            id="rtiSep" name="rtiSep"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiSep')"><%
                                        out.print(PayrollEntityList.get(i).getRtiSep());%></span></td>
                                    <%} else if (month == 10) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiAug().toString())%>"
                                            id="rtiAug" name="rtiAug"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiAug')"><%
                                        out.print(PayrollEntityList.get(i).getRtiAug());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiSep().toString())%>"
                                            id="rtiSep" name="rtiSep"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiSep')"><%
                                        out.print(PayrollEntityList.get(i).getRtiSep());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiOct().toString())%>"
                                            id="rtiOct" name="rtiOct"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiOct')"><%
                                        out.print(PayrollEntityList.get(i).getRtiOct());%></span></td>
                                    <%} else if (month == 11) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiSep().toString())%>"
                                            id="rtiSep" name="rtiSep"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiSep')"><%
                                        out.print(PayrollEntityList.get(i).getRtiSep());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiOct().toString())%>"
                                            id="rtiOct" name="rtiOct"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiOct')"><%
                                        out.print(PayrollEntityList.get(i).getRtiOct());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiNov().toString())%>"
                                            id="rtiNov" name="rtiNov"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiNov')"><%
                                        out.print(PayrollEntityList.get(i).getRtiNov());%></span></td>
                                    <%} else if (month == 12) {%>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiOct().toString())%>"
                                            id="rtiOct" name="rtiOct"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiOct')"><%
                                        out.print(PayrollEntityList.get(i).getRtiOct());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiNov().toString())%>"
                                            id="rtiNov" name="rtiNov"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiNov')"><%
                                        out.print(PayrollEntityList.get(i).getRtiNov());%></span></td>
                                    <td><span
                                            class="<%=getClassLable(PayrollEntityList.get(i).getRtiDec().toString())%>"
                                            id="rtiDec" name="rtiDec"
                                            onclick="changeState(this,'<%=PayrollEntityList.get(i).getComRef().toString() %>','rtiDec')"><%
                                        out.print(PayrollEntityList.get(i).getRtiDec());%></span></td>
                                    <%}%>
                                    <td>
                                    <input type="text" id="comments"
                                           onkeypress="updateComment(this,'<%=PayrollEntityList.get(i).getComRef().toString()%>')"
                                           value="<%=PayrollEntityList.get(i).getComments()%>">
                                    </td>
                                </tr>
                                <%}%>
                            </table>

                        </div>
                        <!-- /.box-body -->
                        <div>
                            </br>
                            <table>
                                <tr>
                                    <td style="width:900px"></td>
                                    <td style="width:150px">
                                        <button class="btn btn-block btn-success btn-sm">See Full Table</button>
                                    </td>
                                </tr>
                            </table>
                            </br>
                        </div>
                    </div>
                    <!-- /.box -->
                </div>

            </div>
            <!-- ./row -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->


    <%--footer is added--%>
    <jsp:include page="../general/mainfooter.jsp"/>

    <!-- Control Sidebar -->

    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->
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

    function updateComment(ele, comid) {
        if (event.keyCode == 13) {
            var value = ele.value;

            event.preventDefault();
            $.ajax({

                type: "POST",
                url: "update-payroll-coments",
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
    }

    function addEmailBox() {
        var div = document.getElementById("emailBox");
        div.innerHTML += "</br><input type='text' class='form-control' placeholder='Email'>";

        var div1 = document.getElementById("divBox");
        div1.innerHTML = "";
    }
</script>

<script>
    function changeState(cell, comid, coloumn) {
        "use strict";
        if (cell.className == "label label-success") {
            cell.innerHTML = "Denied";
            cell.className = "label label-danger";
        }
        else if (cell.className == "label label-danger") {
            cell.innerHTML = "Pending";
            cell.className = "label label-warning";
        }
        else if (cell.className == "label label-warning") {
            cell.innerHTML = "Accepted";
            cell.className = "label label-success";
        }

        // get the form values
        var value = cell.innerHTML;
        var comid = comid;
        var coloumn = coloumn;

        event.preventDefault();
        $.ajax({

            type: "POST",
            url: "update-payroll-values",
            data: "comid=" + comid + "&value=" + value + "&coloumn=" + coloumn,
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

</script>
</body>
</html>
