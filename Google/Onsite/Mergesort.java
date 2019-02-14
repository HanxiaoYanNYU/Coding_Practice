package Leetcode.Google.Onsite;

public class Mergesort {

    public static void main(String[] args) {
        Mergesort m = new Mergesort();
        int[] array = new int[]{2,0,5,1,2,6,4,8,55,68,4,2,9};
        m.mergesort(array);
        for (Integer i : array) {
            System.out.print(i + " ");
        }
    }

    public void mergesort(int[] array) {
        divide(array, new int[array.length], 0, array.length-1);
    }

    private void divide(int[] array, int[] temp, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        divide(array, temp, left, mid);
        divide(array, temp, mid+1, right);
        combine(array, temp, left, mid, mid+1, right);
    }

    private void combine(int[] array, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int i = leftStart;
        int j = rightStart;
        int I = leftStart;

        while (i <= leftEnd && j <= rightEnd) {
            if (array[i] <= array[j]) {
                temp[I] = array[i];
                i++;
            } else {
                temp[I] = array[j];
                j++;
            }
            I++;
        }

        System.arraycopy(array, i, temp, I, leftEnd-i+1);
        System.arraycopy(array, j, temp, I, rightEnd-j+1);
        System.arraycopy(temp, leftStart, array, leftStart, rightEnd-leftStart+1);
    }
}
