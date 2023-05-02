package atb.social.network.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBirthdayDto {

    private int id;
    private String name;
    private String surname;
    private int branchId;
    private String filterBirth;
    private int departmentId;
    private int subDepartment;
    private String positionName;
    private int position;
    private String internalNumber;
    private String birhtDate;
    private String phoneNumber;
    private String startJobDate;
    private String email;
    private Boolean isAdmin;
    private String photoBase64;
    private String branchName;
    private String departmentName;
    private String subDepartmentName;

    @JsonIgnore
    private LocalDate birthday;
}
