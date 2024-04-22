package Lv2;

import java.util.ArrayList;
import java.util.List;

// [1차] 뉴스 클러스터링
public class N17677 {
    public static int solution(String str1, String str2) {
        if (str1.equalsIgnoreCase(str2)) {
            return 65536;
        }

        List<String> list1 = new ArrayList<>(); // str1의 집합
        List<String> list2 = new ArrayList<>(); // str2의 집합
        for (int i = 0; i < str1.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            // 특수문자, 숫자, 공백 제외
            if (((ch1 >= 'A' && ch1 <= 'Z') || (ch1 >= 'a' && ch1 <= 'z')) && ((ch2 >= 'A' && ch2 <= 'Z') || (ch2 >= 'a' && ch2 <= 'z'))) {
                list1.add(sb.append(ch1).append(ch2).toString().toLowerCase());
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);
            // 특수문자, 숫자, 공백 제외
            if (((ch1 >= 'A' && ch1 <= 'Z') || (ch1 >= 'a' && ch1 <= 'z')) && ((ch2 >= 'A' && ch2 <= 'Z') || (ch2 >= 'a' && ch2 <= 'z'))) {
                list2.add(sb.append(ch1).append(ch2).toString().toLowerCase());
            }
        }

        List<String> copyOfList1 = new ArrayList<>(List.copyOf(list1)); // str1의 집합 copy
        List<String> intersection = new ArrayList<>(); // 교집합
        for (int i = 0; i < list2.size(); i++) {
            String cur = list2.get(i);
            if (copyOfList1.contains(cur)) {
                intersection.add(cur);
                copyOfList1.remove(cur);
                list2.remove(i);
                i--;
            }
        }

        List<String> union = new ArrayList<>(intersection); // 합집합
        for (String s : intersection) {
            list1.remove(s);
        }
        union.addAll(list1);
        union.addAll(list2);

        return (int) (((double) intersection.size() / (double) union.size()) * 65536);
    }

    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
        System.out.println(solution("aaabbcccccccc", "aaaabbcccc"));
        System.out.println(solution("abcd_", "dod_df"));
    }
}
