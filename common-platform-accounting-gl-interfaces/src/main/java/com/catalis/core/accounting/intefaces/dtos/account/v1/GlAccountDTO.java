package com.catalis.core.accounting.intefaces.dtos.account.v1;

import com.catalis.core.accounting.intefaces.enums.account.v1.GlAccountTypeEnum;
import com.catalis.core.utils.annotations.FilterableId;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlAccountDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String code;
    private String name;
    private GlAccountTypeEnum type;

    @FilterableId
    private Long parentId;

    private boolean isLeaf;
    private boolean active;
    private String currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}