package java_core_final_project.util;

import java_core_final_project.model.ParsedTransferData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {

    public List<ParsedTransferData> parse(File file) throws FileNotFoundException {
        List<ParsedTransferData> result = new ArrayList<>();

        String fromAccount = null;
        String toAccount = null;
        int amount = 0;

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                if (fromAccount != null && toAccount != null) {
                    result.add (new ParsedTransferData(fromAccount, toAccount, amount));
                }
                fromAccount = null;
                toAccount = null;
                amount = 0;
                continue;
            }
            if (line.startsWith("from:")) {
                fromAccount = line.substring(5).trim();
            }

            else if (line.startsWith("to:")) {
                toAccount = line.substring(3).trim();
            }

            else if (line.startsWith("amount:")) {
                amount = Integer.parseInt(line.substring(7).trim());
            }
        }

        if (fromAccount != null && toAccount != null) {
            result.add(new ParsedTransferData(fromAccount, toAccount, amount));
        }

        scanner.close();

        return result;
    }
}
