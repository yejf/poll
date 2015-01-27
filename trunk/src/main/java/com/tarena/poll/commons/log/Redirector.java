package com.tarena.poll.commons.log;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Calendar;

/**
 * defined Redirector log��manage System.setErr and System.setOut output.
 * 2008-9-9.
 * 
 * @author		[Tarena Training Group]
 * @version	1.0
 * @since		JDK1.6(suggestion)
 * @author madf
 */

public final class Redirector {

    /** The output stream for writing redirect file. */
    private static RedirectStream sRedirectStream = null;

    /**
     * Redirects the standard output into a log file with defualt settings.
     *
     * @throws IllegalStateException if redirect has already opened.
     * @throws FileNotFoundException if the redirect file cann't be accessed.
     * @see #open(String, boolean)
     */
    public static void open() throws IllegalStateException
            , FileNotFoundException {
        open(getFileName(), true);
    }

    /**
     * Redirects standard output into the specified file and depends on the
     * writing methods, If append, redirect will write information to the end
     * of the specified file, otherwise the beginning.
     *
     * @param fileName String the file name to be written down.
     * @param append boolean if true, redirect information will be written
     *        to the end of the file rather than the beginning.
     * @throws FileNotFoundException if the redirect file cann't be accessed.
     * @throws IllegalStateException if redirect has already opened.
     */
    public static void open(String fileName, boolean append) throws
            FileNotFoundException
            , IllegalStateException {
        if (!isOpened()) {
            try {
                sRedirectStream = new RedirectStream(new FileOutputStream(
                        fileName, append), true);
//                System.setErr(sRedirectStream);
//                System.setOut(sRedirectStream);
            } catch (FileNotFoundException fnfe) {
                throw new FileNotFoundException(
                        "Cann't create output file!");
            }
        } else {
            throw new IllegalStateException(
                    "Redirect has already been opened!");
        }
    }

    /**
     * Creates the file name for redirector, the file name convention is
     * according to log file.
     * 
     * @return the file name.
     */
    private static String getFileName() {
//    	 return "./log/poll_redirector_logs" + formatCurrentTimeForFile() + ".log";
    	String path = "./log";
    	String file = "/poll_redirector_logs.log";
    	File red = new File(path);
    	if(!red.exists()){
    		red.mkdirs();
    	}
        return path + file;
    }

    /**
     * Gets the status of redirect, true if it has been opened.
     * 
     * @return the open status.
     */
    public static boolean isOpened() {
        return (sRedirectStream != null);
    }

    /**
     * Closes the output stream.
     *
     * @throws IllegalStateException if redirect has already been closed.
     */
    public static void close() throws IllegalStateException {
        if (isOpened()) {
            sRedirectStream.close();
            sRedirectStream = null;
        } else {
            throw new IllegalStateException(
                            "Redirect has already been closed!");
        }
    }

    /**
     * Gets a simple format of current time as YYYY-MM-DD HH:MM:SS ZZZ.
     *
     * @return the formatted string.
     */
    private static String formatCurrentTime() {
        Calendar now = Calendar.getInstance();

        // The length of string will not bigger than 23.
        StringBuffer buf = new StringBuffer(23);

        buf.append(now.get(Calendar.YEAR));
        buf.append('-');
        buf.append(roundInt(now.get(Calendar.MONTH) + 1, 2));
        buf.append('-');
        buf.append(roundInt(now.get(Calendar.DATE), 2));
        buf.append(' ');
        buf.append(roundInt(now.get(Calendar.HOUR_OF_DAY), 2));
        buf.append(':');
        buf.append(roundInt(now.get(Calendar.MINUTE), 2));
        buf.append(':');
        buf.append(roundInt(now.get(Calendar.SECOND), 2));
        buf.append(' ');
        buf.append(roundInt(now.get(Calendar.MILLISECOND), 3));

        return buf.toString();
    }

    /**
     * A function used to round the int to specified digital.
     *
     * @param value the int value.
     * @param digital the expected digital.
     * @return the rounded string for the <code>value</code>.
     * @throws IllegalArgumentException if the digital of <code>value</code>
     *         is bigger than <code>digital</code>.
     */
    private static StringBuffer roundInt(int value, int digital)
                                    throws IllegalArgumentException {

        StringBuffer buf = new StringBuffer(digital);
        buf.append(value);

        int length = buf.length();
        if (length > digital) {
            throw new IllegalArgumentException(
                    "Digital length is less than value.");
        } else if (length == digital) {
            return buf;
        } else {
            for (int i = length; i < digital; i++) {
                buf.insert(0, '0');
            }
            return buf;
        }
    }

    /**
     * Gets a simple format of current time as 'YYYYMMDD_HHMMSS_ZZZ'
     * for filename.
     *
     * @return the formatted string.
     */
    @SuppressWarnings("unused")
	private static String formatCurrentTimeForFile() {
        Calendar now = Calendar.getInstance();

        // The length of string will not bigger than 23.
        StringBuffer buf = new StringBuffer(19);

        buf.append(now.get(Calendar.YEAR));
        buf.append(roundInt(now.get(Calendar.MONTH) + 1, 2));
        buf.append(roundInt(now.get(Calendar.DATE), 2));

        return buf.toString();
    }

    /**
     * Overrides <code>PrintStream</code> for formatting the output strings,
     * and attaches the time for clearly reading and tracing.
     */
    private static class RedirectStream extends PrintStream {

        /**
         * Construct the RedirectStream.
         * 
         * @param out the out stream.
         * @param autoFlush the flag of auto flush.
         * @see java.io.PrintStream#PrintStream(OutputStream, boolean)
         */
        public RedirectStream(OutputStream out, boolean autoFlush) {
            super(out, autoFlush);
        }

        /**
         * Prints the time before writing <code>String</code> logs.
         *
         * @parm x the string to be printed.
         * @see java.io.PrintStream#println(String)
         */
        public void println(String x) {
            synchronized (this) {
                print("[" + formatCurrentTime() + "] ");
                super.println(x);
            }
        }

        /**
         * Prints the time before writing <code>object</code> logs.
         *
         * @param obj the object to be printed.
         * @see java.io.PrintStream#println(Object)
         */
        public void println(Object obj) {
            synchronized (this) {
                if (!String.valueOf(obj).startsWith("at")) {
                    print("[" + formatCurrentTime() + "] ");
                }
                super.println(obj);
            }
        }
    }
}
