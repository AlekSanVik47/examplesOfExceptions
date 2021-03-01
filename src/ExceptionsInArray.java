public class ExceptionsInArray {
    public static int exceptionMethod(String[][] arr1) throws MyArraySizeException, MyArrayDataException {
        int sumOfElements = 0;
        if (arr1.length != 4) throw new MyArraySizeException();
        for (String[] strings : arr1) {
            if (strings.length != 4)
                throw new MyArraySizeException();
            for (int j = 0; j < strings.length; j++) {
                try {
                    sumOfElements += Integer.parseInt(strings[j]);
                } catch (NumberFormatException e) {
                    String arrayElement = strings[j];
                    System.out.println("ЗНАЧЕНИЕ МАССИВА ИМЕЕТ НЕ ЧИСЛОВОЕ ЗНАЧЕНИЕ");
                    System.out.println("ОШИБКА В ЯЧЕЙКЕ МАССИВА: "+
                           "в строке: " + (j + 1) + " *" + " столбца: " + (j) + " в значении - " + arrayElement);
                    e.printStackTrace();
                }
            }
        }
        System.out.println();
        return sumOfElements;
    }

    public static void main(String[] args) {
        String[][] arr1 = {
                {"22", "37", "67", "15"},
                {"1", "3", "7", "125"},
                {"2", "test", "0", "0"},
                {"52", "77", "87", "new"},
                {"66"}
        };
                try { int result;
                    result = exceptionMethod(arr1);
                    System.out.println("Сумма числовых элементов массива равна: " + result);
                    System.out.println();
                } catch (MyArraySizeException e) {
                    System.out.println("РАЗМЕР МАССИВА НЕ РАВЕН 4 (четырем)!");
                    e.printStackTrace();
                }
            }
    private static class MyArraySizeException extends IndexOutOfBoundsException {


    }
    private static class MyArrayDataException extends NumberFormatException {

    }
}
