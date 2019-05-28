package DokuzTas;

import java.util.ArrayList;

/**
 *
 * @author haltay
 */
public class Komsular {

    public static int[] getKomsular(int input) throws Exception {
        if (input < 0 || input > 23) {
            throw new Exception("input not in valid region");
        }

        switch (input) {
            case 0:
                return new int[]{1, 3, 9};
            case 1:
                return new int[]{0, 2, 4};
            case 2:
                return new int[]{1, 5, 14};
            case 3:
                return new int[]{0, 4, 6, 10};
            case 4:
                return new int[]{1, 3, 5, 7};
            case 5:
                return new int[]{2, 4, 8, 13};
            case 6:
                return new int[]{3, 7, 11};
            case 7:
                return new int[]{4, 6, 8};
            case 8:
                return new int[]{5, 7, 12};
            case 9:
                return new int[]{0, 10, 21};
            case 10:
                return new int[]{3, 9, 11, 18};
            case 11:
                return new int[]{6, 10, 15};
            case 12:
                return new int[]{8, 13, 17};
            case 13:
                return new int[]{5, 12, 14, 20};
            case 14:
                return new int[]{2, 13, 23};
            case 15:
                return new int[]{11, 16, 18};
            case 16:
                return new int[]{15, 17, 19};
            case 17:
                return new int[]{12, 16, 20};
            case 18:
                return new int[]{10, 15, 19, 21};
            case 19:
                return new int[]{16, 18, 20, 22};
            case 20:
                return new int[]{13, 17, 19, 23};
            case 21:
                return new int[]{9, 18, 22};
            case 22:
                return new int[]{19, 21, 23};
            case 23:
                return new int[]{14, 20, 22};
            default:
                return new int[]{};
        }
    }

    public static void main(String[] args) throws Exception {
        int[] arr = Komsular.getKomsular(5);

        for (int i : arr) {
            System.out.println(i);
        }

//        int[] arr = new int[]{1,2,3};
    }
}
