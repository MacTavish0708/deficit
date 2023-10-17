package testgroup.deficit.dao.substance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import testgroup.deficit.model.Substance;

import java.util.List;

@Repository
public class SubstanceDaoImpl implements SubstanceDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Substance> substanceList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Substance ", Substance.class).list();
    }

    @Override
    public void add(Substance substance) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(substance);
    }

    @Override
    public void delete(Substance substance) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(substance);
    }

    @Override
    public void edit(Substance substance) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(substance);
    }

    @Override
    public Substance getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Substance.class, id);
    }

}
