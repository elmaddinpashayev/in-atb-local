package atb.social.network.model;


//import atb.social.network.model.security.Role;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private int branchId;
    @Nullable
    private String filterBirth;
    private int departmentId;
    private int subDepartment;
    private String positionName;
    private int position;
    @Nullable
    private String internalNumber;
    @Nullable
    private String birhtDate;
    @Nullable
    private String phoneNumber;
    @Nullable
    private String startJobDate;

    @Size(max = 50)
    private String email;

    private Boolean isAdmin;

    @Column(columnDefinition = "TEXT")
    @Nullable
    private String photoBase64;

    @Size(max = 20)
    private String username;

    @Size(max = 120)
    private String password;

//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
    //private Set<Role> roles = new HashSet<>();

    public EmployeeModel() {
    }

    public EmployeeModel(String username, String email, String encode) {

    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getFilterBirth() {
        return filterBirth;
    }

    public void setFilterBirth(String filterBirth) {
        this.filterBirth = filterBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getSubDepartment() {
        return subDepartment;
    }

    public void setSubDepartment(int subDepartment) {
        this.subDepartment = subDepartment;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }

    @Transient
    public String getPhotosImagePath() {
        if (photoBase64 == null)
            return null;
        return "/user-photos/" + id + "/" + photoBase64;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", branchId=" + branchId +
                ", filterBirth='" + filterBirth + '\'' +
                ", departmentId=" + departmentId +
                ", subDepartment=" + subDepartment +
                ", positionName='" + positionName + '\'' +
                ", position=" + position +
                ", internalNumber='" + internalNumber + '\'' +
                ", birhtDate='" + birhtDate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", startJobDate='" + startJobDate + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                ", photoBase64='" + photoBase64 + '\'' +
                '}';
    }
}
