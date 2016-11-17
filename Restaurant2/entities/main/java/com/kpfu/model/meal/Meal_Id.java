package com.kpfu.model.meal;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Vlad.M on 12.11.2016.
 */
@Embeddable
public class Meal_Id implements Serializable{
    public String name;
    public String type;
    public Meal_Id(){}
    public Meal_Id(String name, String type){
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Meal_Id))return false;
        if (this.name.equals(((Meal_Id) obj).name)
                && this.type.equals(((Meal_Id) obj).type))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode()*13;
    }
}
