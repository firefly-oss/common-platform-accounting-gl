package com.firefly.core.accounting.core.services.account.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.filters.FilterUtils;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.accounting.core.mappers.account.v1.GlAccountMapper;
import com.firefly.core.accounting.intefaces.dtos.account.v1.GlAccountDTO;
import com.firefly.core.accounting.models.entities.account.v1.GlAccount;
import com.firefly.core.accounting.models.repositories.account.v1.GlAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class GlAccountServiceImpl implements GlAccountService {

    @Autowired
    private GlAccountRepository repository;

    @Autowired
    private GlAccountMapper mapper;

    @Override
    public Mono<GlAccountDTO> create(GlAccountDTO dto) {
        return Mono.just(dto)
                .map(mapper::toEntity)
                .flatMap(repository::save)
                .map(mapper::toDTO);
    }

    @Override
    public Mono<GlAccountDTO> getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No account found with ID: " + id)));
    }

    @Override
    public Mono<GlAccountDTO> update(Long id, GlAccountDTO dto) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No account found with ID: " + id)))
                .flatMap(existingAccount -> {
                    GlAccount updatedEntity = mapper.toEntity(dto);
                    updatedEntity.setId(id);
                    return repository.save(updatedEntity);
                })
                .map(mapper::toDTO);
    }

    @Override
    public Mono<Void> delete(Long id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new IllegalArgumentException("No account found with ID: " + id)))
                .flatMap(existingAccount -> repository.delete(existingAccount));
    }

    @Override
    public Mono<PaginationResponse<GlAccountDTO>> search(FilterRequest<GlAccountDTO> filterRequest) {
        return FilterUtils
                .createFilter(
                        GlAccount.class,
                        mapper::toDTO
                )
                .filter(filterRequest);
    }

    @Override
    public Mono<PaginationResponse<GlAccountDTO>> findChildren(Long parentId, FilterRequest<GlAccountDTO> filterRequest) {
        filterRequest.getFilters().setParentId(parentId);
        return FilterUtils.createFilter(
                GlAccount.class,
                mapper::toDTO
        ).filter(filterRequest);
    }

    @Override
    public Mono<GlAccountDTO> createChild(Long parentId, GlAccountDTO dto) {
        dto.setParentId(parentId);
        return create(dto);
    }
}