-- V1: Create Enums

CREATE TYPE gl_account_type AS ENUM (
    'ASSET',
    'LIABILITY',
    'INCOME',
    'EXPENSE',
    'EQUITY'
);

CREATE TYPE journal_batch_status AS ENUM (
    'OPEN',
    'POSTED',
    'CANCELLED',
    'REVERSED'
);

CREATE TYPE journal_line_dr_cr AS ENUM (
    'DR',
    'CR'
);