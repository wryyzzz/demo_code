import java.util.Arrays;

public class kmp {

    public static void main(String[] args) {
        char[] s = "aaaabcdef".toCharArray();//主串
        char[] p = "aaaaax".toCharArray();//子串
        int[] next = calculateNext(p);
        int tar = 0;//主串下标 10
        int pos = 0;//子串下标 6
        while (tar < s.length) {
            if (s[tar] == p[pos]) {
                if (pos == p.length - 1) {
                    System.out.println(tar + 1 - p.length);
                    break;
                }
                tar += 1;
                pos += 1;
            } else if (pos == 0) {
                tar += 1;
            } else {
                pos = next[pos - 1];
            }
            if (tar == s.length - 1) {
                System.out.println(-1);
            }

        }
    }

    private static int[] calculateNext(char[] pattern) {
        int[] next = new int[pattern.length];
        next[0] = 0;
        int x = 1, now = 0;
        while (x < pattern.length) {
            if (pattern[now] == pattern[x]) {
                now++;
                next[x] = now;
                x++;
            } else if (now != 0) {
                now = next[now - 1];
            } else {
                next[x] = 0;
                x++;
            }
        }
        return next;
    }
}
