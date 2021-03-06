/**
 * 
 * A class representing a Queen chess piece
 * @author Peter Schlueter
 * 
 */
public class QueenPiece extends ChessPiece implements VerticalMove, HorizontalMove, DiagonalMove
{
  
  /* This section contains the constructor for a queen chess piece */
  
  /**
   * Creates a queen chess piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public QueenPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "Q", null, row, column, board);
  }
  
  /* This section contains methods which define a queen piece's move rules */
  
  /**
   * Checks if the inputted moved is legal for a queen (vertical, horizontal, or diagonal and has no pieces in its way)
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for a queen and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    //If the move is not out of bounds or not set to the original position, continue with the method
    if (super.isLegalMove(toRow, toColumn))
    {
      //If the move is legal for a queen, return true
      if ((isVerticalMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn())))
        || (isHorizontalMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn())))
          || (isDiagonalMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn()))))
      {
        return true;
      }
    }
    return false;
  }

}