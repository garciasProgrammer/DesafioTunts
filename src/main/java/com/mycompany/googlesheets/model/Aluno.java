/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.googlesheets.model;

/**
 *
 * @author Thiago Garcia
 */
public class Aluno {

    /**
     * @return the totalDeAulas
     */
    public String getTotalDeAulas() {
        return totalDeAulas;
    }

    /**
     * @param totalDeAulas the totalDeAulas to set
     */
    public void setTotalDeAulas(String totalDeAulas) {
        this.totalDeAulas = totalDeAulas;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the aluno
     */
    public String getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the faltas
     */
    public String getFaltas() {
        return faltas;
    }

    /**
     * @param faltas the faltas to set
     */
    public void setFaltas(String faltas) {
        this.faltas = faltas;
    }

    /**
     * @return the p1
     */
    public String getP1() {
        return p1;
    }

    /**
     * @param p1 the p1 to set
     */
    public void setP1(String p1) {
        this.p1 = p1;
    }

    /**
     * @return the p2
     */
    public String getP2() {
        return p2;
    }

    /**
     * @param p2 the p2 to set
     */
    public void setP2(String p2) {
        this.p2 = p2;
    }

    /**
     * @return the p3
     */
    public String getP3() {
        return p3;
    }

    /**
     * @param p3 the p3 to set
     */
    public void setP3(String p3) {
        this.p3 = p3;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the naf
     */
    public String getNaf() {
        return naf;
    }

    /**
     * @param naf the naf to set
     */
    public void setNaf(String naf) {
        this.naf = naf;
    }
    
    @Override
    public String toString(){
    return "ALUNO:\nMatr.: "+matricula+" Aluno: "+aluno+" Faltas:"+faltas+" P1: "+p1+" P2: "+p2+"P3: "+p3;
    }
    
    private String totalDeAulas;
    private String matricula;
    private String aluno;
    private String faltas;
    private String p1;
    private String p2;
    private String p3;
    private String situacao;
    private String naf;
    
    
}
