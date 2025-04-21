package com.catalis.core.accounting.intefaces.dtos.journal.v1;

import com.catalis.core.accounting.intefaces.enums.journal.v1.JournalLineDrCrEnum;
import com.catalis.core.utils.annotations.FilterableId;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalLineDTO {

    private Long id;

    @FilterableId
    private Long entryId;

    @FilterableId
    private Long accountId;

    private BigDecimal amount;
    private JournalLineDrCrEnum drCr;
    private String memo;
    private String fxCurrency;
    private BigDecimal fxRate;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}