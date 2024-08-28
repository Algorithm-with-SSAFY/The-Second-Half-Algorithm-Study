import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static project[] myproject;
	static int N, start_date,end_date;
	static boolean[] visit;
	
	static class project implements Comparable<project>{
		int start_month;
		int start_day;
		int end_month;
		int end_day;
		public project(int start_month, int start_day, int end_month, int end_day) {
			this.start_month = start_month;
			this.start_day = start_day;
			this.end_month = end_month;
			this.end_day = end_day;
		}
		@Override
		public int compareTo(project o) {
			// TODO Auto-generated method stub
			if(o.end_month==this.end_month) return o.end_day-this.end_day;
			return o.end_month-this.end_month;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		myproject = new project[N];
		start_date = date(3,1);
		end_date = date(11,30);
		
		for(int i = 0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start_month = Integer.parseInt(st.nextToken());
			int start_day = Integer.parseInt(st.nextToken());
			int end_month = Integer.parseInt(st.nextToken());
			int end_day = Integer.parseInt(st.nextToken());
			myproject[i] = new project(start_month,start_day,end_month,end_day);
		}
		
		Arrays.sort(myproject);
		visit = new boolean[N];
		int answer = 0;
		while(true) {
			if(!schedule()) {
				answer = 0;
				break;
			}
			answer++;
			if(start_date>end_date) break;
			
		}

		System.out.println(answer);
		

	}
	public static int date(int month, int day) {
		int result = day;
		for(int i = 1; i<month ; i++) {
			if(i == 2) result+=28;
			else if(i==4 || i==6 || i==9 || i==11) result+=30;
			else result+=31;
		}
		return result;
	}
	public static boolean schedule() {
		for(int i = 0 ; i<N ; i++) {
			if(!visit[i] && date(myproject[i].start_month,myproject[i].start_day)<=start_date) {
				visit[i] = true;
				start_date = date(myproject[i].end_month,myproject[i].end_day);
				return true;
			}
		}
		return false;
	}
	

}
