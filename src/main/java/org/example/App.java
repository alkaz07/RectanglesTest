package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static void sortByArea(ArrayList<Rectangle> rectangles)
    {
        rectangles.sort(Comparator.comparing(rectangle -> rectangle.calcArea()));
    }

    public static ArrayList<Rectangle> readFromFile(String name) throws FileNotFoundException {
        ArrayList<Rectangle> result = new ArrayList<>();
        Scanner scan = new Scanner(new File(name));
        while (scan.hasNextLine())
        {
            String s = scan.nextLine();
            Rectangle r = makeRectangle(s);
            result.add(r);
        }
        return result;
    }


    public static Rectangle makeRectangle(String s)
    {
        String[] m = s.split(" ");
        try {
            double h = Double.parseDouble(m[0]);
            double w = Double.parseDouble(m[1]);
            if (h <= 0 || w <= 0)
                throw new Exception("negative side of Rectangle!");
            return new Rectangle(h, w);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
