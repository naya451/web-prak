package ru.msu.cmc.webprak.DAO.implementation;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.GoodsDAO;
import ru.msu.cmc.webprak.models.Goods;

import java.sql.Date;
import java.util.List;

@Repository
public class GoodsDAOimplementation extends CommonDAOimplementation<Goods, Long> implements GoodsDAO {

    public GoodsDAOimplementation(){
        super(Goods.class);
    }


    private String likeExpr(String param) {
        return "%" + param + "%";
    }

    @Override
    public List<Goods> getAllGoods(String name, String type, int amount, Date GoodToDate) {
        return null;
    }

    @Override
    public List<Goods> getAllGoodsSortedByName(int asc, String name, String type, int amount, Date GoodToDate) {
        return null;
    }

    @Override
    public List<Goods> getAllGoodsSortedByAmount(int asc, String name, String type, int amount, Date GoodToDate) {
        return null;
    }

    @Override
    public List<Goods> getAllGoodsSortedByGTDate(int asc, String name, String type, int amount, Date GoodToDate) {
        return null;
    }
}