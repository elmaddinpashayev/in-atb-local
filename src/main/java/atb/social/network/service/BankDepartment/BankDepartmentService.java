package atb.social.network.service.BankDepartment;

import atb.social.network.dto.DepartmentDto;
import atb.social.network.model.BankDepartmenModel;

import java.util.List;

public interface BankDepartmentService {

    List<BankDepartmenModel> getAllDepartments() throws Exception;

    List<BankDepartmenModel> getByBranchId(int id) throws Exception;
    void save(DepartmentDto departmentDto) throws Exception;
    void edit(DepartmentDto departmentDto, int id) throws Exception;
    void remove(int id) throws Exception;



}
