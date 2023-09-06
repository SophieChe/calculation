package main.java.preliminaryTask.util;

public enum RomanNumerals {
    NUMI(1), NUMII(2), NUMIII(3), NUMIV(4), NUMV(5),
    NUMVI(6), NUMVII(7), NUMVIII(8), NUMIX(9), NUMX(10);

    private Integer RomanNum;
    RomanNumerals(Integer RomanNum) {
        this.RomanNum = RomanNum;
    }

    public Integer getRomanNum(){
        return RomanNum;
    }

    @Override
    public String toString() {
        return RomanNum+"";
    }
}
