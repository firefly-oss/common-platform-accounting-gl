package com.catalis.core.accounting.core.mappers.journal.v1;

import com.catalis.core.accounting.intefaces.dtos.journal.v1.JournalLineDTO;
import com.catalis.core.accounting.models.entities.journal.v1.JournalLine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JournalLineMapper {
    JournalLineDTO toDTO (JournalLine entity);
    JournalLine toEntity (JournalLineDTO dto);
}