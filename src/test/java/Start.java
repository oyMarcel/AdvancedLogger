import tk.oymarcel.advancedlogger.AdvancedLogger;
import tk.oymarcel.advancedlogger.util.AlertType;
import tk.oymarcel.advancedlogger.util.save.LogType;

public class Start {
    public static void main(String[] args)
    {
        AdvancedLogger.register("test");
        AdvancedLogger.logType(LogType.all);
        AdvancedLogger.inform("hi");
        AdvancedLogger.alert("yo", AlertType.error);
    }
}
