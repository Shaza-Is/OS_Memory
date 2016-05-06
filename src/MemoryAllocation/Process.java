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
public class Process extends Block {
    private static int idGen = 0;
    public int id;
    public int size;
    public int start;
    
    public void assignId() {
        id = idGen++;
    }
    
    public static void resetIDGen() {
        idGen = 0;
    }
}
