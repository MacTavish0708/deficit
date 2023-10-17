package testgroup.deficit.dao.tov;

import testgroup.deficit.model.CalculationPost;
import testgroup.deficit.model.TOV;

import java.util.List;

public interface TOVDAO {
    List<TOV> allTOVList();

    TOV getTOV(CalculationPost calculationPost);
    float getMaxVolume(CalculationPost calculationPost);
}
