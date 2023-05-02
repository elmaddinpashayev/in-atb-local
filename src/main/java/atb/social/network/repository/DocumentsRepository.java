package atb.social.network.repository;

import atb.social.network.model.DocumentsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentsRepository extends CrudRepository<DocumentsModel,Integer> {


    List<DocumentsModel> findAll();
}
