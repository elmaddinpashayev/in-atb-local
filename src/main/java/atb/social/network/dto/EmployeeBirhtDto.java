package atb.social.network.dto;

public class EmployeeBirhtDto {

    private int id;
    private String name;
    private String surname;
    private String internalNum;
    private Boolean isAdmin;
    private String photo;


    public EmployeeBirhtDto() {
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
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

    public String getInternalNum() {
        return internalNum;
    }

    public void setInternalNum(String internalNum) {
        this.internalNum = internalNum;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
