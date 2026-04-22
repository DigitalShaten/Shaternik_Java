package java_core_final_project.model;

import java.time.LocalDateTime;

//транзакции
public record Transaction (
        String fromAccount,
        String toAccount,
        int amount,
        TransactionStatus status,
        LocalDateTime dateTime
) {}
