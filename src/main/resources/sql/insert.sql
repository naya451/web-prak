SELECT *
from goods;

INSERT INTO sellers (seller_name, phone, email, address, seller_description)
VALUES ('H&M', '8 (925) 111 11 11', 'handm@gmail.com', 'New-York', 'clothes seller'),
       ('H&M home', '8 (925) 222 22 22', 'hmhome@outlook.com', 'Los Angeles', 'another clothes seller'),
       ('CROPP', '8 (925) 333 33 33', 'cropp@yandex.ru', 'Tver', 'one more clothes seller');

INSERT INTO supplies
VALUES (1, '2023-01-01', 1, 'from H&M', 'H&M'),
       (2, '2023-02-01', 2, 'from H&M home', 'H&M home'),
       (3, '2022-01-01', 3, 'from CROPP', 'CROPP'),
       (4, '2013-01-02', 1, 'from H&M', 'H&M'),
       (5, '2023-01-02', 2, 'from H&M home', 'H&M home'),
       (6, '2013-02-02', 3, 'from CROPP', 'CROPP'),
       (7, '2014-01-02', 1, 'from H&M', 'H&M'),
       (8, '2014-02-02', 2, 'from H&M home', 'H&M home'),
       (9, '2014-03-02', 3, 'from CROPP', 'CROPP'),
       (10, '2014-04-02', 1, 'from H&M', 'H&M'),
       (11, '2012-1-02', 1, 'from H&M', 'H&M');

INSERT INTO goods (good_name, good_type, good_size1, good_description, measurement)
VALUES ('jeans', 'clothes', 3, 'cool jeans', 'size'),
       ('brown jeans', 'for children', 35, 'tiny jeans', 'size'),
       ('chocolate', 'products', 100, 'tasty chocolate', 'gr');

INSERT INTO goods_in_supply
VALUES (1, 7, 1, 2),
       (2, 9, 2, 2),
       (3, 1, 2, 2),
       (4, 7, 2, 1);

INSERT INTO warehouse_condition
VALUES (1, 1, 1, 'clothes', false, 1),
       (2, 1, 2, 'for children', false, 2),
       (3, 3, 10, 'for children', false, 2),
       (4, 4, 6, 'products', true, NULL);

INSERT INTO buyers (buyer_name, phone)
VALUES ('Mike Smith', '8 (926) 111 11 11'),
       ('Tom Smith', '8 (926) 222 22 22'),
       ('Ally Mads', '8 (926) 333 33 33');

INSERT INTO deliveries
VALUES (1, '2023-01-02', 1, 'to mike', 'Mike Smith'),
       (2, '2023-02-02', 2, 'to Tom', 'Tom Smith'),
       (3, '2022-01-02', 3, 'to Ally', 'Ally Mads'),
       (4, '2013-01-03', 1, 'to mike', 'Mike Smith'),
       (5, '2023-01-03', 2, 'to Tom', 'Tom Smith'),
       (6, '2013-02-03', 3, 'to Ally', 'Ally Mads'),
       (7, '2014-01-03', 1, 'to mike', 'Mike Smith'),
       (8, '2014-02-03', 2, 'to Tom', 'Tom Smith'),
       (9, '2014-03-03', 3, 'to Ally', 'Ally Mads'),
       (10, '2014-04-03', 1, 'To mike', 'Mike Smith'),
       (11, '2012-1-03', 1, 'To mike', 'Mike Smith');

INSERT INTO goods_in_delivery
VALUES (1, 7, 1, 1),
       (2, 9, 2, 1),
       (3, 1, 2, 1),
       (4, 7, 2, 1);

SELECT *
from goods;

SELECT current_timestamp - interval '1 year';
SELECT * FROM Buyers;