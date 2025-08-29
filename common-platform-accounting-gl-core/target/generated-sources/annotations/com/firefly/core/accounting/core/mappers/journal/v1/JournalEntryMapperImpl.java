package com.firefly.core.accounting.core.mappers.journal.v1;

import com.firefly.core.accounting.intefaces.dtos.journal.v1.JournalEntryDTO;
import com.firefly.core.accounting.models.entities.journal.v1.JournalEntry;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-29T20:18:08+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Homebrew)"
)
@Component
public class JournalEntryMapperImpl implements JournalEntryMapper {

    @Override
    public JournalEntryDTO toDTO(JournalEntry entity) {
        if ( entity == null ) {
            return null;
        }

        JournalEntryDTO.JournalEntryDTOBuilder journalEntryDTO = JournalEntryDTO.builder();

        journalEntryDTO.id( entity.getId() );
        journalEntryDTO.batchId( entity.getBatchId() );
        journalEntryDTO.transactionId( entity.getTransactionId() );
        journalEntryDTO.sourceModule( entity.getSourceModule() );
        journalEntryDTO.totalAmount( entity.getTotalAmount() );
        journalEntryDTO.description( entity.getDescription() );
        journalEntryDTO.entryDate( entity.getEntryDate() );
        journalEntryDTO.posted( entity.isPosted() );
        journalEntryDTO.createdBy( entity.getCreatedBy() );
        journalEntryDTO.createdAt( entity.getCreatedAt() );
        journalEntryDTO.updatedAt( entity.getUpdatedAt() );

        return journalEntryDTO.build();
    }

    @Override
    public JournalEntry toEntity(JournalEntryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        JournalEntry.JournalEntryBuilder journalEntry = JournalEntry.builder();

        journalEntry.id( dto.getId() );
        journalEntry.batchId( dto.getBatchId() );
        journalEntry.transactionId( dto.getTransactionId() );
        journalEntry.sourceModule( dto.getSourceModule() );
        journalEntry.totalAmount( dto.getTotalAmount() );
        journalEntry.description( dto.getDescription() );
        journalEntry.entryDate( dto.getEntryDate() );
        journalEntry.posted( dto.isPosted() );
        journalEntry.createdBy( dto.getCreatedBy() );
        journalEntry.createdAt( dto.getCreatedAt() );
        journalEntry.updatedAt( dto.getUpdatedAt() );

        return journalEntry.build();
    }
}
