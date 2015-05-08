package ac.wits.elen7046.surveyapplication.entities;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Ronald Menya
 */
public class Question {

    /**
     * 
     */
    private long id;
    
    /**
     * 
     */
    private String description;
    
    /**
     * 
     */
    private List<Response> responses;
    
    /**
     * 
     * @param  
     */
    public void setId(long id) {
        if (id <= 0 ) {
           throw new RuntimeException("ID must be greater than 0");
        }
        
        this.id = id;
    }

    /**
     * 
     * @return 
     */
    public long getId() {
        return this.id;
    }

    /**
     * 
     * @param 
     */
    public void setDescription(String description) {
        if (description == null || description.length() == 0) {
            throw new RuntimeException("description can not be null or empty.");
        }
        
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        return this.description;
    }
    
    /**
     * 
     * @param 
     */ 
    public void setResponses(List<Response> responses) {
        this.responses = responses;    
    }

    /**
     * 
     * @return  
     */ 
    public List<Response> getResponses() {
        return this.responses;
    }
    /**
     * 
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Question other = (Question) obj;
        if (this.id != other.id) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", description=" + description + '}';
    }
}