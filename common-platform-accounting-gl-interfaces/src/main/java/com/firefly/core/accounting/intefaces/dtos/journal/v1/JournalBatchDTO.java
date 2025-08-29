package com.firefly.core.accounting.intefaces.dtos.journal.v1;

import com.firefly.core.accounting.intefaces.enums.journal.v1.JournalBatchStatusEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JournalBatchDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String reference;
    private JournalBatchStatusEnum status;
    private LocalDate batchDate;
    private String remarks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
