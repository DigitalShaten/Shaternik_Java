package java_core_final_project.service;

import java_core_final_project.model.ParsedTransferData;
import java_core_final_project.model.Transaction;
import java_core_final_project.util.FileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public void processInputDirectory(String path, boolean changeMode) {
        File directory = new File(path);
        File[] files = directory.listFiles();
        if(files == null || files.length == 0) {
            System.out.println("Файлы не найдены");
            return;
        }

        for (File file : files) {
            if (!isTxtFile(file)) continue;

            if (changeMode) processFile(file);
            else readFile(file);
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
    private void readFile (File file) {
        try (FileReader fileReader = new FileReader(file)){
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException  ioException) {
            System.out.println("Ошибка чтения файла: " + file.getName());
        }
    }

    private boolean isTxtFile (File file) {
        return file.isFile() && file.getName().endsWith(".txt");

    }
}
