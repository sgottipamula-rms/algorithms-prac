package com.san.lists;

import java.util.HashSet;
import java.util.Set;

public class DeDupList {

    Node head;

    public void dedupThis() {
        Node current = head;
        Set<Integer> setOfVals = new HashSet<Integer>();

        while (current != null) {
            if (!setOfVals.contains(current.getVal())) {
                setOfVals.add(current.getVal());
                current = current.getNext();
            } else {
                current.setVal(current.getNext().getVal());
                current.setNext(current.getNext().getNext());
            }
        }
    }

    public void dedupThisWithoutSet() {
        Node current = head;

        while (current != null) {
            int currentVal = current.getVal();
            Node runner = head;
            while (runner != null && runner != current) {
                if (runner.getVal() == currentVal) {
                    if (runner.getNext() != null) {
                        runner.setVal(runner.getNext().getVal());
                        runner.setNext(runner.getNext().getNext());
                        break;
                    }

                }
                runner = runner.getNext();
            }
            current = current.getNext();
        }
    }

}
