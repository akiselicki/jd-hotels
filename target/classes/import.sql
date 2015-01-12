insert into hotels(id, name, address, zip) values (1, 'Test Hotel 1', 'Test Street 1', '000001');
insert into hotels(id, name, address, zip) values (2, 'Test Hotel 2', 'Test Street 2', '000002');
insert into hotels(id, name, address, zip) values (3, 'Test Hotel 3', 'Test Street 3', '000003');
insert into hotels(id, name, address, zip) values (4, 'Test Hotel 4', 'Test Street 4', '000004');
insert into hotels(id, name, address, zip) values (5, 'Test Hotel 5', 'Test Street 5', '000005');
insert into hotels(id, name, address, zip) values (6, 'Test Hotel 6', 'Test Street 6', '000006');
insert into hotels(id, name, address, zip) values (7, 'Test Hotel 7', 'Test Street 7', '000007');
insert into hotels(id, name, address, zip) values (8, 'Test Hotel 8', 'Test Street 8', '000008');
insert into hotels(id, name, address, zip) values (9, 'Test Hotel 9', 'Test Street 9', '000009');
insert into hotels(id, name, address, zip) values (10, 'Test Hotel 10', 'Test Street 10', '000010');
insert into hotels(id, name, address, zip) values (11, 'Test Hotel 11', 'Test Street 11', '000011');
insert into hotels(id, name, address, zip) values (12, 'Test Hotel 12', 'Test Street 12', '000012');
insert into hotels(id, name, address, zip) values (13, 'Test Hotel 13', 'Test Street 13', '000013');
insert into hotels(id, name, address, zip) values (14, 'Test Hotel 14', 'Test Street 14', '000014');
insert into hotels(id, name, address, zip) values (15, 'Test Hotel 15', 'Test Street 15', '000015');
insert into hotels(id, name, address, zip) values (16, 'Test Hotel 16', 'Test Street 16', '000016');
insert into hotels(id, name, address, zip) values (17, 'Test Hotel 17', 'Test Street 17', '000017');
insert into hotels(id, name, address, zip) values (18, 'Test Hotel 18', 'Test Street 18', '000018');
insert into hotels(id, name, address, zip) values (19, 'Test Hotel 19', 'Test Street 19', '000019');
insert into hotels(id, name, address, zip) values (20, 'Test Hotel 20', 'Test Street 20', '000020');
insert into hotels(id, name, address, zip) values (21, 'Test Hotel 21', 'Test Street 21', '000021');
insert into hotels(id, name, address, zip) values (22, 'Test Hotel 22', 'Test Street 22', '000022');
insert into hotels(id, name, address, zip) values (23, 'Test Hotel 23', 'Test Street 23', '000023');
insert into hotels(id, name, address, zip) values (24, 'Test Hotel 24', 'Test Street 24', '000024');

insert into rooms(id, hotel_id, number, price, occupied) values (1, 1, '1', 1000000, false);
insert into rooms(id, hotel_id, number, price, occupied) values (2, 1, '2', 4500000, true);
insert into rooms(id, hotel_id, number, price, occupied) values (3, 1, '3', 1500000, false);
insert into rooms(id, hotel_id, number, price, occupied) values (4, 1, '4', 2000000, true);
insert into rooms(id, hotel_id, number, price, occupied) values (5, 2, '1', 500, true);
insert into rooms(id, hotel_id, number, price, occupied) values (6, 2, '2', 750, true);
insert into rooms(id, hotel_id, number, price, occupied) values (7, 2, '3', 350, false);
insert into rooms(id, hotel_id, number, price, occupied) values (8, 2, '4', 1000, false);
insert into rooms(id, hotel_id, number, price, occupied) values (9, 3, '1', 1200, true);
insert into rooms(id, hotel_id, number, price, occupied) values (10, 3, '2', 3000, true);
insert into rooms(id, hotel_id, number, price, occupied) values (11, 3, '3', 900, false);
insert into rooms(id, hotel_id, number, price, occupied) values (12, 4, '1', 450, true);

insert into users(username, password, enabled) values ('admin', 'admin', true);
insert into users(username, password, enabled) values ('user', 'user', false);

insert into authorities(username, authority) values ('admin', 'ADMIN');
insert into authorities(username, authority) values ('user', 'USER');


