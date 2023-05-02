package atb.social.network.dto;

public class EmployeeBriefDetailsDto {

    private int id;

    private String name;

    private String surname;

    private String position;

    private String internalNumber;
    private String photo;

    private double importance;

    public  EmployeeBriefDetailsDto(){

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

    public String getPhoto() {
        return photo;
    }

    public double getImportance() {
        return importance;
    }

    public void setImportance(double importance) {
        this.importance = importance;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
