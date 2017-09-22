package ru.vladmatyunin;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class contains two bags, which stores the "weight" of each value
 *  for every bag
 */
public class BagContainer {

    private List<Integer> leftBag;

    private List<Integer> middleBag;

    private List<Integer> rightBag;

    public BagContainer(){
        leftBag = new ArrayList<>();
        rightBag = new ArrayList<>();
        middleBag = new ArrayList<>();
    }

    //creates new instances of bags
    public BagContainer(List<Integer> leftBag, List<Integer> middleBag, List<Integer> rightBag){
        this.leftBag = new ArrayList<>(leftBag);
        this.rightBag = new ArrayList<>(rightBag);
        this.middleBag = new ArrayList<>(middleBag);
    }

    public void putLeft(int value){
        leftBag.add(value);
    }

    public void putMiddle(int value){
        middleBag.add(value);
    }

    public void putRight(int value){
        rightBag.add(value);
    }

    public List<Integer> getLeftBag(){
        return leftBag;
    }

    public List<Integer> getRightBag(){
        return rightBag;
    }

    /**
     * @return the difference between three bags, result is gt 0
     */
    public int getDifference(){
        int leftBagWeight = sumArray(leftBag);
        int rightBagWeight = sumArray(rightBag);
        int middleBagWeight = sumArray(middleBag);
        int minimal = Integer.min(Integer.min(leftBagWeight, rightBagWeight), middleBagWeight);
        int maximal = Integer.max(Integer.max(leftBagWeight, rightBagWeight), middleBagWeight);
        return Math.abs(maximal-minimal);
    }

    // sum the weight of a bag
    private int sumArray(List<Integer> values){
        int counter = 0;
        for (Integer value: values){
            counter+=value;
        }
        return counter;
    }

    @Override
    public String toString() {
        return "Left Bag:"+leftBag.toString()+"\n"+
                "Middle Bag:" + middleBag.toString()+"\n"+
                "Right Bag:" + rightBag.toString()+ "\n"+
                "Difference is: "+ getDifference();
    }

    public List<Integer> getMiddleBag() {
        return middleBag;
    }
}
