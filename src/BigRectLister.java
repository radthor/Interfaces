import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        Filter bigRectFilter = new BigRectangleFilter();
        ArrayList<Rectangle> rects = new ArrayList<>();

        rects.add(new Rectangle(4, 2));
        rects.add(new Rectangle(2, 1));
        rects.add(new Rectangle(4, 3));
        rects.add(new Rectangle(5, 1));
        rects.add(new Rectangle(3, 3));
        rects.add(new Rectangle(1, 1));
        rects.add(new Rectangle(4, 4));
        rects.add(new Rectangle(2, 1));
        rects.add(new Rectangle(3, 2));
        rects.add(new Rectangle(2, 2));

        for (Rectangle rect : rects) {
            double perimeter = 2 * (rect.getWidth() + rect.getHeight());
            System.out.printf("Rectangle [width=%d, height=%d] - Perimeter: %.1f%n",
                    rect.width, rect.height, perimeter);
        }

        System.out.println("\nRectangles with perimeter > 10:");
        System.out.println("--------------------------------");
        for (Rectangle rect : rects) {
            if (bigRectFilter.accept(rect)) {
                double perimeter = 2 * (rect.getWidth() + rect.getHeight());
                System.out.printf("Rectangle [width=%d, height=%d] - Perimeter: %.1f%n",
                        rect.width, rect.height, perimeter);
            }
        }
    }
}
