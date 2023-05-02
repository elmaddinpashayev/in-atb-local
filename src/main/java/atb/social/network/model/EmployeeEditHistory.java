package atb.social.network.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeEditHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;

    private int employeeId;

    private int fPosition;

    private int fBranch;

    private int fDepartment;


    private int lBranch;

    private int lDepartment;

    private int lPosition;

    private String dateWithoutYear;

    private String status;



    public EmployeeEditHistory() {
    }

    public int getfBranch() {
        return fBranch;
    }

    public void setfBranch(int fBranch) {
        this.fBranch = fBranch;
    }

    public int getfDepartment() {
        return fDepartment;
    }

    public void setfDepartment(int fDepartment) {
        this.fDepartment = fDepartment;
    }

    public int getlBranch() {
        return lBranch;
    }

    public void setlBranch(int lBranch) {
        this.lBranch = lBranch;
    }

    public int getlDepartment() {
        return lDepartment;
    }

    public void setlDepartment(int lDepartment) {
        this.lDepartment = lDepartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getfPosition() {
        return fPosition;
    }

    public void setfPosition(int fPosition) {
        this.fPosition = fPosition;
    }

    public int getlPosition() {
        return lPosition;
    }

    public void setlPosition(int lPosition) {
        this.lPosition = lPosition;
    }

    public String getDateWithoutYear() {
        return dateWithoutYear;
    }

    public void setDateWithoutYear(String dateWithoutYear) {
        this.dateWithoutYear = dateWithoutYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
