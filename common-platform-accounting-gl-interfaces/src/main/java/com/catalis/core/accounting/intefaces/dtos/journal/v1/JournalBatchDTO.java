package com.catalis.core.accounting.intefaces.dtos.journal.v1;

import com.catalis.core.accounting.intefaces.enums.journal.v1.JournalBatchStatusEnum;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalBatchDTO {
    private Long id;
    private String reference;
    private JournalBatchStatusEnum status;
    private LocalDate batchDate;
    private String remarks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
