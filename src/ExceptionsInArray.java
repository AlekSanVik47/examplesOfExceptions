public class ExceptionsInArray {
    public static int exceptionMethod(String[][] arr1) throws MyArraySizeException, MyArrayDataException {
        int sumOfElements = 0;
        if (arr1.length != 4) throw new MyArraySizeException();
        for (String[] strings : arr1) {
            if (strings.length != 4) throw new MyArraySizeException();
            for (int j = 0; j < arr1.length; j++) {
                try {
                    sumOfElements += Integer.parseInt(strings[j]);
                } catch (NumberFormatException e) {
                    DataException(arr1);
                }
            }
        }
        System.out.println();
        return sumOfElements;
    }
    public static boolean DataException(String[][] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
              try {
                  int number = Integer.parseInt(arr1[i][j]);
              }catch (NumberFormatException e){
                  System.out.println("ЗНАЧЕНИЕ МАССИВА ИМЕЕТ НЕ ЧИСЛОВОЕ ЗНАЧЕНИЕ");
                  System.out.println("ОШИБКА В ЯЧЕЙКЕ МАССИВА: (строка * столбец)"  + "  " +
                          (i +1) + "*" + (j +1) + " значение - " + arr1[i][j]);
                  return false;
              }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String[][] arr1 = {
                {"22", "37", "67", "15", "25"},
                {"1", "3", "7", "work"},
                {"2", "1", "0", "0"},
                {"52", "77", "87", "54"}
        };
                try { int result;
                    result = exceptionMethod(arr1);
                    System.out.println("Сумма числовых элементов массива равна: " + result);
                     return;
                } catch (MyArraySizeException e) {
                    e.printStackTrace();
                    System.out.println();
                    System.out.println("РАЗМЕР МАССИВА НЕ РАВЕН 4 (четырем)!");
                    return;
                } catch (MyArrayDataException e) {
                    e.printStackTrace();
                }
            }
    private static class MyArraySizeException extends IndexOutOfBoundsException {

    }
    private static class MyArrayDataException extends ClassCastException {

    }
}
