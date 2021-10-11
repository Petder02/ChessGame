//TODO: Implement Check (Done) and Checkmate Logic
/**
 * 
 * A class which represents a game of European Chess
 * @author Peter Schlueter
 * 
 */
public class EuropeanChess implements ChessGame, PieceUpgrade
{
  //Field indicating the current player (only used here, I only want this class to be able to reset the player's side, so the field is used directly in the class)
  //Note that the North Side will always have the first turn
  private ChessGame.Side playerSide = Side.NORTH;
  
  protected final int INDO_EURO_CHESS_NUM_ROWS = 8;            // number of rows on an Indo-European board
  protected final int INDO_EURO_CHESS_NUM_COLS = 8;            // number of columns on an Indo-European board
  
  /**
   * Determines if it is legal to play a given piece.
   * @param piece   the piece to be played
   * @param row     the row of the square the piece is on
   * @param column  the column of the square the piece is on
   * @return true if the piece is allowed to move on this turn
   */
  public boolean legalPieceToPlay(ChessPiece piece, int row, int column)
  {
    //If the side of the chess piece in the chosen spot is equal to that of the current player, return true
    if (piece.getSide().equals(playerSide))
    {
      return true;
    }
    return false;
  }
  
  /** 
   * Moves a piece to a new position (at the moment, most of this is done within the ChessPiece hierarchy)
   * @param piece     the piece to move
   * @param toRow     the row of the square the piece is moving to
   * @param toColumn  the column of the square the piece is moving to
   * @return true if the move was made, false if the move was not made
   */
  public boolean makeMove(ChessPiece piece, int toRow, int toColumn)
  {
    //If legalPieceToPlay returned true, continue with the method
    if (legalPieceToPlay(piece, piece.getRow(), piece.getColumn()))
    {
      //A piece move must be legal if legalCaptureMove or legalNonCaptureMove returned true
      //These two methods currently handle piece movement and removal (if the move is a legal capture move) 
      //If one of the two does return true, switch the player side and the turn will end
      if (piece.isLegalCaptureMove(toRow, toColumn) || piece.isLegalNonCaptureMove(toRow, toColumn))
      {
        //Sets that the piece has moved to true
        piece.setHasMoved(true);
        //If the player's piece should be upgraded this turn, upgrade the piece at this spot
        if (piece.getToBeUpgraded())
        {
          upgradePiece(piece);
          piece.setHasMoved(true);
        }
        if (playerSide.equals(Side.NORTH))
        {
          playerSide = Side.SOUTH;
        }
        else
        {
          playerSide = Side.NORTH;
        }
        return true;
      }
    }
    //Return false if the move is illegal
    return false;
  }
  
  /**
   * Gets the number of rows on a European Chess Board
   * @return the number of rows on a European Chess Board
   */
  public int getNumRows()
  {
    return INDO_EURO_CHESS_NUM_ROWS;
  }
  
  /**
   * Gets the number of columns on a European Chess Board
   * @return the number of columns on a European Chess Board
   */
  public int getNumColumns()
  {
    return INDO_EURO_CHESS_NUM_COLS;
  }
  
  /**
   * Starts a game of European Chess
   * @param board  the board on which the game of European Chess will be played
   */
  public void startGame(ChessBoard board)
  {
  
    /* The piece's initial positions on the board are being created under the assumption that this is a typical chess board (8 squares x 8 squares),
     * the two player sides are NORTH and SOUTH, and NORTH starts at row 0 and SOUTH starts at row 7 */
  
    /* Instanciate and place all pieces of the NORTH side on the board */
  
    //Instanciates a NORTH rook chess piece at its starting position
    ChessPiece northRook1 = new RookPiece(ChessGame.Side.NORTH, 0, 0, board);
    //Instanciates a NORTH knight chess piece at its starting position
    ChessPiece northKnight1 = new KnightPiece(ChessGame.Side.NORTH, 0, 1, board);
    //Instanciates a NORTH bishop chess piece at its starting position
    ChessPiece northBishop1 = new BishopPiece(ChessGame.Side.NORTH, 0, 2, board);
    //Instanciates a NORTH queen chess piece at its starting position
    ChessPiece northQueen = new QueenPiece(ChessGame.Side.NORTH, 0, 3, board);
    //Instanciates a NORTH king chess piece at its starting position
    ChessPiece northKing = new KingPiece(ChessGame.Side.NORTH, 0, 4, board);
    //Instanciates a NORTH bishop chess piece at its starting position
    ChessPiece northBishop2 = new BishopPiece(ChessGame.Side.NORTH, 0, 5, board);
    //Instanciates a NORTH knight chess piece at its starting position
    ChessPiece northKnight2 = new KnightPiece(ChessGame.Side.NORTH, 0, 6, board);
    //Instanciates a NORTH rook chess piece at its starting position
    ChessPiece northRook2 = new RookPiece(ChessGame.Side.NORTH, 0, 7, board);
    //Instanciates a NORTH pawn chess piece at its starting position
    ChessPiece northPawn1 = new PawnPiece(ChessGame.Side.NORTH, 1, 0, board);
    //Instanciates a NORTH pawn chess piece at its starting position
    ChessPiece northPawn2 = new PawnPiece(ChessGame.Side.NORTH, 1, 1, board);
    //Instanciates a NORTH pawn chess piece at its starting position
    ChessPiece northPawn3 = new PawnPiece(ChessGame.Side.NORTH, 1, 2, board);
    //Instanciates a NORTH pawn chess piece at its starting position
    ChessPiece northPawn4 = new PawnPiece(ChessGame.Side.NORTH, 1, 3, board);
    //Instanciates a NORTH pawn chess piece at its starting position
    ChessPiece northPawn5 = new PawnPiece(ChessGame.Side.NORTH, 1, 4, board);
    //Instanciates a NORTH pawn chess piece at its starting position
    ChessPiece northPawn6 = new PawnPiece(ChessGame.Side.NORTH, 1, 5, board);
    //Instanciates a NORTH pawn chess piece at its starting position
    ChessPiece northPawn7 = new PawnPiece(ChessGame.Side.NORTH, 1, 6, board);
    //Instanciates a NORTH pawn chess piece at its starting position
    ChessPiece northPawn8 = new PawnPiece(ChessGame.Side.NORTH, 1, 7, board);
    //Adds the pieces on the NORTH side to the board
    board.addPiece(northRook1, 0, 0);
    board.addPiece(northKnight1, 0, 1);
    board.addPiece(northBishop1, 0, 2);
    board.addPiece(northQueen, 0, 3);
    board.addPiece(northKing, 0, 4);
    board.addPiece(northBishop2, 0, 5);
    board.addPiece(northKnight2, 0, 6);
    board.addPiece(northRook2, 0, 7);
    board.addPiece(northPawn1, 1, 0);
    board.addPiece(northPawn2, 1, 1);
    board.addPiece(northPawn3, 1, 2);
    board.addPiece(northPawn4, 1, 3);
    board.addPiece(northPawn5, 1, 4);
    board.addPiece(northPawn6, 1, 5);
    board.addPiece(northPawn7, 1, 6);
    board.addPiece(northPawn8, 1, 7);
    
    /* Instanciate and place all pieces of the SOUTH side of the board */
      
    //Instanciates a SOUTH rook chess piece at its starting position
    ChessPiece southRook1 = new RookPiece(ChessGame.Side.SOUTH, 7, 0, board);
    //Instanciates a SOUTH knight chess piece at its starting position
    ChessPiece southKnight1 = new KnightPiece(ChessGame.Side.SOUTH, 7, 1, board);
    //Instanciates a SOUTH bishop chess piece at its starting position
    ChessPiece southBishop1 = new BishopPiece(ChessGame.Side.SOUTH, 7, 2, board);
    //Instanciates a SOUTH queen chess piece at its starting position
    ChessPiece southQueen = new QueenPiece(ChessGame.Side.SOUTH, 7, 3, board);
    //Instanciates a SOUTH king chess piece at its starting position
    ChessPiece southKing = new KingPiece(ChessGame.Side.SOUTH, 7, 4, board);
    //Instanciates a SOUTH bishop chess piece at its starting position
    ChessPiece southBishop2 = new BishopPiece(ChessGame.Side.SOUTH, 7, 5, board);
    //Instanciates a SOUTH knight chess piece at its starting position
    ChessPiece southKnight2 = new KnightPiece(ChessGame.Side.SOUTH, 7, 6, board);
    //Instanciates a SOUTH rook chess piece at its starting position
    ChessPiece southRook2 = new RookPiece(ChessGame.Side.SOUTH, 7, 7, board);
    //Instanciates a SOUTH pawn chess piece at its starting position
    ChessPiece southPawn1 = new PawnPiece(ChessGame.Side.SOUTH, 6, 0, board);
    //Instanciates a SOUTH pawn chess piece at its starting position
    ChessPiece southPawn2 = new PawnPiece(ChessGame.Side.SOUTH, 6, 1, board);
    //Instanciates a SOUTH pawn chess piece at its starting position
    ChessPiece southPawn3 = new PawnPiece(ChessGame.Side.SOUTH, 6, 2, board);
    //Instanciates a SOUTH pawn chess piece at its starting position
    ChessPiece southPawn4 = new PawnPiece(ChessGame.Side.SOUTH, 6, 3, board);
    //Instanciates a SOUTH pawn chess piece at its starting position
    ChessPiece southPawn5 = new PawnPiece(ChessGame.Side.SOUTH, 6, 4, board);
    //Instanciates a SOUTH pawn chess piece at its starting position
    ChessPiece southPawn6 = new PawnPiece(ChessGame.Side.SOUTH, 6, 5, board);
    //Instanciates a SOUTH pawn chess piece at its starting position
    ChessPiece southPawn7 = new PawnPiece(ChessGame.Side.SOUTH, 6, 6, board);
    //Instanciates a SOUTH pawn chess piece at its starting position
    ChessPiece southPawn8 = new PawnPiece(ChessGame.Side.SOUTH, 6, 7, board);
    //Adds the pieces on the SOUTH side to the board
    board.addPiece(southRook1, 7, 0);
    board.addPiece(southKnight1, 7, 1);
    board.addPiece(southBishop1, 7, 2);
    board.addPiece(southQueen, 7, 3);
    board.addPiece(southKing, 7, 4);
    board.addPiece(southBishop2, 7, 5);
    board.addPiece(southKnight2, 7, 6);
    board.addPiece(southRook2, 7, 7);
    board.addPiece(southPawn1, 6, 0);
    board.addPiece(southPawn2, 6, 1);
    board.addPiece(southPawn3, 6, 2);
    board.addPiece(southPawn4, 6, 3);
    board.addPiece(southPawn5, 6, 4);
    board.addPiece(southPawn6, 6, 5);
    board.addPiece(southPawn7, 6, 6);
    board.addPiece(southPawn8, 6, 7);
  }
  
  
}
        
    
    
  
    
  
  