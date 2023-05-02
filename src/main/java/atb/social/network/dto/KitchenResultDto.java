package atb.social.network.dto;

import java.util.List;

public class KitchenResultDto {

    List<KitchenDto> kitchenDtoList;
    List<String> newMeals;

    public List<KitchenDto> getKitchenDtoList() {
        return kitchenDtoList;
    }

    public void setKitchenDtoList(List<KitchenDto> kitchenDtoList) {
        this.kitchenDtoList = kitchenDtoList;
    }

    public List<String> getNewMeals() {
        return newMeals;
    }

    public void setNewMeals(List<String> newMeals) {
        this.newMeals = newMeals;
    }
}
