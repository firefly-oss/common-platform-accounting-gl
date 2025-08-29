package com.firefly.core.accounting.core.services.journal.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.filters.FilterUtils;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.accounting.core.mappers.journal.v1.JournalLineMapper;
import com.firefly.core.accounting.intefaces.dtos.journal.v1.JournalLineDTO;
import com.firefly.core.accounting.models.entities.journal.v1.JournalLine;
import com.firefly.core.accounting.models.repositories.journal.v1.JournalLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class JournalLineServiceImpl implements JournalLineService {

    @Autowired
    private JournalLineRepository repository;

    @Autowired
    private JournalLineMapper mapper;

    @Override
    public Mono<JournalLineDTO> create(Long batchId, Long entryId, JournalLineDTO dto) {
        return Mono.just(dto)
                .map(inputDto -> {
                    inputDto.setEntryId(entryId);
                    return mapper.toEntity(inputDto);
                })
                .flatMap(entity -> repository.save(entity))
                .map(savedEntity -> mapper.toDTO(savedEntity));
    }

    @Override
    public Mono<JournalLineDTO> getById(Long batchId, Long entryId, Long lineId) {
        return repository.findById(lineId)
                .filter(entity -> entity.getEntryId().equals(entryId))
                .map(mapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No journal line found with ID: " + lineId)));
    }

    @Override
    public Mono<JournalLineDTO> update(Long batchId, Long entryId, Long lineId, JournalLineDTO dto) {
        return repository.findById(lineId)
                .filter(entity -> entity.getEntryId().equals(entryId))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No journal line found with ID: " + lineId)))
                .flatMap(existingEntity -> {
                    existingEntity.setAccountId(dto.getAccountId());
                    existingEntity.setAmount(dto.getAmount());
                    existingEntity.setDrCr(dto.getDrCr());
                    existingEntity.setMemo(dto.getMemo());
                    existingEntity.setFxCurrency(dto.getFxCurrency());
                    existingEntity.setFxRate(dto.getFxRate());
                    existingEntity.setUpdatedAt(dto.getUpdatedAt());
                    return repository.save(existingEntity);
                })
                .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(Long batchId, Long entryId, Long lineId) {
        return repository.findById(lineId)
                .filter(entity -> entity.getEntryId().equals(entryId))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No journal line found with ID: " + lineId)))
                .flatMap(repository::delete);
    }

    @Override
    public Mono<PaginationResponse<JournalLineDTO>> search(Long batchId, Long entryId, FilterRequest<JournalLineDTO> filterRequest) {
        filterRequest.getFilters().setEntryId(entryId);
        return FilterUtils.createFilter(
                JournalLine.class,
                mapper::toDTO
        ).filter(filterRequest);
    }
}
