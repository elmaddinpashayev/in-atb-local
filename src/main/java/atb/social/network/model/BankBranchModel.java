package atb.social.network.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankBranchModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String branchName;

    private int isMainBranch;

    private Integer importance;

    public BankBranchModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getIsMainBranch() {
        return isMainBranch;
    }

    public void setIsMainBranch(int isMainBranch) {
        this.isMainBranch = isMainBranch;
    }

    public Integer getImportance() {
        return importance;
    }

    public void setImportance(Integer importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "BankBranchModel{" +
                "id=" + id +
                ", branchName='" + branchName + '\'' +
                ", isMainBranch=" + isMainBranch +
                ", importance=" + importance +
                '}';
    }
}
