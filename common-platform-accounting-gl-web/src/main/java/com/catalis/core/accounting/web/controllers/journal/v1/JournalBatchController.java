package com.catalis.core.accounting.web.controllers.journal.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.accounting.core.services.journal.v1.JournalBatchService;
import com.catalis.core.accounting.intefaces.dtos.journal.v1.JournalBatchDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/journal-batches")
@RequiredArgsConstructor
@Tag(name = "Journal Batches", description = "API for managing Journal Batches")
public class JournalBatchController {

    private final JournalBatchService journalBatchService;

    @Operation(summary = "Create a new Journal Batch")
    @ApiResponse(responseCode = "201", description = "Journal Batch created")
    @PostMapping
    public Mono<ResponseEntity<JournalBatchDTO>> create(@RequestBody JournalBatchDTO dto) {
        return journalBatchService.create(dto)
                .map(ResponseEntity::ok);
    }

    @Operation(summary = "Get a Journal Batch by ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{id}")
    public Mono<ResponseEntity<JournalBatchDTO>> getById(@PathVariable("id") Long id) {
        return journalBatchService.getById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update an existing Journal Batch")
    @ApiResponse(responseCode = "200", description = "Batch updated")
    @PutMapping("/{id}")
    public Mono<ResponseEntity<JournalBatchDTO>> update(@PathVariable("id") Long id,
                                                        @RequestBody JournalBatchDTO dto) {
        return journalBatchService.update(id, dto)
                .map(ResponseEntity::ok);
    }

    @Operation(summary = "Delete a Journal Batch")
    @ApiResponse(responseCode = "204", description = "Batch deleted")
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") Long id) {
        return journalBatchService.delete(id)
                .thenReturn(ResponseEntity.noContent().build());
    }

    @Operation(summary = "Search/Filter Journal Batches")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/")
    public Mono<ResponseEntity<PaginationResponse<JournalBatchDTO>>> search(
            @ParameterObject @ModelAttribute FilterRequest<JournalBatchDTO> filterRequest) {
        return journalBatchService.search(filterRequest)
                .map(ResponseEntity::ok);
    }
}
