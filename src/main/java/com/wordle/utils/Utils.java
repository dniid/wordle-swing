package com.wordle.utils;

import com.wordle.exceptions.LettersExceedsMaxAmount;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Utils {
    public static final String WORDS_PTBR_JSON = "src\\main\\java\\com\\wordle\\json\\respostas.json";
    public static final String VALIDS_PTBR_JSON = "src\\main\\java\\com\\wordle\\json\\palavrasval.json";
    public static final String WORDS_EN_JSON = "src\\main\\java\\com\\wordle\\json\\answers.json";
    public static final String VALIDS_EN_JSON = "src\\main\\java\\com\\wordle\\json\\valwords.json";
    private static String[] separateRandomWord;
    private static ArrayList<String> alreadyTyped = new ArrayList<String>();
    
    public static String[] getWord(String language) throws LettersExceedsMaxAmount{
        JSONParser parser = new JSONParser();
        try {
            if(separateRandomWord == null){
                Object wordsObj = null;
                if(language.equals("ptbr")){
                    wordsObj = parser.parse(new FileReader(WORDS_PTBR_JSON));
                }else if(language.equals("en")){
                    wordsObj = parser.parse(new FileReader(WORDS_EN_JSON));
                }
                String wordsString = wordsObj.toString().substring(1,wordsObj.toString().length() - 1);
                wordsString = wordsString.replace("\"", "");

                String[] words = wordsString.split(",");
                int Random = new Random().nextInt(words.length);

                String randomWord = words[Random];

                if(randomWord.length() > 5){
                    throw new LettersExceedsMaxAmount("A palavra '"+randomWord+"' excede o número máximo de letras");
                }

                separateRandomWord = randomWord.split("(?<=\\G.{1})");
            }
            
            return separateRandomWord;
        }
        catch (FileNotFoundException e) {}
        catch (IOException | ParseException e) {}
        
        return null;
    }
    
    public static String[] getValidWords(String language){
        JSONParser parser = new JSONParser();
        try {
            Object valWordsObj = null;
            if(language.equals("ptbr")){
                valWordsObj = parser.parse(new FileReader(VALIDS_PTBR_JSON));
            }else if(language.equals("en")){
                valWordsObj  = parser.parse(new FileReader(VALIDS_EN_JSON));
            };
            String valWordsString = valWordsObj.toString().substring(1,valWordsObj.toString().length() - 1);
            valWordsString = valWordsString.replace("\"", "");

            String[] valWords = valWordsString.split(",");

            return valWords;
        }
        catch (FileNotFoundException e) {}
        catch (IOException | ParseException e) {}
        
        return null;
    }
    
    public static boolean checkValidWord(String fullChosenWord, String[] valWords){
        for (String typed : alreadyTyped){
            if(fullChosenWord.equals(typed)){
                return false;
            }
        }
        alreadyTyped.add(fullChosenWord);
        
        for(String check : valWords){
            if(fullChosenWord.equals(check)){
                return true;
            }
        }
        return false;
    }
    
    public static void checkWin(ArrayList<JButton> row, int position){
        int acertos = 0;
        for(int i=0;i<5;i++){
            if(row.get(i).getForeground() == Color.GREEN){
                acertos++;
            }else{
                acertos = 0;
            }
        }

        if(acertos == 5){
            int input = JOptionPane.showConfirmDialog(null, "Você venceu!", "Vitória", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(input == 0){
                System.exit(0);
            }
        }else if(position == 5){
            int input = JOptionPane.showConfirmDialog(null, "Você perdeu!", "Derrota", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            if(input == 0){
                System.exit(0);
            }
        }
    }
}