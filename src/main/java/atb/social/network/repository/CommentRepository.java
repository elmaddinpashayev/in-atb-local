package atb.social.network.repository;

import atb.social.network.model.CommentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<CommentModel,Integer> {

    CommentModel findBySuggestId(int id);
}
