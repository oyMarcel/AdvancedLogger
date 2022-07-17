package tk.oymarcel.advancedlogger;

import tk.oymarcel.advancedlogger.util.AlertType;
import tk.oymarcel.advancedlogger.util.save.LogType;
import tk.oymarcel.advancedlogger.util.save.Saver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdvancedLogger {

    public static boolean logToFile;
    private static String applicationName;
    private static LogType logType;


    static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    static Date date = new Date();



    /**
     * Register the advanced logger to activate it
     * @param appName your application name that the logger will display
     */
    public static void register(String appName){
        applicationName = appName;
        System.out.println("AdvancedLogger was initialized by " + appName);
    }
    /**
     * Switch logging types
     * @param logType all logs the informations too and errorsOnly only logs the logs produced by the alert function
     */
    public static void logType(LogType logType){
    }
    private static String logName = "log-" + format.format(date) + "-" + applicationName;

    /**
     * Produce an informative message
     */
    public static void inform(String message){
        if(applicationName != null){
            System.out.println("[" + format.format(date) + "] " + "[" + applicationName + "] [Main/INFO]: " +  message);

            if (logType == LogType.all){
                Saver.writeFile(logName,"[" + format.format(date) + "] " +"[" + applicationName + "] [Main/INFO]: " +  message);
            }
        } else {
            notInitialized();
        }

    }

    /**
     * Produce a warning message
     * @param alertTypes warning gives a warning, error gives an error, and fatal gives an error and crashes right after
     */
    public static void alert(String message, AlertType alertTypes){
        if(applicationName != null){
            if(alertTypes == AlertType.warning){
                System.out.println("[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ALERT]: " +  message);
                Saver.writeFile(logName,"[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ALERT]: " +  message);
            }
            else if(alertTypes == AlertType.error){
                System.out.println("[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ERROR]: " +  message);
                Saver.writeFile(logName,"[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ERROR]: " +  message);
            }
            else if(alertTypes == AlertType.fatal){
                System.out.println("[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ERROR]: " +  message);
                Saver.writeFile(logName,"[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ERROR]: " +  message);
                Saver.writeFile(logName, "This error was fatal.");
                System.exit(-1);
            }

        } else {
            notInitialized();
        }
    }
    private static void notInitialized(){
        System.out.println("AdvancedLogger was not initialized");
    }
}
