//TODO: Implement Check and Checkmate Logic
/**
 * 
 * A class defining the rules of a game of Xiangqi (a type of chess)
 * @author Peter Schlueter
 * 
 */
public class Xiangqi implements ChessGame
{
  //Field indicating the current player (only used here, I only want this class to be able to reset the player's side, so the field is used directly in the class)
  //Note that the North Side will always have the first turn
  private ChessGame.Side playerSide = Side.NORTH;
  
  //int northKingRow stores the row which the NORTH king is on
  private int northKingRow = 0;
  
  //int southKingRow stores the row which the SOUTH king is on
  private int southKingRow = 0;
  
  protected final int XIANGQI_NUM_ROWS = 10;           // number of rows on an Indo-European board
  protected final int XIANGQI_NUM_COLS = 9;            // number of columns on an Indo-European board
  
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
   * Check if there are any pieces between two kings
   * @param piece    the chess piece which might be moved
   * @return true if two kings are on the same column, false otherwise
   */
  private boolean areNoPiecesBetweenKings(ChessPiece piece)
  {
    //int northKingColumn stores the column which the NORTH king is on
    int northKingColumn = 0;
    //int southKingColumn stores the column which the SOUTH king is on
    int southKingColumn = 0;
    
    //Loop-Goal: Cycle through the rows of the board
    for (int r = 0; r < getNumRows(); r++)
    {
      
      //Loop-Goal: Cycle through each column of this row on the board, storing the positions of the two kings on the board
      for (int c = 0; c < getNumColumns(); c++)
      {
        if ((piece.getChessBoard().getPiece(r, c) instanceof XiangqiKingPiece) && 
            (piece.getChessBoard().getPiece(r, c).getSide() == ChessGame.Side.NORTH))
        {
          //Save the position of the North king
          northKingRow = r;
          northKingColumn = c;
          
        }
        if ((piece.getChessBoard().getPiece(r, c) instanceof XiangqiKingPiece) &&
            (piece.getChessBoard().getPiece(r, c).getSide() == ChessGame.Side.SOUTH))
        {
          //Save the position of the South king
          southKingRow = r;
          southKingColumn = c;
        }
      }
    }
    //return northKingColumn == southKingColumn;
    //If the columns of the North and South King match, check if the move made would create a "facing kings" situation
    if (northKingColumn == southKingColumn)
    {
      //Loop-Goal: If there is a piece between the two kings, return false (the kings cannon "see" eachother if this is the case
      for (int r = northKingRow + 1; r < southKingRow; r++)
      {
        if (piece.getChessBoard().hasPiece(r, northKingColumn))
        {
          //System.out.println("Has a piece at (" + r + ", " + northKingColumn + ")");
          return false;
        }
      }
      //piece.setLocation(rowBeforeMove, columnBeforeMove);
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
    //int rowBeforeMove stores the row which the piece was on prior to its potential move
    int rowBeforeMove = piece.getRow();
    //int columnBeforeMove stores the column which the piece was on prior to its potential move
    int columnBeforeMove = piece.getColumn();
    //ChessPiece savedPiece stores a ChessPiece readded to the board if a capture move needs to be undone due to it creating a facing kings situation
    ChessPiece savedPiece = null;
    //If there is a piece at toRow and toColumn, save it in savedPiece
    if (piece.getChessBoard().getPiece(toRow, toColumn) != null)
    {
      savedPiece = piece.getChessBoard().getPiece(toRow, toColumn);
    }
    //If legalPieceToPlay returned true, continue with the method
    if (legalPieceToPlay(piece, piece.getRow(), piece.getColumn()))
    {
      //A piece move must be legal if legalCaptureMove or legalNonCaptureMove returned true
      //These two methods currently handle piece movement and removal (if the move is a legal capture move) 
      //If one of the two does return true, switch the player side and the turn will end
      if (piece.isLegalCaptureMove(toRow, toColumn) || piece.isLegalNonCaptureMove(toRow, toColumn))
      {
        //If, once the move has been made, there are no pieces between the two kings (i.e. they can "see" each other), undo the move just made
        if (areNoPiecesBetweenKings(piece))
        {
          //If this move creates a facing kings situation, undo the move just made
          piece.getChessBoard().addPiece(piece.getChessBoard().removePiece(toRow, toColumn), rowBeforeMove, columnBeforeMove);
          if (savedPiece != null)
          {
            //If this move was a capture move, then place the piece captured back onto the board
            piece.getChessBoard().addPiece(savedPiece, toRow, toColumn);
          }
          return false;
        }
        //Sets that the piece has moved to true
        piece.setHasMoved(true);
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
   * Gets the number of rows on a Xiangqi Board
   * @return the number of rows on a Xiangqi Board
   */
  public int getNumRows()
  {
    return XIANGQI_NUM_ROWS;
  }
  
  /**
   * Gets the number of columns on a Xiangqi Board
   * @return the number of columns on a Xiagnqi Board
   */
  public int getNumColumns()
  {
    return XIANGQI_NUM_COLS;
  }
  
  /**
   * Starts a game of Xiangqi
   * @param board  the board on which the game of Xiangqi will be played
   */
  public void startGame(ChessBoard board)
  {
  
    /* The piece's initial positions on the board are being created under the assumption that this is a typical chess board (8 squares x 8 squares),
     * the two player sides are NORTH and SOUTH, and NORTH starts at row 0 and SOUTH starts at row 7 */
  
    /* Instanciate and place all pieces of the NORTH side on the board */
  
    //Instanciates a NORTH chariot chess piece at its starting position
    ChessPiece northChariot1 = new RookPiece(ChessGame.Side.NORTH, 0, 0, board);
    //Instanciates a NORTH horse chesspiece at its starting position
    ChessPiece northHorse1 = new HorsePiece(ChessGame.Side.NORTH, 0, 1, board);
    //Instanciates a NORTH elephant chess piece at its starting position
    ChessPiece northElephant1 = new ElephantPiece(ChessGame.Side.NORTH, 0, 2, board);
    //Instanciates a NORTH guard chess piece at its starting position
    ChessPiece northGuard1 = new GuardPiece(ChessGame.Side.NORTH, 0, 3, board);
    //Instanciates a NORTH xiangqi king chess piece at its starting position
    ChessPiece northXiangqiKing = new XiangqiKingPiece(ChessGame.Side.NORTH, 0, 4, board);
    //Instanciates a NORTH guard chess piece at its starting position
    ChessPiece northGuard2 = new GuardPiece(ChessGame.Side.NORTH, 0, 5, board);
    //Instanciates a NORTH elephant chess piece at its starting position
    ChessPiece northElephant2 = new ElephantPiece(ChessGame.Side.NORTH, 0, 6, board);
    //Instanciates a NORTH horse chess piece at its starting position
    ChessPiece northHorse2 = new HorsePiece(ChessGame.Side.NORTH, 0, 7, board);
    //Instanciates a NORTH chariot chess piece at its starting position
    ChessPiece northChariot2 = new RookPiece(ChessGame.Side.NORTH, 0, 8, board);
    //Instanciates a NORTH cannon chess piece at its starting position
    ChessPiece northCannon1 = new CannonPiece(ChessGame.Side.NORTH, 2, 1, board);
    //Instanciates a NORTH cannon chess piece at its starting position
    ChessPiece northCannon2 = new CannonPiece(ChessGame.Side.NORTH, 2, 7, board);
    //Instanciates a NORTH soldier chess piece at its starting position
    ChessPiece northSoldier1 = new SoldierPiece(ChessGame.Side.NORTH, 3, 0, board);
    //Instanciates a NORTH soldier chess piece at its starting position
    ChessPiece northSoldier2 = new SoldierPiece(ChessGame.Side.NORTH, 3, 2, board);
    //Instanciates a NORTH soldier chess piece at its starting position
    ChessPiece northSoldier3 = new SoldierPiece(ChessGame.Side.NORTH, 3, 4, board);
    //Instanciates a NORTH soldier chess piece at its starting position
    ChessPiece northSoldier4 = new SoldierPiece(ChessGame.Side.NORTH, 3, 6, board);
    //Instanciates a NORTH soldier chess piece at its starting position
    ChessPiece northSoldier5 = new SoldierPiece(ChessGame.Side.NORTH, 3, 8, board);
    //Adds the pieces on the NORTH side to the board
    board.addPiece(northChariot1, 0, 0);
    board.addPiece(northHorse1, 0, 1);
    board.addPiece(northElephant1, 0, 2);
    board.addPiece(northGuard1, 0, 3);
    board.addPiece(northXiangqiKing, 0, 4);
    board.addPiece(northGuard2, 0, 5);
    board.addPiece(northElephant2, 0, 6);
    board.addPiece(northHorse2, 0, 7);
    board.addPiece(northChariot2, 0, 8);
    board.addPiece(northCannon1, 2, 1);
    board.addPiece(northCannon2, 2, 7);
    board.addPiece(northSoldier1, 3, 0);
    board.addPiece(northSoldier2, 3, 2);
    board.addPiece(northSoldier3, 3, 4);
    board.addPiece(northSoldier4, 3, 6);
    board.addPiece(northSoldier5, 3, 8);
    
    /* Instanciate and place all pieces of the SOUTH side of the board */
      
    //Instanciates a SOUTH chariot chess piece at its starting position
    ChessPiece southChariot1 = new RookPiece(ChessGame.Side.SOUTH, 9, 0, board);
    //Instanciates a SOUTH horse chesspiece at its starting position
    ChessPiece southHorse1 = new HorsePiece(ChessGame.Side.SOUTH, 9, 1, board);
    //Instanciates a SOUTH elephant chess piece at its starting position
    ChessPiece southElephant1 = new ElephantPiece(ChessGame.Side.SOUTH, 9, 2, board);
    //Instanciates a SOUTH guard chess piece at its starting position
    ChessPiece southGuard1 = new GuardPiece(ChessGame.Side.SOUTH, 9, 3, board);
    //Instanciates a SOUTH xiangqi king chess piece at its starting position
    ChessPiece southXiangqiKing = new XiangqiKingPiece(ChessGame.Side.SOUTH, 9, 4, board);
    //Instanciates a SOUTH guard chess piece at its starting position
    ChessPiece southGuard2 = new GuardPiece(ChessGame.Side.SOUTH, 9, 5, board);
    //Instanciates a SOUTH elephant chess piece at its starting position
    ChessPiece southElephant2 = new ElephantPiece(ChessGame.Side.SOUTH, 9, 6, board);
    //Instanciates a SOUTH horse chess piece at its starting position
    ChessPiece southHorse2 = new HorsePiece(ChessGame.Side.SOUTH, 9, 7, board);
    //Instanciates a SOUTH chariot chess piece at its starting position
    ChessPiece southChariot2 = new RookPiece(ChessGame.Side.SOUTH, 9, 8, board);
    //Instanciates a SOUTH cannon chess piece at its starting position
    ChessPiece southCannon1 = new CannonPiece(ChessGame.Side.SOUTH, 7, 1, board);
    //Instanciates a SOUTH cannon chess piece at its starting position
    ChessPiece southCannon2 = new CannonPiece(ChessGame.Side.SOUTH, 7, 7, board);
    //Instanciates a SOUTH soldier chess piece at its starting position
    ChessPiece southSoldier1 = new SoldierPiece(ChessGame.Side.SOUTH, 6, 0, board);
    //Instanciates a SOUTH soldier chess piece at its starting position
    ChessPiece southSoldier2 = new SoldierPiece(ChessGame.Side.SOUTH, 6, 2, board);
    //Instanciates a SOUTH soldier chess piece at its starting position
    ChessPiece southSoldier3 = new SoldierPiece(ChessGame.Side.SOUTH, 6, 4, board);
    //Instanciates a SOUTH soldier chess piece at its starting position
    ChessPiece southSoldier4 = new SoldierPiece(ChessGame.Side.SOUTH, 6, 6, board);
    //Instanciates a SOUTH soldier chess piece at its starting position
    ChessPiece southSoldier5 = new SoldierPiece(ChessGame.Side.SOUTH, 6, 8, board);
    //Adds the pieces on the SOUTH side to the board
    board.addPiece(southChariot1, 9, 0);
    board.addPiece(southHorse1, 9, 1);
    board.addPiece(southElephant1, 9, 2);
    board.addPiece(southGuard1, 9, 3);
    board.addPiece(southXiangqiKing, 9, 4);
    board.addPiece(southGuard2, 9, 5);
    board.addPiece(southElephant2, 9, 6);
    board.addPiece(southHorse2, 9, 7);
    board.addPiece(southChariot2, 9, 8);
    board.addPiece(southCannon1, 7, 1);
    board.addPiece(southCannon2, 7, 7);
    board.addPiece(southSoldier1, 6, 0);
    board.addPiece(southSoldier2, 6, 2);
    board.addPiece(southSoldier3, 6, 4);
    board.addPiece(southSoldier4, 6, 6);
    board.addPiece(southSoldier5, 6, 8);
  }
}