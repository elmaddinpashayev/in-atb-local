package atb.social.network.repository;


import atb.social.network.model.EmployeeModel;
import atb.social.network.model.projection.EmployeeProjDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, Integer> {


    List<EmployeeModel> findAllByBranchIdAndDepartmentId(int bId, int dId);

    EmployeeModel findById(int id);

    Set<EmployeeModel> findAll();

    List<EmployeeModel> findAllByFilterBirth(String birthday);

    EmployeeModel findByEmailIgnoreCase(String email);

    Optional<EmployeeModel> findByUsername(String username);

    Boolean existsByUsername(String username);

    @Query(nativeQuery = true, value = "SELECT " +
            "e.id as id, " +
            "e.birht_date as birhtDate, " +
            "e.branch_id as branchId, " +
            "e.department_id as departmentId, " +
            "e.email as email, " +
            "e.filter_birth as filterBirth, " +
            "e.internal_number as internalNumber, " +
            "e.name as name, " +
            "e.phone_number as phoneNumber, " +
            "e.position as position, " +
            "e.position_name as positionName, " +
            "e.start_job_date as startJobDate, " +
            "e.sub_department as subDepartMent, " +
            "e.surname as surname, " +
            "e.photo_base64 as photoBase64, " +
            "e.is_admin as isAdmin, " +
            "e.username as username, " +
            "b.branch_name as branchName," +
            "d.department_name as departmentName," +
            "s.name as subDepartmentName " +
            "from Employee_Model e " +
            "left join sub_department_model s on e.sub_department = s.id " +
            "left join bank_branch_model b on e.branch_id = b.id " +
            "left join bank_departmen_model d on e.department_id = d.id")
    List<EmployeeProjDto> findAllEmployeeBirthdayDto();

    Boolean existsByEmail(String email);


}

