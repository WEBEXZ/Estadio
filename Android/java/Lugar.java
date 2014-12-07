/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.alebrijes;
/**
 *
 * @author Feliciano
 */
public class Lugar {
String zona,area;
    public Lugar(String zona, String area) {
        this.zona=zona;
        this.area=area;
        }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }   
}