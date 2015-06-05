package ac.wits.elen7046.surveyapplication.entities;


import java.util.Date;
import java.util.List;


/**
 *
 * @author Ronald Menya
 */
public class Survey {
    
    private long id;
    private String name;
    private double version;
    private Location location;
    private Surveyor surveyor;
    private Respondent respondent;
    private List<Question> questions;
    private Date creationDate;
    private SurveyStatus surveyStatus;
    
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVersion() {
        return this.version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Surveyor getSurveyor() {
        return this.surveyor;
    }

    public void setSurveyor(Surveyor surveyor) {
        this.surveyor = surveyor;
    }

    public List<Question> getQuestions() {
        return this.questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
    
    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public Respondent getRespondent() {
        return respondent;
    }

    public void setRespondent(Respondent respondent) {
        this.respondent = respondent;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
