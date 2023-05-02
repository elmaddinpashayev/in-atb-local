package atb.social.network.dto;

public class SuggestionViewDTO{


    private int id;

    private int empId;

    private String photo;

    private String name;

    private String surname;

    private String position;

    private String text;

    private CommentViewDTO commentViewDTO;

    private int anonim;

    private int status;

    private String date;

    public SuggestionViewDTO() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
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

    public CommentViewDTO getCommentViewDTO() {
        return commentViewDTO;
    }

    public void setCommentViewDTO(CommentViewDTO commentViewDTO) {
        this.commentViewDTO = commentViewDTO;
    }

    public int getAnonim() {
        return anonim;
    }

    public void setAnonim(int anonim) {
        this.anonim = anonim;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}
