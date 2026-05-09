package java_core_final_project.service;

import java_core_final_project.model.Transaction;
import java.io.FileWriter;
import java.io.IOException;

public class ReportService {
    public void write(
            Transaction transaction,
            String fileName
    ) {
        try (FileWriter writer = new FileWriter("src\\java_core_final_project\\archive\\report.txt", true)){
            String reportLine = transaction.dateTime()
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
}
