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



    public static void initialize(String appName){
         applicationName = appName;
         System.out.println("AdvancedLogger was initialized by " + appName);
         inform(logName);
    }
    public static void log(boolean logToFile, LogType logType){
        logToFile = logToFile;
    }
    private static String logName = "log-" + format.format(date) + "-" + applicationName;
    public static void inform(String message){
        if(applicationName != null){
            System.out.println("[" + format.format(date) + "] " + "[" + applicationName + "] [Main/INFO]: " +  message);

            if (logToFile && logType == LogType.all){
                Saver.writeFile(logName,"[" + format.format(date) + "] " +"[" + applicationName + "] [Main/INFO]: " +  message);
            }
        } else {
            notInitialized();
        }

    }
    public static void alert(String message, AlertType alertTypes){
        if(applicationName != null){
            if(alertTypes == AlertType.warning){
                System.out.println("[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ALERT]: " +  message);
                if (logToFile){
                    Saver.writeFile(logName,"[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ALERT]: " +  message);
                }
            }
            else if(alertTypes == AlertType.error){
                System.out.println("[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ERROR]: " +  message);
                if (logToFile){
                    Saver.writeFile(logName,"[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ERROR]: " +  message);

                }
            }
            else if(alertTypes == AlertType.fatal){
                System.out.println("[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ERROR]: " +  message);
                if (logToFile){
                    Saver.writeFile(logName,"[" + format.format(date) + "] " +"[" + applicationName + "] [Main/ERROR]: " +  message);
                    Saver.writeFile(logName, "This error was fatal.");
                }
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
