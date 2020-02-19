package com.example.todopractice1_9bookhuh;

import java.util.ArrayList;

public class ToDoClass {
    private String wish="a";
    private String type="a";
    private static ArrayList<ToDoClass> toDoDaily=new ArrayList<>();
    private static ArrayList<ToDoClass> toDoWeekly=new ArrayList<>();
    private static ArrayList<ToDoClass> toDoMonthly=new ArrayList<>();



    public static ArrayList<ToDoClass> GetDoDaily(){
        return toDoDaily;
    }

    public static ArrayList<ToDoClass> getDoWeekly() {
        return toDoWeekly;
    }

    public static ArrayList<ToDoClass> getDoMonthly() {
        return toDoMonthly;
    }

    public ToDoClass(String wish,String type){
        this.type=type;
        this.wish=wish;
    }

    public String getWish() {
        return wish;
    }

    public String getType() {
        return type;
    }

    public void SetWish(String w){
        this.wish=w;
    }

    public void SetType(String t){
        this.type=t;
    }

    public String toString(){
        return this.wish.toString();
    }

}
