package atb.social.network.repository;

import atb.social.network.model.QuestionModel;
import atb.social.network.model.VoteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends CrudRepository<VoteModel,Integer> {
    List<VoteModel> findAllByQuestionModelsAndStatus(QuestionModel questionModel, int status);

    List<VoteModel> findAllByQuestionModels(QuestionModel questionModel);

}
