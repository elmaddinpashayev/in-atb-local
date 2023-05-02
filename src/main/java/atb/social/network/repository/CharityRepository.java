package atb.social.network.repository;

import atb.social.network.model.CharityModel;
import atb.social.network.model.NewsModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharityRepository extends CrudRepository<CharityModel,Integer> {

    List<CharityModel> findAll(Sort sort);

    CharityModel findById(int id);


}
