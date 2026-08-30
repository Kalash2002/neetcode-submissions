class Solution {
    public boolean isValidSudoku(char[][] board) {
         Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char ch = board[r][c];

                if (ch == '.')
                    continue;

                int box = (r / 3) * 3 + (c / 3);

                if (rows[r].contains(ch) ||
                    cols[c].contains(ch) ||
                    boxes[box].contains(ch))
                    return false;

                rows[r].add(ch);
                cols[c].add(ch);
                boxes[box].add(ch);
            }
        }

        return true;
    }
}

// Check rows and columns
        // for (int i = 0; i < 9; i++) {

        //     Set<Character> row = new HashSet<>();
        //     Set<Character> col = new HashSet<>();

        //     for (int j = 0; j < 9; j++) {

        //         // Row
        //         if (board[i][j] != '.') {
        //             if (row.contains(board[i][j]))
        //                 return false;
        //             row.add(board[i][j]);
        //         }

        //         // Column
        //         if (board[j][i] != '.') {
        //             if (col.contains(board[j][i]))
        //                 return false;
        //             col.add(board[j][i]);
        //         }
        //     }
        // }

        // // Check 3x3 boxes
        // for (int row = 0; row < 9; row += 3) {
        //     for (int col = 0; col < 9; col += 3) {

        //         Set<Character> box = new HashSet<>();

        //         for (int i = row; i < row + 3; i++) {
        //             for (int j = col; j < col + 3; j++) {

        //                 if (board[i][j] == '.')
        //                     continue;

        //                 if (box.contains(board[i][j]))
        //                     return false;

        //                 box.add(board[i][j]);
        //             }
        //         }
        //     }
        // }

        // return true;