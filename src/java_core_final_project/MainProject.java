package java_core_final_project;

import java_core_final_project.repository.AccountRepository;
import java_core_final_project.service.FileService;
import java_core_final_project.service.ReportService;
import java_core_final_project.service.TransferService;
import java_core_final_project.util.FileParser;

import java.util.Scanner;

/**
 * Java core final project
 * @author Nikita Shaternik
 * *.05.2026
 */

public class MainProject {
    public static void main(String[] args) {
        AccountRepository accounts = new AccountRepository();
        TransferService transferService = new TransferService(accounts);
        FileParser fileParser = new FileParser();
        ReportService reportService = new ReportService();

        FileService fileService = new FileService(transferService,fileParser, reportService);
        Scanner scanner = new Scanner(System.in);


        System.out.println("Доброй пожаловать в программу переводов!");

        while (true) {
            System.out.println("Выберите необходимый процесс:");
            System.out.println("1. Парсинг файлов перевода из input");
            System.out.println("2. Вывод списка всех переводов из файла-отчета");
            System.out.println("3. Выход из приложения");
            System.out.print("Ввод пользователя (цифра): ");
            int choose = scanner.nextInt();
            if (scanner.hasNextLine()){
                switch (choose) {
                    case 1 -> {
                        fileService.processInputDirectory("src\\java_core_final_project\\input", true);
                        System.out.println("Процесс завершен!");
                    }
                    case 2 -> {
                        fileService.processInputDirectory("src\\java_core_final_project\\archive", false);
                        System.out.println("Процесс завершен!");
                    }
                    case 3 -> {
                        System.out.println("До свидания!");
                        return;
                    }
                }
            } else {
                System.out.println("Введено неверное значение.");
            }
        }
    }
}
