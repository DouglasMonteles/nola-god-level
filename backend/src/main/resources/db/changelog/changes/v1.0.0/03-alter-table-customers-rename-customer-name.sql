--liquibase formatted sql

--changeset douglasmonteles:03-alter-table-customers-rename-customer-name.sql
--comment: Correção dos tipos dos campos de latitude e longitude

ALTER TABLE customers
  RENAME COLUMN customer_name TO costumer_name;

-- rollback ALTER TABLE customers RENAME COLUMN costumer_name TO customer_name;
