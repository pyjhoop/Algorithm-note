class Solution {
    public int[] solution(String[] park, String[] routes) {
        // 2차원 배열 생성
        String[][] square = new String[park.length][park[0].length()];
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
                square[i][j] = strArr[j]; // 올바른 순서로 설정
            }
        }

        int xMax = park[0].length();
        int yMax = park.length;

        // routes 배열에서 반복문을 돌면서 진행 방향 및 칸수를 조회
        for (String str : routes) {
            String[] strArr = str.split(" ");
            String direction = strArr[0];
            int step = Integer.parseInt(strArr[1]);

            if (direction.equals("E") || direction.equals("W")) {
                int finalX = direction.equals("E") ? startX + step : startX - step;
                if (finalX >= xMax || finalX < 0) {
                    continue;
                } else {
                    boolean flag = false;
                    for (int k = 1; k <= step; k++) {
                        int p = direction.equals("E") ? k : -k;
                        if (square[startY][startX + p].equals("X")) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) continue;
                    startX = finalX;
                }
            } else {
                int finalY = direction.equals("S") ? startY + step : startY - step;
                if (finalY >= yMax || finalY < 0) {
                    continue;
                } else {
                    boolean flag = false;
                    for (int k = 1; k <= step; k++) {
                        int p = direction.equals("S") ? k : -k;
                        if (square[startY + p][startX].equals("X")) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) continue;
                    startY = finalY;
                }
            }
        }

        int[] answer = {startY, startX}; // (y, x) 순서로 반환
        return answer;
    }
}