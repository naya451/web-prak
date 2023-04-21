CREATE OR REPLACE FUNCTION name_checker() RETURNS TRIGGER AS
$seller_name_check$
begin
    update deliveries set Buyer_name = (select buyer_name from buyers where buyer_id = NEW.buyer_id);
    return NEW;
END;
$seller_name_check$ LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER check_name
    AFTER insert or update
        of Buyer_id
    on deliveries
    FOR EACH row
EXECUTE PROCEDURE name_checker();
