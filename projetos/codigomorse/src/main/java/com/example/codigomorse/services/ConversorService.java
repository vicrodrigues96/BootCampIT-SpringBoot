package com.example.codigomorse.services;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {

    String[] letter = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            ",", ".", "?"};
    String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
            "-----", "--..--", ".-.-.-", "..--.."};

    public String conversor(String morse) {
        String traducao = "";
        String[] palavras = morse.split("    ");
        for (int i = 0; i < palavras.length; i++) {
            String[] palavra = palavras[i].split(" ");
            for (int h = 0; h < palavra.length; h++) {
                for (int j = 0; j < codes.length; j++) {
                    if (palavra[h].compareTo(codes[j]) == 0) {
                        traducao = traducao + letter[j];
                    }
                }
            }
            traducao += " ";
        }
        return traducao;
    }
}

