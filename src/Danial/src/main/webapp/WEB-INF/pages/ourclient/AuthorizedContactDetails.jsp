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
              <li class="active"><a href="companyHouseClients"><i class="fa fa fa-users"></i>Company House Clients</a></li>
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
        Contact Details
      </h1>
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-md-6">
          <div class="box box-info">
            <div class="box-header">
              <h3 class="box-title">Edit Contact Details</h3>
              <!-- tools box -->
              <div class="pull-right box-tools">
                <button class="btn btn-info btn-sm" data-widget="collapse" data-toggle="tooltip" title="Collapse"><i class="fa fa-minus"></i></button>
                <button class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip" title="Remove"><i class="fa fa-times"></i></button>
              </div><!-- /. tools -->
            </div><!-- /.box-header -->
            <div class="box-body pad">
              <div class ="col-md-10">
                <form id="editprivatecontactdetails" action="save-private-contact-details" method="post">

                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="Contact Person">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="T.P">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="M.P">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="Fax">
                  </div>
                  <div class="form-group" id="emailBox">
                    <input type="text" class="form-control" placeholder="Email">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="CH Auth code">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="HMRC ID">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="HMRC PW">
                  </div>
              </div>
              <div class="col-md-1" style="padding-top:196px;" id="divBox">
                <button type="button" class="btn btn-success" onclick="addEmailBox()"><i class="fa fa-chevron-down"></i></button>
              </div>
            </div>


            <div>
              <table class="table table-bordered text-center" style="border: none">
                <tbody>
                <tr>
                  <td class="col-md-4" style="border: none"></td>
                  <td style="border: none;"><button class="btn btn-block btn-primary">Save Contact Details</button></td>
                </tr>
                </tbody>
              </table>
            </div>

            </form>
          </div>
        </div><!-- /.box -->
      </div><!-- /.col-->
  </div><!-- ./row -->
  </section><!-- /.content -->
</div><!-- /.content-wrapper -->

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


  function addEmailBox(){
    var div = document.getElementById("emailBox");
    div.innerHTML += "</br><input type='text' class='form-control' placeholder='Email'>";

    var div1 = document.getElementById("divBox");
    div1.innerHTML = "";
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
</script>
</body>
</html>