package tk.oymarcel.advancedlogger.util.save;

import tk.oymarcel.advancedlogger.AdvancedLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Saver {

    public static final String ranpath = AdvancedLogger.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    public static void writeFile(String fileName, String write) {
        System.out.println(ranpath);

        try (BufferedWriter wr = Files.newBufferedWriter(Paths.get(fileName), StandardCharsets.UTF_8)) {
            wr.write(write);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
