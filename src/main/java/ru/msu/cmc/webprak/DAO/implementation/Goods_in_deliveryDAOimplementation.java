package ru.msu.cmc.webprak.DAO.implementation;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Goods_in_deliveryDAO;
import ru.msu.cmc.webprak.models.Goods_in_delivery;

import java.util.List;

@Repository
public class Goods_in_deliveryDAOimplementation extends CommonDAOimplementation<Goods_in_delivery, Long> implements Goods_in_deliveryDAO {

    public Goods_in_deliveryDAOimplementation(){
        super(Goods_in_delivery.class);
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }

    @Override
    public List<Goods_in_delivery> getAllGoods_in_delivery() {
        return null;
    }
}
