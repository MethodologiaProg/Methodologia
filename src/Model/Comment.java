package Model;

public class Comment {
    private int id;
    private int senterId;
    private int entryId;
    private String message;
    
    /**
     *The class of the object comment
     * 
     * @param id The id of the comment
     * @param senterId The id of the user posting the comment
     * @param entryId The id of the entry the comment meant to be
     * @param message The message of the comment
     */
    public Comment(int id, int senterId, int entryId, String message){
        this.id = id;
        this.entryId = entryId;
        this.senterId = senterId;
        this.message = message;
    }

    /**Get the id
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**Set the id
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**Get the user id
     * @return the user id
     */
    public int getSenterId() {
        return senterId;
    }

    /**Set the user id
     * @param senterId the user id to set
     */
    public void setSenterId(int senterId) {
        this.senterId = senterId;
    }

    /**Get the entry id
     * @return the entryId
     */
    public int getEntryId() {
        return entryId;
    }

    /**Set the entry id
     * @param entryId the entryId to set
     */
    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    /**Get the message as a String
     * @return as String of the message
     */
    public String getMessage() {
        return message;
    }

    /**Set the message as a String
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
