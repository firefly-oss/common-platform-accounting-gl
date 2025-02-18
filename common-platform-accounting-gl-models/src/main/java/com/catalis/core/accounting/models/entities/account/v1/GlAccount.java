package com.catalis.core.accounting.models.entities.account.v1;

import com.catalis.core.accounting.intefaces.enums.account.v1.GlAccountTypeEnum;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("gl_account")
public class GlAccount {
    @Id
    private Long id;

    private String code;
    private String name;
    private GlAccountTypeEnum type;
    private Long parentId;
    private boolean isLeaf;
    private boolean active;
    private String currency;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
