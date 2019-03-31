package com.san.strings;

public class StringCompression {

    public String compressString(String str) {

        int count=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++) {
            char target = str.charAt(i);
            count=0;

            for(int j=i;j<str.length();j++) {

                if(str.charAt(j)==target)
                    count++;
                else
                    break;
            }

            sb.append(target);
            sb.append(count);
            i+=count-1;
        }

        return sb.length()>str.length() ? str : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression().compressString("aaabbcccc"));
    }
}
