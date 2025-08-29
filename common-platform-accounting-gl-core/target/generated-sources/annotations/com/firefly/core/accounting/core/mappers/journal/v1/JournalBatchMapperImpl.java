package com.firefly.core.accounting.core.mappers.journal.v1;

import com.firefly.core.accounting.intefaces.dtos.journal.v1.JournalBatchDTO;
import com.firefly.core.accounting.models.entities.journal.v1.JournalBatch;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-29T20:18:08+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Homebrew)"
)
@Component
public class JournalBatchMapperImpl implements JournalBatchMapper {

    @Override
    public JournalBatchDTO toDTO(JournalBatch entity) {
        if ( entity == null ) {
            return null;
        }

        JournalBatchDTO.JournalBatchDTOBuilder journalBatchDTO = JournalBatchDTO.builder();

        journalBatchDTO.id( entity.getId() );
        journalBatchDTO.reference( entity.getReference() );
        journalBatchDTO.status( entity.getStatus() );
        journalBatchDTO.batchDate( entity.getBatchDate() );
        journalBatchDTO.remarks( entity.getRemarks() );
        journalBatchDTO.createdAt( entity.getCreatedAt() );
        journalBatchDTO.updatedAt( entity.getUpdatedAt() );

        return journalBatchDTO.build();
    }

    @Override
    public JournalBatch toEntity(JournalBatchDTO dto) {
        if ( dto == null ) {
            return null;
        }

        JournalBatch.JournalBatchBuilder journalBatch = JournalBatch.builder();

        journalBatch.id( dto.getId() );
        journalBatch.reference( dto.getReference() );
        journalBatch.status( dto.getStatus() );
        journalBatch.batchDate( dto.getBatchDate() );
        journalBatch.remarks( dto.getRemarks() );
        journalBatch.createdAt( dto.getCreatedAt() );
        journalBatch.updatedAt( dto.getUpdatedAt() );

        return journalBatch.build();
    }
}
