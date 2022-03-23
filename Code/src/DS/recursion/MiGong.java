package DS.recursion;

public class MiGong {
    public static void main(String[] args) {
        int[][] map= new int[8][7];
        //墙为1
        for(int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全为1
        for(int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板, 1表示
        map[3][1] = 1;
        map[3][2] = 1;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.println(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5] == 2) {
            return true;
        }
        return true;
    }
}
