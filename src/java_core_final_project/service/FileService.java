package java_core_final_project.service;

import java_core_final_project.model.ParsedTransferData;
import java_core_final_project.model.Transaction;
import java_core_final_project.util.FileParser;

import java.io.File;

//читаем файлы, перемещаем файлы
public class FileService {
    private final TransferService transferService;
    private final FileParser fileParser;

    public FileService(TransferService transferService, FileParser fileParser) {
        this.transferService = transferService;
        this.fileParser = fileParser;
    }

    public void processInputDirectory(String path) {
        File directory = new File(path);
        File[] files = directory.listFiles();
        if(files == null || files.length == 0) {
            System.out.println("Файлы не найдены");
            return;
        }

        for (File file : files) {
            if (!isTxtFile(file)) continue;

            processFile(file);
        }
    }

    private void processFile (File file) {
        try {
            ParsedTransferData data = fileParser.parse(file);
            Transaction transaction = transferService.transfer(
                    data.fromAccount(),
                    data.toAccount(),
                    data.amount()
            );

            // пока просто выводим результат
            System.out.println(transaction);

            // TODO:
            // записать в report.txt

            // TODO:
            // переместить файл в archive
        } catch (Exception e) {
            System.out.println("Ошибка обработки файла: " + file.getName());
        }

    }

    private boolean isTxtFile (File file) {
        return file.isFile() && file.getName().endsWith(".txt");

    }
}
