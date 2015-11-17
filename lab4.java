import java.util.Scanner;
import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class lab4 extends JPanel {
  
  public static String show = "show";
  public static String polygon = "polygon";
  public static String exit = "exit"; 
  public static String translate = "t";
  public static String rotate = "r";
  public static String scale = "s";
  public static int length = 0;
  public static Object[] numbersArray;
  public static Object[] translateArray;
  public static Object[] rotateArray;
  
  public static void main (String[] args) {
    
    int centroid_x=0; 
    int centroid_y=0;
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    numbersArray = Arrays.asList(str.trim().split(" ")).toArray();
    List<String> list;
      
    while (str.toLowerCase().indexOf(exit.toLowerCase()) == -1) { //while input string doesn't contain "exit"
      if (str.toLowerCase().indexOf(polygon.toLowerCase()) != -1) { //if input string contains "polygon"
        str = str.replaceAll("[^0-9]+", " ");
        list = Arrays.asList(str.trim().split(" "));
        numbersArray = list.toArray(new Object[list.size()]);
        if (numbersArray.length % 2 == 0) {
          System.out.println("OK");
        }
        else {
          while (numbersArray.length % 2 != 0) {
            System.out.println("This program cannot run properly without the correct vertice notation");
            System.out.println("Please enter vertices in this format: polygon(x1, y1, x2, y2, �, xn, yn) " 
                                 + "[note: even number of vertices only!]");
            str = scanner.nextLine(); 
            str = str.replaceAll("[^0-9]+", " ");
            list = Arrays.asList(str.trim().split(" "));
            numbersArray = list.toArray(new Object[list.size()]);
          }
        System.out.println("OK"); 
        }  
      }
      if (str.toLowerCase().indexOf(show.toLowerCase()) != -1 ) { //if input string contains "show"
        for (int i = 0; i < numbersArray.length; i++) {
          System.out.print(numbersArray[i] + ", " );
        }
        JFrame frame = new JFrame();
        frame.setTitle("Polygon");
        frame.setSize(350, 250);
        Container contentPane = frame.getContentPane();
        contentPane.add(new lab4());
        frame.setVisible(true);
        System.out.println(); 
      }
      if (str.toLowerCase().indexOf(translate.toLowerCase()) != -1) {
       str = str.replaceAll("[^0-9]+", " "); 
       translateArray = Arrays.asList(str.trim().split(" ")).toArray();
       for (int i = 0; i < numbersArray.length; i+=2) {
         Object x = (Object) (Integer.parseInt(numbersArray[i].toString()) + Integer.parseInt(translateArray[0].toString()));
         Object y = (Object) (Integer.parseInt(numbersArray[(i+1)].toString()) + Integer.parseInt(translateArray[1].toString()));
         numbersArray[i] = (Object) x;
         numbersArray[(i+1)] = (Object) y;
       } 
      }
      if (str.toLowerCase().indexOf(rotate.toLowerCase()) != -1) {
       str = str.replaceAll("[^0-9]+", " "); 
       rotateArray = Arrays.asList(str.trim().split(" ")).toArray();
       for (int i = 0; i < numbersArray.length; i+=2) {
         centroid_x += Integer.parseInt(numbersArray[i].toString());
         centroid_y += Integer.parseInt(numbersArray[(i+1)].toString());
       } 
       System.out.println("x: " + centroid_x + " y: " + centroid_y + " na/2: " + (numbersArray.length/2));
       centroid_x = centroid_x/(numbersArray.length/2);
       centroid_y = centroid_y/(numbersArray.length/2);
       System.out.println(centroid_x);
       System.out.println(centroid_y);
       System.out.println(rotateArray[0]);
       for (int i = 0; i < numbersArray.length; i+=2) {
         Object a = (Object) (Math.cos(Math.toRadians(Integer.parseInt(rotateArray[0].toString()))) 
                           * (Integer.parseInt(numbersArray[i].toString()) - centroid_x)
                           - Math.sin(Math.toRadians(Integer.parseInt(rotateArray[0].toString()))) 
                           * (Integer.parseInt(numbersArray[i+1].toString()) - centroid_y) + centroid_x);
         Object b = (Object) (Math.sin(Math.toRadians(Integer.parseInt(rotateArray[0].toString()))) 
                             * (Integer.parseInt(numbersArray[i].toString()) - centroid_x)
                             + Math.cos(Math.toRadians(Integer.parseInt(rotateArray[0].toString()))) 
                             * (Integer.parseInt(numbersArray[i+1].toString()) - centroid_y) + centroid_y);
         numbersArray[i] =  (Object) a;
         numbersArray[(i+1)] = (Object) b; 
       }
      }
      str = scanner.nextLine();  
    }
  }
  
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Polygon p = new Polygon();
    for (int i = 0; i < numbersArray.length; i+=2) {
      double x_i = Double.parseDouble( numbersArray[i].toString() );
      double y_i = Double.parseDouble( numbersArray[i+1].toString() );
      p.addPoint( (int) x_i, (int) y_i );
    }
    g.drawPolygon(p);
 }   
}