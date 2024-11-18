class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 2차원 배열 생성
        String[][] square = new String[park.length][park[0].length()]; // 배열 크기 수정
        // 2차원 배열 세팅 및 S의 위치를 찾는다
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < park.length; i++) {
            String[] strArr = park[i].split("");
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j].equals("S")) {
                    startX = j;
                    startY = i;
                }
                square[i][j] = strArr[j];
            }
        }

        int xMax = park[0].length();
        int yMax = park.length;

        // routes 배열에서 반복문을 돌면서 진행 방향 및 칸수를 조회
        for (String str : routes) {
            String[] strArr = str.split(" ");
            String direction = strArr[0];
            int step = Integer.parseInt(strArr[1]);

            int xPlus = 0;
            int yPlus = 0;
            boolean flag = false;

            // 이동을 시도하기 전에 경계 조건을 먼저 확인합니다
            for (int k = 1; k <= step; k++) {
                switch (direction) {
                    case "S": yPlus++; break;
                    case "N": yPlus--; break;
                    case "E": xPlus++; break;
                    case "W": xPlus--; break;
                }

                // 경계 조건을 먼저 확인합니다
                if ((startX + xPlus) >= xMax || (startX + xPlus) < 0 || (startY + yPlus) >= yMax || (startY + yPlus) < 0) {
                    flag = true;
                    break;
                }

                // 장애물 확인
                if (square[startY + yPlus][startX + xPlus].equals("X")) {
                    flag = true;
                    break;
                }
            }

            if (flag) continue; // 경계 조건 또는 장애물이 있는 경우 명령 무시

            // 이동할 수 있으면 위치 업데이트
            startY += yPlus;
            startX += xPlus;
        }

        int[] answer = {startY, startX}; // (y, x) 순서로 반환
        return answer;
    }
}
