//Peter Schlueter, Creates and defines some properties of a chess piece
//Note: A chess piece is sometimes refered to as just a piece in comments of this code
//Note 2: Although there are implementations of all methods in this class, it is still abstract because I may add other implementations in the future

//Note 3: To the reader, I used comments in methods for both debugging purposes and readability,
//but, and this only applies for comments INSIDE methods, some of them may be outdated.

//Import package java.io.* for the purposes of debugging piece hierarchy through printing what is going on in problem areas
import java.io.*;


/**
 * 
 * A class representing general properties of a Chess Piece
 * @author Peter Schlueter
 * 
 */
public abstract class ChessPiece implements LMove
{
  
  /* These are properties of a chess piece (class/instance fields) */
  
  //Field storing side which a chess piece is on
  private ChessGame.Side side;
  
  //Field storing a chess piece label
  private String label;
  
  //Field storing a chess piece icon (graphical representation of a chess piece)
  private Object icon;
  
  //Field storing the row in which a chess piece is in
  private int row;
  
  //Field storing the collumn in which a chess piece is in
  private int column;
    
  //Field storing the chess board the chess piece is on
  private ChessBoard board;
  
  //Field storing whether or not a piece has moved this game
  private boolean hasMoved = false;
  
  //Field storing if the piece should be upgraded
  private boolean toBeUpgraded = false;
  
  //Field storing if the piece at an inputted spot should be removed
  private boolean toBeRemoved = false;
  
  /* Section containing constructor for a chess piece */
  
  /**
   *  Creates a chess piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param label  the chess piece label
   * @param icon   the chess piece icon
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public ChessPiece(ChessGame.Side side, String label, Object icon, int row, int column, ChessBoard board)
  {
    this.side = side;
    this.label = label;
    this.icon = icon;
    this.row = row;
    this.column = column;
    this.board = board;
  }
  
  /* Section containing getter/setter methods for properties of a chess piece */
  
  /**
   * Gets whether or not this piece has moved this game
   * @return true if the piece has moved this game, false otherwise
   */
  public boolean getHasMoved()
  {
    return this.hasMoved;
  }
  
  /**
   * Sets whether or not this piece has moved
   * @param hasMoved whether or not this piece has moved
   */
  public void setHasMoved(boolean hasMoved)
  {
    this.hasMoved = hasMoved;
  }
  
  /**
   * Gets whether or not the piece should be upgraded this turn
   * @return true if the piece should be upgraded this turn, false otherwise
   */
  public boolean getToBeUpgraded()
  {
    return this.toBeUpgraded;
  }
  
  /**
   * Sets whether or not the piece should be upgraded this turn
   * @param toBeUpgraded whether or not the piece should be upgraded this turn
   */
  public void setToBeUpgraded(boolean toBeUpgraded)
  {
    this.toBeUpgraded = toBeUpgraded;
  }
  
  /**
   * Gets whether or not this piece should be removed from the board
   * @return whether or not this piece should be removed from the game
   */
  public boolean getToBeRemoved()
  {
    return this.toBeRemoved;
  }
  
  /**
   * Sets whether or not this piece should be removed from the board
   * @param toBeRemoved whether or not this piece should be removed from the board
   */
  public void setToBeRemoved(boolean toBeRemoved)
  {
    this.toBeRemoved = toBeRemoved;
  }
  
  /**
   * Gets the player side the chess piece is on
   * @return side which chess piece is on
   */
  public ChessGame.Side getSide()
  {
    return this.side;
  }
  
  /**
   * Gets a non-visual representation of a chess piece
   * @return label identifying the chess piece
   */
  public String getLabel()
  {
    return this.label;
  }
  
  /**
   * Gets a visual representation of a chess piece
   * @return icon identifying the chess piece
   */
  public Object getIcon()
  {
    return this.icon;
  }
  
  /**
   * Sets a chess piece's location on the board
   * @param row    the row which the chess piece is in
   * @param column the collumn which the chess piece is in
   */
  public void setLocation(int row, int column)
  {
    this.row = row;
    this.column = column;
  }
  
  /**
   * Gets the row in which a chess piece is in
   * @return row which chess piece resides in
   */
  public int getRow()
  {
    return this.row;
  }
  
  /**
   * Gets the column in which a chess piece is in
   * @return column which chess piece resides in
   */
  public int getColumn()
  {
    return this.column;
  }
  
  /**
   * Gets the chess board which the chess piece is on
   * @return chess board which chess piece resides on
   */
  public ChessBoard getChessBoard()
  {
    return this.board;
  }
  
  /* isLegalMove is overriden in extended classes. A default implimentation is provided here */
  
  /**
   * Determines whether or not the chess piece move is legal
   * @param toRow    stores row which chess piece is intended to be moved to
   * @param toColumn stores column which chess piece is intended to be moved to
   * @return true if the piece doesn't go off the board, false if it does or input location is the same as the current one
   */
  public boolean isLegalMove(int toRow, int toColumn)
  {
    //ChessBoard board is the current chessboard
    ChessBoard board = getChessBoard();
    //If the input location goes off the board, return false
    if ((toRow > board.getGameRules().getNumRows()) || (toColumn > board.getGameRules().getNumColumns()) || (toRow < 0) || (toColumn < 0))
    {
      return false;
    }
    //A piece cannot move if the location to be moved to is the same as the current location
    if ((this.getRow() == toRow) && (this.getColumn() == toColumn))
    {
      return false;
    }
    //If all conditions fail to return false, return true
    return true;
  }
  
  /* This section contains methods that will be implimented in individual chess pieces (abstract methods) */
  
  /**
   * Determines whether or not a move is legal given the location to be moved to is unoccupied
   * @param row    stores the row which the chess piece is intended to be moved
   * @param column stores the column which the chess piece is intended to be moved
   * @return true if the chess piece can be moved to the given location, false if not
   */
  public boolean isLegalNonCaptureMove(int row, int column)
  {
    //If the move is legal, continue with the method
    if (isLegalMove(row, column))
    {
      
      //If there is not a piece on the square which the piece is intended to be moved to
      //and the two pieces are not of the same side, set the piece's location to the new position and return true
      if ((getChessBoard().getPiece(row, column) == null))
      {
        //ChessPiece piece stores the ChessPiece being moved
        ChessPiece piece = getChessBoard().removePiece(getRow(), getColumn());
        //If this piece is an instance of a king, check if it is castling
        if (piece instanceof KingPiece)
        {
          //KingPiece castlingCheck stores a KingPiece which will check if the move is castling
          KingPiece castlingCheck = (KingPiece)this;
          //If the piece is castling, make sure to move the rook before the king
          if (castlingCheck.isCastleMove(row, column, castlingCheck) && (castlingCheck.getColumn() < column))
          {
            //ChessPiece movePiece stores the rook which should be moved for castling
            ChessPiece movePiece = getChessBoard().removePiece(row, getChessBoard().getGameRules().getNumColumns() - 1);
            getChessBoard().addPiece(movePiece, row, column - 1);
          }
          if (castlingCheck.isCastleMove(row, column, castlingCheck) && (castlingCheck.getColumn() > column))
          {
            //ChessPiece movePiece stores the rook which should be moved for castling
            ChessPiece movePiece = getChessBoard().removePiece(row, 0);
            getChessBoard().addPiece(movePiece, row, column + 1);
          }
        }
        //Sets that the piece at this spot has moved this game
        piece.setHasMoved(true);
        //Add the piece to the new position on the game board
        getChessBoard().addPiece(piece, row, column);
        return true;
      }
    }
    return false;
  }
  
  /**
   * Determines whether or not a move is legal given the location to be moved to is occupied
   * @param row    stores the row which the chess piece is intended to be moved
   * @param column stores the column which the chess piece is intended to be moved
   * @return true if the chess piece can be moved to the given location, false if not
   */
  public boolean isLegalCaptureMove(int row, int column)
  {
    //If the move is legal, continue with the method
    if (isLegalMove(row, column))
    {
      //If there is a piece on the square, continue with the method
      if (getChessBoard().getPiece(row, column) != null)
      {
        //If this piece is on the opposing side (the side of the current piece
        //(which has not moved yet) is not equal to the side of the piece in the space we want to move to),
        //remove the piece at this position and set the piece's location to the new position and return true
        if (!((getChessBoard().getPiece(getRow(), getColumn()).getSide()).equals(getChessBoard().getPiece(row, column).getSide())))
        {
          //Reset toBeRemoved
          setToBeRemoved(false);
          //First, make the opposing piece null
          ChessPiece remove = getChessBoard().getPiece(row, column);
          remove = null;
          //ChessPiece piece stores the ChessPiece being moved
          ChessPiece piece = getChessBoard().removePiece(getRow(), getColumn());
          getChessBoard().addPiece(piece, row, column);
          //Sets that the piece that just moved has moved this game
          piece.setHasMoved(true);
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * Handles necessary processesing after the move is completed
   * Note: This method currently does nothing since all end of move processing is done in the methods
   * listed in the comments in the body of this method
   */
  public void moveDone()
  {
    //In the current state of the project, all end of move processing is done in the following methods and classes
    //1.) isLegalCaptureMove() (from ChessPiece)
    //2.) isLegalNonCaptureMove() (from ChessPiece)
    //3.) EuropeanChess class (handles setting that the piece has moved this game
    //So, at this current time this method is only here because it was listed as necessary in the project directions
    //Also, again since this method currently does nothing, I do not think that it is necessary to test it in the testing class
  }
}
  
  