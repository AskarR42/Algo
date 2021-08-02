class Solution {

    public String solveEquation(String equation) {
        int xCoefficient = 0;
        int number = 0;
        char sign = '+';
        boolean leftPart = true;
        String n = "1";

        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '=') {
                leftPart = false;
                sign = '+';
            } else if (equation.charAt(i) == '+' || equation.charAt(i) == '-') {
                sign = equation.charAt(i);
            } else if (equation.charAt(i) == 'x') {
                if (sign == '+') {
                    xCoefficient = (leftPart ? xCoefficient + Integer.parseInt(n) : xCoefficient - Integer.parseInt(n));
                } else {
                    xCoefficient = (leftPart ? xCoefficient - Integer.parseInt(n) : xCoefficient + Integer.parseInt(n));
                }
                n = "1";
            } else {
                n = "";
                while (i != equation.length() && equation.charAt(i) >= '0' && equation.charAt(i) <= '9') {
                    n += equation.charAt(i);
                    i++;
                }
                if (i == equation.length() || equation.charAt(i) != 'x') {
                    if (sign == '+') {
                        number = (leftPart ? number - Integer.parseInt(n) : number + Integer.parseInt(n));
                    } else {
                        number = (leftPart ? number + Integer.parseInt(n) : number - Integer.parseInt(n));
                    }
                    n = "1";
                }
                i--;
            }
        }

        String answer;
        if (xCoefficient == 0 && number == 0) {
            answer = "Infinite solutions";
        } else if (xCoefficient == 0 && number != 0) {
            answer = "No solution";
        } else {
            answer = "x=" + number / xCoefficient;
        }

        return answer;
    }
}
