package com.wordle.models;

import com.wordle.utils.Utils;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;

public class Grid {
    private ArrayList<JButton> rowA;
    private ArrayList<JButton> rowB;
    private ArrayList<JButton> rowC;
    private ArrayList<JButton> rowD;
    private ArrayList<JButton> rowE;
    private ArrayList<JButton> rowF;
    private int pos;
    
    public Grid(ArrayList<JButton> rowA, ArrayList<JButton> rowB, ArrayList<JButton> rowC, ArrayList<JButton> rowD, ArrayList<JButton> rowE, ArrayList<JButton> rowF){
        this.rowA = rowA;
        this.rowB = rowB;
        this.rowC = rowC;
        this.rowD = rowD;
        this.rowE = rowE;
        this.rowF = rowF;
        this.pos = 0;
    }

    // <editor-fold defaultstate="collapsed" desc="Getters e Setters">
    
    public ArrayList<JButton> getRowA() {
        return rowA;
    }

    public void setRowA(ArrayList<JButton> rowA) {
        this.rowA = rowA;
    }

    public ArrayList<JButton> getRowB() {
        return rowB;
    }

    public void setRowB(ArrayList<JButton> rowB) {
        this.rowB = rowB;
    }

    public ArrayList<JButton> getRowC() {
        return rowC;
    }

    public void setRowC(ArrayList<JButton> rowC) {
        this.rowC = rowC;
    }

    public ArrayList<JButton> getRowD() {
        return rowD;
    }

    public void setRowD(ArrayList<JButton> rowD) {
        this.rowD = rowD;
    }

    public ArrayList<JButton> getRowE() {
        return rowE;
    }

    public void setRowE(ArrayList<JButton> rowE) {
        this.rowE = rowE;
    }

    public ArrayList<JButton> getRowF() {
        return rowF;
    }

    public void setRowF(ArrayList<JButton> rowF) {
        this.rowF = rowF;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    //</editor-fold>
    
    public ArrayList<ArrayList> toList(){
        ArrayList<ArrayList> listObj = new ArrayList<ArrayList>();
        
        listObj.add(this.rowA);
        listObj.add(this.rowB);
        listObj.add(this.rowC);
        listObj.add(this.rowD);
        listObj.add(this.rowE);
        listObj.add(this.rowF);
                
        return listObj;
    }
    
    public ArrayList<String> rowToStringList(ArrayList<JButton> currentRow){
        ArrayList<String> stringRow = new ArrayList<String>();
        
        for(JButton item : currentRow){
            stringRow.add(item.getText());
        }
        
        return stringRow;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Place Letter">
    public void placeLetterRow(String tecla, int position){
        ArrayList<JButton> currentRow = this.toList().get(position);
        
        for(JButton item : currentRow){
            if(item.getText().equals("")){
                item.setText(tecla);
                break;
            }
        }
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Remove Letter">
    public void removeLetterRow(int position){
        ArrayList<JButton> currentRow = this.toList().get(position);
        
        for (int i = currentRow.size() - 1; i >= 0; i--) {
            JButton letter = currentRow.get(i);
            if(!letter.getText().equals("")){
                letter.setText("");
                break;
            }
        }
    }
    // </editor-fold>
    
    public void enterWord(int position, String[] validWords,String[] separateRandomWordDefault, Keyboard keyboardObject){
        ArrayList<JButton> currentRow = this.toList().get(position);
        String[] separateRandomWord = Arrays.copyOf(separateRandomWordDefault, separateRandomWordDefault.length);
        
        JButton lastLetter = currentRow.get(currentRow.size() - 1);
        if(!lastLetter.getText().equals("")){
            ArrayList<String> chosenWord = this.rowToStringList(currentRow);
            
            String fullChosenWord = String.join("", chosenWord);
            if(!Utils.checkValidWord(fullChosenWord, validWords))
                return;
            
            for(int i=0;i<currentRow.size();i++){
                String fullWord = String.join("", separateRandomWord);
                
                if(chosenWord.get(i).equals(separateRandomWord[i])){
                    currentRow.get(i).setForeground(Color.GREEN);
                    separateRandomWord[i] = "*";
                    
                    keyboardObject.setColor(chosenWord.get(i), Color.GREEN);
                }else if(fullWord.contains(chosenWord.get(i))){
                    currentRow.get(i).setForeground(Color.YELLOW);
                    separateRandomWord[fullWord.indexOf(chosenWord.get(i))] = "*";
                    
                    keyboardObject.setColor(chosenWord.get(i), Color.YELLOW);
                }else{
                    currentRow.get(i).setForeground(Color.BLACK);
                    
                    keyboardObject.setColor(chosenWord.get(i), Color.BLACK);
                }
            }
            
            Utils.checkWin(currentRow, position);
            this.setPos(this.getPos()+1);
        }
    }
}