package com.springapp.mvc.excelReader;

import com.springapp.mvc.domain.MarketingMain;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by bruntha on 8/11/15.
 */
public class Excel {


    public ArrayList<String> getTradingNames(String fileDirectory, String sheetName) throws Exception {

        ArrayList<String> tradingNames = new ArrayList<String>();

        FileInputStream file = new FileInputStream(new File(fileDirectory));

        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int noOfRows = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < noOfRows; i++) {
            XSSFRow row = sheet.getRow(i);
            XSSFCell rowCell = row.getCell(0);
            tradingNames.add(rowCell.getStringCellValue());
        }
        return tradingNames;
    }

    public ArrayList<MarketingMain> getTradingNamesAndDetails(String fileDirectory, String sheetName) throws Exception {

        ArrayList<MarketingMain> marketingMains = new ArrayList<MarketingMain>();

        FileInputStream file = new FileInputStream(new File(fileDirectory));

        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int noOfRows = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < noOfRows; i++) {
            XSSFRow row = sheet.getRow(i);

            MarketingMain marketingMain = new MarketingMain();
            try {
                marketingMain.setTradingNameAtLocation(row.getCell(0).getStringCellValue());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            try {
                marketingMain.setTown(row.getCell(5).getStringCellValue());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            try {
                marketingMain.setCountry(row.getCell(6).getStringCellValue());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
            try {
                marketingMain.setPostCode(row.getCell(7).getStringCellValue());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            try {
//                    marketingMain.setMailID(row.getCell(00).getStringCellValue());    //not in the new table
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            try {
                marketingMain.setTitle(row.getCell(9).getStringCellValue());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            try {
//                    marketingMain.setInitial(row.getCell(13).getStringCellValue()); //not in the new table
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            try {
                marketingMain.setForeName(row.getCell(10).getStringCellValue());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            try {
                marketingMain.setSurname(row.getCell(11).getStringCellValue());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            try {
//                    marketingMain.setJobFuntion(row.getCell(00).getStringCellValue());  //not in the new table
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            try {
                marketingMain.setJobTitile(row.getCell(12).getStringCellValue());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
            try {
                marketingMain.setTelephoneNumber(row.getCell(8).getStringCellValue());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }

            marketingMains.add(marketingMain);
        }
        return marketingMains;
    }

    public MarketingMain getCompanyDetails(String fileDirectory, String sheetName, String companyName, MarketingMain marketingMain) throws Exception {

        FileInputStream file = new FileInputStream(new File(fileDirectory));

        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int noOfRows = sheet.getPhysicalNumberOfRows();

        for (int i = 1; i < noOfRows; i++) {
            XSSFRow row = sheet.getRow(i);
            XSSFCell rowCell = row.getCell(0);
            String tempTradingNameAtLocation = rowCell.getStringCellValue();

            if (tempTradingNameAtLocation.equals(companyName)) {
                try {
                    marketingMain.setTown(row.getCell(5).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    marketingMain.setCountry(row.getCell(6).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    marketingMain.setPostCode(row.getCell(7).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                try {
//                    marketingMain.setMailID(row.getCell(00).getStringCellValue());    //not in the new table
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                try {
                    marketingMain.setTitle(row.getCell(9).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                try {
//                    marketingMain.setInitial(row.getCell(13).getStringCellValue()); //not in the new table
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                try {
                    marketingMain.setForeName(row.getCell(10).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                try {
                    marketingMain.setSurname(row.getCell(11).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                try {
//                    marketingMain.setJobFuntion(row.getCell(00).getStringCellValue());  //not in the new table
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                try {
                    marketingMain.setJobTitile(row.getCell(12).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                try {
                    marketingMain.setTelephoneNumber(row.getCell(8).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }

                try {
                    marketingMain.setMailID(row.getCell(13).getStringCellValue());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                }
                break;
            }
        }
        return marketingMain;
    }
}
