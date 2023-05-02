package atb.social.network.dto;

import java.util.List;

public class EmployeesBirthDayList {

    private String date;

    private List<EmployeeBirhtDto> employeeBirhtDtoList;

    public EmployeesBirthDayList() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<EmployeeBirhtDto> getEmployeeBirhtDtoList() {
        return employeeBirhtDtoList;
    }

    public void setEmployeeBirhtDtoList(List<EmployeeBirhtDto> employeeBirhtDtoList) {
        this.employeeBirhtDtoList = employeeBirhtDtoList;
    }
}
