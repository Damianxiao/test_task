
import SJCE.xgui.ChessTheme;
import SJCE.xgui.Move;
import SJCE.xgui.JPanel.BoardUI;
import SJCE.xgui.PiecesUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class testMove {
    private Move move;
    private int[] board;
    private PiecesUI piecesUI;

    @BeforeEach
    public void setUp() {
        move = new Move();
        board = new int[64];
        piecesUI = new PiecesUI();
    }

    /**
     * @Description :
     * test variable initialize
    */
    @Test
    public void testVariablesInitialize() {
        assertEquals(100, Move.NORMAL_MOVE);
        assertEquals(101, Move.CASTLE_MOVE);
        assertEquals(102, Move.PROMOTION_MOVE);
        assertEquals(103, Move.ENPASSANT_MOVE);
        assertEquals(0, Move.WOO_CASTLE);
        assertEquals(1, Move.WOOO_CASTLE);
        assertEquals(2, Move.BOO_CASTLE);
        assertEquals(3, Move.BOOO_CASTLE);
        assertEquals(80, Move.ENPASSANT_CAPTURE);
    }


    /*
     * @Description :
     * test construct move with 2 parameters
    */
    @Test
    public void testConstructInitialMove() {
        Move move = new Move(0, 1);
        assertEquals(0, move.getSource());
        assertEquals(1, move.getDestination());
        assertEquals(PiecesUI.NO_PIECE, move.getPiece());
    }

    /*
     * @Description :
     * test construct move with 3 parameters
    */
    @Test
    public void testConstructMove() {
        Move move = new Move(0, 1, 2);
        assertEquals(0, move.getSource());
        assertEquals(1, move.getDestination());
        assertEquals(2, move.getPiece());
    }

    /*
     * @Description :
     * test getter ang setter
    */
    @Test
    public void testGetterAndSetter() {
        move.setPiece(1);
        assertEquals(1, move.getPiece());
        move.setCaptured(2);
        assertEquals(2, move.getCaptured());
        move.setPromoted(3);
        assertEquals(3, move.getPromoted());
    }

    /*
     * @Description :
     * test domove
    */
    @Test
    public void testDomove(){
        board = PiecesUI.getBoard();
        board[move.getSource()] = PiecesUI.WHITE_PAWN;
        board[move.getDestination()] = PiecesUI.NO_PIECE;

        int moveType = move.doMove(board);

        assertEquals(Move.NORMAL_MOVE, moveType);
        assertEquals(PiecesUI.WHITE_PAWN, board[move.getDestination()]);
    }





}
