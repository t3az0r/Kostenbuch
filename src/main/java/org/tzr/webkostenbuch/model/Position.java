/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tzr.webkostenbuch.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author cthies
 */
@Entity
@Table(name = "POSITION")
@NamedQueries({
    @NamedQuery(name = "Position.findAll", query = "SELECT i FROM Position i"),
    @NamedQuery(name = "Position.findByCategory", query = "SELECT i FROM Position i WHERE i.category = :category"),
    @NamedQuery(name = "Position.findByDate", query = "SELECT i FROM Position i WHERE i.date = :date"),
    @NamedQuery(name = "Position.findByDescription", query = "SELECT i FROM Position i WHERE i.description = :description")
})
public class Position implements Comparable<Position>{

    private Category category;
    private Date date;
    private float amount;
    private String description;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{"+date+":"+description+":"+category+":"+amount+"}";
    }

    @Override
    public int compareTo(Position o) {
        return this.getDate().compareTo(o.getDate());
    }
            
    
    
}
