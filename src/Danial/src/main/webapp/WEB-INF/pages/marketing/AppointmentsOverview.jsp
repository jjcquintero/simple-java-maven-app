<%@ page import="com.springapp.mvc.domain.AppointmentEntity" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Daniel | Calendar</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- fullCalendar 2.2.5-->
    <link rel="stylesheet" href="resources/plugins/fullcalendar/fullcalendar.min.css">
    <link rel="stylesheet" href="resources/plugins/fullcalendar/fullcalendar.print.css" media="print">
    <!-- Theme style -->
    <link rel="stylesheet" href="resources/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="resources/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%--Mainheader is added--%>
    <jsp:include page="../general/mainHeader.jsp"/>


    <%

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List appointmentList = (List) request.getAttribute("appointments");

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
                        <li class="active"><a href="appointment-overview"><i class="fa fa-tasks"></i>Appointments</a></li>
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
                Calendar
                <small>Control panel</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Calendar</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">

                <div class="col-md-12">
                    <div class="box box-primary">
                        <div class="box-body no-padding">
                            <!-- THE CALENDAR -->
                            <div id="calendar"></div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /. box -->
                </div>
                <!-- /.col -->
            </div>
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
            <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>

    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<div class="box box-info" id="popupDiv" style="display: none">
    <div class="box-header">
        <h3 class="box-title">Edit Event</h3>
        <!-- /. tools -->
    </div>
    <!-- /.box-header -->
    <div class="box-body pad">

        <form action="appointment-save" method="get" id="appointment-form">
            <div class="form-group">
                <label class="col-sm-2"> Title: </label>
                <input type="text" class="col-sm-10" id="appointment-title" name="appointmentTitle">
            </div>
            <br><br>
            <!-- Date and time range -->
            <div class="form-group">
                <label class="col-sm-2">When:</label>

                <div class="input-group">
                    <div class="input-group-addon">
                        <i class="fa fa-clock-o"></i>
                    </div>
                    <input type="text" class="form-control pull-right" id="reservationtime" name="reservationTime">
                </div>
                <!-- /.input group -->
            </div>
            <!-- /.form group -->
            <div class="form-group">
                <label class="col-sm-2">Calender</label>
                <select class="col-sm-10" id="appointment-calender" name="appointmentCalender">
                    <option>Client Appointments</option>
                    <option>option 2</option>
                    <option>option 3</option>
                </select>
            </div>
            <br><br>

            <div class="form-group">
                <label class="col-sm-2"> Who: </label>
                <input type="text" class="col-sm-10" id="appointment-who" name="appointmentWho">
            </div>
            <br>

            <div class="form-group">
                <label class="col-sm-2"> Where: </label>
                <input type="text" class="col-sm-10" id="appointment-where" name="appointmentWhere">
            </div>
            <br><br>
            <textarea id="note" name="note" rows="10" cols="110"></textarea>
            </br>
            <div>
                <table class="table table-bordered text-center" style="border: none">
                    <tbody>
                    <tr>
                        <td class="col-md-4" style="border: none"></td>
                        <td style="border: none">
                            <button class="btn btn-block btn-success btn" onclick="popUpSave()" >Save</button>
                        </td>
                        <td style="border: none">
                            <button class="btn btn-block btn-danger" id="popupdelete" >Delete</button>
                        </td>
                        <td style="border: none">
                            <button class="btn btn-block btn-warning" id="popupcancel">
                                Cancel
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
    <!-- /.box -->
</div>
<!-- jQuery 2.1.4 -->
<script src="resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<!-- Slimscroll -->
<script src="resources/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="resources/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="resources/dist/js/app.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="resources/dist/js/demo.js"></script>
<!-- CK Editor -->
<script src="https://cdn.ckeditor.com/4.4.3/standard/ckeditor.js"></script>
<!-- fullCalendar 2.2.5 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
<script src="resources/plugins/fullcalendar/fullcalendar.min.js"></script>
<!-- Page specific script -->
<script>
    $(document).ready(function () {

        $("#popupdelete").click(function() {

                $('#appointment-form').attr('action', action = "appointment-delete");

            e.preventDefault();
        });

    });

    $(document).ready(function () {
        $("#popupcancel").click(function() {
            $('#appointment-form').attr('action', action = "appointment-overview");
            e.preventDefault();

        });

    });
    // Function to Close Div Popup
    function ClosePopupDiv(divId) {
        var table = document.getElementById('table' + divId);
        var element = table.parentElement;
        var divElt = document.getElementById(divId);
        divElt.style.display = 'none';
        var tempElt = document.getElementById('tempElt' + divId);
        tempElt.parentElement.insertBefore(divElt, tempElt);
        table.parentElement.removeChild(table);
        table.setAttribute('style', 'display: none');
        tempElt.parentElement.removeChild(tempElt);
    }

    // Function to Show Div Popup
    function ShowPopup(event, divId, popupSetting) {
        var divElt = document.getElementById(divId);

        var title = document.getElementById("appointment-title");
        var reservationtime = document.getElementById("reservationtime");
        var when = document.getElementById("appointment-calender");
        var who = document.getElementById("appointment-who");
        var where = document.getElementById("appointment-where");
        var note = document.getElementById("note");

        var data = event.title;
        var dataSplitted = data.split("BREAK");
        title.value = dataSplitted[0];
        reservationtime.value = dataSplitted[2];
        when.value = dataSplitted[3];
        who.value = dataSplitted[4];
        where.value = dataSplitted[5];
        note.value = dataSplitted[6];

        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'clientId';
        input.value = dataSplitted[1];
        document.getElementById("appointment-form").appendChild(input);

        divElt.style.display = 'block';
        var element = divElt.parentElement;
        popupSetting = popupSetting || {};
        popupSetting.height = divElt.height;
        var table = document.createElement('table');
        var tr2 = document.createElement('tr');
        var tdDynamic = document.createElement('td');
        var tempElt = document.createElement('div');
        tempElt.setAttribute('id', 'tempElt' + divElt.id);
        divElt.parentElement.insertBefore(tempElt, divElt);
        tdDynamic.appendChild(divElt);
        tr2.appendChild(tdDynamic);
        table.appendChild(tr2);
        var cssText = 'display: block; z-index:92000; top:15%; left:50%;';
        cssText += 'width: ' + popupSetting.width + 'px; height: ' + popupSetting.height + 'px; margin-left: -' + Math.round(popupSetting.width / 2) + 'px;';
        if (popupSetting.isFixed === true) {
            cssText += 'position: fixed;';
        }
        else {
            cssText += 'position: absolute;';
        }
        table.setAttribute('style', cssText);
        element.appendChild(table);
    }


    $(function () {
        /* initialize the external events
         -----------------------------------------------------------------*/
        function ini_events(ele) {
            ele.each(function () {

                // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
                // it doesn't need to have a start or end
                var eventObject = {
                    title: $.trim($(this).text()) // use the element's text as the event title
                };

                // store the Event Object in the DOM element so we can get to it later
                $(this).data('eventObject', eventObject);

                // make the event draggable using jQuery UI
                $(this).draggable({
                    zIndex: 1070,
                    revert: true, // will cause the event to go back to its
                    revertDuration: 0  //  original position after the drag
                });

            });
        }

        ini_events($('#external-events div.external-event'));

        /* initialize the calendar
         -----------------------------------------------------------------*/


        //Date for the calendar events (dummy data)
        var date = new Date();
        var d = date.getDate(),
                m = date.getMonth(),
                y = date.getFullYear();
        $('#calendar').fullCalendar({
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            buttonText: {
                today: 'today',
                month: 'month',
                week: 'week',
                day: 'day'
            },

            events: [

                <%for (int i = 0; i < appointmentList.size(); i++) {
        AppointmentEntity appointmentEntity=(AppointmentEntity)appointmentList.get(i);
        int month=Calendar.getInstance().get(Calendar.MONTH);

        int appointmentMonth=Integer.parseInt(appointmentEntity.getWhendate().split("/")[0]);
        int appointmentDate=Integer.parseInt(appointmentEntity.getWhendate().split("/")[1]);

        %>
                //Random default events
                <% out.print("{\n" +
                    "title:"+"\'"+appointmentEntity.getTitle()+"BREAK"+appointmentEntity.getAppointmentId()+"BREAK"+appointmentEntity.getWhendate() +" "+appointmentEntity.getWhentime()+" - "+appointmentEntity.getTodate()+" "+appointmentEntity.getTotime()+"BREAK"+appointmentEntity.getCalendar()+"BREAK"+appointmentEntity.getClient()+"BREAK"+appointmentEntity.getVenue()+"BREAK"+appointmentEntity.getNote()+"\'"+",\n" +
                    //"title:"+appointmentEntity+",\n" +
                    "start: new Date(2015"+","+(appointmentMonth-1)+","+appointmentDate+"),\n" +
                    "backgroundColor: \"#f56954\", //red\n" +
                    "borderColor: \"#f56954\" //red\n" +
                    "},");

                    %>

                <%}%>

            ],

            eventClick: function (event) {

                var executedTitle = event.title;
                var divToOpen = "popupDiv";
                var popupSetting = {width: '700', height: '', title: '', isFixed: false};
                ShowPopup(event, divToOpen, popupSetting);
                return false;
            },
            editable: true,
            droppable: true, // this allows things to be dropped onto the calendar !!!
            drop: function (date, allDay) { // this function is called when something is dropped

                // retrieve the dropped element's stored Event Object
                var originalEventObject = $(this).data('eventObject');

                // we need to copy it, so that multiple events don't have a reference to the same object
                var copiedEventObject = $.extend({}, originalEventObject);

                // assign it the date that was reported
                copiedEventObject.start = date;
                copiedEventObject.allDay = allDay;
                copiedEventObject.backgroundColor = $(this).css("background-color");
                copiedEventObject.borderColor = $(this).css("border-color");

                // render the event on the calendar
                // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
                $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);

                // is the "remove after drop" checkbox checked?
                if ($('#drop-remove').is(':checked')) {
                    // if so, remove the element from the "Draggable Events" list
                    $(this).remove();
                }

            }
        });

        /* ADDING EVENTS */
        var currColor = "#3c8dbc"; //Red by default
        //Color chooser button
        var colorChooser = $("#color-chooser-btn");
        $("#color-chooser > li > a").click(function (e) {
            e.preventDefault();
            //Save color
            currColor = $(this).css("color");
            //Add color effect to button
            $('#add-new-event').css({"background-color": currColor, "border-color": currColor});
        });


        $("#add-new-event").click(function (e) {
            e.preventDefault();
            //Get value and make sure it is not null
            var val = $("#new-event").val();
            if (val.length == 0) {
                return;
            }

            //Create events
            var event = $("<div />");
            event.css({
                "background-color": currColor,
                "border-color": currColor,
                "color": "#fff"
            }).addClass("external-event");
            event.html(val);
            $('#external-events').prepend(event);

            //Add draggable funtionality
            ini_events(event);

            //Remove event from text input
            $("#new-event").val("");
        });

    });
</script>
</body>
</html>