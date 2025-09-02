package com.firefly.core.accounting.models.repositories.journal.v1;

import com.firefly.core.accounting.models.entities.journal.v1.JournalLine;
import com.firefly.core.accounting.models.repositories.BaseRepository;
import java.util.UUID;

public interface JournalLineRepository extends BaseRepository<JournalLine, UUID> {
}