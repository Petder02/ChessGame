import org.junit.Test;
import static org.junit.Assert.*;


/**
 * 
 * A class which tests various methods from the ChessPiece hierarchy (note that this class tests all methods in Project 3
 * and all methods from the ChessPiece hierarchy in Project 5)
 * IMPORTANT NOTE TO THE READER: All direction/cardinality specifications (e.g. left, north-west, etc.) are from the perspective of a person
 * looking at the board from the bottom (the last row, which would be the south side) to the top (the first row, which would be the north side)
 * Secondary Note: Since the method moveDone() does nothing by design, it is not tested in this unit tester
 * @author Peter Schlueter
 * 
 */
public class ChessPieceTester
{
  //EuropeanChess gameRules stores the basic rules for this chess game (EuropeanChess)
  EuropeanChess gameRules = new EuropeanChess();
  
  //Xiangqi xiangqiGameRules stores the basic rules for a game of Xiangqi
  Xiangqi xiangqiGameRules = new Xiangqi();
  
  //EuropeanChessDisplay boardDisplay stores a chess board display instance
  SwingEuropeanChessDisplay boardDisplay = new SwingEuropeanChessDisplay();
  
  //SwingChessBoard board stores the chess game board
  //Note: This is the typical size of a chess board, being 8 squares x 8 squares
  SwingChessBoard board = new SwingChessBoard(boardDisplay, gameRules);
  
  //SwingChessBoard xiangqiBoard stores a chess game board for Xiangqi
  //Since this is used for the purpose of testing the pieces rather than the display, a SwingEuropeanChessDisplay is still used for the display of the board here
  SwingChessBoard xiangqiBoard = new SwingChessBoard(boardDisplay, xiangqiGameRules);
  
  /**
   * Tests all getters and setters in ChessPiece, which are listed below
   * 1.) setHasMoved(boolean hasMoved) and getHasMoved()
   * 2.) setLocation(int row, int column), getRow(), and getColumn()
   * 3.) setToBeRemoved(boolean toBeRemoved) and getToBeRemoved()
   * 4.) setToBeUpgraded(boolean toBeUpgraded) and getToBeUpgraded()
   * 5.) getChessBoard()
   * 6.) getIcon()
   * 7.) getLabel()
   * 8.) getSide()
   */
  @Test
  public void testGettersAndSetters()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the getter/setter methods of chess piece
    ChessPiece testPiece = new KnightPiece(ChessGame.Side.NORTH, 0, 0, board);
    
    /* Setters are called in this section, tested via calling the getter methods which should return the values set by the setter methods here */
    
    //Should set the value for whether or not the piece has moved this game
    testPiece.setHasMoved(true);
    //Should set the row and collumn of the piece to the specified value for each
    testPiece.setLocation(1, 1);
    //Should set the value for whether or not the piece should be removed
    testPiece.setToBeRemoved(true);
    //Should set the value for wheter or not the piece should be upgraded
    testPiece.setToBeUpgraded(true);
    
    /* Getters tested in this section */
    
    //Should get the board the piece is on set by the contructor
    assertEquals(board, testPiece.getChessBoard());
    //Should get the column the piece was set to be on by setLocation()
    assertEquals(1, testPiece.getColumn());
    //Should get the value set by setHasMoved() for whether or not the piece has moved this game
    assertEquals(true, testPiece.getHasMoved());
    //Should get the icon of the piece set by the constructor
    assertEquals(null, testPiece.getIcon());
    //Should get the label of the piece set by the constructor
    assertEquals("N", testPiece.getLabel());
    //Should get the row the piece was set to be on by setLocation()
    assertEquals(1, testPiece.getRow());
    //Should get the side of the piece set by the contructor
    assertEquals(ChessGame.Side.NORTH, testPiece.getSide());
    //Sould get the value set by setToBeRemoved() for whether or not the piece should be removed
    assertEquals(true, testPiece.getToBeRemoved());
    //Should get the value set by setToBeUpgraded() for whether or not the piece should be upgraded
    assertEquals(true, testPiece.getToBeUpgraded());
    
    
  }
  
  /**
   * Tests the contructor for ChessPiece
   */
  @Test
  public void testChessPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the ChessPiece constructor
    //It is worth noting that since all classes extending ChessPiece call its constructor in their constructors,
    //all subclasses of ChessPiece will properly test the ChessPiece constructor
    ChessPiece testPiece = new KnightPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "N" for a KnightPiece instance of a ChessPiece
    assertEquals("N", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a KnightPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /**
   * Tests the contructor for a KnightPiece
   */
  @Test
  public void testKnightPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the KnightPiece constructor
    ChessPiece testPiece = new KnightPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "N" for a KnightPiece instance of a ChessPiece
    assertEquals("N", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a KnightPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /**
   * Tests the contructor for a RookPiece
   */
  @Test
  public void testRookPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the RookPiece constructor
    ChessPiece testPiece = new RookPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "R" for a RookPiece instance of a ChessPiece
    assertEquals("R", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a RookPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /**
   * Tests the contructor for a BishopPiece
   */
  @Test
  public void testBishopPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the BishopPiece constructor
    ChessPiece testPiece = new BishopPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "B" for a BishopPiece instance of a ChessPiece
    assertEquals("B", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a BishopPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /**
   * Tests the contructor for a QueenPiece
   */
  @Test
  public void testQueenPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the QueenPiece constructor
    ChessPiece testPiece = new QueenPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "Q" for a QueenPiece instance of a ChessPiece
    assertEquals("Q", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a QueenPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /**
   * Tests the contructor for a KingPiece
   */
  @Test
  public void testKingPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the KingPiece constructor
    ChessPiece testPiece = new KingPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "K" for a KingPiece instance of a ChessPiece
    assertEquals("K", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a KingPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /**
   * Tests the contructor for a PawnPiece
   */
  @Test
  public void testPawnPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the PawnPiece constructor
    ChessPiece testPiece = new PawnPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "P" for a PawnPiece instance of a ChessPiece
    assertEquals("P", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a PawnPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /**
   * Tests isLMove(int toRow, int toColumn, ChessPiece piece) from the interface LMove
   */
  @Test
  public void testIsLMove()
  {
    //ChessPiece testPiece stores a chess piece used for testing this method
    KnightPiece testPiece = new KnightPiece(ChessGame.Side.NORTH, 4, 4, board);
    
    //The following tests should return true if the input location is up/down two spaces, over one space
    assertTrue(testPiece.isLMove(6, 5, testPiece));
    assertTrue(testPiece.isLMove(6, 3, testPiece));
    assertTrue(testPiece.isLMove(2, 5, testPiece));
    assertTrue(testPiece.isLMove(2, 3, testPiece));
    //The following tests should return true if the input location is up/down one space, over two spaces
    assertTrue(testPiece.isLMove(5, 6, testPiece));
    assertTrue(testPiece.isLMove(5, 2, testPiece));
    assertTrue(testPiece.isLMove(3, 6, testPiece));
    assertTrue(testPiece.isLMove(3, 2, testPiece));
    //This test should return false since the input location is not a valid L-Move
    assertFalse(testPiece.isLMove(0, 0, testPiece));
  }
  
  /**
   * Tests isVerticalMove(int toRow, toColumn, ChessPiece piece) from VerticalMove interface
   */
  @Test
  public void testIsVerticalMove()
  {
    //RookPiece testUpward stores a RookPiece used for testing general cases and cases where the piece attempts to move upward
    RookPiece testUpward = new RookPiece(ChessGame.Side.NORTH, 4, 4, board);
    //RookPiece testDownward stores a RookPiece used for testing cases where the piece attempts to move downward
    RookPiece testDownward = new RookPiece(ChessGame.Side.NORTH, 3, 3, board);
    //KnightPiece downHitDetection will store a KnightPiece used for testing that a vertical move is not legal if there is a piece between the input location and the current location
    KnightPiece downHitDetection = new KnightPiece(ChessGame.Side.NORTH, 1, 4, board);
    //Must add the piece to the board as otherwise all spaces on the board would be null
    testUpward.getChessBoard().addPiece(downHitDetection, 1, 4);
    //KnightPiece upHitDetection will store a KnightPiece used for testing that a vertical move is not legal if there is a piece between the input location and the current location
    KnightPiece upHitDetection = new KnightPiece(ChessGame.Side.NORTH, 6, 3, board);
    //Must add the piece to the board as otherwise all spaces on the board would be null
    testDownward.getChessBoard().addPiece(upHitDetection, 6, 3);
    
    //Is not a vertical move if the current column and input column do not match
    assertFalse(testUpward.isVerticalMove(0, 0, testUpward));
    //Is not a vertical move if the input position is the same as the current one
    assertFalse(testUpward.isVerticalMove(4, 4, testUpward));
    //Is a vertical move if the piece moves one space in the upward direction
    assertTrue(testUpward.isVerticalMove(3, 4, testUpward));
    //Is a vertical move if the piece moves multiple spaces in the upward direction
    assertTrue(testUpward.isVerticalMove(2, 4, testUpward));
    //Is not a vertical move if there is a piece between the inputted column and the one the piece is on
    assertFalse(testUpward.isVerticalMove(0, 4, testUpward));
    //Is a vertical move if the piece moves one space in the downward direction
    assertTrue(testDownward.isVerticalMove(4, 3, testDownward));
    //Is a vertical move if the piece moves multiple spaces in the downward direction
    assertTrue(testDownward.isVerticalMove(5, 3, testDownward));
    //Is not a vertical move if there is a piece between the inputted column and the one the piece is on 
    assertFalse(testDownward.isVerticalMove(7, 3, testDownward));
  }
  
  /**
   * Tests isHorizontalMove(int toRow, toColumn, ChessPiece piece) from HorizontalMove interface
   */
  @Test
  public void testIsHorizontalMove()
  {
    //RookPiece testLeftward stores a RookPiece used for testing general cases and cases where the piece attempts to move leftward
    RookPiece testLeftward = new RookPiece(ChessGame.Side.NORTH, 4, 4, board);
    //RookPiece testRight stores a RookPiece used for testing cases where the piece attempts to move rightward
    RookPiece testRightward = new RookPiece(ChessGame.Side.NORTH, 3, 3, board);
    //KnightPiece leftHitDetection will store a KnightPiece used for testing that a horizontal move is not legal if there is a piece between the input location and the current location
    KnightPiece leftHitDetection = new KnightPiece(ChessGame.Side.NORTH, 4, 1, board);
    //Must add the piece to the board as otherwise all spaces on the board would be null
    testLeftward.getChessBoard().addPiece(leftHitDetection, 4, 1);
    //KnightPiece rightHitDetection will store a KnightPiece used for testing that a horizontal move is not legal if there is a piece between the input location and the current location
    KnightPiece rightHitDetection = new KnightPiece(ChessGame.Side.NORTH, 3, 6, board);
    //Must add the piece to the board as otherwise all spaces on the board would be null
    testRightward.getChessBoard().addPiece(rightHitDetection, 3, 6);
    
    //Is not a horizontal move if the current row and input row do not match
    assertFalse(testLeftward.isHorizontalMove(0, 0, testLeftward));
    //Is not a horizontal move if the input position is the same as the current one
    assertFalse(testLeftward.isHorizontalMove(4, 4, testLeftward));
    //Is a horizontal move if the piece moves one space in the leftward direction
    assertTrue(testLeftward.isHorizontalMove(4, 3, testLeftward));
    //Is a horizontal move if the piece moves multiple spaces in the leftward direction
    assertTrue(testLeftward.isHorizontalMove(4, 2, testLeftward));
    //Is not a horizontal move if there is a piece between the inputted row and the one the piece is on
    assertFalse(testLeftward.isHorizontalMove(4, 0, testLeftward));
    //Is a horizontal move if the piece moves one space in the rightward direction
    assertTrue(testRightward.isHorizontalMove(3, 4, testRightward));
    //Is a horizontal move if the piece moves multiple spaces in the rightward direction
    assertTrue(testRightward.isHorizontalMove(3, 5, testRightward));
    //Is not a horizontal move if there is a piece between the inputted row and the one the piece is on 
    assertFalse(testRightward.isHorizontalMove(3, 7, testRightward));
  }
  
  /**
   * Tests isDiagonalMove(int toRow, toColumn, ChessPiece piece) from DiagonalMove interface
   */
  @Test
  public void testIsDiagonalMove()  //This test will fail at current due to current constants
  {
    //ChessBoard diagonalBoard stores a 9 x 9 chess board which makes testing this method easier
    SwingChessBoard diagonalBoard = new SwingChessBoard(boardDisplay, gameRules);
    //BishopPiece testDiagonal stores a BishopPiece used for testing all cases in this method
    BishopPiece testDiagonal = new BishopPiece(ChessGame.Side.NORTH, 4, 4, diagonalBoard);
    //KnightPiece southEastHitDetection will store a KnightPiece used for testing that a diagonal move is not legal if there is a piece between the input location and the current location
    KnightPiece southEastHitDetection = new KnightPiece(ChessGame.Side.NORTH, 7, 7, diagonalBoard);
    //Must add the piece to the board as otherwise all spaces on the board would be null
    testDiagonal.getChessBoard().addPiece(southEastHitDetection, 7, 7);
    //KnightPiece northEastDetection will store a KnightPiece used for testing that a diagonal move is not legal if there is a piece between the input location and the current location
    KnightPiece northEastHitDetection = new KnightPiece(ChessGame.Side.NORTH, 1, 7, diagonalBoard);
    //Must add the piece to the board as otherwise all spaces on the board would be null
    testDiagonal.getChessBoard().addPiece(northEastHitDetection, 1, 7);
    //KnightPiece southWestHitDetection will store a KnightPiece used for testing that a diagonal move is not legal if there is a piece between the input location and the current location
    KnightPiece southWestHitDetection = new KnightPiece(ChessGame.Side.NORTH, 7, 1, diagonalBoard);
    //Must add the piece to the board as otherwise all spaces on the board would be null
    testDiagonal.getChessBoard().addPiece(southWestHitDetection, 7, 1);
    //KnightPiece northWestHitDetection will store a KnightPiece used for testing that a diagonal move is not legal if there is a piece between the input location and the current location
    KnightPiece northWestHitDetection = new KnightPiece(ChessGame.Side.NORTH, 1, 1, diagonalBoard);
    //Must add the piece to the baord as otherwise all spaces on the board would be null
    testDiagonal.getChessBoard().addPiece(northWestHitDetection, 1, 1);
    
    //First, test must be implimented checking if the inputted move is diagonal to the original position (in report: a test must be implimented checking if the absolute value...)
    //Should return false for reasons stated in previous line comment
    assertFalse(testDiagonal.isDiagonalMove(4, 0, testDiagonal));
    //Second, test if the piece can move zero, one, or more than one spaces in the south east direction
    assertFalse(testDiagonal.isDiagonalMove(4, 4, testDiagonal));
    assertTrue(testDiagonal.isDiagonalMove(5, 5, testDiagonal));
    assertTrue(testDiagonal.isDiagonalMove(6, 6, testDiagonal));
    //Third, test that the piece cannot move south east if there is a piece between its destination and current location
    assertFalse(testDiagonal.isDiagonalMove(8, 8, testDiagonal));
    //Fourth, test if the piece can move zero, one or more than one spaces in the north east direction
    assertFalse(testDiagonal.isDiagonalMove(4, 4, testDiagonal));
    assertTrue(testDiagonal.isDiagonalMove(3, 5, testDiagonal));
    assertTrue(testDiagonal.isDiagonalMove(2, 6, testDiagonal));
    //Fifth, test that the piece cannot move north east if there is a piece between its destination and current location
    assertFalse(testDiagonal.isDiagonalMove(0, 8, testDiagonal));
    //Sixth, test if the piece can move zero, one, or more than one spaces in the south west direction
    assertFalse(testDiagonal.isDiagonalMove(4, 4, testDiagonal));
    assertTrue(testDiagonal.isDiagonalMove(5, 3, testDiagonal));
    assertTrue(testDiagonal.isDiagonalMove(6, 2, testDiagonal));
    //Seventh, test that the piece cannot move south west if there is a piece between its destination and current location
    assertFalse(testDiagonal.isDiagonalMove(8, 0, testDiagonal));
    //Eighth, test if the piece can move zero, one, or more than one spaces in the north west direction
    assertFalse(testDiagonal.isDiagonalMove(4, 4, testDiagonal));
    assertTrue(testDiagonal.isDiagonalMove(3, 3, testDiagonal));
    assertTrue(testDiagonal.isDiagonalMove(2, 2, testDiagonal));
    //Ninth and finally, test that the piece cannot move north west if there is a piece between its destination and current location
    assertFalse(testDiagonal.isDiagonalMove(0, 0, testDiagonal));
  }
  
  /**
   * Tests isOmniDirectionalOneSpaceMove(int toRow, int toColumn, ChessPiece piece)
   */
  @Test
  public void testIsOmniDirectionalOneSpaceMove()
  {
    //KingPiece testPiece stores a KingPiece used to test this method
    KingPiece testPiece = new KingPiece(ChessGame.Side.NORTH, 4, 4, board);
    
    //Should be a legal omni direcitonal one space move if the piece moves left one space
    assertTrue(testPiece.isOmniDirectionalOneSpaceMove(3, 4, testPiece));
    //Should be a legal omni direcitonal one space move if the piece moves right one space
    assertTrue(testPiece.isOmniDirectionalOneSpaceMove(5, 4, testPiece));
    //Should be a legal omni direcitonal one space move if the piece moves up one space
    assertTrue(testPiece.isOmniDirectionalOneSpaceMove(4, 5, testPiece));
    //Should be a legal omni direcitonal one space move if the piece moves down one space
    assertTrue(testPiece.isOmniDirectionalOneSpaceMove(4, 3, testPiece));
    //Should be a legal omni direcitonal one space move if the piece moves south east one space
    assertTrue(testPiece.isOmniDirectionalOneSpaceMove(5, 5, testPiece));
    //Should be a legal omni direcitonal one space move if the piece moves north east one space
    assertTrue(testPiece.isOmniDirectionalOneSpaceMove(3, 5, testPiece));
    //Should be a legal omni directional one space move if the piece moves south west one space
    assertTrue(testPiece.isOmniDirectionalOneSpaceMove(5, 3, testPiece));
    //Should be a legal omni direcitonal one space move if the piece moves north west one space
    assertTrue(testPiece.isOmniDirectionalOneSpaceMove(3, 3, testPiece));
    //Should not be an omni directional onespace move if the piece does not move one space in any direction
    assertFalse(testPiece.isOmniDirectionalOneSpaceMove(0, 0, testPiece));
  }
  
  /**
   *  Tests isCastleMove(int toRow, intToColumn, ChessPiece piece)
   * Also, SE = south east, NE = north east, SW = south west, and NW = north west
   */
  @Test
  public void testIsCastleMove()
  {
    //KingPiece testMovement stores a KingPiece testing if the king has moved this game
    KingPiece testKingMovement = new KingPiece(ChessGame.Side.NORTH, 0, 4, board);
    board.addPiece(testKingMovement, 0, 4);
    testKingMovement.isLegalNonCaptureMove(1, 4);
    //KingPiece testKingNorth stores a KingPiece testing castle move validity on the north side of the board
    KingPiece testKingNorth = new KingPiece(ChessGame.Side.NORTH, 0, 4, board);
    board.addPiece(testKingNorth, 0, 4);
    //KingPiece testKingSouth stores a KingPiece testing castle move validity on the south side of the board
    KingPiece testKingSouth = new KingPiece(ChessGame.Side.SOUTH, 7, 4, board);
    board.addPiece(testKingSouth, 7, 4);
    //All of the following are KnightPiece's which are used to test that a piece cannot castle if a piece other than a rook is in the corner of the board they are trying to move to
    
    /* In all of the following pieces defined here, the row and column assigned to the piece does not matter since it will be added to the board at a defined point anyway */
    
    //All of the following are KnightPiece's which are used to test that a piece cannot castle if a piece other than a rook is in the corner of the board they are trying to move to
    KnightPiece testIsRookSE = new KnightPiece(ChessGame.Side.NORTH, 7, 7, board);
    KnightPiece testIsRookNE = new KnightPiece(ChessGame.Side.NORTH, 0, 7, board);
    KnightPiece testIsRookSW = new KnightPiece(ChessGame.Side.NORTH, 7, 0, board);
    KnightPiece testIsRookNW = new KnightPiece(ChessGame.Side.NORTH, 0, 0, board);
    board.addPiece(testIsRookSE, 7, 7);
    board.addPiece(testIsRookNE, 0, 7);
    board.addPiece(testIsRookSW, 7, 0);
    board.addPiece(testIsRookNW, 0, 0);
    //All of the following are RookPiece's which are used to test that a piece cannot castle if a piece at this corner of the board is of the opposing side
    RookPiece testIsSameSideSE = new RookPiece(ChessGame.Side.NORTH, 7, 7, board);
    RookPiece testIsSameSideNE = new RookPiece(ChessGame.Side.SOUTH, 0, 7, board);
    RookPiece testIsSameSideSW = new RookPiece(ChessGame.Side.NORTH, 7, 0, board);
    RookPiece testIsSameSideNW = new RookPiece(ChessGame.Side.SOUTH, 0, 0, board);
    //All of the following are RookPiece's which are used to test that a piece cannot castle if the piece at this corner of the board has moved this game
    RookPiece testRookMovementSE = new RookPiece(ChessGame.Side.NORTH, 7, 7, board);
    RookPiece testRookMovementNE = new RookPiece(ChessGame.Side.NORTH, 0, 7, board);
    RookPiece testRookMovementSW = new RookPiece(ChessGame.Side.NORTH, 7, 0, board);
    RookPiece testRookMovementNW = new RookPiece(ChessGame.Side.NORTH, 0, 0, board);
    //All of the following are KnightPiece's which are used to test that a piece cannot castle if there are many pieces between the king and the piece at this spot on the board
    KnightPiece testManySE = new KnightPiece(ChessGame.Side.NORTH, 7, 7, board);
    KnightPiece testManyNE = new KnightPiece(ChessGame.Side.NORTH, 0, 7, board);
    KnightPiece testManySW = new KnightPiece(ChessGame.Side.NORTH, 7, 0, board);
    KnightPiece testManyNW = new KnightPiece(ChessGame.Side.NORTH, 0, 0, board);
    //All of the following are KnightPiece's which are used to test that a piece cannot castle if there is one piece between the king and the piece at this spot
    KnightPiece testOneSE = new KnightPiece(ChessGame.Side.NORTH, 7, 7, board);
    KnightPiece testOneNE = new KnightPiece(ChessGame.Side.NORTH, 0, 7, board);
    KnightPiece testOneSW = new KnightPiece(ChessGame.Side.NORTH, 7, 0, board);
    KnightPiece testOneNW = new KnightPiece(ChessGame.Side.NORTH, 0, 0, board);
    //All of the following are KnightPiece's which are used to test that a piece cannot castle if many spaces between the king and the rook are threatened
    QueenPiece testManyThreatenedSE = new QueenPiece(ChessGame.Side.NORTH, 7, 7, board);
    QueenPiece testManyThreatenedNE = new QueenPiece(ChessGame.Side.SOUTH, 0, 7, board);
    QueenPiece testManyThreatenedSW = new QueenPiece(ChessGame.Side.NORTH, 7, 0, board);
    QueenPiece testManyThreatenedNW = new QueenPiece(ChessGame.Side.SOUTH, 0, 0, board);
    //All of the following are KnightPiece's which are used to test that a piece cannot castle if one space between the king and the rook are threatened
    RookPiece testOneThreatenedSE = new RookPiece(ChessGame.Side.NORTH, 7, 7, board);
    RookPiece testOneThreatenedNE = new RookPiece(ChessGame.Side.SOUTH, 0, 7, board);
    RookPiece testOneThreatenedSW = new RookPiece(ChessGame.Side.NORTH, 7, 0, board);
    RookPiece testOneThreatenedNW = new RookPiece(ChessGame.Side.SOUTH, 0, 0, board);
    //All of the following are KnightPiece's which are used to test that a piece can castle if there are zero pieces between the king and the piece at this spot
    //and zero spaces between the king and this spot are threatened (this would mean that none of the conditions in the method return false for the specified direction
    RookPiece testZeroSE = new RookPiece(ChessGame.Side.SOUTH, 7, 7, board);
    RookPiece testZeroNE = new RookPiece(ChessGame.Side.NORTH, 0, 7, board);
    RookPiece testZeroSW = new RookPiece(ChessGame.Side.SOUTH, 7, 0, board);
    RookPiece testZeroNW = new RookPiece(ChessGame.Side.NORTH, 0, 0, board);
    
    //First, test if that a castle move does not move two spaces to the right or left and/or the piece does not move horizontally across the same row
    assertFalse(testKingNorth.isCastleMove(4, 4, testKingNorth));
    //Before the rest of the tests, check if the king has moved at all this game
    assertFalse(testKingMovement.isCastleMove(0, 2, testKingMovement));
    board.removePiece(1, 4);
    
    /* All of the following tests apply to a piece attempting to castle on the north east side */

    //1.) Check if the piece at this corner of the board is a rook
    assertFalse(testKingNorth.isCastleMove(0, 6, testKingNorth));
    board.removePiece(0, 7);
    //2.) Check if the piece at this corner of the board is on the opposing side
    board.addPiece(testIsSameSideNE, 0, 7);
    assertFalse(testKingNorth.isCastleMove(0, 6, testKingNorth));
    board.removePiece(0, 7);
    //3.) Check if the piece at this corner of the board has moved this game
    board.addPiece(testRookMovementNE, 0, 7);
    testRookMovementNE.isLegalNonCaptureMove(0, 6);
    testRookMovementNE.isLegalNonCaptureMove(0, 7);
    assertFalse(testKingNorth.isCastleMove(0, 6, testKingNorth));
    board.removePiece(0, 7);
    //4a.) Check if there are many pieces in between the piece in this corner of the board and the king
    board.addPiece(testManyNE, 0, 7);
    board.addPiece(testManyNE, 0, 6);
    board.addPiece(testManyNE, 0, 5);
    assertFalse(testKingNorth.isCastleMove(0, 6, testKingNorth));
    board.removePiece(0, 7);
    board.removePiece(0, 6);
    //4b.) Check if there is one piece in between the piece in this corner of the board and the king
    board.addPiece(testOneNE, 0, 7);
    assertFalse(testKingNorth.isCastleMove(0, 6, testKingNorth));
    board.removePiece(0, 7);
    board.removePiece(0, 5);
    //5a.) Check if there are many squares threatened between the piece in this corner of the board and the king
    board.addPiece(testManyThreatenedNE, 0, 7);
    board.addPiece(testManyThreatenedNE, 1, 6);
    board.addPiece(testManyThreatenedNE, 1, 5);
    assertFalse(testKingNorth.isCastleMove(0, 6, testKingNorth));
    board.removePiece(0, 7);
    board.removePiece(1, 6);
    //5b.) Check if there is one square threatened between the piece in this corner of the board and the king
    board.addPiece(testOneThreatenedNE, 0, 7);
    assertFalse(testKingNorth.isCastleMove(0, 6, testKingNorth));
    board.removePiece(0, 7);
    board.removePiece(1, 5);
    //4c, 5c., and by proxy 6.): Check if there are zero spaces threatened between the piece in this corner and the king
    //and there there are zero pieces on the board between the this piece and the king
    board.addPiece(testZeroNE, 0, 7);
    assertTrue(testKingNorth.isCastleMove(0, 6, testKingNorth));
    board.removePiece(0, 7);
    
    /* All of the following tests apply to a piece attempting to castle on the north west side */

    //1.) Check if the piece at this corner of the board is a rook
    assertFalse(testKingNorth.isCastleMove(0, 2, testKingNorth));
    board.removePiece(0, 0);
    //2.) Check if the piece at this corner of the board is on the opposing side
    board.addPiece(testIsSameSideNW, 0, 0);
    assertFalse(testKingNorth.isCastleMove(0, 2, testKingNorth));
    board.removePiece(0, 0);
    //3.) Check if the piece at this corner of the board has moved this game
    board.addPiece(testRookMovementNW, 0, 0);
    testRookMovementNW.isLegalNonCaptureMove(0, 1);
    testRookMovementNW.isLegalNonCaptureMove(0, 0);
    assertFalse(testKingNorth.isCastleMove(0, 2, testKingNorth));
    board.removePiece(0, 0);
    //4a.) Check if there are many pieces in between the piece in this corner of the board and the king
    board.addPiece(testManyNW, 0, 0);
    board.addPiece(testManyNW, 0, 1);
    board.addPiece(testManyNW, 0, 2);
    assertFalse(testKingNorth.isCastleMove(0, 2, testKingNorth));
    board.removePiece(0, 0);
    board.removePiece(0, 1);
    //4b.) Check if there is one piece in between the piece in this corner of the board and the king
    board.addPiece(testOneNW, 0, 0);
    assertFalse(testKingNorth.isCastleMove(0, 2, testKingNorth));
    board.removePiece(0, 0);
    board.removePiece(0, 2);
    //5a.) Check if there are many squares threatened between the piece in this corner of the board and the king
    board.addPiece(testManyThreatenedNW, 0, 0);
    board.addPiece(testManyThreatenedNW, 1, 1);
    board.addPiece(testManyThreatenedNW, 1, 2);
    assertFalse(testKingNorth.isCastleMove(0, 2, testKingNorth));
    board.removePiece(0, 0);
    board.removePiece(1, 1);
    //5b.) Check if there is one square threatened between the piece in this corner of the board and the king
    board.addPiece(testOneThreatenedNW, 0, 0);
    assertFalse(testKingNorth.isCastleMove(0, 2, testKingNorth));
    board.removePiece(0, 0);
    board.removePiece(1, 2);
    //4c, 5c., and by proxy 6.): Check if there are zero spaces threatened between the piece in this corner and the king
    //and there there are zero pieces on the board between the this piece and the king
    board.addPiece(testZeroNW, 0, 0);
    assertTrue(testKingNorth.isCastleMove(0, 2, testKingNorth));
    board.removePiece(0, 0);
    
    /* All of the following tests apply to a piece attempting to castle on the south east side */
    
    //1.) Check if the piece at this corner of the board is a rook
    assertFalse(testKingSouth.isCastleMove(7, 6, testKingSouth));
    board.removePiece(7, 7);
    //2.) Check if the piece at this corner of the board is on the opposing side
    board.addPiece(testIsSameSideSE, 7, 7);
    assertFalse(testKingSouth.isCastleMove(7, 6, testKingSouth));
    board.removePiece(7, 7);
    //3.) Check if the piece at this corner of the board has moved this game
    board.addPiece(testRookMovementSE, 7, 7);
    testRookMovementSE.isLegalNonCaptureMove(7, 6);
    testRookMovementSE.isLegalNonCaptureMove(7, 7);
    assertFalse(testKingSouth.isCastleMove(7, 6, testKingSouth));
    board.removePiece(7, 7);
    //4a.) Check if there are many pieces in between the piece in this corner of the board and the king
    board.addPiece(testManySE, 7, 7);
    board.addPiece(testManySE, 7, 6);
    board.addPiece(testManySE, 7, 5);
    assertFalse(testKingSouth.isCastleMove(7, 6, testKingSouth));
    board.removePiece(7, 7);
    board.removePiece(7, 6);
    //4b.) Check if there is one piece in between the piece in this corner of the board and the king
    board.addPiece(testOneSE, 7, 7);
    assertFalse(testKingSouth.isCastleMove(7, 6, testKingSouth));
    board.removePiece(7, 7);
    board.removePiece(7, 5);
    //5a.) Check if there are many squares threatened between the piece in this corner of the board and the king
    board.addPiece(testManyThreatenedSE, 7, 7);
    board.addPiece(testManyThreatenedSE, 6, 6);
    board.addPiece(testManyThreatenedSE, 6, 5);
    assertFalse(testKingSouth.isCastleMove(7, 6, testKingSouth));
    board.removePiece(7, 7);
    board.removePiece(6, 6);
    //5b.) Check if there is one square threatened between the piece in this corner of the board and the king
    board.addPiece(testOneThreatenedSE, 7, 7);
    assertFalse(testKingSouth.isCastleMove(7, 6, testKingSouth));
    board.removePiece(7, 7);
    board.removePiece(6, 5);
    //4c, 5c., and by proxy 6.): Check if there are zero spaces threatened between the piece in this corner and the king
    //and there there are zero pieces on the board between the this piece and the king
    board.addPiece(testZeroSE, 7, 7);
    assertTrue(testKingSouth.isCastleMove(7, 6, testKingSouth));
    board.removePiece(7, 7);
    
    /* All of the following tests apply to a piece attempting to castle on the south west side */

    //1.) Check if the piece at this corner of the board is a rook
    assertFalse(testKingSouth.isCastleMove(7, 2, testKingSouth));
    board.removePiece(7, 0);
    //2.) Check if the piece at this corner of the board is on the opposing side
    board.addPiece(testIsSameSideSW, 7, 0);
    assertFalse(testKingSouth.isCastleMove(7, 2, testKingSouth));
    board.removePiece(7, 0);
    //3.) Check if the piece at this corner of the board has moved this game
    board.addPiece(testRookMovementSW, 7, 0);
    testRookMovementSW.isLegalNonCaptureMove(7, 1);
    testRookMovementSW.isLegalNonCaptureMove(7, 0);
    assertFalse(testKingSouth.isCastleMove(7, 2, testKingSouth));
    board.removePiece(7, 0);
    //4a.) Check if there are many pieces in between the piece in this corner of the board and the king
    board.addPiece(testManySW, 7, 0);
    board.addPiece(testManySW, 7, 1);
    board.addPiece(testManySW, 7, 2);
    assertFalse(testKingSouth.isCastleMove(7, 2, testKingSouth));
    board.removePiece(7, 0);
    board.removePiece(7, 1);
    //4b.) Check if there is one piece in between the piece in this corner of the board and the king
    board.addPiece(testOneSW, 7, 0);
    assertFalse(testKingSouth.isCastleMove(7, 2, testKingSouth));
    board.removePiece(7, 0);
    board.removePiece(7, 2);
    //5a.) Check if there are many squares threatened between the piece in this corner of the board and the king
    board.addPiece(testManyThreatenedSW, 7, 0);
    board.addPiece(testManyThreatenedSW, 6, 1);
    board.addPiece(testManyThreatenedSW, 6, 2);
    assertFalse(testKingSouth.isCastleMove(7, 2, testKingSouth));
    board.removePiece(7, 0);
    board.removePiece(6, 1);
    //5b.) Check if there is one square threatened between the piece in this corner of the board and the king
    board.addPiece(testOneThreatenedSW, 7, 0);
    assertFalse(testKingSouth.isCastleMove(7, 2, testKingSouth));
    board.removePiece(7, 0);
    board.removePiece(6, 2);
    //4c, 5c., and by proxy 6.): Check if there are zero spaces threatened between the piece in this corner and the king
    //and there there are zero pieces on the board between the this piece and the king
    board.addPiece(testZeroSW, 7, 0);
    assertTrue(testKingSouth.isCastleMove(7, 2, testKingSouth));
    board.removePiece(7, 0);
  }
  
  /**
   *  Tests isPawnMove(int toRow, intToColumn, ChessPiece piece)
   * Also, SE = south east, NE = north east, SW = south west, and NW = north west
   */
  @Test
  public void testIsPawnMove()
  {
    //PawnPiece testNorth is used for testing the legality of one space pawn moves starting on the north side
    PawnPiece testNorth = new PawnPiece(ChessGame.Side.NORTH, 1, 4, board);
    //PawnPiece testSouth is used for testing the legality of one space pawn moves starting on the south side
    PawnPiece testSouth = new PawnPiece(ChessGame.Side.SOUTH, 7, 7, board);
    //PawnPiece testNorthFirstMove is used for testing the legality of two space pawn moves starting on the north side
    PawnPiece testNorthFirstMove = new PawnPiece(ChessGame.Side.NORTH, 1, 6, board);
    //PawnPiece testSouthFirstMove is used for testing the legality of two space pawn moves starting on the north side
    PawnPiece testSouthFirstMove = new PawnPiece(ChessGame.Side.SOUTH, 7, 7, board);
    //PawnPiece testNorthDiagonalMove is used for testing 
    //the legality of one space diagonal pawn moves starting on the north side
    PawnPiece testNorthDiagonalMove = new PawnPiece(ChessGame.Side.NORTH, 3, 5, board);
    //PawnPiece testSouthDiagonalMove is used for testing 
    //the legality of one space diagonal pawn moves starting on the north side
    PawnPiece testSouthDiagonalMove = new PawnPiece(ChessGame.Side.SOUTH, 4, 5, board);
    //PawnPiece testUpgrade is used for testing if a pawn is set to be upgraded when it reaches the opposing side
    PawnPiece testUpgrade = new PawnPiece(ChessGame.Side.NORTH, 6, 7, board);
    //This method call will return true, as shown in the unit tests below (moving piece one space forward is legal for a pawn)
    testUpgrade.isPawnMove(7, 7, testUpgrade);
    
    /* This section tests the legality of pawn moves made by pawns on the north side of the board */
    
    //Refer to 4.) in testing report: All of these tests check that toBeUpgraded is set to true in the tests that return true
    //Tests that if a pawn attempts to move one space forward, this is a pawn move
    assertTrue(testNorth.isPawnMove(2, 4, testNorth));
    assertTrue(testUpgrade.getToBeUpgraded());
    //Tests that if a pawn attempts to move two spaces forward, this is a pawn move
    assertTrue(testNorthFirstMove.isPawnMove(3, 6, testNorthFirstMove));
    assertTrue(testUpgrade.getToBeUpgraded());
    //Tests that if a pawn attempts to move one space diagonally, it can only do so if there is an opponent piece on that part of the board
    testNorthDiagonalMove.getChessBoard().addPiece(testNorthDiagonalMove, 3, 5);
    testNorthDiagonalMove.getChessBoard().addPiece(testSouth, 4, 4);
    testNorthDiagonalMove.getChessBoard().addPiece(testSouth, 4, 6);
    assertTrue(testNorthDiagonalMove.isPawnMove(4, 4, testNorthDiagonalMove));
    assertTrue(testUpgrade.getToBeUpgraded());
    testNorthDiagonalMove.getChessBoard().removePiece(4, 4);
    testNorthDiagonalMove.getChessBoard().addPiece(testNorthDiagonalMove, 3, 5);
    assertTrue(testNorthDiagonalMove.isPawnMove(4, 6, testNorthDiagonalMove));
    assertTrue(testUpgrade.getToBeUpgraded());
    testNorthDiagonalMove.getChessBoard().removePiece(4, 6);
    testNorthDiagonalMove.getChessBoard().removePiece(4, 4);
    testNorthDiagonalMove.getChessBoard().removePiece(3, 5);
    testSouth.setLocation(7, 7);
    
    /* This section tests the legality of pawn moves made by pawns on the south side of the board */
    
    //Refer to 4.) in testing report: All of these tests check that toBeUpgraded is set to true in the tests that return true
    //Tests that if a pawn attempts to move one space forward, this is a pawn move
    assertTrue(testSouth.isPawnMove(6, 7, testSouth));
    assertTrue(testUpgrade.getToBeUpgraded());
    //Tests that if a pawn attempts to move two spaces forward, this is a pawn move
    assertTrue(testSouthFirstMove.isPawnMove(5, 7, testSouthFirstMove));
    assertTrue(testUpgrade.getToBeUpgraded());
    //Tests that if a pawn attempts to move one space diagonally, it can only do so if there is an opponent piece on that part of the board
    testSouthDiagonalMove.getChessBoard().addPiece(testSouthDiagonalMove, 4, 5);
    testSouthDiagonalMove.getChessBoard().addPiece(testNorth, 3, 4);
    testSouthDiagonalMove.getChessBoard().addPiece(testNorth, 3, 6);
    assertTrue(testSouthDiagonalMove.isPawnMove(3, 4, testSouthDiagonalMove));
    assertTrue(testUpgrade.getToBeUpgraded());
    testSouthDiagonalMove.getChessBoard().removePiece(4, 5);
    testSouthDiagonalMove.getChessBoard().addPiece(testSouthDiagonalMove, 4, 5);
    assertTrue(testSouthDiagonalMove.isPawnMove(3, 6, testSouthDiagonalMove));
    assertTrue(testUpgrade.getToBeUpgraded());
    
    /* :Last two tests: Check to make sure that a move is not a legal pawn move if none of the above conditions are fulfilled
     * or if the piece tries to move two spaces forward if it has already moved once this game */
    assertFalse(testNorth.isPawnMove(0, 0, testNorth));
    assertFalse(testSouthFirstMove.isPawnMove(3, 7, testSouthFirstMove));
  }
  
  /**
   * Tests isLegalMove(int toRow, int toColumn) from the KnightPiece Class
   */
  @Test
  public void testKnightPieceIsLegalMove()
  {
    //ChessPiece testPiece stores a KnightPiece used for testing this method
    KnightPiece testPiece = new KnightPiece(ChessGame.Side.NORTH, 0, 1, board);
    board.addPiece(testPiece, 0, 1);
    
    //Should return false if the player tries to move the piece out of bounds/off the board
    assertFalse(testPiece.isLegalMove(900, 900));
    //Should return false if the player tries to not move the piece at all
    assertFalse(testPiece.isLegalMove(0, 1));
    //Should return true if the player inputs a legal move for a knight (isLMove() returns true)
    assertTrue(testPiece.isLegalMove(1, 3));
    //Should return false if the player inputs an illegal move for a knight (isLMove() returns false)
    assertFalse(testPiece.isLegalMove(6, 6));
  }
  
  /**
   * Tests isLegalMove(int toRow, int toColumn) from the RookPiece Class
   */
  @Test
  public void testRookPieceIsLegalMove()
  {
    //ChessPiece testPiece stores a RookPiece used for testing this method
    RookPiece testPiece = new RookPiece(ChessGame.Side.NORTH, 0, 0, board);
    board.addPiece(testPiece, 0, 0);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testPiece.isLegalMove(900, 900));
    //Should return false if the player tries to not move the piece at all
    assertFalse(testPiece.isLegalMove(0, 0));
    //Should return true if the player inputs a legal vertical move (isVerticalMove() returns true)
    assertTrue(testPiece.isLegalMove(0, 6));
    //Should return true if the player inputs a legal horizontal move (isHorizontalMove() returns true)
    assertTrue(testPiece.isLegalMove(6, 0));
    //Should return false if, given the inputted destination is on the board and is not in the same spot as the piece currently is,
    //the move is not legal for a rook
    assertFalse(testPiece.isLegalMove(4, 4));
  }
  
  /**
   * Tests isLegalMove(int toRow, int toColumn) from the BishopPiece Class
   */
  @Test
  public void testBishopPieceIsLegalMove()
  {
    //ChessPiece testPiece stores a BishopPiece used for testing this method
    BishopPiece testPiece = new BishopPiece(ChessGame.Side.NORTH, 0, 0, board);
    board.addPiece(testPiece, 4, 4);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testPiece.isLegalMove(900, 900));
    //Should return false if the player tries to not move the piece at all
    assertFalse(testPiece.isLegalMove(4, 4));
    //Should return true if the player inputs a legal diagonal move (isDiagonalMove() returns true)
    assertTrue(testPiece.isLegalMove(1, 1));
    //Should return false if, given the inputted destination is on the board and is not in the same spot as the piece currently is,
    //the move is not legal for a bishop
    assertFalse(testPiece.isLegalMove(1, 0));
  }
  
  /**
   * Tests isLegalMove(int toRow, int toColumn) from the QueenPiece Class
   */
  @Test
  public void testQueenPieceIsLegalMove()
  {
    //QueenPiece testPiece stores a QueenPiece used for testing this method
    QueenPiece testPiece = new QueenPiece(ChessGame.Side.NORTH, 0, 0, board);
    board.addPiece(testPiece, 4, 4);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testPiece.isLegalMove(900, 900));
    //Should return false if the player tries to not move the piece at all
    assertFalse(testPiece.isLegalMove(4, 4));
    //Should return true if the player inputs a legal diagonal move (isDiagonalMove() returns true)
    assertTrue(testPiece.isLegalMove(7, 7));
    //Should return true if the player inputs a legal vertical move (isVerticalMove() returns true)
    assertTrue(testPiece.isLegalMove(1, 4));
    //Should return true if the player inputs a legal horizontal move (isHorizontalMove() returns true)
    assertTrue(testPiece.isLegalMove(4, 7));
    //Should return false if, given the inputted destination is on the board and is not in the same spot as the piece currently is,
    //the move is not legal for a queen
    assertFalse(testPiece.isLegalMove(1, 0));
  }
  
  /**
   * Tests isLegalMove(int toRow, int toColumn) from the KingPiece Class
   */
  @Test
  public void testKingPieceIsLegalMove()
  {
    //KingPiece testPiece stores a KingPiece used for testing this method
    KingPiece testPiece = new KingPiece(ChessGame.Side.NORTH, 0, 4, board);
    board.addPiece(testPiece, 0, 4);
    //RookPiece testCastle stores a RookPiece used for testing that a legal move for a king is a castle move
    RookPiece testCastle = new RookPiece(ChessGame.Side.NORTH, 0, 0, board);
    board.addPiece(testCastle, 0, 0);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testPiece.isLegalMove(900, 900));
    //Should return false if the player tries to not move the piece at all
    assertFalse(testPiece.isLegalMove(0, 4));
    //Should return true if the player inputs a legal castle move (isCastleMove() returns true)
    assertTrue(testPiece.isLegalMove(0, 2));
    //Should return true if the player inputs a legal omni directional one space move (isOmniDirectionalOneSpaceMove() returns true)
    assertTrue(testPiece.isLegalMove(1, 4));
    //Should return false if, given the inputted destination is on the board and is not in the same spot as the piece currently is,
    //the move is not legal for a king
    assertFalse(testPiece.isLegalMove(5, 0));
  }
  
  /**
   * Tests isLegalMove(int toRow, int toColumn) from the PawnPiece Class
   */
  @Test
  public void testPawnPieceIsLegalMove()
  {
    //PawnPiece testPiece stores a PawnPiece used for testing this method
    KingPiece testPiece = new KingPiece(ChessGame.Side.SOUTH, 7, 4, board);
    board.addPiece(testPiece, 7, 4);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testPiece.isLegalMove(900, 900));
    //Should return false if the player tries to not move the piece at all
    assertFalse(testPiece.isLegalMove(7, 4));
    //Should return true if the player inputs a legal pawn move (isPawnMove() returns true)
    assertTrue(testPiece.isLegalMove(6, 4));
    //Should return false if, given the inputted destination is on the board and is not in the same spot as the piece currently is,
    //the move is not legal for a pawn
    assertFalse(testPiece.isLegalMove(7, 7));
  }
  
  /**
   * Tests isLegalNonCaptureMove(int row, int column)
   */
  @Test
  public void testIsLegalNonCaptureMove()
  {
    //QueenPiece testPiece stores a QueenPiece used for testing this method
    QueenPiece testPiece = new QueenPiece(ChessGame.Side.NORTH, 4, 4, board);
    board.addPiece(testPiece, 4, 4);
    //PawnPiece testEmpty stores a PawnPiece used for testing if testPiece is trying to move to an empty square or not
    PawnPiece testEmpty = new PawnPiece(ChessGame.Side.NORTH, 1, 1, board);
    board.addPiece(testEmpty, 1, 1);
    //KingPiece testCastleLeft stores a KingPiece used for testing that a rook is moved properly if a castle move is made
    //with the king castling to the left
    KingPiece testCastleLeft = new KingPiece(ChessGame.Side.NORTH, 0, 4, board);
    board.addPiece(testCastleLeft, 0, 4);
    //RookPiece testLeftCastlingRookMoves stores a RookPiece used for testing that a rook is moved properly if the king makes a castle move
    //with the king castling to the left
    RookPiece testLeftCastlingRookMoves = new RookPiece(ChessGame.Side.NORTH, 0, 0, board);
    board.addPiece(testLeftCastlingRookMoves, 0, 0);
    
    //Tests that if the input position is not a legal move for this type of piece, this is not a legal move
    //(In other words, isLegalMove() for this piece returns false)
    assertFalse(testPiece.isLegalNonCaptureMove(2, 3));
    //Tests that if the square the player is trying to move to is occupied, this piece should not be moved
    assertFalse(testPiece.isLegalNonCaptureMove(1, 1));
    //Tests that if the square the player is trying to move to is a legal move for this kind of piece
    //and is empty, then the piece should be moved to new input location
    assertTrue(testPiece.isLegalNonCaptureMove(6, 6));
    //Tests that if the piece attempting to be moved is a king and a castle move is being made,
    //then if the king is castling to the right corner, move the rook in that corner to be one space to the right of the king's new position
    assertTrue(testCastleLeft.isLegalNonCaptureMove(0, 2));
    board.removePiece(0, 2);
    //Testing Rook's new position: If the rook did not move, then trying to remove the piece at this position should throw a NullPointerException during runtime
    board.removePiece(0, 3);
    //KingPiece testCastleRight stores a KingPiece used for testing that a rook is moved properly if a castle move is made
    //with the king castling to the right
    KingPiece testCastleRight = new KingPiece(ChessGame.Side.NORTH, 0, 4, board);
    board.addPiece(testCastleRight, 0, 4);
    //RookPiece testRightCastlingRookMoves stores a RookPiece used for testing that a rook is moved properly if the king makes a castle move
    //with the king castling to the right
    RookPiece testRightCastlingRookMoves = new RookPiece(ChessGame.Side.NORTH, 0, 7, board);
    board.addPiece(testRightCastlingRookMoves, 0, 7);
    //Tests that if the piece attempting to be moved is a king and a castle move is being made,
    //then if the king is castling to the right corner, move the rook in that corner to be one space to the left of the king
    assertTrue(testCastleRight.isLegalNonCaptureMove(0, 6));
    //Testing Rook's new position: If the rook did not move, then trying to remove the piece at this position should throw a NullPointerException during runtime
    board.removePiece(0, 5);
  }
  
  /**
   * Tests isLegalCaptureMove(int row, int column)
   */
  @Test
  public void testIsLegalCaptureMove()
  {
    //QueenPiece testPiece stores a QueenPiece used for testing this method
    QueenPiece testPiece = new QueenPiece(ChessGame.Side.NORTH, 4, 4, board);
    board.addPiece(testPiece, 4, 4);
    //PawnPiece testEmpty stores a PawnPiece used for testing if testPiece is trying to move to a spot with a piece on it
    PawnPiece testEmpty = new PawnPiece(ChessGame.Side.SOUTH, 1, 1, board);
    board.addPiece(testEmpty, 1, 1);
    //PawnPiece testSameSide stores a PawnPiece used for testing if testPiece is trying to move to a spot containing a piece of the same side
    PawnPiece testSameSide = new PawnPiece(ChessGame.Side.NORTH, 1, 6, board);
    board.addPiece(testSameSide, 1, 6);
    
    //Tests if this piece is making a legal move, is moving to a space with a piece, and the piece
    //in the destination square is not on the same side as the piece being moved, this is a legal capture move for the piece being moved
    assertTrue(testPiece.isLegalCaptureMove(1, 1));  //This will set the location of testPiece to row 1, column 1
    //Tests if this piece is not making a legal move for its type, then this is not a legal capture move
    assertFalse(testPiece.isLegalCaptureMove(3, 2));
    //Tests if this piece is making a legal move for its type but the space it is trying to move to is empty,
    //this is not a legal capture move
    assertFalse(testPiece.isLegalCaptureMove(3, 3));
    //Tests if this piece is making a legal move for its type and is moving to an unempty space containing a piece of the same side,
    //this is not a legal capture move
    assertFalse(testPiece.isLegalCaptureMove(1, 6));
  }
  
  /**
   * Tests legalPieceToPlay(ChessPiece piece, int row, int column) from EuropeanChess class
   * Note that, by default, the starting player is always the one of the north side
   */
  @Test
  public void testLegalPieceToPlay()
  {
    //PawnPiece testLegalToPlay stores a PawnPiece used to test this method (north side trying to use north side piece)
    PawnPiece testLegalToPlay = new PawnPiece(ChessGame.Side.NORTH, 4, 4, board);
    //PawnPiece testPieceIllegalToPlay stores a PawnPiece used to test this method (north side trying to use south side piece)
    PawnPiece testIllegalToPlay = new PawnPiece(ChessGame.Side.SOUTH, 4, 4, board);
    
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
  public void testMakeMove()
  {
    //QueenPiece testNorthPiece stores a QueenPiece used to test condtions where the piece can move this turn
    QueenPiece testNorthPiece = new QueenPiece(ChessGame.Side.NORTH, 4, 4, board);
    board.addPiece(testNorthPiece, 4, 4);
    //PawnPiece testSouthPiece stores a PawnPiece used to test conditions where this piece will not move this turn
    PawnPiece testSouthPiece = new PawnPiece(ChessGame.Side.SOUTH, 4, 4, board);
    //PawnPiece testCapture storse a PawnPiece used to test conditions where the move being made is a legal capture move
    PawnPiece testCapture = new PawnPiece(ChessGame.Side.NORTH, 3, 0, board);
    board.addPiece(testCapture, 3, 0);
    
    //Tests If the player on the north side is trying to use a piece of the north side,
    //the piece is making a legal non capture move or legal capture move (legal non-capture move in this test),
    //and the player is of the north side, then the move is made and the player side is swapped to south
    assertTrue(gameRules.makeMove(testNorthPiece, 4, 5));
    assertTrue(!(testNorthPiece.getToBeUpgraded()));
    board.addPiece(testSouthPiece, 4, 1);
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
   * NOTE: All methods past this point test methods from ChessPiece Hierarchy related to Xiangqi
   */
  
  /** 
   * Tests the contructor for a XiangqiKingPiece
   */
  @Test
  public void testXiangqiKingPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the XiangqiKingPiece constructor
    ChessPiece testPiece = new XiangqiKingPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "X" for a  instance of a ChessPiece
    assertEquals("X", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a  instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /** 
   * Tests the contructor for a RookPiece
   */
  @Test
  public void testGuardPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the GuardPiece constructor
    ChessPiece testPiece = new GuardPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "G" for a GuardPiece instance of a ChessPiece
    assertEquals("G", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a GuardPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /** 
   * Tests the contructor for a ElephantPiece
   */
  @Test
  public void testElephantPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the ElephantPiece constructor
    ChessPiece testPiece = new ElephantPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "E" for a ElephantPiece instance of a ChessPiece
    assertEquals("E", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a ElephantPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /** 
   * Tests the contructor for a HorsePiece
   */
  @Test
  public void testHorsePiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the HorsePiece constructor
    ChessPiece testPiece = new HorsePiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "H" for a HorsePiece instance of a ChessPiece
    assertEquals("H", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a HorsePiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /** 
   * Tests the contructor for a CannonPiece
   */
  @Test
  public void testCannonPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the CannonPiece constructor
    ChessPiece testPiece = new CannonPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "C" for a CannonPiece instance of a ChessPiece
    assertEquals("C", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a CannonPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /** 
   * Tests the contructor for a SoldierPiece
   */
  @Test
  public void testSoldierPiece()
  {
    //ChessPiece testPiece stores a chess piece which is used for testing the SoldierPiece constructor
    ChessPiece testPiece = new SoldierPiece(ChessGame.Side.SOUTH, 7, 1, board);
    
    //Should get the piece's side, which is set to SOUTH for testPiece
    assertEquals(ChessGame.Side.SOUTH, testPiece.getSide());
    //Should get the piece's label, which is set to "S" for a SoldierPiece instance of a ChessPiece
    assertEquals("S", testPiece.getLabel());
    //Should get the piece's icon, which is set to null for a SoldierPiece instance of a ChessPiece
    assertEquals(null, testPiece.getIcon());
    //Should get the piece's row, which is set to 7 for testPiece
    assertEquals(7, testPiece.getRow());
    //Should get the piece's column, which is set to 1 for testPiece
    assertEquals(1, testPiece.getColumn());
    //Should get the board the piece is on, which is set to board for testPiece
    assertEquals(board, testPiece.getChessBoard());
  }
  
  /**
   * A method which tests isOneSpaceHorizontalMove(int toRow, int toColumn, ChessPiece piece) from OneSpaceHorizontalMove
   */
  @Test
  public void testIsOneSpaceHorizontalMove()
  {
    //XiangqiKingPiece testPiece stores a piece used for testing the validity of this method
    XiangqiKingPiece testPiece = new XiangqiKingPiece(ChessGame.Side.NORTH, 1, 4, xiangqiBoard);
    
    //Calling isOneSpaceHorizontalMove here should return true since the piece is moving one space to the left
    assertTrue(testPiece.isOneSpaceHorizontalMove(1, 3, testPiece));
    //Calling isOneSpaceHorizontalMove here should return true since the piece is moving one space to the right
    assertTrue(testPiece.isOneSpaceHorizontalMove(1, 5, testPiece));
    //Calling isOneSpaceHorizontalMove here should return false since the row which the piece is on has changed and its column remains the same
    assertFalse(testPiece.isOneSpaceHorizontalMove(2, 4, testPiece));
    //Calling isOneSpaceHorizontalMove here should return false since the piece has moved diagonally one space in any direction
    assertFalse(testPiece.isOneSpaceHorizontalMove(2, 3, testPiece));
  }
  
  /**
   * A method which tests isOneSpaceVerticalMove(int toRow, int toColumn, ChessPiece piece) from OneSpaceVerticalMove
   */
  @Test
  public void testIsOneSpaceVerticalMove()
  {
    //XiangqiKingPiece testPiece stores a piece used for testing the validity of this method
    XiangqiKingPiece testPiece = new XiangqiKingPiece(ChessGame.Side.NORTH, 1, 4, xiangqiBoard);
    
    //Calling isOneSpaceVerticalMove here should return true since the piece is moving one space forward (numerically, adding one to its row)
    assertTrue(testPiece.isOneSpaceVerticalMove(2, 4, testPiece));
    //Calling isOneSpaceVerticalMove here should return true since the piece is moving one space to the backward (numerically, subtracting one from its row)
    assertTrue(testPiece.isOneSpaceVerticalMove(0, 4, testPiece));
    //Calling isOneSpaceVerticalMove here should return false since the column which the piece is on has changed and its row remains the same (i.e. moving horizontally, not vertically)
    assertFalse(testPiece.isOneSpaceVerticalMove(1, 3, testPiece));
    //Calling isOneSpaceVerticalMove here should return false since the piece has moved diagonally one space in any direction
    assertFalse(testPiece.isOneSpaceVerticalMove(2, 3, testPiece));
  }
  
  /**
   * A method which tests isOneSpaceDiagonalMove(int toRow, int toColumn, ChessPiece piece) from OneSpaceDiagonalMove
   */
  @Test
  public void testIsOneSpaceDiagonalMove()
  {
    //GuardPiece testPiece stores a piece used to test the validity of one space diagonal moves
    GuardPiece testPiece = new GuardPiece(ChessGame.Side.NORTH, 1, 4, xiangqiBoard);
    
    //Calling isOneSpaceDiagonalMove here should return true since the piece is moving northeast one space
    assertTrue(testPiece.isOneSpaceDiagonalMove(0, 5, testPiece));
    //Calling isOneSpaceDiagonalMove here should return true since the piece is moving southeast one space
    assertTrue(testPiece.isOneSpaceDiagonalMove(2, 5, testPiece));
    //Calling isOneSpaceDiagonalMove here should return true since the piece is moving southwest one space
    assertTrue(testPiece.isOneSpaceDiagonalMove(2, 3, testPiece));
    //Calling isOneSpaceDiagonalMove here should return true since the piece is moving northwest one space
    assertTrue(testPiece.isOneSpaceDiagonalMove(0, 3, testPiece));
    //Calling isOneSpaceDiagonalMove here should return false since the piece is moving vertically one space
    assertFalse(testPiece.isOneSpaceDiagonalMove(2, 4, testPiece));
    //Calling isOneSpaceDiagonalMove here should return false since the piece is moving horizontally one space
    assertFalse(testPiece.isOneSpaceDiagonalMove(1, 5, testPiece));
    //Calling isOneSpaceDiagonalMove here should return false since the piece is moving more than one space diagonally
    assertFalse(testPiece.isOneSpaceDiagonalMove(3, 6, testPiece));
  }
  
  /**
   * A method which tests isLegalMove(int toRow, int toColumn) from XiangqiKingPiece
   */
  @Test
  public void testIsLegalMoveXiangqiKingPiece()
  {
    //XiangqiKingPiece testNorthPiece stores a piece used for testing the validity of this piece's move on the NORTH side
    XiangqiKingPiece testNorthPiece = new XiangqiKingPiece(ChessGame.Side.NORTH, 1, 4, xiangqiBoard);
    //XiangqiKingPiece testSouthPiece stores a piece used for testing the validity of this piece's move on the SOUTH side
    XiangqiKingPiece testSouthPiece = new XiangqiKingPiece(ChessGame.Side.SOUTH, 8, 4, xiangqiBoard);
    //Must add the pieces to the board for them to be correctly tested
    xiangqiBoard.addPiece(testNorthPiece, 1, 4);
    xiangqiBoard.addPiece(testSouthPiece, 8, 4);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testNorthPiece.isLegalMove(900, 900));
    //Should allow the piece to move to the indicated square as long as it stays in the nine-point fortress and moves one space vertically or horizontally
    //The functionality of isOneSpaceVerticalMove is tested in the method "testIsOneSpaceVerticalMove" and
    //the functionality of isOneSpaceHorizontalMove is tested in the method "testIsOneSpaceHorizontalMove"
    assertTrue(testNorthPiece.isLegalMove(2, 4));   //Moves forward (vertical)
    assertTrue(testNorthPiece.isLegalMove(1, 3));   //Moves left  (horizontal)
    assertTrue(testSouthPiece.isLegalMove(9, 4));   //Moves backward (vertical)
    assertTrue(testSouthPiece.isLegalMove(8, 5));   //Moves right (horizontal)
    assertFalse(testNorthPiece.isLegalMove(0, 3));  //Moves diagonally (this piece cannot move in such a way)
    //If the piece's move exceeds the bounds of the nine-point fortress on its side, then the move is not legal (referred to here as "out of bounds" condition)
    //Testing out of bounds condition for the NORTH side
    testNorthPiece = new XiangqiKingPiece(ChessGame.Side.NORTH, 2, 3, xiangqiBoard);
    xiangqiBoard.addPiece(testNorthPiece, 2, 3);
    assertFalse(testNorthPiece.isLegalMove(3, 3));
    assertFalse(testNorthPiece.isLegalMove(2, 2));
    //Testing out of bounds condition for the SOUTH side
    testSouthPiece = new XiangqiKingPiece(ChessGame.Side.SOUTH, 7, 5, xiangqiBoard);
    xiangqiBoard.addPiece(testSouthPiece, 7, 5);
    assertFalse(testSouthPiece.isLegalMove(6, 5));
    assertFalse(testSouthPiece.isLegalMove(7, 6));
  }
  
  /**
   * A method which tests isLegalMove(int toRow, int toColumn, ChessPiece piece) from GuardPiece
   */
  @Test
  public void testIsLegalMoveGuardPiece()
  {
    //GuardPiece testNorthPiece stores a piece used for testing the validity of this piece's move on the NORTH side
    GuardPiece testNorthPiece = new GuardPiece(ChessGame.Side.NORTH, 1, 4, xiangqiBoard);
    //GuardPiece testSouthPiece stores a piece used for testing the validity of this piece's move on the SOUTH side
    GuardPiece testSouthPiece = new GuardPiece(ChessGame.Side.SOUTH, 8, 4, xiangqiBoard);
    //Must add the pieces to the board for them to be correctly tested
    xiangqiBoard.addPiece(testNorthPiece, 1, 4);
    xiangqiBoard.addPiece(testSouthPiece, 8, 4);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testNorthPiece.isLegalMove(900, 900));
    //Should allow the piece to move to the indicated square as long as it stays in the nine-point fortress and moves one space diagonally
    //The functionality of isOneSpaceDiagonalMove is tested in "testIsOneSpaceDiagonalMove"
    assertTrue(testNorthPiece.isLegalMove(0, 5));   //Moves northeast
    assertTrue(testNorthPiece.isLegalMove(2, 5));   //Moves southeast
    assertTrue(testSouthPiece.isLegalMove(9, 3));   //Moves southwest
    assertTrue(testSouthPiece.isLegalMove(7, 3));   //Moves northwest
    assertFalse(testNorthPiece.isLegalMove(2, 4));  //Moves vertically (not allowed by this piece)
    assertFalse(testSouthPiece.isLegalMove(8, 5));  //Moves horizontally (not allowed by this piece)
    //If the piece's move exceeds the bounds of the nine-point fortress on its side, then the move is not legal (referred to here as "out of bounds" condition)
    //Testing out of bounds condition for the NORTH side
    testNorthPiece = new GuardPiece(ChessGame.Side.NORTH, 2, 3, xiangqiBoard);
    xiangqiBoard.addPiece(testNorthPiece, 2, 3);
    assertFalse(testNorthPiece.isLegalMove(3, 4));
    assertFalse(testNorthPiece.isLegalMove(3, 2));
    //Testing out of bounds condition for the SOUTH side
    testSouthPiece = new GuardPiece(ChessGame.Side.SOUTH, 7, 5, xiangqiBoard);
    xiangqiBoard.addPiece(testSouthPiece, 7, 3);
    assertFalse(testSouthPiece.isLegalMove(6, 2));
    assertFalse(testSouthPiece.isLegalMove(6, 4));
  }
  
  /**
   * A method which tests isLegalMove(int toRow, int toColumn, ChessPiece piece) from ElephantPiece
   */
  @Test
  public void testIsLegalMoveElephantPiece()
  {
    //ElephantPiece testNorthPiece stores a piece used for testing the validity of this piece's move on the NORTH side
    ElephantPiece testNorthPiece = new ElephantPiece(ChessGame.Side.NORTH, 0, 4, xiangqiBoard);
    //ElephantPiece testSouthPiece stores a piece used for testing the validity of this piece's move on the SOUTH side
    ElephantPiece testSouthPiece = new ElephantPiece(ChessGame.Side.SOUTH, 8, 4, xiangqiBoard);
    //ElephantPiece testBlockedPiece stores a piece used for testing the validity of a move if the first square in the piece's path is blocked by another piece
    ElephantPiece testBlockedPiece = new ElephantPiece(ChessGame.Side.SOUTH, 1, 3, xiangqiBoard);
    //Must add the pieces to the board for them to be correctly tested
    xiangqiBoard.addPiece(testNorthPiece, 0, 4);
    xiangqiBoard.addPiece(testSouthPiece, 8, 4);
    xiangqiBoard.addPiece(testBlockedPiece, 1, 3);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testNorthPiece.isLegalMove(900, 900));
    //Should allow the piece to move to the indicated square as long as it stays in its half of the board,
    //does not have a piece between it and its destination space, and moves two spaces diagonally on a turn
    assertFalse(testNorthPiece.isLegalMove(2, 2));  //Attempts to move southwest two spaces, but has a piece between it and its destimation square
    assertTrue(testNorthPiece.isLegalMove(2, 6));   //Moves southeast two spaces
    assertTrue(testSouthPiece.isLegalMove(6, 2));   //Moves northwest two spaces
    assertTrue(testSouthPiece.isLegalMove(6, 6));   //Moves northeast two spaces
    assertFalse(testNorthPiece.isLegalMove(2, 4));  //Moves vertically (not allowed by this piece)
    assertFalse(testSouthPiece.isLegalMove(8, 5));  //Moves horizontally (not allowed by this piece)
    assertFalse(testSouthPiece.isLegalMove(7, 5));  //Attempts to move more than two spaces diagonally (not allowed by this piece)
    //If the piece's move exceeds the bounds of its half of the board (referred to here as "out of bounds" condition), then the piece's move should be disallowed
    //Testing out of bounds condition for the NORTH side
    testNorthPiece = new ElephantPiece(ChessGame.Side.NORTH, 4, 4, xiangqiBoard);
    xiangqiBoard.addPiece(testNorthPiece, 4, 4);
    assertFalse(testNorthPiece.isLegalMove(6, 6));
    assertFalse(testNorthPiece.isLegalMove(6, 2));
    //Testing out of bounds condition for the SOUTH side
    testSouthPiece = new ElephantPiece(ChessGame.Side.SOUTH, 5, 4, xiangqiBoard);
    xiangqiBoard.addPiece(testSouthPiece, 5, 4);
    assertFalse(testSouthPiece.isLegalMove(3, 6));
    assertFalse(testSouthPiece.isLegalMove(3, 2));
  }
  
  /**
   * Tests isLegalMove(int toRow, int toColumn, ChessPiece piece) from HorsePiece
   */
  @Test
  public void testIsLegalMoveHorsePiece()
  {
    //HorsePiece testPiece stores a piece used for testing the validity of this piece's move
    HorsePiece testPiece = new HorsePiece(ChessGame.Side.NORTH, 5, 4, xiangqiBoard);
    
    //Must add this piece to the board to test its moveset
    xiangqiBoard.addPiece(testPiece, 5, 4);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testPiece.isLegalMove(900, 900));
    //Checks that this piece can make an L-shaped move when it is unblocked
    //For tests of all forms of an L-shaped move, see the testing method with the name "testIsLMove"
    assertTrue(testPiece.isLegalMove(7, 5));
    //If the piece attempts to make some other kind of move (e.g. a one space vertical move), then the move should be disallowed
    assertFalse(testPiece.isLegalMove(6, 4));
    
    //Add pieces to the board surrounding testPiece which will test the feature described in the next comment
    xiangqiBoard.addPiece(new HorsePiece(ChessGame.Side.SOUTH, 4, 4, xiangqiBoard), 4, 4);
    xiangqiBoard.addPiece(new HorsePiece(ChessGame.Side.SOUTH, 6, 4, xiangqiBoard), 6, 4);
    xiangqiBoard.addPiece(new HorsePiece(ChessGame.Side.NORTH, 5, 3, xiangqiBoard), 5, 3);
    xiangqiBoard.addPiece(new HorsePiece(ChessGame.Side.NORTH, 5, 5, xiangqiBoard), 5, 5);
    
    //If the first square in the path to a HorsePiece instance's destination square is blocked by another piece of any side, disallow the move
    //All of the following tests check that the feature just described is implemented properly
    assertFalse(testPiece.isLegalMove(3, 3));      //Tests this feature when a piece attempts to move up and northwest
    assertFalse(testPiece.isLegalMove(4, 2));      //Tests this feature when a piece attempts to move left and northwest
    assertFalse(testPiece.isLegalMove(6, 2));      //Tests this feature when a piece attempts to move left and southwest
    assertFalse(testPiece.isLegalMove(7, 3));      //Tests this feature when a piece attempts to move down and southwest
    assertFalse(testPiece.isLegalMove(7, 5));      //Tests this feature when a piece attempts to move down and southeast
    assertFalse(testPiece.isLegalMove(6, 6));      //Tests this feature when a piece attempts to move right and southeast
    assertFalse(testPiece.isLegalMove(4, 6));      //Tests this feature when a piece attempts to move right and northeast
    assertFalse(testPiece.isLegalMove(3, 5));      //Tests this feature when a piece attempts to move up and northeast
  }
  
  /**
   * Tests isLegalMove(int toRow, int toColumn, ChessPiece piece) from CannonPiece
   */
  @Test
  public void testIsLegalMoveCannonPiece()
  {
    //CannonPiece testPiece stores a piece used for testing the validity of a piece's move when it has no pieces in front of it
    CannonPiece testPiece = new CannonPiece(ChessGame.Side.NORTH, 2, 5, xiangqiBoard);
    //CannonPiece testCapture stores a piece used for testing the validity of a piece's move if this piece may be capturing another piece
    CannonPiece testCapture = new CannonPiece(ChessGame.Side.SOUTH, 7, 5, xiangqiBoard);
    //CannonPiece testOneObstructingPiece stores a piece used for testing the validity of a move if the exactly one square in the piece's path with a piece on it
    CannonPiece testOneObstructingPiece = new CannonPiece(ChessGame.Side.SOUTH, 8, 5, xiangqiBoard);
    //CannonPiece testSecondObstructingPiece stores a piece used for testing the validity of a move if there is more than one square in the piece's path with a piece on it
    CannonPiece testSecondObstructingPiece = new CannonPiece(ChessGame.Side.NORTH, 9, 5, xiangqiBoard);
    //To test moves with no obstructing pieces, just add testPiece to the board at the beginning
    xiangqiBoard.addPiece(testPiece, 2, 5);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testPiece.isLegalMove(900, 900));
    //If this is a vertical or hoizontal move (any number of squares) and this piece is not capturing another piece 
    //(in which case there are no pieces obstructing this one's path), this move is legal
    //See "testIsVerticalMove" and "testIsHorizontalMove" for tests demonstrating the functionality of a horizontal and vertical moves of any distance
    assertTrue(testPiece.isLegalMove(2, 8));       //Piece is moving right
    assertTrue(testPiece.isLegalMove(2, 2));       //Piece is moving left
    assertTrue(testPiece.isLegalMove(5, 5));       //Piece is moving forward (down)
    assertTrue(testPiece.isLegalMove(0, 5));       //Piece is moving backwards (up)
    //Add an obstructing piece to the board
    xiangqiBoard.addPiece(testOneObstructingPiece, 5, 5);
    assertFalse(testPiece.isLegalMove(6, 5));      //Piece attempts to move forwards, but cannot as it is not capturing a piece and has a piece in its way
    
    /* Section testing moves with obstructing pieces when piece is moving downwards */
    //Add a piece to capture to the board
    xiangqiBoard.addPiece(testCapture, 7, 5);
    //The piece testPiece should be able to move to this location since it is capturing a piece and jumping over exactly one piece to do so (moving down to do so)
    assertTrue(testPiece.isLegalMove(7, 5));
    //Add a second obstructing piece to the board
    xiangqiBoard.addPiece(testSecondObstructingPiece, 4, 5);
    //The piece testPiece should not be able to move to this location since it is attempting to capture a piece when it has more than one piece in its path (moving down to do so)
    assertFalse(testPiece.isLegalMove(7, 5));
    //Reset the obstructing pieces
    xiangqiBoard.removePiece(4, 5);                //Position of testSecondObstructingPiece 
    xiangqiBoard.removePiece(5, 5);                //Position of testOneObstructingPiece
    xiangqiBoard.removePiece(7, 5);                //Position of testCapture
    
    /* Section testing moves with obstructing pieces when piece is moving to the right */
    //Add a piece to capture to the board and an obstructing piece
    xiangqiBoard.addPiece(testCapture, 2, 8);
    xiangqiBoard.addPiece(testOneObstructingPiece, 2, 6);
    //The piece testPiece should be able to move to this location since it is capturing a piece and jumping over exactly one piece to do so (moving right to do so)
    assertTrue(testPiece.isLegalMove(2, 8));
    //Add a second obstructing piece to the board
    xiangqiBoard.addPiece(testSecondObstructingPiece, 2, 7);
    //The piece testPiece should not be able to move to this location since it is attempting to capture a piece when it has more than one piece in its path (moving right to do so)
    assertFalse(testPiece.isLegalMove(2, 8));
    //Reset the obstructing pieces
    xiangqiBoard.removePiece(2, 7);                //Position of testSecondObstructingPiece 
    xiangqiBoard.removePiece(2, 6);                //Position of testOneObstructingPiece
    xiangqiBoard.removePiece(2, 8);                //Position of testCapture
    
    /* Section testing moves with obstructing pieces when piece is moving to the left */
    //Add a piece to capture to the board and an obstructing piece
    xiangqiBoard.addPiece(testCapture, 2, 0);
    xiangqiBoard.addPiece(testOneObstructingPiece, 2, 2);
    //The piece testPiece should be able to move to this location since it is capturing a piece and jumping over exactly one piece to do so (moving left to do so)
    assertTrue(testPiece.isLegalMove(2, 0));
    //Add a second obstructing piece to the board
    xiangqiBoard.addPiece(testSecondObstructingPiece, 2, 4);
    //The piece testPiece should not be able to move to this location since it is attempting to capture a piece when it has more than one piece in its path (moving left to do so)
    assertFalse(testPiece.isLegalMove(2, 0));
    //Reset the obstructing pieces and testPiece
    xiangqiBoard.removePiece(2, 4);                //Position of testSecondObstructingPiece 
    xiangqiBoard.removePiece(2, 2);                //Position of testOneObstructingPiece
    xiangqiBoard.removePiece(2, 0);                //Position of testCapture
    xiangqiBoard.removePiece(2, 5);                //Position of testPiece
    
    /* Section testing moves with obstructing pieces when piece is moving upwards */
    //Add testPiece to the board
    xiangqiBoard.addPiece(testPiece, 9, 4);
    //Add a piece to capture to the board and an obstructing piece
    xiangqiBoard.addPiece(testCapture, 1, 4);
    xiangqiBoard.addPiece(testOneObstructingPiece, 5, 4);
    //The piece testPiece should be able to move to this location since it is capturing a piece and jumping over exactly one piece to do so (moving up to do so)
    assertTrue(testPiece.isLegalMove(1, 4));
    //Add a second obstructing piece to the board
    xiangqiBoard.addPiece(testSecondObstructingPiece, 2, 4);
    //The piece testPiece should not be able to move to this location since it is attempting to capture a piece when it has more than one piece in its path (moving up to do so)
    assertFalse(testPiece.isLegalMove(1, 4));
    
  }
  
  /**
   * Tests isLegalMove(int toRow, int toColumn, ChessPiece piece) from SoldierPiece
   */
  public void testIsLegalMoveSoldierPiece()
  {
    //SoldierPiece testNorthPiece stores a piece used to test the functionality of this method for NORTH piece moves
    SoldierPiece testNorthPiece = new SoldierPiece(ChessGame.Side.NORTH, 3, 3, xiangqiBoard);
    //SoldierPiece testSouthPiece stores a piece used to test the functionality of this method for SOUTH piece moves
    SoldierPiece testSouthPiece = new SoldierPiece(ChessGame.Side.SOUTH, 6, 6, xiangqiBoard);
    //Must add the pieces to the board to test the functionality of this method
    xiangqiBoard.addPiece(testNorthPiece, 3, 3);        
    xiangqiBoard.addPiece(testSouthPiece, 6, 6);
    
    //Should return false if the player tries to move the piece off the board/out of bounds
    assertFalse(testNorthPiece.isLegalMove(900, 900));
    
    /* Testing pieces of the NORTH side */
    //If a piece has not passed the middle of the board, it sould only be able to move forward (towards the other side) one space
    assertTrue(testNorthPiece.isLegalMove(4, 3));  //Piece of the NORTH side moves one space towards the other side
    assertFalse(testNorthPiece.isLegalMove(3, 2)); //Piece of the NORTH side should not be able to move horizontally (left) yet
    assertFalse(testNorthPiece.isLegalMove(3, 4)); //Piece of the NORTH side should not be able to move horizontally (right) yet
    assertFalse(testNorthPiece.isLegalMove(2, 3)); //Piece of the NORTH side should never be able to move back towards its own side
    assertFalse(testNorthPiece.isLegalMove(3, 5)); //Piece of the NORTH side cannot make a move larger than one space in any direction (tests vertical direction)
    //Reset the piece location, add it to a new location for next tests
    xiangqiBoard.addPiece(xiangqiBoard.removePiece(3, 3), 6, 3);
    //If a piece has passed the middle of the board, it should be able to move forward one space and horizontally one space in either direciton
    assertTrue(testNorthPiece.isLegalMove(7, 3));  //Piece of the NORTH side moves one space towards the other side
    assertTrue(testNorthPiece.isLegalMove(6, 2));  //Piece of the NORTH side should be able to move horizontally (left) since it has crossed the middle of the board
    assertTrue(testNorthPiece.isLegalMove(6, 4));  //Piece of the NORTH side should be able to move horizontally (right) since it has crossed the middle of the board
    assertFalse(testNorthPiece.isLegalMove(5, 3)); //Piece of the NORTH side should never be able to move back towards its own side
    assertFalse(testNorthPiece.isLegalMove(6, 5)); //Piece of the NORTH side cannot make a move larger than one space in any direction (tests horizontal direction)
    
    /* Testing pieces of the SOUTH side */
    //If a piece has not passed the middle of the board, it sould only be able to move forward (towards the other side) one space
    assertTrue(testSouthPiece.isLegalMove(5, 6));  //Piece of the SOUTH side moves one space towards the other side
    assertFalse(testSouthPiece.isLegalMove(6, 5)); //Piece of the SOUTH side should not be able to move horizontally (left) yet
    assertFalse(testSouthPiece.isLegalMove(6, 7)); //Piece of the SOUTH side should not be able to move horizontally (right) yet
    assertFalse(testSouthPiece.isLegalMove(7, 6)); //Piece of the SOUTH side should never be able to move back towards its own side
    assertFalse(testSouthPiece.isLegalMove(4, 6)); //Piece of the SOUTH side cannot make a move larger than one space in any direction (tests vertical direction)
    //Reset the piece location, add it to a new location for next tests
    xiangqiBoard.addPiece(xiangqiBoard.removePiece(6, 6), 3, 6);
    //If a piece has passed the middle of the board, it should be able to move forward one space and horizontally one space in either direciton
    assertTrue(testSouthPiece.isLegalMove(2, 6));  //Piece of the SOUTH side moves one space towards the other side
    assertTrue(testSouthPiece.isLegalMove(3, 5));  //Piece of the SOUTH side should be able to move horizontally (left) since it has crossed the middle of the board
    assertTrue(testSouthPiece.isLegalMove(3, 7));  //Piece of the SOUTH side should be able to move horizontally (right) since it has crossed the middle of the board
    assertFalse(testSouthPiece.isLegalMove(4, 6)); //Piece of the SOUTH side should never be able to move back towards its own side
    assertFalse(testSouthPiece.isLegalMove(3, 8)); //Piece of the SOUTH side cannot make a move larger than one space in any direction (tests horizontal direction)
  }

  /**
   * All methods after this point test extra features added to the game, including rules for legal moves and improvements to the play of the game
   */

  /**
   * Tests check logic for KingPiece and XiangqiKingPiece
   */
  @Test
  public void testCheckLogic()
  {
    //KingPiece euroKing stores a King Piece which is used for testing Check logic for a King in European Chess
    KingPiece euroKing = new KingPiece(ChessGame.Side.NORTH, 0, 4, board);
    //QueenPiece threatensEuroKing stores a QueenPiece which is used for testing Check logic for a King in European Chess
    QueenPiece threatensEuroKing = new QueenPiece(ChessGame.Side.SOUTH, 4, 7, board);
    //XiangqiKingPiece xiangqiKing stores a Xinagqi King Piece which is used for testing Check logic for a King in Xiangqi
    XiangqiKingPiece xiangqiKing = new XiangqiKingPiece(ChessGame.Side.NORTH, 1, 4, xiangqiBoard);
    //SoldierPiece threatensXiangqiKing stores a Xiangqi Soldier Piece which is used for testing Check logic for a King in Xiangqi
    SoldierPiece threatensXiangqiKing = new SoldierPiece(ChessGame.Side.SOUTH, 3, 4, xiangqiBoard);
    //Add the pieces to the board to test the Check logic
    board.addPiece(euroKing, 0, 4);
    board.addPiece(threatensEuroKing, 4, 7);
    xiangqiBoard.addPiece(xiangqiKing, 1, 4);
    xiangqiBoard.addPiece(threatensXiangqiKing, 3, 4);

    //Attempting to move the KingPiece one space towards the opposing side should be disallowed since there is a queen of the opposing side which can move to that space
    //assertFalse(euroKing.isLegalMove(1, 4));
    //Attempting to move the XinagqiKingPiece one space towards the opposing side should be disallowed since there is a soldier of the opposing side which can move to that space
    //ssertFalse(xiangqiKing.isLegalMove(2, 4));
  }


}
