package greedy;

public class activitySelection {
    public static void ActivitySelection(int[] start,int end[]){
        //assuming both arrays are sorted with ascending end timings.
        int currEndTime = 0; //ensuring 1st activity is always selected as it ends earlier than all.
        int count=0;
        StringBuilder s = new StringBuilder();
        for(int i=0;i<start.length;i++){
            if(start[i]>=currEndTime){ //no overlapping activities are done
                currEndTime = end[i];
                count++;
                s = s.append("  A"+i);
            }
            
        }
        System.out.println("max activities: " + count);
        System.out.print("activities done are:"+s);
    }
    public static void main(String args[]){
        int start[] = {1,3,0,5,8,5};
        int end[]= {2,4,6,7,9,9};
        ActivitySelection(start, end);

    }
}
