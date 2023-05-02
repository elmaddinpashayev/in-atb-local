package atb.social.network.dto;

import java.util.List;

public class PollEditDTO {


    private  int id;

    private String title;
    private String link;
    private String description;

    private List<VoteEditDTO> votes;


    public PollEditDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<VoteEditDTO> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteEditDTO> votes) {
        this.votes = votes;
    }
}
