package com.san.stacks;

import sun.jvm.hotspot.memory.FreeChunk;

import java.util.Stack;

public class StackWithMax {

    class MaxFrequency {
        public Integer MAX;
        public Integer FREQUENCY;

        public MaxFrequency(Integer max) {
            this.MAX = max;
            this.FREQUENCY = 1;
        }

        public void incrementFrequency() {
            this.FREQUENCY++;
        }

        public void decrementFrequency() {
            this.FREQUENCY--;
        }

        public boolean isLastInstance() {
            return FREQUENCY == 1;
        }
    }

    Stack<Integer> elementStack = new Stack<Integer>();
    Stack<MaxFrequency> maxElementStack = new Stack<>();


    public void push(int val) {
        elementStack.push(val);

        if(maxElementStack.isEmpty())
            maxElementStack.push(new MaxFrequency(val));

        if(val > maxElementStack.peek().MAX) {
            maxElementStack.push(new MaxFrequency(val));
        }
        else if(maxElementStack.peek().MAX == val) {
            MaxFrequency maxFrequency = maxElementStack.pop();
            maxFrequency.incrementFrequency();
            maxElementStack.push(maxFrequency);
        }
    }

    public int pop() {
        Integer popItem = elementStack.pop();

        if(popItem == maxElementStack.peek().MAX) {
            MaxFrequency maxFrequency = maxElementStack.pop();

            if( ! maxFrequency.isLastInstance()) {
                maxFrequency.decrementFrequency();
                maxElementStack.push(maxFrequency);
            }

        }

        return popItem;
    }

    public Integer max() {
        return maxElementStack.peek().MAX;
    }


    public static void main(String[] args) {
        StackWithMax stackWithMax = new StackWithMax();

        stackWithMax.push(1);
        stackWithMax.push(3);
        stackWithMax.push(2);
        stackWithMax.push(5);
        stackWithMax.push(4);

        System.out.println(stackWithMax.pop());
        System.out.println(stackWithMax.max());

        System.out.println(stackWithMax.pop());
        System.out.println(stackWithMax.max());

        System.out.println(stackWithMax.pop());
        System.out.println(stackWithMax.max());

        System.out.println(stackWithMax.pop());
        System.out.println(stackWithMax.max());

        System.out.println(stackWithMax.pop());
        System.out.println(stackWithMax.max());


    }
}
