-- V2: Create Tables (if not exists)

-- ========================================================================
-- TABLE: gl_account
-- ========================================================================
CREATE TABLE IF NOT EXISTS gl_account (
                                          id          BIGSERIAL                PRIMARY KEY,
                                          code        VARCHAR(50)             NOT NULL,
    name        VARCHAR(255)            NOT NULL,
    type        gl_account_type         NOT NULL,
    parent_id   BIGINT                  NULL,
    is_leaf     BOOLEAN                 NOT NULL DEFAULT FALSE,
    active      BOOLEAN                 NOT NULL DEFAULT TRUE,
    currency    VARCHAR(3)              NOT NULL, -- e.g., 'EUR', 'USD'
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_parent_account FOREIGN KEY (parent_id) REFERENCES gl_account(id)
    );

-- ========================================================================
-- TABLE: journal_batch
-- ========================================================================
CREATE TABLE IF NOT EXISTS journal_batch (
                                             id          BIGSERIAL                    PRIMARY KEY,
                                             reference   VARCHAR(50)                 NOT NULL,
    status      journal_batch_status        NOT NULL,
    batch_date  DATE                        NOT NULL,
    remarks     TEXT                        NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
    );

-- ========================================================================
-- TABLE: journal_entry
-- ========================================================================
CREATE TABLE IF NOT EXISTS journal_entry (
                                             id              BIGSERIAL                    PRIMARY KEY,
                                             batch_id        BIGINT                       NOT NULL,
                                             transaction_id  VARCHAR(255)                NULL,
    source_module   VARCHAR(255)                NULL,
    total_amount    DECIMAL(18,2)               NOT NULL,
    description     VARCHAR(255)                NULL,
    entry_date      TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    posted          BOOLEAN                     NOT NULL DEFAULT FALSE,
    created_by      VARCHAR(50)                 NULL,
    created_at      TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at      TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_journal_batch FOREIGN KEY (batch_id) REFERENCES journal_batch(id)
    );

-- ========================================================================
-- TABLE: journal_line
-- ========================================================================
CREATE TABLE IF NOT EXISTS journal_line (
                                            id           BIGSERIAL                    PRIMARY KEY,
                                            entry_id     BIGINT                       NOT NULL,
                                            account_id   BIGINT                       NOT NULL,
                                            amount       DECIMAL(18,2)               NOT NULL,
    dr_cr        journal_line_dr_cr          NOT NULL,
    memo         VARCHAR(255)                NULL,
    fx_currency  VARCHAR(3)                  NULL,
    fx_rate      DECIMAL(18,6)               NULL,
    created_by   VARCHAR(50)                 NULL,
    created_at   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_journal_entry FOREIGN KEY (entry_id) REFERENCES journal_entry(id),
    CONSTRAINT fk_gl_account   FOREIGN KEY (account_id) REFERENCES gl_account(id)
    );