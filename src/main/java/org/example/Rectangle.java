package org.example;

import javafx.beans.property.SimpleDoubleProperty;

import java.util.Objects;

public class Rectangle {
    //double height, width;
    SimpleDoubleProperty height;
    SimpleDoubleProperty width;
    SimpleDoubleProperty area;

    public Rectangle(double h, double w) {
        height= new SimpleDoubleProperty(h);
        width=new SimpleDoubleProperty(w);
        area=new SimpleDoubleProperty(calcArea());
        height.addListener((val, o, n)->{area.set(calcArea());});
        width.addListener((val, o, n)->{area.set(calcArea());});
    }

    public double calcArea(){
        return height.get()*width.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(this.height.get(), rectangle.height.get())==0 &&
               Double.compare(this.width.get(),  rectangle.width.get()) ==0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, area);
    }
}
