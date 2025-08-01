package com.catalis.core.accounting.web.controllers.journal.v1;

import com.catalis.common.core.filters.FilterRequest;
import com.catalis.common.core.queries.PaginationResponse;
import com.catalis.core.accounting.core.services.journal.v1.JournalLineService;
import com.catalis.core.accounting.intefaces.dtos.journal.v1.JournalLineDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/journal-batches/{batchId}/entries/{entryId}/lines")
@RequiredArgsConstructor
@Tag(name = "Journal Lines", description = "API for managing Journal Lines (nested under Journal Entries)")
public class JournalLineController {

    private final JournalLineService journalLineService;

    @Operation(summary = "Create a new Journal Line in a specific Entry")
    @ApiResponse(responseCode = "201", description = "Journal Line created")
    @PostMapping
    public Mono<ResponseEntity<JournalLineDTO>> create(@PathVariable("batchId") Long batchId,
                                                       @PathVariable("entryId") Long entryId,
                                                       @RequestBody JournalLineDTO dto) {
        return journalLineService.create(batchId, entryId, dto)
                .map(createdDto -> ResponseEntity.status(201).body(createdDto));
    }

    @Operation(summary = "Get a Journal Line by ID")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/{lineId}")
    public Mono<ResponseEntity<JournalLineDTO>> getById(@PathVariable("batchId") Long batchId,
                                                        @PathVariable("entryId") Long entryId,
                                                        @PathVariable("lineId") Long lineId) {
        return journalLineService.getById(batchId, entryId, lineId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update a Journal Line")
    @ApiResponse(responseCode = "200", description = "Line updated")
    @PutMapping("/{lineId}")
    public Mono<ResponseEntity<JournalLineDTO>> update(@PathVariable("batchId") Long batchId,
                                                       @PathVariable("entryId") Long entryId,
                                                       @PathVariable("lineId") Long lineId,
                                                       @RequestBody JournalLineDTO dto) {
        return journalLineService.update(batchId, entryId, lineId, dto)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a Journal Line")
    @ApiResponse(responseCode = "204", description = "Line deleted")
    @DeleteMapping("/{lineId}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("batchId") Long batchId,
                                             @PathVariable("entryId") Long entryId,
                                             @PathVariable("lineId") Long lineId) {
        return journalLineService.delete(batchId, entryId, lineId)
                .then(Mono.just(ResponseEntity.noContent().build()));
    }

    @Operation(summary = "Search/Filter Journal Lines")
    @ApiResponse(responseCode = "200", description = "OK")
    @GetMapping("/")
    public Mono<ResponseEntity<PaginationResponse<JournalLineDTO>>> search(@PathVariable("batchId") Long batchId,
                                                                           @PathVariable("entryId") Long entryId,
                                                                           @RequestBody FilterRequest<JournalLineDTO> filterRequest) {
        return journalLineService.search(batchId, entryId, filterRequest)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}