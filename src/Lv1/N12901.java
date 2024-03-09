package Lv1;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

// 2016년
public class N12901 {
    public static String solution(int a, int b) {
        LocalDate date = LocalDate.of(2016, a, b);
        return date.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.US).toUpperCase(Locale.ROOT);
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }
}
