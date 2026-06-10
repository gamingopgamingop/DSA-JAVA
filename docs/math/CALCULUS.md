# 📈 Calculus & Analysis

The study of continuous change—derivatives, integrals, and limits.

---

## 🔍 Deep Dive: Power Rule for Differentiation

### 1. Formula
For $f(x) = x^n$:
$$f'(x) = \frac{d}{dx}x^n = nx^{n-1}$$
Where $n$ is any real number (integer, rational, irrational).

### 2. Derivation
Using the **limit definition of the derivative**:
$$f'(x) = \lim_{h \to 0} \frac{f(x+h) - f(x)}{h}$$
For $f(x)=x^n$:
- Use binomial theorem to expand $(x+h)^n$
- Simplify, cancel terms, take the limit.

### 3. Mathematical Proof
Rigorous proof using the limit definition and binomial expansion for integer $n$. Extends to real $n$ using logarithms/exponentials.

### 4. Intuition
The derivative is the slope of the tangent line. The power rule says "bring the exponent down as a multiplier, subtract 1 from the exponent".

### 5. Visual Explanation
A parabola $f(x)=x^2$ with a tangent line at $x=2$. The slope is 4, which is $2x^{2-1}=2x$.

### 6. Step-by-Step Calculation
1. **Problem**: Differentiate $f(x) = 3x^4 + 2x^2 - 5$
2. Apply power rule to each term:
   - $d/dx (3x^4) = 3 \cdot 4x^3 = 12x^3$
   - $d/dx (2x^2) = 2 \cdot 2x = 4x$
   - $d/dx (-5) = 0$
3. Final derivative: $f'(x) = 12x^3 + 4x$

### 7. Shortcuts
- Derivative of a constant is 0.
- Derivative of a sum is the sum of derivatives.
- Derivative of a constant multiple is the constant times the derivative.

### 8. Common Mistakes
- Forgetting that the derivative of a constant is 0.
- Using the power rule incorrectly on negative exponents (e.g., $d/dx (1/x) = -1/x^2$).

### 9. Competitive Programming Applications
- **Numerical differentiation** for optimization in CP problems.
- Calculus-based physics problems.

### 10. DSA Applications
- **Searching**: Finding minima/maxima (derivative is zero at critical points).
- **Time complexity**: Analyzing growth rates of functions.

### 11. AI/ML Applications
- **Backpropagation**: The heart of neural network training relies on the chain rule (extension of power rule).
- **Gradient Descent**: Uses derivatives to minimize loss functions.

### 12. Real-World Applications
- **Physics**: Velocity/acceleration (derivatives of position/velocity).
- **Economics**: Marginal cost/revenue.
- **Engineering**: Rate of change in systems.

### 13. Practice Questions
- Differentiate $f(x) = 5x^3 - \sqrt{x} + 2/x$.
- Find the tangent line to $f(x)=x^3$ at $x=2$.

### 14. Advanced Questions
- Prove the chain rule using the limit definition.
- Differentiate $f(x) = x^x$ (use logarithmic differentiation).

### 15. Research-Level Extensions
- **Fractional calculus**: Derivatives of non-integer order.
- **Automatic differentiation**: Used in PyTorch/TensorFlow (core of deep learning).
- **Stochastic calculus**: For ML and finance (Brownian motion).

---

## 📂 Other Calculus Topics
- [Limits & Continuity](./CALCULUS.md#limits)
- [Integration](./CALCULUS.md#integration)
- [Differential Equations](./CALCULUS.md#diff-eq)
- [Multivariable Calculus](./CALCULUS.md#multivariable)
- [Vector Calculus](./CALCULUS.md#vector)
