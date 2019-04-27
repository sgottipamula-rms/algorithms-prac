package com.san.arrays;

public class SortedArrayProblem {

    public void findCommonElements(int[] a, int[] b) {

        int aIndex = 0;
        int bIndex = 0;

        while(true) {

            if(aIndex>=a.length || bIndex>=b.length)
                break;

            if(a[aIndex]==b[bIndex]) {

                System.out.println(a[aIndex]);
                aIndex++;
                bIndex++;
                continue;
            }

            if(a[aIndex]<b[bIndex])
                aIndex++;

            if(a[aIndex]>b[bIndex])
                bIndex++;
        }

    }

    public void findMinimumDifferencePair(int[] a, int[] b) {

        int aIndex=0;
        int bIndex=0;
        int min = Integer.MAX_VALUE;
        int avalue = Integer.MAX_VALUE;
        int bvalue=Integer.MAX_VALUE;

        while(true) {

            if(aIndex>=a.length || bIndex>=b.length)
                break;

            int currentmin = Math.abs(a[aIndex] - b[bIndex]);

            if(currentmin<min) {
                min = currentmin;
                avalue = a[aIndex++];
                bvalue = b[bIndex++];
                continue;
            }

            if(a[aIndex]<b[bIndex])
                aIndex++;

            if(a[aIndex]>b[bIndex])
                bIndex++;

        }


        System.out.println("MIN:"+min);
        System.out.println("Avalue:"+avalue);
        System.out.println("Bvalue:"+bvalue);
    }

    public void go() {

        findMinimumDifferencePair(new int[]{1,2,5,11}, new int[]{4,12,19,23,127,235});
    }

    public static void main(String[] args) {
        new SortedArrayProblem().go();
    }
}
