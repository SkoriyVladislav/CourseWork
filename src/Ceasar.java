/**
 * Created by Skori on 07.09.2017.
 */
public abstract class Ceasar {
    public static String shifr(char a[], String t, int k){
        int sizeAlph = a.length;
        int sizeText = t.length();
        int temp = 0;

        char shifrText[] = t.toCharArray();
        for (int i = 0; i < sizeText; i++) {
            temp = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == a[j]) {
                    temp = j;
                    break;
                }
            }
            if (temp == -1) {
                shifrText[i] = t.charAt(i);
            }
            else
                shifrText[i] = a[(temp + 2*k)%sizeAlph];
        }
        return new String(shifrText);
    }


    public static String deshifr(char a[], String t, int k){
        int sizeAlph = a.length;
        int sizeText = t.length();
        int temp = 0;
        char deShifrText[] = t.toCharArray();

        for (int i = 0; i < sizeText; i++) {
            temp = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == a[j]) {
                    temp = j;
                    break;
                }
            }
            if (temp == -1) {
                deShifrText[i] = t.charAt(i);
            }
            else
                deShifrText[i] = a[(sizeAlph + temp - k) % sizeAlph];
        }
        return new String(deShifrText);
    }
}
