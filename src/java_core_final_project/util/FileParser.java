package java_core_final_project.util;

import java_core_final_project.model.ParsedTransferData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//разбор файлов
public class FileParser {

    public ParsedTransferData parse (File file) throws FileNotFoundException {
        String fromAccount = null;
        String toAccount = null;
        int amount = 0;

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            if (line.startsWith("from:")) {
                fromAccount =
                        line.substring(5).trim();
            }

            else if (line.startsWith("to:")) {
                toAccount =
                        line.substring(3).trim();
            }

            else if (line.startsWith("amount:")) {
                amount = Integer.parseInt(
                        line.substring(7).trim()
                );
            }
        }

        scanner.close();

        return new ParsedTransferData(
                fromAccount,
                toAccount,
                amount
        );
    }
}
