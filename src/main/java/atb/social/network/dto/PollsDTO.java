package atb.social.network.dto;

import java.util.List;

public class PollsDTO {

    private int qId;

    private String title;

    private String link;

    private String description;

    private int access;


    private List<VoteListDTO> votes;


    public PollsDTO() {
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<VoteListDTO> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteListDTO> votes) {
        this.votes = votes;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
}
