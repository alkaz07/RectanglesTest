package org.example;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AppTest {
    @Test
    public void test0(){
        assert true;
    }

    @Test
    public void testArea1(){
        Rectangle r1 = new Rectangle(2, 3);
        Rectangle r2 = new Rectangle(3, 2);
        assert r1.calcArea() == 6;
        assert 6 == r2.calcArea();
    }
    @Test
    public void testMakeRectangle()
    {
        String s = "10 12";
        Rectangle r1 = new Rectangle(10, 12);
        //assert App.makeRectangle(s).equals(r1);
        Assertions.assertEquals(r1, App.makeRectangle(s));
        Rectangle r2 =new Rectangle(12, 10);
        //assert !r2.equals(App.makeRectangle(s));
        Assertions.assertNotEquals(r2, App.makeRectangle(s));
        //Assertions.assertThrows(new Exception(), App.makeRectangle("Vasya Sveta"));
        Exception ex = Assertions.assertThrows(Exception.class, ()->
        {
            Rectangle r3 = App.makeRectangle("Vasya Sveta");
        });
        System.out.println(ex.getMessage());

        ex=Assertions.assertThrows(Exception.class, ()->{
            Rectangle r4 = App.makeRectangle("12 -99");
        });
        System.out.println(ex.getMessage());
        Assertions.assertEquals("java.lang.Exception: negative side of Rectangle!", ex.getMessage());
    }

    @Test
    public void testRead()
    {
        ArrayList<Rectangle> sample = new ArrayList<>();
        sample.add(new Rectangle(12, 50));
        sample.add(new Rectangle(61, 4));
        sample.add(new Rectangle(32, 32));
        sample.add(new Rectangle(4, 15));
        sample.add(new Rectangle(15, 4));
        sample.add(new Rectangle(15, 8));

        try {
            Assertions.assertIterableEquals(sample, App.readFromFile("rec1.txt"));
        }
        catch (IOException e){
            System.out.println("а где файл?");
        }

    }

    @Test
    public void testSortByArea() throws FileNotFoundException {
        ArrayList<Rectangle> mas = App.readFromFile("rec1.txt");
        App.sortByArea(mas);

        ArrayList<Rectangle> sample = new ArrayList<>();
        sample.add(new Rectangle(4, 15));
        sample.add(new Rectangle(15, 4));
        sample.add(new Rectangle(15, 8));
        sample.add(new Rectangle(61, 4));
        sample.add(new Rectangle(12, 50));
        sample.add(new Rectangle(32, 32));

        Assertions.assertIterableEquals(sample, mas);
    }

}
