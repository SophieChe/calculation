package main.java.preliminaryTask.util;

public class SpecialExeption extends Exception {
    public SpecialExeption(String description){
        super(description);
        System.exit(0);
    }
}
