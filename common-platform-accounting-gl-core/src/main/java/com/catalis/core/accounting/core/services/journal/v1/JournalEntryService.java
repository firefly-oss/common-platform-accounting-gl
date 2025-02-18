package com.catalis.core.accounting.core.services.journal.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.accounting.intefaces.dtos.journal.v1.JournalEntryDTO;
import reactor.core.publisher.Mono;

public interface JournalEntryService {
    /**
     * Creates a new journal entry for the specified batch.
     *
     * @param batchId the unique identifier of the batch to which the journal entry belongs
     * @param dto the data transfer object containing the details of the journal entry to be created
     * @return a Mono emitting the created journal entry details wrapped in a JournalEntryDTO
     */
    Mono<JournalEntryDTO> create(Long batchId, JournalEntryDTO dto);
    /**
     * Retrieves a journal entry identified by the specified batch ID and entry ID.
     *
     * @param batchId the unique identifier of the journal batch
     * @param entryId the unique identifier of the journal entry within the batch
     * @return a Mono emitting the JournalEntryDTO representing the journal entry,
     *         or an empty Mono if no entry is found
     */
    Mono<JournalEntryDTO> getById(Long batchId, Long entryId);
    /**
     * Updates an existing journal entry identified by the given batch ID and entry ID with the provided details.
     *
     * @param batchId the unique identifier of the batch containing the journal entry to be updated
     * @param entryId the unique identifier of the journal entry to be updated
     * @param dto the data transfer object containing the updated details of the journal entry
     * @return a Mono that emits the updated JournalEntryDTO upon successful update
     */
    Mono<JournalEntryDTO> update(Long batchId, Long entryId, JournalEntryDTO dto);
    /**
     * Deletes a specific journal entry identified by its batch ID and entry ID.
     *
     * @param batchId the identifier of the batch containing the journal entry to be deleted
     * @param entryId the identifier of the journal entry to be deleted
     * @return a reactive Mono signaling completion when the deletion operation has finished
     */
    Mono<Void> delete(Long batchId, Long entryId);
    /**
     * Searches for journal entries within a specific batch using the provided filter criteria.
     *
     * @param batchId the unique identifier of the batch containing the journal entries to be searched
     * @param filterRequest the filtering criteria and parameters for searching journal entries
     * @return a Mono emitting a paginated response containing the list of matching journal entry DTOs
     */
    Mono<PaginationResponse<JournalEntryDTO>> search(Long batchId, FilterRequest<JournalEntryDTO> filterRequest);
}
