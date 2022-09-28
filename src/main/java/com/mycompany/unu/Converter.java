/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unu;

import java.util.ArrayList;

/**
 *
 * @author sergiu
 */

public class Converter {
    
    int DEC_FORMAT = 1;
    int HEX_FORMAT = 2;
    int BIN_BASE = 2;
    int HEX_BASE = 16;
    String hexDictionary = "0123456789abcdef";
    int convertToDecimal(String value) {
        return 0;
    }
    
    char translate(int digit) {
        for (int i = 0; i < hexDictionary.length(); i++) {
            char c = this.hexDictionary.charAt(i);
            if (digit == i) {
               return c;
            }
        }
        return 0;
    }
    
    ArrayList<Character> convertToHexadecimal (String value, int base) {
        ArrayList<Character> hexValue = new ArrayList<Character>();
        int intValue = Integer.parseInt(value);
        int divider = base;
        while (divider * base < intValue) {
            divider *= base;
        }
        
        int divisionResult = intValue / divider;
        int rest = intValue % divider;
        char letter = translate(divisionResult);
        hexValue.add(letter);
        divider /= base;
        while (divider > 0) {
            divisionResult = rest / divider;
        }
        
        return hexValue;
    }
    
    int checkValueFormat(String value) {
        String[] hexStartSymbols = {"#", "0x"};
        char hexEndSymbol = 'h';
        for (String startSymbol: hexStartSymbols) {
            if (value.startsWith(startSymbol)) {
                return HEX_FORMAT;
            }
        }
        
        if (value.charAt(value.length()-1) == hexEndSymbol) {
            return HEX_FORMAT;
        } else {
            return DEC_FORMAT;
        }
    }
    
    public ArrayList<Character> convert(String value) {
       int valueFormat = checkValueFormat(value);
       ArrayList<Character> result = new ArrayList<Character>();
       if (valueFormat == HEX_FORMAT) {
           convertToDecimal(value);
       } else {
           result = this.convertToHexadecimal(value, HEX_BASE);
       }
       System.out.print(result);
       return result;
    }
}
