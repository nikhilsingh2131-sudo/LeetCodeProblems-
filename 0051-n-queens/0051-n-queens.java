class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> boards = new ArrayList<>();

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diags = new HashSet<>();
        Set<Integer> antiDiags = new HashSet<>();

        char[][] game = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(game[i], '.');
        }

        backtrack(0, cols, diags, antiDiags, boards, n, game);

        return boards;
    }

    public void backtrack(
        int row,
        Set<Integer> cols,
        Set<Integer> diags,
        Set<Integer> antiDiags,
        List<List<String>> boards,
        int n,
        char[][] game
    ) {

        // Base case
        if (row == n) {

            List<String> board = new ArrayList<>();

            for (char[] r : game) {
                board.add(new String(r));
            }

            boards.add(board);
            return;
        }

        // Try every column
        for (int col = 0; col < n; col++) {

            // Check column and diagonals
            if (cols.contains(col) ||
                diags.contains(row - col) ||
                antiDiags.contains(row + col)) {

                continue;
            }

            // Choose
            game[row][col] = 'Q';

            cols.add(col);
            diags.add(row - col);
            antiDiags.add(row + col);

            // Explore
            backtrack(
                row + 1,
                cols,
                diags,
                antiDiags,
                boards,
                n,
                game
            );

            // Undo / Backtrack
            game[row][col] = '.';

            cols.remove(col);
            diags.remove(row - col);
            antiDiags.remove(row + col);
        }
    }
}