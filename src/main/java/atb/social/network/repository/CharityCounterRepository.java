package atb.social.network.repository;

import atb.social.network.model.CharityCounterModel;
import atb.social.network.model.NewsCounterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharityCounterRepository extends CrudRepository<CharityCounterModel, Integer> {

    NewsCounterModel findByCharityIdAndIp(int id, String ip);

    List<NewsCounterModel> findAllByCharityId(int id);
}
