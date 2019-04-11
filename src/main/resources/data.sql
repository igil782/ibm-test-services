INSERT INTO TYPE_CARD (ID_TYPE, DESCRIPTION) VALUES(1, 'CREDIT');
INSERT INTO GEO_CITY (ID_CITY, DESCRIPTION) VALUES(1, 'BOGOTA');
INSERT INTO GEO_CITY (ID_CITY, DESCRIPTION) VALUES(2, 'MEDELLIN');
INSERT INTO BANK_CARD (ID_CARD, NUMBER_CARD, CCV, ID_TYPE) VALUES (10001, '4929803982798420', '090', 1);
INSERT INTO BANK_CARD (ID_CARD, NUMBER_CARD, CCV, ID_TYPE) VALUES (10002, '4916969819650343', '997', 1);
INSERT INTO BANK_CARD (ID_CARD, NUMBER_CARD, CCV, ID_TYPE) VALUES (10003, '5226499133911421', '445', 1);
INSERT INTO BANK_CARD (ID_CARD, NUMBER_CARD, CCV, ID_TYPE) VALUES (10004, '5448981609269964', '709', 1);
INSERT INTO BANK_CUSTOMER (ID_CUSTOMER, NAME, ADDRESS, TELEPHONE) VALUES(10001, 'IVAN GIL', 'CLL 17 SUR 28 47', '+573045202163');
INSERT INTO BANK_CUSTOMER (ID_CUSTOMER, NAME, ADDRESS, TELEPHONE) VALUES(10002, 'JESUS GIL', 'CLL 17 SUR 28 48', '+573045202164');
INSERT INTO BANK_CUSTOMER (ID_CUSTOMER, NAME, ADDRESS, TELEPHONE) VALUES(10003, 'LYDA GIL', 'CLL 17 SUR 28 49', '+573045202165');
INSERT INTO BANK_CUSTOMER (ID_CUSTOMER, NAME, ADDRESS, TELEPHONE) VALUES(10004, 'STELLA GIL', 'CLL 17 SUR 28 50', '+573045202166');
INSERT INTO BANK_CUSTOMER (ID_CUSTOMER, NAME, ADDRESS, TELEPHONE) VALUES(10005, 'EDUARDO GIL', 'CLL 17 SUR 28 51', '+573045202167');
INSERT INTO BANK_CUSTOMER_CARD (ID_CARD, ID_CUSTOMER) VALUES (10001, 10001);
INSERT INTO BANK_CUSTOMER_CARD (ID_CARD, ID_CUSTOMER) VALUES (10003, 10001);
INSERT INTO BANK_CUSTOMER_CARD (ID_CARD, ID_CUSTOMER) VALUES (10002, 10002);
INSERT INTO BANK_CUSTOMER_CARD (ID_CARD, ID_CUSTOMER) VALUES (10004, 10003);
INSERT INTO BANK_CARD_MOVEMENT (ID_MOVEMENT, ID_CARD, DATE_MOVEMENT, DESCRIPTION, AMOUNT) VALUES (10001, 10001, CURRENT_TIMESTAMP(), 'CLARO 100', 900040.5 );
INSERT INTO BANK_CARD_MOVEMENT (ID_MOVEMENT, ID_CARD, DATE_MOVEMENT, DESCRIPTION, AMOUNT) VALUES (10002, 10001, CURRENT_TIMESTAMP(), 'OLIMPICA 56', 1900040.5 );
INSERT INTO BANK_CARD_MOVEMENT (ID_MOVEMENT, ID_CARD, DATE_MOVEMENT, DESCRIPTION, AMOUNT) VALUES (10003, 10002, CURRENT_TIMESTAMP(), 'FALABELLA 167', 2900040.5 );
INSERT INTO BANK_CARD_MOVEMENT (ID_MOVEMENT, ID_CARD, DATE_MOVEMENT, DESCRIPTION, AMOUNT) VALUES (10004, 10002, CURRENT_TIMESTAMP(), 'LOS HORNITOS', 90040.5 );