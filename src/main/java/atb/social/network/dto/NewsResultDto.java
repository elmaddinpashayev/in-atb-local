package atb.social.network.dto;

import java.util.List;

public class NewsResultDto {

    List<NewsViewDTO> newsViewDTOList;
    int size;


    public List<NewsViewDTO> getNewsViewDTOList() {
        return newsViewDTOList;
    }

    public void setNewsViewDTOList(List<NewsViewDTO> newsViewDTOList) {
        this.newsViewDTOList = newsViewDTOList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
