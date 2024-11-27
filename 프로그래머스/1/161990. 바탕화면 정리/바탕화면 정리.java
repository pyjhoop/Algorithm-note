class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int minRow = Integer.MAX_VALUE;
        int maxRow = 0;
        int minColumn = Integer.MAX_VALUE;
        int maxColumn = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            String[] arr = wallpaper[i].split("");
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].equals("#")) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minColumn = Math.min(minColumn, j);
                    maxColumn = Math.max(maxColumn, j);
                }
            }
        }
        return new int[] { minRow, minColumn, maxRow + 1, maxColumn + 1 };
    }
}
