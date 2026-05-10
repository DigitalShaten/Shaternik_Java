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
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileService {
    private final TransferService transferService;
    private final FileParser fileParser;
    private final ReportService reportService;
    private final ExecutorService executor = Executors.newFixedThreadPool(4);

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

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (isTxtFile(file)) {
                    CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                        processFile(file);
                        moveFileToArchive(file, archivePath);
                    }, executor);

                    futures.add(future);
                }
            }
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
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

    public void readReportFile(String archivePath) {
        File reportFile = new File(archivePath, "report.txt");

        if (!reportFile.exists() || !reportFile.isFile()) {
            System.out.println("Файл отчета в архиве не найден.");
            return;
        }

        System.out.println("Содержимое отчета");

        try (BufferedReader reader = new BufferedReader(new FileReader(reportFile))) {
            String line;
            boolean isEmpty = true;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("Файл отчета пуст.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла отчета: " + e.getMessage());
        }
    }

    private boolean isTxtFile (File file) {
        return file.isFile() && file.getName().endsWith(".txt");
    }

    public void shutdown() {
        executor.shutdown();
    }
}
