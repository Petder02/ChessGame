/**
 *
 * An interface defining a horizontal move of any length,
 * where the piece being moved has no pieces between it and its destination square
 * @author Peter Schlueter
 *
 */
public interface HorizontalMove
{
  /**
   * Determines if a move is a horizontal move of any number of spaces
   * @param toRow    the row to which the piece is intended to be moved
   * @param toColumn the column to which the piece is intended to be moved
   * @param piece    the chess piece the player is intending to move
   * @return true if the move is horizontal and there are no pieces between this row and the row to be moved to, false otherwise
   */
  default boolean isHorizontalMove(int toRow, int toColumn, ChessPiece piece)
  {
    //If the row does not change from the previous row, then this is at least a horizontal move
    if ((piece.getRow() == toRow) && (piece.getColumn() != toColumn))
    {
      if (piece.getColumn() > toColumn)
      {
      
        //Loop-Goal: Determine if there is a piece between the inputted column and the column where the piece is now
        for (int c = piece.getColumn() - 1; c > toColumn; c--)
        {
          //If there is a piece at this row and column c, return false
          if (piece.getChessBoard().getPiece(piece.getRow(), c) != null)
          {
            return false;
          }
        }
      }
      //Otherwise, do the same thing except count from the oposite direction
      else
      {
        
        //Loop-Goal: Determine if there is a piece between the inputted column and the column where the piece is now
        for (int c = piece.getColumn() + 1; c < toColumn; c++)
        {
          //If there is a piece at this row and column c, return false
          if (piece.getChessBoard().getPiece(piece.getRow(), c) != null)
          {
            return false;
          }
        }
      }
      //If the if and else clauses fail to return false, then this is a legal horizontal move
      return true;
    }
    return false;
  }
}