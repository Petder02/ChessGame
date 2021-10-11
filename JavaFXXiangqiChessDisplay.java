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
 * A class representative of a chess board display for Xiangqi
 * @author Peter Schlueter
 * 
 */
public class JavaFXXiangqiChessDisplay implements JavaFXChessBoardDisplay
{
  
  //Field storing the primary background color of a tile on the chessboard
  private static Background lightGrayBackground = new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, new Insets(5)));
  
  //Field storing the secondary (alternate) background color of a tile on the chessboard
  private static Background darkGrayBackground = new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, new Insets(5)));
  
  //Field storing the background color of a piece on the north side of the chessboard
  private static BackgroundFill northPieceColor = new BackgroundFill(Color.RED, new CornerRadii(50), new Insets(5));
  
  //Field storing the background color of a piece on the south side of the chessboard
  private static BackgroundFill southPieceColor = new BackgroundFill(Color.SILVER, new CornerRadii(50), new Insets(5));
  
  //Fiekd storing the background color of a piece on the west side of the chessboard
  private static BackgroundFill westPieceColor = new BackgroundFill(Color.DEEPPINK, new CornerRadii(50), new Insets(5));
  
  //Field storing the background color of a piece on the east side of the chessboard
  private static BackgroundFill eastPieceColor = new BackgroundFill(Color.TURQUOISE, new CornerRadii(50), new Insets(5));
  
  //Field storing the highlight color of the board display
  private static Background highlightColor = new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY));

  //TODO: Have diagonal lines run through edges of nine-point fortress
  /**
   * @see JavaFXChessBoardDisplay#displayEmptySquare
   */
  public void displayEmptySquare(Button button, int row, int column) 
  {
    button.setBackground(lightGrayBackground);
    if (((row == 0) || (row == 1) || (row == 2) || (row == 7) || (row == 8) || (row == 9))
       && ((column == 3) || (column == 4) || (column == 5)))
    {
      button.setBackground(darkGrayBackground);
    }
    button.setText(null);
    button.setGraphic(null);
  }
  
  /**
   * The link to the picture from which all piece icons are derived from cna be found after the method description
   * @see JavaFXChessBoardDisplay#displayFilledSquare
   * @see <a href = "https://www.pinterest.com/pin/540220917777814056/"> All Xiangqi Piece Icons Image Source </a>
   */
  public void displayFilledSquare(Button button, int row, int column, ChessPiece piece)
  {
    //BackgroundFill spaceColor stores the color of the background which the piece should have
    BackgroundFill spaceColor = lightGrayBackground.getFills().get(0);
    
     if (((row == 0) || (row == 1) || (row == 2) || (row == 7) || (row == 8) || (row == 9))
       && ((column == 3) || (column == 4) || (column == 5)))
    {
      spaceColor = darkGrayBackground.getFills().get(0);
    }
    
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
     * Implemenation of Icons for JavaFX Xiangqi Display (EXTRA CREDIT FEATURE)
     */
    //Image pieceImage stores new Image which will store the image data of this piece
    Image pieceImage = (Image)piece.getIcon();
    
    //Depending on the label of the piece, set the image of the icon appropriately
    switch (piece.getLabel())
    {
      case "X":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/Red Xiangqi King Piece.png") : new Image("Assets/Black Xiangqi King Piece.png"));
        break;
      case "G":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/Red Xiangqi Guard Piece.png") : new Image("Assets/Black Xiangqi Guard Piece.png"));
        break;
      case "E":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/Red Xiangqi Elephant Piece.png") : new Image("Assets/Black Xiangqi Elephant Piece.png"));
        break;
      case "H":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/Red Xiangqi Horse Piece.png") : new Image("Assets/Black Xiangqi Horse Piece.png"));
        break;
      case "C":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/Red Xiangqi Cannon Piece.png") : new Image("Assets/Black Xiangqi Cannon Piece.png"));
        break;
      case "R":
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/Red Xiangqi Rook Piece.png") : new Image("Assets/Black Xiangqi Rook Piece.png"));
        break;
      default:
        pieceImage = (piece.getSide() == ChessGame.Side.NORTH ? new Image("Assets/Red Xiangqi Soldier Piece.png") : new Image("Assets/Black Xiangqi Soldier Piece.png"));
        break;
    }
    //ImageView pieceImageView stores the image of this piece's icon
    ImageView pieceImageView = new ImageView(pieceImage);
    //Set the bounds of pieceImageView so that the icon of the piece and its label fit within the bounds of the button
    pieceImageView.setFitHeight(button.getMinHeight() / 2);
    pieceImageView.setFitWidth(button.getMinWidth() / 2);
    //Set the icon/graphic of the piece to be the icon which represents the piece
    button.setGraphic(pieceImageView);
    button.setText(piece.getLabel());
    
    //Finally, set the text of the button, which will appear next to the button's icon when the button is displayed
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