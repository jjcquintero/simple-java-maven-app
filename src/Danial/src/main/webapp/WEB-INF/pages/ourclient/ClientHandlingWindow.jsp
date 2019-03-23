<%@ page import="com.springapp.mvc.domain.BusinessOfficeEntity" %>
<%@ page import="com.springapp.mvc.domain.OurClientsNewEntity" %>
<%@ page import="com.springapp.mvc.domain.PostalOfficeEntity" %>
<%@ page import="com.springapp.mvc.domain.RegisteredOfficeEntity" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
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
        OurClientsNewEntity ourClientsNewEntity = (OurClientsNewEntity) request.getAttribute("ourClientsNewEntity");
        RegisteredOfficeEntity registeredOfficeEntity = (RegisteredOfficeEntity) request.getAttribute("registeredOfficeEntity");
        BusinessOfficeEntity businessOfficeEntity = (BusinessOfficeEntity) request.getAttribute("businessOfficeEntity");
        PostalOfficeEntity postalOfficeEntity = (PostalOfficeEntity) request.getAttribute("postalOfficeEntity");
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
                Search & Edit
                <small>Danial Clients</small>
            </h1>
        </section>


        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-11">
                    <div class="box box-info">
                        <div class="box-header">
                            <h3 class="box-title">Search Clients</h3>
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
                        <div class="box-body pad ">
                            <form id="process-handling-window" action="process-client-handling-window" method="post">
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Client Ref" value="<% out.print(ourClientsNewEntity.getClientRef());%>"
                                               name="clientRef" id="clientRef" style="width: 120px;">
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td><input
                                                        value="<% out.print(ourClientsNewEntity.getCompanyName());%>"
                                                        type="text" class="form-control" placeholder="Company Name"
                                                        name="companyName" style="width: 330px;"
                                                        id="textChangeState1"></td>
                                                <td style="width: 15px;"></td>
                                                <td><input type="checkbox" class="flat-red"
                                                           onclick="OnChangeCheckbox (this)" id="enablingCheckBox"></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td><input
                                                        value="<% out.print(ourClientsNewEntity.getComRegNo());%>"
                                                        type="text" class="form-control" name="comRegNo"
                                                        placeholder="Registration No" style="width: 120px;"></td>
                                                <td style="width: 150px;"></td>
                                                <td>
                                                    <select name="type" class="form-control"
                                                            style="width: 120px;">
                                                        <option>Private company Limited by share</option>
                                                        <option>Private company Limited by guranteed</option>
                                                        <option>Sloe trader</option>
                                                        <option>Partnership</option>
                                                    </select>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td><input value="<% registeredOfficeEntity.getRegionR();%>" type="text"
                                                           class="form-control"
                                                           name="placeOfReg"
                                                           placeholder="Place of Reg" style="width: 120px;"
                                                           id="textChangeState2"></td>
                                                <td style="width: 150px;"></td>
                                                <td><input value="<% out.print(ourClientsNewEntity.getStatus());%>"
                                                           type="text" class="form-control" name="status"
                                                           placeholder="Status" style="width: 120px;"
                                                           id="textChangeState3"></td>
                                            </tr>
                                        </table>
                                    </div>
                                    </br>
                                    </br>
                                    <label>Address Details</label>

                                    <div class="nav-tabs-custom">
                                        <ul class="nav nav-tabs">
                                            <li class="active"><a href="#tab_1" data-toggle="tab">Reg Office</a></li>
                                            <li><a href="#tab_2" data-toggle="tab">Business</a></li>
                                            <li><a href="#tab_3" data-toggle="tab">Postal</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="tab_1">
                                                <div class="form-group">
                                                    <input placeholder="c/o" name="careOfR" type="text"
                                                           class="form-control"
                                                           value="<% out.print(registeredOfficeEntity.getCareOfR()); %>">
                                                    <input placeholder="AddressLine1" name="addressLine1R" type="text"
                                                           class="form-control"
                                                           value="<% out.print(registeredOfficeEntity.getAddressLine1R()); %>">
                                                    <input placeholder="AddressLine2" name="addressLine2R" type="text"
                                                           class="form-control"
                                                           value="<% out.print(registeredOfficeEntity.getAddressLine2R()); %>">
                                                    <input placeholder="AddressLine3" name="addressLine3R" type="text"
                                                           class="form-control"
                                                           value="<% out.print(registeredOfficeEntity.getAddressLine3R()); %>">
                                                    <input placeholder="AddressLine4" name="addressLine4R" type="text"
                                                           class="form-control"
                                                           value="<% out.print(registeredOfficeEntity.getAddressLine4R()); %>">
                                                    <input placeholder="Region" name="regionR" type="text"
                                                           class="form-control"
                                                           value="<% out.print(registeredOfficeEntity.getRegionR()); %>">
                                                    <input placeholder="Locality" name="localityR" type="text"
                                                           class="form-control"
                                                           value="<% out.print(registeredOfficeEntity.getLocalityR()); %>">
                                                    <input placeholder="Postal Code" name="postcodeR" type="text"
                                                           class="form-control"
                                                           value="<% out.print(registeredOfficeEntity.getPostalCodeR()); %>">
                                                </div>

                                            </div>
                                            <!-- /.tab-pane -->
                                            <div class="tab-pane" id="tab_2">
                                                <div class="form-group">
                                                    <input value="<% out.print(businessOfficeEntity.getCareOfB()); %>"
                                                           name="careOfB" type="text" class="form-control"
                                                           placeholder="Correspondent">
                                                    <input name="addressLine1B"
                                                           value="<% out.print(businessOfficeEntity.getAddressLine1B()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Address Line 1">
                                                    <input name="addressLine2B"
                                                           value="<% out.print(businessOfficeEntity.getAddressLine2B()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Address Line 2">
                                                    <input name="addressLine3B"
                                                           value="<% out.print(businessOfficeEntity.getAddressLine3B()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Address Line 3">
                                                    <input name="addressLine4B"
                                                           value="<% out.print(businessOfficeEntity.getAddressLine4B()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Address Line 4">
                                                    <input name="localityB"
                                                           value="<% out.print(businessOfficeEntity.getLocalityB()); %>"
                                                           type="text" class="form-control" placeholder="PostTown">
                                                    <input name="regionB"
                                                           value="<% out.print(businessOfficeEntity.getRegionB()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Country/Region">
                                                    <input name="postalCodeB"
                                                           value="<% out.print(businessOfficeEntity.getPostalCodeB()); %>"
                                                           type="text" class="form-control" placeholder="Postal Code">

                                                </div>
                                            </div>
                                            <!-- /.tab-pane -->
                                            <div class="tab-pane" id="tab_3">
                                                <div class="form-group">
                                                    <input value="<% out.print(postalOfficeEntity.getCareOfP()); %>"
                                                           name="careOfP" type="text" class="form-control"
                                                           placeholder="Correspondent">
                                                    <input name="addressLine1P"
                                                           value="<% out.print(postalOfficeEntity.getAddressLine1P()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Address Line 1">
                                                    <input name="addressLine2P"
                                                           value="<% out.print(postalOfficeEntity.getAddressLine2P()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Address Line 2">
                                                    <input name="addressLine3P"
                                                           value="<% out.print(postalOfficeEntity.getAddressLine3P()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Address Line 3">
                                                    <input name="addressLine4P"
                                                           value="<% out.print(postalOfficeEntity.getAddressLine4P()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Address Line 4">
                                                    <input name="localityP"
                                                           value="<% out.print(postalOfficeEntity.getLocalityP()); %>"
                                                           type="text" class="form-control" placeholder="PostTown">
                                                    <input name="regionP"
                                                           value="<% out.print(postalOfficeEntity.getRegionP()); %>"
                                                           type="text" class="form-control"
                                                           placeholder="Country/Region">
                                                    <input name="postalCodeP"
                                                           value="<% out.print(postalOfficeEntity.getPostalCodeP()); %>"
                                                           type="text" class="form-control" placeholder="Postal Code">

                                                </div>
                                            </div>
                                            <!-- /.tab-pane -->
                                        </div>
                                        <!-- /.tab-content -->
                                    </div>
                                    <!-- /.tab -->
                                    </br>
                                    </br>
                                    <label> Officers: </label>

                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getOfficer1()); %>" type="text" class="form-control" name="officer1"
                                               placeholder="Director/Share Holder" id="textChangeState4">
                                    </div>
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getOfficer2()); %>" type="text" class="form-control" name="officer2"
                                               placeholder="Director/Share Holder" id="textChangeState5">
                                    </div>
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getOfficer3()); %>" type="text" class="form-control" name="officer3" placeholder="Secretary"
                                               id="textChangeState6">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                </div>
                                <div class="col-md-5">
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getDateOfIncoporate()); %>"
                                               type="text" class="form-control" name="dateOfIncoporate"
                                               placeholder="Date of Incorporate" id="textChangeState7">
                                    </div>
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getAccountReferrenceDate());%>"
                                               type="text" class="form-control" name="accountReferrenceDate"
                                               placeholder="Accounts Reference Data" id="textChangeState8">
                                    </div>
                                    <div class="form-group">
                                    </div>
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getUtrNo());%>" type="number"
                                               class="form-control" size="10" maxlength="10" name="utrNo"
                                               placeholder="UTR No">
                                    </div>
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getTaxDistrictNo());%>"
                                               type="number" class="form-control" name="taxDistrictNo" size="3"
                                               maxlength="3"
                                               placeholder="Tax District No">
                                    </div>
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getAccountOffice());%>"
                                               type="text" class="form-control" name="accountOffice"
                                               placeholder="Account Office">
                                    </div>
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getPayeRef());%>" type="text"
                                               class="form-control" name="payeRef" placeholder="Pay Ref">
                                    </div>
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getNestId());%>" type="text"
                                               class="form-control" name="nestId" placeholder="Nest Id">
                                    </div>
                                    <div class="form-group">

                                    </div>
                                    <div class="form-group">
                                        <input value="<% out.print(ourClientsNewEntity.getVat());%>" type="number"
                                               class="form-control" name="vat" placeholder="Vat">
                                    </div>
                                    </br>
                                    <div class="form-group">
                                        <label> Service: </label>
                                        <select name="service" class="form-control">
                                            <%
                                                if (ourClientsNewEntity.getService() == null) {
                                                    out.print("<option value=\"Active\">Active</option>\n" +
                                                            "                                            <option value=\"Active\">Inactive</option>\n" +
                                                            "                                            <option value=\"Active\">Hold</option>");
                                                }else if (ourClientsNewEntity.getService().matches("Active")) {
                                                    out.print("<option selected value=\"Active\">Active</option>\n" +
                                                            "                                            <option value=\"Active\">Inactive</option>\n" +
                                                            "                                            <option value=\"Active\">Hold</option>");

                                                } else if (ourClientsNewEntity.getService().matches("Inactive")) {
                                                    out.print("<option value=\"Active\">Active</option>\n" +
                                                            "                                            <option selected value=\"Active\">Inactive</option>\n" +
                                                            "                                            <option value=\"Active\">Hold</option>");

                                                } else if (ourClientsNewEntity.getService().matches("Hold")) {
                                                    out.print("<option value=\"Active\">Active</option>\n" +
                                                            "                                            <option value=\"Active\">Inactive</option>\n" +
                                                            "                                            <option selected value=\"Active\">Hold</option>");

                                                }
                                            %>
                                            }

                                        </select>
                                        </br>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td><label style="font-weight: normal;"> Statuary Accounts: </label>
                                                </td>
                                                <td style="width: 15px;"></td>
                                                <td>
                                                    <%
                                                        if (ourClientsNewEntity.getStatuaryAccounts() == null) {
                                                            out.print("<input type=\"checkbox\" name=\"statuaryAccounts\" class=\"flat-red\">");
                                                        } else if (ourClientsNewEntity.getStatuaryAccounts().matches("on")) {
                                                            out.print("<input type=\"checkbox\" name=\"statuaryAccounts\" class=\"flat-red\" checked>");
                                                        } else if (ourClientsNewEntity.getStatuaryAccounts().matches("False")) {
                                                            out.print("<input type=\"checkbox\" name=\"statuaryAccounts\" class=\"flat-red\">");
                                                        }
                                                    %></td>
                                            </tr>
                                        </table>
                                    </div>
                                     <div class="form-group">
                                         <table>
                                             <tr>
                                                 <td style="width: 110px;"><label style="font-weight: normal;"> Book
                                                     Keeping: </label></td>
                                                 <td style="width: 15px;"></td>
                                                 <td><%
                                                     if (ourClientsNewEntity.getBookKeeping() == null) {
                                                         out.print("<input type=\"checkbox\" name=\"bookKeeping\" class=\"flat-red\">");
                                                     } else if (ourClientsNewEntity.getBookKeeping().matches("on")) {
                                                         out.print("<input type=\"checkbox\" name=\"bookKeeping\" class=\"flat-red\" checked>");
                                                     } else if (ourClientsNewEntity.getBookKeeping().matches("False")) {
                                                         out.print("<input type=\"checkbox\" name=\"bookKeeping\" class=\"flat-red\">");
                                                     }
                                                 %>
                                                 </td>
                                             </tr>
                                         </table>
                                     </div>
                                     <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 110px;"><label style="font-weight: normal;">
                                                    Payroll: </label></td>
                                                <td style="width: 15px;"></td>
                                                <td><%
                                                    if (ourClientsNewEntity.getPayRoll() == null) {
                                                        out.print("<input type=\"checkbox\" name=\"payRoll\" class=\"flat-red\">");
                                                    } else if (ourClientsNewEntity.getPayRoll().matches("on")) {
                                                        out.print("<input type=\"checkbox\" name=\"payRoll\" class=\"flat-red\" checked>");
                                                    } else if (ourClientsNewEntity.getPayRoll().matches("False")) {
                                                        out.print("<input type=\"checkbox\" name=\"payRoll\" class=\"flat-red\">");
                                                    }
                                                %></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 110px;"><label style="font-weight: normal;">
                                                    Vat: </label>
                                                </td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 150px;"><select name="vatSelect" class="form-control">
                                                    <%
                                                        if (ourClientsNewEntity.getVatSelect() == null) {
                                                            out.print("<option value=\"Q-1\">Q-1</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-2</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-3</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-4</option>");
                                                        } else if (ourClientsNewEntity.getVatSelect().matches("Q-1")) {
                                                            out.print("<option checked value=\"Q-1\">Q-1</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-2</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-3</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-4</option>");

                                                        } else if (ourClientsNewEntity.getVatSelect().matches("Q-2")) {
                                                            out.print("<option value=\"Q-1\">Q-1</option>\n" +
                                                                    "                                                    <option checked value=\"Q-1\">Q-2</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-3</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-4</option>");

                                                        } else if (ourClientsNewEntity.getVatSelect().matches("Q-3")) {
                                                            out.print("<option value=\"Q-1\">Q-1</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-2</option>\n" +
                                                                    "                                                    <option checked value=\"Q-1\">Q-3</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-4</option>");

                                                        } else if (ourClientsNewEntity.getVatSelect().matches("Q-4")) {
                                                            out.print("<option value=\"Q-1\">Q-1</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-2</option>\n" +
                                                                    "                                                    <option value=\"Q-1\">Q-3</option>\n" +
                                                                    "                                                    <option checked value=\"Q-1\">Q-4</option>");

                                                        }
                                                    %>
                                                </select></td>
                                            </tr>
                                        </table>
                                    </div>
                                    </br>
                                    </br>


                                </div>
                                <div class="col-md-12">
                                    <table>
                                        <tr>
                                            <td style="width: 630px;"></td>
                                            <td style="width: 200px;">
                                                <button class="btn btn-block btn-primary btn"
                                                        id="navigatetodatesandnotes">Dates & notes
                                                </button>
                                            </td>
                                            <td style="width: 20px;"></td>
                                            <td style="width: 200px;">
                                                <button class="btn btn-block btn-success btn">Save</button>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- /.box -->
                </div>
                <!-- /.col-->
                <div class="col-md-11">
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
<!-- FastClick -->
<script src="resources/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="resources/dist/js/demo.js"></script>
<!-- CK Editor -->
<script src="https://cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script>
<!-- date-range-picker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="resources/plugins/daterangepicker/daterangepicker.js"></script>
<!-- iCheck 1.0.1 -->
<script src="resources/plugins/iCheck/icheck.min.js"></script>
<script>

    $(document).ready(function () {
        makeDisabled();
    });

    $(document).ready(function () {

        $("#navigatetodatesandnotes").click(function () {

            $('#process-handling-window').attr('action', action = "dates-and-notes");

            e.preventDefault();
        });

    });

    function makeDisabled() {
        var dvAct = document.getElementById("tab_1");
        var elInput = dvAct.getElementsByTagName("input");
        for (i = 0; i < elInput.length; i++) {
            elInput[i].readOnly = true;
        }
        document.getElementById("textChangeState1").readOnly = true;
        document.getElementById("textChangeState2").readOnly = true;
        document.getElementById("textChangeState3").readOnly = true;
        document.getElementById("textChangeState4").readOnly = true;
        document.getElementById("textChangeState5").readOnly = true;
        document.getElementById("textChangeState6").readOnly = true;
        document.getElementById("textChangeState7").readOnly = true;
        document.getElementById("textChangeState8").readOnly = true;
    }

    function makeUnabled() {
        var dvAct = document.getElementById("tab_1");
        var elInput = dvAct.getElementsByTagName("input");
        for (i = 0; i < elInput.length; i++) {
            console.log(elInput[i]);
            elInput[i].readOnly = false;
        }
        document.getElementById("textChangeState1").readOnly = false;
        document.getElementById("textChangeState2").readOnly = false;
        document.getElementById("textChangeState3").readOnly = false;
        document.getElementById("textChangeState4").readOnly = false;
        document.getElementById("textChangeState5").readOnly = false;
        document.getElementById("textChangeState6").readOnly = false;
        document.getElementById("textChangeState7").readOnly = false;
        document.getElementById("textChangeState8").readOnly = false;
    }

    function OnChangeCheckbox(checkbox) {
        if (checkbox.checked) {
            makeUnabled();
        }
        else {
            makeDisabled();
        }
    }

    $(function () {
        // Replace the <textarea id="editor1"> with a CKEditor
        // instance, using default configuration.
        CKEDITOR.replace('editor1');
        //bootstrap WYSIHTML5 - text editor
        $(".textarea").wysihtml5();
        //Date range picker
        $('#reservation').daterangepicker();
        //Date range picker with time picker
        $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
        //Date range as a button
        $('#daterange-btn').daterangepicker(
                {
                    ranges: {
                        'Today': [moment(), moment()],
                        'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                        'Last 7 Days': [moment().subtract(6, 'days'), moment()],
                        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                        'This Month': [moment().startOf('month'), moment().endOf('month')],
                        'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                    },
                    startDate: moment().subtract(29, 'days'),
                    endDate: moment()
                },
                function (start, end) {
                    $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
                }
        );
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });
        //Red color scheme for iCheck
        $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
            checkboxClass: 'icheckbox_minimal-red',
            radioClass: 'iradio_minimal-red'
        });
        //Flat red color scheme for iCheck
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        });

    });

    $('#process-handling-window').submit(function() {
        if ($.trim($("#clientRef").val()) === "" ) {
            alert('Enter a unique client reference number');
            return false;
        }
    });
</script>
</body>
</html>