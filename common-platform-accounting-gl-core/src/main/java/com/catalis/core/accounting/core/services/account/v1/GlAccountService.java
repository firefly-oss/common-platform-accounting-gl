package com.catalis.core.accounting.core.services.account.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.accounting.intefaces.dtos.account.v1.GlAccountDTO;
import reactor.core.publisher.Mono;

public interface GlAccountService {
    /**
     * Creates a new General Ledger (GL) account based on the provided details.
     *
     * @param dto the data transfer object containing the details of the GL account to be created
     * @return a Mono emitting the created GL account details
     */
    Mono<GlAccountDTO> create(GlAccountDTO dto);

    /**
     * Retrieves a general ledger account by its unique identifier.
     *
     * @param id the unique identifier of the general ledger account to be retrieved
     * @return a Mono emitting a GlAccountDTO representing the general ledger account, or empty if not found
     */
    Mono<GlAccountDTO> getById(Long id);

    /**
     * Updates an existing General Ledger (GL) account identified by the provided ID with the given details.
     *
     * @param id The unique identifier of the GL account to update.
     * @param dto The data transfer object containing the updated details of the GL account.
     * @return A Mono containing the updated GL account data transfer object.
     */
    Mono<GlAccountDTO> update(Long id, GlAccountDTO dto);

    /**
     * Deletes a GL account by its unique identifier.
     *
     * @param id the unique identifier of the GL account to be deleted
     * @return a reactive Mono signaling completion when the deletion operation has finished
     */
    Mono<Void> delete(Long id);

    /**
     * Searches for GL accounts using the specified filter criteria.
     *
     * @param filterRequest the filtering criteria and parameters for searching GL accounts
     * @return a Mono emitting a paginated response containing the list of matching GL accounts
     */
    Mono<PaginationResponse<GlAccountDTO>> search(FilterRequest<GlAccountDTO> filterRequest);

    /**
     * Finds child General Ledger (GL) accounts under the specified parent GL account, applying the given filter criteria.
     *
     * @param parentId the ID of the parent GL account whose child accounts are to be retrieved
     * @param filterRequest the filter criteria to apply during the retrieval of child GL accounts
     * @return a reactive Mono containing a paginated response of GL account DTOs that represent the child accounts
     */
    Mono<PaginationResponse<GlAccountDTO>> findChildren(Long parentId, FilterRequest<GlAccountDTO> filterRequest);

    /**
     * Creates a child General Ledger (GL) account under a specified parent account.
     *
     * @param parentId the ID of the parent GL account under which the child account will be created
     * @param dto the data transfer object containing information about the child GL account to be created
     * @return a Mono emitting the created child GL account details wrapped in a GlAccountDTO
     */
    Mono<GlAccountDTO> createChild(Long parentId, GlAccountDTO dto);
}