package greedy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.sound.midi.Sequence;

public class jobSequencing {
    public static class Job{
        int deadline;
        int profit;
        int id; //A,B,C....
        public Job(int deadline,int profit,int id){
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
        }

    }
    public static void PrintJobs(ArrayList<Job> jobs){
        for(int i=0;i<jobs.size();i++){
            System.out.println(jobs.get(i).id + ": " + "deadline:"+ jobs.get(i).deadline+ "  profit:"+ jobs.get(i).profit);
        }
    }
    public static void PrintSeq(ArrayList<Integer> seq){
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+ " ");
        }
    }
    
    public static void main(String args[]){
        int jobsInfo[][] = {{4,20}, {1,10}, {1,40}, {1,20}};
        ArrayList<Job> jobs = new ArrayList<>(); //created an object array of specified length;
        
        for(int i=0;i<jobsInfo.length;i++){
            jobs.add(new Job(jobsInfo[i][0], jobsInfo[i][1], i)) ; //filled the necessary details from given info in objects 
        }
        PrintJobs(jobs);
        //how to sort objects with comparators:
        Collections.sort(jobs, (a,b) -> b.profit-a.profit); //gives objects with decsending order of profits;
        int time = 0;
        ArrayList<Integer> seq = new ArrayList<>();
        for(int i=0;i<jobs.size();i++){
            Job curr = jobs.get(i);
            if(curr.deadline>time){
                time = time + curr.deadline;
                seq.add(curr.id);

            }
        }
        System.out.println("max jobs done: "+ seq.size());
        PrintSeq(seq);
    }    
}
