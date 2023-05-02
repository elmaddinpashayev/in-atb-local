package atb.social.network.repository;

import atb.social.network.model.CongratModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongratRepository extends CrudRepository<CongratModel,Integer> {

    List<CongratModel> findAllByToIdAndYear(int toId, String year);

    CongratModel findByUserIpAndToId(String userIp, int toId);

    CongratModel findByEmpIdAndToId(int empId, int toId);
}
