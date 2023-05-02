package atb.social.network.repository;

import atb.social.network.model.QuestionModel;
import atb.social.network.model.VoteUserModel;
import io.swagger.models.auth.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteUserRepository extends CrudRepository<VoteUserModel, Integer> {


    VoteUserModel findByQuestionModelsAndUserIp(QuestionModel questionModel,String ip);


    List<VoteUserModel> findAllByQuestionModels(QuestionModel questionModel);

}
