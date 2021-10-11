/**
 * 
 * A class which represents a Xiangqi Guard Piece
 * @author Peter Schlueter
 * 
 */
public class GuardPiece extends ChessPiece implements OneSpaceDiagonalMove
{
  
  /** 
   * Creates a guard piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public GuardPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "G", null, row, column, board);
  }
  
  /** 
   * Checks if the inputted move is legal for a guard
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for a guard and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    //Initially check if this move is legal for a general chess piece
    if (super.isLegalMove(toRow, toColumn))
    {
      //If this is a one space diagonal move and the move
      //does not exceed the "nine-point fortress" of this piece's side, then this is a legal move
      if (isOneSpaceDiagonalMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn())))
      {
        //Checking a piece of the NORTH side (Magic numers indicate position of nine-point fortress, since the number of rows and columns on the board is constant)
        if ((getSide() == ChessGame.Side.NORTH) && ((toRow > getChessBoard().getGameRules().getNumRows() - 8) ||
            (toColumn < getChessBoard().getGameRules().getNumColumns() - 6) || (toColumn > getChessBoard().getGameRules().getNumColumns() - 4)))
        {
          return false;
        }
        //Checking a piece of the SOUTH side (Magic numbers indicate position of nine-point fortress, since the number of rows and columns on the board is constant)
        if ((getSide() == ChessGame.Side.SOUTH) && ((toRow < getChessBoard().getGameRules().getNumRows() - 3) ||
            (toColumn < getChessBoard().getGameRules().getNumColumns() - 6) || (toColumn > getChessBoard().getGameRules().getNumColumns() - 4)))
        {
          return false;
        }
        return true;
      }
    }
    return false;
  }
}