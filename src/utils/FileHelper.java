package utils;

import constant.FileConstant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHelper {
    public static void createFolder() {
        File dir = new File("data");

        if (!dir.exists()) {
            try {
                boolean success = dir.mkdir();
                System.out.println(success ? "Created folder data success" : "Create folder data failed");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void createFile() {
        Path path = getPath(FileConstant.STUDENTS_PATH);
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("Created file data success");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static Path getPath(String src) {
        return Paths.get(src);
    }

    public static void writeFile(Path path, List<String> lines) throws IOException {
        Files.write(path, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
