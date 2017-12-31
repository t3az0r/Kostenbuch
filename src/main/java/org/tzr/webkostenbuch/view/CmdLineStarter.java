/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tzr.webkostenbuch.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.tzr.webkostenbuch.controller.ControllerMonatsblatt;
import org.tzr.webkostenbuch.model.Monthsheet;
import org.tzr.webkostenbuch.model.Category;
import org.tzr.webkostenbuch.model.Position;


/**
 *
 * @author cthies
 */
public class CmdLineStarter {

    private static final Calendar CALENDAR = Calendar.getInstance();
    private static final String COLUMN_SEPARATOR = ";";
    private static final String ROW_SEPARATOR = "\n";
    
    private Monthsheet currentMonth;
    private List<Monthsheet> allMonths = new ArrayList<Monthsheet>();
    
    public CmdLineStarter() {
        //bootstrap
        CALENDAR.setTime(new Date());
        currentMonth = new Monthsheet();
        currentMonth.setYear(CALENDAR.get(Calendar.YEAR));
        currentMonth.setMonth(CALENDAR.get(Calendar.MONTH));
        final Category c1 = new Category("c1", "Lebensmittel");
        final Category c2 = new Category("c2", "Auto");
        final Category c3 = new Category("c3", "Haus");
        final Category c4 = new Category("c4", "d4");
        
        currentMonth.getCategories().add(c3);
        currentMonth.getCategories().add(c1);
        currentMonth.getCategories().add(c2);
        //currentMonth.getCategories().add(c4);
        
        {
            Position position1 = new Position();
            position1.setCategory(c1);
            CALENDAR.add(Calendar.DATE, -3);
            position1.setDate(CALENDAR.getTime());
            position1.setAmount(10.50f);
            position1.setDescription("Kekse");

            currentMonth.getPositions().add(position1);
        }
        {
            Position position1 = new Position();
            position1.setCategory(c1);
            CALENDAR.add(Calendar.DATE, +6);
            position1.setDate(CALENDAR.getTime());
            position1.setAmount(10.50f);
            position1.setDescription("Kekse");

            currentMonth.getPositions().add(position1);
        }
        {
            Position position1 = new Position();
            position1.setCategory(c1);
            CALENDAR.add(Calendar.DATE, -9);
            position1.setDate(CALENDAR.getTime());
            position1.setAmount(10.50f);
            position1.setDescription("Kekse");

            currentMonth.getPositions().add(position1);
        }
        
        {
            Position position1 = new Position();
            position1.setCategory(c2);
            CALENDAR.set(2017, 11, 6);
            position1.setDate(CALENDAR.getTime());
            position1.setAmount(250.50f);
            position1.setDescription("Auspuff");

            currentMonth.getPositions().add(position1);
        }
        {
            Position position1 = new Position();
            position1.setCategory(c2);
            CALENDAR.set(2017, 11, 17);
            position1.setDate(CALENDAR.getTime());
            position1.setAmount(400.50f);
            position1.setDescription("Reifen");

            currentMonth.getPositions().add(position1);
        }
        {
            Position position1 = new Position();
            position1.setCategory(c2);
            CALENDAR.set(2017, 11, 27);
            position1.setDate(CALENDAR.getTime());
            position1.setAmount(88.50f);
            position1.setDescription("Ölwechsel");

            currentMonth.getPositions().add(position1);
        }

        System.out.println("org.tzr.webkostenbuch.view.CmdLineStarter.main()" + currentMonth.getYear());
        System.out.println("org.tzr.webkostenbuch.view.CmdLineStarter.main()" + currentMonth.getMonth());
        System.out.println("org.tzr.webkostenbuch.view.CmdLineStarter.main()" + currentMonth.getCategories());
        System.out.println("org.tzr.webkostenbuch.view.CmdLineStarter.main()" + currentMonth.getPositions());


        System.out.println("org.tzr.webkostenbuch.view.CmdLineStarter.<init>()" + ControllerMonatsblatt.sumCat(currentMonth, c1));
        System.out.println("org.tzr.webkostenbuch.view.CmdLineStarter.<init>()" + ControllerMonatsblatt.sumCat(currentMonth, c2));
        System.out.println("org.tzr.webkostenbuch.view.CmdLineStarter.<init>()" + ControllerMonatsblatt.sumCat(currentMonth, c3));
        System.out.println("org.tzr.webkostenbuch.view.CmdLineStarter.<init>()" + ControllerMonatsblatt.sumCat(currentMonth, c4));


        
    }
    
    public static void main(String[] args) {
        CmdLineStarter cmdLineStarter = new CmdLineStarter();
        cmdLineStarter.printOverview();
    }
    
    private String monthHashMap[] = new String[]{ "Jan", "Feb" , "Mar" , "Apr" , "May" , "Jun" , "Jul" , "Aug" , "Sep" , "Oct" , "Nov" , "Dec" };
    
    public void printOverview() {
        
        Monthsheet m = currentMonth;
        StringBuffer sbuf = new StringBuffer();

        //meta
        String month = monthHashMap[m.getMonth()];
        String year = String.valueOf(m.getYear());
        
        //header
        sbuf.append(""+month+"/"+year);
        for (Category c : m.getCategories()) {
            sbuf.append(COLUMN_SEPARATOR);
            sbuf.append(c.getDescription());
        }
        sbuf.append(ROW_SEPARATOR);
        
        //body
        for (Position p : m.getPositions()) {
            sbuf.append(p.getDate()+":"+p.getDescription());
            for (Category c : m.getCategories()) {
                sbuf.append(COLUMN_SEPARATOR);
                if (p.getCategory().equals(c)) {
                    sbuf.append(p.getAmount());
                } else {
                    sbuf.append(" ");
                }
            }
            sbuf.append(ROW_SEPARATOR);
        }

        //footer
        sbuf.append("sums");
        for (Category c : m.getCategories()) {
            sbuf.append(COLUMN_SEPARATOR);
            sbuf.append(ControllerMonatsblatt.sumCat(m, c));
        }
        sbuf.append(ROW_SEPARATOR);
        
        System.out.println(sbuf.toString());
        
    }
}
