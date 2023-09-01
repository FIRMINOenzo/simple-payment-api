INSERT INTO user_types(typ_description) VALUES('Common'), ('Merchandiser');

INSERT INTO users(use_first_name, use_last_name, use_email, use_password, use_document, use_balance, use_type_id) VALUES('Enzo', 'Campanari', 'test@test.com', '1234', '12312312312', 150.50, 1), ('Pedro', 'Cavalo', 'test2@test.com', '123456', '12345678909', 130.50, 2);

INSERT INTO transfers(tra_sender_id, tra_amount, tra_receiver_id) VALUES(1, 12.30, 2);
INSERT INTO transfers(tra_sender_id, tra_amount, tra_receiver_id) VALUES(1, 1.30, 2);
INSERT INTO transfers(tra_sender_id, tra_amount, tra_receiver_id) VALUES(1, 2.30, 2);
INSERT INTO transfers(tra_sender_id, tra_amount, tra_receiver_id) VALUES(1, 12.0, 2);
INSERT INTO transfers(tra_sender_id, tra_amount, tra_receiver_id) VALUES(1, 122.30, 2);
INSERT INTO transfers(tra_sender_id, tra_amount, tra_receiver_id) VALUES(1, 1.60, 2);