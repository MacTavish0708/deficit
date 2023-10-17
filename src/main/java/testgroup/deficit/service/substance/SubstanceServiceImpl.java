package testgroup.deficit.service.substance;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import testgroup.deficit.dao.substance.SubstanceDAO;
import testgroup.deficit.model.Substance;
import testgroup.deficit.model.Van;


import java.util.List;

@Repository
public class SubstanceServiceImpl implements SubstanceService {
    private final SubstanceDAO substanceDAO;

    public SubstanceServiceImpl(SubstanceDAO substanceDAO) {
        this.substanceDAO = substanceDAO;
    }

    @Override
    @Transactional
    public List<Substance> substanceList() {
        return substanceDAO.substanceList();
    }

    @Override
    @Transactional
    public void add(Substance substance) {
        substanceDAO.add(substance);
    }

    @Override
    @Transactional
    public void delete(Substance substance) {
        substanceDAO.delete(substance);
    }

    @Override
    @Transactional
    public void edit(Substance substance) {
        substanceDAO.edit(substance);
    }

    @Override
    @Transactional
    public Substance getById(int id) {
        return substanceDAO.getById(id);
    }

    public static List<Substance> allPlusSubstanceList(List<Substance> substanceList ){
        substanceList.add(0, new Substance());
        substanceList.get(0).setSubstance("All");
        substanceList.get(0).setId(substanceList.get(substanceList.size()-1).getId()+1);
        return substanceList;
    }

    public static List<Substance> editListSubstance(List<Substance> substanceList, Van van){
        String vanSubstance = van.getSubstance();
        for (Substance sub :
                substanceList) {
            if (sub.getSubstance().equalsIgnoreCase(vanSubstance)) {
                substanceList.remove(sub);
                substanceList.add(0, sub);
                break;
            }
        }
        return substanceList;
    }

    public static List<Substance> editListSubstance(List<Substance> substanceList, String substance){
        for (Substance sub :
                substanceList) {
            if (sub.getSubstance().equalsIgnoreCase(substance)) {
                substanceList.remove(sub);
                substanceList.add(0, sub);
                break;
            }
        }
        return substanceList;
    }

}

