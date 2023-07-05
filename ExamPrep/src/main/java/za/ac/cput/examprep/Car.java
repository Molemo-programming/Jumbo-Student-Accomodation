
package za.ac.cput.examprep;

import java.util.ArrayList;

/*
Car.java
This is a standard Worker class pojo
Author: Hanno Visser Immelman (221074414)
 */
public class Car {

    private String modelNum, carName, carManufacturer, EngineHP;

    public Car(String modelNum, String carName, String carManufacturer, String EngineHP) {
        this.modelNum = modelNum;
        this.carName = carName;
        this.carManufacturer = carManufacturer;
        this.EngineHP = EngineHP;
    }

    public String getModelNum() {
        return modelNum;
    }

    public String getCarName() {
        return carName;
    }

    public String getCarManufacturer() {
        return carManufacturer;
    }

    public String getEngineHP() {
        return EngineHP;
    }

    public void setModelNum(String modelNum) {
        this.modelNum = modelNum;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setCarManufacturer(String carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public void setEngineHP(String EngineHP) {
        this.EngineHP = EngineHP;
    }

    public ArrayList getItems() {
        ArrayList arr = new ArrayList();
        arr.add(modelNum);
        arr.add(carName);
        arr.add(carManufacturer);
        arr.add(EngineHP);
        return arr;
    }
}
