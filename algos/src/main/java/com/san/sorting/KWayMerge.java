package com.san.sorting;

import com.san.heap.MinHeap;

import java.util.Arrays;

//merge 3 sorted arrays in to a sorted array
public class KWayMerge {


    public int[] merge(int[] a, int[] b, int[] c) {

        int[] workspace = new int[a.length+b.length+c.length];

        MinHeap minHeap =  new MinHeap(3);
        int aIndex=0;
        int bIndex=0;
        int cIndex=0;
        int workspaceIndex=0;

        minHeap.insert(a[aIndex]);
        minHeap.insert(b[bIndex]);
        minHeap.insert(c[cIndex]);


        while(true) {

            if((aIndex==a.length-1) && (bIndex==b.length-1) && (cIndex==c.length-1))
                break;

            int element = minHeap.remove(1);
            workspace[workspaceIndex++] = element;

            //naive solution assumes unique elements.
            if(a[aIndex]==element) {

                if(aIndex+1 == a.length)
                    continue;

                aIndex++;
                minHeap.insert(a[aIndex]);
            }
            else if(b[bIndex]==element) {

                if(bIndex+1 == b.length)
                    continue;

                bIndex++;
                minHeap.insert(b[bIndex]);
            }
            else if(c[cIndex]==element) {

                if(cIndex+1 == c.length)
                    continue;

                cIndex++;
                minHeap.insert(c[cIndex]);
            }

        }

        int element = minHeap.remove(1);
        while(element != -1) {
            workspace[workspaceIndex++] = element;
            element = minHeap.remove(1);
        }

        return workspace;
    }


    public static void main(String[] args) {
        KWayMerge kWayMerge = new KWayMerge();

        int[] res = kWayMerge.merge(new int[]{1,2,3},
                        new int[]{4,5,6},
                        new int[]{7,8,9});

        System.out.println(Arrays.toString(res));
    }
}
