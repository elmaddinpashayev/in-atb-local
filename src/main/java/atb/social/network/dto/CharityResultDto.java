package atb.social.network.dto;

import java.util.List;

public class CharityResultDto {

    List<CharityViewDTO> charityViewDTOS;
    int size;

    public List<CharityViewDTO> getCharityViewDTOS() {
        return charityViewDTOS;
    }

    public void setCharityViewDTOS(List<CharityViewDTO> charityViewDTOS) {
        this.charityViewDTOS = charityViewDTOS;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
