package com.catalis.core.accounting.web.controllers.journal.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.accounting.core.services.journal.v1.JournalEntryService;
import com.catalis.core.accounting.intefaces.dtos.journal.v1.JournalEntryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/journal-batches/{batchId}/entries")
@RequiredArgsConstructor
@Tag(name = "Journal Entries", description = "API for managing Journal Entries (nested under Journal Batches)")
public class JournalEntryController {

    private final JournalEntryService journalEntryService;

    @Operation(summary = "Create a new Journal Entry in a specific Batch")
    @ApiResponse(responseCode = "201", description = "Journal Entry created")
    @PostMapping
    public Mono<ResponseEntity<JournalEntryDTO>> create(@PathVariable("batchId") Long batchId,
                                                        @RequestBody JournalEntryDTO dto) {
        return journalEntryService.create(batchId, dto)
                .map(entry -> ResponseEntity.status(201).body(entry));
    }

    @Operation(summary = "Get a Journal Entry by ID within a Batch")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{entryId}")
    public Mono<ResponseEntity<JournalEntryDTO>> getById(@PathVariable("batchId") Long batchId,
                                                         @PathVariable("entryId") Long entryId) {
        return journalEntryService.getById(batchId, entryId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update a Journal Entry within a Batch")
    @ApiResponse(responseCode = "200", description = "Entry updated")
    @PutMapping("/{entryId}")
    public Mono<ResponseEntity<JournalEntryDTO>> update(@PathVariable("batchId") Long batchId,
                                                        @PathVariable("entryId") Long entryId,
                                                        @RequestBody JournalEntryDTO dto) {
        return journalEntryService.update(batchId, entryId, dto)
                .map(ResponseEntity::ok);
    }

    @Operation(summary = "Delete a Journal Entry within a Batch")
    @ApiResponse(responseCode = "204", description = "Entry deleted")
    @DeleteMapping("/{entryId}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("batchId") Long batchId,
                                             @PathVariable("entryId") Long entryId) {
        return journalEntryService.delete(batchId, entryId)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    @Operation(summary = "Search/Filter Journal Entries within a Batch")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/")
    public Mono<ResponseEntity<PaginationResponse<JournalEntryDTO>>> search(
            @PathVariable("batchId") Long batchId,
            @ParameterObject @ModelAttribute FilterRequest<JournalEntryDTO> filterRequest) {
        return journalEntryService.search(batchId, filterRequest)
                .map(ResponseEntity::ok);
    }
}