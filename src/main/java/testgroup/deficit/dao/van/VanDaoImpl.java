package testgroup.deficit.dao.van;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.deficit.model.Van;
import testgroup.deficit.model.VanTablePost;

import java.util.List;

@Repository
public class VanDaoImpl implements VanDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Van van) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(van);
    }

    @Override
    public void delete(Van van) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(van);
    }

    @Override
    public void edit(Van van) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(van);
    }

    @Override
    public Van getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Van.class, id);
    }

    @Override
    public int queryVanCount(VanTablePost vanTablePost) {
        Session session = sessionFactory.getCurrentSession();
        String stringQuery = getStringQuery(vanTablePost);
        return session.createQuery("SELECT COUNT(*) FROM Van " + stringQuery, Number.class).getSingleResult().intValue();
    }

    @Override
    public List<Van> queryVanList(VanTablePost vanTablePost, int page, int maxPage) {
        Session session = sessionFactory.getCurrentSession();
        String stringQuery = getStringQuery(vanTablePost);
        return session.createQuery("FROM Van " + stringQuery, Van.class).setFirstResult(maxPage * (page - 1)).setMaxResults(maxPage).list();
    }

    private String getStringQuery(VanTablePost vanTablePost) {
        StringBuilder stringQuery = new StringBuilder();
        String substance = vanTablePost.getSubstance();
        String typeList = vanTablePost.getTypeList();
        String year = vanTablePost.getYear();
        String month = vanTablePost.getMonth();
        String dateFrom = vanTablePost.getDateFrom();
        String dateTo = vanTablePost.getDateTo();
        if (substance.equals("All")) {
            switch (typeList) {
                case "1" -> stringQuery
                        .append("WHERE year(DateOfArrival) = ")
                        .append(year)
                        .append(" ORDER BY DateOfArrival");
                case "2" -> stringQuery
                        .append("WHERE year(DateOfArrival) = ")
                        .append(year)
                        .append(" AND month(DateOfArrival) = ")
                        .append(month)
                        .append(" ORDER BY DateOfArrival");
                case "3" -> stringQuery
                        .append("WHERE (DateOfArrival Between \"")
                        .append(dateFrom)
                        .append("\" And \"")
                        .append(dateTo)
                        .append("\") ORDER BY DateOfArrival");
            }
        } else {
            switch (typeList) {
                case "0" -> stringQuery
                        .append("WHERE Substance = \"")
                        .append(substance)
                        .append("\"");
                case "1" -> stringQuery
                        .append("WHERE Substance = \"")
                        .append(substance)
                        .append("\" ")
                        .append("AND year(DateOfArrival) = ")
                        .append(year)
                        .append(" ORDER BY DateOfArrival");
                case "2" -> stringQuery
                        .append("WHERE Substance = \"")
                        .append(substance)
                        .append("\" ")
                        .append("AND year(DateOfArrival) = ")
                        .append(year)
                        .append(" AND month(DateOfArrival) = ")
                        .append(month)
                        .append(" ORDER BY DateOfArrival");
                case "3" -> stringQuery
                        .append("WHERE  Substance = \"")
                        .append(substance)
                        .append("\" ")
                        .append("AND (DateOfArrival Between \"")
                        .append(dateFrom)
                        .append("\" And \"")
                        .append(dateTo)
                        .append("\") ORDER BY DateOfArrival");
            }
        }
        return stringQuery.toString();
    }


}


    /*
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Data> dataMap = new HashMap<>();

    static {
        Data data1 = new Data();
        data1.setCode(AUTO_ID.getAndIncrement());
        data1.setSubstance("Izobutanol");
        data1.setDateOfArrival("2020-12-10");
        data1.setRailwayTankNumber(12345678);
        data1.setDateOfDrain("2020-12-10");
        data1.setTypeOfRailwayTank("56");
        data1.setOverflow((short) 250);
        data1.setDensity((short) 800);
        data1.setTemperature((short) 25);
        data1.setWeightInvoice(65000);
        data1.setVolumeOfTheRailwayTank(80000);
        data1.setActualWeight(64000);
        data1.setDifferenceActInv(1000);
        dataMap.put(data1.getCode(), data1);
    }


    @Override
    public List<Data> allDataList() {
        return new ArrayList<>(dataMap.values());
    }

    @Override
    public void add(Data van) {
        van.setCode(AUTO_ID.getAndIncrement());
        dataMap.put(van.getCode(), van);
    }

    @Override
    public void delete(Data van) {
        dataMap.remove(van.getCode());
    }

    @Override
    public void edit(Data van) {
        dataMap.put(van.getCode(), van);
    }

    @Override
    public Data getById(int id) {
        return dataMap.get(id);
    }
    */