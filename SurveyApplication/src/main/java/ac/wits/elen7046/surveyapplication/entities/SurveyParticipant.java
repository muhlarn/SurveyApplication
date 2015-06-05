package ac.wits.elen7046.surveyapplication.entities;


/**
 *
 * @author Ronald Menya
 */
public abstract class SurveyParticipant {
    
    protected long id;
    private String firstname;
    private String lastname;
    private int age;
    
    public SurveyParticipant() {
        id = System.currentTimeMillis();
    }      

    public long getId() {
        return id;
    }

    public void setFirstname(String firstname) {
        if (firstname == null || firstname.length() == 0) {
            throw new RuntimeException("firstname can not be null or empty.");
        }
        
        this.firstname = firstname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setLastname(String lastname) {
        if (lastname == null || lastname.length() == 0) {
            throw new RuntimeException("lastname can not be null or empty.");
        }
        
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new RuntimeException("Expecting an adult");
        }
        
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}
