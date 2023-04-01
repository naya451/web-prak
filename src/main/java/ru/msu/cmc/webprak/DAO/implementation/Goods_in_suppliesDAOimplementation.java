package ru.msu.cmc.webprak.DAO.implementation;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.Goods_in_suppliesDAO;
import ru.msu.cmc.webprak.models.Goods_in_supplies;

import java.util.List;

@Repository
public class Goods_in_suppliesDAOimplementation extends CommonDAOimplementation<Goods_in_supplies, Long> implements Goods_in_suppliesDAO {

    public Goods_in_suppliesDAOimplementation(){
        super(Goods_in_supplies.class);
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }

    @Override
    public List<Goods_in_supplies> getAllGoods_in_supplies() {
        return null;
    }
}

