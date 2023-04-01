package ru.msu.cmc.webprak.DAO.implementation;

import org.springframework.stereotype.Repository;
import ru.msu.cmc.webprak.DAO.DeliveriesDAO;
import ru.msu.cmc.webprak.models.Deliveries;

import java.sql.Date;
import java.util.List;

@Repository
public class DeliveriesDAOimplementation extends CommonDAOimplementation<Deliveries, Long> implements DeliveriesDAO {

    public DeliveriesDAOimplementation(){
        super(Deliveries.class);
    }

    private String likeExpr(String param) {
        return "%" + param + "%";
    }


    @Override
    public List<Deliveries> getAllDeliveries(Date deliveryDate, String buyer_name, int amount) {
        return null;
    }

    @Override
    public List<Deliveries> getAllDeliveriesSortedByDate(int asc, Date deliveryDate, String buyer_name, int amount) {
        return null;
    }

    @Override
    public List<Deliveries> getAllDeliveriesSortedByBName(int asc, Date deliveryDate, String buyer_name, int amount) {
        return null;
    }

    @Override
    public List<Deliveries> getAllDeliveriesSortedByAmount(int asc, Date deliveryDate, String buyer_name, int amount) {
        return null;
    }
}
