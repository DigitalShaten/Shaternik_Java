package java_core_final_project.util;

import java_core_final_project.model.ParsedTransferData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileParser {

    private static final String ACCOUNT_REGEX = "\\d{5}-\\d{5}";

    public List<ParsedTransferData> parse(File file) throws FileNotFoundException {
        List<ParsedTransferData> result = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        String fromAccount = null;
        String toAccount = null;
        double amount = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                validateAndAdd(result, fromAccount, toAccount, amount);
                fromAccount = null; toAccount = null; amount = 0;
                continue;
            }
            if (line.startsWith("from:")) {
                fromAccount = line.substring(5).trim();
            } else if (line.startsWith("to:")) {
                toAccount = line.substring(3).trim();
            } else if (line.startsWith("amount:")) {
                try {
                    amount = Double.parseDouble(line.substring(7).trim());
                } catch (NumberFormatException e) {
                    System.err.println("Ошибка формата суммы в файле " + file.getName());
                    amount = -1;
                }
            }
        }
        validateAndAdd(result, fromAccount, toAccount, amount);
        scanner.close();
        return result;
    }

    private void validateAndAdd(List<ParsedTransferData> list, String from, String to, double amount) {
        if (from != null && to != null) {
            if (from.matches(ACCOUNT_REGEX) && to.matches(ACCOUNT_REGEX)) {
                list.add(new ParsedTransferData(from, to, amount));
            } else {
                System.err.println("Ошибка формата счета: " + from + " или " + to);
            }
        }
    }
}