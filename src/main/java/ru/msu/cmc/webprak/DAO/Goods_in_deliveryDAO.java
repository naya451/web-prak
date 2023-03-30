package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Goods_in_delivery;

import java.util.List;

public interface Goods_in_deliveryDAO extends CommonDAO<Goods_in_delivery, Long> {

    List<Goods_in_delivery> getAllGoods_in_deliveryByName(String goodName);
    Goods_in_delivery getSingleGood_in_deliveryByName(String goodName);
    List<Goods_in_delivery> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private String name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}