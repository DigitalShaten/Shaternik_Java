package java_core_final_project.model;

public record ParsedTransferData(
        String fromAccount,
        String toAccount,
        int amount
) {}