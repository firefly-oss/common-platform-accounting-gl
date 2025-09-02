package com.firefly.core.accounting.intefaces.dtos.journal.v1;

import com.firefly.core.utils.annotations.FilterableId;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalEntryDTO {
    private UUID id;

    @FilterableId
    private UUID batchId;

    @FilterableId
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