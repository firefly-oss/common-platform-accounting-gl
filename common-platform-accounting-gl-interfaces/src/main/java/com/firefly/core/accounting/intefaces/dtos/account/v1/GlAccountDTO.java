package com.firefly.core.accounting.intefaces.dtos.account.v1;

import com.firefly.annotations.ValidCurrencyCode;
import com.firefly.core.accounting.intefaces.enums.account.v1.GlAccountTypeEnum;
import com.firefly.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlAccountDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    private String code;
    private String name;
    private GlAccountTypeEnum type;

    @FilterableId
    private UUID parentId;

    private boolean isLeaf;
    private boolean active;

    @ValidCurrencyCode
    private String currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
