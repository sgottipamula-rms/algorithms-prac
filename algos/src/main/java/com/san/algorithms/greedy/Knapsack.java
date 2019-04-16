package com.san.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Knapsack {

    class Item {
        int weight;
        int profit;
        double profitPerUnitWeight;

        public Item(int profit, int weight) {
            this.weight = weight;
            this.profit = profit;

            this.profitPerUnitWeight = (double)profit/weight;
        }
    }

    class ItemToBeIncluded {
        double weight;
        double profit;
    }


    public List<ItemToBeIncluded> fillContainer(int containerMaxWeight, List<Item> items)
    {
        List<ItemToBeIncluded> result = new ArrayList<>();

        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {

                if(o1.profitPerUnitWeight==o2.profitPerUnitWeight)
                    return 0;

                if(o1.profitPerUnitWeight>o2.profitPerUnitWeight)
                    return -1;

                if(o1.profitPerUnitWeight<o2.profitPerUnitWeight)
                    return 1;

                return 0;
            }
        });


        double currentweight = 0;
        for(Item item : items) {

            int itemcount = 0;
            ItemToBeIncluded itemToBeIncluded = new ItemToBeIncluded();
            while(itemcount<item.weight) {
                if((currentweight+item.profitPerUnitWeight)>containerMaxWeight) {
                    break;
                }
                currentweight += item.profitPerUnitWeight;
                itemcount++;
                itemToBeIncluded.profit  += item.profitPerUnitWeight;
                itemToBeIncluded.weight +=1;
            }
            result.add(itemToBeIncluded);
        }

        return result;
    }

    public void go() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(10,2));
        items.add(new Item(5,3));
        items.add(new Item(15,5));
        items.add(new Item(7,7));
        items.add(new Item(6,1));
        items.add(new Item(18,4));
        items.add(new Item(3,1));

        List<ItemToBeIncluded> itemsToBeFilled = fillContainer(15,items);

        for(ItemToBeIncluded itemToBeIncluded : itemsToBeFilled) {
            System.out.println("---");
            System.out.println(itemToBeIncluded.profit);
            System.out.println(itemToBeIncluded.weight);
        }
    }


    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        knapsack.go();
    }

}
