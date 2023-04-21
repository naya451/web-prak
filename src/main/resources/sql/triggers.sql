CREATE OR REPLACE FUNCTION bound() RETURNS TRIGGER AS
$bound$
begin
    update deliveries set Buyer_name = (select buyer_name from buyers where buyer_id = NEW.buyer_id);
    return NEW;
END;
$bound$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER check_name
    AFTER insert or update
        of Buyer_id
    on deliveries
    FOR EACH row
EXECUTE PROCEDURE bound();

CREATE OR REPLACE FUNCTION getNumberYearsDeliveries(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM Deliveries
            WHERE Deliveries.delivery_id = id
              AND Deliveries.delivery_date_time >= current_timestamp - interval '1 year');
END;
$bound$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION getNumberDeliveries(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM Deliveries
            WHERE Deliveries.delivery_id = id);
END;
$bound$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION getNumberOfGoodsInDelivery(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM goods_in_delivery
            WHERE goods_in_delivery.delivery_id = id);
END;
$bound$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION getNumberOfGoodsInSupply(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM goods_in_supply
            WHERE goods_in_supply.supply_id = id);
END;
$bound$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION getAvailability(id INTEGER) RETURNS INTEGER AS
$bound$
begin
    return (SELECT COUNT(*)
            FROM warehouse_condition
            WHERE warehouse_condition.good_id = id);
END;
$bound$ LANGUAGE plpgsql;
