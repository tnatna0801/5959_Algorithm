import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Player implements Comparable<Player>{
	int level;
	String nickname;
	
	public Player(int level, String nickname) {
		super();
		this.level = level;
		this.nickname = nickname;
	}

	// 닉네임 순으로 저장하기
	@Override
	public int compareTo(Player o) {
		return this.nickname.compareTo(o.nickname);
	}
	
}

class Room {
	
	// 이 방에 입장할 수 있는 레벨의 최솟값과 최댓값
	int min, max;
	
	// 참여한 플레이어 정보 - 우선순위 큐
	PriorityQueue<Player> players;
	public Room(int min, int max, PriorityQueue<Player> players) {
		super();
		this.min = min;
		this.max = max;
		this.players = players;
	}
	
	
}

public class BOJ_20006 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Room> rooms = new ArrayList<>();
		
		int l;
		String n;
		boolean newRoom;
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			n = st.nextToken();
			
			newRoom = true; // 방을 새로 만들어야 하는지 여부.
			for(Room room : rooms) { // 모든 방을 보면서
				if (room.players.size()<m && room.min<=l && l<= room.max) { // 현재 플레이어가 들어갈 수 있는 방이 있다면,
					newRoom = false; // 방을 새로 만들지 않고, 현재 방에 플레이어가 들어간다.
					room.players.add(new Player(l, n));
					break;
				}
			}
			
			// 방을 새로 만들어야 할 때
			if (newRoom) {
				Room room = new Room(l-10, l+10, new PriorityQueue<>());
				room.players.add(new Player(l, n));
				rooms.add(room);
			}
		}

		// 출력
		for(Room room : rooms) {
			if (room.players.size() == m) {
				sb.append("Started!").append("\n");
			}
			else {
				sb.append("Waiting!").append("\n");
			}
			
			while(!room.players.isEmpty()) {
				Player player = room.players.poll();
				sb.append(player.level).append(" ").append(player.nickname).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
}
