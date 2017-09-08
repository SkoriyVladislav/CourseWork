import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Skori on 08.09.2017.
 */
public abstract class Kardano {

    public static int[][] shifr(char a[], String t,final int KEYSIZE) {
        int sizeAlph = a.length;
        int sizeText = t.length();
        int temp = 0;

        //сообщение ввиде цифр
        int arrText[] = new int[sizeText];
        for (int i = 0; i < sizeText; i++) {
            temp = -1;
            for (int j = 0; j < sizeAlph; j++) {
                if (t.charAt(i) == a[j]) {
                    temp = j;
                }
            }
            if (temp >= 0) {
                arrText[i] = temp;
            }
            else {
                arrText[i] = t.charAt(i);
            }
        }

        //создание матрицы шифротекста
        int[][] shifrMatrix = new int[KEYSIZE][];
        for (int i = 0; i < KEYSIZE; i++) {
            shifrMatrix[i] = new int[KEYSIZE];
        }
        for (int i = 0; i < KEYSIZE; i++) {
            for (int j = 0; j < KEYSIZE; j++) {
                shifrMatrix[i][j] = 0;
            }
        }

        // создание матрицы ключа
        int keyMatrix[][] = new int[KEYSIZE][];
        for (int i = 0; i < KEYSIZE; i++) {
            keyMatrix[i] = new int[KEYSIZE];
        }
        for (int i = 0; i < KEYSIZE; i++) {
            for (int j = 0; j < KEYSIZE; j++) {
                keyMatrix[i][j] = 0;
            }
        }

        Random rd = new Random();

        //vector<int> arr;

        for (int i = 0; i < KEYSIZE / 2; i++) {

            List<Integer> arr = new ArrayList<>();
            //vector<int> arr;
            for (int j = 0; j < KEYSIZE - i * 2 - 1; j++) {

                arr.add(j);
            }


            for (int j = 0; j < KEYSIZE - i * 2 - 1; j++) {


                int tempStroka = rd.nextInt(4);

                //uniform_int_distribution<int>sizeIter(0, arr.size() - 1);
                int iter = rd.nextInt(arr.size());

                if (tempStroka == 0) {
                    keyMatrix[i][i + arr.get(iter)] = 1;
                }
                if (tempStroka == 1) {
                    keyMatrix[i + arr.get(iter)][KEYSIZE - 1 - i] = 1;
                }
                if (tempStroka == 2) {
                    keyMatrix[KEYSIZE - 1 - i][KEYSIZE - 1 - i - arr.get(iter)] = 1;
                }
                if (tempStroka == 3) {
                    keyMatrix[KEYSIZE - 1 - i - arr.get(iter)][i] = 1;
                }

                arr.remove(iter);
                //arr.erase(arr.begin() + iter);
            }
        }

        for (int i = 0; i < KEYSIZE; i++) {

            for (int j = 0; j < KEYSIZE; j++) {
                System.out.print(keyMatrix[i][j] + "    ");
            }
            System.out.println();
            System.out.println();
            System.out.println();
        }

        /* вот так должен выглядеть ключ:
	1 0 0 0
	0 1 0 0
	0 0 0 1
	0 0 1 0 */

        /* keyMatrix[0][0] = 1;
	keyMatrix[1][1] = 1;
	keyMatrix[2][3] = 1;
	keyMatrix[3][2] = 1; */


        //заполнение матрицы текстом
        int val = 0;
        for (int m = 0; m < 4; m++) {
            for (int i = 0; i < KEYSIZE; i++) {
                for (int j = 0; j < KEYSIZE; j++) {
                    if (keyMatrix[i][j] != 0) {
                        shifrMatrix[i][j] = arrText[val];
                        val++;
                    }
                }
            }
            for (int i = 0; i < KEYSIZE; i++) {
                for (int j = 0; j < KEYSIZE; j++) {
                    System.out.print(a[shifrMatrix[i][j]] + "   ");
                }

                System.out.println();
                System.out.println();
                System.out.println();
            }
            System.out.println();
            System.out.println();

            keyMatrix = rotateMatr(keyMatrix, KEYSIZE);

        }

        return shifrMatrix;
    }

    private static int[][] rotateMatr(int[][] arr1, int size) {
	int[][] arr2 = new int[size][];
        for (int i = 0; i < size; i++) {
            arr2[i] = new int[size];
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr2[i][j] = 0;
            }
        }


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr2[j][size - i - 1] = arr1[i][j];
            }
        }
        return arr2;
    }
}
