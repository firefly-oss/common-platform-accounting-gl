package com.firefly.core.accounting.core.services.journal.v1;

import com.firefly.common.core.filters.FilterRequest;
import com.firefly.common.core.queries.PaginationResponse;
import com.firefly.core.accounting.intefaces.dtos.journal.v1.JournalBatchDTO;
import reactor.core.publisher.Mono;

public interface JournalBatchService {
    /**
     * Creates a new Journal Batch based on the provided details.
     *
     * @param dto the data transfer object containing the details for the Journal Batch to be created
     * @return a Mono emitting the created Journal Batch details wrapped in a JournalBatchDTO
     */
    Mono<JournalBatchDTO> create(JournalBatchDTO dto);
    /**
     * Retrieves a journal batch by its unique identifier.
     *
     * @param id the unique identifier of the journal batch to be retrieved
     * @return a Mono emitting a JournalBatchDTO representing the journal batch, or empty if not found
     */
    Mono<JournalBatchDTO> getById(Long id);
    /**
     * Updates an existing Journal Batch identified by the provided ID with the given details.
     *
     * @param id the unique identifier of the Journal Batch to update
     * @param dto the data transfer object containing the updated details of the Journal Batch
     * @return a Mono containing the updated Journal Batch data transfer object
     */
    Mono<JournalBatchDTO> update(Long id, JournalBatchDTO dto);
    /**
     * Deletes a journal batch by its unique identifier.
     *
     * @param id the unique identifier of the journal batch to be deleted
     * @return a reactive Mono signaling completion when the deletion operation has finished
     */
    Mono<Void> delete(Long id);
    /**
     * Searches for journal batches using the specified filtering criteria.
     *
     * @param filterRequest the filtering criteria and parameters for searching journal batches
     * @return a Mono emitting a paginated response containing a list of matching journal batch DTOs
     */
    Mono<PaginationResponse<JournalBatchDTO>> search(FilterRequest<JournalBatchDTO> filterRequest);
}
