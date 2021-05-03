public class Main {

    public static void main(String[] args) {
        int [] arr = new int[]{0,1,2,3,4,5,6,7,8,9};

        massive(arr);


    }

    public static int [] massive(int [] arr){

        int i;
        int j;

        //Проверка на последнюю четверку
        if (arr[arr.length-1] == 4){
            return (new int[0]);
        }

        //Проверка на наличие цифры 4 в массиве
        boolean b = false;
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

        //Находим следующий индекс после последней четверки
        for (i = arr.length-1; i >= 0 ; i--) {
            //System.out.print(arr[i] + " ");
            //new int[]{0,1,2,3,4,5,6,7,8,9};
            if (arr[i] == 4) {
                j = i;
                i = 0;
                int [] arr1 = new int[arr.length-j];

                for ( j = j ; j < arr.length ; j++) {

                    arr1[i] = arr[j];
                    System.out.print(arr1[i]);
                    i++;


                }return arr1;
            }
        }
        return arr;
    }
}

