SELECT *
from goods;

INSERT INTO sellers
VALUES (1, 'H&M', '8 (925) 111 11 11', 'handm@gmail.com', 'New-York', 'clothes seller'),
       (2, 'H&M home', '8 (925) 222 22 22', 'hmhome@outlook.com', 'Los Angeles', 'another clothes seller'),
       (3, 'CROPP', '8 (925) 333 33 33', 'cropp@yandex.ru', 'Tver', 'one more clothes seller');

INSERT INTO supplies
VALUES (1, '2023-01-01', 1, 'from H&M', 'H&M'),
       (2, '2023-02-01', 2, 'from H&M home', 'H&M homeh'),
       (3, '2022-01-01', 3, 'from CROPP', 'CROPP'),
       (4, '2013-01-02', 1, 'from H&M', 'H&M'),
       (5, '2023-01-02', 2, 'from H&M home', 'H&M home'),
       (6, '2013-02-02', 3, 'from CROPP', 'CROPP'),
       (7, '2014-01-02', 1, 'from H&M', 'H&M'),
       (8, '2014-02-02', 2, 'from H&M home', 'H&M homeh'),
       (9, '2014-03-02', 3, 'from CROPP', 'CROPP'),
       (10, '2014-04-02', 1, 'from H&M', 'H&M'),
       (11, '2012-1-02', 1, 'from H&M', 'H&M');

INSERT INTO goods (good_id, good_name, good_type, good_size1, good_description, measurement)
VALUES (1, 'jeans', 'clothes', 3, 'cool jeans', 'size'),
       (2, 'boots', 'for children', 35, 'tiny boots', 'size'),
       (3, 'chocolate', 'products', 100, 'tasty chocolate', 'gr');

INSERT INTO goods_in_supply
VALUES (1, 7, 1, 5),
       (2, 9, 2, 10),
       (3, 1, 2, 4),
       (4, 7, 2, 8);

INSERT INTO warehouse_condition
VALUES (1, 1, 1, 'clothes', false, 1),
       (2, 1, 2, 'for children', false, 2),
       (3, 3, 10, 'products', false, 3),
       (4, 4, 6, 'for children', true, NULL);

INSERT INTO buyers (buyer_id, buyer_name, phone)
VALUES (1, 'Mike Smith', '8 (926) 111 11 11'),
       (2, 'Tom Smith', '8 (926) 222 22 22'),
       (3, 'Ally Mads', '8 (926) 333 33 33');

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
VALUES (1, 7, 1, 5),
       (2, 9, 2, 10),
       (3, 1, 2, 4),
       (4, 7, 2, 8);

SELECT *
from goods;

SELECT current_timestamp - interval '1 year';
SELECT * FROM Goods_in_supply WHERE supply_id = 7;