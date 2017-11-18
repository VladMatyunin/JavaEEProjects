package vlad.matyunin.model;

/**
 * Created by Vlad on 11.11.2017.
 */
public class Dog extends Animal {
    private int legSize;

    public int getLegSize() {
        return legSize;
    }

    public void setLegSize(int legSize) {
        this.legSize = legSize;
    }

    @Override
    public String toString() {
        return "Dog"+"{leg:"+6+", "+"name:"+name+", size: "+size+"}";
    }
}
