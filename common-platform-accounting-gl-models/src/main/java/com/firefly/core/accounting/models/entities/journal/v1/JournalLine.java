package com.firefly.core.accounting.models.entities.journal.v1;

import com.firefly.core.accounting.intefaces.enums.journal.v1.JournalLineDrCrEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("journal_line")
public class JournalLine {
    @Id
    private Long id;

    private Long entryId;
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
