import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * A class which tests method from the ChessGame Hierarchy implemented in the following classes:
 * 1.) EuropeanChess
 * 2.) Xiangqi
 * @author Peter Schlueter
 * 
 */
public class ChessGameTester
{
  
  //ChessGame gameRules stores the rules of a game of Chess (preset to EuropeanChess)
  private ChessGame gameRules = new EuropeanChess();
  
  //SwingChessBoardDisplay swingDisplay stores a display of the ChessBoard done in Swing
  private SwingChessBoardDisplay swingDisplay = new SwingEuropeanChessDisplay();
  
  //SwingChessBoard swingBoard stores a chess board implemnted in Swing
  private SwingChessBoard swingBoard = new SwingChessBoard(swingDisplay, gameRules);
  
  //JavaFXChessBoard fxBoard stores a chess board implemented in JavaFX for EuropeanChess
  private JavaFXChessBoard fxBoard = new JavaFXChessBoard();
  
  /** 
   * Tests legalPieceToPlay(ChessPiece piece, int row, int column) from EuropeanChess class
   * Note that, by default, the starting player is always the one of the north side
   */
  @Test
  public void testLegalPieceToPlayEuroChess()
  {
    //PawnPiece testLegalToPlay stores a PawnPiece used to test this method (north side trying to use north side piece)
    PawnPiece testLegalToPlay = new PawnPiece(ChessGame.Side.NORTH, 4, 4, swingBoard);
    //PawnPiece testPieceIllegalToPlay stores a PawnPiece used to test this method (north side trying to use south side piece)
    PawnPiece testIllegalToPlay = new PawnPiece(ChessGame.Side.SOUTH, 4, 4, swingBoard);
    
    //Tests if the player on the north side is trying to use a piece of the north side that this is a legal piece to play
    assertTrue(gameRules.legalPieceToPlay(testLegalToPlay, 4, 4));
    //Tests if the player on the north side is trying to use a piece of the south side that this is not a legal piece to play
    assertFalse(gameRules.legalPieceToPlay(testIllegalToPlay, 4, 4));
  }
  
  /** 
   * Tests legalPieceToPlay(ChessPiece piece, int row, int column) from EuropeanChess class
   * Again, it is worth noting that, by default, the starting player is always the one on the north side
   */
  @Test
  public void testMakeMoveEuroChess()
  {
    //QueenPiece testNorthPiece stores a QueenPiece used to test condtions where the piece can move this turn
    QueenPiece testNorthPiece = new QueenPiece(ChessGame.Side.NORTH, 4, 4, swingBoard);
    swingBoard.addPiece(testNorthPiece, 4, 4);
    //PawnPiece testSouthPiece stores a PawnPiece used to test conditions where this piece will not move this turn
    PawnPiece testSouthPiece = new PawnPiece(ChessGame.Side.SOUTH, 4, 4, swingBoard);
    //PawnPiece testCapture storse a PawnPiece used to test conditions where the move being made is a legal capture move
    PawnPiece testCapture = new PawnPiece(ChessGame.Side.NORTH, 3, 0, swingBoard);
    swingBoard.addPiece(testCapture, 3, 0);
    
    //Tests If the player on the north side is trying to use a piece of the north side,
    //the piece is making a legal non capture move or legal capture move (legal non-capture move in this test),
    //and the player is of the north side, then the move is made and the player side is swapped to south
    assertTrue(gameRules.makeMove(testNorthPiece, 4, 5));
    assertTrue(!(testNorthPiece.getToBeUpgraded()));
    swingBoard.addPiece(testSouthPiece, 4, 1);
    //This test shows the player side has been set back to the south side (a player on the south side cannot play a piece of the north side)
    assertFalse(gameRules.legalPieceToPlay(testNorthPiece, 3, 0));
    //Tests If the player on the south side is trying to use a piece of the south side,
    //the piece is making a legal non capture move or legal capture move (legal capture move in this test),
    //the piece should be upgraded this turn, and the player is on the south side                                      
    //then the move is made, the pawn is upgraded and set to not be upgraded next turn, and the player is swapped to north
    assertTrue(gameRules.makeMove(testSouthPiece, 3, 0));
    assertTrue(testSouthPiece.getToBeUpgraded() == false);
    //This test shows the player side has been set back to the north side (a player on the north side cannot play a piece of the south side)
    assertFalse(gameRules.legalPieceToPlay(testSouthPiece, 3, 0));
    
    //Tests that this piece cannot be moved if it is not of the same side as the person currently trying to move it
    assertFalse(gameRules.makeMove(testSouthPiece, 3, 0));
    //Tests that this piece cannot be moved if the input location is not representative of a legal capture move or legal non capture move
    assertFalse(gameRules.makeMove(testNorthPiece, 0, 3));
  }
  
  /**
   * Tests getNumRows() from EuropeanChess
   */
  @Test
  public void testGetNumRowsEuroChess()
  {
    //Should return the number of rows in a EuropeanChess instance (which is 8 rows)
    assertEquals(8, gameRules.getNumRows());
  }
  
  /**
   * Tests getNumColumns from EuropeanChess
   */
  @Test
  public void testGetNumColumnsEuroChess()
  {
    //Should return the number of columsn in a EuropeanChess instance (which is 8 columns)
    assertEquals(8, gameRules.getNumColumns());
  }
  
  /**
   * Tests legalPieceToPlay from Xiangqi
   * Note that by default, the player that starts the game (i.e. has the first turn) will always be the player of the NORTH side
   */
  @Test
  public void testLegalPieceToPlayXiangqi()
  {
    //HorsePiece testLegalToPlay stores a HorsePiece used to test this method (north side trying to use north side piece)
    HorsePiece testLegalToPlay = new HorsePiece(ChessGame.Side.NORTH, 4, 4, swingBoard);
    //HorsePiece testPieceIllegalToPlay stores a HorsePiece used to test this method (north side trying to use south side piece)
    HorsePiece testIllegalToPlay = new HorsePiece(ChessGame.Side.SOUTH, 4, 4, swingBoard);
    
    //Tests if the player on the north side is trying to use a piece of the north side that this is a legal piece to play
    assertTrue(gameRules.legalPieceToPlay(testLegalToPlay, 4, 4));
    //Tests if the player on the north side is trying to use a piece of the south side that this is not a legal piece to play
    assertFalse(gameRules.legalPieceToPlay(testIllegalToPlay, 4, 4));
  }
  
  /**
   * Tests makeMove from Xiangqi and private method areNoPiecesBetweenKings(ChessPiece piece) from Xiangqi
   * Note that by default, the player that starts the game (i.e. has the first turn) will always be the player of the NORTH side
   */
  @Test
  public void testMakeMoveXiangqi()
  {
    gameRules = new Xiangqi();
    swingBoard = new SwingChessBoard(swingDisplay, gameRules);
    //XiangqiKingPiece testFacingKingsNorth stores a XiangqiKingPiece used to test that moves which create "facing kings" situations are prevented
    XiangqiKingPiece testFacingKingsNorth = new XiangqiKingPiece(ChessGame.Side.NORTH, 1, 4, swingBoard);
    swingBoard.addPiece(testFacingKingsNorth, 1, 4);
    //XiangqiKingPiece testFacingKingsSouth stores a XiangqiKingPiece used to test that moves which create "facing kings" situations are prevented
    XiangqiKingPiece testFacingKingsSouth = new XiangqiKingPiece(ChessGame.Side.SOUTH, 8, 4, swingBoard);
    swingBoard.addPiece(testFacingKingsSouth, 8, 4);
    //SoldierPiece betweenKings stores a SoldierPiece used to test that moves which create "facing kings" situations are prevented
    SoldierPiece betweenKings = new SoldierPiece(ChessGame.Side.NORTH, 4, 4, swingBoard);
    swingBoard.addPiece(betweenKings, 4, 4);
    //SoldierPiece testNorthPiece stores a SoldierKingPiece used to test condtions where a non-king piece can move this turn
    SoldierPiece testNorthPiece = new SoldierPiece(ChessGame.Side.NORTH, 3, 2, swingBoard);
    swingBoard.addPiece(testNorthPiece, 3, 2);
    //HorsePiece testSouthPiece stores a HorsePiece used to test conditions where this piece will not move this turn (does not include facing kings scenarios)
    HorsePiece testSouthPiece = new HorsePiece(ChessGame.Side.SOUTH, 3, 1, swingBoard);
    swingBoard.addPiece(testSouthPiece, 3, 1);
    //ElephantPiece testCapture storse an ElephantPiece used to test conditions where the move being made is a legal capture move
    ElephantPiece testCapture = new ElephantPiece(ChessGame.Side.NORTH, 5, 3, swingBoard);
    swingBoard.addPiece(testCapture, 5, 2);
    
    //Tests If the player on the north side is trying to use a piece of the north side,
    //the piece is making a legal non capture move or legal capture move (legal non-capture move in this test),
    //and the player is of the north side, then the move is made and the player side is swapped to south
    assertTrue(gameRules.makeMove(testNorthPiece, 4, 2));
    //This test shows the player side has been set back to the south side (a player on the south side cannot play a piece of the north side)
    assertFalse(gameRules.legalPieceToPlay(testNorthPiece, 4, 2));
    //Tests If the player on the south side is trying to use a piece of the south side,
    //the piece is making a legal non capture move or legal capture move (legal capture move in this test),
    //the piece should be upgraded this turn, and the player is on the south side                                      
    //then the move is made and the player is swapped to north
    assertTrue(gameRules.makeMove(testSouthPiece, 5, 2));
    //This test shows the player side has been set back to the north side (a player on the north side cannot play a piece of the south side)
    assertFalse(gameRules.legalPieceToPlay(testSouthPiece, 5, 2));
    
    //Tests that this piece cannot be moved if it is not of the same side as the person currently trying to move it
    assertFalse(gameRules.makeMove(testSouthPiece, 7, 3));
    //Tests that this piece cannot be moved if the input location is not representative of a legal capture move or legal non capture move
    assertFalse(gameRules.makeMove(testNorthPiece, 6, 7));
    
    /* The following section contains tests for moves which create "facing kings" situations */
    //This segment also tests the private method areNoPiecesBetweenKings(ChessPiece piece) from Xiangqi
    //The following moves should be allowed as they do not create facing kings situations
    assertTrue(gameRules.makeMove(betweenKings, 5, 4));           //Should allow this piece to move up one space since the kings cannot "see" each other
    assertTrue(gameRules.makeMove(testFacingKingsSouth, 7, 4));   //Should allow this piece to move forward one space since the kings cannot "see" each other
    assertTrue(gameRules.makeMove(testFacingKingsNorth, 0, 4));   //Should allow this piece to move back one space since the kings cannot "see" each other
    assertTrue(gameRules.makeMove(testFacingKingsSouth, 7, 3));   //Should allow this piece to move left one because the kings are not on the same column
    assertTrue(gameRules.makeMove(betweenKings, 5, 3));           //Should allow this piece to move left one space because the kings are not on the same column
    //The following moves, unless otherwise specified, should not be allowed as the create a facing kings situation
    assertFalse(gameRules.makeMove(testFacingKingsSouth, 7, 4));  //Should not be allowed to move right one space because the two kings can "see" each other (on same column with no pieces between them)
    gameRules.makeMove(betweenKings, 5, 4);                       //Resets position of betweenKings for following tests
    assertFalse(gameRules.makeMove(testFacingKingsNorth, 0, 3));  //Should not be allowed to move left one space because the two kings can "see" each other (on same column with no pieces between them)
    gameRules.makeMove(testFacingKingsSouth, 8, 3);               //Moves piece of SOUTH side so a piece on the NORTH side can be moved for the next test
    assertFalse(gameRules.makeMove(betweenKings, 5, 5));          //Should not be allowed to move right one space because the two kings can "see" each other (on same column with no pieces between them)
  }
  
  /**
   * Tests getNumRows() from Xiangqi
   */
  @Test
  public void testGetNumRowsXiangqi()
  {
    gameRules = new Xiangqi();
    //Should return the number of rows on a board in a game of Xiangqi (which is 10)
    assertEquals(10, gameRules.getNumRows());
  }
  
  /**
   * Tests getNumColumns() from Xiangqi
   */
  @Test
  public void testGetNumColumnsXiangqi()
  {
    gameRules = new Xiangqi();
    //Should return the number of columns on a board in a game of Xiangqi (which is 9)
    assertEquals(9, gameRules.getNumColumns());
  }
  
  /**
   * Tests startGame(ChessBoard board) from EuropeanChess
   */
  @Test
  public void testStartGameEuroChess()
  {
    //Calling startGame should set the pieces to the correct initial locations
    gameRules.startGame(swingBoard);
    /*
     * Each test below checks that each of the following are true for pieces of the NORTH side
     * 1.) These pieces are all of the correct type
     * 2.) These pieces are all of the NORTH side
     * 3.) These pieces are assigned to the correct row
     * 4.) These pieces are assigned to the correct column
     * 5.) These pieces are all on the correct chess board
     */
    assertTrue(swingBoard.getPiece(0, 0) instanceof RookPiece);
    assertTrue(swingBoard.getPiece(0, 0).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 0).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 0).getColumn() == 0);
    assertTrue(swingBoard.getPiece(0, 0).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 1) instanceof KnightPiece);
    assertTrue(swingBoard.getPiece(0, 1).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 1).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 1).getColumn() == 1);
    assertTrue(swingBoard.getPiece(0, 1).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 2) instanceof BishopPiece);
    assertTrue(swingBoard.getPiece(0, 2).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 2).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 2).getColumn() == 2);
    assertTrue(swingBoard.getPiece(0, 2).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 3) instanceof QueenPiece);
    assertTrue(swingBoard.getPiece(0, 3).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 3).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 3).getColumn() == 3);
    assertTrue(swingBoard.getPiece(0, 3).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 4) instanceof KingPiece);
    assertTrue(swingBoard.getPiece(0, 4).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 4).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 4).getColumn() == 4);
    assertTrue(swingBoard.getPiece(0, 4).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 5) instanceof BishopPiece);
    assertTrue(swingBoard.getPiece(0, 5).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 5).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 5).getColumn() == 5);
    assertTrue(swingBoard.getPiece(0, 5).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 6) instanceof KnightPiece);
    assertTrue(swingBoard.getPiece(0, 6).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 6).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 6).getColumn() == 6);
    assertTrue(swingBoard.getPiece(0, 6).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 7) instanceof RookPiece);
    assertTrue(swingBoard.getPiece(0, 7).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 7).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 7).getColumn() == 7);
    assertTrue(swingBoard.getPiece(0, 7).getChessBoard() == swingBoard);
    //Loop-Goal: Check all of the conditions for this section (described above) for pawn pieces
    for (int c = 0; c < swingBoard.getGameRules().getNumRows(); c++)
    {
      assertTrue(swingBoard.getPiece(1, c) instanceof PawnPiece);
      assertTrue(swingBoard.getPiece(1, c).getSide() == ChessGame.Side.NORTH);
      assertTrue(swingBoard.getPiece(1, c).getRow() == 1);
      assertTrue(swingBoard.getPiece(1, c).getColumn() == c);
      assertTrue(swingBoard.getPiece(1, c).getChessBoard() == swingBoard);
    }
    
    /*
     * Each test below checks that each of the following are true for pieces of the SOUTH side
     * 1.) These pieces are all of the correct type
     * 2.) These pieces are all of the SOUTH side
     * 3.) These pieces are assigned to the correct row
     * 4.) These pieces are assigned to the correct column
     * 5.) These pieces are all on the correct chess board
     */
    assertTrue(swingBoard.getPiece(7, 0) instanceof RookPiece);
    assertTrue(swingBoard.getPiece(7, 0).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 0).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 0).getColumn() == 0);
    assertTrue(swingBoard.getPiece(7, 0).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(7, 1) instanceof KnightPiece);
    assertTrue(swingBoard.getPiece(7, 1).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 1).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 1).getColumn() == 1);
    assertTrue(swingBoard.getPiece(7, 1).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(7, 2) instanceof BishopPiece);
    assertTrue(swingBoard.getPiece(7, 2).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 2).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 2).getColumn() == 2);
    assertTrue(swingBoard.getPiece(7, 2).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(7, 3) instanceof QueenPiece);
    assertTrue(swingBoard.getPiece(7, 3).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 3).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 3).getColumn() == 3);
    assertTrue(swingBoard.getPiece(7, 3).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(7, 4) instanceof KingPiece);
    assertTrue(swingBoard.getPiece(7, 4).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 4).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 4).getColumn() == 4);
    assertTrue(swingBoard.getPiece(7, 4).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(7, 5) instanceof BishopPiece);
    assertTrue(swingBoard.getPiece(7, 5).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 5).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 5).getColumn() == 5);
    assertTrue(swingBoard.getPiece(7, 5).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(7, 6) instanceof KnightPiece);
    assertTrue(swingBoard.getPiece(7, 6).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 6).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 6).getColumn() == 6);
    assertTrue(swingBoard.getPiece(7, 6).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(7, 7) instanceof RookPiece);
    assertTrue(swingBoard.getPiece(7, 7).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 7).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 7).getColumn() == 7);
    assertTrue(swingBoard.getPiece(7, 7).getChessBoard() == swingBoard);
    //Loop-Goal: Check that each piece in this row is a pawn piece (SOUTH side)
    for (int c = 0; c < swingBoard.getGameRules().getNumRows(); c++)
    {
      assertTrue(swingBoard.getPiece(6, c) instanceof PawnPiece);
      assertTrue(swingBoard.getPiece(6, c).getSide() == ChessGame.Side.SOUTH);
      assertTrue(swingBoard.getPiece(6, c).getRow() == 6);
      assertTrue(swingBoard.getPiece(6, c).getColumn() == c);
      assertTrue(swingBoard.getPiece(6, c).getChessBoard() == swingBoard);
    }
  }
  
  /**
   * Tests startGame(ChessBoard board) from Xiangqi
   */
  @Test
  public void testStartGameXiangqi()
  {
    gameRules = new Xiangqi();
    ChessBoard swingBoard = new SwingChessBoard(swingDisplay, gameRules);
    //Calling startGame should set the pieces to the correct initial locations
    gameRules.startGame(swingBoard);
    /*
     * Each test below checks that each of the following are true for pieces of the NORTH side
     * 1.) These pieces are all of the correct type
     * 2.) These pieces are all of the NORTH side
     * 3.) These pieces are assigned to the correct row
     * 4.) These pieces are assigned to the correct column
     * 5.) These pieces are all on the correct chess board
     */
    assertTrue(swingBoard.getPiece(0, 0) instanceof RookPiece);
    assertTrue(swingBoard.getPiece(0, 0).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 0).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 0).getColumn() == 0);
    assertTrue(swingBoard.getPiece(0, 0).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 1) instanceof HorsePiece);
    assertTrue(swingBoard.getPiece(0, 1).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 1).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 1).getColumn() == 1);
    assertTrue(swingBoard.getPiece(0, 1).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 2) instanceof ElephantPiece);
    assertTrue(swingBoard.getPiece(0, 2).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 2).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 2).getColumn() == 2);
    assertTrue(swingBoard.getPiece(0, 2).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 3) instanceof GuardPiece);
    assertTrue(swingBoard.getPiece(0, 3).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 3).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 3).getColumn() == 3);
    assertTrue(swingBoard.getPiece(0, 3).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 4) instanceof XiangqiKingPiece);
    assertTrue(swingBoard.getPiece(0, 4).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 4).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 4).getColumn() == 4);
    assertTrue(swingBoard.getPiece(0, 4).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 5) instanceof GuardPiece);
    assertTrue(swingBoard.getPiece(0, 5).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 5).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 5).getColumn() == 5);
    assertTrue(swingBoard.getPiece(0, 5).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 6) instanceof ElephantPiece);
    assertTrue(swingBoard.getPiece(0, 6).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 6).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 6).getColumn() == 6);
    assertTrue(swingBoard.getPiece(0, 6).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 7) instanceof HorsePiece);
    assertTrue(swingBoard.getPiece(0, 7).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 7).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 7).getColumn() == 7);
    assertTrue(swingBoard.getPiece(0, 7).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(0, 8) instanceof RookPiece);
    assertTrue(swingBoard.getPiece(0, 8).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(0, 8).getRow() == 0);
    assertTrue(swingBoard.getPiece(0, 8).getColumn() == 8);
    assertTrue(swingBoard.getPiece(0, 8).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(2, 1) instanceof CannonPiece);
    assertTrue(swingBoard.getPiece(2, 1).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(2, 1).getRow() == 2);
    assertTrue(swingBoard.getPiece(2, 1).getColumn() == 1);
    assertTrue(swingBoard.getPiece(2, 1).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(2, 7) instanceof CannonPiece);
    assertTrue(swingBoard.getPiece(2, 7).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(2, 7).getRow() == 2);
    assertTrue(swingBoard.getPiece(2, 7).getColumn() == 7);
    assertTrue(swingBoard.getPiece(2, 7).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(3, 0) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(3, 0).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(3, 0).getRow() == 3);
    assertTrue(swingBoard.getPiece(3, 0).getColumn() == 0);
    assertTrue(swingBoard.getPiece(3, 0).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(3, 2) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(3, 2).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(3, 2).getRow() == 3);
    assertTrue(swingBoard.getPiece(3, 2).getColumn() == 2);
    assertTrue(swingBoard.getPiece(3, 2).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(3, 4) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(3, 4).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(3, 4).getRow() == 3);
    assertTrue(swingBoard.getPiece(3, 4).getColumn() == 4);
    assertTrue(swingBoard.getPiece(3, 4).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(3, 6) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(3, 6).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(3, 6).getRow() == 3);
    assertTrue(swingBoard.getPiece(3, 6).getColumn() == 6);
    assertTrue(swingBoard.getPiece(3, 6).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(3, 8) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(3, 8).getSide() == ChessGame.Side.NORTH);
    assertTrue(swingBoard.getPiece(3, 8).getRow() == 3);
    assertTrue(swingBoard.getPiece(3, 8).getColumn() == 8);
    assertTrue(swingBoard.getPiece(3, 8).getChessBoard() == swingBoard);
    
    /*
     * Each test below checks that each of the following are true for pieces of the SOUTH side
     * 1.) These pieces are all of the correct type
     * 2.) These pieces are all of the SOUTH side
     * 3.) These pieces are assigned to the correct row
     * 4.) These pieces are assigned to the correct column
     * 5.) These pieces are all on the correct chess board
     */
    assertTrue(swingBoard.getPiece(9, 0) instanceof RookPiece);
    assertTrue(swingBoard.getPiece(9, 0).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(9, 0).getRow() == 9);
    assertTrue(swingBoard.getPiece(9, 0).getColumn() == 0);
    assertTrue(swingBoard.getPiece(9, 0).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(9, 1) instanceof HorsePiece);
    assertTrue(swingBoard.getPiece(9, 1).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(9, 1).getRow() == 9);
    assertTrue(swingBoard.getPiece(9, 1).getColumn() == 1);
    assertTrue(swingBoard.getPiece(9, 1).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(9, 2) instanceof ElephantPiece);
    assertTrue(swingBoard.getPiece(9, 2).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(9, 2).getRow() == 9);
    assertTrue(swingBoard.getPiece(9, 2).getColumn() == 2);
    assertTrue(swingBoard.getPiece(9, 2).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(9, 3) instanceof GuardPiece);
    assertTrue(swingBoard.getPiece(9, 3).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(9, 3).getRow() == 9);
    assertTrue(swingBoard.getPiece(9, 3).getColumn() == 3);
    assertTrue(swingBoard.getPiece(9, 3).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(9, 4) instanceof XiangqiKingPiece);
    assertTrue(swingBoard.getPiece(9, 4).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(9, 4).getRow() == 9);
    assertTrue(swingBoard.getPiece(9, 4).getColumn() == 4);
    assertTrue(swingBoard.getPiece(9, 4).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(9, 5) instanceof GuardPiece);
    assertTrue(swingBoard.getPiece(9, 5).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(9, 5).getRow() == 9);
    assertTrue(swingBoard.getPiece(9, 5).getColumn() == 5);
    assertTrue(swingBoard.getPiece(9, 5).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(9, 6) instanceof ElephantPiece);
    assertTrue(swingBoard.getPiece(9, 6).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(9, 6).getRow() == 9);
    assertTrue(swingBoard.getPiece(9, 6).getColumn() == 6);
    assertTrue(swingBoard.getPiece(9, 6).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(9, 7) instanceof HorsePiece);
    assertTrue(swingBoard.getPiece(9, 7).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(9, 7).getRow() == 9);
    assertTrue(swingBoard.getPiece(9, 7).getColumn() == 7);
    assertTrue(swingBoard.getPiece(9, 7).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(9, 8) instanceof RookPiece);
    assertTrue(swingBoard.getPiece(9, 8).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(9, 8).getRow() == 9);
    assertTrue(swingBoard.getPiece(9, 8).getColumn() == 8);
    assertTrue(swingBoard.getPiece(9, 8).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(7, 1) instanceof CannonPiece);
    assertTrue(swingBoard.getPiece(7, 1).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 1).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 1).getColumn() == 1);
    assertTrue(swingBoard.getPiece(7, 1).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(7, 7) instanceof CannonPiece);
    assertTrue(swingBoard.getPiece(7, 7).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(7, 7).getRow() == 7);
    assertTrue(swingBoard.getPiece(7, 7).getColumn() == 7);
    assertTrue(swingBoard.getPiece(7, 7).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(6, 0) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(6, 0).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(6, 0).getRow() == 6);
    assertTrue(swingBoard.getPiece(6, 0).getColumn() == 0);
    assertTrue(swingBoard.getPiece(6, 0).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(6, 2) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(6, 2).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(6, 2).getRow() == 6);
    assertTrue(swingBoard.getPiece(6, 2).getColumn() == 2);
    assertTrue(swingBoard.getPiece(6, 2).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(6, 4) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(6, 4).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(6, 4).getRow() == 6);
    assertTrue(swingBoard.getPiece(6, 4).getColumn() == 4);
    assertTrue(swingBoard.getPiece(6, 4).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(6, 6) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(6, 6).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(6, 6).getRow() == 6);
    assertTrue(swingBoard.getPiece(6, 6).getColumn() == 6);
    assertTrue(swingBoard.getPiece(6, 6).getChessBoard() == swingBoard);
    assertTrue(swingBoard.getPiece(6, 8) instanceof SoldierPiece);
    assertTrue(swingBoard.getPiece(6, 8).getSide() == ChessGame.Side.SOUTH);
    assertTrue(swingBoard.getPiece(6, 8).getRow() == 6);
    assertTrue(swingBoard.getPiece(6, 8).getColumn() == 8);
    assertTrue(swingBoard.getPiece(6, 8).getChessBoard() == swingBoard);
  }
  
}