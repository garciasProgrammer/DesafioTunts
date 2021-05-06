/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.googlesheets;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 *
 * @author Thiago Garcia
 */
public class Initialization {

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        
        GoogleSheetsLiveTest.setup();

    }
}
