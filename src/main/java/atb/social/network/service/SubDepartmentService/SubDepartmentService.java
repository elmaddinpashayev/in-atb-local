package atb.social.network.service.SubDepartmentService;

import atb.social.network.dto.SubDepartDto;
import atb.social.network.model.SubDepartmentModel;

import java.util.List;

public interface SubDepartmentService {

    SubDepartmentModel getSubServiceData(int id) throws Exception;

    List<SubDepartmentModel> getallSubDepartment(int branchId, int departId) throws Exception;

    void save (SubDepartDto subDepartDto) throws Exception;

    void edit(SubDepartDto subDepartDto, int id) throws Exception;

    void remove(int id) throws Exception;

}
