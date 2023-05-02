package atb.social.network.dto;

import atb.social.network.model.MealModel;

import java.util.List;

public class CanteenDto {

    private String category;

    private List<MealModel> mealModels;

    public CanteenDto() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<MealModel> getMealModels() {
        return mealModels;
    }

    public void setMealModels(List<MealModel> mealModels) {
        this.mealModels = mealModels;
    }
}
