package atb.social.network.repository;

import atb.social.network.model.QuestionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends CrudRepository<QuestionModel, Integer> {

    List<QuestionModel> findAll();
    List<QuestionModel> findAllByStatus(int status);

}
