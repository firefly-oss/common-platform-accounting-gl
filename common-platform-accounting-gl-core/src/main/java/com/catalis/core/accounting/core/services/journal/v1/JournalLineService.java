package com.catalis.core.accounting.core.services.journal.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.accounting.intefaces.dtos.journal.v1.JournalLineDTO;
import reactor.core.publisher.Mono;

public interface JournalLineService {

    /**
     * Creates a new journal line for the specified batch and entry.
     *
     * @param batchId the unique identifier of the batch to which the journal line belongs
     * @param entryId the unique identifier of the journal entry to which the journal line belongs
     * @param dto the data transfer object containing the details of the journal line to be created
     * @return a Mono emitting the created journal line details wrapped in a JournalLineDTO
     */
    Mono<JournalLineDTO> create(Long batchId, Long entryId, JournalLineDTO dto);

    /**
     * Retrieves a journal line identified by the specified batch ID, entry ID, and line ID.
     *
     * @param batchId the unique identifier of the journal batch to which the line belongs
     * @param entryId the unique identifier of the journal entry containing the line
     * @param lineId the unique identifier of the journal line to be retrieved
     * @return a Mono emitting the JournalLineDTO representing the journal line,
     *         or an empty Mono if no line is found
     */
    Mono<JournalLineDTO> getById(Long batchId, Long entryId, Long lineId);

    /**
     * Updates an existing journal line identified by the given batch ID, entry ID, and line ID
     * with the details provided in the JournalLineDTO object.
     *
     * @param batchId the unique identifier of the journal batch containing the journal entry
     * @param entryId the unique identifier of the journal entry containing the journal line
     * @param lineId the unique identifier of the journal line to be updated
     * @param dto the data transfer object containing the updated details for the journal line
     * @return a {@code Mono<JournalLineDTO>} that emits the updated journal line details upon successful update
     */
    Mono<JournalLineDTO> update(Long batchId, Long entryId, Long lineId, JournalLineDTO dto);

    /**
     * Deletes a specific journal line identified by its batch ID, entry ID, and line ID.
     *
     * @param batchId the identifier of the batch containing the journal line to be deleted
     * @param entryId the identifier of the entry containing the journal line to be deleted
     * @param lineId the identifier of the journal line to be deleted
     * @return a reactive Mono signaling completion when the deletion operation has finished
     */
    Mono<Void> delete(Long batchId, Long entryId, Long lineId);

    /**
     * Searches for journal lines within a specific batch and entry using the provided filter criteria.
     *
     * @param batchId the unique identifier of the journal batch containing the journal lines to be searched
     * @param entryId the unique identifier of the journal entry containing the journal lines to be searched
     * @param filterRequest the filtering criteria and parameters for searching journal lines
     * @return a Mono emitting a paginated response containing the list of matching journal line DTOs
     */
    Mono<PaginationResponse<JournalLineDTO>> search(Long batchId, Long entryId, FilterRequest<JournalLineDTO> filterRequest);
}
