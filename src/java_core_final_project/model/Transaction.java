package java_core_final_project.model;

import java.time.LocalDateTime;

public  record Transaction (
        String fromAccount,
        String toAccount,
        double amount,
        TransactionStatus status,
        String message,
        LocalDateTime dateTime
) {}
