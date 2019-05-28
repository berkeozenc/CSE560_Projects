package DokuzTas;

/**
 *
 * @author haltay
 */
public class Morris {

    public static boolean isCloseMorris(Tas[] tahta, int input) throws Exception {
        if (input < 0 || input > 23) {
            throw new Exception("input not in valid region");
        }

        switch (input) {
            case 0:
                if (((tahta[0].getRenk() == tahta[1].getRenk()) && (tahta[0].getRenk() == tahta[2].getRenk()))
                        || ((tahta[0].getRenk() == tahta[9].getRenk()) && (tahta[0].getRenk() == tahta[21].getRenk()))
                        || ((tahta[0].getRenk() == tahta[3].getRenk()) && (tahta[0].getRenk() == tahta[6].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 1:
                if (((tahta[1].getRenk() == tahta[0].getRenk()) && (tahta[1].getRenk() == tahta[2].getRenk()))
                        || ((tahta[1].getRenk() == tahta[4].getRenk()) && (tahta[1].getRenk() == tahta[7].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (((tahta[2].getRenk() == tahta[0].getRenk()) && (tahta[2].getRenk() == tahta[1].getRenk()))
                        || ((tahta[2].getRenk() == tahta[5].getRenk()) && (tahta[2].getRenk() == tahta[8].getRenk()))
                        || ((tahta[2].getRenk() == tahta[14].getRenk()) && (tahta[2].getRenk() == tahta[23].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (((tahta[3].getRenk() == tahta[0].getRenk()) && (tahta[3].getRenk() == tahta[6].getRenk()))
                        || ((tahta[3].getRenk() == tahta[10].getRenk()) && (tahta[3].getRenk() == tahta[18].getRenk()))
                        || ((tahta[3].getRenk() == tahta[4].getRenk()) && (tahta[3].getRenk() == tahta[5].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (((tahta[4].getRenk() == tahta[1].getRenk()) && (tahta[4].getRenk() == tahta[7].getRenk()))
                        || ((tahta[4].getRenk() == tahta[3].getRenk()) && (tahta[4].getRenk() == tahta[5].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 5:
                if (((tahta[5].getRenk() == tahta[3].getRenk()) && (tahta[5].getRenk() == tahta[4].getRenk()))
                        || ((tahta[5].getRenk() == tahta[13].getRenk()) && (tahta[5].getRenk() == tahta[20].getRenk()))
                        || ((tahta[5].getRenk() == tahta[2].getRenk()) && (tahta[5].getRenk() == tahta[8].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 6:
                if (((tahta[6].getRenk() == tahta[3].getRenk()) && (tahta[6].getRenk() == tahta[0].getRenk()))
                        || ((tahta[6].getRenk() == tahta[11].getRenk()) && (tahta[6].getRenk() == tahta[15].getRenk()))
                        || ((tahta[6].getRenk() == tahta[7].getRenk()) && (tahta[6].getRenk() == tahta[8].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 7:
                if (((tahta[7].getRenk() == tahta[4].getRenk()) && (tahta[7].getRenk() == tahta[1].getRenk()))
                        || ((tahta[7].getRenk() == tahta[6].getRenk()) && (tahta[7].getRenk() == tahta[8].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 8:
                if (((tahta[8].getRenk() == tahta[6].getRenk()) && (tahta[8].getRenk() == tahta[7].getRenk()))
                        || ((tahta[8].getRenk() == tahta[12].getRenk()) && (tahta[8].getRenk() == tahta[17].getRenk()))
                        || ((tahta[8].getRenk() == tahta[5].getRenk()) && (tahta[8].getRenk() == tahta[2].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 9:
                if (((tahta[9].getRenk() == tahta[0].getRenk()) && (tahta[9].getRenk() == tahta[21].getRenk()))
                        || ((tahta[9].getRenk() == tahta[10].getRenk()) && (tahta[9].getRenk() == tahta[11].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 10:
                if (((tahta[10].getRenk() == tahta[9].getRenk()) && (tahta[10].getRenk() == tahta[11].getRenk()))
                        || ((tahta[10].getRenk() == tahta[3].getRenk()) && (tahta[10].getRenk() == tahta[18].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 11:
                if (((tahta[11].getRenk() == tahta[9].getRenk()) && (tahta[11].getRenk() == tahta[10].getRenk()))
                        || ((tahta[11].getRenk() == tahta[6].getRenk()) && (tahta[11].getRenk() == tahta[15].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 12:
                if (((tahta[12].getRenk() == tahta[8].getRenk()) && (tahta[12].getRenk() == tahta[17].getRenk()))
                        || ((tahta[12].getRenk() == tahta[13].getRenk()) && (tahta[12].getRenk() == tahta[14].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 13:
                if (((tahta[13].getRenk() == tahta[12].getRenk()) && (tahta[13].getRenk() == tahta[14].getRenk()))
                        || ((tahta[13].getRenk() == tahta[5].getRenk()) && (tahta[13].getRenk() == tahta[20].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 14:
                if (((tahta[14].getRenk() == tahta[2].getRenk()) && (tahta[14].getRenk() == tahta[23].getRenk()))
                        || ((tahta[14].getRenk() == tahta[13].getRenk()) && (tahta[14].getRenk() == tahta[12].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 15:
                if (((tahta[15].getRenk() == tahta[6].getRenk()) && (tahta[15].getRenk() == tahta[11].getRenk()))
                        || ((tahta[15].getRenk() == tahta[16].getRenk()) && (tahta[15].getRenk() == tahta[17].getRenk()))
                        || ((tahta[15].getRenk() == tahta[18].getRenk()) && (tahta[15].getRenk() == tahta[21].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 16:
                if (((tahta[16].getRenk() == tahta[15].getRenk()) && (tahta[16].getRenk() == tahta[17].getRenk()))
                        || ((tahta[16].getRenk() == tahta[19].getRenk()) && (tahta[16].getRenk() == tahta[22].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 17:
                if (((tahta[17].getRenk() == tahta[16].getRenk()) && (tahta[17].getRenk() == tahta[15].getRenk()))
                        || ((tahta[17].getRenk() == tahta[12].getRenk()) && (tahta[17].getRenk() == tahta[8].getRenk()))
                        || ((tahta[17].getRenk() == tahta[20].getRenk()) && (tahta[17].getRenk() == tahta[23].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 18:
                if (((tahta[18].getRenk() == tahta[10].getRenk()) && (tahta[18].getRenk() == tahta[3].getRenk()))
                        || ((tahta[18].getRenk() == tahta[19].getRenk()) && (tahta[18].getRenk() == tahta[20].getRenk()))
                        || ((tahta[18].getRenk() == tahta[15].getRenk()) && (tahta[18].getRenk() == tahta[21].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 19:
                if (((tahta[19].getRenk() == tahta[18].getRenk()) && (tahta[19].getRenk() == tahta[20].getRenk()))
                        || ((tahta[19].getRenk() == tahta[16].getRenk()) && (tahta[19].getRenk() == tahta[22].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 20:
                if (((tahta[20].getRenk() == tahta[13].getRenk()) && (tahta[20].getRenk() == tahta[5].getRenk()))
                        || ((tahta[20].getRenk() == tahta[19].getRenk()) && (tahta[20].getRenk() == tahta[18].getRenk()))
                        || ((tahta[20].getRenk() == tahta[17].getRenk()) && (tahta[20].getRenk() == tahta[23].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 21:
                if (((tahta[21].getRenk() == tahta[9].getRenk()) && (tahta[21].getRenk() == tahta[0].getRenk()))
                        || ((tahta[21].getRenk() == tahta[22].getRenk()) && (tahta[21].getRenk() == tahta[23].getRenk()))
                        || ((tahta[21].getRenk() == tahta[18].getRenk()) && (tahta[21].getRenk() == tahta[15].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 22:
                if (((tahta[22].getRenk() == tahta[21].getRenk()) && (tahta[22].getRenk() == tahta[23].getRenk()))
                        || ((tahta[22].getRenk() == tahta[16].getRenk()) && (tahta[22].getRenk() == tahta[19].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            case 23:
                if (((tahta[23].getRenk() == tahta[22].getRenk()) && (tahta[23].getRenk() == tahta[21].getRenk()))
                        || ((tahta[23].getRenk() == tahta[20].getRenk()) && (tahta[23].getRenk() == tahta[17].getRenk()))
                        || ((tahta[23].getRenk() == tahta[14].getRenk()) && (tahta[23].getRenk() == tahta[2].getRenk()))) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    public static void main(String[] args) throws Exception {
        Tahta tahta = new Tahta();
//        for (int i = 0; i < tahta.tahta.length; i++) {
//            System.out.println(tahta.tahta[i].getRenk());
//        }
        tahta.tasKoy(0, new Tas(Renk.MAVI));
        tahta.tasKoy(3, new Tas(Renk.MAVI));
        tahta.tasKoy(6, new Tas(Renk.MAVI));
//        tahta.tasKoy(2, new Tas(Renk.SARI));
//        tahta.tasKoy(2, new Tas(Renk.BOS));

        boolean isCloseMorris = Morris.isCloseMorris(tahta.getTahta(), 0);

        System.out.println(isCloseMorris);

    }
}
