/**
 * 
 * A class representing a Rook chess piece for Indo-European Chess
 * and a Chariot chess piece for Xiangqi (Chariots and Rooks have the same legal move,
 * so they are grouped together in this class and are both referred to as rooks)
 * @author Peter Schlueter
 * 
 */
public class RookPiece extends ChessPiece implements HorizontalMove, VerticalMove
{
  
  /* This section contains the contructor for a rook chess piece */
  
  /**
   * Creates a rook chess piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public RookPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "R", null, row, column, board);
  }
  
  /* This section contains methods which define a rook piece's move rules */

  /**
   *  Checks if the inputted moved is legal for a rook (vertical, horizontal, and has no pieces in its way)
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for a rook and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    //If the move is not out of bounds or not set to the original position, continue with the method
    if (super.isLegalMove(toRow, toColumn))
    {
      //If the move is legal for a rook, return true
      if ((isVerticalMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn())))
        || (isHorizontalMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn()))))
      {
        return true;
      }
    }
    return false;
  }

}