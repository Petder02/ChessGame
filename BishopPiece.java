//Peter Schlueter, This class represents a bishop chess piece

/**
 * 
 * A class representing a Bishop Chess Piece in European Chess
 * @author Peter Schlueter
 * 
 */
public class BishopPiece extends ChessPiece implements DiagonalMove
{
  
  /* This section contains the contructor for a bishop chess piece */
  
  /**
   * Creates a bishop chess piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public BishopPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "B", null, row, column, board);
  }
  
  /* This section contains methods which define a bishop piece's move rules */
  
  /**
   * Checks if the inputted moved is legal for a bishop (diagonal and has no pieces in its way)
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for a bishop and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    //If the move is not out of bounds or not set to the original position, continue with the method
    if (super.isLegalMove(toRow, toColumn))
    {
      //If the move is legal for a bishop, return true
      if ((isDiagonalMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn()))))
      {
        return true;
      }
    }
    return false;
  }
  
}