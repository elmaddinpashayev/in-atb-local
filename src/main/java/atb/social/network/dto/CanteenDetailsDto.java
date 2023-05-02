package atb.social.network.dto;

import java.util.List;

public class CanteenDetailsDto {

    private String date;

    private List<CanteenDto> canteenDtos;

    public CanteenDetailsDto() {
    }

    public List<CanteenDto> getCanteenDtos() {
        return canteenDtos;
    }

    public void setCanteenDtos(List<CanteenDto> canteenDtos) {
        this.canteenDtos = canteenDtos;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
