package com.springapp.mvc.apiClient;

import com.springapp.mvc.domain.MarketingMain;
import com.springapp.mvc.domain.OurClientsNewEntity;
import com.springapp.mvc.domain.RegisteredOfficeEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruntha on 8/10/15.
 */
public class MarketingClients {

    private ServiceHandler serviceHandler;
    private HttpResponse httpResponse;
    private boolean isSuccessWebService;
    private HttpEntity httpEntity;
    private InputStream is;
    private JSONParser parsing;
    private JSONObject json;

    MarketingMain marketingMain;//=new MarketingMain();

    public MarketingMain getCompanyDetails(String companyName) {
        marketingMain = new MarketingMain();
        getCompanyDetailsByName(companyName);
        getCompanyDetailsByRegNo(marketingMain.getCompanyRegNo());
        return marketingMain;
    }

    public MarketingMain updateCompanyDetails(MarketingMain marketingMain) {
        this.marketingMain = marketingMain;
        getCompanyDetailsByName(marketingMain.getTradingNameAtLocation());
        getCompanyDetailsByRegNo(marketingMain.getCompanyRegNo());
        return this.marketingMain;
    }

    public OurClientsNewEntity getClientDetails(String companyRegNo) {
        OurClientsNewEntity ourClientsNewEntity = new OurClientsNewEntity();
        ourClientsNewEntity= getCompanyDetails(ourClientsNewEntity);
        ourClientsNewEntity.setComRegNo(companyRegNo);
        List<NameValuePair> value = null;

        serviceHandler = new ServiceHandler();
        httpResponse = serviceHandler.makeServiceCallJson(IPConfig.ip + "/company/" + companyRegNo, 1, value, "RVl3TGFYX0w3ejAzQkRPM0Q0Q0J6NXFuNXRta2VrX1BGVi15bS1jVjo=");

        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            isSuccessWebService = true;
        } else if (httpResponse.getStatusLine().getStatusCode() == 403) {
            isSuccessWebService = false;
        } else if (httpResponse.getStatusLine().getStatusCode() == 404) {
            isSuccessWebService = false;
        } else {
            isSuccessWebService = false;
        }

        if (isSuccessWebService) {
            try {
                httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                parsing = new JSONParser();
                json = parsing.getJSONFromResponse(is);

                try {
                    String month = json.getJSONObject("accounts").getJSONObject("accounting_reference_date").getString("month");
                    String day = json.getJSONObject("accounts").getJSONObject("accounting_reference_date").getString("day");
                    String date = "2000-" + month + "-" + day;
                    ourClientsNewEntity.setAccountReferrenceDate(Date.valueOf(date));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    ourClientsNewEntity.setDateOfIncoporate(Date.valueOf(json.getString("date_of_creation")));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    ourClientsNewEntity.setDateStatus(json.getJSONObject("accounts").getString("overdue"));

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    ourClientsNewEntity.setAccountLastAcMadeUpTo(json.getJSONObject("accounts").getJSONObject("last_accounts").getString("made_up_to"));

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    ourClientsNewEntity.setAccountNextAcDue1(json.getJSONObject("accounts").getString("next_due"));

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    ourClientsNewEntity.setAccountNextAcDue2(json.getJSONObject("accounts").getString("next_made_up_to"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    ourClientsNewEntity.setAnnualLastArMadeUpTo(json.getJSONObject("annual_return").getString("last_made_up_to"));

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    ourClientsNewEntity.setAnnualNextArMadeUpTo(json.getJSONObject("annual_return").getString("next_made_up_to"));

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    ourClientsNewEntity.setAnnualNextArDue(json.getJSONObject("annual_return").getString("next_due"));

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }

                try {
                    ourClientsNewEntity.setAnnualLastFullMemberList(json.getString("last_full_members_list_date"));

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }

                try {
                    ourClientsNewEntity.setCompanyName(json.getString("company_name"));

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ourClientsNewEntity;
    }

    private void getCompanyDetailsByName(String companyName) {

        List<NameValuePair> value = new ArrayList<NameValuePair>();
        value.add(new BasicNameValuePair("q", companyName));

        serviceHandler = new ServiceHandler();
        httpResponse = serviceHandler.makeServiceCallJson(IPConfig.ip + "/search/companies", 1, value, "RVl3TGFYX0w3ejAzQkRPM0Q0Q0J6NXFuNXRta2VrX1BGVi15bS1jVjo=");

        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            isSuccessWebService = true;
        } else if (httpResponse.getStatusLine().getStatusCode() == 403) {
            isSuccessWebService = false;
        } else if (httpResponse.getStatusLine().getStatusCode() == 404) {
            isSuccessWebService = false;
        } else {
            isSuccessWebService = false;
        }

        if (isSuccessWebService) {
            try {
                httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                parsing = new JSONParser();
                json = parsing.getJSONFromResponse(is);

                int totalResult = json.getInt("total_results");

                if (totalResult > 0) {
                    JSONArray array = json.getJSONArray("items");

                    JSONObject jsonObject = (JSONObject) array.get(0);

                    marketingMain.setStatus(jsonObject.getString("company_status"));
                    marketingMain.setCompanyRegNo(jsonObject.getString("company_number"));
                    marketingMain.setTradingNameAtLocation(jsonObject.getString("title"));
                    marketingMain.setAddressLine1(jsonObject.getJSONObject("address").getString("address_line_1"));
                    marketingMain.setAddressLine2(jsonObject.getJSONObject("address").getString("address_line_2"));
                    marketingMain.setDateOfIncorporation(jsonObject.getString("date_of_creation"));

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    
    private OurClientsNewEntity getCompanyDetails(OurClientsNewEntity ourClientsNewEntity) {

        List<NameValuePair> value = new ArrayList<NameValuePair>();
        value.add(new BasicNameValuePair("q", ourClientsNewEntity.getCompanyName()));

        serviceHandler = new ServiceHandler();
        httpResponse = serviceHandler.makeServiceCallJson(IPConfig.ip + "/search/companies", 1, value, "RVl3TGFYX0w3ejAzQkRPM0Q0Q0J6NXFuNXRta2VrX1BGVi15bS1jVjo=");

        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            isSuccessWebService = true;
        } else if (httpResponse.getStatusLine().getStatusCode() == 403) {
            isSuccessWebService = false;
        } else if (httpResponse.getStatusLine().getStatusCode() == 404) {
            isSuccessWebService = false;
        } else {
            isSuccessWebService = false;
        }

        if (isSuccessWebService) {
            try {
                httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                parsing = new JSONParser();
                json = parsing.getJSONFromResponse(is);

                int totalResult = json.getInt("total_results");

                if (totalResult > 0) {
                    JSONArray array = json.getJSONArray("items");

                    JSONObject jsonObject = (JSONObject) array.get(0);

                    ourClientsNewEntity.setStatus(jsonObject.getString("company_status"));
                    ourClientsNewEntity.setDateOfIncoporate(Date.valueOf(jsonObject.getString("date_of_creation")));

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ourClientsNewEntity;
    }

    private void getCompanyDetailsByRegNo(String regNo) {

        List<NameValuePair> value = null;

        serviceHandler = new ServiceHandler();
        httpResponse = serviceHandler.makeServiceCallJson(IPConfig.ip + "/company/" + regNo, 1, value, "RVl3TGFYX0w3ejAzQkRPM0Q0Q0J6NXFuNXRta2VrX1BGVi15bS1jVjo=");

        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            isSuccessWebService = true;
        } else if (httpResponse.getStatusLine().getStatusCode() == 403) {
            isSuccessWebService = false;
        } else if (httpResponse.getStatusLine().getStatusCode() == 404) {
            isSuccessWebService = false;
        } else {
            isSuccessWebService = false;
        }

        if (isSuccessWebService) {
            try {
                httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                parsing = new JSONParser();
                json = parsing.getJSONFromResponse(is);

                try {
                    marketingMain.setNextAccountDue(json.getJSONObject("accounts").getString("next_due"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    marketingMain.setNextReturnDue(json.getJSONObject("annual_return").getString("next_due"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                String companyName = null;
                try {
                    companyName = json.getString("company_name");
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                String careOF = null;
                try {
                    careOF = json.getJSONObject("registered_office_address").getString("care_of");
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                String addL1 = null;
                try {
                    addL1 = json.getJSONObject("registered_office_address").getString("address_line_1");
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                String addL2 = null;
                try {
                    addL2 = json.getJSONObject("registered_office_address").getString("address_line_2");
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                String locality = null;
                try {
                    locality = json.getJSONObject("registered_office_address").getString("locality");
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                String region = null;
                try {
                    region = json.getJSONObject("registered_office_address").getString("region");
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                String postalCode = null;
                try {
                    postalCode = json.getJSONObject("registered_office_address").getString("postal_code");
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }

                String registerdOffice = "";

                if (companyName != null) {
                    registerdOffice = companyName;
                }
                if (careOF != null) {
                    registerdOffice = registerdOffice + "\n" + careOF;
                }
                if (addL1 != null) {
                    registerdOffice = registerdOffice + "\n" + addL1;
                }
                if (addL2 != null) {
                    registerdOffice = registerdOffice + "\n" + addL2;
                }
                if (locality != null) {
                    registerdOffice = registerdOffice + "\n" + locality;
                }
                if (region != null) {
                    registerdOffice = registerdOffice + "\n" + region;
                }
                if (postalCode != null) {
                    registerdOffice = registerdOffice + "\n" + postalCode;
                }
                RegisteredOfficeEntity registeredOfficeEntity = new RegisteredOfficeEntity(marketingMain.getCompanyRegNo(), careOF, addL1, addL2, "", "", locality, region, postalCode);

                marketingMain.setRegisteredOfficeEntity(registeredOfficeEntity);
                if (marketingMain.getTradingNameAtLocation() == null)
                    marketingMain.setTradingNameAtLocation(companyName);

//                JSONArray array=json.getJSONArray("items");

//                JSONObject jsonObject= (JSONObject) array.get(0);

//                marketingMain.setStatus(jsonObject.getString("company_status"));
//                marketingMain.setCompanyRegNo(jsonObject.getString("company_number"));
//                marketingMain.setTitle(jsonObject.getString("title"));
//                marketingMain.setAddressLine1(jsonObject.getJSONObject("address").getString("address_line_1"));
//                marketingMain.setAddressLine2(jsonObject.getJSONObject("address").getString("address_line_2"));

//                String message = json.getString("message");
//                data = new JSONObject(json.getString("data"));

//                JSONObject obj=new JSONObject(data.getString("user"));
//                id=obj.getString("id");
//
//                Intent newIntent=new Intent(loginActivity,HomeActivity.class);
//                loginActivity.startActivity(newIntent);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public RegisteredOfficeEntity getRegisteredOfficeEntity(String regNo) {
        RegisteredOfficeEntity registeredOfficeEntity=new RegisteredOfficeEntity();
        List<NameValuePair> value = null;

        serviceHandler = new ServiceHandler();
        httpResponse = serviceHandler.makeServiceCallJson(IPConfig.ip + "/company/" + regNo, 1, value, "RVl3TGFYX0w3ejAzQkRPM0Q0Q0J6NXFuNXRta2VrX1BGVi15bS1jVjo=");

        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            isSuccessWebService = true;
        } else if (httpResponse.getStatusLine().getStatusCode() == 403) {
            isSuccessWebService = false;
        } else if (httpResponse.getStatusLine().getStatusCode() == 404) {
            isSuccessWebService = false;
        } else {
            isSuccessWebService = false;
        }

        if (isSuccessWebService) {
            try {
                httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
                parsing = new JSONParser();
                json = parsing.getJSONFromResponse(is);

                try {
                    registeredOfficeEntity.setCareOfR(json.getJSONObject("registered_office_address").getString("care_of"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    registeredOfficeEntity.setAddressLine1R(json.getJSONObject("registered_office_address").getString("address_line_1"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    registeredOfficeEntity.setAddressLine2R(json.getJSONObject("registered_office_address").getString("address_line_2"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    registeredOfficeEntity.setAddressLine3R(json.getJSONObject("registered_office_address").getString("address_line_2"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }try {
                    registeredOfficeEntity.setAddressLine4R(json.getJSONObject("registered_office_address").getString("address_line_2"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    registeredOfficeEntity.setLocalityR(json.getJSONObject("registered_office_address").getString("locality"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    registeredOfficeEntity.setRegionR(json.getJSONObject("registered_office_address").getString("region"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
                try {
                    registeredOfficeEntity.setPostalCodeR(json.getJSONObject("registered_office_address").getString("postal_code"));
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return registeredOfficeEntity;
    }

}
