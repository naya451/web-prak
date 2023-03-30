package ru.msu.cmc.webprak.DAO;

import lombok.Builder;
import lombok.Getter;
import ru.msu.cmc.webprak.models.Goods_in_supplies;

import java.util.List;

public interface Goods_in_suppliesDAO extends CommonDAO<Goods_in_supplies, Long> {

    List<Goods_in_supplies> getAllGoods_in_suppliesByName(String goodName);
    Goods_in_supplies getSingleGoodByName(String goodName);
    List<Goods_in_supplies> getByFilter(Filter filter);

    @Builder
    @Getter
    class Filter {
        private String name;
    }

    static Filter.FilterBuilder getFilterBuilder() {
        return Filter.builder();
    }
}