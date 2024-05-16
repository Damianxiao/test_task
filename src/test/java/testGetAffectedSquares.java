import SJCE.xgui.Move;
import SJCE.xgui.PiecesUI;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class testGetAffectedSquares {

    public static int NORMAL_MOVE = 100;
    public static int CASTLE_MOVE = 101;
    public static int PROMOTION_MOVE = 102;
    public static int ENPASSANT_MOVE = 103;
    private short source;
    private short destination;
    private byte piece;
    private byte captured;
    private byte promoted;
    public static int WOO_CASTLE = 0;
    public static int WOOO_CASTLE = 1;
    public static int BOO_CASTLE = 2;
    public static int BOOO_CASTLE = 3;
    public static int ENPASSANT_CAPTURE = 80;
    private static byte[][] CASTLE = {{7, 5}, {0, 3}, {63, 61}, {56, 59}};
    public Move  move;

    private int[] castleRookMove() {
        switch(source + destination) {
            case 10: return new int[] {CASTLE[WOO_CASTLE][0], CASTLE[WOO_CASTLE][1],
                    PiecesUI.WHITE_ROOK};
            case 6: return new int[] {CASTLE[WOOO_CASTLE][0], CASTLE[WOOO_CASTLE][1],
                    PiecesUI.WHITE_ROOK};
            case 122: return new int[] {CASTLE[BOO_CASTLE][0], CASTLE[BOO_CASTLE][1],
                    PiecesUI.BLACK_ROOK};
            case 118: return new int[] {CASTLE[BOOO_CASTLE][0], CASTLE[BOOO_CASTLE][1],
                    PiecesUI.BLACK_ROOK};
        }
        return null;
    }


    @Test
    public void testGetAffectedSquares1(){
        // test path 1 2 3 6
        Move move = new Move(0, 1);
        int[] affectedSquares = move.getAffectedSquares(ENPASSANT_MOVE);
        assertTrue(affectedSquares.length == 3);
        System.out.println("Path 1 2 3 6 passed!");
    }


    @Test
    public void testGetAffectedSquare2(){
        // test path 1,2,4,5,7,9
        Move move = new Move(0, 10);
        int[] rookMove = move.castleRookMove();
        int[] affectedSquares = move.getAffectedSquares(CASTLE_MOVE);
        assertTrue(affectedSquares[2] == rookMove[0]);
        System.out.println("Path 1,2,4,5,7,9 passed!");
    }


    @Test
    public void testGetAffectedSquare3(){
        // test path 1,2,4,5,8,10
        Move move = new Move(0, 1);
        int[] affectedSquares = move.getAffectedSquares(999);
        assertTrue(affectedSquares[0] == 0);
        System.out.println("Path 1,2,4,5,8,10 passed!");
    }
}
