package com.firefly.core.accounting.models.repositories.journal.v1;

import com.firefly.core.accounting.models.entities.journal.v1.JournalEntry;
import com.firefly.core.accounting.models.repositories.BaseRepository;
import java.util.UUID;

public interface JournalEntryRepository extends BaseRepository<JournalEntry, UUID> {
}