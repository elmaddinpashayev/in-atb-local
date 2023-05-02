package atb.social.network.repository;

import atb.social.network.model.SubDepartmentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubDepartmentRepository extends CrudRepository<SubDepartmentModel,Integer> {


    List<SubDepartmentModel> findAllByBranchIdAndDepartId(int branchId, int departId);



}
