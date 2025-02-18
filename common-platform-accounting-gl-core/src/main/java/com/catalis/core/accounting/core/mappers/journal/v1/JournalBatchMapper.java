package com.catalis.core.accounting.core.mappers.journal.v1;

import com.catalis.core.accounting.intefaces.dtos.journal.v1.JournalBatchDTO;
import com.catalis.core.accounting.models.entities.journal.v1.JournalBatch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JournalBatchMapper {
    JournalBatchDTO toDTO (JournalBatch entity);
    JournalBatch toEntity (JournalBatchDTO dto);
}