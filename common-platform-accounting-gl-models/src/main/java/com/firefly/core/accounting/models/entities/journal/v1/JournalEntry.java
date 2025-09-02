package com.firefly.core.accounting.models.entities.journal.v1;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("journal_entry")
public class JournalEntry {
    @Id
    private UUID id;

    private UUID batchId;
    private String transactionId;
    private String sourceModule;
    private BigDecimal totalAmount;
    private String description;
    private LocalDateTime entryDate;
    private boolean posted;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
