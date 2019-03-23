<%@ page import="com.springapp.mvc.domain.OurClientsNewEntity" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.sql.Date" %>
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

    %>


    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Date & Notes
            </h1>
        </section>

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


        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-md-10">
                    <div class="box box-info">
                        <div class="box-header">
                            <h3 class="box-title">Edit Date & Notes</h3>
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
                            <form action="dates-and-notes-process" id="dateandnotes" method="post">
                                <div class="col-md-6">

                                    <div><label>Dates</label></div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 115px;"><label style="font-weight: normal;"> A/c Ref.
                                                    Date: </label></td>
                                                <td style="width: 15px;"></td>
                                                <%
                                                    Date date=ourClientsNewEntity.getAccountReferrenceDate();
                                                    String dateS=date.toString();
                                                    String[] dateSA=dateS.split("-");
                                                    String day=dateSA[2];
                                                    String month=dateSA[1];

                                                %>
                                                <input type="hidden" value="<% out.print(ourClientsNewEntity.getComRegNo()); %>" name="comRegNo" value="Norway">
                                                <td style="width: 70px;"><input value="<% out.print(day); %>" type="text" class="form-control"
                                                                                name="day" placeholder="Day"></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 150px;"><input value="<% out.print(month); %>" type="text" class="form-control"
                                                                                 name="month" placeholder="Month"></td>

                                            </tr>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 150px;"><label style="font-weight: normal;">Date of
                                                    Incorporation:</label></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 200px;">
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input value="<% out.print(ourClientsNewEntity.getDateOfIncoporate()); %>" name="dateOfIncoporate" type="text" class="form-control pull-right"
                                                               id="reservationtime">
                                                    </div>
                                                    <!-- /.input group --></td>
                                            </tr>
                                        </table>
                                    </div>

                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 150px;"><label style="font-weight: normal;"> Status: </label></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 200px;"><input value="<% out.print(ourClientsNewEntity.getDateStatus()); %>" name="dateStatus" type="text" class="form-control"
                                                                                 placeholder="Active/Dorment/etc"></td>
                                            </tr>
                                        </table>
                                    </div>

                                    </br>

                                    <div><label>Accounts</label></div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 150px;"><label style="font-weight: normal;">Last A/c
                                                    made up to:</label></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 200px;">
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input value="<% out.print(ourClientsNewEntity.getAccountLastAcMadeUpTo()); %>" name="accountLastAcMadeUpTo" type="text" class="form-control pull-right"
                                                               id="reservationtime">
                                                    </div>
                                                    <!-- /.input group --></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 150px;"><label style="font-weight: normal;">Next A/c
                                                    due:</label></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 200px;">
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input value="<% out.print(ourClientsNewEntity.getAccountNextAcDue1()); %>" name="accountNextAcDue1" type="text" class="form-control pull-right"
                                                               id="reservationtime">
                                                    </div>
                                                    <!-- /.input group --></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 150px;"><label style="font-weight: normal;">Next A/c
                                                    due:</label></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 200px;">
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input value="<% out.print(ourClientsNewEntity.getAccountNextAcDue2()); %>" name="accountNextAcDue2" type="text" class="form-control pull-right"
                                                               id="reservationtime">
                                                    </div>
                                                    <!-- /.input group --></td>
                                            </tr>
                                        </table>
                                    </div>

                                    </br>

                                    <div><label>Annual Return</label></div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 150px;"><label style="font-weight: normal;">Last A/R
                                                    made up to:</label></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 200px;">
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input value="<% out.print(ourClientsNewEntity.getAccountLastAcMadeUpTo()); %>" name="annualLastArMadeUpTo" type="text" class="form-control pull-right"
                                                               id="reservationtime">
                                                    </div>
                                                    <!-- /.input group --></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 150px;"><label style="font-weight: normal;">Next A/R
                                                    made up to:</label></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 200px;">
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input value="<% out.print(ourClientsNewEntity.getAnnualNextArMadeUpTo()); %>" name="annualNextArMadeUpTo" type="text" class="form-control pull-right"
                                                               id="reservationtime">
                                                    </div>
                                                    <!-- /.input group --></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 150px;"><label style="font-weight: normal;">Next A/R
                                                    due:</label></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 200px;">
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input value="<% out.print(ourClientsNewEntity.getAnnualNextArDue()); %>" name="annualNextArDue" type="text" class="form-control pull-right"
                                                               id="reservationtime">
                                                    </div>
                                                    <!-- /.input group --></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="form-group">
                                        <table>
                                            <tr>
                                                <td style="width: 150px;"><label style="font-weight: normal;">Last Full
                                                    Members List:</label></td>
                                                <td style="width: 15px;"></td>
                                                <td style="width: 200px;">
                                                    <div class="input-group">
                                                        <div class="input-group-addon">
                                                            <i class="fa fa-calendar"></i>
                                                        </div>
                                                        <input value="<% out.print(ourClientsNewEntity.getAnnualLastFullMemberList()); %>" name="annualLastFullMemberList" type="text" class="form-control pull-right"
                                                               id="reservationtime">
                                                    </div>
                                                    <!-- /.input group --></td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                                <div class="col-md-5">

                                    <div style="padding-top:23px;">
                                        <textarea name="notesDates" class="form-control" rows="6" cols="100"
                                                  placeholder="Notes ..."><% out.print(ourClientsNewEntity.getNotesDates()); %></textarea>
                                    </div>

                                    </br>
                                    <div style="padding-top:40px;">
                                        <textarea name="notesAccount" class="form-control" rows="6" cols="100"
                                                  placeholder="Notes ..."><% out.print(ourClientsNewEntity.getNotesAccount()); %></textarea>
                                    </div>

                                    </br>
                                    <div style="padding-top:40px;">
                                        <textarea name="notesAnnualReturn" class="form-control" rows="8" cols="100"
                                                  placeholder="Notes ..."><% out.print(ourClientsNewEntity.getNotesAnnualReturn()); %></textarea>
                                    </div>
                                </div>
                                <div>
                                    <table class="table table-bordered text-center" style="border: none">
                                        <tbody>
                                        <tr>
                                            <td class="col-md-9" style="border: none"></td>
                                            <td style="border: none">
                                                <button id="checkcontactdetails" class="btn btn-block btn-primary">Check
                                                    Contact Details
                                                </button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- checkbox -->
                                <textarea id="editor1" name="notes" rows="10" cols="80"><% out.print(ourClientsNewEntity.getNotes()); %></textarea>
                                </br>
                                <div>
                                    <table class="table table-bordered text-center" style="border: none">
                                        <tbody>
                                        <tr>
                                            <td class="col-md-9" style="border: none"></td>
                                            <td style="border: none">
                                                <button type="submit" class="btn btn-block btn-success btn">Save Note
                                                </button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>

                            </form>
                        </div>


                    </div>
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col-->

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
        $("#checkcontactdetails").click(function () {
            $('#dateandnotes').attr('action', action = "private-contact-details");
            e.preventDefault();
        });
    });

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
</script>
</body>
</html>