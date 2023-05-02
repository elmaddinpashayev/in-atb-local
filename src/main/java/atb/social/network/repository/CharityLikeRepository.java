package atb.social.network.repository;

import atb.social.network.model.CharityLikeModel;
import atb.social.network.model.NewsLikeModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharityLikeRepository extends CrudRepository<CharityLikeModel,Integer> {

    List<CharityLikeModel> findAllByCharityIdAndStatus(int charityId, int status);
    CharityLikeModel findByCharityIdAndUserip(int charityId, String userIp);

    CharityLikeModel findByCharityIdAndUseripAndStatus(int charityId, String userIp,int status);

}
