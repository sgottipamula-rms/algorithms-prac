package com.san.searching;

public class StringSearch {

    public int find(String[] strings, int start, int end, String val) {

        //basically binary search but if mid=empty string then
        // keep moving left and right pointers until you encounter non empty strings
        // and use that for binary search

        int mid = (start+end)/2;

        if(strings[mid].equals(val))
            return mid;

        if(start>end)
            return -1;

        //eliminate empty strings from search criteria
        int left = mid;
        int right = mid;
        if(strings[mid].isEmpty()) {

            while(strings[left].isEmpty())
                left--;

            while(strings[right].isEmpty())
                right++;
        }


        if(left>=start && val.compareTo(strings[left])<=0) {
            return find(strings,start,left, val);
        }
        else if(right<=end && val.compareTo(strings[right])>=0) {
            return find(strings,right,end, val);
        }

        return -1;
    }

    public static void main(String[] args) {
        StringSearch stringSearch = new StringSearch();
        String[] strings = new String[]{"at","","","","ball","","","","car","","","dad",""};

        System.out.println(stringSearch.find(strings,0, strings.length-1, "ball"));
    }
}
