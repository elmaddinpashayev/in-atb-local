package atb.social.network.dto;

public class EmployeeKudosDTO {

    private int empId;
    private String empName;
    private String empSurName;
    private String profilePicURL;
    private String empPosition;

    @Override
    public String toString() {
        return "EmployeeKudosDTO{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empSurName='" + empSurName + '\'' +
                ", profilePicURL='" + profilePicURL + '\'' +
                ", empPosition='" + empPosition + '\'' +
                '}';
    }

    public String getEmpSurName() {
        return empSurName;
    }

    public void setEmpSurName(String empSurName) {
        this.empSurName = empSurName;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }
}
