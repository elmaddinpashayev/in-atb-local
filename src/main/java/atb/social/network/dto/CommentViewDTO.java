package atb.social.network.dto;

public class CommentViewDTO {

    private int id;

    private int empId;


    private String photo;

    private String name;

    private String surname;

    private String position;

    private String text;

    private int anonim;

    private String email;

    private String date;



    public CommentViewDTO() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getAnonim() {
        return anonim;
    }

    public void setAnonim(int anonim) {
        this.anonim = anonim;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }


    @Override
    public String toString() {
        return "CommentViewDTO{" +
                "id=" + id +
                ", empId=" + empId +
                ", photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", text='" + text + '\'' +
                ", anonim=" + anonim +
                ", email='" + email + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
