package com.nunezeric.randomfact.randomFact.trivia.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author Eric Nunez
 */
@Entity
public class Trivia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "text")
    private String question;

    @ElementCollection
    private List<String> answers;

    @Column(name = "correct_answer")
    private String correctAnswer;

    public Trivia(){}

    public Trivia( String question, List<String> answers, String correctAnswer) {

        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public int hashCode() {
        final int HASH = 31;
        int result = 1;
        result = HASH * result + (this.id ^ (this.id >>> 32));
        result = HASH * result + this.question.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Trivia))
            return false;
        Trivia t = (Trivia) obj;
        if(this.id != t.id || this.answers !=t.answers) {
            return false;
        } else if(this.correctAnswer != t.correctAnswer ||
                this.question != t.question) {
            return false;
        }
        return true;
    }
}
