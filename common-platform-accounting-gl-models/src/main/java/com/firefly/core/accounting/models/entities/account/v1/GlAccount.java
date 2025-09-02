package com.firefly.core.accounting.models.entities.account.v1;

import com.firefly.core.accounting.intefaces.enums.account.v1.GlAccountTypeEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("gl_account")
public class GlAccount {
    @Id
    private UUID id;

    private String code;
    private String name;
    private GlAccountTypeEnum type;
    private UUID parentId;
    private boolean isLeaf;
    private boolean active;
    private String currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
