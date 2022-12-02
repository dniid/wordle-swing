package com.wordle;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class SettingsScreen extends javax.swing.JFrame {

    public SettingsScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        language = new javax.swing.ButtonGroup();
        difficulty = new javax.swing.ButtonGroup();
        languageLabel = new javax.swing.JLabel();
        languagePT = new javax.swing.JRadioButton();
        languageEN = new javax.swing.JRadioButton();
        difficultyEasy = new javax.swing.JRadioButton();
        difficultyMedium = new javax.swing.JRadioButton();
        difficultyLabel = new javax.swing.JLabel();
        difficultyHard = new javax.swing.JRadioButton();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações");

        languageLabel.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        languageLabel.setText("Idioma");

        language.add(languagePT);
        languagePT.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        languagePT.setSelected(true);
        languagePT.setText("Português Brasileiro");

        language.add(languageEN);
        languageEN.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        languageEN.setText("Inglês");

        difficulty.add(difficultyEasy);
        difficultyEasy.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        difficultyEasy.setForeground(new java.awt.Color(51, 153, 0));
        difficultyEasy.setText("Fácil");

        difficulty.add(difficultyMedium);
        difficultyMedium.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        difficultyMedium.setForeground(new java.awt.Color(204, 204, 0));
        difficultyMedium.setSelected(true);
        difficultyMedium.setText("Médio");

        difficultyLabel.setFont(new java.awt.Font("Lucida Console", 1, 18)); // NOI18N
        difficultyLabel.setText("Dificuldade");

        difficulty.add(difficultyHard);
        difficultyHard.setFont(new java.awt.Font("Lucida Console", 0, 12)); // NOI18N
        difficultyHard.setForeground(new java.awt.Color(204, 0, 0));
        difficultyHard.setText("Difícil");

        saveBtn.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        saveBtn.setText("Salvar");

        cancelBtn.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        cancelBtn.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(difficultyHard, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(difficultyMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(difficultyEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(difficultyLabel)
                    .addComponent(languageEN, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languagePT, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(languageLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(languageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(languagePT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(languageEN, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(difficultyLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(difficultyEasy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(difficultyMedium, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(difficultyHard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        languagePT.getAccessibleContext().setAccessibleName("ptbr");
        languageEN.getAccessibleContext().setAccessibleName("en");
        difficultyEasy.getAccessibleContext().setAccessibleName("easy");
        difficultyMedium.getAccessibleContext().setAccessibleName("normal");
        difficultyHard.getAccessibleContext().setAccessibleName("hard");
        difficultyHard.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public ButtonGroup getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(ButtonGroup difficulty) {
        this.difficulty = difficulty;
    }

    public ButtonGroup getLanguage() {
        return language;
    }

    public void setLanguage(ButtonGroup language) {
        this.language = language;
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public void setSaveBtn(JButton saveBtn) {
        this.saveBtn = saveBtn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.ButtonGroup difficulty;
    private javax.swing.JRadioButton difficultyEasy;
    private javax.swing.JRadioButton difficultyHard;
    private javax.swing.JLabel difficultyLabel;
    private javax.swing.JRadioButton difficultyMedium;
    private javax.swing.ButtonGroup language;
    private javax.swing.JRadioButton languageEN;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JRadioButton languagePT;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
