DROP TABLE IF EXISTS Sellers CASCADE;
CREATE TABLE Sellers (
                           Seller_ID SERIAL PRIMARY KEY,
                           Seller_name TEXT NOT NULL,
                           Phone TEXT,
                           Email TEXT,
                           Address TEXT,
                           Seller_description TEXT
);
DROP TABLE IF EXISTS Supplies CASCADE;
CREATE TABLE Supplies (
                            Supply_ID SERIAL PRIMARY KEY,
                            Supply_date DATE NOT NULL,
                            Supply_time TIME NOT NULL,
                            Seller_ID INTEGER NOT NULL REFERENCES Sellers(Seller_ID) ON DELETE CASCADE,
                            Supply_comment TEXT,
                            Sum_amount INTEGER NOT NULL CHECK (Sum_amount > 0),
                            Seller_name TEXT NOT NULL
);

DROP TABLE IF EXISTS Goods CASCADE;
CREATE TABLE Goods (
                         Good_ID SERIAL PRIMARY KEY,
                         Good_name TEXT NOT NULL,
                         Good_type TEXT CHECK (Good_type = 'products'
                                                   OR Good_type = 'clothes'
                                                   OR Good_type = 'devices'
                                                   OR Good_type = 'for children'
                                                   OR Good_type = 'for pets'),
                         Availability INTEGER NOT NULL CHECK (Availability >= 0),
                         Good_size1 INTEGER CHECK (Good_size1 > 0),
                         Good_size2 INTEGER CHECK (Good_size2 > 0),
                         Good_size3 INTEGER CHECK (Good_size3 > 0),
                         Time_of_keeping DATE,
                         Good_description TEXT,
                         Measurement TEXT NOT NULL
);
DROP TABLE IF EXISTS Goods_in_supplies CASCADE;
CREATE TABLE Goods_in_supplies (
                                     Position_ID SERIAL PRIMARY KEY,
                                     Supply_ID INTEGER NOT NULL REFERENCES Supplies(Supply_ID) ON DELETE CASCADE,
                                     Good_ID INTEGER NOT NULL REFERENCES Goods(Good_ID) ON DELETE CASCADE,
                                     Good_amount INTEGER NOT NULL CHECK (Good_amount > 0)
);
DROP TABLE IF EXISTS Warehouse_condition CASCADE;
CREATE TABLE Warehouse_condition (
                                       Place_ID SERIAL PRIMARY KEY,
                                       Room_ID INTEGER CHECK (Room_ID >= 0) NOT NULL ,
                                       Shelf_ID INTEGER CHECK (Shelf_ID >= 0) NOT NULL,
                                       Goods_type TEXT NOT NULL CHECK (Goods_type = 'products'
                                           OR Goods_type = 'clothes'
                                           OR Goods_type = 'devices'
                                           OR Goods_type = 'for children'
                                           OR Goods_type = 'for pets'),
                                       Shelf_availability bool,
                                       Good_ID INTEGER REFERENCES Goods(Good_ID) ON DELETE SET NULL
);
DROP TABLE IF EXISTS Buyers CASCADE;
CREATE TABLE Buyers (
                          Buyer_ID SERIAL PRIMARY KEY,
                          Buyer_name TEXT NOT NULL,
                          Phone TEXT,
                          Email TEXT,
                          Address TEXT,
                          Buyer_description TEXT
);
DROP TABLE IF EXISTS Deliveries CASCADE;
CREATE TABLE Deliveries (
                              Delivery_ID SERIAL PRIMARY KEY,
                              Delivery_date DATE NOT NULL,
                              Delivery_time TIME NOT NULL,
                              Buyer_ID INTEGER NOT NULL REFERENCES Buyers(Buyer_ID) ON DELETE CASCADE,
                              Delivery_comment TEXT,
                              Sum_amount INTEGER NOT NULL CHECK (Sum_amount > 0),
                              Buyer_name TEXT NOT NULL
);
DROP TABLE IF EXISTS Goods_in_delivery CASCADE;
CREATE TABLE Goods_in_delivery (
                                     Position_ID SERIAL PRIMARY KEY,
                                     Delivery_ID INTEGER NOT NULL REFERENCES Deliveries(Delivery_ID) ON DELETE CASCADE,
                                     Good_ID INTEGER NOT NULL REFERENCES Goods(Good_ID) ON DELETE CASCADE,
                                     Good_amount INTEGER NOT NULL
);
