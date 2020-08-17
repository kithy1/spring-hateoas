package otheralghoritms;

import java.util.Arrays;

public class BubbleSort {
    
    public static void sort(int[] ints){
        int len = ints.length;

        for (int i = 0; i < len - 1; i++) {

            for (int j = 0; j < len - i - 1; j++) {

                if (ints[j]>ints[j+1]){

                    int temp = ints[j];
                    ints[j] = ints[j+1];
                    ints[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] ints = {8,3,5,2,9};
        sort(ints);

        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
