package com.firefly.core.accounting.core.mappers.journal.v1;

import com.firefly.core.accounting.intefaces.dtos.journal.v1.JournalLineDTO;
import com.firefly.core.accounting.models.entities.journal.v1.JournalLine;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-29T16:39:54+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Homebrew)"
)
@Component
public class JournalLineMapperImpl implements JournalLineMapper {

    @Override
    public JournalLineDTO toDTO(JournalLine entity) {
        if ( entity == null ) {
            return null;
        }

        JournalLineDTO.JournalLineDTOBuilder journalLineDTO = JournalLineDTO.builder();

        journalLineDTO.id( entity.getId() );
        journalLineDTO.entryId( entity.getEntryId() );
        journalLineDTO.accountId( entity.getAccountId() );
        journalLineDTO.amount( entity.getAmount() );
        journalLineDTO.drCr( entity.getDrCr() );
        journalLineDTO.memo( entity.getMemo() );
        journalLineDTO.fxCurrency( entity.getFxCurrency() );
        journalLineDTO.fxRate( entity.getFxRate() );
        journalLineDTO.createdBy( entity.getCreatedBy() );
        journalLineDTO.createdAt( entity.getCreatedAt() );
        journalLineDTO.updatedAt( entity.getUpdatedAt() );

        return journalLineDTO.build();
    }

    @Override
    public JournalLine toEntity(JournalLineDTO dto) {
        if ( dto == null ) {
            return null;
        }

        JournalLine.JournalLineBuilder journalLine = JournalLine.builder();

        journalLine.id( dto.getId() );
        journalLine.entryId( dto.getEntryId() );
        journalLine.accountId( dto.getAccountId() );
        journalLine.amount( dto.getAmount() );
        journalLine.drCr( dto.getDrCr() );
        journalLine.memo( dto.getMemo() );
        journalLine.fxCurrency( dto.getFxCurrency() );
        journalLine.fxRate( dto.getFxRate() );
        journalLine.createdBy( dto.getCreatedBy() );
        journalLine.createdAt( dto.getCreatedAt() );
        journalLine.updatedAt( dto.getUpdatedAt() );

        return journalLine.build();
    }
}
