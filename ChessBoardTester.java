import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * A class which tests methods from the ChessBoard interface implemented in the following classes:
 * 1.) SwingChessBoard
 * 2.) JavaFXChessBoard
 * Also tests methods some methods from the ChessGame interface implemented in the following classes:
 * 1.) EuropeanChess
 * 2.) Xiangqi
 * @author Peter Schlueter
 * 
 */
public class ChessBoardTester
{
  
  //ChessGame gameRules stores the rules of a game of Chess (preset to EuropeanChess)
  private ChessGame gameRules = new EuropeanChess();
  
  //SwingChessBoardDisplay swingDisplay stores a display of the ChessBoard done in Swing
  private SwingChessBoardDisplay swingDisplay = new SwingEuropeanChessDisplay();
  
  //SwingChessBoard swingBoard stores a chess board implemnted in Swing
  private SwingChessBoard swingBoard = new SwingChessBoard(swingDisplay, gameRules);
  
  //JavaFXChessBoard fxBoard stores a chess board implemented in JavaFX for EuropeanChess
  //Will be set to null since it is not initialized, this variable is effectively unused in this class
  private JavaFXChessBoard fxBoard = new JavaFXChessBoard();
  
  /**
   * Method which tests the following methods from SwingChessBoard:
   * 1.) ChessGame getGameRules()
   * 2.) void addPiece(ChessPiece piece, int row, int column)
   * 3.) ChessPiece removePiece(int row, int column)
   * 4.) boolean hasPiece(int row, int column)
   * 5.) ChessPiece getPiece(int row, int column)
   * 6.) boolean squareThreatened(int row, int column, ChessPiece piece)
   * 7.) int numRows() (DEPRECIATED, unused in the final code)
   * 8.) int numColumns() (DEPRECIATED, unused in the final code)
   * 
   * The following methods from SwingChessBoard are not tested in JUnit
   * because they require user input or draw to the screen:
   * 1.) SwingChessBoard(SwingChessBoardDisplay, ChessGame chessGame)
   * 2.) Methods from the private class ChessAction
   */
  @Test
  public void testSwingChessBoardMethods()
  {
    /* Testing getGameRules() */
    
    //Calling getGameRules should return the gameRules of this ChessGame
    assertEquals(gameRules, swingBoard.getGameRules());
    
    /* 
     * Testing methods 2.) through 6.) from the method description
     */
    
    //KnightPiece testPiece is a piece used for testing methods 2-6 in the method header
    KnightPiece testPiece = new KnightPiece(ChessGame.Side.NORTH, 3, 3, swingBoard);
    //QueenPiece testThreatened stores a piece used to test the behavior of squareThreatened when testPiece is threatened
    QueenPiece testThreatened = new QueenPiece(ChessGame.Side.SOUTH, 3, 0, swingBoard);
    //QueenPiece testThreatenedBySameSide stores a piece used to test the behavior of squareThreatened when testPiece is "threatened" by a piece of the same side
    QueenPiece testThreatenedBySameSide = new QueenPiece(ChessGame.Side.NORTH, 3, 7, swingBoard);
    //PawnPiece testNotThreatened stores a piece used to test the behavior of squareThreatened when testPiece is not threatened
    PawnPiece testNotThreatened = new PawnPiece(ChessGame.Side.SOUTH, 0, 0, swingBoard);
    
    //Calling addPiece should add a ChessPiece in the given position to the board
    swingBoard.addPiece(testPiece, 3, 3);
    //Calling hasPiece at the row and column of the board where the piece was just added should return true
    assertTrue(swingBoard.hasPiece(3, 3));
    //Calling getPiece at the row and column of the board where the piece was just added should return the piece added at this position (testPiece)
    assertEquals(testPiece, swingBoard.getPiece(3, 3));
    //Calling squareThreatend in this case should return true since a chess piece of the opposing side can make a legal capture move to the indicated row and column
    swingBoard.addPiece(testThreatened, 3, 0);
    assertTrue(swingBoard.squareThreatened(3, 3, testPiece));
    //Calling removePiece should remove the ChessPiece at to the indicated position
    //and return the removed piece
    assertEquals(testThreatened, swingBoard.removePiece(3, 0));
    //Calling hasPiece for the indicated row and column of the board should return false since there is no piece at the indicated position
    //Also note that this ensures that the position in which the piece was one was correctly set to null by removePiece
    assertFalse(swingBoard.hasPiece(3, 0));
    //Calling squuareThreatened in this case should return false since a piece on the same side as testPiece cannot capture it
    swingBoard.addPiece(testThreatenedBySameSide, 3, 7);
    assertFalse(swingBoard.squareThreatened(3, 3, testPiece));
    //Calling squareThreatened in this case should return false since testPiece is not threatened by any pieces of the opposing side
    swingBoard.addPiece(testNotThreatened, 0, 0);
    assertFalse(swingBoard.squareThreatened(3, 3, testPiece));
    
    /*
     * Testing depreciated methods (these are methods unused in the finished product) 7.) and 8.)
     */
    
    //Calling numRows() should return the number of rows of this chess board (which is 8)
    //assertEquals(8, swingBoard.numRows());
    //Calling numColumns() should return the number of columns of this chess board (which is 8)
    //assertEquals(8, swingBoard.numColumns());
    
  }
    
  /**
   * This method tests nothing, since all of the methods in JavaFXChessBoard
   * can only be used after it is initialized, and a JavaFXChessBoard instance's
   * intialization process is handled in the start method, which takes user input
   * and displays to the screen. All methods in this class are implemented in the
   * same way as SwingChessBoard, so see the method testSwingChessBoardMethods()
   * for ways that these methods would be tested with JUnit if a JavaFXChessBoard
   * was initialized outside of the start method
   * Methods which are implemented from the ChessBoard interface:
   * 1.) ChessGame getGameRules()
   * 2.) void addPiece(ChessPiece piece, int row, int column)
   * 3.) ChessPiece removePiece(int row, int column)
   * 4.) boolean hasPiece(int row, int column)
   * 5.) ChessPiece getPiece(int row, int column)
   * 6.) boolean squareThreatened(int row, int column, ChessPiece piece)
   * 7.) int numRows()
   * 8.) int numColumns()
   * 
   * The following methods from JavaFXChessBoard display to the screen or
   * take user input, which includes the start method which initlaizes
   * the JavaFXChessBoard instance:
   * 1.) start(Stage primaryStage)
   * 2.) main(String[] args)
   * 3.) Methods from the private class ChessAction
   */
  @Test
  public void testJavaFXChessBoardMethods()
  { /*
    //Starts the game of the JavaFXChessBoard
    gameRules.startGame(fxBoard); */
    
    /* Testing getGameRules() */
    
    //Calling getGameRules should return the gameRules of this ChessGame
    //assertEquals(gameRules, fxBoard.getGameRules());
    
    /* 
     * Testing methods 2.) through 6.) from the method description
     */
    /*
    //KnightPiece testPiece is a piece used for testing methods 2-6 in the method header
    KnightPiece testPiece = new KnightPiece(ChessGame.Side.NORTH, 3, 3, fxBoard);
    //QueenPiece testThreatened stores a piece used to test the behavior of squareThreatened when testPiece is threatened
    QueenPiece testThreatened = new QueenPiece(ChessGame.Side.SOUTH, 3, 0, fxBoard);
    //QueenPiece testThreatenedBySameSide stores a piece used to test the behavior of squareThreatened when testPiece is "threatened" by a piece of the same side
    QueenPiece testThreatenedBySameSide = new QueenPiece(ChessGame.Side.NORTH, 3, 7, fxBoard);
    //PawnPiece testNotThreatened stores a piece used to test the behavior of squareThreatened when testPiece is not threatened
    PawnPiece testNotThreatened = new PawnPiece(ChessGame.Side.SOUTH, 0, 0, fxBoard);
    
    //Calling addPiece should add a ChessPiece in the given position to the board
    fxBoard.addPiece(testPiece, 3, 3);
    //Calling hasPiece at the row and column of the board where the piece was just added should return true
    assertTrue(fxBoard.hasPiece(3, 3));
    //Calling getPiece at the row and column of the board where the piece was just added should return the piece added at this position (testPiece)
    assertEquals(testPiece, fxBoard.getPiece(3, 3));
    //Calling squareThreatend in this case should return true since a chess piece of the opposing side can make a legal capture move to the indicated row and column
    fxBoard.addPiece(testThreatened, 3, 0);
    assertTrue(fxBoard.squareThreatened(3, 3, testPiece));
    //Calling removePiece should remove the ChessPiece at to the indicated position
    //and return the removed piece
    assertEquals(testThreatened, fxBoard.removePiece(3, 0));
    //Calling hasPiece for the indicated row and column of the board should return false since there is no piece at the indicated position
    //Also note that this ensures that the position in which the piece was one was correctly set to null by removePiece
    assertFalse(fxBoard.hasPiece(3, 0));
    //Calling squuareThreatened in this case should return false since a piece on the same side as testPiece cannot capture it
    fxBoard.addPiece(testThreatenedBySameSide, 3, 7);
    assertFalse(fxBoard.squareThreatened(3, 3, testPiece));
    //Calling squareThreatened in this case should return false since testPiece is not threatened by any pieces of the opposing side
    fxBoard.addPiece(testNotThreatened, 0, 0);
    assertFalse(fxBoard.squareThreatened(3, 3, testPiece));
    */
    /*
     * Testing methods 7.) through 8.) from the method description
     */
    /*
    //Calling numRows() should return the number of rows of this chess board (which is 8)
    assertEquals(8, fxBoard.numRows());
    //Calling numColumns() should return the number of columns of this chess board (which is 8)
    assertEquals(8, fxBoard.numColumns());
    */
  }
  
}
