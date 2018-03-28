import java.util.ArrayList;

public class IOAssignment {
	
	ArrayList<ArrayList<Integer>> jobList = new ArrayList<ArrayList<Integer>>();
	int[][] arr = new int[16][3];
	
	int size = 0;
	int min = 50;
	
	public static void main(String ...strings){
		final IOAssignment IO = new IOAssignment();
		IO.addJob('A', 30, 50, 1);
		IO.addJob('B', 25, 75, 2);
		IO.addJob('C', 50, 100, 3);
		
		
	}
	
	public void calculateTime(int finish){
		int time = -1;
		while(++time <= finish){
		}
	}
	
	public void addJob(char c, int jobtime , int requesttime, int where){
		if(arr[where][0] == 0) return;
		arr[where][0] = c;	
		arr[where][1] = jobtime;
		arr[where][2] = requesttime;
		size++;
	}
	
	public void calculateNewRequests(int start, int finish){
		for(;start<=finish;start++){
			for(int i=0;i < size; i++){
				if(start % arr[i][2] == 0){
					if(jobList.get(i) == null){
						ArrayList<Integer> newlist = new ArrayList<Integer>();
						newlist.add(arr[i][0]);
						jobList.add(newlist);
					}else{
						jobList.get(i).add(arr[i][0]);
					}
				}
			}
		}
	}
	
	public void jobDone(int i){
		System.out.println(jobList.get(i).get(0));
		jobList.get(i).remove(0);
	}
}

