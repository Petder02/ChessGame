import javax.swing.JOptionPane;

/**
 * 
 * An interface which defines what happens when a piece should be upgraded
 * @author Peter Schlueter
 * 
 */
public interface PieceUpgrade
{
  
  //Since this is after a move is made, the row and collumn parameters are not needed
  
  /** 
   * Upgrade a piece if it reached the other side
   * @param piece the chess piece to be upgraded
   */
  default void upgradePiece(ChessPiece piece)
  {
    if (piece.getToBeUpgraded() == true)
    {
      //int row stores the row of the piece being upgraded
      int row = piece.getRow();
      //int column stores the column of the piece being upgraded
      int column = piece.getColumn();
      //First, remove the piece at this location
      piece.getChessBoard().removePiece(piece.getRow(), piece.getColumn());
      //String response stores the users inputted piece if their pawn reaches the other side
      String response = JOptionPane.showInputDialog("Input the number corresponding with the piece you want to upgrade your pawn to: 1: Rook, 2: Bishop, 3: Knight, 4: Queen");
      //Add the piece specified by the user's entry
      switch (response)
      {
        case "1":
          piece = new RookPiece(piece.getSide(), row, column, piece.getChessBoard());
          piece.getChessBoard().addPiece(piece, row, column);
          break;
        case "2":
          piece = new BishopPiece(piece.getSide(), row, column, piece.getChessBoard());
          piece.getChessBoard().addPiece(piece, row, column);
          break;
        case "3":
          piece = new KnightPiece(piece.getSide(), row, column, piece.getChessBoard());
          piece.getChessBoard().addPiece(piece, row, column);
          break;
        case "4":
          piece = new QueenPiece(piece.getSide(), row, column, piece.getChessBoard());
          piece.getChessBoard().addPiece(piece, row, column);
          break;
        default:
          //If the input is invalid, I am choosing to default the piece upgrade to a queen (because it usually is one)
          piece = new QueenPiece(piece.getSide(), row, column, piece.getChessBoard());
          piece.getChessBoard().addPiece(piece, row, column);
      }
      //Reset toBeUpgraded to false
      piece.setToBeUpgraded(false);
    }
  }
}