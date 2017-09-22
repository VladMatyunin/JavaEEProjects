package ru.vladmatyunin;

import java.util.ArrayList;
import java.util.List;

/**
 * Executor uses recursion, each iteration of which
 * it appends to current polynomial a value with + or -, and calls another recursion step
 * Returns when all items are included to current polynomial
 */
public class Executor {

    private List<Polynomial> results;

    private int[] values;

    public Executor(int[] values){
        results = new ArrayList<>();
        this.values = values;
    }
    public List<Polynomial> execute(){
        recursiveExecution(new Polynomial(new ArrayList<>()),0,values[0]);
        return results;
    }
    private void recursiveExecution(Polynomial polynomial, int nextIndex, int nextValue){
        if (nextIndex==values.length-1){
            results.add(new Polynomial(polynomial.getValues()).append(nextValue));
            results.add(new Polynomial(polynomial.getValues()).append(-nextValue));
        }
        else {
            //execute next step with positive
            recursiveExecution(new Polynomial(polynomial.getValues()).append(nextValue), nextIndex+1, values[nextIndex+1]);
            //execute with the same values but with negative
            recursiveExecution(new Polynomial(polynomial.getValues()).append(nextValue), nextIndex+1, -values[nextIndex+1]);
        }
    }

    /**
     * @param polynomials - the polynomials to inspect
     * @return - the minimal polynomial, which abs is the lowest
     */
    static Polynomial getMinimalPolynomial(List<Polynomial> polynomials){
        int min = Integer.MAX_VALUE;
        Polynomial minPolynomial = polynomials.get(0);
        for (Polynomial polynomial: polynomials){
            if (polynomial.getAbsSum()<min){
                min = polynomial.getAbsSum();
                minPolynomial = polynomial;
            }
        }
        return minPolynomial;
    }
}
