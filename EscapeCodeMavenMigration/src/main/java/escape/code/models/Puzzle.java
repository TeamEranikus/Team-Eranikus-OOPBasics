package escape.code.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "puzzle")
public class Puzzle implements Serializable{
    private Long id;
    private String question;
    private String correctAnswer;
    private String hint;
    private String imagePath;
    private String nextClue;
    private String levelName;


    /*public Puzzle(String question, String correctAnswer, String hint, String imagePath, String nextClue) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
        this.image = new Image(getClass().getResourceAsStream(imagePath));
        this.nextClue = nextClue;
    }*/

    public Puzzle(){

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getNextClue() {
        return nextClue;
    }

    public void setNextClue(String nextClue) {
        this.nextClue = nextClue;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean checkCorrectAnswer(String answer){
        if(answer.equals(getCorrectAnswer())){
            return true;
        }
        return false;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}

