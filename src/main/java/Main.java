public class Main implements IntMain {

    public static void main(String[] args) {
//        int [] arr = new int[]{0,1,2,3,0,5,6,7,8,9};
//        massive(arr);

    }

    @Override
    public int [] massive(int[] arr){
        int [] newArr = new int[0];
        boolean b = false; // для определения есть 4 в массиве ии нет
        int i;
        int j;

        //Проверка на последнюю четверку
        if (arr[arr.length-1] == 4){
            return newArr;
        }

        //Проверка на наличие цифры 4 в массиве
        for (i = 0; i < arr.length; i++) {
            b = false;
            if (arr[i] == 4) {
                b = true;
                break;
            }
        }
        if(!b) {
            throw new RuntimeException("в массиве нет цифры 4");
        }

        //Бежим по массиву в обратном направлении
        for (i = arr.length-1; i >= 0 ; i--) {

            //Находим следующий индекс после последней четверки (j)
            if (arr[i] == 4) {
                j = i+1;
                i = 0;
                newArr = new int[arr.length-j];

                for ( int k = j ; k < arr.length ; k++) {
                    newArr[i] = arr[k];
                    System.out.print(newArr[i]);
                    i++;
                }
                break;
            }
        }
        return newArr;
    }

    @Override
    public boolean massiveOneFour(int[] arr) {
        boolean b = false;
        int counterOne = 0;
        int counterFour = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                counterOne++;
            }
            if (arr[i] == 4) {
                counterFour++;
            }
            if (arr[i] != 1 && arr[i] != 4){
                return false;
            }
        }
        if (counterFour > 0 && counterOne > 0){
            b = true;
        }
        return b;
    }


}

