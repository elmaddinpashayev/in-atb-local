package atb.social.network.dto;

public class EmployeeDto {

    private int empId;
    private String name;

    private String surname;

    private String branchName;

    private String departmentName;


    private int branchId;

    private int departmentId;


    private String subDepartmentName;

    private String position;

    private String internalNumber;

    private String birhtDate;

    private String phoneNumber;

    private String startJobDate;

    private String email;

    private String photo;

    private int isBirth;

    private Boolean isAdmin;



    private int canCongrat;

    public EmployeeDto(){

    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getIsBirth() {
        return isBirth;
    }

    public void setIsBirth(int isBirth) {
        this.isBirth = isBirth;
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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSubDepartmentName() {
        return subDepartmentName;
    }

    public void setSubDepartmentName(String subDepartmentName) {
        this.subDepartmentName = subDepartmentName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInternalNumber() {
        return internalNumber;
    }

    public void setInternalNumber(String internalNumber) {
        this.internalNumber = internalNumber;
    }

    public String getBirhtDate() {
        return birhtDate;
    }

    public void setBirhtDate(String birhtDate) {
        this.birhtDate = birhtDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartJobDate() {
        return startJobDate;
    }

    public void setStartJobDate(String startJobDate) {
        this.startJobDate = startJobDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getCanCongrat() {
        return canCongrat;
    }

    public void setCanCongrat(int canCongrat) {
        this.canCongrat = canCongrat;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
