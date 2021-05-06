/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.googlesheets;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Thiago Garcia
 */
public class GoogleSheetsLiveTest {

    private static Sheets sheetsService;
    private static final String SPREADSHEET_ID = "1Ctg103Cr2miXAH26d17gWiGmHYbNSMC8veUk6jzPQeE";

    public static void setup() throws GeneralSecurityException, IOException {
        sheetsService = SheetsServiceUtil.getSheetsService();
        String range = "!A3:F27";

        String situacao = "";
        int notaNaf = 0;
        int aulas = 60;
        int faltasLimite = 0;
        int cont = 4;

        //LEITURA DA PLANILHA DE MODO GERAL
        //calculado porcentagem de faltas, 25%
        faltasLimite = ((aulas * 25) / 100);
        System.out.println("LIMITE DE FALTAS: " + faltasLimite);
        System.out.println("AULAS DO PERIODO: " + aulas);

        ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range)
                .execute();

        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            System.out.println("No Data Found");
        } else {
            for (List row : values) {
                System.out.printf("%s %s %s %s %s %s\n", row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5) + "\n");

            }
            System.out.printf("**** END OF READING ***********\n");
        }

        String range1 = "!A4:F27";

        ValueRange response1 = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range1)
                .execute();

        List<List<Object>> values1 = response1.getValues();

        if (values1 == null || values1.isEmpty()) {
            System.out.println("No Data Found");
        } else {

            System.out.println("CALCULATING MEDIA\n");
            for (List row : values1) {
                //pegando valores de nota e calculando a media
                int p1 = Integer.parseInt(row.get(3).toString());
                int p2 = Integer.parseInt(row.get(4).toString());
                int p3 = Integer.parseInt(row.get(5).toString());
                int faltas = Integer.parseInt(row.get(2).toString());
                int med = (p1 + p2 + p3) / 3;

                //reprovado por faltas
                if (faltas > faltasLimite) {

                    situacao = "REPROVADO POR FALTA";
                    notaNaf = 0;

                } else {

                    //reprovado por nota
                    if (med < 50) {

                        situacao = "REPROVADO POR NOTA";
                        notaNaf = 0;
                    }
                    //realixar exame final e qual nota deve alcancar
                    if (med >= 50 || med <= 70) {

                        situacao = "EXAME FINAL";
                        
                        notaNaf = 100-med;

                    }

                    //aluno aprovado
                    if (med >= 70) {

                        situacao = "APROVADO";
                        notaNaf = 0;

                    }
                }

                System.out.printf("%s %s %s %s %s %s      %s    %s    %s\n", row.get(0), row.get(1), row.get(2), row.get(3), row.get(4), row.get(5), med, situacao, notaNaf + "\n");

                String range2 = "!G" + cont + ":H27";
                ValueRange body = new ValueRange()
                        .setValues(Arrays.asList(Arrays.asList(situacao, notaNaf)));

                UpdateValuesResponse result = sheetsService.spreadsheets().values()
                        .update(SPREADSHEET_ID, range2, body)
                        .setValueInputOption("RAW")
                        .execute();

                System.out.println("\n***** UPDATING GOOGLE SHEETS TABLE  MEDIA *****\n");

                cont++;
            }

            System.out.println("\n***** END OF CALCULATION THE UPDATE OF THE TABLE ON GOOGLE SHEETS ***** MEDIAS\n");

        }

    }

}
