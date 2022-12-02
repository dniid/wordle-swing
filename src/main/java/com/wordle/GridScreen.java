package com.wordle;

import com.wordle.utils.Utils;
import com.wordle.models.Grid;
import com.wordle.models.Keyboard;
import com.wordle.models.Settings;
import java.awt.AWTEvent;
import java.awt.Image;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author nid
 */
public class GridScreen extends javax.swing.JFrame implements AWTEventListener{
    private String tecla;
    private String[] validWords;
    private String[] separateRandomWord;
    private String randomWord;
    
    private ArrayList<JButton> rowA;
    private ArrayList<JButton> rowB;
    private ArrayList<JButton> rowC;
    private ArrayList<JButton> rowD;
    private ArrayList<JButton> rowE;
    private ArrayList<JButton> rowF;
    private Grid grid;
    
    private KeyboardScreen keyboardScreen;
    private Keyboard keyboardObject;
    private boolean keyboardOpen;
    
    private SettingsScreen settingsScreen;
    private Settings settingsObject;
    private boolean settingsOpen;
    private String currentLanguage;
    private String currentDifficulty;
    
    private Connection connection;

    /**
     * Creates new form Wordle
     */
    public GridScreen() {
        databaseConnection();
        initComponents();
        initVariables();
        
        initIcons();
        bindKeyboardCloseAction();
        bindSettingsActions();
    }

    private void handleKeyEvent(String tecla){
        if(tecla.matches("^[a-zA-Z]*$") && tecla.length() == 1){
            grid.placeLetterRow(tecla, grid.getPos());
        }else if(tecla.equals("Backspace")){
            grid.removeLetterRow(grid.getPos());
        }else if(tecla.equals("Enter")){
            grid.enterWord(grid.getPos(), validWords, separateRandomWord, keyboardObject);
        }
    }

    private void initVariables(){
        getSettingsDB();
                
        rowA = new ArrayList<JButton>();
        rowB = new ArrayList<JButton>();
        rowC = new ArrayList<JButton>();
        rowD = new ArrayList<JButton>();
        rowE = new ArrayList<JButton>();
        rowF = new ArrayList<JButton>();
        appendButtons();
        
        grid = new Grid(rowA, rowB, rowC, rowD, rowE, rowF);
        
        keyboardScreen = new KeyboardScreen();
        keyboardObject = new Keyboard(keyboardScreen.getKeyboardRowA(), keyboardScreen.getKeyboardRowB(), keyboardScreen.getKeyboardRowC());
        keyboardOpen = false;
        
        settingsScreen = new SettingsScreen();
        checkSettingsButtonGroup();
        settingsObject = new Settings(settingsScreen.getDifficulty(), settingsScreen.getLanguage(), settingsScreen.getSaveBtn(), settingsScreen.getCancelBtn());
        
        validWords = Utils.getValidWords(currentLanguage);
        separateRandomWord = Utils.getWord(currentLanguage);
        randomWord = String.join("", separateRandomWord);
        
        this.getToolkit().addAWTEventListener(this, AWTEvent.KEY_EVENT_MASK);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Append Buttons to List">
    private void appendButtons(){
        rowA.add(A1Letter);
        rowA.add(A2Letter);
        rowA.add(A3Letter);
        rowA.add(A4Letter);
        rowA.add(A5Letter);
        
        rowB.add(B1Letter);
        rowB.add(B2Letter);
        rowB.add(B3Letter);
        rowB.add(B4Letter);
        rowB.add(B5Letter);
       
        rowC.add(C1Letter);
        rowC.add(C2Letter);
        rowC.add(C3Letter);
        rowC.add(C4Letter);
        rowC.add(C5Letter);
        
        rowD.add(D1Letter);
        rowD.add(D2Letter);
        rowD.add(D3Letter);
        rowD.add(D4Letter);
        rowD.add(D5Letter);
        
        rowE.add(E1Letter);
        rowE.add(E2Letter);
        rowE.add(E3Letter);
        rowE.add(E4Letter);
        rowE.add(E5Letter);
        
        rowF.add(F1Letter);
        rowF.add(F2Letter);
        rowF.add(F3Letter);
        rowF.add(F4Letter);
        rowF.add(F5Letter);
    }
    // </editor-fold>
    
    @Override
    public void eventDispatched(AWTEvent event) {
        if(event instanceof KeyEvent key){
            if(key.getID()==KeyEvent.KEY_PRESSED){
                tecla = KeyEvent.getKeyText(key.getKeyCode());
                
                handleKeyEvent(tecla);
                
                // Debugging
                if(key.isAltDown()&&key.isControlDown()&&(key.isShiftDown())){
                    JOptionPane.showMessageDialog(null, "A palavra que está em jogo é: " + randomWord);
                }
                key.consume();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        A1Letter = new javax.swing.JButton();
        A2Letter = new javax.swing.JButton();
        A3Letter = new javax.swing.JButton();
        A4Letter = new javax.swing.JButton();
        A5Letter = new javax.swing.JButton();
        B1Letter = new javax.swing.JButton();
        B2Letter = new javax.swing.JButton();
        B3Letter = new javax.swing.JButton();
        B4Letter = new javax.swing.JButton();
        B5Letter = new javax.swing.JButton();
        C1Letter = new javax.swing.JButton();
        C2Letter = new javax.swing.JButton();
        C3Letter = new javax.swing.JButton();
        C4Letter = new javax.swing.JButton();
        C5Letter = new javax.swing.JButton();
        D1Letter = new javax.swing.JButton();
        D2Letter = new javax.swing.JButton();
        D3Letter = new javax.swing.JButton();
        D4Letter = new javax.swing.JButton();
        D5Letter = new javax.swing.JButton();
        E1Letter = new javax.swing.JButton();
        E2Letter = new javax.swing.JButton();
        E3Letter = new javax.swing.JButton();
        E4Letter = new javax.swing.JButton();
        E5Letter = new javax.swing.JButton();
        F1Letter = new javax.swing.JButton();
        F2Letter = new javax.swing.JButton();
        F3Letter = new javax.swing.JButton();
        F4Letter = new javax.swing.JButton();
        F5Letter = new javax.swing.JButton();
        ShowKeyboard = new javax.swing.JButton();
        Settings = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wordle");
        setResizable(false);

        A1Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        A1Letter.setEnabled(false);

        A2Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        A2Letter.setEnabled(false);

        A3Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        A3Letter.setEnabled(false);

        A4Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        A4Letter.setEnabled(false);

        A5Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        A5Letter.setEnabled(false);

        B1Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        B1Letter.setEnabled(false);

        B2Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        B2Letter.setEnabled(false);

        B3Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        B3Letter.setEnabled(false);

        B4Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        B4Letter.setEnabled(false);

        B5Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        B5Letter.setEnabled(false);

        C1Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        C1Letter.setEnabled(false);

        C2Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        C2Letter.setEnabled(false);

        C3Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        C3Letter.setEnabled(false);

        C4Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        C4Letter.setEnabled(false);

        C5Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        C5Letter.setEnabled(false);

        D1Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        D1Letter.setEnabled(false);

        D2Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        D2Letter.setEnabled(false);

        D3Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        D3Letter.setEnabled(false);

        D4Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        D4Letter.setEnabled(false);

        D5Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        D5Letter.setEnabled(false);

        E1Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        E1Letter.setEnabled(false);

        E2Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        E2Letter.setEnabled(false);

        E3Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        E3Letter.setEnabled(false);

        E4Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        E4Letter.setEnabled(false);

        E5Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        E5Letter.setEnabled(false);

        F1Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        F1Letter.setEnabled(false);

        F2Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        F2Letter.setEnabled(false);

        F3Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        F3Letter.setEnabled(false);

        F4Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        F4Letter.setEnabled(false);

        F5Letter.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        F5Letter.setEnabled(false);

        ShowKeyboard.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        ShowKeyboard.setText("Mostrar Letras");
        ShowKeyboard.setFocusable(false);
        ShowKeyboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowKeyboardActionPerformed(evt);
            }
        });

        Settings.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        Settings.setToolTipText("");
        Settings.setAlignmentY(0.0F);
        Settings.setBorder(null);
        Settings.setBorderPainted(false);
        Settings.setFocusable(false);
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ShowKeyboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(A1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(A5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(B1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(B5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(C1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(C5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(D1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(D5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(E1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(E5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(F1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(F5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(Settings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(A1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(A5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(C1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(D1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(D5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(E1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(E5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(F1Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F2Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F3Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F4Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(F5Letter, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ShowKeyboard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Settings.getAccessibleContext().setAccessibleName("Settings");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ShowKeyboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowKeyboardActionPerformed
        if(!keyboardOpen){
            keyboardScreen.setVisible(true);
            
            keyboardOpen = true;
        }else{
            keyboardScreen.dispose();
            
            keyboardOpen = false;
        }
        
    }//GEN-LAST:event_ShowKeyboardActionPerformed

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        if(!settingsOpen){
            settingsScreen.setVisible(true);
            
            settingsOpen = true;
        }else{
            settingsScreen.dispose();
            
            settingsOpen = false;
        }
        
    }//GEN-LAST:event_SettingsActionPerformed

    private void bindKeyboardCloseAction(){
        keyboardScreen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                keyboardOpen = false;
            }
        });
    }
    
    private void bindSettingsActions(){
        settingsScreen.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeSettingsWindow();
            }
        });
        
        settingsObject.getCancelBtn().addActionListener((java.awt.event.ActionEvent evt) -> {
            closeSettingsWindow();
        });
        
        settingsObject.getSaveBtn().addActionListener((java.awt.event.ActionEvent evt) -> {
            updateSettingsData();
            updateSettingsDB(currentLanguage, currentDifficulty);
            closeSettingsWindow();
            restartGame();
        });
    }
    
    private void restartGame(){
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    private void closeSettingsWindow(){
        settingsScreen.dispose();
        settingsOpen = false;
    }
    
    private void updateSettingsData(){
        for (Enumeration<AbstractButton> languages = settingsObject.getLanguage().getElements(); languages.hasMoreElements();) {
            AbstractButton language = languages.nextElement();

            if (language.isSelected()) {
                currentLanguage = language.getAccessibleContext().getAccessibleName();
            }
        }
        
        for (Enumeration<AbstractButton> difficulties = settingsObject.getDifficulty().getElements(); difficulties.hasMoreElements();) {
            AbstractButton difficulty = difficulties.nextElement();

            if (difficulty.isSelected()) {
                currentDifficulty = difficulty.getAccessibleContext().getAccessibleName();
            }
        }
    }
    
    private void initIcons(){
        Settings.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\com\\wordle\\images\\cog.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)));
    }
    
    private void databaseConnection(){
        String url = "jdbc:mysql://localhost:3306/wordle_settings";
        String username = "root";
        String password = "root";
        
        System.out.println("Connecting database...");

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    
    private void updateSettingsDB(String language, String difficulty){
        String sql = "update settings set language = ?, difficulty = ? where idSettings = 1";
        
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, language);
            statement.setString(2, difficulty);
            
            statement.execute();
            
            statement.close();
        }catch (SQLException e){
            System.err.println("Error while updating data!");
            System.out.println(e); 
        }
    }
    
    private void getSettingsDB(){
        String sql = "select language, difficulty from settings where idSettings = 1";
        
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                currentLanguage = result.getString("language");
                currentDifficulty = result.getString("difficulty");
            }
            
            statement.close();
        }catch (SQLException e){
            System.err.println("Error while getting data!");
            System.out.println(e); 
        }
    }
    
    private void checkSettingsButtonGroup(){
        for (Enumeration<AbstractButton> languages = settingsScreen.getLanguage().getElements(); languages.hasMoreElements();) {
            AbstractButton language = languages.nextElement();

            if (language.getAccessibleContext().getAccessibleName().equals(currentLanguage)) {
                language.setSelected(true);
            }else{
                language.setSelected(false);
            }
        }
        
        for (Enumeration<AbstractButton> difficulties = settingsScreen.getDifficulty().getElements(); difficulties.hasMoreElements();) {
            AbstractButton difficulty = difficulties.nextElement();

            if (difficulty.getAccessibleContext().getAccessibleName().equals(currentLanguage)) {
                difficulty.setSelected(true);
            }else{
                difficulty.setSelected(false);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeyboardScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GridScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton A1Letter;
    private javax.swing.JButton A2Letter;
    private javax.swing.JButton A3Letter;
    private javax.swing.JButton A4Letter;
    private javax.swing.JButton A5Letter;
    private javax.swing.JButton B1Letter;
    private javax.swing.JButton B2Letter;
    private javax.swing.JButton B3Letter;
    private javax.swing.JButton B4Letter;
    private javax.swing.JButton B5Letter;
    private javax.swing.JButton C1Letter;
    private javax.swing.JButton C2Letter;
    private javax.swing.JButton C3Letter;
    private javax.swing.JButton C4Letter;
    private javax.swing.JButton C5Letter;
    private javax.swing.JButton D1Letter;
    private javax.swing.JButton D2Letter;
    private javax.swing.JButton D3Letter;
    private javax.swing.JButton D4Letter;
    private javax.swing.JButton D5Letter;
    private javax.swing.JButton E1Letter;
    private javax.swing.JButton E2Letter;
    private javax.swing.JButton E3Letter;
    private javax.swing.JButton E4Letter;
    private javax.swing.JButton E5Letter;
    private javax.swing.JButton F1Letter;
    private javax.swing.JButton F2Letter;
    private javax.swing.JButton F3Letter;
    private javax.swing.JButton F4Letter;
    private javax.swing.JButton F5Letter;
    private javax.swing.JButton Settings;
    private javax.swing.JButton ShowKeyboard;
    // End of variables declaration//GEN-END:variables
}
