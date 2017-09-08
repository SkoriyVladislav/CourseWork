/**
 * Created by Skori on 08.09.2017.
 */
public class Analiz {

    static private double[] arr1;
    static private double[] arrMaxText;
    static private int[] ma;

    static void analizText(char[] a, String t, double[] arr, int[] mt) {
        int sizeAlph = Alphabet.alph.length;
        int sizeText = t.length();
        double max = 0;

	    /*double[] arr1 = new double[sizeAlph / 2];
        for (int i = 0; i < sizeAlph / 2; i++) {
            arr1[i] = 0.0;
        }*/

        // В этом блоке мы анализируем частоту встречаемости букв в заданном тексте
        for (int i = 1, k = 0; i < sizeAlph; i += 2, k++) {
            for (int j = 0; j < sizeText; j++) {
                if (t.charAt(j) == Alphabet.alph[i]) {
                    arr1[k]++;
                }
            }
        }

        for (int i = 0; i < sizeAlph / 2; i++) {
            arr1[i] /= sizeText;
        }

        for (int i = 0; i < sizeAlph / 2; i++) {
            arrMaxText[i] = arr1[i];
        }

        // Инициализируем упорядоченный массив из наиболее встречающихся букв (в процентах)
        for (int repeat_counter = 0; repeat_counter < sizeAlph / 2; repeat_counter++) {
            // временная переменная для хранения значения перестановки
            double temp = arrMaxText[0];
            for (int element_counter = repeat_counter + 1; element_counter < sizeAlph / 2; element_counter++) {
                if (arrMaxText[repeat_counter] < arrMaxText[element_counter]) {
                    temp = arrMaxText[repeat_counter];
                    arrMaxText[repeat_counter] = arrMaxText[element_counter];
                    arrMaxText[element_counter] = temp;
                }
            }
        }

        // Cоставляем массив с упорядоченными по частоте индексами букв алфавита
        for (int i = 0; i < sizeAlph / 2; i++) {
            int temp = 0;
            for (int j = 0; j < sizeAlph / 2; j++) {
                if (arrMaxText[i] == arr1[j]) {
                    arr1[j] = 0;
                    temp = j;
                    break;
                }
            }
            ma[i] = 1 + 2 * temp;
            //cout << "    Буква '" << a[ma[i]] << "' встречается в " << arrMaxText[i] * 100 << "% случаях." << endl;
        }

    }

    static void anCeas(char[] a, String t, double[] arr, int[] mt) {

    }


    static void anVig(char[] a, String t, double[] arrMaxText, int[] ma) {

    }


    static int anText(char[] a, String t, int i, int shag) {

        return 1;
    }

    static int nod(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b)
                a = a % b;
            else
                b = b % a;
        }
        return a + b;
    }
}
