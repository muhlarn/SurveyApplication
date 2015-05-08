package ac.wits.elen7046.surveyapplication.entities;


/**
 *
 * @author Ronald Menya
 */
public class Response {

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
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    /**
     * 
     * @return
     * @param 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Response other = (Response) obj;
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
        return "Response{" + "id=" + id + ", description=" + description + '}';
    }
}
