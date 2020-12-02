//Name: Song Soon Wee
//Student No.: A0200378L
//Collaboator: Neo Soon keat, Nicole Joseph
import java.util.PriorityQueue;

public class Driver {
    public static void main(String[] args){
        Kattio reader = new Kattio(System.in);
        int researchers = reader.getInt();
        int lockTimer = reader.getInt();
        int savedLogins = 0;
        PriorityQueue<Researcher> resQueue = new PriorityQueue<Researcher>(researchers, new ResearcherComparator());
        PriorityQueue<Workstation> workQueue = new PriorityQueue<Workstation>(1, new WorkstationComparator());
        for(int i = 0; i < researchers; i++){
            int arrivalTime = reader.getInt();
            int usageTime = reader.getInt();
            resQueue.add(new Researcher(arrivalTime, usageTime)); //Add researcher into res queue.
        }
        while(resQueue.peek()!= null){ //While the researcher queue is not empty
            Researcher currRes = resQueue.poll(); //Polled from smallest to biggest
            int arrivalTime = currRes.startTime;
            int endTime = currRes.endTime;
            if(workQueue.isEmpty()){
                workQueue.add(new Workstation(arrivalTime, endTime, lockTimer));
                continue; //Since first res is assigned a workstation, skip the loop.
            }
            while(!workQueue.isEmpty()){
                Workstation currWork = workQueue.peek();
                int workEndTime = currWork.availToUseTime;
                int workLockTime = currWork.expectedLockTime;
                if(arrivalTime < workEndTime){
                    workQueue.add(new Workstation(arrivalTime, endTime, lockTimer));
                    break;
                } else if(arrivalTime >= workEndTime && arrivalTime <= workLockTime){
                    workQueue.poll();
                    workQueue.add(new Workstation(arrivalTime, endTime, lockTimer));
                    savedLogins = savedLogins + 1;
                    break;
                } else{
                    workQueue.poll();
                }
            }
        }
        System.out.println(savedLogins);
        reader.close();
    }
}
