package com.firefly.core.accounting.core.services.journal.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.filters.FilterUtils;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.accounting.core.mappers.journal.v1.JournalEntryMapper;
import com.firefly.core.accounting.intefaces.dtos.journal.v1.JournalEntryDTO;
import com.firefly.core.accounting.models.entities.journal.v1.JournalEntry;
import com.firefly.core.accounting.models.repositories.journal.v1.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import java.util.UUID;

@Service
@Transactional
public class JournalEntryServiceImpl implements JournalEntryService {

    @Autowired
    private JournalEntryRepository repository;

    @Autowired
    private JournalEntryMapper mapper;

    @Override
    public Mono<JournalEntryDTO> create(UUID batchId, JournalEntryDTO dto) {
        dto.setBatchId(batchId);
        return repository.save(mapper.toEntity(dto))
                .map(mapper::toDTO);
    }

    @Override
    public Mono<JournalEntryDTO> getById(UUID batchId, UUID entryId) {
        return repository.findById(entryId)
                .filter(entity -> entity.getBatchId().equals(batchId))
                .map(mapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No journal entry found with ID: " + entryId)));
    }

    @Override
    public Mono<JournalEntryDTO> update(UUID batchId, UUID entryId, JournalEntryDTO dto) {
        return repository.findById(entryId)
                .filter(entity -> entity.getBatchId().equals(batchId))
                .flatMap(existingEntity -> {
                    JournalEntry updatedEntity = mapper.toEntity(dto);
                    updatedEntity.setId(existingEntity.getId());
                    updatedEntity.setBatchId(existingEntity.getBatchId());
                    return repository.save(updatedEntity);
                })
                .map(mapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No journal entry found with ID: " + entryId)));
    }

    @Override
    public Mono<Void> delete(UUID batchId, UUID entryId) {
        return repository.findById(entryId)
                .filter(entity -> entity.getBatchId().equals(batchId))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No journal entry found with ID: " + entryId)))
                .flatMap(repository::delete);
    }

    @Override
    public Mono<PaginationResponse<JournalEntryDTO>> search(UUID batchId, FilterRequest<JournalEntryDTO> filterRequest) {
        return FilterUtils.createFilter(
                JournalEntry.class,
                mapper::toDTO
        ).filter(filterRequest);
    }
}