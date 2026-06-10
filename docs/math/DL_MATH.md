# 🤖 Deep Learning Mathematics

The math behind neural networks—tensors, Jacobians, Hessians, transformers.

---

## 🔍 Deep Dive: Jacobian Matrix & Chain Rule for Deep Learning

### 1. Formulas
- **Jacobian**: For function $f: \mathbb{R}^n \to \mathbb{R}^m$, the Jacobian $J_f$ is an $m \times n$ matrix where $J_f[i,j] = \frac{\partial f_i}{\partial x_j}$.
- **Chain Rule (Multivariable)**: For $h(x) = g(f(x))$, $J_h = J_g \times J_f$ (matrix multiplication).

### 2. Derivation
Generalization of the single-variable chain rule using partial derivatives.

### 3. Mathematical Proof
By applying the limit definition of the derivative to each component.

### 4. Intuition
The Jacobian represents the local linear approximation of $f$. The chain rule tells us how errors propagate back through layers in a neural network.

### 5. Visual Explanation
A computational graph of a simple neural network (input → hidden → output), with arrows showing how gradients flow backwards using the chain rule.

### 6. Step-by-Step Calculation
1. **Simple Neural Network**: $z = w \cdot x + b$, $a = \sigma(z)$, $L = (y - a)^2$
2. Compute $\frac{\partial L}{\partial w}$ using chain rule:
   - $\frac{\partial L}{\partial a} = -2(y - a)$
   - $\frac{\partial a}{\partial z} = \sigma(z)(1-\sigma(z))$
   - $\frac{\partial z}{\partial w} = x$
   - Multiply them together: $\frac{\partial L}{\partial w} = \frac{\partial L}{\partial a} \cdot \frac{\partial a}{\partial z} \cdot \frac{\partial z}{\partial w}$

### 7. Shortcuts
- **Element-wise operations**: Jacobian is diagonal.
- **Linear layers**: Jacobian is the weight matrix.

### 8. Common Mistakes
- Mixing up the order of multiplication in the chain rule.
- Forgetting to transpose matrices when needed.

### 9. Competitive Programming Applications
- **Numerical optimization**: Gradient-based optimization in CP.
- **Matrix multiplication**: Efficient implementation for large matrices.

### 10. DSA Applications
- **Tensors**: N-dimensional arrays used in PyTorch/TensorFlow.
- **Automatic differentiation**: Reverse-mode AD (core of backpropagation).

### 11. AI/ML Applications
- **Backpropagation**: The backbone of neural network training.
- **Gradient checking**: Verifying backpropagation using Jacobians.
- **Transformers**: Self-attention uses matrix multiplication and gradients.

### 12. Real-World Applications
- **Deep learning frameworks**: PyTorch, TensorFlow implement automatic differentiation using Jacobians.
- **Computer vision**: CNN training uses backpropagation.
- **NLP**: Transformer training uses the chain rule.

### 13. Practice Questions
- Compute the Jacobian of $f(x,y) = (x^2 + y, 2x + y^3)$.
- Compute the gradient of $L = (y - \sigma(wx + b))^2$ with respect to $w$ and $b$.

### 14. Advanced Questions
- Derive the Hessian matrix of a neural network loss function.
- Explain reverse-mode vs forward-mode automatic differentiation.

### 15. Research-Level Extensions
- **Hessian-free optimization**: Uses second-order information.
- **Neural tangent kernels**: Infinite-width neural networks.
- **Differentiable programming**: Extending AD to more complex systems.

---

## 📂 Other DL Math Topics
- [Tensor Algebra](./DL_MATH.md#tensors)
- [Hessian Matrix](./DL_MATH.md#hessian)
- [Optimization Techniques](./DL_MATH.md#optimization)
- [Transformer Mathematics](./DL_MATH.md#transformers)
