package com.firefly.core.accounting.core.services.journal.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.filters.FilterUtils;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.accounting.core.mappers.journal.v1.JournalBatchMapper;
import com.firefly.core.accounting.intefaces.dtos.journal.v1.JournalBatchDTO;
import com.firefly.core.accounting.models.entities.journal.v1.JournalBatch;
import com.firefly.core.accounting.models.repositories.journal.v1.JournalBatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class JournalBatchServiceImpl implements JournalBatchService {

    @Autowired
    private JournalBatchRepository repository;

    @Autowired
    private JournalBatchMapper mapper;

    @Override
    public Mono<JournalBatchDTO> create(JournalBatchDTO dto) {
        return Mono.just(dto)
                .map(mapper::toEntity)
                .flatMap(repository::save)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<JournalBatchDTO> getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No journal batch found with ID: " + id)));
    }

    @Override
    public Mono<JournalBatchDTO> update(UUID id, JournalBatchDTO dto) {
        return repository.findById(id)
                .flatMap(existingEntity -> {
                    existingEntity.setReference(dto.getReference());
                    existingEntity.setStatus(dto.getStatus());
                    existingEntity.setBatchDate(dto.getBatchDate());
                    existingEntity.setRemarks(dto.getRemarks());
                    existingEntity.setUpdatedAt(LocalDateTime.now());
                    return repository.save(existingEntity);
                })
                .map(mapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No journal batch found with ID: " + id)));
    }

    @Override
    public Mono<Void> delete(UUID id) {
        return repository.findById(id)
                .flatMap(existingEntity -> repository.delete(existingEntity))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No journal batch found with ID: " + id)))
                .then();
    }

    @Override
    public Mono<PaginationResponse<JournalBatchDTO>> search(FilterRequest<JournalBatchDTO> filterRequest) {
        return FilterUtils.createFilter(
                JournalBatch.class,
                mapper::toDTO
        ).filter(filterRequest);
    }
}
