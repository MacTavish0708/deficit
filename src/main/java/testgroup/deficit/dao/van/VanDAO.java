package testgroup.deficit.dao.van;

import testgroup.deficit.model.Van;
import testgroup.deficit.model.VanTablePost;

import java.util.List;

public interface VanDAO {
    void add(Van van);
    void delete(Van van);
    void edit(Van van);
    Van getById(int id);
    int queryVanCount(VanTablePost vanTablePost);

    List<Van> queryVanList(VanTablePost vanTablePost, int page, int maxPage);

}
