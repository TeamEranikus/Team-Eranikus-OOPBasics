package escape.code;

import escape.code.core.Game;
import escape.code.services.puzzleService.PuzzleService;
import escape.code.services.puzzleService.PuzzleServiceImpl;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class AppRun extends Application {

    @Override
    public void start(Stage primaryStage){
        //StageManager stageManager = new StageManager();
        //FXMLLoader loader = stageManager.loadSceneToPrimaryStage(primaryStage, Constants.LOGIN_FXML_PATH);

        //Todo: when you furst build the program change hibernateUnils line 55 form update to create, then comment from here
        String[][] taskParams = {
                {"-What the following code will print?", "piano", "Do you really need the numbers?", "What could it be??", "/pictures/ComputerTaskWhite.png", "0"},
                {"-One piano button is stuck!", "13", "How will you EXit?", "You are one step away from the exit.", "/pictures/PianoTask.jpg", "0"},
                {"-The way to unlock the door is to know the secret number.", "111", "Do you see something unusual?", "The door is open now.", "/pictures/LibraryWithJoker.jpg", "0"},
                {"-Does the chessboard reminds you of something?","matrix","[][]","Oh, look it's currently playing!","/pictures/chessboard.jpg", "1"},
                {"","coffee","It's hot","What could it be??","/pictures/TvPuzzle.png", "1"},
                {"Who collects the garbage?","garbage collector","Be like Java!! Collect your own garbage.","The second door is open now.","/pictures/Bin.png", "1"}

        };
        PuzzleService puzzleService = new PuzzleServiceImpl();
        Arrays.stream(taskParams).forEach(puzzleService::createPuzzle);
        // Todo: to here, and rechange to update agein


        Game game = new Game(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}


