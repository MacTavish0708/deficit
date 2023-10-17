package testgroup.deficit.service.substance;

import testgroup.deficit.model.Substance;

import java.util.List;

public interface SubstanceService {
    List<Substance> substanceList();
    void add(Substance substance);
    void delete(Substance substance);
    void edit(Substance substance);
    Substance getById(int id);

}
