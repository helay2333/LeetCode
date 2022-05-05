class Solution {
    public int uniquePaths(int m, int n) {
        //m表示列
        //n表示行
        int[][] arr = new int[m][n];
        for(int i = 0; i < n; i++){
            arr[0][i] = 1;
        }
        for(int j = 0; j < m; j++){
            arr[j][0] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }
        return arr[m - 1][n - 1];
    }
}