/**
 * 
 * A class which represents a Xiangqi King Piece
 * @author Peter Schlueter
 * 
 */
public class XiangqiKingPiece extends ChessPiece implements OneSpaceHorizontalMove, OneSpaceVerticalMove
{
  
  /** 
   * Creates a Xiangqi king chess piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public XiangqiKingPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "X", null, row, column, board);
  }
  
  /** 
   * Checks if the inputted move is legal for a king (vertical, horizontal, or diagonal of one space)
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for a king and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    //Initially check if this move is legal for a general chess piece
    if (super.isLegalMove(toRow, toColumn))
    {
      //If this is a one space vertical move or one space horizontal move and
      //does not exceed the "nine-point fortress" of that pieces side
      if (isOneSpaceHorizontalMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn())) ||
          isOneSpaceVerticalMove(toRow, toColumn, getChessBoard().getPiece(getRow(), getColumn())))
      {
        //Prevent a xiangqi king piece from moving into check
        //if (getChessBoard().squareThreatened(toRow, toColumn, this))
        //{
          //return false;
        //}
        //Checking a piece of the NORTH side (Magic numbers indicate position of nine-point fortress, since the number of rows and columns on the board is constant)
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