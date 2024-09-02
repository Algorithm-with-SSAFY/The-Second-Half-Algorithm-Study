import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2109 {

	static class Class implements Comparable<Class> {
		int p,d,idx;

		public Class(int p, int d) {
			this.p = p;
			this.d = d;
		}

		@Override
		public int compareTo(Class o) {
			if(o.p==this.p) {
				return this.d-o.d;
			}
			return o.p-this.p;
		}

		@Override
		public String toString() {
			return "Class [p=" + p + ", d=" + d + ", idx=" + idx + "]";
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		Queue<Class> que = new PriorityQueue<>();
		for(int n=0;n<N;n++) {
			st=new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			que.add(new Class(p,d));
		}
		int max = 0;
		boolean visited[] = new boolean[100001];
		while(!que.isEmpty()) {
			Class q = que.poll();
			for(int d=q.d;d>=1;d--) {
				if(visited[d])continue;
				visited[d]=true;
				max+=q.p;
				break;
			}
			
		}
		System.out.println(max);
	}

}
