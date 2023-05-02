package atb.social.network.repository;

import atb.social.network.model.SugesstionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuggestRepository extends CrudRepository<SugesstionModel,Integer> {

    List<SugesstionModel> findAllByStatus(int status);
    List<SugesstionModel> findAll();

    SugesstionModel findByCommentId(int id);

}
