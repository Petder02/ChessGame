/**
 * 
 * An interface defining a vertical move of any length
 * where there are no pieces between a piece and its destination square
 * @author Peter Schlueter
 * 
 */
public interface VerticalMove
{
  
  /* Determines if a move is a vertical move of any number of spaces
   * @param toRow    the row to which the piece is intended to be moved
   * @param toColumn the column to which the piece is intended to be moved
   * @param piece    the chess piece the player is intending to move
   * @return true if the move is vertical and there are no pieces between this row and the row to be moved to, false otherwise
   */
  default boolean isVerticalMove(int toRow, int toColumn, ChessPiece piece)
  {
    //If the row does not change from the previous row, continue with the method
    if ((piece.getColumn() == toColumn) && (piece.getRow() != toRow))
    {
      if (piece.getRow() > toRow)
      {
        //Loop-Goal: Determine if there is a piece between the inputted row and the row where the piece is now
        for (int r = piece.getRow() - 1; r > toRow; r--)
        {
          //If there is a piece at r and this column, return false
          if (piece.getChessBoard().getPiece(r, piece.getColumn()) != null)
          {
            return false;
          }
        }
      }
      //Otherwise, do the same thing except count from the opposite direction
      else
      {
        
        //Loop-Goal: Determine if there is a piece between the inputted row and the row where the piece is now
        for (int r = piece.getRow() + 1; r < toRow; r++)
        {
          //If there is a piece at r and this column, return false
          if (piece.getChessBoard().getPiece(r, piece.getColumn()) != null)
          {
            return false;
          }
        }
      }
      //If both of these conditions fail, this is a legal vertical move
      return true;
    }
    return false;
  }
}