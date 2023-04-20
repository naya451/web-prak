CREATE OR REPLACE FUNCTION seller_name_check() RETURNS TRIGGER AS $seller_name_check$
BEGIN

END;
$seller_name_check$ LANGUAGE plpgsql;

CREATE TRIGGER seller_name_check
    AFTER INSERT OR UPDATE OR DELETE ON emp
    FOR EACH ROW EXECUTE PROCEDURE seller_name_check();