package Accepted;

public class IntegerToRoman {

public String intToRoman(int num) {
        
        int remains = num;
        String result = "";
        
        while (remains > 0) {
            if (remains >= 1000) {
                for (int i = 0; i < remains / 1000; i ++)
                    result = result + "M";
                remains = remains % 1000;
            }
            else if (remains >= 900) {
                result = result + "CM";
                remains = remains % 900;
            }
            else if (remains >= 500) {
                for (int i = 0; i < remains / 500; i ++)
                    result = result + "D";
                remains = remains % 500;
            }
            else if (remains >= 400) {
                result = result + "CD";
                remains = remains % 400;
            }
            else if (remains >= 100) {
                for (int i = 0; i < remains / 100; i ++)
                    result = result + "C";
                remains = remains % 100;
            }
            else if (remains >= 90) {
                result = result + "XC";
                remains = remains % 90;
            }
            else if (remains >= 50) {
                for (int i = 0; i < remains / 50; i ++)
                    result = result + "L";
                remains = remains % 50;
            }
            else if (remains >= 40) {
                result = result + "XL";
                remains = remains % 40;
            }
            else if (remains >= 10) {
                for (int i = 0; i < remains / 10; i ++)
                    result = result + "X";
                remains = remains % 10;
            }
            else if (remains >= 9) {
                result = result + "IX";
                remains = remains % 9;
            }
            else if (remains >= 5) {
                for (int i = 0; i < remains / 5; i ++)
                    result = result + "V";
                remains = remains % 5;
            }
            else if (remains >= 4) {
                result = result + "IV";
                remains = remains % 4;
            }
            else if (remains >= 1) {
                for (int i = 0; i < remains / 1; i ++)
                    result = result + "I";
                remains = remains % 1;
            }
        }
        
        return result;
    }

}
