package com.firefly.core.accounting.models.entities.journal.v1;

import com.firefly.core.accounting.intefaces.enums.journal.v1.JournalBatchStatusEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("journal_batch")
public class JournalBatch {
    @Id
    private Long id;

    private String reference;
    private JournalBatchStatusEnum status;
    private LocalDate batchDate;
    private String remarks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}