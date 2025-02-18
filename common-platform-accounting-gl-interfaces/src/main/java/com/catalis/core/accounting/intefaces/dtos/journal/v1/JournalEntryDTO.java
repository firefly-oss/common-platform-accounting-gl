package com.catalis.core.accounting.intefaces.dtos.journal.v1;

import com.catalis.common.core.filters.FilterableId;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalEntryDTO {
    private Long id;

    @FilterableId
    private Long batchId;

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