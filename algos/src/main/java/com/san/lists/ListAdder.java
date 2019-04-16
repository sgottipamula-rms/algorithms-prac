package com.san.lists;

public class ListAdder {

    public SinglyLinkedList addem(Node sll1, Node sll2) {
        SinglyLinkedList result = new SinglyLinkedList();
        int carryOver = 0;

        while (true) {
            int val1, val2;
            val1 = sll1 == null ? 0 : sll1.getVal();
            val2 = sll1 == null ? 0 : sll2.getVal();

            if (val1 == 0 && val2 == 0 && carryOver == 0)
                break;

            int sum = val1 + val2 + carryOver;
            carryOver = 0;

            if (sum > 9) {
                int temp = sum;
                sum = temp % 10;
                temp = temp / 10;
                carryOver = temp % 10;
            }
            result.insertFirst(sum);
            sll1 = sll1.getNext();
            sll2 = sll2.getNext();
        }

        return result;
    }

}
