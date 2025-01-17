package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogReport {
    private static final Logger LogReport = LogManager.getLogger(LogReport.class);

    //Warn Level Logs
    public static void info (String message) {
        LogReport.info(message);
    }
    //Warn Level Logs
    public static void warn (String message) {
        LogReport.warn(message);
    }
    //Error Level Logs
    public static void error (String message) {
        LogReport.error(message);
    }
    //Fatal Level Logs
    public static void fatal (String message) {
        LogReport.fatal(message);
    }
    //Debug Level Logs
    public static void debug (String message) {
        LogReport.debug(message);
    }
}
