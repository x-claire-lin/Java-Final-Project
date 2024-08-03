/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 * Represents a subscription message.
 * Contains information about the sender, recipient, content, and send date.
 * 
 * @author Dunxing Yu 
 * @version 1.0
 */
public class SubscriptionMsg {
    
    private int id;
    private String senderName;
    private int recipientID;
    private String content; 
    private Date dateSent;

    /**
     * Constructs a new SubscriptionMsg object.
     */
    public SubscriptionMsg() {
    }
    /**
     * Gets the ID of the message.
     * 
     * @return The message.
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the ID of the message.
     * 
     * @param id The message id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the sender.
     * 
     * @return The sender's name.
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * Sets the name of the sender.
     * 
     * @param senderName The sender's name to set.
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     * Gets the ID of the recipient.
     * 
     * @return The recipient's ID.
     */
    public int getRecipientID() {
        return recipientID;
    }

    /**
     * Sets the ID of the recipient.
     * 
     * @param recipientID The recipient's ID to set.
     */
    public void setRecipientID(int recipientID) {
        this.recipientID = recipientID;
    }

    /**
     * Gets the content of the message.
     * 
     * @return The message content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the message.
     * 
     * @param content The message content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the date when the message was sent.
     * 
     * @return The date when the message was sent.
     */
    public Date getDateSent() {
        return dateSent;
    }

    /**
     * Sets the date when the message was sent.
     * 
     * @param dateSent The date when the message was sent to set.
     */
    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    /**
     * Returns a string representation of the SubscriptionMsg object.
     * 
     * @return A string representation of the SubscriptionMsg object.
     */
    @Override
    public String toString() {
        return "SubscriptionMsg{" + "senderName=" + senderName + ", recipientID=" + recipientID + ", content=" + content + ", dateSent=" + dateSent + '}';
    }
}