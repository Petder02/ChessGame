import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * A class representative of a chess board display for Indo-European chess
 * @author Peter Schlueter
 * 
 */
public class JavaFXEuropeanChessDisplay implements JavaFXChessBoardDisplay
{
  
  //Field storing the primary background color of a tile on the chessboard
  private static Background darkCyanBackground = new Background(new BackgroundFill(Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY));
  
  //Field storing the secondary (alternate) background color of a tile on the chessboard
  private static Background linenBackground = new Background(new BackgroundFill(Color.LINEN, CornerRadii.EMPTY, Insets.EMPTY));
  
  //Field storing the background color of a piece on the north side of the chessboard
  private static BackgroundFill northPieceColor = new BackgroundFill(Color.IVORY, new CornerRadii(50), new Insets(5));
  
  //Field storing the background color of a piece on the south side of the chessboard
  private static BackgroundFill southPieceColor = new BackgroundFill(Color.SILVER, new CornerRadii(50), new Insets(5));
  
  //Field storing the background color of a piece on the west side of the chessboard
  private static BackgroundFill westPieceColor = new BackgroundFill(Color.DEEPPINK, new CornerRadii(50), new Insets(5));
  
  //Field storing the background color of a piece on the east side of the chessboard
  private static BackgroundFill eastPieceColor = new BackgroundFill(Color.TURQUOISE, new CornerRadii(50), new Insets(5));
  
  //Field storing the highlight color of the board display
  private static Background highlightColor = new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY));
  
  /**
   * @see JavaFXChessBoardDisplay#displayEmptySquare
   */
  public void displayEmptySquare(Button button, int row, int column) 
  {
    button.setBackground((row + column) % 2 == 0 ? darkCyanBackground : linenBackground);
    button.setText(null);
    button.setGraphic(null);
    //button.setSkin(I think this is the right method, takes a graphic (i.e. a Node))
  }
  
  /**
   * The citations for the links to each piece image are included after the method description
   * @see JavaFXChessBoardDisplay#displayFilledSquare
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
  public void displayFilledSquare(Button button, int row, int column, ChessPiece piece)
  {
    //BackgroundFill spaceColor stores the color of the background which the piece should have
    BackgroundFill spaceColor = ((row + column) % 2 == 0 ? darkCyanBackground.getFills().get(0) : linenBackground.getFills().get(0));
    
    //Set the Background of the piece on this button based on its side
    switch (piece.getSide())
    {
      case NORTH:
        button.setBackground(new Background(spaceColor, northPieceColor));
        break;
      case SOUTH:
        button.setBackground(new Background(spaceColor, southPieceColor));
        break;
      case WEST:
        button.setBackground(new Background(spaceColor, westPieceColor));
        break;
      default:
        button.setBackground(new Background(spaceColor, eastPieceColor));
        break;
    }
    /*
     * Implemenation of Icons for JavaFX European Chess Display (EXTRA CREDIT FEATURE)
     */
    //Image pieceImage stores new Image (initialized to null) which will store the image data of this piece
    Image pieceImage = (Image)piece.getIcon();
    
    //Depending on the label of the piece, set the image of the icon appropriately
    switch (piece.getLabel())
    {
      case "P":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/White Pawn Chess Piece.png") : new Image("Assets/Black Pawn Chess Piece.png"));
        break;
      case "N":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/White Knight Chess Piece.png") : new Image("Assets/Black Knight Chess Piece.png"));
        break;
      case "K":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/White King Chess Piece.png") : new Image("Assets/Black King Piece.png"));
        break;
      case "B":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/White Bishop Chess Piece.png") : new Image("Assets/Black Bishop Chess Piece.png"));
        break;
      case "Q":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/White Queen Chess Piece.png") : new Image("Assets/Black Queen Chess Piece.png"));
        break;
      default:
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/White Rook Chess Piece.png") : new Image("Assets/Black Rook Chess Piece.png"));
        break;
    }
    //ImageView pieceImageView stores the image of this piece's icon
    ImageView pieceImageView = new ImageView(pieceImage);
    //Set the bounds of pieceImageView so that the icon of the piece and its label fit within the bounds of the button
    pieceImageView.setFitHeight(button.getMinHeight() / 2);
    pieceImageView.setFitWidth(button.getMinWidth() / 2);
    //Set the icon/graphic of the piece to be the icon which represents the piece
    button.setGraphic(pieceImageView);
    
    //Finally, set the text of the button, which will appear next to the icon when the button is displayed
    button.setText(piece.getLabel());
  }
  
  /**
   * @see JavaFXChessBoardDisplay#highlightSquare
   */
  public void highlightSquare(boolean highlight, Button button, int row, int column, ChessPiece piece) 
  {
    if (highlight) 
    {
      button.setBackground(highlightColor);
    }
    else if (piece == null)
    {
      displayEmptySquare(button, row, column);
    }
    else
    {
      displayFilledSquare(button, row, column, piece);
    }
  }
        
    
  
}
  
  
  
  


