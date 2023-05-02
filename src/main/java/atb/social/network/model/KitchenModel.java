package atb.social.network.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KitchenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mealName;

    private String mealCategory;


    public KitchenModel() {
    }

    public KitchenModel(int id, String mealName, String mealCategory) {
        this.id = id;
        this.mealName = mealName;
        this.mealCategory = mealCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealCategory() {
        return mealCategory;
    }

    public void setMealCategory(String mealCategory) {
        this.mealCategory = mealCategory;
    }
}
