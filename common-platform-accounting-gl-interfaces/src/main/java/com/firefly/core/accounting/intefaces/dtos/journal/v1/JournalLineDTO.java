package com.firefly.core.accounting.intefaces.dtos.journal.v1;

import com.firefly.core.accounting.intefaces.enums.journal.v1.JournalLineDrCrEnum;
import com.firefly.core.utils.annotations.FilterableId;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalLineDTO {

    private UUID id;

    @FilterableId
    private UUID entryId;

    @FilterableId
    private UUID accountId;

    private BigDecimal amount;
    private JournalLineDrCrEnum drCr;
    private String memo;
    private String fxCurrency;
    private BigDecimal fxRate;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}