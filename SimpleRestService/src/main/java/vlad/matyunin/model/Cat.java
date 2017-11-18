package vlad.matyunin.model;

/**
 * Created by Vlad on 11.11.2017.
 */
public class Cat extends Animal {
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Cat"+"{nick:"+nickName+", "+"name:"+name+", size: "+size+"}";
    }
}
