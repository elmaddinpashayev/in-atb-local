package atb.social.network.repository;

import atb.social.network.model.NewsLikeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsLikeRepository extends CrudRepository<NewsLikeModel,Integer> {

    List<NewsLikeModel> findAllByNewsIdAndStatus(int newsId, int status);

    NewsLikeModel findByNewsIdAndUserip(int newsId, String userIp);

    NewsLikeModel findByNewsIdAndUseripAndStatus(int newsId, String userIp,int status);

}
