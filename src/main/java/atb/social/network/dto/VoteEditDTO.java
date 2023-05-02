package atb.social.network.dto;

public class VoteEditDTO {


    private int cid;

    private String text;


    public VoteEditDTO() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
