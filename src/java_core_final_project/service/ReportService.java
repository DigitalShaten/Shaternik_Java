package java_core_final_project.service;

import java_core_final_project.model.Transaction;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ReportService {
    public void write(
            Transaction transaction,
            String fileName
    ) {
        try (FileWriter writer = new FileWriter("src/java_core_final_project/archive/report.txt", true)){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SS");
            String reportLine = transaction.dateTime().format(formatter)
                                + " | "
                                + fileName
                                + " | "
                                + "перевод с "
                                + transaction.fromAccount()
                                + " на "
                                + transaction.toAccount()
                                + " "
                                + transaction.amount()
                                + " | "
                                + transaction.message();
            writer.write(reportLine + System.lineSeparator());
        } catch (IOException ioException) {
            System.out.println("Ошибка записи в report.txt");
        }
    }

    public void showOperationsByDate() {
        Scanner consoleScanner = new Scanner(System.in);
        File reportFile = new File("src/java_core_final_project/archive/report.txt");
        if (!reportFile.exists()) {
            System.out.println("Файл отчета еще не создан. Сначала проведите транзакции (пункт 1).");
            return;
        }

        try {
            System.out.println("Введите дату ОТ (yyyy-MM-dd):");
            String fromInput = consoleScanner.nextLine();
            System.out.println("Введите дату ДО (yyyy-MM-dd):");
            String toInput = consoleScanner.nextLine();

            LocalDate fromDate = LocalDate.parse(fromInput);
            LocalDate toDate = LocalDate.parse(toInput);

            System.out.println("Результаты поиска:");
            try (Scanner fileScanner = new Scanner(reportFile)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] parts = line.split("\\|");

                    if (parts.length < 1) continue;

                    String dateTimeStr = parts[0].trim();
                    LocalDate operationDate = LocalDate.parse(dateTimeStr.substring(0, 10));

                    if (!operationDate.isBefore(fromDate) && !operationDate.isAfter(toDate)) {
                        System.out.println(line);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка: проверьте формат ввода даты (должен быть ГГГГ-ММ-ДД).");
        }
    }
}
