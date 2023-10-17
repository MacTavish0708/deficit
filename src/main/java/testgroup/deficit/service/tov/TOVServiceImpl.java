package testgroup.deficit.service.tov;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import testgroup.deficit.dao.tov.TOVDAO;
import testgroup.deficit.model.CalculationPost;
import testgroup.deficit.model.TOV;

import java.util.List;

@Repository
public class TOVServiceImpl implements TOVService {
    private final TOVDAO tovdao;

    public TOVServiceImpl(TOVDAO tovDAO) {
        this.tovdao = tovDAO;
    }

    @Override
    @Transactional
    public List<TOV> allTOVList() {
        return tovdao.allTOVList();
    }

    @Override
    @Transactional
    public TOV getTOV(CalculationPost calculationPost) {
        return tovdao.getTOV(calculationPost);
    }

    @Override
    @Transactional
    public float getMaxVolume(CalculationPost calculationPost) {
        return tovdao.getMaxVolume(calculationPost);
    }


}

