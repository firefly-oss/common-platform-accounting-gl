package com.firefly.core.accounting.core.mappers.account.v1;

import com.firefly.core.accounting.intefaces.dtos.account.v1.GlAccountDTO;
import com.firefly.core.accounting.models.entities.account.v1.GlAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GlAccountMapper {
    GlAccountDTO toDTO (GlAccount entity);
    GlAccount toEntity (GlAccountDTO dto);
}