package testgroup.deficit.service.van;

import testgroup.deficit.model.Van;
import testgroup.deficit.model.VanTablePost;

import java.util.List;

public interface VanService {
    void add(Van van);
    void delete(Van van);
    void edit(Van van);
    Van getById(int id);
    void procedureUpdate();
    int vanCount(VanTablePost vanTablePost);
    List<Van> getVanList(VanTablePost vanTablePost, int page, int maxPage);

}
