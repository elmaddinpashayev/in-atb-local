package atb.social.network.repository;

import atb.social.network.model.NewsCounterModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsCounterRepository extends CrudRepository<NewsCounterModel,Integer> {

    NewsCounterModel findByNewsIdAndIp(int id, String ip);

    List<NewsCounterModel> findAllByNewsId(int id);
}
