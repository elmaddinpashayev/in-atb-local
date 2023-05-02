package atb.social.network.dto;

import java.util.List;

public class EmployeeBriefDto {

    private String subDepartmentName;


    private List<EmployeeBriefDetailsDto> employeeBriefDetailsDtos;

    public EmployeeBriefDto(){

    }

    public String getSubDepartmentName() {
        return subDepartmentName;
    }

    public void setSubDepartmentName(String subDepartmentName) {
        this.subDepartmentName = subDepartmentName;
    }

    public List<EmployeeBriefDetailsDto> getEmployeeBriefDetailsDtos() {
        return employeeBriefDetailsDtos;
    }

    public void setEmployeeBriefDetailsDtos(List<EmployeeBriefDetailsDto> employeeBriefDetailsDtos) {
        this.employeeBriefDetailsDtos = employeeBriefDetailsDtos;
    }
}
