package com.java.automation.lab.fall.grinecivh.core22.domain.classes;

import com.java.automation.lab.fall.grinecivh.core22.domain.enums.DictionaryEntity;

public class Dictionary {

    private String airportLicence;
    private String luggageRules;
    private String flightComments;
    private String airlineCompanyComments;

    public void addNewDictionary(DictionaryEntity entity,String content, String path){
        FileUtil.overwrite(content, path);

        switch (entity){
            case AIRLINE_COMPANY_COMMENT:
                airlineCompanyComments = path;
                break;
            case FLIGHT_COMMENT:
                flightComments = path;
                break;
            case AIRPORT_LICENSE:
                airportLicence = path;
                break;
            case LUGGAGE_RULE:
                luggageRules = path;
                break;
        }
    }

    public void addInDictionary(String content, String path){
        FileUtil.append(content,path);
    }

    public void addInDictionary(String content, DictionaryEntity entity){
        String path = null;
        switch (entity){
            case AIRLINE_COMPANY_COMMENT:
                path = airlineCompanyComments;
                break;
            case FLIGHT_COMMENT:
                path = flightComments;
                break;
            case AIRPORT_LICENSE:
                path = airportLicence;
                break;
            case LUGGAGE_RULE:
                path = luggageRules;
                break;
        }
        FileUtil.append(content,path);
    }

    public void printDictionary(String path){
        System.out.println(FileUtil.read(path));
    }

}
