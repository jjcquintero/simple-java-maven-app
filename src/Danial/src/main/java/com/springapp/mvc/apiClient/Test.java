package com.springapp.mvc.apiClient;

import java.io.File;
import java.io.IOException;

/**
 * Created by bruntha on 8/10/15.
 */
public class Test {
    public static void main(String args[]) {

        File file=new File("Testing.docx");
        try {
            System.out.print(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        MarketingClients marketingClients=new MarketingClients();
//        marketingClients.getCompanyDetails("W M B MOTORS");
    }




}
