/**
 * 
 * A class which represents a Xiangqi Soldier Piece
 * @author Peter Schlueter
 * 
 */
public class SoldierPiece extends ChessPiece implements OneSpaceHorizontalMove
{
  
  /** 
   * Creates a Xiangqi king chess piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public SoldierPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "S", null, row, column, board);
  }
  
  /** 
   * Checks if the inputted move is legal for a soldier
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for a king and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    if (super.isLegalMove(toRow, toColumn))
    {
      //If this piece is on the NORTH side, do the following checks
      if (getSide() == ChessGame.Side.NORTH)
      {
        //If this piece is moving up one space, return true
        if ((getColumn() == toColumn) && (getRow() - toRow == -1))
        {
          return true;
        }
        //If this piece is of the NORTH side and has crossed the middle of the board, it can also make a one space horizontal move
        //Integer division erros are avoided, since 10 (the number of rows of the board) divides evenly into 2
        if ((toRow >= (getChessBoard().getGameRules().getNumRows() / 2)) && (isOneSpaceHorizontalMove(toRow, toColumn, this)))
        {
          return true;
        }
      }
      //If this piece is on the SOUTH side, do the following checks
      if (getSide() == ChessGame.Side.SOUTH)
      {
        //If this piece is moving up one space, return true
        if ((getColumn() == toColumn) && (getRow() - toRow == 1))
        {
          return true;
        }
        //If this piece is of the SOUTH side and has crossed the middle of the board, it can also make a one space horizontal move
        //Integer division errors are avoided since 10 (the number of rows of the board) divides evenly into 2
        if ((toRow < (getChessBoard().getGameRules().getNumRows() / 2)) && (isOneSpaceHorizontalMove(toRow, toColumn, this)))
        {
          return true;
        }
      }
    }
    return false;
  }
}