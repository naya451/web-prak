CREATE OR REPLACE FUNCTION seller_name_check() RETURNS TRIGGER AS
$seller_name_check$
BEGIN
    update goods
    set availability =
            (select sum(good_amount)
             from goods_in_delivery
             where good_id = NEW.good_id
             group by goods.good_id)
    where Good_id = NEW.good_id;
END;
$seller_name_check$ LANGUAGE plpgsql;

CREATE TRIGGER seller_name_check
    AFTER insert or update
        of Good_amount
    on goods_in_delivery
    FOR EACH row
EXECUTE PROCEDURE seller_name_check();