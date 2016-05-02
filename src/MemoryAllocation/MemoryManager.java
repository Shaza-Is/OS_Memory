package MemoryAllocation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tootis
 */
public class MemoryManager extends JPanel {
    
    private final double MEM_SHAPE_WIDTH = 130;
    private final double MEM_SHAPE_HEIGHT = 500;
    private final double MEM_MAX_SIZE = 1023;
    private final ArrayList<Hole> holes;
    private final ArrayList<Process> processes;
    
    public MemoryManager() {
        setBackground(Color.blue);
        holes = new ArrayList<>();
        processes = new ArrayList<>();
    }
    
    public void addHole(Hole h) {
        h.start_px = (h.start * MEM_SHAPE_HEIGHT) / MEM_MAX_SIZE;
        h.end_px = ((h.start + h.size) * MEM_SHAPE_HEIGHT) / MEM_MAX_SIZE;
        
        System.out.println("ADDING HOLE");
        System.out.println("START PIX: " + h.start_px);
        System.out.println("END PIX: " + h.end_px);
        System.out.println();
        
        boolean collision = false;
        int currentIndex = 0;
        for(Hole h2 : holes) {
            System.out.println("CHECKING FOR COLLISION!");
            if(h.collidesWith(h2))
            {
                System.out.println("COLLISION!!!");
                Hole newHole = 
                        createHoleFromCollision(h, holes.remove(currentIndex));
                collision = true;
                addHole(newHole);
                break;
            }
            currentIndex++;
        }
        
        if (!collision) {
            holes.add(h);
            System.out.println("COUNT OF HOLES NOW: " + holes.size());
            System.out.println("=====================");
            repaint();
        }
    }
    
    private Hole createHoleFromCollision(Hole h1, Hole h2) {
        Hole newHole = new Hole();
        
        newHole.start = (h1.start < h2.start) ? h1.start : h2.start;
        System.out.println();
        
        if(h1.end_px > h2.end_px) {
            newHole.size = 
                   (int) ((h1.end_px * MEM_MAX_SIZE) / MEM_SHAPE_HEIGHT) - newHole.start;
        } else {
            newHole.size = 
                   (int) ((h2.end_px * MEM_MAX_SIZE) / MEM_SHAPE_HEIGHT) - newHole.start;
        }
        
        System.out.println("NEW HOLE SIZE: " + newHole.size);
        
        return newHole;
    }
    
    public void deallocateProcess(Process p) {
        
    }
    
    public void addProcess(Process p, String algo) {
        
    } 
    
    private void firstFit(Process p) {
        
    }
    
    private void bestFit(Process p) {
        
    }
    
    private void worstFit(Process p) {
        
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setColor(Color.red);
        for(Hole h : holes) {
            Rectangle2D r = new Rectangle2D.Double(0, h.start_px, MEM_SHAPE_WIDTH, (h.end_px - h.start_px));
            g2d.fill(r);
        }
    }
}