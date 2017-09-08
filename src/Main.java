import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Skori on 07.09.2017.
 */
public class Main {
    public static void main (String... args) {
        final char alph[] = {'А', 'а', 'Б', 'б', 'В', 'в', 'Г', 'г', 'Д', 'д', 'Е', 'е', 'Ё', 'ё', 'Ж', 'ж', 'З', 'з', 'И', 'и', 'Й', 'й', 'К', 'к',
                'Л', 'л', 'М', 'м', 'Н', 'н', 'О', 'о', 'П', 'п', 'Р', 'р', 'С', 'с', 'Т', 'т', 'У', 'у', 'Ф', 'ф', 'Х', 'х', 'Ц', 'ц', 'Ч', 'ч', 'Ш', 'ш',
                'Щ', 'щ', 'Ъ', 'ъ', 'Ы', 'ы', 'Ь', 'ь', 'Э', 'э', 'Ю', 'ю', 'Я', 'я' };
        int sizeAlph = alph.length / 2;

        Scanner sc = new Scanner(System.in);

        // Кусок непонятного кода который отвечает за случаные циферки от 1 до размера алфавита
	    final int ONE = 1;


        String flag = "д";
        String flag1 = "н";
        String flag2 = "д";
        String text, stext;
        int keyC = 0;
        String keyV;
        double kol = 0;

        // Это текст который нам нужно расшифравать (Ну сначало мы его зашифруем со случайным ключом, а потом расшифруем)
        String shifrText, forShifrText = "И если бы даже случилось когда-нибудь так, что уже всё до последней точки было бы им разобрано и решено окончательно и сомнений не оставалось бы уже более никаких, -- то тут-то бы, кажется, он и отказался от всего, как от нелепости, чудовищности и невозможности. Но неразрешенных пунктов и сомнений оставалась еще целая бездна. Что же касается до того, где достать топор, то эта мелочь его нисколько не беспокоила, потому что не было ничего легче. Дело в том, что Настасьи, и особенно по вечерам, поминутно не бывало дома: или убежит к соседям, или в лавочку, а дверь всегда оставляет настежь. Хозяйка только из-за этого с ней и ссорилась. Итак, стоило только потихоньку войти, когда придет время, в кухню и взять топор, а потом, чрез час (когда всё уже кончится), войти и положить обратно. Но представлялись и сомнения: он, положим, придет через час, чтобы положить обратно, а Настасья тут как тут, воротилась. Конечно, надо пройти мимо и выждать, пока она опять выйдет. А ну как тем временем хватится топора, искать начнет, раскричится, -- вот и подозрение или, по крайней мере, случай к подозрению.";
        String forShifrText2 = "И ты понял всё не так, я загадывал не это: Нет, я не хотел летать, я хотел увидеть небо	Забери крылья назад, я свободное паденье Да, ты понял всё не так";
        int key322 = 3;
        String key3222 = "примерключа";
        List<Integer> myKey = new ArrayList<Integer>();
        //vector<int> myKey(0);
        int sizeMyKey = 0;
        int numb = -1;
        String bukva = "a";

        // Это текст который мы анализируем что бы узнать частоту встречаемости букв в обычом тексте
        String textForAnaliz = "Он съел немного, без аппетита, ложки три-четыре, как бы машинально. Голова болела меньше. Пообедав, протянулся он опять на диван, но заснуть уже не мог, а лежал без движения, ничком, уткнув лицо в подушку. Ему всё грезилось, и всё странные такие были грезы: всего чаще представлялось ему, что он где-то в Африке, в Египте, в каком-то оазисе. Караван отдыхает, смирно лежат верблюды; кругом пальмы растут целым кругом; все обедают. Он же всё пьет воду, прямо из ручья, который тут же, у бока, течет и журчит. И прохладно так, и чудесная-чудесная такая голубая вода, холодная, бежит по разноцветным камням и по такому чистому с золотыми блестками песку... Вдруг он ясно услышал, что бьют часы. Он вздрогнул, очнулся, приподнял голову, посмотрел в окно, сообразил время и вдруг вскочил, совершенно опомнившись, как будто кто его сорвал с дивана. На цыпочках подошел он к двери, приотворил ее тихонько и стал прислушиваться вниз на лестницу. Сердце его страшно билось. Но на лестнице было всё тихо, точно все спали... Дико и чудно показалось ему, что он мог проспать в таком забытьи со вчерашнего дня и ничего еще не сделал, ничего не приготовил... А меж тем, может, и шесть часов било... И необыкновенная лихорадочная и какая-то растерявшаяся суета охватила его вдруг, вместо сна и отупения. Приготовлений, впрочем, было немного. Он напрягал все усилия, чтобы всё сообразить и ничего не забыть; а сердце всё билось, стукало так, что ему дышать стало тяжело. Во-первых, надо было петлю сделать и к пальто пришить -- дело минуты. Он полез под подушку и отыскал в напиханном под нее белье одну, совершенно развалившуюся, старую, немытую свою рубашку. Из лохмотьев ее он выдрал тесьму, в вершок шириной и вершков в восемь длиной. Эту тесьму сложил он вдвое, снял с себя свое широкое, крепкое, из какой-то толстой бумажной материи летнее пальто (единственное его верхнее платье) и стал пришивать оба конца тесьмы под левую мышку изнутри. Руки его тряслись пришивая, но он одолел и так, что снаружи ничего не было видно, когда он опять надел пальто. Иголка и нитки были у него уже давно приготовлены и лежали в столике, в бумажке. Что же касается петли, то это была очень ловкая его собственная выдумка: петля назначалась для топора. Нельзя же было по улице нести топор в руках. А если под пальто спрятать, то все-таки надо было рукой придерживать, что было бы приметно. Теперь же, с петлей, стоит только вложить в нее лезвие топора, и он будет висеть спокойно, под мышкой изнутри, всю дорогу. Запустив же руку в боковой карман пальто, он мог и конец топорной ручки придерживать, чтоб она не болталась; а так как пальто было очень широкое, настоящий мешок, то и не могло быть приметно снаружи, что он что-то рукой, через карман, придерживает. Эту петлю он тоже уже две недели назад придумал.";

        // Набор переменных для анализа текстов
	double arrMaxText[] = new double[sizeAlph]; // В этих массивах хранятся упорядоченные по частоте встречаемости буквы
        for (int i = 0; i < sizeAlph / 2; i++) {
            arrMaxText[i] = 0.0;
        }
	double arrMaxShifrText[] = new double[sizeAlph];
        for (int i = 0; i < sizeAlph / 2; i++) {
            arrMaxShifrText[i] = 0.0;
        }
	int arrMaxIndex[] = new int[sizeAlph];
        for (int i = 0; i < sizeAlph / 2; i++) {
            arrMaxIndex[i] = 0;
        }
	int arrMaxShifrIndex[] = new int[sizeAlph];
        for (int i = 0; i < sizeAlph / 2; i++) {
            arrMaxShifrIndex[i] = 0;
        }


        //текст для шифровки решёткой Кардано
        String kard = "ТахиондвижетсябыстреескоростисветаАА";
        //создание матрицы текста
	final int KEYSIZE = 6;
	int shifrMatrix[][];
        for (int i = 0; i < KEYSIZE; i++) {
            shifrMatrix[i] = new int[KEYSIZE];
        }
        for (int i = 0; i < KEYSIZE; i++) {
            for (int j = 0; j < KEYSIZE; j++) {
                shifrMatrix[i][j] = 0;
            }
        }

        for ( ; flag.equals("д"); ) {
            int choice = 0;
            int choise2 = 0;
            System.out.println();
            System.out.println("Введите 1, если хотите зашифровать текст методом Цезаря.");
            System.out.println("Введите 2, если хотите расшифровать текст который зашифрован методом Цезаря и у вас есть ключ.");
            System.out.println("Введите 3, если хотите зашифровать текст методом Виженера.");
            System.out.println("Введите 4, если хотите расшифровать текст который зашифрован методом Виженера и у вас есть ключ.");
            System.out.println("Введите 5, если хотите расшифровать текст который зашифрован методом Цезаря и у вас нет ключа.");
            System.out.println("Введите 6, если хотите расшифровать текст который зашифрован методом Виженера и у вас нет ключа.");
            System.out.println("Введите 7, если хотите зашифровать текст решёткой Кардано.");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите ваш текст: ");
                    text = sc.nextLine();
                    System.out.println("Введите ключ: ");
                    keyC = sc.nextInt();
                    while (keyC > sizeAlph) {
                        keyC = keyC % sizeAlph;
                    }
                    stext = Ceasar.shifr(alph, text, keyC);
                    System.out.println(stext);
                    break;
                case 2:
                    System.out.println("Введите ваш зашифрованный текст: ");
                    text = sc.nextLine();
                    System.out.println("Введите ключ: ");
                    keyC = sc.nextInt();
                    while (keyC > sizeAlph) {
                        keyC = keyC % sizeAlph;
                    }
                    stext = Ceasar.deshifr(alph, text, 2 * keyC);
                    System.out.println(stext);
                    break;
                case 3:
                    System.out.println("Введите ваш текст: ");
                    text = sc.nextLine();
                    System.out.println("Введите ключ: ");
                    keyV = sc.nextLine();
                    stext = Vigenere.shifr(alph, text, keyV);
                    System.out.println(stext);
                    break;
                case 4:
                    System.out.println("Введите ваш зашифрованный текст: ");
                    text = sc.nextLine();
                    System.out.println("Введите ключ: ");
                    keyV = sc.nextLine();
                    stext = Vigenere.deshifr(alph, text, keyV);
                    System.out.println(stext);
                    break;
                case 5:
                    shifrText = Ceasar.shifr(alph, forShifrText2, key322);
                    System.out.println("Вот зашифрованный текст: ");
                    System.out.println(shifrText);

                    // В этом блоке мы анализируем частоту встречаемости букв в заданном тексте
                    // и составляем массив с упорядоченными по частоте индексами букв алфавита
                    Analiz::anCeas(alph, textForAnaliz, arrMaxText, arrMaxIndex);
                    // В этом блоке тоже самое что и в предыдущем только тут анализируем зашифрованный текст
                    Analiz::anCeas(alph, shifrText, arrMaxShifrText, arrMaxShifrIndex);

                    // Цикл для проверки правильно ли мы выбрали ключ или нет
                    for (int i = 0; i < sizeAlph && flag1.equals("н"); i++) {
                        String deShifrText = Ceasar.deshifr(alph, shifrText, (sizeAlph + (arrMaxShifrIndex[0] - arrMaxIndex[i])) % sizeAlph);
                        System.out.println("Я предпологаю что ключ: " + arrMaxIndex[i]);
                        System.out.println("А исходный текст: ");
                        System.out.println(deShifrText);
                        System.out.println("Если это не похоже на исходный текст введите 'н': ";
                        flag1 = sc.nextLine();
                    }
                    break;
                case 6:
                    shifrText = Vigenere.shifr(alph, forShifrText, key3222);
                    System.out.println("Вот зашифрованный текст: ");
                    System.out.println(shifrText);

                    // В этом блоке мы анализируем частоту встречаемости букв в заданном тексте
                    // и составляем массив с упорядоченными по частоте индексами букв алфавита

                    // Первый аргумент - алфавит, второй - зашифрованный текст, третий - массив для хранения частоты встечающихся букв, четвёрный - массив с индексами букв
                    Analiz::anCeas(alph, textForAnaliz, arrMaxText, arrMaxIndex);
                    // В этом блоке тоже самое что и в предыдущем только тут анализируем зашифрованный текст
                    Analiz::anVig(alph, shifrText, arrMaxShifrText, arrMaxShifrIndex);

                    //В этом блоке мы находим ключевое слово исходя из его длины
                    System.out.println("Выебрите длину ключа: ");
                    sizeMyKey = sc.nextInt();
                    for (int i = 0; i < sizeMyKey; i++) {
                        //System.out.println(arrMaxIndex[i] << "   текст") << Analiz::anText(alph, shifrText, i, sizeMyKey)));
                        myKey.add((2 * sizeAlph + Analiz::anText(alph, shifrText, i, sizeMyKey) - arrMaxIndex[0]) % (2 * sizeAlph) + 1);
                    }
                    System.out.println("Я предполгагаю что ключ к этому тексту: ");
                    for (int i = 0; i < myKey.size(); i++) {
                        System.out.println(alph[myKey.get(i)]);
                    }
                    System.out.println();


                    System.out.println("Введите 1, если данный ключ корректен.");
                    System.out.println("Введите 2, если хотите заменить определённую букву ключа.");
                    choise2 = sc.nextInt();
                    switch (choise2) {
                        case 1:
                            break;
                        case 2:
                            for (; flag2.equals("д");) {
                                System.out.println("Введите номер буквы которую хотите изменить: ");
                                numb = sc.nextInt();
                                System.out.println("Введите букву на которую хотите заменить: ");
                                bukva = sc.nextLine();
                                for (int i = 1; i < sizeAlph * 2; i = i + 2) {
                                    if (bukva.equals(alph[i])) {
                                        myKey.set(numb - 1, i);
                                    }
                                }
                                System.out.println("Я предполгагаю что ключ к этому тексту: ");
                                for (int i = 0; i < myKey.size(); i++) {
                                    System.out.println(alph[myKey.get(i)]);
                                }
                                System.out.println();
                                System.out.println("Если хотите продолжать исправять ключ введите 'д': ");
                                flag2 = sc.nextLine();
                            }
                            break;
                    }

                    stext = Vigenere.deshifr(alph, shifrText, myKey);
                    System.out.println(stext);

                    break;
                case 7:
                    System.out.println();
                    shifrMatrix = Kardano::shifr(alph, kard, KEYSIZE);
                    for (int i = 0; i < KEYSIZE; i++) {
                        for (int j = 0; j < KEYSIZE; j++) {
                            System.out.print(alph[shifrMatrix[i][j]] + "   ");
                        }
                        System.out.println();
                    }
                    break;
                default:
                    System.out.println("Вы должны ввести число от 1 до 7.");
            }
            System.out.println("Если вы хотите продолжить работу, введите 'д':");
            flag = sc.nextLine();
        }
    }
}
