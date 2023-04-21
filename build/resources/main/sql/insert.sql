SELECT *
from goods;

INSERT INTO sellers
VALUES (1, 'H&M', '8 (925) 111 11 11', 'handm@gmail.com', 'New-York', 'clothes seller'),
       (2, 'Zara', '8 (925) 222 22 22', 'zara@outlook.com', 'Los Angeles', 'another clothes seller'),
       (3, 'CROPP', '8 (925) 333 33 33', 'cropp@yandex.ru', 'Tver', 'one more clothes seller');

INSERT INTO supplies
VALUES (1, '2022-01-02 13:30', 1, 'from h&m', 'H&M'),
       (2, '2022-01-02 13:40', 2, 'from Zara', 'Zara'),
       (3, '2022-01-02 13:50', 3, 'from CROPP', 'CROPP'),
       (4, '2013-01-03 14:00', 1, 'from h&m', 'h&m'),
       (5, '2013-01-03 14:10', 2, 'from zara', 'Zara'),
       (6, '2013-01-03 14:20', 3, 'from CROPP', 'CROPP'),
       (7, '2014-01-03 15:00', 1, 'from h&m', 'h&m'),
       (8, '2014-01-03 15:10', 2, 'from zara', 'Zara'),
       (9, '2014-01-03 15:20', 3, 'from CROPP', 'CROPP');

INSERT INTO goods (good_id, good_name, good_type, good_size1, good_description, measurement)
VALUES (1, 'jeans', 'clothes', 3, 'cool jeans', 'size'),
       (2, 'boots', 'for children', 35, 'tiny boots', 'size'),
       (3, 'chocolate', 'products', 100, 'tasty chocolate', 'gr');

INSERT INTO goods_in_supply
VALUES (1, 1, 1, 5),
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
       (2, 'Tom John', '8 (926) 222 22 22'),
       (3, 'Ally Mads', '8 (926) 333 33 33');

INSERT INTO deliveries
VALUES (1, '2022-01-02 13:30', 1, 'to mike', 'Mike Smith'),
       (2, '2022-01-02 13:40', 2, 'to Tom', 'Tom John'),
       (3, '2022-01-02 13:50', 3, 'to Ally', 'Ally Mads'),
       (4, '2013-01-03 14:00', 1, 'to mike', 'Mike Smith'),
       (5, '2013-01-03 14:10', 2, 'to Tom', 'Tom John'),
       (6, '2013-01-03 14:20', 3, 'to Ally', 'Ally Mads'),
       (7, '2014-01-03 15:00', 1, 'to mike', 'Mike Smith'),
       (8, '2014-01-03 15:10', 2, 'to Tom', 'Tom John'),
       (9, '2014-01-03 15:20', 3, 'to Ally', 'Ally Mads');

INSERT INTO goods_in_delivery
VALUES (1, 1, 1, 5),
       (2, 9, 2, 10),
       (3, 1, 2, 4),
       (4, 7, 2, 8);

SELECT *
from goods;
