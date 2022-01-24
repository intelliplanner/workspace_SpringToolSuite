package com.ipssi.ppgcl.utility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.lang.Nullable;


public class StringUtils {

    final static String  CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    /**
     * Utility method to check where an object is empty or null
     * @param value
     *
     * @return boolean
     */
    public static boolean isNull(Object value) {
        if (value == null || "".equals(value.toString().trim())) {
            return true;
        }
        String strValue = null;
        if (value instanceof Integer
                || value instanceof Float
                || value instanceof Long
                || value instanceof Double
                || value instanceof String
                || value instanceof Date
                || value instanceof LocalDate
                || value instanceof LocalDateTime
                || value instanceof Boolean) {
            strValue = value.toString();
        }

        // strValue will never null in or condition...removed null check
        if (strValue == null || "undefined".equals(strValue.trim()) || "-1".equals(strValue.trim())) {
            return true;
        }
        return false;
    }

    /**
     * Utility method to check where an object is not empty/null
     * @param value
     *
     * @return boolean
     */
    public static boolean isNotNull(Object value) {
        return !isNull(value);
    }

    /**
     * Checks whether a String value is empty or null
     * @param object1
     * @param object2
     */
    public static boolean equals(Object object1,Object object2) {
        if(object1 == null || object2 == null){
            return Boolean.FALSE;
        }
        return object1.equals(object2);
    }

    /**
     * Removes Last Comma If Present
     */
    public static String removeLastComma(String value){
        if(StringUtils.isNotNull(value)){
            int index = value.lastIndexOf(",");
            value = value.substring(0, index);
        }
        return value;
    }

    /**
     * This method splits any comma, space and arrow separated string.
     * @param str
     * @return array of string
     */
    public static String[] split(String str) {
        final String REGEX = "\\s*(\\s|=>|,)\\s*";
        final Pattern p = Pattern.compile(REGEX);
        return p.split(str);
    }

    /**
     * Split sting with commas
     * @param str
     * @return
     */
    public static String[] splitWithComma(String str) {
        final String REGEX = ",\\s*";
        final Pattern p = Pattern.compile(REGEX);
        return p.split(str);
    }

    public static String cleanEmailString(String email) {
        if(isNotNull(email)){
            email = email.replaceAll("[;\\s\\,]+",",");
        }

        return email;
    }

    public static boolean isValidEmailAddress(String aEmailAddress){
        //Regex to restrict leading, trailing, or consecutive dots in emails
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(aEmailAddress);
        return matcher.matches();
    }

    /**
     * This method generates random string
     * @return String
     */
    public static String generateRandomString(int RANDOM_STRING_LENGTH){
        String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    /**
     * This method generates random numbers
     * @return int
     */
    private static int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
    /**
     * This method generates random numbers
     * @return String
     */
    public static String getRandomNumber(Integer digits) {
    	Random randomGenerator = new Random();
    	return String.format("%04d", randomGenerator.nextInt(10000));
    }
    public static String getSixtenDigitRandomNumber() {
    	long nextLong = ThreadLocalRandom.current().nextLong(1000000000000000l, 9999999999999999l);
    	return nextLong+"";
    }
    public static String getWsRefNumber() {
    	Random randomGenerator = new Random();
    	return "OS"+randomGenerator.ints(100000000, (999999999)).limit(1).findFirst().getAsInt();
    }

    /**
     * Utility method to log exception message
     * @param ex: Exception
     *
     * @return Exception message: String
     */
    public static String getStackTrace(Exception ex) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        ex.printStackTrace(pWriter);

        return sWriter.toString();
    }
    
    public static String nullCheck(Object value)
    {
    	if(value !=null && !"null".equalsIgnoreCase(value.toString()))
    	{
    		return value.toString();
    	}
    	else
    	{
    		return "";
    	}
    }

    public static boolean isStringEmptyOrNull(@Nullable Object str) {
        return str == null || "".equals(str.toString().trim()) || "undefined".equalsIgnoreCase(str.toString().trim()) || "-1".equals(str.toString().trim()) || "null".equalsIgnoreCase(str.toString().trim());
    }
    

}
