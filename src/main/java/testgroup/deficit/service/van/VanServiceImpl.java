package testgroup.deficit.service.van;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import testgroup.deficit.dao.van.VanDAO;
import testgroup.deficit.model.Van;
import testgroup.deficit.model.VanTablePost;

import java.util.List;

@Repository
public class VanServiceImpl implements VanService {
    private final VanDAO vanDAO;

    public VanServiceImpl(VanDAO vanDAO) {
        this.vanDAO = vanDAO;
    }


    @Override
    @Transactional
    public void add(Van van) {
        vanDAO.add(van);
    }

    @Override
    @Transactional
    public void delete(Van van) {
        vanDAO.delete(van);
    }

    @Override
    @Transactional
    public void edit(Van van) {
        vanDAO.edit(van);
    }

    @Override
    @Transactional
    public Van getById(int id) {
        return vanDAO.getById(id);
    }

    @Override
    @Transactional
    public int vanCount(VanTablePost vanTablePost) {
        return vanDAO.queryVanCount(vanTablePost);
    }

    @Override
    @Transactional
    public List<Van> getVanList(VanTablePost vanTablePost, int page, int maxPage) {
        return vanDAO.queryVanList(vanTablePost, page, maxPage);
    }

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void procedureUpdate() {
        //"updateVolumeAndWeight" this is the name procedure
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("updateVolumeAndWeight");
        query.execute();
    }

}

