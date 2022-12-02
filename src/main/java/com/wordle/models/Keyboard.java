package com.wordle.models;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Keyboard {
    private JTextPane firstRow;
    private JTextPane secondRow;
    private JTextPane thirdRow;
    private int pos;
    
    public Keyboard(JTextPane firstRow, JTextPane secondRow, JTextPane thirdRow){
        this.firstRow = firstRow;
        this.secondRow = secondRow;
        this.thirdRow = thirdRow;
        this.pos = 0;
    }

    public JTextPane getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(JTextPane firstRow) {
        this.firstRow = firstRow;
    }

    public JTextPane getSecondRow() {
        return secondRow;
    }

    public void setSecondRow(JTextPane secondRow) {
        this.secondRow = secondRow;
    }

    public JTextPane getThirdRow() {
        return thirdRow;
    }

    public void setThirdRow(JTextPane thirdRow) {
        this.thirdRow = thirdRow;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
    
    public int getKeysAmountInPos(int pos){
        switch(pos){
            case 0:
                return 10;
            case 1:
                return 9;
            case 2:
                return 7;
            default:
                return 0;
        }
    }
    
    public ArrayList<JTextPane> toList(){
        ArrayList<JTextPane> toList = new ArrayList<JTextPane>();
        
        toList.add(firstRow);
        toList.add(secondRow);
        toList.add(thirdRow);
        
        return toList;
    }
    
    public void setColor(String text, Color color){
        this.setPos(0);
        
        while(this.getPos() < 3){
            ArrayList<JTextPane> keyRows = this.toList();
            JTextPane pane = keyRows.get(this.getPos());
            int j = this.getKeysAmountInPos(this.getPos());
            boolean found = false;
            String queryLetter = "";
        
            StyledDocument doc = pane.getStyledDocument();

            Style style = pane.addStyle("Color Style", null);
            StyleConstants.setForeground(style, color);
            
            try {
                for(int i=0;i<j;i++){
                    queryLetter = doc.getText(i*4, 1);
                    
                    Element letterElement = doc.getCharacterElement(i*4);
                    AttributeSet elementAttribs = letterElement.getAttributes();
                    Color currentColor = StyleConstants.getForeground(elementAttribs);
                    
                    if(text.equals(queryLetter)){
                        if((!currentColor.equals(Color.GREEN) && !color.equals(Color.BLACK)) || (currentColor.equals(Color.GRAY) && color.equals(Color.BLACK)) ){
                            doc.remove(i*4, 2);
                            doc.insertString(i*4, text+" ", style);
                            
                            found = true;
                            
                            break;
                        }
                    }
                }
                this.setPos(this.getPos()+1);
            } 
            catch (BadLocationException e) {
                e.printStackTrace();
            }
            
            if(found == true){
                break;
            }
        }
    }
}