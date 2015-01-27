package com.tarena.poll.commons.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Format date util. Format the given date type object to string with a given
 * pattern.
 * 
 * @author madf
 */
public class DateFormat {
    
    /** Date formator. */
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat();
    public static final String YYY_MM_DD = "yyy/MM/dd";
    
    /**
     * Get a current date and format it to the type given.
     * For example, DateFormat.getCurrentDate("yyyy-MM-dd");
     * The returned string is "2005-07-22".
     * 
     * @param format the format pattern. 
     * @return the formatted date string.
     */
    public static String getCurrentDate(String format){
    	Calendar cale = Calendar.getInstance();
    	return  getFormatedDate(cale.getTime(), format);
    }
    
    /**
     * Get a date and format it to the type given.
     * For example, DateFormat.getFormatedDate(new Date(),"yyyy-MM-dd");
     * The returned string is "2005-07-22".
     * 
     * @param date the date to be formatted.
     * @param format the format pattern. 
     * @return the formatted date string.
     */
    public static String getFormatedDate(Date date, String format) {
        if (date == null) {
            throw new NullPointerException("Date to format can not be null.");
        }
        
        if (format == null) {
            throw new NullPointerException("Format pattern can not be null.");
        }
        // Get a formater.
        FORMAT.applyPattern(format);
        
        return FORMAT.format(date);
    }
    
    /**
     * @param date
     * @return
     */
    public static String format(String date) {
        if (date != null && date.length() == 8) {
            return date.substring(0, 4) + "/" + date.substring(4, 6) + "/"
                    + date.substring(6, 8);
        }
        return date;
    }

    // Below code is merged from TigerGuiConstants class in ATB project.
    private final static SimpleDateFormat sDateParser = new SimpleDateFormat( "yyyyMMdd" );

//    private final static SimpleDateFormat sDateFormat = new SimpleDateFormat( "yyyy/MM/dd" );
    private final static SimpleDateFormat sDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
    /*
     * @author zhengxh
     * @date   2009_1_6 pm 12:42
     * 为了业务需要，在马老师的代码中加了一个方法和属性
     * 为了得到yyyy/MM/dd HH:mm类型的时间。
     */
    
    private final static SimpleDateFormat pollTimeFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private final static SimpleDateFormat sHHMMSSTimeParser = new SimpleDateFormat( "HHmmss" );

    private final static SimpleDateFormat sFullTimeFormat = new SimpleDateFormat( "yyyyMMddHHmmss" );

    private final static SimpleDateFormat sHHMMSSTimeFormat = new SimpleDateFormat( "HH:mm:ss" );

    private final static SimpleDateFormat sHHMMTimeParser = new SimpleDateFormat( "HHmm" );

    private final static SimpleDateFormat sHHMMTimeFormat = new SimpleDateFormat( "HH:mm" );
    
    /**
     * @parma date date string, its format is 'yyyy/MM/dd HH:mm'.
     * @return an instance of <code>Data</code>
     * @author zhengxh
     * 
     */
    public static Date getPollDate(String date) {
        Date objDate = null;
        try {
            objDate = pollTimeFormat.parse( date );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	return objDate;
    }
    
    
    /**
     * Format date to specified format.
     * 
     * @param rawDate instance of <code>Date</code>.
     * @return string format of date.
     */
    public static String getPollFormatDate(Date rawDate) {
        String date = "";

        date = pollTimeFormat.format( rawDate );
        return date;
    }
    
    
    
    
    
    
    /**
     * Format a date string to a <code>Data</code> object, the format of date string is 'yyyy/MM/dd'.
     * 
     * @param date date string, its format is 'yyyy/MM/dd'.
     * @return an instance of <code>Data</code>.
     */
    public static Date getDate(String date) {
        Date objDate = null;
        try {
            objDate = sDateFormat.parse( date );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return objDate;
    }
    
    /**
     * Format date to specified format.
     * 
     * @param rawDate instance of <code>Date</code>.
     * @return string format of date.
     */
    public static String getFormattedDate(Date rawDate) {
        String date = "";

        date = sDateFormat.format( rawDate );
        return date;
    }
    

    /**
     * Format date for a plain date string, its format is 'yyyyMMdd'.
     * 
     * @param date instance of <code>Date</code>.
     * @return date string.
     */
    public static String convertToPlainFormat(Date date) {
        String plainDateFormat = "";

        plainDateFormat = sDateParser.format( date );
        return plainDateFormat;
    }
    
    /**
     * Format date to "yyyy/MM/dd"
     * 
     * @param date
     * @return format date
     */
    public static String formatDate(String date) {
        if (date == null){
            return null;
        }
        
        if (date.length() >= 8) {
            return date.substring(0, 4) + "/" + date.substring(4, 6) + "/"
                    + date.substring(6, 8);
        }
        return date;
    }
    
    /**
     * Format the date with sympol
     * 
     * @param date
     * @return
     */
    public static String formatDateWithSympol(String date){
        if (date == null ){
            return null;
        }
        
        if (date.length( ) == 8){
            date = formatDate(date);
        } else if (date.length( ) > 9) {
            date = date.substring( 0, 10 ).trim();
        }
        return date;
    }
}
