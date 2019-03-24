package com.san.strings;

import java.util.BitSet;

public class DeDup {

    public String removeDupes(String str)
    {
        BitSet bitSet = new BitSet(256);
        char[] charArrayOfString = str.toCharArray();

        for(int i=0;i<charArrayOfString.length;i++)
        {
            int bitSetIndex = (int)charArrayOfString[i];
            if(!bitSet.get(bitSetIndex))
            {
                bitSet.set(bitSetIndex);
            }
            else
            {
                charArrayOfString[i]='X';
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<charArrayOfString.length;i++)
        {
            char charInProgress = charArrayOfString[i];
            if(charInProgress!='X')
                sb.append(charArrayOfString[i]);
        }

        return sb.toString();
    }
}
