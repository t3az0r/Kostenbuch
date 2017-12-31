/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tzr.webkostenbuch.controller;

import org.tzr.webkostenbuch.model.Category;
import org.tzr.webkostenbuch.model.Monthsheet;
import org.tzr.webkostenbuch.model.Position;

/**
 *
 * @author cthies
 */
public class ControllerMonatsblatt {
    
    public static Float sumCat(Monthsheet m, Category c) {
        Float result = 0.0f;
        
        //assertions
        if (null == m || null == c) return null;
        
        if (!m.getCategories().contains(c)) return null;
        
        for (Position p : m.getPositions()) {
            if (p.getCategory().equals(c)) {
                result += p.getAmount();
            }
        }
        
        return result;
    }
    
}
