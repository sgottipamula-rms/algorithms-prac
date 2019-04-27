package com.san.algorithms.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class JobSequencing {

    class Job {
        String label;
        int profit;
        int deadline;
        public Job(String label, int profit, int deadline) {
            this.label = label;
            this.profit = profit;
            this.deadline = deadline;
        }
    }

    public List<Job> getBestJobs(List<Job> jobs, int slots) {

        LinkedList<Job> results = new LinkedList<>();

        jobs.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.profit<o2.profit)
                    return 1;
                if(o1.profit>o2.profit)
                    return -1;

                return 0;
            }
        });

        while( ! jobs.isEmpty()) {

            if(slots==0)
                break;

            if(jobs.get(0).deadline<=slots) {
                results.addFirst(jobs.remove(0));
                slots--;
            }
        }

        return results;
    }

    public void go() {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("J1",20,2));
        jobs.add(new Job("J2",15,2));
        jobs.add(new Job("J3",10,1));
        jobs.add(new Job("J4",5,3));
        jobs.add(new Job("J5",1,3));

        List<Job> tbd = getBestJobs(jobs,3);

        for(Job job : tbd) {
            System.out.println(job.label);
        }
    }

    public static void main(String[] args) {
        new JobSequencing().go();
    }
}
