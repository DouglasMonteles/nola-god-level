--liquibase formatted sql

--changeset douglasmonteles:02-alter-table-stores-fix-latitude-longitude
--comment: Correção dos tipos dos campos de latitude e longitude

ALTER TABLE stores
  ALTER COLUMN latitude TYPE NUMERIC(9,6),
  ALTER COLUMN longitude TYPE NUMERIC(9,6);

-- rollback ALTER TABLE stores ALTER COLUMN latitude DECIMAL(9,6);
-- rollback ALTER TABLE stores ALTER COLUMN longitude DECIMAL(9,6);
