package com.example.jc.myapplication.builder.custom;

/**
 * Created by jc on 2017/7/10.
 */

public abstract class MealBuilder {

    protected Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
