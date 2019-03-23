package com.springapp.mvc.excelReader;

import com.springapp.mvc.domain.MarketingMain;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by bruntha on 8/11/15.
 */
public class Test {
    public static void main(String args[]) {
        Excel excel=new Excel();
        MarketingMain marketingMain=new MarketingMain();
        AbstractList<String> tradingNames=new ArrayList<String>();
        try {
            excel.getCompanyDetails("Data/Marketing.xlsx","Data for marketing","W M B MOTORS",marketingMain);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < tradingNames.size(); i++) {
            System.out.println(tradingNames.get(i));
        }

    }
}
