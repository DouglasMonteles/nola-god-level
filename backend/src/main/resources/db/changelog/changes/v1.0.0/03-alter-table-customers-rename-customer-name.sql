--liquibase formatted sql

--changeset douglasmonteles:02-alter-table-stores-fix-latitude-longitude
--comment: Correção dos tipos dos campos de latitude e longitude

ALTER TABLE stores
  RENAME COLUMN customer_name TO costumer_name;
