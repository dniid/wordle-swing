package com.wordle.models;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class Settings {
    private ButtonGroup difficulty;
    private ButtonGroup language;
    private JButton saveBtn;
    private JButton cancelBtn;

    public Settings(ButtonGroup difficulty, ButtonGroup language, JButton saveBtn, JButton cancelBtn) {
        this.difficulty = difficulty;
        this.language = language;
        this.saveBtn = saveBtn;
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

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }
    
    
}