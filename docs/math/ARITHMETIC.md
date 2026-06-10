# ➗ Arithmetic & Quantitative Aptitude

The foundation of numerical computation and problem-solving.

---

## 🔍 Deep Dive: Compound Interest

### 1. Formula
$$A = P \left(1 + \frac{r}{n}\right)^{nt}$$
Where:
- $A$ = Final amount
- $P$ = Principal amount
- $r$ = Annual interest rate (decimal)
- $n$ = Number of times interest is compounded per year
- $t$ = Time in years

### 2. Derivation
Compound interest is the interest on interest.
1. After first compounding period: $A_1 = P + P \cdot \frac{r}{n} = P(1 + \frac{r}{n})$
2. After second period: $A_2 = A_1(1 + \frac{r}{n}) = P(1 + \frac{r}{n})^2$
3. Generalizing for $nt$ periods: $A = P(1 + \frac{r}{n})^{nt}$

### 3. Mathematical Proof
By induction:
- **Base case**: $t=1$ holds as shown in derivation.
- **Inductive step**: Assume true for $t=k$, then $A(k+1) = A(k)(1 + \frac{r}{n})^n = P(1 + \frac{r}{n})^{n(k+1)}$, which is true.

### 4. Intuition
Your money grows exponentially because each interest payment earns its own interest over time—like a snowball rolling downhill.

### 5. Visual Explanation
A line graph where simple interest is a straight line and compound interest is a curve that grows steeper over time.

### 6. Step-by-Step Calculation
1. **Problem**: $P = \$10,000$, $r = 5\% = 0.05$, $n = 12$ (monthly), $t = 10$ years.
2. Compute $\frac{r}{n} = 0.05/12 \approx 0.004167$
3. Compute $nt = 12 \times 10 = 120$
4. Compute $(1 + 0.004167)^{120} \approx 1.6470$
5. Final amount: $A = 10,000 \times 1.6470 = \$16,470$

### 7. Shortcuts
- **Rule of 72**: Estimate doubling time: $t \approx 72 / r$ (e.g., $r=6\%$ → ~12 years).
- **Rule of 70**: Similar but uses 70 for continuous compounding.

### 8. Common Mistakes
- Confusing **annual rate** with **periodic rate** (forgetting to divide $r$ by $n$).
- Mixing up simple and compound interest formulas.

### 9. Competitive Programming Applications
- Problems involving growth/decay, loan repayment, investment.
- Modular arithmetic for large compound interest values.

### 10. DSA Applications
- Used in **dynamic programming** for financial/resource allocation problems.
- Calculating amortization schedules (trees/graphs for payments).

### 11. AI/ML Applications
- **Time series forecasting**: Exponential growth models.
- **Reinforcement learning**: Reward compounding over time steps.

### 12. Real-World Applications
- **Finance**: Savings accounts, loans, retirement planning.
- **Business**: Revenue growth projections.
- **Science**: Population growth, radioactive decay.

### 13. Practice Questions
- Calculate the amount after 5 years on $\$5000$ at 8% compounded quarterly.
- What principal will grow to $\$10,000$ in 10 years at 6% compounded annually?

### 14. Advanced Questions
- Derive the formula for **continuous compounding** ($A = Pe^{rt}$) as $n \to \infty$.
- Solve for $t$ given $A, P, r, n$ using logarithms.

### 15. Research-Level Extensions
- **Stochastic compound interest**: Models with random interest rates.
- **Fractional compounding**: Non-integer $n$ using calculus.
- **Compound interest in cryptocurrencies**: Staking and yield farming.

---

## 📂 Other Arithmetic Topics
- [Basic Operations](./ARITHMETIC.md#basics)
- [Fractions & Decimals](./ARITHMETIC.md#fractions)
- [Ratios & Proportions](./ARITHMETIC.md#ratios)
- [Time & Work](./ARITHMETIC.md#time-work)
- [Time, Speed & Distance](./ARITHMETIC.md#speed-distance)
