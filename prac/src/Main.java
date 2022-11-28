import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Deque<Integer> deque = new ArrayDeque<>();

		int buffer = in.nextInt();
		while(true){
			int num = in.nextInt();
			if(num == -1){
				break;
			}

			if(num == 0){
				Integer outNum = deque.removeFirst();
			}else{
				if(num > 0 && deque.size() < buffer){
					deque.add(num);
				}
			}
		}

		if(deque.isEmpty()){
			System.out.println("empty");
		}else{
			for (Integer numStr : deque) {
				System.out.print(numStr + " ");
			}
		}

	}
}