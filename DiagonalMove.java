/**
 * 
 * An interface defining a diagonal move of any length,
 * where there are no pieces between a piece and its destination square
 * @author Peter Schlueter
 * 
 */
public interface DiagonalMove
{
  
  /* Determines if moving the piece to the inputted location is a legal diagonal move
   * @param toRow    the row to which the piece is to be moved
   * @param toColumn the column to which the piece is to be moved
   * @param piece    the chess piece the player is intending to move
   * @return true if this is a legal diagonal move, false otherwise
   */
  default boolean isDiagonalMove(int toRow, int toColumn, ChessPiece piece)
  {
    //If the desired destination (toRow and toColumn) match the current location of the piece, return false
    if ((toRow == piece.getRow()) && (toColumn == piece.getColumn()))
    {
      return false;
    }
    //If the piece is moving an equal number of rows and collumns, continue with the method
    if ((Math.abs(piece.getRow() - toRow) == Math.abs(piece.getColumn() - toColumn)))
    {
      
      //Loop-Goal: Determine if a south-east bound piece has any pieces in its way, return false if it does
      for (int r = piece.getRow() + 1, c = piece.getColumn() + 1; r < toRow && c < toColumn; r++, c++)
      {
        if (piece.getChessBoard().getPiece(r, c) != null)
        {
          return false;
        }
      }
      
      //Loop-Goal: Determine if a north-east bound piece has any pieces in its way, return false if it does
      for (int r = piece.getRow() - 1, c = piece.getColumn() + 1; r > toRow && c < toColumn; r--, c++)
      {
        if (piece.getChessBoard().getPiece(r, c) != null)
        {
          return false;
        }
      }
      
      //Loop-Goal: Determine if a south-west bound piece has any pieces in its way, return false if it does
      for (int r = piece.getRow() + 1, c = piece.getColumn() - 1; r < toRow && c > toColumn; r++, c--)
      {
        if (piece.getChessBoard().getPiece(r, c) != null)
        {
          return false;
        }
      }
      
      //Loop-Goal: Determine if a north-west bound piece has any pieces in its way, return false if it does
      for (int r = piece.getRow() - 1, c = piece.getColumn() - 1; r > toRow && c > toColumn; r--, c--)
      {
        if (piece.getChessBoard().getPiece(r, c) != null)
        {
          return false;
        }
      }
      //If none of these loops return false, this is a legal diagonal move
      return true;
    }
    return false;
  }

}
      
      