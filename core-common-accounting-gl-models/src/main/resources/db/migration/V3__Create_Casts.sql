-- V3__create_casts.sql

-------------------------
-- gl_account_type
-------------------------
CREATE CAST (varchar AS gl_account_type)
    WITH INOUT
    AS IMPLICIT;

-------------------------
-- journal_batch_status
-------------------------
CREATE CAST (varchar AS journal_batch_status)
    WITH INOUT
    AS IMPLICIT;

-------------------------
-- journal_line_dr_cr
-------------------------
CREATE CAST (varchar AS journal_line_dr_cr)
    WITH INOUT
    AS IMPLICIT;