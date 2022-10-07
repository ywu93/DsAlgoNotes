package recursive;

/**
 * Use Divide and Conquer method to solve chessboard cover problem
 * <url><a href="https://undergroundmathematics.org/divisibility-and-induction/triominoes/solution">Triominoes</a></url>
 *
 * @author Ying Wu
 */
public class Chessboard {
    /**
     * the initial number of the L-shape tile
     */
    private int tile = 1;
    private static final int CHESSBOARD_SIZE = 8;
    private final int[][] board = new int[CHESSBOARD_SIZE][CHESSBOARD_SIZE];


    /**
     * @param tr   the row number of the start position
     * @param tc   the column number of the start position
     * @param dr   the row number of the special square
     * @param dc   the column number ot the special square
     * @param size the size of the chessboard
     */
    void chessBoard(int tr, int tc, int dr, int dc, int size) {
        if (size == 1)   // base condition, when the chessboard size is 1
            return;
        int t = tile++;
        int s = size / 2;    // the center of the chessboard
        //Check if the special square in the left-top part of the chessboard
        if (dr < tr + s && dc < tc + s)
            // in the left-top
            chessBoard(tr, tc, dr, dc, s);
        else {
            //if not, suppose the right-bottom square is the special square
            board[tr + s - 1][tc + s - 1] = t;
            chessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
        }
        //Check if the special square in the right-top part of the chessboard
        if (dr < tr + s && dc >= tc + s) {
            // yes
            chessBoard(tr, tc + s, dr, dc, s);
        } else {
            // if not, suppose the left-bottom square is the special square
            board[tr + s - 1][tc + s] = t;
            chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
        }
        //Check if the special square in the left-bottom part of the chessboard
        if (dr >= tr + s && dc < tc + s) {
            chessBoard(tr + s, tc, dr, dc, s);
        } else {
            board[tr + s][tc + s - 1] = t;
            chessBoard(tr + s, tc, tr + s, tc + s - 1, s);
        }
        //Check if the special square in the right-bottom part of the chessboard
        if (dr >= tr + s && dc >= tc + s) {
            chessBoard(tr + s, tc + s, dr, dc, s);
        } else {
            board[tr + s][tc + s] = t;
            chessBoard(tr + s, tc + s, tr + s, tc + s, s);

        }
    }

    public static void main(String[] args) {
        int tr = 0;
        int tc = 0;
        int dr = 0;
        int dc = 0;
        int size = 2;
        Chessboard cb = new Chessboard();
        cb.chessBoard(tr, tc, dr, dc, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(cb.board[i][j]);
            }

        }
    }
}
