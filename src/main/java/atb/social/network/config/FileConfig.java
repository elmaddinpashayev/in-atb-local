package atb.social.network.config;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileConfig {

    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }


    public static void deleteDirectoryJava7(String filePath)
            throws IOException {

        Path path = Paths.get(filePath);
        if (Files.isDirectory(path)) {
            Files.walkFileTree(path, new SimpleFileVisitor<>() {

                        // delete directories or folders
                        @Override
                        public FileVisitResult postVisitDirectory(Path dir,
                                                                  IOException exc)
                                throws IOException {
                            Files.deleteIfExists(dir);
                            System.out.printf("Directory is deleted : %s%n", dir);
                            return FileVisitResult.CONTINUE;
                        }

                        // delete files
                        @Override
                        public FileVisitResult visitFile(Path file,
                                                         BasicFileAttributes attrs)
                                throws IOException {
                            Files.deleteIfExists(file);
                            System.out.printf("File is deleted : %s%n", file);
                            return FileVisitResult.CONTINUE;
                        }
                    }
            );
        }


    }


    public static void deleteFile(String filePath) {

        File myObj = new File(filePath);
        if (myObj.delete()) {
            System.out.println("Deleted the folder: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the folder.");
        }
    }


}
