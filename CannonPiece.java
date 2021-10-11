/**
 * 
 * A class which represents a Xiangqi Cannon Piece
 * @author Peter Schlueter
 * 
 */
public class CannonPiece extends ChessPiece implements HorizontalMove, VerticalMove
{
  
  /** 
   * Creates a cannon piece with the given user specifications
   * @param side   the side in which the chess piece is on
   * @param row    the row the chess piece is in
   * @param column the column the chess piece is in
   * @param board  the board the chess piece is on
   */
  public CannonPiece(ChessGame.Side side, int row, int column, ChessBoard board)
  {
    super(side, "C", null, row, column, board);
  }
  
  /** 
   * Checks if the inputted move is legal for a cannon
   * @param toRow    stores the row which the rook is intended to be moved to
   * @param toColumn stores the column which the rook is intended to be moved to
   * @return true if the move is legal for a cannon and not going off the board or in the same location as before, false otherwise
   */
  @Override
  public boolean isLegalMove(int toRow, int toColumn)
  {
    if (super.isLegalMove(toRow, toColumn))
    {
      //If this is a valid vertical or horizontal move (any number of spaces), continue checking for the moves legality
      if (isVerticalMove(toRow, toColumn, this) ||
          isHorizontalMove(toRow, toColumn, this))
      {
        //To avoid a NullPointerException in the next if statement, if there is no piece on the destination square, return true
        if (getChessBoard().getPiece(toRow, toColumn) == null)
        {
          return true;
        }
      }
        //If there is a piece on this piece's destination square coordinates (i.e. toRow and toColumn of the board),
        //check that there is exactly one piece on the path to the piece's destination square
        if (getChessBoard().hasPiece(toRow, toColumn))
        {
          //int piecesInPath stores the number of pieces in this piece's path to the other side
          int piecesInPath = 0;
          
          /* This section checks if there is a piece in this piece's path for horizontal moves */
          if (getRow() > toRow)
          {
            
            //Loop-Goal: Determine if there is exactly one piece between the inputted row and the row where the piece is now
            for (int r = getRow() - 1; r > toRow; r--)
            {
              //If there is a piece at r and this column, increment piecesInPath
              if (getChessBoard().getPiece(r, getColumn()) != null)
              {
                piecesInPath++;
              }
            }
          }
          else if (getRow() < toRow)
          {
            
            //Loop-Goal: Determine if there is a piece between the inputted row and the row where the piece is now
            for (int r = getRow() + 1; r < toRow; r++)
            {
              //If there is a piece at r and this column, increment piecesInPath
              if (getChessBoard().getPiece(r, getColumn()) != null)
              {
                piecesInPath++;
              }
            }
          }
          
          /* This section checks if there is exactly one piece in this pieces path for vertical moves */
          else if (getColumn() > toColumn)
          {
             
            //Loop-Goal: Determine if there is a piece between the inputted column and the column where the piece is now
            for (int c = getColumn() - 1; c > toColumn; c--)
            {
              //If there is a piece at this row and column c, increment piecesInPath
              if (getChessBoard().getPiece(getRow(), c) != null)
              {
                piecesInPath++;
              }
            }
          }
          else
          {
        
            //Loop-Goal: Determine if there is a piece between the inputted column and the column where the piece is now
            for (int c = getColumn() + 1; c < toColumn; c++)
            {
              //If there is a piece at this row and column c, increment piecesInPath
              if (getChessBoard().getPiece(getRow(), c) != null)
              {
                piecesInPath++;
              }
            }
          }
          System.out.println("Pieces in path: " + piecesInPath);
          //If there is exactly one piece in this piece's path, then this piece can capture another piece
          return piecesInPath == 1;
        }
      }
    return false;
  }
}