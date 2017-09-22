package ru.vladmatyunin;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple polynomial class, containing values [0, 1, -2, 3] as 0+1-2+3
 */
public class Polynomial {

    private List<Integer> values;

    public Polynomial(List<Integer> values){
        this.values = new ArrayList<>(values);
    }

    public Polynomial append(int value){
        values.add(value);
        return this;
    }

    public List<Integer> getValues(){
        return values;
    }

    @Override
    public String toString() {
        return "polynomial is:" + values.toString() + "\n"
                + "abs is: "+ getAbsSum();
    }

    public int getAbsSum(){
        int count = 0;
        for (Integer value: values){
            count+=value;
        }
        return Math.abs(count);
    }
}
