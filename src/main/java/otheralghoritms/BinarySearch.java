package otheralghoritms;

public class BinarySearch {

    public static int searchElement(int[] ints, int target) {
        int len = ints.length;

        int min = 0;
        int max = len - 1;
        int middle;

        while (max >= min) {
            middle = (max + min) / 2;

            if (middle == target) {
                return middle;
            }

            if (target < middle) {
                max = middle - 1;
            }

            if (target > middle){
                min = (middle + 1);
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int [] ints = {1, 4, 88, 2, 100};

        System.out.println(searchElement(ints, 20));

    }
}
