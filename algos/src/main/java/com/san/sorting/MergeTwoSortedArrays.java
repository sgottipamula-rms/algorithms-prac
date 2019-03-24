package com.san.sorting;


import java.util.Arrays;

public class MergeTwoSortedArrays {

    public int[] merge(int[] a, int[] b, int aLastElementIndex) {
        int aStartIndex = 0;
        int bStartIndex = 0;
        int bLastElementIndex = b.length - 1;

        int inPlaceWorkspaceIndex = a.length - 1;
        while (aLastElementIndex >= aStartIndex && bLastElementIndex >= bStartIndex) {
            if (a[aLastElementIndex] > b[bLastElementIndex])
                a[inPlaceWorkspaceIndex--] = a[aLastElementIndex--];
            else
                a[inPlaceWorkspaceIndex--] = b[bLastElementIndex--];
        }

        while (aLastElementIndex >= aStartIndex)
            a[inPlaceWorkspaceIndex--] = a[aLastElementIndex--];
        while (bLastElementIndex >= bStartIndex)
            a[inPlaceWorkspaceIndex--] = b[bLastElementIndex--];

        return a;
    }


    public int[] mergeWithWorkplace(int[] a, int[] b) {

        int[] workspace = new int[a.length + b.length];


        int aIndex = a.length - 1;
        int bIndex = b.length - 1;
        int workspaceIndex = workspace.length - 1;


        while(aIndex>=0 && bIndex>=0) {

            if(b[bIndex] >= a[aIndex]) {
                workspace[workspaceIndex] = b[bIndex];
                workspaceIndex--;
                bIndex--;
            } else {
                workspace[workspaceIndex] = a[aIndex];
                workspaceIndex--;
                aIndex--;
            }
        }

        while(aIndex>=0) {
            workspace[workspaceIndex] = a[aIndex];
            workspaceIndex--;
            aIndex--;
        }

        while(bIndex>=0) {
            workspace[workspaceIndex] = b[bIndex];
            workspaceIndex--;
            bIndex--;
        }

        return workspace;
    }

    public static void main(String[] args) {

        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();

        int[] a = new int[3];
        a[0]=4;
        a[1]=5;
        a[2]=6;

        int[] b = new int[]{1,2,3};

        //System.out.println(Arrays.toString(mergeTwoSortedArrays.merge(a, b, 2)));

        System.out.println(Arrays.toString(mergeTwoSortedArrays.mergeWithWorkplace(a,b)));
    }
}
