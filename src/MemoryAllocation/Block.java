/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemoryAllocation;

/**
 *
 * @author tootis
 */
public class Block {
    public double start_px;
    public double end_px;
    
    double height() {
        return end_px - start_px;
    }
    
    boolean collidesWith(Block h) {
        System.out.println("THIS START_PX: " + start_px);
        System.out.println("THIS END_PX: " + end_px);
        System.out.println("THAT START_PX: " + h.start_px);
        System.out.println("THAT END_PX: " + h.end_px);

        if(h.start_px == start_px || start_px == h.end_px || h.start_px == end_px)
            return true;
        else if(start_px < h.start_px && h.start_px < end_px)
            return true;
        else if(h.start_px < start_px && start_px < h.end_px)
            return true;
        
        return false;
    }
}
