package atb.social.network.dto;

public class EmployeePositionChangesDto {

    private int empId;
    private String name;
    private String surname;

    private String internalNumber;

    private String status;

    private String fPosition;
    private String lPosition;

    private String fBranch;

    private String fDepartment;


    private String lBranch;

    private String lDepartment;

    private String photo;


    public EmployeePositionChangesDto() {
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(String internalNumber) {
        this.internalNumber = internalNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getfPosition() {
        return fPosition;
    }

    public void setfPosition(String fPosition) {
        this.fPosition = fPosition;
    }

    public String getlPosition() {
        return lPosition;
    }

    public void setlPosition(String lPosition) {
        this.lPosition = lPosition;
    }

    public String getfBranch() {
        return fBranch;
    }

    public void setfBranch(String fBranch) {
        this.fBranch = fBranch;
    }

    public String getfDepartment() {
        return fDepartment;
    }

    public void setfDepartment(String fDepartment) {
        this.fDepartment = fDepartment;
    }

    public String getlBranch() {
        return lBranch;
    }

    public void setlBranch(String lBranch) {
        this.lBranch = lBranch;
    }

    public String getlDepartment() {
        return lDepartment;
    }

    public void setlDepartment(String lDepartment) {
        this.lDepartment = lDepartment;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
