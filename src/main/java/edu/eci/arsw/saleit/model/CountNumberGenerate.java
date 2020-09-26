package edu.eci.arsw.saleit.model;

public class CountNumberGenerate {
    public static long id = 0;

    public static long getId() {
        return id;
    }

    public static void increment(){
        id++;
    }
}
