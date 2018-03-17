package com.tuanche.instance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class C {
    public static int REDIS_CONNECT_TIMEOUT;
    public static int POOL_MAXACTIVIE;
    public static int POOL_MAXIDLE;
    public static int POOL_MINIDLE;
    public static int POOL_MAXWAIT;
    public static boolean POOL_TESTONBORROW;
    public static boolean POOL_TESTONRETURN;
    public static boolean POOL_TESTWHILEIDLE;
    public static int POOL_MINEVICTABLEIDLETIMEMILLIS;
    public static int POOL_TIMEBETWEENEVICTIONRUNSMILLIS;
    public static int POOL_NUMTESTSPEREVICTIONRUN;

    public static boolean AUTOCOMPLETE_USE_PINYIN;
    public static int AUTOCOMPLETE_MAX_RESULT;
    public static String AUTOCOMPLETE_ACKEY;
    public static String AUTOCOMPLETE_SUFFIX_SYMBOLE = "*";

    private static ResourceBundle resource = ResourceBundle.getBundle("redis_search_config");

    static {
        try {
            REDIS_CONNECT_TIMEOUT = Integer.parseInt(resource.getString("timeout"));
            POOL_MAXACTIVIE = Integer.parseInt(resource.getString("maxActive"));
            POOL_MAXIDLE = Integer.parseInt(resource.getString("maxIdle"));
            POOL_MINIDLE = Integer.parseInt(resource.getString("minIdle"));
            POOL_MAXWAIT = Integer.parseInt(resource.getString("maxWait"));

            POOL_TESTONBORROW = Boolean.parseBoolean(resource.getString("testOnBorrow"));
            POOL_TESTONRETURN = Boolean.parseBoolean(resource.getString("testOnReturn"));
            POOL_TESTWHILEIDLE = Boolean.parseBoolean(resource.getString("testWhileIdle"));

            POOL_MINEVICTABLEIDLETIMEMILLIS = Integer.parseInt(resource.getString("minEvictableIdleTimeMillis"));
            POOL_TIMEBETWEENEVICTIONRUNSMILLIS = Integer.parseInt(resource.getString("timeBetweenEvictionRunsMillis"));
            POOL_NUMTESTSPEREVICTIONRUN = Integer.parseInt(resource.getString("numTestsPerEvictionRun"));

            AUTOCOMPLETE_USE_PINYIN = Boolean.parseBoolean(resource.getString("usePinyin"));
            AUTOCOMPLETE_MAX_RESULT = Integer.parseInt(resource.getString("maxRusult"));
            AUTOCOMPLETE_ACKEY = resource.getString("autoCompleteKey");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(C.AUTOCOMPLETE_USE_PINYIN);

    }

}
