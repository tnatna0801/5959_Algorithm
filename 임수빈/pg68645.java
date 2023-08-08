class Solution {
    public int[] solution(int n) {
        int[][] result = new int[n][n];

        // 이동 배열
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};

        // 방향을 바꾸는 횟수, 숫자를 채울 인덱스, 채울 숫자
        int cnt = 0, idx = 0, k = 1;
        // 현재 좌표
        int x = 0, y = 0;
        // 이동할 좌표
        int mx, my;

        // 배열 첫 번째 값 (1)
        result[x][y] = k++;

        while (cnt <= n) {
            // 좌표 이동
            mx = x + dx[idx];
            my = y + dy[idx];

            // 배열의 범위를 벗어났거나 이미 값이 존재하면 방향 바꾸기
            if (mx < 0 || mx >= n || my < 0 || my >= n || result[mx][my] != 0) {
                idx = (idx+1) > 2? 0 : idx+1;
                cnt++;
                continue;
            }

            // 값 넣기
            result[mx][my] = k++;

            // 현재 좌표 갱신
            x = mx;
            y = my;
        }

        // 정답 배열
        int[] answer = new int[result[x][y]];
        idx = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (result[i][j] != 0) {
                    answer[idx++] = result[i][j];
                }
            }
        }

        return answer;
    }
}
