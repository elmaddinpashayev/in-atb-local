package atb.social.network.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BankDepartmenModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String departmentName;

    private int availableOnBranchId;







    public BankDepartmenModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getAvailableOnBranchId() {
        return availableOnBranchId;
    }

    public void setAvailableOnBranchId(int availableOnBranchId) {
        this.availableOnBranchId = availableOnBranchId;
    }
}
