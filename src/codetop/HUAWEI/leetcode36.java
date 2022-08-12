package codetop.HUAWEI;

/**
 * @ClassName leetcode36
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/15 15:47
 * @Version:1.0
 */

/**
 * 36. 有效的数独
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 */
public class leetcode36 {
    /**
     * 遍历数独。
           检查看到每个单元格值是否已经在当前的行 or列 的子数独中出现过：
           如果出现重复，返回 false。
           如果没有，则保留此值以进行进一步跟踪。
           返回 true。
      */
    public boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        int[][] row= new int[9][9];
        // 记录某列，某位数字是否已经被摆放
        int[][] col= new int[9][9];
        // 记录3*3的网格内,某个数字是否已经被摆放
        int[][] sbox=new int[9][9];
        int m=board.length;
        int n=board[0].length;
        for (int i=0;i<m;++i){
            for (int j=0;j<n;++j){
                if (board[i][j]!='.'){
                    int num=board[i][j]-'1';
                    //第i行已经出现num
                    if (row[i][num]==1){
                        return false;
                    }else{
                        row[i][num]=1;
                    }

                    if (col[j][num]==1){
                        return false;
                    }else{
                        col[j][num]=1;
                    }

                    int index_box = (i / 3) * 3 + j / 3;//子数独
                    if (sbox[index_box][num] == 1) {
                        return false;
                    } else {
                        sbox[index_box][num] = 1;
                    }
                }
            }
        }
        return true;

    }
}
