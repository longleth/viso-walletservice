'#####################'
'  POSTGRES DATABASE  '
' database  : viso_db '
' schema    : public  '
' table     : wallet  '
'#####################'

'CREATE DATABASE viso_db;'
'CREATE USER postgres WITH PASSWORD postgres;'
'GRANT ALL PRIVILEGES ON DATABASE viso_db TO postgres;'

'##########################################'

CREATE TABLE wallet (
    wallet_id VARCHAR NOT NULL,
    address VARCHAR(200) NOT NULL,
    user_id VARCHAR NOT NULL,
    currency_id VARCHAR NOT NULL
);

'##########################################'