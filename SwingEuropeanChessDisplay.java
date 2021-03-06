import javax.swing.JButton;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Toolkit;

/** 
 * 
 * Rules for how we want a board to display for a game of Indo-European chess
 * @author Peter Schlueter
 * 
 */
public class SwingEuropeanChessDisplay implements SwingChessBoardDisplay {
  
  /** The primary color of the checkerboard */
  public static Color redColor = Color.red;
  
  /** The secondary color of the checkerboard */
  public static Color blackColor = Color.black;
  
  /* The color of the SOUTH player */
  public static Color southPlayerColor = Color.yellow;
  
  /* The color of the NORTH player */
  public static Color northPlayerColor = Color.green;
  
  /* The color of the EAST player */
  public static Color eastPlayerColor = Color.white;
  
  /* The color of the WEST player */
  public static Color westPlayerColor = Color.gray;
  
  /** The color used to highlight a square */
  public static Color highlightColor = Color.blue;
  
  /**
   * Display a square that has no piece on it.  Will produce a red/black checkerboard.
   * @param button the button that is used for the chessboard square
   * @param row    the row of this square on the board
   * @param column the column of this square on the board
   */
  public void displayEmptySquare(JButton button, int row, int column) {
    button.setBackground((row + column) % 2 == 0 ? Color.black : Color.red);
    button.setText(null);
    button.setIcon(null);
  }

  /**
   * Display a square that has a piece on it.
   * The citations with the links to where to find each image used for the piece are included after the method description
   * @param button the button that is used for the chessboard square
   * @param row    the row of this square on the board
   * @param column the column of this square on the board
   * @param piece  the piece that is on this square
   * @see <a href = "https://www.pngwing.com/en/free-png-nmshz"> Black King Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-nztse"> White King Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-mtson"> Black Pawn Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-zqdau"> White Rook Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-ywkje"> Black Rook Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-ynfmi"> Black Knight Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-ygabq"> Black Bishop Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-nfltq"> Black Queen Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-nconw"> White Bishop Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-pbiiv"> White Knight Chess Piece Image Source </a>
   * @see <a href = "https://www.pngkit.com/view/u2w7e6y3u2o0a9t4_white-silhouette-chess-piece-public-domain-vectors-queen/"> White Queen Chess Piece Image Source </a>
   * @see <a href = "https://www.pngwing.com/en/free-png-mwhsn"> White Pawn Chess Piece Image Source </a>
   */
  public void displayFilledSquare(JButton button, int row, int column, ChessPiece piece) {
    Color pieceColor;
    
    switch (piece.getSide()) {
      case NORTH:   pieceColor = northPlayerColor;
                    break;
      case SOUTH:   pieceColor = southPlayerColor;
                    break;
      case EAST:    pieceColor = eastPlayerColor;
                    break;
      default:      pieceColor = westPlayerColor;
    }
    
    button.setBackground(pieceColor);
    //Note that the next of the button will appear next to the icon of the button on the display
    button.setText(piece.getLabel());
    /*
     * Implementation of Icons for Swing European Chess Display (EXTRA CREDIT FEATURE)
     * Segment below does the following:
     * 1.) First, stores the Icon of the piece into the variable pieceIcon
     * 2.) Sets the Icon of the piece depending on the piece type
     * 3.) Constructs a new ImageIcon using with image scaledImage (stored in variable scaledPieceIcon)
     */
    //Icon pieceIcon stores the icon of this piece (see step 1.) above)
    ImageIcon pieceIcon = (ImageIcon)piece.getIcon();
    
    //Depending on the label of the piece, set its icon appropriately (see step 2.) above)
    switch (piece.getLabel())
    {
      case "P":
        pieceIcon = (piece.getSide() == ChessGame.Side.NORTH ? new ImageIcon("Assets/White Pawn Chess Piece.png") : new ImageIcon("Assets/Black Pawn Chess Piece.png"));
        break;
      case "N":
        pieceIcon = (piece.getSide() == ChessGame.Side.NORTH ? new ImageIcon("Assets/White Knight Chess Piece.png") : new ImageIcon("Assets/Black Knight Chess Piece.png"));
        break;
      case "K":
        pieceIcon = (piece.getSide() == ChessGame.Side.NORTH ? new ImageIcon("Assets/White King Chess Piece.png") : new ImageIcon("Assets/Black King Piece.png"));
        break;
      case "B":
        pieceIcon = (piece.getSide() == ChessGame.Side.NORTH ? new ImageIcon("Assets/White Bishop Chess Piece.png") : new ImageIcon("Assets/Black Bishop Chess Piece.png"));
        break;
      case "Q":
        pieceIcon = (piece.getSide() == ChessGame.Side.NORTH ? new ImageIcon("Assets/White Queen Chess Piece.png") : new ImageIcon("Assets/Black Queen Chess Piece.png"));
        break;
      default:
        pieceIcon = (piece.getSide() == ChessGame.Side.NORTH ? new ImageIcon("Assets/White Rook Chess Piece.png") : new ImageIcon("Assets/Black Rook Chess Piece.png"));
        break;
    }
    //ImageIcon scaledPieceIcon will store a scaled version of the piece's icon based on the initial size of a board square (see step 3.) above)
    ImageIcon scaledPieceIcon = new ImageIcon(pieceIcon.getImage().getScaledInstance(getSquareSize(), getSquareSize(), Image.SCALE_DEFAULT));
    
    //Finally, set the icon of this button to be the ImageIcon scaledPieceIcon
    button.setIcon(scaledPieceIcon);
  }
  
  /**
   * Highlight a square of the board.
   * @param highlight  do we want the highlight on (true) or off (false)?
   * @param button     the button that is used for the chessboard square
   * @param row        the row of this square on the board
   * @param column     the column of this square on the board
   * @param piece      the piece (if any) that is on this square
   */
  public void highlightSquare(boolean highlight, JButton button, int row, int column, ChessPiece piece) {
    if (highlight) {
      button.setBackground(highlightColor);
    }
    else if (piece == null)
      displayEmptySquare(button, row, column);
    else
      displayFilledSquare(button, row, column, piece);
  }
}