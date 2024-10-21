package com.procurement.loc.requisition;

import com.procurement.loc.loc;

import java.util.Properties;

public class requisitionLocators extends loc {


    public static String projectMethod(Properties properties){
        return "//li[contains(text(),'" + properties.getProperty("Project") + "')]";
    }
}
