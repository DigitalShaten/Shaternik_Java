package java_core_final_project.service;

import java_core_final_project.model.ParsedTransferData;
import java_core_final_project.model.Transaction;
import java_core_final_project.util.FileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

public class FileService {
    private final TransferService transferService;
    private final FileParser fileParser;
    private final ReportService reportService;

    public FileService(TransferService transferService, FileParser fileParser, ReportService reportService) {
        this.transferService = transferService;
        this.fileParser = fileParser;
        this.reportService = reportService;
    }

    public void processInputDirectory(String inputPath, String archivePath) {
        File directory = new File(inputPath);
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Файлы для обработки не найдены.");
            return;
        }

        for (File file : files) {
            if (isTxtFile(file)) {
                processFile(file);
                moveFileToArchive(file, archivePath);
            }
        }
    }

    private void processFile (File file) {
        try {
            List<ParsedTransferData> operations = fileParser.parse(file);
            for (ParsedTransferData data : operations) {

                Transaction transaction =
                        transferService.transfer(
                                data.fromAccount(),
                                data.toAccount(),
                                data.amount()
                        );

                reportService.write(transaction, file.getName());
            }
        } catch (IOException ioException) {
            System.out.println("Ошибка обработки файла: " + file.getName());
        }
    }

    private void moveFileToArchive(File file, String archivePath) {
        try {
            Path archiveDir = Paths.get(archivePath);

            if (!Files.exists(archiveDir)) {
                Files.createDirectories(archiveDir);
            }

            Path source = file.toPath();
            Path target = archiveDir.resolve(file.getName());

            Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл " + file.getName() + " успешно перенесен в архив.");
        } catch (IOException e) {
            System.err.println("Не удалось переместить файл в архив: " + file.getName());
        }
    }

    public void readArchiveFiles(String archivePath) {
        File directory = new File(archivePath);
        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Архив пуст.");
            return;
        }

        for (File file : files) {
            System.out.println("Содержимое файла: " + file.getName());
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения архива.");
            }
        }
    }

    private boolean isTxtFile (File file) {
        return file.isFile() && file.getName().endsWith(".txt");
    }
}
