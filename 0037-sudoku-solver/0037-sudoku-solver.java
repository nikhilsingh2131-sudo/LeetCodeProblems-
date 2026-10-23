
class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    public boolean helper(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (char k = '1'; k <= '9'; k++) {

                        if (valid(board, i, j, k)) {
                            board[i][j] = k;

                            if (helper(board)) {
                                return true;
                            }

                            board[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public boolean valid(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == ch) {
                return false;
            }

            if (board[i][col] == ch) {
                return false;
            }

            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;

            if (board[r][c] == ch) {
                return false;
            }
        }

        return true;
    }
}
