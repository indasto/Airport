package com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant;

public class IOConstant {
    public static final String PROPERTIES_EXPANSION = ".properties";
    public static final String PROPERTIES_PATH = System.getProperties().getProperty("user.dir") + "/src/resources/_config.properties";
    public static final String TMP_DIR_PATH = System.getProperties().getProperty("user.dir") + "/tmp";

    public static final String CLIENT_PATH = TMP_DIR_PATH + "/clients";
    public static final String FLIGHT_PATH = TMP_DIR_PATH + "/flights";
    public static final String PLANE_PATH = TMP_DIR_PATH + "/planes";
    public static final String ROUTE_PATH = TMP_DIR_PATH + "/routes";
    public static final String TICKET_PATH = TMP_DIR_PATH + "/tickets";
    public static final String WORKER_PATH = TMP_DIR_PATH + "/workers";
}