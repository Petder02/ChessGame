# ChessGame
A playable implementation of European Chess and Xiangqi done using Java\
Note: This was a project for CSDS 132 - Introduction to Programming in Java\
Note 2: The author Harold Connamacher contributed to some of the classes for this project\
\
# How to run the project
1. Navigate to the directory the following directory in your project structure: "[project_directory]/out/artifacts"\
2. There should be two folders in this directory. Each contains a .jar file labeled with the graphics library it is created with\
3. For the Swing .jar file, no command arguments are required, just navigate to the directory of the Swing jar and type "java -jar ChessGameJavaSwing.jar" to run the .jar file\
4. For the JavaFX .jar file, you need to specify the type of chess you want to play, otherwise the program will error out with an IndexOutOfBoundsException\
5. To play European Chess using the JavaFX .jar file, navigate to the directory of the JavaFX jar file and type "java -jar ChessGameJavaFX.jar" "chess"\
6. To play Xiangqi using the JavaFX .jar file, navigate to the directory of the JavaFX jar file and type "java -jar ChessGameJavaFX.jar" "xiangqi"
