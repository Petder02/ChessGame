/**
 * 
 * An interface representing a legal one space move in any direction
 * (hence the "omni-direcitonal" part of the interface name)
 * @author Peter Schlueter
 * 
 */
public interface OmniDirectionalOneSpaceMove
{
  /** 
   * Determines if moving the piece to the input location is a legal omni-directional one-space move
   * @param toRow    the row to which the piece is intended to be moved
   * @param toColumn the column to which the piece is intended to be moved
   * @param piece    the chess piece which is intended to be moved
   * @return true if the move is a legal omni-directional one-space move, false otherwise
   */
  default boolean isOmniDirectionalOneSpaceMove(int toRow, int toColumn, ChessPiece piece)
  {
    /* Line 17: Checks if this is a one space horizontal move
     * Line 18: Checks if this is a one space vertical move
     * Line 19: Checks if this is a one space diagonal move
     * If any of these conditions are true, return true, otherwise, return false  */
    if (((piece.getRow() == toRow) && (Math.abs(toColumn - piece.getColumn()) == 1))
        || ((Math.abs(toRow - piece.getRow()) == 1) && (piece.getColumn() == toColumn))
          ||  ((Math.abs(toRow - piece.getRow()) == 1) && (Math.abs(toColumn - piece.getColumn()) == 1)))
    {
      return true;
    }
    return false;
  }
}
    