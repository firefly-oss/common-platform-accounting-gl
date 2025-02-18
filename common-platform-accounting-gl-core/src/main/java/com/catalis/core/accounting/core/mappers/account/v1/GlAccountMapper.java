package com.catalis.core.accounting.core.mappers.account.v1;

import com.catalis.core.accounting.intefaces.dtos.account.v1.GlAccountDTO;
import com.catalis.core.accounting.models.entities.account.v1.GlAccount;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GlAccountMapper {
    GlAccountDTO toDTO (GlAccount entity);
    GlAccount toEntity (GlAccountDTO dto);
}