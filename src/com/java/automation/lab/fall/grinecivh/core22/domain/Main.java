package com.java.automation.lab.fall.grinecivh.core22.domain;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.AirlineCompany;
import com.java.automation.lab.fall.grinecivh.core22.domain.enums.DictionaryEntity;

public class Main {

    public static void main(String[] args) {

        AirlineCompany airlineCompany = new AirlineCompany("Test", "Test street");

        airlineCompany.getDictionary().addNewDictionary(DictionaryEntity.AIRPORT_LICENSE,"License",
                "C:\\Users\\indasto\\IdeaProjects\\Solvd\\Airport\\src\\resources\\directory\\license.dat");

        airlineCompany.getDictionary().addInDictionary("\nLicence extend", DictionaryEntity.AIRPORT_LICENSE);
        airlineCompany.getDictionary().printDictionary(
                "C:\\Users\\indasto\\IdeaProjects\\Solvd\\Airport\\src\\resources\\directory\\license.dat");

        airlineCompany.getDictionary().addNewDictionary(DictionaryEntity.FLIGHT_COMMENT, "5 stars" ,
                "C:\\Users\\indasto\\IdeaProjects\\Solvd\\Airport\\src\\resources\\directory\\Flight com.dat");
        airlineCompany.getDictionary().addNewDictionary(DictionaryEntity.LUGGAGE_RULE,"Rule 1\nRule 2\n\t2.1\n\t2.2",
                "C:\\Users\\indasto\\IdeaProjects\\Solvd\\Airport\\src\\resources\\directory\\Luggage rule.dat");
        airlineCompany.getDictionary().addNewDictionary(DictionaryEntity.AIRLINE_COMPANY_COMMENT,"Won't fly with them ever again",
                "C:\\Users\\indasto\\IdeaProjects\\Solvd\\Airport\\src\\resources\\directory\\airline company com.dat");


    }
}
