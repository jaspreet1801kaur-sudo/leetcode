class Solution {

    public String solveEquation(String equation) {
        String[] sides = equation.split("=");

        int[] left = evaluate(sides[0]);
        int[] right = evaluate(sides[1]);

        int coeff = left[0] - right[0];
        int constant = right[1] - left[1];

        if (coeff == 0) {
            if (constant == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }

        return "x=" + (constant / coeff);
    }

    private int[] evaluate(String expr) {
        int coeff = 0;
        int constant = 0;
        int sign = 1;
        int i = 0;

        while (i < expr.length()) {

            if (expr.charAt(i) == '+') {
                sign = 1;
                i++;
            } else if (expr.charAt(i) == '-') {
                sign = -1;
                i++;
            }

            int num = 0;
            boolean hasNum = false;

            while (i < expr.length() && Character.isDigit(expr.charAt(i))) {
                num = num * 10 + (expr.charAt(i) - '0');
                i++;
                hasNum = true;
            }

            if (i < expr.length() && expr.charAt(i) == 'x') {
                if (!hasNum)
                    num = 1;
                coeff += sign * num;
                i++;
            } else {
                constant += sign * num;
            }
        }

        return new int[]{coeff, constant};
    }
}