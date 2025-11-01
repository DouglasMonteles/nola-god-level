--liquibase formatted sql

--changeset liquibase:init-master
--comment: Master changelog file

--include file:db/changelog/changes/v1.0.0/01-create-initial-database.sql
--include file:db/changelog/changes/v1.0.0/02-alter-table-stores-fix-latitude-longitude.sql
--include file:db/changelog/changes/v1.0.0/03-alter-table-customers-rename-customer-name.sql