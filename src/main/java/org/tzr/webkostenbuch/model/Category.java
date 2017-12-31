/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tzr.webkostenbuch.model;

/**
 *
 * @author cthies
 */
public class Category implements Comparable<Category>{
    
    private String id;
    private String description;

    public Category(String id, String description) {
        this.id = id;
        this.description = description;
    }

    @Override
    public String toString() {
        return "["+id+"("+description+")]";
    }

    @Override
    public int compareTo(Category o) {
        return this.getId().compareTo(o.getId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
 
    
    
}
