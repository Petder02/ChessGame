/**
 * 
 * A class which represents a Xiangqi Elephant Piece
 * @author Peter Schlueter
 * 
 */
public class ElephantPiece extends ChessPiece implements DiagonalMove
{
  
  /** 
   * Creates an elephant piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public ElephantPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "E", null, row, column, board);
  }
  
  /** 
   * Checks if the inputted move is legal for an elephant
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for an elephant and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    if (super.isLegalMove(toRow, toColumn))
    {
      //If this move would not be two squares in a diagonal direction, disallow it
      if ((Math.abs(getRow() - toRow) != 2) || (Math.abs(getColumn() - toColumn) != 2))
      {
        return false;
      }
      //If this move is diagonal (and at this point less than two spaces), continue with the method
      if (isDiagonalMove(toRow, toColumn, this))
      {
        //If this move would cross the top half of the board (if on NORTH side)
        //or the bottom half of the board (if on SOUTH side), disallow it
        if ((getSide() == ChessGame.Side.NORTH) && (toRow >= (getChessBoard().getGameRules().getNumRows() / 2)))
        {
          return false;
        }
        if ((getSide() == ChessGame.Side.SOUTH) && (toRow < (getChessBoard().getGameRules().getNumRows() / 2)))
        {
          return false;
        }
        return true;
      }
    }
    return false;
  }
}