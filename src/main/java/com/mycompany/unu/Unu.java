/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.unu;

import java.util.ArrayList;

/**
 *
 * @author sergiu
 */
public class Unu {
    
    public static void main(String[] args) {
        String inputValue = "0x1000";
        Converter converter = new Converter();
        StringBuilder result = converter.convert(inputValue);
        System.out.print(result);
    }
}