DROP TABLE IF EXISTS sellers CASCADE;
CREATE TABLE sellers
(
    seller_id          SERIAL PRIMARY KEY,
    seller_name        TEXT NOT NULL,
    phone              TEXT,
    email              TEXT,
    address            TEXT,
    seller_description TEXT
);
DROP TABLE IF EXISTS supplies CASCADE;
CREATE TABLE supplies
(
    supply_id        SERIAL PRIMARY KEY,
    supply_date_time DATE    NOT NULL,
    seller_id        INTEGER NOT NULL REFERENCES sellers (seller_id) ON DELETE CASCADE,
    supply_comment   TEXT,
    sum_amount       INTEGER NOT NULL CHECK (sum_amount > 0),
    seller_name      TEXT    NOT NULL
);
DROP TABLE IF EXISTS goods CASCADE;
CREATE TABLE goods
(
    good_id          SERIAL PRIMARY KEY,
    good_name        TEXT    NOT NULL,
    good_type        TEXT CHECK (good_type = 'products'
        OR good_type = 'clothes'
        OR good_type = 'devices'
        OR good_type = 'for children'
        OR good_type = 'for pets'),
    availability     INTEGER NOT NULL CHECK (availability >= 0),
    good_size1       INTEGER CHECK (good_size1 > 0),
    good_size2       INTEGER CHECK (good_size2 > 0),
    good_size3       INTEGER CHECK (good_size3 > 0),
    time_of_keeping  DATE,
    good_description TEXT,
    measurement      TEXT    NOT NULL
);
DROP TABLE IF EXISTS goods_in_supplies CASCADE;
DROP TABLE IF EXISTS goods_in_supply CASCADE;
CREATE TABLE goods_in_supply
(
    position_id SERIAL PRIMARY KEY,
    supply_id   INTEGER NOT NULL REFERENCES supplies (supply_id) ON DELETE CASCADE,
    good_id     INTEGER NOT NULL REFERENCES goods (good_id) ON DELETE CASCADE,
    good_amount INTEGER NOT NULL CHECK (good_amount > 0)
);
DROP TABLE IF EXISTS warehouse_condition CASCADE;
CREATE TABLE warehouse_condition
(
    place_id           SERIAL PRIMARY KEY,
    room_id            INTEGER CHECK (room_id >= 0 AND room_id <= 512)  NOT NULL,
    shelf_id           INTEGER CHECK (shelf_id >= 0 AND shelf_id <= 64) NOT NULL,
    goods_type         TEXT                                             NOT NULL CHECK (goods_type = 'products'
        OR goods_type = 'clothes'
        OR goods_type = 'devices'
        OR goods_type = 'for children'
        OR goods_type = 'for pets'),
    shelf_availability bool,
    good_id            INTEGER                                          REFERENCES goods (good_id) ON DELETE SET NULL
);
DROP TABLE IF EXISTS buyers CASCADE;
CREATE TABLE buyers
(
    buyer_id          SERIAL PRIMARY KEY,
    buyer_name        TEXT NOT NULL,
    phone             TEXT,
    email             TEXT,
    address           TEXT,
    buyer_description TEXT
);
DROP TABLE IF EXISTS deliveries CASCADE;
CREATE TABLE deliveries
(
    delivery_id        SERIAL PRIMARY KEY,
    delivery_date_time DATE    NOT NULL,
    buyer_id           INTEGER NOT NULL REFERENCES buyers (buyer_id) ON DELETE CASCADE,
    delivery_comment   TEXT,
    sum_amount         INTEGER NOT NULL CHECK (sum_amount > 0),
    buyer_name         TEXT    NOT NULL
);
DROP TABLE IF EXISTS goods_in_delivery CASCADE;
CREATE TABLE goods_in_delivery
(
    position_id SERIAL PRIMARY KEY,
    delivery_id INTEGER NOT NULL REFERENCES deliveries (delivery_id) ON DELETE CASCADE,
    good_id     INTEGER NOT NULL REFERENCES goods (good_id) ON DELETE CASCADE,
    good_amount INTEGER NOT NULL
);
