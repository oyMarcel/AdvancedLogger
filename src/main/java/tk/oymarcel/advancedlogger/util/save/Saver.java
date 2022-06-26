package tk.oymarcel.advancedlogger.util.save;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tk.oymarcel.advancedlogger.AdvancedLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Saver {

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static File file;

    private static final String ranpath = AdvancedLogger.class.getProtectionDomain().getCodeSource().getLocation().getPath();

    /*
     * Writes and saves everything to a json
     * @param fileName The name of the file to be generated
     * @paran write The string to be written to the file
     */
    public static void writeFile(String fileName, String write) {
        file = new File(fileName + File.separator + "C:\\AdvancedLogs");

        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try{
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getPath());
            fw.write(write);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
