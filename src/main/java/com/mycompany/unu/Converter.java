/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unu;

import static java.lang.Math.pow;

/**
 *
 * @author sergiu
 */

public class Converter {
    
    int DEC_FORMAT = 1;
    int HEX_FORMAT = 2;
//    int BIN_BASE = 2;
    int HEX_BASE = 16;
    String hexDictionary = "0123456789abcdef";
    String[] hexSymbols = {"#", "0x", "h"};
    
    String trim(String value) {
        String trimmed = new String();
        
        return trimmed;
    }
    
    int translateFromHex(char character){
        for (int i = 0; i < hexDictionary.length(); i++) {
            char c = this.hexDictionary.charAt(i);
            if (character == c) {
               return i;
            }
        }
        return 0;
    }
    
    StringBuilder convertToDecimal(String value, int base) {
        int valueLength = value.length() - 1;
        int sum = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            int digit = translateFromHex(c);
            sum += digit * pow(base, valueLength);
            valueLength--;
        }
        result.append(sum);
        return result;
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
    
    StringBuilder convertToHexadecimal (String value, int base) {
        StringBuilder hexValue = new StringBuilder();
        int intValue = Integer.parseInt(value);
        int divider = base;
        while (divider * base <= intValue) {
            divider *= base;
        }
        
        int divisionResult = intValue / divider;
        int rest = intValue % divider;
        char letter = translate(divisionResult);
        hexValue.append(letter);
        divider /= base;
        while (divider > 0) {
            divisionResult = rest / divider;
            rest = rest % divider;
            divider /= base;
            letter = translate(divisionResult);
            hexValue.append(letter);    
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
    
    public StringBuilder convert(String value) {
       int valueFormat = checkValueFormat(value);
       StringBuilder result = new StringBuilder();
       if (valueFormat == HEX_FORMAT) {
           result = convertToDecimal(value, HEX_BASE);
       } else {
           result = this.convertToHexadecimal(value, HEX_BASE);
       }
       return result;
    }
}

//TODO: Implement trim function