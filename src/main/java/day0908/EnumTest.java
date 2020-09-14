package day0908;

public class EnumTest {
    public static void main(String[] args) {
        Color color = Color.BLUE;
        System.out.println(color);
        for (Color value : Color.values()) {
            System.out.println(value);
        }
    }
}