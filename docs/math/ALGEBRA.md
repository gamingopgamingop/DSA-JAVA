# 📐 Algebra & Polynomials

The study of symbols, equations, and relationships between variables.

---

## 🔍 Deep Dive: Quadratic Equations

### 1. Formula (Quadratic Formula)
For $ax^2 + bx + c = 0$:
$$x = \frac{-b \pm \sqrt{b^2 - 4ac}}{2a}$$
Where $\Delta = b^2 - 4ac$ is the **discriminant**.

### 2. Derivation
Complete the square:
1. $ax^2 + bx = -c$
2. $x^2 + \frac{b}{a}x = -\frac{c}{a}$
3. Add $\left(\frac{b}{2a}\right)^2$ to both sides: $x^2 + \frac{b}{a}x + \left(\frac{b}{2a}\right)^2 = -\frac{c}{a} + \left(\frac{b}{2a}\right)^2$
4. Simplify: $\left(x + \frac{b}{2a}\right)^2 = \frac{b^2 - 4ac}{4a^2}$
5. Take square roots and solve for $x$.

### 3. Mathematical Proof
The quadratic formula is a direct algebraic identity derived from completing the square. It holds for all real $a \neq 0, b, c$.

### 4. Intuition
Quadratic equations model parabolas. The formula finds where the parabola crosses the x-axis. The discriminant tells you if there are 2, 1, or 0 real roots.

### 5. Visual Explanation
A parabola opening upwards or downwards. The roots are the intersection points with the y=0 line.

### 6. Step-by-Step Calculation
1. **Problem**: $2x^2 - 5x + 2 = 0$
2. Identify $a=2, b=-5, c=2$
3. Compute discriminant: $\Delta = (-5)^2 - 4(2)(2) = 25 - 16 = 9$
4. Compute roots: $x = \frac{5 \pm 3}{4}$ → $x = 2$ or $x = 0.5$

### 7. Shortcuts
- **Vieta's Formulas**: Sum of roots = $-b/a$, Product = $c/a$
- **Factoring**: When $\Delta$ is a perfect square.

### 8. Common Mistakes
- Forgetting the $\pm$ sign.
- Dividing by $a$ incorrectly when completing the square.

### 9. Competitive Programming Applications
- Solving geometric problems (intersections, distances).
- Root finding in polynomial interpolation.

### 10. DSA Applications
- **Binary Search on Answer**: For problems where the condition is quadratic.
- **Hashing**: Quadratic probing for collision resolution.

### 11. AI/ML Applications
- **Cost functions**: Sum of squared errors is quadratic.
- **Kernel Methods**: Polynomial kernels.

### 12. Real-World Applications
- **Physics**: Projectile motion, free fall.
- **Engineering**: Structural design, electrical circuits.
- **Economics**: Profit maximization.

### 13. Practice Questions
- Solve $3x^2 + 7x + 2 = 0$.
- Find the discriminant and number of real roots for $x^2 - 4x + 5 = 0$.

### 14. Advanced Questions
- Prove Vieta's formulas.
- Solve quadratic equations modulo primes.

### 15. Research-Level Extensions
- **Quadratic forms**: Generalization to $n$ variables (key in ML).
- **Algebraic geometry**: Studying quadratic surfaces.
- **Diophantine equations**: Finding integer solutions to $ax^2 + by^2 = c$.

---

## 📂 Other Algebra Topics
- [Linear Equations](./ALGEBRA.md#linear)
- [Polynomial Theory](./ALGEBRA.md#polynomials)
- [Logarithms & Exponents](./ALGEBRA.md#logs)
- [Sequences & Series](./ALGEBRA.md#series)
- [Complex Numbers](./ALGEBRA.md#complex)
