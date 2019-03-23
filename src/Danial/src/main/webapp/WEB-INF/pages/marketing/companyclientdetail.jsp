<%@ page import="com.springapp.mvc.domain.MarketingMainEntity" %>
<%@ page import="com.springapp.mvc.domain.RegisteredOfficeEntity" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="com.springapp.mvc.domain.BusinessOfficeEntity" %>
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
        RegisteredOfficeEntity registeredOfficeEntity = (RegisteredOfficeEntity) request.getAttribute("registeredOfficeEntity");
        BusinessOfficeEntity businessOfficeEntity = (BusinessOfficeEntity) request.getAttribute("businessOfficeEntity");

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

        </section>

        <!-- Main content -->
        <section class="content">
            <div class="col-md-8">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">Client Details</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <%
                        MarketingMainEntity marketingMainEntity = (MarketingMainEntity) request.getAttribute("marketingMainEntity");
                    %>
                    <form role="form" id="companyclientdetail" action="company-client-detail-submit" method="post">
                        <div class="box-body">
                            <div class="form-group">
                                <label>Company Name:</label>
                                <input name="tradingNameAtLocation" type="text" class="form-control"
                                       value="<% out.print(marketingMainEntity.getTradingNameAtLocation()); %>"
                                        >
                            </div>
                            <div class="form-group">
                                <label>Company Reg No:</label>
                                <input readonly name="companyRegNo" type="text" class="form-control"
                                       value="<% out.print(marketingMainEntity.getCompanyRegNo()); %>">
                            </div>
                            <div class="form-group">
                                <label>Date of Incorporation</label></br>
                                <label>Next Accounts Due:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input name="nextAccountsDue" type="text" class="form-control"
                                           value="<% out.print(marketingMainEntity.getNextAccountsDue()); %>">
                                </div>
                                <!-- /.input group -->
                                <label>Next Return Due:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input name="nextReturnDue" type="text" id="datamask" class="form-control"
                                           value="<% out.print(marketingMainEntity.getNextReturnDue()); %>">
                                </div>
                                <!-- /.input group -->
                            </div>
                            <label>Address Details</label>

                            <div class="nav-tabs-custom">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#tab_1" data-toggle="tab">Contact Address</a></li>
                                    <li><a href="#tab_2" data-toggle="tab">Register Office Address</a></li>
                                    <li><a href="#tab_3" data-toggle="tab">Business Address</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab_1">
                                        <div class="form-group">
                                            <input name="curn" type="text" class="form-control" placeholder="Correspondent"
                                                    value="<% out.print(marketingMainEntity.getCurn()); %>">
                                            <input name="addressLine1" type="text" class="form-control"
                                                   value="<% out.print(marketingMainEntity.getAddressLine1()); %>">
                                            <input name="addressLine2" type="text" class="form-control"
                                                   value="<% out.print(marketingMainEntity.getAddressLine2()); %>">
                                            <input name="addressLine3" type="text" class="form-control"
                                                   value="<% out.print(marketingMainEntity.getAddressLine3()); %>">
                                            <input name="addressLine4" type="text" class="form-control"
                                                   value="<% out.print(marketingMainEntity.getAddressLine4()); %>">
                                            <input name="town" type="text" class="form-control"
                                                   value="<% out.print(marketingMainEntity.getTown()); %>">
                                            <input name="county" type="text" class="form-control"
                                                   value="<% out.print(marketingMainEntity.getCounty()); %>">
                                            <input name="postcode" type="text" class="form-control"
                                                   value="<% out.print(marketingMainEntity.getPostcode()); %>">
                                        </div>

                                    </div>
                                    <!-- /.tab-pane -->
                                    <div class="tab-pane" id="tab_2">
                                        <%--<%
                                            RegisteredOfficeEntity registeredOfficeEntity = (RegisteredOfficeEntity) request.getAttribute("registeredOfficeEntity");
                                            if (registeredOfficeEntity.getCareOf() != null) {
                                                out.print("c/o " + registeredOfficeEntity.getCareOf() + "</br>");
                                            }

                                            try {
                                                if (registeredOfficeEntity.getAddressLine1() != null || registeredOfficeEntity.getAddressLine1().equals("")) {
                                                    out.print(registeredOfficeEntity.getAddressLine1() + "</br>");
                                                }
                                            } catch (Exception e) {
                                            }

                                            try {
                                                if (registeredOfficeEntity.getAddressLine2() != null || registeredOfficeEntity.getAddressLine2().equals("")) {
                                                    out.print(registeredOfficeEntity.getAddressLine2() + "</br>");

                                                }
                                            } catch (Exception e) {
                                            }

                                            if (registeredOfficeEntity.getAddressLine3() != null) {
                                                if (!registeredOfficeEntity.getAddressLine3().equals("")) {
                                                    out.print(registeredOfficeEntity.getAddressLine3() + "</br>");
                                                }
                                            }
                                            if (registeredOfficeEntity.getAddressLine4() != null) {
                                                if (!registeredOfficeEntity.getAddressLine4().equals("")) {
                                                    out.print(registeredOfficeEntity.getAddressLine4() + "</br>");

                                                }
                                            }

                                            try {
                                                if (registeredOfficeEntity.getLocality() != null || registeredOfficeEntity.getLocality().equals("")) {
                                                    out.print(registeredOfficeEntity.getLocality() + "</br>");
                                                }
                                            } catch (Exception e) {
                                            }

                                            try {
                                                if (registeredOfficeEntity.getRegion() != null || registeredOfficeEntity.getRegion().equals("")) {
                                                    out.print(registeredOfficeEntity.getRegion() + "</br>");
                                                }
                                            } catch (Exception e) {
                                            }

                                            try {
                                                if (registeredOfficeEntity.getPostalCode() != null || registeredOfficeEntity.getPostalCode().equals("")) {
                                                    out.print(registeredOfficeEntity.getPostalCode() + "</br>");
                                                }
                                            } catch (Exception e) {
                                            }
                                        %>--%>
                                            <div class="form-group">
                                                <input placeholder="c/o" name="careOfR" type="text" class="form-control"
                                                       value="<% out.print(registeredOfficeEntity.getCareOfR()); %>">
                                                <input placeholder="AddressLine1" name="addressLine1R" type="text" class="form-control"
                                                       value="<% out.print(registeredOfficeEntity.getAddressLine1R()); %>">
                                                <input placeholder="AddressLine2" name="addressLine2R" type="text" class="form-control"
                                                       value="<% out.print(registeredOfficeEntity.getAddressLine2R()); %>">
                                                <input placeholder="AddressLine3" name="addressLine3R" type="text" class="form-control"
                                                       value="<% out.print(registeredOfficeEntity.getAddressLine3R()); %>">
                                                <input placeholder="AddressLine4" name="addressLine4R" type="text" class="form-control"
                                                       value="<% out.print(registeredOfficeEntity.getAddressLine4R()); %>">
                                                <input placeholder="Region" name="regionR" type="text" class="form-control"
                                                       value="<% out.print(registeredOfficeEntity.getRegionR()); %>">
                                                <input placeholder="Locality" name="localityR" type="text" class="form-control"
                                                       value="<% out.print(registeredOfficeEntity.getLocalityR()); %>">
                                                <input placeholder="Postal Code" name="postcodeR" type="text" class="form-control"
                                                       value="<% out.print(registeredOfficeEntity.getPostalCodeR()); %>">
                                            </div>
                                    </div>
                                    <!-- /.tab-pane -->
                                    <div class="tab-pane" id="tab_3">
                                        <div class="form-group">
                                            <input value="<% out.print(businessOfficeEntity.getCareOfB()); %>" name="careOfB" type="text" class="form-control" placeholder="Correspondent">
                                            <input name="addressLine1B" value="<% out.print(businessOfficeEntity.getAddressLine1B()); %>" type="text" class="form-control" placeholder="Address Line 1">
                                            <input name="addressLine2B" value="<% out.print(businessOfficeEntity.getAddressLine2B()); %>" type="text" class="form-control" placeholder="Address Line 2">
                                            <input name="addressLine3B" value="<% out.print(businessOfficeEntity.getAddressLine3B()); %>" type="text" class="form-control" placeholder="Address Line 3">
                                            <input name="addressLine4B" value="<% out.print(businessOfficeEntity.getAddressLine4B()); %>" type="text" class="form-control" placeholder="Address Line 4">
                                            <input name="localityB" value="<% out.print(businessOfficeEntity.getLocalityB()); %>" type="text" class="form-control" placeholder="PostTown">
                                            <input name="regionB" value="<% out.print(businessOfficeEntity.getRegionB()); %>" type="text" class="form-control" placeholder="Country/Region">
                                            <input name="postalCodeB" value="<% out.print(businessOfficeEntity.getPostalCodeB()); %>" type="text" class="form-control" placeholder="Postal Code">
                                        </div>
                                    </div>
                                    <!-- /.tab-pane -->
                                </div>
                                <!-- /.tab-content -->
                            </div>
                            <!-- /.tab -->
                            <div class="form-group">
                                <label>Contact Person</label>

                                <div class="form-group">
                                    <label>Title: </label>
                                    <select name="title" class="form-control">
                                        <%
                                            if (marketingMainEntity.getTitle() != null) {
                                                if (marketingMainEntity.getTitle().matches("Miss")) {
                                                    out.print("<option  value=\"Miss\" selected>Miss</option>\n" +
                                                            "<option  value=\"Mr\">Mr</option>\n" +
                                                            "<option  value=\"Mrs\">Mrs</option>");
                                                } else if (marketingMainEntity.getTitle().matches("Mr")) {
                                                    out.print("<option  value=\"Miss\">Miss</option>\n" +
                                                            "<option  value=\"Mr\" selected>Mr</option>\n" +
                                                            "<option  value=\"Mrs\">Mrs</option>");
                                                } else if (marketingMainEntity.getTitle().matches("Mrs")) {
                                                    out.print("<option  value=\"Miss\">Miss</option>\n" +
                                                            "<option  value=\"Mr\">Mr</option>\n" +
                                                            "<option  value=\"Mrs\" selected>Mrs</option>");
                                                }
                                            } else {
                                                out.print("<option  value=\"Miss\">Miss</option>\n" +
                                                        "<option  value=\"Mr\">Mr</option>\n" +
                                                        "<option  value=\"Mrs\">Mrs</option>");
                                            }
                                        %>


                                    </select>
                                    <label>Initial: </label>
                                    <input name="initial" type="text" class="form-control"
                                           value="<% out.print(marketingMainEntity.getInitial()); %>">
                                    <label>Forename: </label>
                                    <input name="forename" type="text" class="form-control"
                                           value="<% out.print(marketingMainEntity.getForename()); %>">
                                    <label>Surname: </label>
                                    <input name="surname" type="text" class="form-control"
                                           value="<% out.print(marketingMainEntity.getSurname()); %>">
                                    <label>Email: </label>
                                    <input name="mailId" type="text" class="form-control"
                                           value="<% out.print(marketingMainEntity.getMailId()); %>">
                                    <label>Job Function: </label>
                                    <select name="jobFunction" class="form-control">
                                        <%
                                            if (marketingMainEntity.getJobFunction() != null) {
                                                if (marketingMainEntity.getJobFunction().matches("Senior Decision Maker")) {
                                                    out.print("<option  value=\"Senior Decision Maker\" selected>Senior Decision Maker</option>\n" +
                                                            "<option value=\"Management\">Management</option>\n" +
                                                            "<option value=\"Other Role\">Other Role</option>");
                                                } else if (marketingMainEntity.getJobFunction().matches("Management")) {
                                                    out.print("<option value=\"Senior Decision Maker\">Senior Decision Maker</option>\n" +
                                                            "<option  value=\"Management\" selected>Management</option>\n" +
                                                            "<option  value=\"Other Role\">Other Role</option>");
                                                } else {
                                                    out.print("<option value=\"Senior Decision Maker\">Senior Decision Maker</option>\n" +
                                                            "<option value=\"Management\">Management</option>\n" +
                                                            "<option value=\"Other Role\" selected>Other Role</option>");
                                                }
                                            } else {
                                                out.print("<option value=\"Senior Decision Maker\">Senior Decision Maker</option>\n" +
                                                        "<option value=\"Management\">Management</option>\n" +
                                                        "<option value=\"Other Role\">Other Role</option>");
                                            }
                                        %>

                                    </select>
                                    <label>Job Title: </label>
                                    <select name="jobTitle" class="form-control">
                                        <%
                                            if (marketingMainEntity.getJobTitle() != null) {
                                                if (marketingMainEntity.getJobTitle().matches("Company Secretary")) {
                                                    out.print("<option  value=\"Company Secretary\" selected>Company Secretary</option>\n" +
                                                            "<option  value=\"Director\">Director</option>\n" +
                                                            "<option value=\"Manager\">Manager</option>\n" +
                                                            "<option value=\"Managing Director\">Managing Director</option>\n" +
                                                            "<option value=\"Proprietor\">Proprietor</option>");
                                                } else if (marketingMainEntity.getJobTitle().matches("Director")) {
                                                    out.print("<option value=\"Company Secretary\">Company Secretary</option>\n" +
                                                            "<option  value=\"Director\" selected>Director</option>\n" +
                                                            "<option value=\"Manager\" >Manager</option>\n" +
                                                            "<option value=\"Managing Director\">Managing Director</option>\n" +
                                                            "<option value=\"Proprietor\">Proprietor</option>");
                                                } else if (marketingMainEntity.getJobTitle().matches("Manager")) {
                                                    out.print("<option value=\"Company Secretary\">Company Secretary</option>\n" +
                                                            "<option value=\"Director\">Director</option>\n" +
                                                            "<option  value=\"Manager\" selected>Manager</option>\n" +
                                                            "<option value=\"Managing Director\">Managing Director</option>\n" +
                                                            "<option value=\"Proprietor\">Proprietor</option>");
                                                } else if (marketingMainEntity.getJobTitle().matches("Managing Director")) {
                                                    out.print("<option value=\"Company Secretary\">Company Secretary</option>\n" +
                                                            "<option value=\"Director\">Director</option>\n" +
                                                            "<option value=\"Manager\">Manager</option>\n" +
                                                            "<option value=\"Managing Director\" selected>Managing Director</option>\n" +
                                                            "<option value=\"Proprietor\">Proprietor</option>");
                                                } else if (marketingMainEntity.getJobTitle().matches("Proprietor")) {
                                                    out.print("<option value=\"Company Secretary\">Company Secretary</option>\n" +
                                                            "<option value=\"Director\">Director</option>\n" +
                                                            "<option value=\"Manager\" >Manager</option>\n" +
                                                            "<option value=\"Managing Director\">Managing Director</option>\n" +
                                                            "<option  value=\"Proprietor\" selected>Proprietor</option>");
                                                }
                                            } else {
                                                out.print("<option value=\"Company Secretary\">Company Secretary</option>\n" +
                                                        "<option value=\"Director\">Director</option>\n" +
                                                        "<option value=\"Manager\">Manager</option>\n" +
                                                        "<option value=\"Managing Director\">Managing Director</option>\n" +
                                                        "<option value=\"Proprietor\" >Proprietor</option>");
                                            }

                                        %>

                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label>Telephone No:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-phone"></i>
                                    </div>
                                    <input type="text" class="form-control"
                                           name="telephoneNumber"
                                           data-inputmask="&quot;mask&quot;: &quot;(999) 999-9999&quot;" data-mask=""
                                           value="<% out.print(marketingMainEntity.getTelephoneNumber());%>">
                                </div>
                                <!-- /.input group -->
                            </div>
                        </div>
                        <!-- /.box-body -->

                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-4">
                <form action="fix-appointment" method="get">
                    <input type="text" name="companyRegNo" hidden="true"
                           value="<%=marketingMainEntity.getCompanyRegNo()%>">

                    <div class="box-footer">
                        <button id="makeanappointment" class="btn btn-primary">Make an appointment
                        </button>
                    </div>
                </form>
            </div>

        </section>

    </div>
    <!-- /.content -->

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
<script>
    $(document).ready(function () {

        $("#makeanappointment").click(function () {

            $('#companyclientdetail').attr('action', action = "fix-appointment");

            e.preventDefault();
        });

    });


    $("[data-mask]").inputmask();
</script>
<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.1.4 -->
<script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/app.min.js"></script>
<!-- InputMask -->
<script src="resources/plugins/input-mask/jquery.inputmask.js"></script>
<script src="resources/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="resources/plugins/input-mask/jquery.inputmask.extensions.js"></script>

</body>
</html>