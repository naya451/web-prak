DROP TABLE IF EXISTS Sellers CASCADE;
CREATE TABLE Sellers (
                           Seller_ID INT,
                           Seller_name text,
                           Phone text,
                           Email text,
                           Address text,
                           Seller_description text,
                           PRIMARY KEY (Seller_ID)
);
DROP TABLE IF EXISTS Supplies CASCADE;
CREATE TABLE Supplies (
                            Supply_ID INT,
                            Supply_date date,
                            Supply_time time,
                            Seller_ID INT,
                            Supply_comment text,
                            Sum_amount INT,
                            Seller_name text,
                            PRIMARY KEY (Supply_ID),
                            CONSTRAINT "FK_Supplies.Seller_ID"
                                FOREIGN KEY (Seller_ID)
                                    REFERENCES Sellers(Seller_ID)
);
DROP TABLE IF EXISTS Goods CASCADE;
CREATE TABLE Goods (
                         Good_ID INT,
                         Good_name text,
                         Good_type text,
                         Availability INT,
                         Good_size INT[3],
                         Time_of_keeping date,
                         Good_description text,
                         Measurement text,
                         PRIMARY KEY (Good_ID)
);
DROP TABLE IF EXISTS Goods_in_supplies CASCADE;
CREATE TABLE Goods_in_supplies (
                                     Supply_ID INT,
                                     Good_ID INT,
                                     Good_amount INT,
                                     PRIMARY KEY (Supply_ID, Good_ID),
                                     CONSTRAINT "FK_Goods_in_supplies.Supply_ID"
                                         FOREIGN KEY (Supply_ID)
                                             REFERENCES Supplies(Supply_ID),
                                     CONSTRAINT "FK_Goods_in_supplies.Good_ID"
                                         FOREIGN KEY (Good_ID)
                                             REFERENCES Goods(Good_ID)
);
DROP TABLE IF EXISTS Waehouse CASCADE;
CREATE TABLE Warehouse_condition (
                                       Place_ID INT,
                                       Room_ID INT,
                                       Shelf_ID INT,
                                       Goods_type text,
                                       Shelf_availability bool,
                                       Good_ID INT,
                                       PRIMARY KEY (Place_ID),
                                       CONSTRAINT "FK_Warehouse_condition.Good_ID"
                                           FOREIGN KEY (Good_ID)
                                               REFERENCES Goods(Good_ID)
);
DROP TABLE IF EXISTS Buyers CASCADE;
CREATE TABLE Buyers (
                          Buyer_ID INT,
                          Buyer_name text,
                          Phone text,
                          Email text,
                          Address text,
                          Buyer_description text,
                          PRIMARY KEY (Buyer_ID)
);
DROP TABLE IF EXISTS Deliveries CASCADE;
CREATE TABLE Deliveries (
                              Delivery_ID INT,
                              Delivery_date date,
                              Delivery_time time,
                              Buyer_ID INT,
                              Delivery_comment text,
                              Sum_amount INT,
                              Buyer_name text,
                              PRIMARY KEY (Delivery_ID),
                              CONSTRAINT "FK_Deliveries.Buyer_ID"
                                  FOREIGN KEY (Buyer_ID)
                                      REFERENCES Buyers(Buyer_ID)
);
DROP TABLE IF EXISTS Goods_in_delivery CASCADE;
CREATE TABLE Goods_in_delivery (
                                     Delivery_ID INT,
                                     Good_ID INT,
                                     Good_amount INT,
                                     PRIMARY KEY (Delivery_ID, Good_ID),
                                     CONSTRAINT "FK_Goods_in_delivery.Delivery_ID"
                                         FOREIGN KEY (Delivery_ID)
                                             REFERENCES Deliveries(Delivery_ID),
                                     CONSTRAINT "FK_Goods_in_delivery.Good_ID"
                                         FOREIGN KEY (Good_ID)
                                             REFERENCES Goods(Good_ID)
);

