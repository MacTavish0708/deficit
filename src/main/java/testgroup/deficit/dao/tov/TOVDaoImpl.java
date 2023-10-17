package testgroup.deficit.dao.tov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.deficit.model.CalculationPost;
import testgroup.deficit.model.TOV;

import java.util.List;

@Repository
public class TOVDaoImpl implements TOVDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<TOV> allTOVList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from TOV ", TOV.class).list();
    }

    @Override
    public TOV getTOV(CalculationPost calculationPost) {
        Session session = sessionFactory.getCurrentSession();
        String typerw ="\""+ calculationPost.getTyperw() +"\"";
        short density = calculationPost.getDensity()>0 ? calculationPost.getDensity() : 1;
        String volume = String.valueOf(calculationPost.getWeight() * 1000 / density);
        return session.createQuery(
                "from TOV where TypeOfRailwayTank = " + typerw +
                        " AND VolumeOfTheRailwayTank >= " + volume, TOV.class).list().get(0);
    }

    @Override
    public float getMaxVolume(CalculationPost calculationPost) {
        Session session = sessionFactory.getCurrentSession();
        String typerw ="\""+ calculationPost.getTyperw() +"\"";
        return session.createQuery("select max(VolumeOfTheRailwayTank) from TOV where TypeOfRailwayTank = " + typerw , Number.class).getSingleResult().floatValue();


    }


}
