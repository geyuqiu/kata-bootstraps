class sumBase:
    def sumBase(self, n: int, k: int) -> int:
        digits = []
        while n > 0:
            digit = n % k
            digits.append(digit)
            n //= k
        sum = 0;
        for i in range(0, len(digits)):
            sum += digits[i]
        return sum