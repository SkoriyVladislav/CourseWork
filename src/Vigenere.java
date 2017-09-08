import java.util.List;

/**
 * Created by Skori on 08.09.2017.
 */
public abstract class Vigenere {
    static String shifr(char a[], String t, String k) {
        int sizeAlph = a.length;
        int sizeText = t.length();
        int sizeKey = k.length();
        int tempT = 0;
        int tempK = 0;
        int znaki = 0;
        char shifrText[] = t.toCharArray();

        for (int i = 0; i < sizeText; i++) {
            tempT = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == a[j]) {
                    tempT = j;
                    break;
                }
            }
            if (tempT == -1) {
                znaki++;
            }

            for (int j = 0; j < sizeAlph; j++) {
                if (k.charAt((i-znaki) % sizeKey) == a[j]) {
                    tempK = j;
                    break;
                }
                else
                    tempK = 0;
            }
            if (tempT == -1) {
                shifrText[i] = t.charAt(i);
            }
            else
                shifrText[i] = a[(tempT + tempK - 1) % sizeAlph];
        }
        return shifrText.toString();
    }
    static String deshifr(char a[], String t, String k) {
        int sizeAlph = a.length;
        int sizeText = t.length();
        int sizeKey = k.length();
        int tempT = 0;
        int tempK = 0;
        int znaki = 0;
        char deshifrText[] = t.toCharArray();

        for (int i = 0; i < sizeText; i++) {
            tempT = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == a[j]) {
                    tempT = j;
                    break;
                }
            }
            for (int j = 0; j < sizeAlph; j++) {
                if (k.charAt((i - znaki) % sizeKey) == a[j]) {
                    tempK = j;
                    break;
                }
            }
            if (tempT == -1) {
                deshifrText[i] = t.charAt(i);
                znaki++;
            }
            else
                deshifrText[i] = a[(sizeAlph + tempT - tempK + 1) % sizeAlph];
        }
        return deshifrText.toString();
    }
    static String deshifr(char a[], String t, List<Integer> k)  {
        int sizeAlph = a.length;
        int sizeText = t.length();
        int sizeKey = k.size();
        int tempT = 0;
        int tempK = 0;
        int znaki = 0;
        char deshifrText[] = t.toCharArray();

        for (int i = 0; i < sizeText; i++) {
            tempT = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == a[j]) {
                    tempT = j;
                    break;
                }
            }
            for (int j = 0; j < sizeAlph; j++) {
                if (a[k.get((i - znaki) % sizeKey)] == a[j]) {
                    tempK = j;
                    break;
                }
            }
            if (tempT == -1) {
                deshifrText[i] = t.charAt(i);
                znaki++;
            }
            else
                deshifrText[i] = a[(sizeAlph + tempT - tempK + 1) % sizeAlph];
        }
        return deshifrText.toString();
    }
}
