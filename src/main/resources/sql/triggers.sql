CREATE OR REPLACE FUNCTION getnumberyearsdeliveries(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM Deliveries
            WHERE Deliveries.buyer_id = id
              AND Deliveries.delivery_date_time >= current_timestamp - interval '1 year');
END;
$bound$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION getnumberyearssupplies(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM Supplies
            WHERE Supplies.seller_id = id
              AND Supplies.supply_date_time >= current_timestamp - interval '1 year');
END;
$bound$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION getdeliveriesnumber(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM Deliveries
            WHERE Deliveries.buyer_id = id);
END;
$bound$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION getnumbersupplies(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM Supplies
            WHERE Supplies.seller_id = id);
END;
$bound$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION getnumberofgoodsindelivery(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM goods_in_delivery
            WHERE goods_in_delivery.delivery_id = id);
END;
$bound$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION getnumberofgoodsinsupply(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM goods_in_supply
            WHERE goods_in_supply.supply_id = id);
END;
$bound$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION getavailability(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM warehouse_condition
            WHERE warehouse_condition.good_id = id);
END;
$bound$ LANGUAGE plpgsql;
