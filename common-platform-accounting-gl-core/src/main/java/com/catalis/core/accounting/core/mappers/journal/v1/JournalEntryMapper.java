package com.catalis.core.accounting.core.mappers.journal.v1;

import com.catalis.core.accounting.intefaces.dtos.journal.v1.JournalEntryDTO;
import com.catalis.core.accounting.models.entities.journal.v1.JournalEntry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JournalEntryMapper {
    JournalEntryDTO toDTO (JournalEntry entity);
    JournalEntry toEntity (JournalEntryDTO dto);
}