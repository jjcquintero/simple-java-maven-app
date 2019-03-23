package com.springapp.mvc.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.mvc.apiClient.MarketingClients;
import com.springapp.mvc.domain.*;
import com.springapp.mvc.excelReader.Excel;
import com.springapp.mvc.model.UploadedFile;
import com.springapp.mvc.service.*;
import com.springapp.mvc.validator.FileValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/")
public class DanialMainController {
    private String insertStatus = "Not Processing";
    private String updateStatus = "Not Processing";
    private int fileCount = 1;
    Queue<String> marketingFileQueue = new LinkedList<String>();

    @Autowired
    private MarketingMainService marketingMainService;

    @Autowired
    private BusinessOfficeService businessOfficeService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private RegisteredOfficeService registeredOfficeService;

    @Autowired
    private PostalOfficeService postalOfficeService;

    @Autowired
    private OurClientNewService ourClientNewService;

    @Autowired
    private PayrollService payrollService;

    @Autowired
    FileValidator fileValidator;

    private static ObjectMapper objectMapper = new ObjectMapper();

    final static Logger logger = Logger.getLogger(DanialMainController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage() {
        return "general/index";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printWelcome() {
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login() {
        return "general/login";
    }

    @RequestMapping(value = "/create-user-accounts", method = RequestMethod.GET)
    public String createUser() {
        return "admin/createUserAccounts";
    }

    @RequestMapping(value = "/un-authorize", method = RequestMethod.GET)
    public String rendUnauthorized() {
        return "general/unAuthorized";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String insertAuthenticationTable(String username, String inputemail1, String password1, String inputposition, int roleid) {

        authenticationService.insert(new AuthenticationEntity(username, password1, inputemail1, roleid, 1, "a", "a", inputposition));
        return "hello";
    }


    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getAuthenticationTable() {
        AuthenticationEntity authenticationEntity = authenticationService.getUserDetails("prakhash");
        System.out.println(authenticationEntity.getPassword());
        return "hello";
    }


    @RequestMapping(value = "edit-employee-details-page", method = RequestMethod.GET)
    public String rendEditEmployeeDetailsPage(String username, Model model) {
        AuthenticationEntity authenticationEntity = authenticationService.getUserDetails(username);
        model.addAttribute("employeedetails", authenticationEntity);

        return "admin/editEmployeeDetails";
    }


    @RequestMapping(value = "update-employee-details", method = RequestMethod.POST)
    public String editEmployeeDetails(Model model, String existingusername, String username, String email, String position, String roleId, String lastlogintime, String lastlogindate) {

        AuthenticationEntity authenticationEntity = authenticationService.getUserDetails(existingusername);

        authenticationEntity.setUserName(username);
        authenticationEntity.setEmail(email);
        authenticationEntity.setPosition(position);

        authenticationEntity.setRoleId(Integer.parseInt(roleId));
        authenticationService.edit(authenticationEntity);

        List users = authenticationService.getAllUsers();
        model.addAttribute("companyusers", users);


        return "admin/ManageUserAccounts";
    }


    @RequestMapping(value = "/update-marketing-main", method = RequestMethod.POST)
    public
    @ResponseBody
    String updateMarketingMain(Model model) {

        UpdateMarketingMain updateMarketingMain = new UpdateMarketingMain();
        Thread threadUpdate = new Thread(updateMarketingMain);
        if (!threadUpdate.getState().equals("RUNNING")) {
            threadUpdate.start();
        }

        model.addAttribute("updateStatus", updateStatus);
        return "sucess";
    }

    @RequestMapping(value = "/select-marketing-main", method = RequestMethod.GET)
    public String selectMarketingMain(Model model) throws JsonProcessingException {
        MarketingMainEntity x = marketingMainService.getMarketingMain("bruntha");
        model.addAttribute("message", objectMapper.writeValueAsString(x));

        return "hello";
    }

    @RequestMapping(value = "/select-marketing-main-all", method = RequestMethod.GET)
    public String selectMarketingMainAll(Model model) throws JsonProcessingException {
        return "hello";
    }

    //method to add potential client
    @RequestMapping(value = "/add-to-potential-client", method = RequestMethod.POST)
    public String addToPotentialClient(Model model, String registration_no) throws JsonProcessingException {
        MarketingMainEntity marketingMainEntity = marketingMainService.getMarketingMain(registration_no);
        marketingMainEntity.setAddedToPotentialClient("True");
        marketingMainService.edit(marketingMainEntity);

        return "hello";
    }

    //method to add potential client
    @RequestMapping(value = "/add-to-potential-client-new", method = RequestMethod.POST)
    public String addToPotentialClientNew(Model model, String registration_no) throws JsonProcessingException {
        MarketingMainEntity marketingMainEntity = marketingMainService.getMarketingMain(registration_no);
        marketingMainEntity.setAddedToPotentialClient("True");
        marketingMainService.edit(marketingMainEntity);

        return "hello";
    }

    @RequestMapping(value = "/add-appointment", method = RequestMethod.GET)
    public String addAppointment(String titlemeeting, String whenmeeting, String calendermeeting, String withwhome, String wheremeeting,
                                 String repeatmeeting, String note, String companyregnumber, Model model) throws JsonProcessingException {


        List appointmentList = appointmentService.getAllAppointments();
        int size = appointmentList.size();
        int besitId = 0;

        AppointmentEntity appointmentEntity = appointmentService.getAppointment(size + 1);

        if (appointmentEntity != null)
            size = 0;
        else
            besitId = size + 1;

        while (appointmentEntity != null) {
            size = size + 1;
            appointmentEntity = appointmentService.getAppointment(size);
            besitId = size;
        }


        byte isactive = 0;
        byte repeats = 0;
        if (repeatmeeting != null && repeatmeeting.equals("on")) {
            repeats = 1;
        }

        try {

            titlemeeting = titlemeeting.replace("'", " ");
            note = note.replace("'", " ");
            String tokens[] = whenmeeting.split("-");
            String whenDate = tokens[0].trim().split(" ")[0];
            String whenTime = tokens[0].trim().split(" ")[1];
            String toDate = tokens[1].trim().split(" ")[0];
            String toTime = tokens[1].trim().split(" ")[1];


            appointmentService.insert(new AppointmentEntity(besitId, calendermeeting, withwhome, isactive, note, repeats, titlemeeting, toDate, wheremeeting, whenDate, whenTime, toTime, companyregnumber));
        } catch (Exception e) {
            return "marketing/AppointmentsOverview";
        }

        appointmentList = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointmentList);

        return "marketing/AppointmentsOverview";
    }


    @RequestMapping(value = "/appointment-save", method = RequestMethod.GET)
    public ModelAndView saveAppointment(Model model, String clientId, String appointmentTitle, String reservationTime, String appointmentCalender, String appointmentWho, String appointmentWhere,
                                        String note, String companyregnumber) throws JsonProcessingException {
        AppointmentEntity appointmentEntity = appointmentService.getAppointment(Integer.parseInt(clientId));


        try {

            appointmentTitle = appointmentTitle.replace("'", " ");
            appointmentCalender = appointmentCalender.replace("'", " ");
            String tokens[] = reservationTime.split("-");
            String whenDate = tokens[0].trim().split(" ")[0];
            String whenTime = tokens[0].trim().split(" ")[1];
            String toDate = tokens[1].trim().split(" ")[0];
            String toTime = tokens[1].trim().split(" ")[1];


            appointmentEntity.setCalendar(appointmentCalender);
            appointmentEntity.setClient(appointmentWho);
            appointmentEntity.setNote(note);
            appointmentEntity.setTitle(appointmentTitle);
            appointmentEntity.setTodate(toDate);
            appointmentEntity.setVenue(appointmentWhere);
            appointmentEntity.setWhendate(whenDate);
            appointmentEntity.setWhentime(whenTime);
            appointmentEntity.setTodate(toDate);
            appointmentEntity.setTotime(toTime);

            appointmentService.edit(appointmentEntity);

        } catch (Exception e) {
            return new ModelAndView("redirect:/appointment-overview");
        }

        return new ModelAndView("redirect:/appointment-overview");
    }

    @RequestMapping(value = "/appointment-delete", method = RequestMethod.GET)
    public ModelAndView deleteAppointment(Model model, String clientId, String appointmentTitle, String reservationTime,
                                          String appointmentCalender, String appointmentWho, String appointmentWhere) throws JsonProcessingException {
        appointmentService.delete(Integer.parseInt(clientId));
        return new ModelAndView("redirect:/appointment-overview");
    }


    @RequestMapping(value = "/add-to-marketing", method = RequestMethod.GET)
    public String addToMarketing(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,
                                 BindingResult result) {
        return "marketing/AddToMarketing";
    }

    @RequestMapping("/add-to-marketing-success")
    public String fileUploaded(
            @ModelAttribute("uploadedFile") UploadedFile uploadedFile,
            BindingResult result, Model model, HttpServletRequest request) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        System.out.println("CCCCCCCC " + System.getProperty("catalina.base"));

        MultipartFile file = uploadedFile.getFile();
        fileValidator.validate(uploadedFile, result);

        String fileName = file.getOriginalFilename();

        if (result.hasErrors()) {
            model.addAttribute("status", "failed");
            return "marketing/AddToMarketing";
        }

        try {
            inputStream = file.getInputStream();

            fileName = String.valueOf(fileCount++) + ":" + fileName;
            //String realPath=request.getSession().getServletContext().getRealPath("/");

            File newFile = new File(fileName);

            //set application user permissions to 455
            newFile.setExecutable(false);
            newFile.setReadable(true);
            newFile.setWritable(true);

            //change permission to 777 for all the users
            //no option for group and others
            newFile.setExecutable(true, false);
            newFile.setReadable(true, false);
            newFile.setWritable(true, false);

            //using PosixFilePermission to set file permissions 777
            Set<PosixFilePermission> perms = new HashSet<PosixFilePermission>();
            //add owners permission
            perms.add(PosixFilePermission.OWNER_READ);
            perms.add(PosixFilePermission.OWNER_WRITE);
            perms.add(PosixFilePermission.OWNER_EXECUTE);
            //add group permissions
            perms.add(PosixFilePermission.GROUP_READ);
            perms.add(PosixFilePermission.GROUP_WRITE);
            perms.add(PosixFilePermission.GROUP_EXECUTE);
            //add others permissions
            perms.add(PosixFilePermission.OTHERS_READ);
            perms.add(PosixFilePermission.OTHERS_WRITE);
            perms.add(PosixFilePermission.OTHERS_EXECUTE);

            System.out.println(newFile.getAbsoluteFile().getParent().toString());

            Files.setPosixFilePermissions(Paths.get(newFile.getAbsoluteFile().getParent().toString()), perms);

            if (!newFile.exists()) {

                if (!newFile.createNewFile()) {
                    System.out.println("failed");
                    model.addAttribute("status", "failed");
                    return "marketing/AddToMarketingSuccess";

                }
            }
            outputStream = new FileOutputStream(newFile);
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            marketingFileQueue.add(fileName);

            InsertMarketingMain insertMarketingMain = new InsertMarketingMain();
            Thread threadInsert = new Thread(insertMarketingMain);
            if (!threadInsert.getState().equals("RUNNING")) {
                threadInsert.start();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("status", "success");

        return "marketing/AddToMarketingSuccess";
    }

    @RequestMapping(value = "/insert-status", method = RequestMethod.GET)
    public String getFileInserStatus(Model model) {


        model.addAttribute("insertStatus", insertStatus);
        return "hello";
    }

    @RequestMapping(value = "/update-status", method = RequestMethod.GET)
    public String getFileUpdateStatus(Model model) {


        model.addAttribute("updateStatus", updateStatus);
        return "hello";
    }


    /**/
    @RequestMapping(value = "/companyHouseClients", method = RequestMethod.GET)
    public String rendCompanyHouseClients(Model model) {
        List clients = marketingMainService.getAllMarketingMain();
        List registeredOffice = registeredOfficeService.getAllRegisteredOffice();
        Hashtable<String, String> registeredOfficeHashtable = new Hashtable();

        for (int i = 0; i < registeredOffice.size(); i++) {
            String address = "";
            RegisteredOfficeEntity registeredOfficeEntity = (RegisteredOfficeEntity) registeredOffice.get(i);
            if (registeredOfficeEntity.getAddressLine1R() != null) {
                if (!registeredOfficeEntity.getAddressLine1R().matches(""))
                    address = registeredOfficeEntity.getAddressLine1R();
            }
            if (registeredOfficeEntity.getAddressLine2R() != null) {
                if (!registeredOfficeEntity.getAddressLine2R().matches(""))
                    address = address + "\n" + registeredOfficeEntity.getAddressLine2R();
            }
            if (registeredOfficeEntity.getAddressLine3R() != null) {
                if (!registeredOfficeEntity.getAddressLine3R().matches(""))
                    address = address + "\n" + registeredOfficeEntity.getAddressLine3R();
            }
            if (registeredOfficeEntity.getAddressLine4R() != null) {
                if (!registeredOfficeEntity.getAddressLine4R().matches(""))
                    address = address + "\n" + registeredOfficeEntity.getAddressLine4R();
            }
            registeredOfficeHashtable.put(registeredOfficeEntity.getCompanyRegNo(), address);
        }
        model.addAttribute("clients", clients);
        model.addAttribute("registeredOfficeHashtable", registeredOfficeHashtable);
        return "marketing/companyHouseClients";
    }


    @RequestMapping(value = "manage-user-accounts", method = RequestMethod.GET)
    public String manageUserAccounts(Model model) {
        List users = authenticationService.getAllUsers();
        model.addAttribute("companyusers", users);
        return "admin/ManageUserAccounts";
    }


    @RequestMapping(value = "/appointment-overview", method = RequestMethod.GET)
    public String rendAppointmentOverview(Model model) throws JsonProcessingException {
        List appointmentList = appointmentService.getAllAppointments();
        model.addAttribute("appointments", appointmentList);
        return "marketing/AppointmentsOverview";
    }

    @RequestMapping(value = "/company-client-detail", method = RequestMethod.GET)
    public String companyClientDetails(Model model, String companyRegNumber) {
        MarketingMainEntity marketingMainEntity = marketingMainService.getMarketingMain(companyRegNumber);
        RegisteredOfficeEntity registeredOfficeEntity = registeredOfficeService.getRegisteredOffice(companyRegNumber);
        BusinessOfficeEntity businessOfficeEntity = businessOfficeService.getBusinessOffice(companyRegNumber);

        model.addAttribute("marketingMainEntity", makeNullToEmpty(marketingMainEntity));
        model.addAttribute("businessOfficeEntity", makeNullToEmpty(businessOfficeEntity));
        model.addAttribute("registeredOfficeEntity", makeNullToEmpty(registeredOfficeEntity));
        return "marketing/companyclientdetail";
    }

    @RequestMapping(value = "/company-client-detail-submit", method = RequestMethod.POST)
    public String companyClientDetailsSubmit(RegisteredOfficeEntity registeredOfficeEntity, BusinessOfficeEntity businessOfficeEntity, MarketingMainEntity marketingMainEntity) {
        businessOfficeService.insert(businessOfficeEntity);
        registeredOfficeService.insert(registeredOfficeEntity);
        MarketingMainEntity marketingMainEntityDB = marketingMainService.getMarketingMain(marketingMainEntity.getCompanyRegNo());
        marketingMainEntityDB.setAddressLine1(marketingMainEntity.getAddressLine1());
        marketingMainEntityDB.setAddressLine2(marketingMainEntity.getAddressLine2());
        marketingMainEntityDB.setAddressLine3(marketingMainEntity.getAddressLine3());
        marketingMainEntityDB.setAddressLine4(marketingMainEntity.getAddressLine4());
        marketingMainEntityDB.setTown(marketingMainEntity.getCounty());
        marketingMainEntityDB.setCounty(marketingMainEntity.getTitle());
        marketingMainEntityDB.setPostcode(marketingMainEntity.getPostcode());
        marketingMainEntityDB.setTitle(marketingMainEntity.getTitle());
        marketingMainEntityDB.setInitial(marketingMainEntity.getInitial());
        marketingMainEntityDB.setForename(marketingMainEntity.getForename());
        marketingMainEntityDB.setSurname(marketingMainEntity.getSurname());
        marketingMainEntityDB.setJobFunction(marketingMainEntity.getJobFunction());
        marketingMainEntityDB.setJobTitle(marketingMainEntity.getJobTitle());
        marketingMainEntityDB.setTelephoneNumber(marketingMainEntity.getTelephoneNumber());
        marketingMainService.edit(marketingMainEntityDB);
        return "marketing/companyclientdetail";
    }

    @RequestMapping(value = "/fix-appointment", method = RequestMethod.GET)
    public String fixAppointment(Model model, String companyRegNo) throws JsonProcessingException {
        model.addAttribute("marketingMainEntity", marketingMainService.getMarketingMain(companyRegNo));
        return "marketing/makeappointment";
    }


    /*Authentication Mechanism*/

    @RequestMapping(value = "/update-details", method = RequestMethod.GET)
    public String updateUserDetails(Model model, String username, String password) {
        AuthenticationEntity authenticationEntity = authenticationService.getUserDetails("Abiraj");

        authenticationEntity.setRoleId(1);
        authenticationEntity.setEmail("aa");
        authenticationEntity.setIsActive(1);
        authenticationEntity.setLastLoginDate("aa");
        authenticationEntity.setLastLoginTime("aa");
        authenticationEntity.setPassword("aa");
        authenticationEntity.setPosition("aa");
        authenticationService.edit(authenticationEntity);
        return "general/login";
    }

    @RequestMapping(value = "/get-user-edit-page", method = RequestMethod.GET)
    public String getEditUserPage(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        AuthenticationEntity user = authenticationService.getUserDetails(auth.getName());


        model.addAttribute("username", user.getUserName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("position", user.getPosition());
        model.addAttribute("lastlogintime", user.getLastLoginTime());
        model.addAttribute("lastlogindate", user.getLastLoginDate());

        return "authentication/editMyDetails";

    }

    @RequestMapping(value = "/get-overdue-csv", method = RequestMethod.GET)
    public void getOverdueCSV(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final String COMMA_DELIMITER = ",";
        final String NEW_LINE_SEPARATOR = "\n";
        final String FILE_HEADER = "companyRegNo name,registration no, address, mailid, status, date of incorporation,Registered Address";

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(new File("companydetails.xlsx"));
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List clients = marketingMainService.getAllMarketingMain();
        int number = clients.size();
        for (int i = 0; i < number; i++) {
            MarketingMainEntity marketingMainEntity = (MarketingMainEntity) clients.get(i);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = new Date();
            String dateCurrentString = format.format(date);
            boolean val = true;
            try {
                val = format.parse(dateCurrentString).before(format.parse(marketingMainEntity.getNextAccountsDue()));
            } catch (Exception e) {
            }
            if (!val) {
                try {

                    String companyname = String.valueOf(marketingMainEntity.getTradingNameAtLocation());
                    String regnumber = String.valueOf(marketingMainEntity.getCompanyRegNo());
                    String addresline1 = String.valueOf(marketingMainEntity.getAddressLine1());
                    String status = String.valueOf(marketingMainEntity.getStatus());
                    String dateofincorporation = String.valueOf(marketingMainEntity.getDateOfIncorporation());
                    String mailId = String.valueOf(marketingMainEntity.getMailId());


                    if (!companyname.isEmpty())
                        fileWriter.append(companyname.replace(",", " "));
                    fileWriter.append(COMMA_DELIMITER);

                    if (!regnumber.isEmpty())
                        fileWriter.append(regnumber.replace(",", " "));
                    fileWriter.append(COMMA_DELIMITER);

                    if (!addresline1.isEmpty())
                        fileWriter.append(addresline1.replace(",", " "));
                    fileWriter.append(COMMA_DELIMITER);

                    if (!mailId.isEmpty())
                        fileWriter.append(mailId.replace(",", " "));
                    fileWriter.append(COMMA_DELIMITER);

                    if (!status.isEmpty())
                        fileWriter.append(status.replace(",", " "));
                    fileWriter.append(COMMA_DELIMITER);

                    if (!dateofincorporation.isEmpty())
                        fileWriter.append(dateofincorporation.replace(",", " "));
                    fileWriter.append(COMMA_DELIMITER);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        File file = new File("companydetails.xlsx");
        System.out.println("File location on server::" + file.getAbsolutePath());
        InputStream fis = new FileInputStream(file);

//        response.setContentType(mimeType != null? mimeType:"application/octet-stream");

        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "companydetails.xlsx" + "\"");


        ServletOutputStream os = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read = 0;

        while ((read = fis.read(bufferData)) != -1) {
            os.write(bufferData, 0, read);
        }

        os.flush();
        os.close();
        fis.close();

        System.out.println("File downloaded at client successfully");

    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public
    @ResponseBody
    String uploadFileHandler(@RequestParam("name") String name,
                             @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                //printing on CONSOLE
//                logger.info("Server File Location=" + serverFile.getAbsolutePath());

                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }


    private class InsertMarketingMain implements Runnable {

        @Override
        public void run() {

            insertStatus = "Processing";


            while (!marketingFileQueue.isEmpty()) {
                String fileName = marketingFileQueue.remove();

                Excel excel = new Excel();
                ArrayList<String> tradingNames = new ArrayList<String>();
                MarketingClients marketingClients = new MarketingClients();

                try {
                    tradingNames = excel.getTradingNames(fileName, "Shipment ME-44349 Daniel Consul");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < tradingNames.size(); i++) {
                    MarketingMain marketingMain = new MarketingMain();
                    try {
                        marketingMain = excel.getCompanyDetails(fileName, "Shipment ME-44349 Daniel Consul", tradingNames.get(i), marketingClients.getCompanyDetails(tradingNames.get(i)));
                        if (marketingMain.getCompanyRegNo().matches("")) {
                            writeToFile(tradingNames.get(i), "Companies_API_Error");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    marketingMain.setAddedToPotentialClient("False");
                    try {
//                        MarketingMainEntity marketingMainEntity = new MarketingMainEntity(marketingMain.getTradingNameAtLocation(), marketingMain.getCompanyRegNo(), marketingMain.getAddressLine1(), marketingMain.getAddressLine2(), marketingMain.getAddressLine3(), marketingMain.getAddressLine4(), marketingMain.getTown(), marketingMain.getCountry(), marketingMain.getPostCode(), marketingMain.getMailID(), marketingMain.getStatus(), marketingMain.getDateOfIncorporation(), marketingMain.getNextAccountDue(), marketingMain.getNextReturnDue(), marketingMain.getAddedToPotentialClient(), marketingMain.getRegisteredOffice(), marketingMain.getTitle(), marketingMain.getInitial(), marketingMain.getForeName(), marketingMain.getSurname(), marketingMain.getJobFuntion(), marketingMain.getJobTitile(), marketingMain.getTelephoneNumber());
                        MarketingMainEntity marketingMainEntity = new MarketingMainEntity(marketingMain.getCompanyRegNo(), marketingMain.getAddedToPotentialClient(), marketingMain.getAddressLine1(), marketingMain.getAddressLine2(), marketingMain.getAddressLine3(), marketingMain.getAddressLine4(), marketingMain.getCountry(), marketingMain.getMailID(), marketingMain.getDateOfIncorporation(), marketingMain.getForeName(), marketingMain.getInitial(), marketingMain.getJobFuntion(), marketingMain.getJobTitile(), marketingMain.getNextAccountDue(), marketingMain.getNextReturnDue(), marketingMain.getPostCode(), marketingMain.getStatus(), marketingMain.getSurname(), marketingMain.getTelephoneNumber(), marketingMain.getTitle(), marketingMain.getTown(), marketingMain.getTradingNameAtLocation(), "");
                        if (!marketingMainEntity.getCompanyRegNo().equals("")) {
                            marketingMainService.insert(marketingMainEntity);
                            registeredOfficeService.insert(marketingMain.getRegisteredOfficeEntity());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }


            insertStatus = "Insertion Finished";
        }
    }

    private void writeToFile(String line, String filePath) {
        PrintStream fileStream = null;
        File file = new File(filePath);

        try {
            fileStream = new PrintStream(new FileOutputStream(file, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fileStream.println(line);
        fileStream.close();
    }

    private class UpdateMarketingMain implements Runnable {
        List marketingMainAll = new ArrayList();
        MarketingClients marketingClients = new MarketingClients();
        MarketingMain marketingMain;//=new MarketingMain();

        @Override
        public void run() {
            updateStatus = "Updating Database";
            marketingMainAll = marketingMainService.getAllMarketingMain();

            for (int i = 0; i < marketingMainAll.size(); i++) {
                MarketingMainEntity marketingMainEntityFromDB = (MarketingMainEntity) marketingMainAll.get(i);
                marketingMain = new MarketingMain(marketingMainEntityFromDB.getCompanyRegNo(), marketingMainEntityFromDB.getAddressLine1(), marketingMainEntityFromDB.getAddressLine2(), marketingMainEntityFromDB.getAddressLine3(), marketingMainEntityFromDB.getAddressLine4(), marketingMainEntityFromDB.getAddedToPotentialClient(), marketingMainEntityFromDB.getCounty(), marketingMainEntityFromDB.getMailId(), marketingMainEntityFromDB.getDateOfIncorporation(), marketingMainEntityFromDB.getForename(), marketingMainEntityFromDB.getInitial(), marketingMainEntityFromDB.getJobFunction(), marketingMainEntityFromDB.getJobTitle(), marketingMainEntityFromDB.getNextAccountsDue(), marketingMainEntityFromDB.getNextReturnDue(), marketingMainEntityFromDB.getPostcode(), marketingMainEntityFromDB.getStatus(), marketingMainEntityFromDB.getSurname(), marketingMainEntityFromDB.getTelephoneNumber(), marketingMainEntityFromDB.getTitle(), marketingMainEntityFromDB.getTown(), marketingMainEntityFromDB.getTradingNameAtLocation(), null);

                marketingMain = marketingClients.updateCompanyDetails(marketingMain);
                try {
                    MarketingMainEntity marketingMainEntity = new MarketingMainEntity(marketingMain.getTradingNameAtLocation(), marketingMain.getCompanyRegNo(), marketingMain.getAddressLine1(), marketingMain.getAddressLine2(), marketingMain.getAddressLine3(), marketingMain.getAddressLine4(), marketingMain.getTown(), marketingMain.getCountry(), marketingMain.getPostCode(), marketingMain.getMailID(), marketingMain.getStatus(), marketingMain.getDateOfIncorporation(), marketingMain.getNextAccountDue(), marketingMain.getNextReturnDue(), marketingMain.getAddedToPotentialClient(), marketingMain.getTitle(), marketingMain.getInitial(), marketingMain.getForeName(), marketingMain.getSurname(), marketingMain.getJobFuntion(), marketingMain.getJobTitile(), marketingMain.getTelephoneNumber(), "");
                    if (!marketingMainEntity.getCompanyRegNo().equals("")) {
                        marketingMainService.edit(marketingMainEntity);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            updateStatus = "Update finished";

        }
    }

    /**
     * ********************************* Client Page ****************************************************************
     */


    @RequestMapping(value = "/dates-and-notes", method = RequestMethod.POST)
    public String getDatesAndNotes(Model model, String comRegNo) {

        OurClientsNewEntity ourClientsNewEntity = ourClientNewService.getOurClientNew(comRegNo);
        if (ourClientsNewEntity == null) {
            MarketingClients marketingClients = new MarketingClients();
            ourClientsNewEntity = marketingClients.getClientDetails(comRegNo);

            if (ourClientsNewEntity.getCompanyName() != null) {
                model.addAttribute("ourClientsNewEntity", makeNullToEmpty(ourClientsNewEntity));
                return "ourclient/DateAndNotes";
            } else {
                //redirect to error page
                return "ourclient/error";
            }
        } else {
            if (ourClientsNewEntity.getAccountLastAcMadeUpTo() == null) {
                MarketingClients marketingClients = new MarketingClients();
                ourClientsNewEntity = marketingClients.getClientDetails(comRegNo);
            } else if (ourClientsNewEntity.getAccountLastAcMadeUpTo().matches("null")) {
                MarketingClients marketingClients = new MarketingClients();
                ourClientsNewEntity = marketingClients.getClientDetails(comRegNo);
            }
            model.addAttribute("ourClientsNewEntity", makeNullToEmpty(ourClientsNewEntity));
            return "ourclient/DateAndNotes";
        }
    }


    @RequestMapping(value = "/dates-and-notes-process", method = RequestMethod.POST)
    public String setDatesAndNotes(Model model, OurClientsNewEntity ourClientsNewEntity, String day, String month) {
        ourClientsNewEntity.setAccountReferrenceDate(java.sql.Date.valueOf("2000-" + month + "-" + day));

        OurClientsNewEntity ourClientsNewEntityDB = ourClientNewService.getOurClientNew(ourClientsNewEntity.getComRegNo());

        if (ourClientsNewEntityDB == null) {
            ourClientNewService.insert(ourClientsNewEntity);
        } else {
            ourClientsNewEntityDB.setAccountReferrenceDate(ourClientsNewEntity.getAccountReferrenceDate());
            ourClientsNewEntityDB.setDateOfIncoporate(ourClientsNewEntity.getDateOfIncoporate());
            ourClientsNewEntityDB.setDateStatus(ourClientsNewEntity.getDateStatus());
            ourClientsNewEntityDB.setAccountLastAcMadeUpTo(ourClientsNewEntity.getAccountLastAcMadeUpTo());
            ourClientsNewEntityDB.setAccountNextAcDue1(ourClientsNewEntity.getAccountNextAcDue1());
            ourClientsNewEntityDB.setAccountNextAcDue2(ourClientsNewEntity.getAccountNextAcDue2());
            ourClientsNewEntityDB.setAccountLastAcMadeUpTo(ourClientsNewEntity.getAccountLastAcMadeUpTo());
            ourClientsNewEntityDB.setAnnualNextArMadeUpTo(ourClientsNewEntity.getAnnualNextArMadeUpTo());
            ourClientsNewEntityDB.setAnnualNextArDue(ourClientsNewEntity.getAnnualNextArDue());
            ourClientsNewEntityDB.setAnnualLastFullMemberList(ourClientsNewEntity.getAnnualLastFullMemberList());
            ourClientsNewEntityDB.setNotes(ourClientsNewEntity.getNotes());
            ourClientsNewEntityDB.setNotesDates(ourClientsNewEntity.getNotesDates());
            ourClientsNewEntityDB.setNotesAccount(ourClientsNewEntity.getNotesAccount());
            ourClientsNewEntityDB.setNotesAnnualReturn(ourClientsNewEntity.getNotesAnnualReturn());
            ourClientNewService.edit(ourClientsNewEntityDB);
        }
        model.addAttribute("error", "Added");
        return "general/index";
    }

    @RequestMapping(value = "/dates-and-notes-process-com", method = RequestMethod.POST)
    public String setDatesAndNotesCOM(Model model, String comRegNo, String dateOfIncoporate, String notesDates, String notesAccount, String notesAnnualReturn, String notes, String dateStatus, String accountLastAcMadeUpTo, String accountNextAcDue1, String accountNextAcDue2, String annualLastArMadeUpTo, String annualNextArMadeUpTo, String annualNextArDue, String annualLastFullMemberList, String day, String month) {

        OurClientsNewEntity ourClientsNewEntityDB = ourClientNewService.getOurClientNew(comRegNo);

        java.sql.Date dateOfIncorporate;
        if (dateOfIncoporate == null || dateOfIncoporate.matches("")) {
            dateOfIncorporate = null;
        } else {
            dateOfIncorporate = java.sql.Date.valueOf(dateOfIncoporate);
        }


        java.sql.Date accountRefferenceDate;
        if (day.matches("") || month.matches("")) {
            accountRefferenceDate = null;
        } else {
            accountRefferenceDate = java.sql.Date.valueOf("2000-" + month + "-" + day);
        }


        if (ourClientsNewEntityDB == null) {
//            ourClientNewService.insert(new OurClientsNewEntity(comRegNo,"","","","","",dateOfIncorporate, accountRefferenceDate,0,0,"","","",0,"","","",notesDates,notesAccount,notesAnnualReturn,notes,dateStatus,accountLastAcMadeUpTo,accountNextAcDue1,accountNextAcDue2,annualLastArMadeUpTo,annualNextArMadeUpTo,annualNextArDue,annualLastFullMemberList,"","","","",""));
            model.addAttribute("error", "Company not available");
            return "general/index";
        } else {
            ourClientsNewEntityDB.setAccountReferrenceDate(accountRefferenceDate);
            ourClientsNewEntityDB.setDateOfIncoporate(dateOfIncorporate);
            ourClientsNewEntityDB.setDateStatus(dateStatus);
            ourClientsNewEntityDB.setAccountLastAcMadeUpTo(accountLastAcMadeUpTo);
            ourClientsNewEntityDB.setAccountNextAcDue1(accountNextAcDue1);
            ourClientsNewEntityDB.setAccountNextAcDue2(accountNextAcDue2);
            ourClientsNewEntityDB.setAccountLastAcMadeUpTo(accountLastAcMadeUpTo);
            ourClientsNewEntityDB.setAnnualNextArMadeUpTo(annualNextArMadeUpTo);
            ourClientsNewEntityDB.setAnnualNextArDue(annualNextArDue);
            ourClientsNewEntityDB.setAnnualLastFullMemberList(annualLastFullMemberList);
            ourClientsNewEntityDB.setNotes(notes);
            ourClientsNewEntityDB.setNotesDates(notesDates);
            ourClientsNewEntityDB.setNotesAccount(notesAccount);
            ourClientsNewEntityDB.setNotesAnnualReturn(notesAnnualReturn);
            ourClientNewService.edit(ourClientsNewEntityDB);
            model.addAttribute("error", "Added");
            return "general/index";
        }

    }

    @RequestMapping(value = "/private-contact-details", method = RequestMethod.POST)
    public String getPrivateContactWindow(Model model) {

        return "ourclient/AuthorizedContactDetails";

    }

    @RequestMapping(value = "/client-remider", method = RequestMethod.GET)
    public String getClientReminder(Model model) {
        List ourClientNew = ourClientNewService.getAllOurClientNew();

        ArrayList<ClientReminderResponse> finalAccounts = new ArrayList<ClientReminderResponse>();
        ArrayList<ClientReminderResponse> abbreviatedAccounts = new ArrayList<ClientReminderResponse>();
        ArrayList<ClientReminderResponse> annualAccounts = new ArrayList<ClientReminderResponse>();

        for (int i = 0; i < ourClientNew.size(); i++) {
            OurClientsNewEntity ourClientsNewEntity = (OurClientsNewEntity) ourClientNew.get(i);
            MarketingMainEntity marketingMainEntity = marketingMainService.getMarketingMain(ourClientsNewEntity.getComRegNo());
            if (marketingMainEntity != null) {
                ClientReminderResponse clientReminderResponseFinalAccounts = new ClientReminderResponse(marketingMainEntity.getCompanyRegNo(), ourClientsNewEntity.getClientRef(), "", String.valueOf(ourClientsNewEntity.getAccountReferrenceDate()), "", marketingMainEntity.getStatus(), "");
                finalAccounts.add(clientReminderResponseFinalAccounts);
                ClientReminderResponse clientReminderResponseAbbreviatedAccounts = new ClientReminderResponse(marketingMainEntity.getCompanyRegNo(), ourClientsNewEntity.getClientRef(), "", String.valueOf(marketingMainEntity.getNextAccountsDue()), "", marketingMainEntity.getStatus(), "");
                abbreviatedAccounts.add(clientReminderResponseAbbreviatedAccounts);
                ClientReminderResponse clientReminderResponseAnnualAccounts = new ClientReminderResponse(marketingMainEntity.getCompanyRegNo(), ourClientsNewEntity.getClientRef(), "", String.valueOf(marketingMainEntity.getNextReturnDue()), "", marketingMainEntity.getStatus(), "");
                annualAccounts.add(clientReminderResponseAnnualAccounts);
            }

        }
        model.addAttribute("finalAccounts", finalAccounts);
        model.addAttribute("abbreviatedAccounts", abbreviatedAccounts);
        model.addAttribute("annualAccounts", annualAccounts);
        return "ourclient/ClientReminders";
    }

    @RequestMapping(value = "/our-client-search", method = RequestMethod.POST)
    public String searchOurClients(Model model, String companyRegNo) {
        OurClientsNewEntity ourClientsNewEntity = null;

        if (!companyRegNo.matches("[0-9]+")) {
            List list = ourClientNewService.getAllOurClientNew(companyRegNo);
            if (list.size() > 0)
                ourClientsNewEntity = (OurClientsNewEntity) list.get(0);
        } else {
            ourClientsNewEntity = ourClientNewService.getOurClientNew(companyRegNo);
        }
        if (ourClientsNewEntity == null) {
            MarketingClients marketingClients = new MarketingClients();
            ourClientsNewEntity = marketingClients.getClientDetails(companyRegNo);


            if (ourClientsNewEntity.getCompanyName() != null) {
                RegisteredOfficeEntity registeredOfficeEntity = marketingClients.getRegisteredOfficeEntity(companyRegNo);
                BusinessOfficeEntity businessOfficeEntity = businessOfficeService.getBusinessOffice(companyRegNo);
                PostalOfficeEntity postalOfficeEntity = postalOfficeService.getPostalOffice(companyRegNo);
                model.addAttribute("registeredOfficeEntity", makeNullToEmpty(registeredOfficeEntity));
                model.addAttribute("businessOfficeEntity", makeNullToEmpty(businessOfficeEntity));
                model.addAttribute("postalOfficeEntity", makeNullToEmpty(postalOfficeEntity));

                model.addAttribute("ourClientsNewEntity", makeNullToEmpty(ourClientsNewEntity));
                return "ourclient/ClientHandlingWindow";
            } else {
                //redirect to error page
                model.addAttribute("error", "Company Not Available");
                return "general/index";
            }

        } else {
            RegisteredOfficeEntity registeredOfficeEntity = registeredOfficeService.getRegisteredOffice(companyRegNo);
            BusinessOfficeEntity businessOfficeEntity = businessOfficeService.getBusinessOffice(companyRegNo);
            PostalOfficeEntity postalOfficeEntity = postalOfficeService.getPostalOffice(companyRegNo);
            model.addAttribute("registeredOfficeEntity", makeNullToEmpty(registeredOfficeEntity));
            model.addAttribute("businessOfficeEntity", makeNullToEmpty(businessOfficeEntity));
            model.addAttribute("postalOfficeEntity", makeNullToEmpty(postalOfficeEntity));
            model.addAttribute("ourClientsNewEntity", makeNullToEmpty(ourClientsNewEntity));
            return "ourclient/ClientHandlingWindow";
        }
    }


    @RequestMapping(value = "/process-client-handling-window", method = RequestMethod.POST)
    public String processClientHandlingWindow(Model model, RegisteredOfficeEntity registeredOfficeEntity, BusinessOfficeEntity businessOfficeEntity, PostalOfficeEntity postalOfficeEntity, OurClientsNewEntity ourClientsNewEntity) {

        OurClientsNewEntity ourClientsNewEntityDB = ourClientNewService.getOurClientNew(ourClientsNewEntity.getComRegNo());
        if (ourClientsNewEntityDB == null) {
            ourClientNewService.insert(ourClientsNewEntity);
        } else {
            ourClientsNewEntity.setAccountReferrenceDate(ourClientsNewEntityDB.getAccountReferrenceDate());
            ourClientsNewEntity.setDateOfIncoporate(ourClientsNewEntityDB.getDateOfIncoporate());
            ourClientsNewEntity.setDateStatus(ourClientsNewEntityDB.getDateStatus());
            ourClientsNewEntity.setAccountLastAcMadeUpTo(ourClientsNewEntityDB.getAccountLastAcMadeUpTo());
            ourClientsNewEntity.setAccountNextAcDue1(ourClientsNewEntityDB.getAccountNextAcDue1());
            ourClientsNewEntity.setAccountNextAcDue2(ourClientsNewEntityDB.getAccountNextAcDue2());
            ourClientsNewEntity.setAccountLastAcMadeUpTo(ourClientsNewEntityDB.getAccountLastAcMadeUpTo());
            ourClientsNewEntity.setAnnualNextArMadeUpTo(ourClientsNewEntityDB.getAnnualNextArMadeUpTo());
            ourClientsNewEntity.setAnnualNextArDue(ourClientsNewEntityDB.getAnnualNextArDue());
            ourClientsNewEntity.setAnnualLastFullMemberList(ourClientsNewEntityDB.getAnnualLastFullMemberList());
            ourClientsNewEntity.setNotes(ourClientsNewEntityDB.getNotes());
            ourClientsNewEntity.setNotesDates(ourClientsNewEntityDB.getNotesDates());
            ourClientsNewEntity.setNotesAccount(ourClientsNewEntityDB.getNotesAccount());
            ourClientsNewEntity.setNotesAnnualReturn(ourClientsNewEntityDB.getNotesAnnualReturn());
            ourClientNewService.edit(ourClientsNewEntity);
        }

        if (registeredOfficeService.getRegisteredOffice(ourClientsNewEntity.getComRegNo()) == null) {
            registeredOfficeService.insert(registeredOfficeEntity);
        } else {
            registeredOfficeService.edit(registeredOfficeEntity);
        }

        if (businessOfficeService.getBusinessOffice(ourClientsNewEntity.getComRegNo()) == null) {
            businessOfficeService.insert(businessOfficeEntity);
        } else {
            businessOfficeService.edit(businessOfficeEntity);
        }

        if (postalOfficeService.getPostalOffice(ourClientsNewEntity.getComRegNo()) == null) {
            postalOfficeService.insert(postalOfficeEntity);
        } else {
            postalOfficeService.edit(postalOfficeEntity);
        }

        if (ourClientsNewEntity.getClientRef() != null)
            payrollService.insert(new PayrollEntity(ourClientsNewEntity.getClientRef(), ourClientsNewEntity.getCompanyName(), "", "", "", "pending", "pending",
                    "Pending", "Pending", "Pending", "Pending", "Pending", "Pending", "Pending", "Pending", "Pending", "Pending",
                    "Pending", "Pending", "Pending", "Pending", "Pending", "Pending", "Pending", ""));

        model.addAttribute("error", "Added to Our Clients");
        return "general/index";
    }

    @RequestMapping(value = "/our-client-search-otherthan-com", method = RequestMethod.POST)
    public String processClientHandlingWindowCOM(Model model, RegisteredOfficeEntity registeredOfficeEntity, BusinessOfficeEntity businessOfficeEntity, PostalOfficeEntity postalOfficeEntity, String comRegNo, String clientRef, String companyName, String placeOfReg, String type, String status, String accountOffice, String payeRef, String nestId, Integer vat, String officer1, String officer2, String officer3, String service, String statuaryAccounts, String bookKeeping, String payRoll, String vatSelect, String dateOfIncoporate, String accountReferrenceDate, String utrNo, String taxDistrictNo) {

        OurClientsNewEntity ourClientsNewEntity = ourClientNewService.getOurClientNew(comRegNo);
        if (ourClientsNewEntity == null) {
            registeredOfficeService.insert(registeredOfficeEntity);
            businessOfficeService.insert(businessOfficeEntity);
            postalOfficeService.insert(postalOfficeEntity);

            java.sql.Date dateOfIncorporate;
            if (dateOfIncoporate == null || dateOfIncoporate.matches("")) {
                dateOfIncorporate = null;
            } else {
                dateOfIncorporate = java.sql.Date.valueOf(dateOfIncoporate);
            }


            java.sql.Date accountRefferenceDate;
            if (accountReferrenceDate == null || accountReferrenceDate.matches("")) {
                accountRefferenceDate = null;
            } else {
                accountRefferenceDate = java.sql.Date.valueOf(accountReferrenceDate);
            }

            int utrnoInt;
            if (utrNo == null || utrNo.matches("")) {
                utrnoInt = 0;
            } else {
                utrnoInt = Integer.parseInt(utrNo);
            }

            int taxdisticInt;
            if (taxDistrictNo == null || taxDistrictNo.matches("")) {
                taxdisticInt = 0;
            } else {
                taxdisticInt = Integer.parseInt(taxDistrictNo);
            }
            ourClientNewService.insert(new OurClientsNewEntity(comRegNo, clientRef, companyName, placeOfReg, type, status, dateOfIncorporate, accountRefferenceDate, utrnoInt, taxdisticInt, accountOffice, payeRef, nestId, vat, officer1, officer2, officer3, "", "", "", "", "", "", "", "", "", "", "", "", service, statuaryAccounts, bookKeeping, payRoll, vatSelect));

            model.addAttribute("error", "Added to Our Clients");
            return "general/index";
        } else {
            model.addAttribute("error", "Client already exist");
            return "general/index";
        }

    }

    @RequestMapping(value = "/save-private-contact-details", method = RequestMethod.POST)
    public String savePrivateClient(Model model, String contactPerson, String telephone) {

        return "";
    }

    @RequestMapping(value = "/get-payroll", method = RequestMethod.GET)
    public String getPayroll(Model model) {

        List payrollList = payrollService.getAllPayrolls();
        model.addAttribute("payrollList", payrollList);

        return "ourclient/Payroll";
    }


    @RequestMapping(value = "/update-potential-client", method = RequestMethod.POST)
    public
    @ResponseBody
    String addUser(String comid, String value) {
        MarketingMainEntity marketingMainEntity = marketingMainService.getMarketingMain(comid);
        marketingMainEntity.setAddedToPotentialClient(value);
        marketingMainService.edit(marketingMainEntity);
        return "success";

    }


    @RequestMapping(value = "/get-generated-error-files", method = RequestMethod.GET)
    public void getNotUpdatedClients(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("Companies_API_Error");
        System.out.println("File location on server::" + file.getAbsolutePath());
        InputStream fis = new FileInputStream(file);

        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "Companies_API_Error" + "\"");


        ServletOutputStream os = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read = 0;

        while ((read = fis.read(bufferData)) != -1) {
            os.write(bufferData, 0, read);
        }

        os.flush();
        os.close();
        fis.close();

        System.out.println("File downloaded at client successfully");

    }

    private RegisteredOfficeEntity makeNullToEmpty(RegisteredOfficeEntity registeredOfficeEntity) {
        if (registeredOfficeEntity == null) {
            registeredOfficeEntity = new RegisteredOfficeEntity();
        } else {
            if (registeredOfficeEntity.getRegionR() == null)
                registeredOfficeEntity.setRegionR("");
            if (registeredOfficeEntity.getLocalityR() == null)
                registeredOfficeEntity.setLocalityR("");
            if (registeredOfficeEntity.getCareOfR() == null)
                registeredOfficeEntity.setCareOfR("");
            if (registeredOfficeEntity.getAddressLine1R() == null)
                registeredOfficeEntity.setAddressLine1R("");
            if (registeredOfficeEntity.getAddressLine2R() == null)
                registeredOfficeEntity.setAddressLine2R("");
            if (registeredOfficeEntity.getAddressLine3R() == null)
                registeredOfficeEntity.setAddressLine3R("");
            if (registeredOfficeEntity.getAddressLine4R() == null)
                registeredOfficeEntity.setAddressLine4R("");
            if (registeredOfficeEntity.getLocalityR() == null)
                registeredOfficeEntity.setLocalityR("");
            if (registeredOfficeEntity.getPostalCodeR() == null)
                registeredOfficeEntity.setPostalCodeR("");
        }
        return registeredOfficeEntity;
    }

    private OurClientsNewEntity makeNullToEmpty(OurClientsNewEntity ourClientsNewEntity) {
        if (ourClientsNewEntity.getOfficer1() == null)
            ourClientsNewEntity.setOfficer1("");
        if (ourClientsNewEntity.getOfficer2() == null)
            ourClientsNewEntity.setOfficer2("");
        if (ourClientsNewEntity.getOfficer3() == null)
            ourClientsNewEntity.setOfficer3("");
        if (ourClientsNewEntity.getClientRef() == null)
            ourClientsNewEntity.setClientRef("");
        if (ourClientsNewEntity.getStatus() == null)
            ourClientsNewEntity.setStatus("");
        if (ourClientsNewEntity.getAccountOffice() == null)
            ourClientsNewEntity.setAccountOffice("");
        if (ourClientsNewEntity.getPayeRef() == null)
            ourClientsNewEntity.setPayeRef("");
        if (ourClientsNewEntity.getNestId() == null)
            ourClientsNewEntity.setNestId("");
        if (ourClientsNewEntity.getNotesDates() == null)
            ourClientsNewEntity.setNotesDates("");
        if (ourClientsNewEntity.getNotesAnnualReturn() == null)
            ourClientsNewEntity.setNotesAnnualReturn("");
        if (ourClientsNewEntity.getNotesAccount() == null)
            ourClientsNewEntity.setNotesAccount("");
        if (ourClientsNewEntity.getNotes() == null)
            ourClientsNewEntity.setNotes("");
        if (ourClientsNewEntity.getDateStatus() == null)
            ourClientsNewEntity.setDateStatus("");
        if (ourClientsNewEntity.getDateStatus().matches("null"))
            ourClientsNewEntity.setDateStatus("");
        return ourClientsNewEntity;
    }

    private BusinessOfficeEntity makeNullToEmpty(BusinessOfficeEntity businessOfficeEntity) {
        if (businessOfficeEntity == null) {
            businessOfficeEntity = new BusinessOfficeEntity();
        } else {
            if (businessOfficeEntity.getRegionB() == null)
                businessOfficeEntity.setRegionB("");
            if (businessOfficeEntity.getLocalityB() == null)
                businessOfficeEntity.setLocalityB("");
            if (businessOfficeEntity.getAddressLine1B() == null)
                businessOfficeEntity.setAddressLine1B("");
            if (businessOfficeEntity.getAddressLine2B() == null)
                businessOfficeEntity.setAddressLine2B("");
            if (businessOfficeEntity.getAddressLine3B() == null)
                businessOfficeEntity.setAddressLine3B("");
            if (businessOfficeEntity.getAddressLine4B() == null)
                businessOfficeEntity.setAddressLine4B("");
            if (businessOfficeEntity.getCareOfB() == null)
                businessOfficeEntity.setCareOfB("");
        }
        return businessOfficeEntity;
    }

    private MarketingMainEntity makeNullToEmpty(MarketingMainEntity marketingMainEntity) {
        if (marketingMainEntity == null) {
            marketingMainEntity = new MarketingMainEntity();
        } else {
            if (marketingMainEntity.getCurn() == null)
                marketingMainEntity.setCurn("");
        }
        return marketingMainEntity;
    }

    private PostalOfficeEntity makeNullToEmpty(PostalOfficeEntity postalOfficeEntity) {
        if (postalOfficeEntity == null) {
            postalOfficeEntity = new PostalOfficeEntity();
        } else {
            if (postalOfficeEntity.getRegionP() == null)
                postalOfficeEntity.setRegionP("");
            if (postalOfficeEntity.getLocalityP() == null)
                postalOfficeEntity.setLocalityP("");
        }


        return postalOfficeEntity;
    }


    @RequestMapping(value = "/get-arr-abb-finance", method = RequestMethod.GET)
    public String getArrAbbFinance(Model model) {
        List ourClientsNewEntityList = ourClientNewService.getAllOurClientNew();
        model.addAttribute("ourClientsNewEntityList", ourClientsNewEntityList);

        return "ourclient/ArrAbbFinance";
    }

    @RequestMapping(value = "/our-client-search-otherthan-com", method = RequestMethod.GET)
    public String searchOurClientsOtherThanCOm(Model model) {
        return "ourclient/OtherthanComClients";

    }


    @RequestMapping(value = "/dates-and-notes-otherthan-com", method = RequestMethod.POST)
    public String searchDateandNotesOtherthanClients(Model model, String comRegNo) {
        model.addAttribute("comRegNo", comRegNo);
        return "ourclient/DateandNotesOtherClient";
    }

    @RequestMapping(value = "/update-payroll-values", method = RequestMethod.POST)
    public
    @ResponseBody
    String updatePayroll(String comid, String value, String coloumn) {
        PayrollEntity payrollEntity = payrollService.getPayroll(comid);

        if (coloumn.equals("psPrEx"))
            payrollEntity.setPsPrEx(value);
        else if (coloumn.equals("letter"))
            payrollEntity.setLetter(value);
        else if (coloumn.equals("checked"))
            payrollEntity.setLetter(value);
        else if (coloumn.equals("psPri"))
            payrollEntity.setPsPri(value);
        else if (coloumn.equals("letPr"))
            payrollEntity.setLetPr(value);
        else if (coloumn.equals("eMail"))
            payrollEntity.seteMail(value);
        else if (coloumn.equals("post"))
            payrollEntity.setPost(value);
        else if (coloumn.equals("rtiJan"))
            payrollEntity.setRtiJan(value);
        else if (coloumn.equals("rtiFeb"))
            payrollEntity.setRtiFeb(value);
        else if (coloumn.equals("rtiMar"))
            payrollEntity.setRtiMar(value);
        else if (coloumn.equals("rtiApr"))
            payrollEntity.setRtiApr(value);
        else if (coloumn.equals("rtiMay"))
            payrollEntity.setRtiMay(value);
        else if (coloumn.equals("rtiJun"))
            payrollEntity.setRtiJun(value);
        else if (coloumn.equals("rtiJul"))
            payrollEntity.setRtiJul(value);
        else if (coloumn.equals("rtiAug"))
            payrollEntity.setRtiAug(value);
        else if (coloumn.equals("rtiSep"))
            payrollEntity.setRtiSep(value);
        else if (coloumn.equals("rtiOct"))
            payrollEntity.setRtiOct(value);
        else if (coloumn.equals("rtiNov"))
            payrollEntity.setRtiNov(value);
        else if (coloumn.equals("rtiDec"))
            payrollEntity.setRtiDec(value);

        payrollService.edit(payrollEntity);
        return "success";

    }


    @RequestMapping(value = "/update-payroll-coments", method = RequestMethod.POST)
    public
    @ResponseBody
    String updatePayrollComment(String comid, String value) {

        PayrollEntity payrollEntity = payrollService.getPayroll(comid);
        payrollEntity.setComments(value);
        payrollService.edit(payrollEntity);
        return "success";

    }

    @RequestMapping(value = "/display-our-client-list", method = RequestMethod.GET)
    public String DisplayOurClientList(Model model) {
        List ourClientsNewEntityList = ourClientNewService.getAllOurClientNew();
        model.addAttribute("ourClientsNewEntityList", ourClientsNewEntityList);
        return "ourclient/OurClientList";

    }


}


