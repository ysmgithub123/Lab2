class Solution10 {
    public String fractionAddition(String expression) {
        long numerator = 0, denominator = 1; // 分子，分母
        int index = 0, n = expression.length();
        while (index < n) {
            // 读取分子
            long numeratorPart = 0, sign = 1;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1;
                index++;
            }
            while (index < n && Character.isDigit(expression.charAt(index))) {
                numeratorPart = numeratorPart * 10 + expression.charAt(index) - '0';
                index++;
            }
            numeratorPart *= sign;
            index++; // 跳过 '/' 字符

            // 读取分母
            long denominatorPart = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                denominatorPart = denominatorPart * 10 + expression.charAt(index) - '0';
                index++;
            }

            // 更新总分数 (通分)
            numerator = numerator * denominatorPart + numeratorPart * denominator;
            denominator *= denominatorPart;

            // 化简分数，避免分子分母值过大
            long gcdValue = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcdValue;
            denominator /= gcdValue;
        }

        // 处理分数化简
        if (numerator == 0) {
            return "0/1";
        }

        // 确保分母为正数
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        return numerator + "/" + denominator;
    }

    // 求最大公约数
    public long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
