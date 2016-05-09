/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Hrystos
 */
public class Comment {
    private int id;
    private int senterId;
    private int entryId;
    private String message;
    
    public Comment(int id, int senterId, int entryId, String message){
        this.id = id;
        this.entryId = entryId;
        this.senterId = senterId;
        this.message = message;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the senterId
     */
    public int getSenterId() {
        return senterId;
    }

    /**
     * @param senterId the senterId to set
     */
    public void setSenterId(int senterId) {
        this.senterId = senterId;
    }

    /**
     * @return the entryId
     */
    public int getEntryId() {
        return entryId;
    }

    /**
     * @param entryId the entryId to set
     */
    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
}
