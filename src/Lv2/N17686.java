package Lv2;

import java.util.Arrays;
import java.util.PriorityQueue;

// [3차] 파일명 정렬
public class N17686 {
    static class FileName {
        int idx; // 원래 입력으로 들어온 순서
        String name; // 파일 이름
        String[] nameArr; // 파일 이름을 head와 number로 나눈 배열

        public FileName(int idx, String name) {
            nameArr = new String[2];
            StringBuilder sb = new StringBuilder(); // number부분
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                if (sb.length() == 5) { // number의 길이는 5를 넘지 않는다
                    break;
                }

                if (nameArr[0] != null) {
                    if (c >= '0' && c <= '9') {
                        sb.append(c); // head부분을 구한 후 숫자가 나오는 경우에 sb에 저장
                        continue;
                    } else {
                        break; // 다시 문자가 나온다면 tail부분에 해당하므로 반복문을 끝낸다. (tail은 구할 필요가 없음)
                    }
                }

                if (c >= '0' && c <= '9') {
                    nameArr[0] = name.substring(0, i).toLowerCase(); // 처음 숫자가 나온 부분 이전까지가 head부분임
                    sb.append(c);
                }
            }

            nameArr[1] = sb.toString();
            this.name = name;
            this.idx = idx;
        }
    }

    public static String[] solution(String[] files) {
        String[] result = new String[files.length];
        PriorityQueue<FileName> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.nameArr[0].equals(o2.nameArr[0])) {
                if (Integer.parseInt(o1.nameArr[1]) == Integer.parseInt(o2.nameArr[1])) {
                    return o1.idx - o2.idx; // head가 같고 number도 같다면 원래 입력한 순서로 뽑는다.
                }

                return Integer.parseInt(o1.nameArr[1]) - Integer.parseInt(o2.nameArr[1]); // head가 같다면 number를 비교
            }

            return o1.nameArr[0].compareTo(o2.nameArr[0]); // head를 비교
        });

        for (int i = 0; i < files.length; i++) {
            pq.offer(new FileName(i, files[i]));
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = pq.poll().name;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
        System.out.println(Arrays.toString(solution(new String[]{"foo.a-s.d122.zip", "O00321", "O49qcGPHuRLR5FEfoO00321"})));
    }
}
