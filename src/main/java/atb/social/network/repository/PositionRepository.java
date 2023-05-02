package atb.social.network.repository;

import atb.social.network.model.PositionModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends CrudRepository<PositionModel,Integer> {


    List<PositionModel> findAllByBranchIdAndDepartIdAndSubDepartId(int branchId,int departId,int SubDepartId);




}
