package com.firefly.core.accounting.core.mappers.account.v1;

import com.firefly.core.accounting.intefaces.dtos.account.v1.GlAccountDTO;
import com.firefly.core.accounting.models.entities.account.v1.GlAccount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-29T16:39:54+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Homebrew)"
)
@Component
public class GlAccountMapperImpl implements GlAccountMapper {

    @Override
    public GlAccountDTO toDTO(GlAccount entity) {
        if ( entity == null ) {
            return null;
        }

        GlAccountDTO.GlAccountDTOBuilder glAccountDTO = GlAccountDTO.builder();

        glAccountDTO.id( entity.getId() );
        glAccountDTO.code( entity.getCode() );
        glAccountDTO.name( entity.getName() );
        glAccountDTO.type( entity.getType() );
        glAccountDTO.parentId( entity.getParentId() );
        glAccountDTO.active( entity.isActive() );
        glAccountDTO.currency( entity.getCurrency() );
        glAccountDTO.createdAt( entity.getCreatedAt() );
        glAccountDTO.updatedAt( entity.getUpdatedAt() );

        return glAccountDTO.build();
    }

    @Override
    public GlAccount toEntity(GlAccountDTO dto) {
        if ( dto == null ) {
            return null;
        }

        GlAccount.GlAccountBuilder glAccount = GlAccount.builder();

        glAccount.id( dto.getId() );
        glAccount.code( dto.getCode() );
        glAccount.name( dto.getName() );
        glAccount.type( dto.getType() );
        glAccount.parentId( dto.getParentId() );
        glAccount.active( dto.isActive() );
        glAccount.currency( dto.getCurrency() );
        glAccount.createdAt( dto.getCreatedAt() );
        glAccount.updatedAt( dto.getUpdatedAt() );

        return glAccount.build();
    }
}
