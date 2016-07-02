package escape.code.daos.puzzledaos;

import escape.code.models.Puzzle;

import java.util.List;

public interface PuzzleDao {
    List<Puzzle> getAllByLevel(String levelName);
    void createPuzzle(Puzzle puzzle);
}
