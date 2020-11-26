package com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant;

public class IOConstant {
    public static final String PROPERTIES_EXPANSION = ".properties";
    public static final String PROPERTIES_PATH = System.getProperties().getProperty("user.dir") + "/src/main/resources/_config.properties";
    public static final String TMP_DIR_PATH = System.getProperties().getProperty("user.dir") + "/tmp";
    public static final String RS_PATH = TMP_DIR_PATH + "/rs";
    public static final String RQ_PATH = TMP_DIR_PATH + "/rq";
}