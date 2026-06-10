# 📈 Optimization Mathematics

The study of finding the best solution from all feasible solutions.

---

## 🔍 Deep Dive: Gradient Descent

### 1. Formula
The update rule for a parameter $\theta$:
$$\theta_{next} = \theta_{current} - \eta \cdot \nabla_{\theta} J(\theta)$$
Where:
- $\eta$ is the learning rate.
- $\nabla_{\theta} J(\theta)$ is the gradient of the cost function $J$ with respect to $\theta$.

### 2. Derivation
Consider the Taylor expansion of $J(\theta)$ around $\theta$:
$$J(\theta + \Delta \theta) \approx J(\theta) + \nabla J(\theta)^T \Delta \theta$$
To minimize $J$, we want $J(\theta + \Delta \theta) < J(\theta)$. This happens when $\nabla J(\theta)^T \Delta \theta$ is as negative as possible. The direction that minimizes this dot product is the opposite of the gradient: $\Delta \theta = -\eta \nabla J(\theta)$.

### 3. Mathematical Proof
For a convex function $J$, if $\eta$ is sufficiently small (specifically $\eta < 2/L$ where $L$ is the Lipschitz constant of the gradient), the sequence $J(\theta_k)$ is non-increasing and converges to the global minimum.

### 4. Intuition
Imagine you are standing on a foggy mountain (the cost function surface) and want to reach the lowest valley. Since you can't see far, you feel the slope of the ground under your feet and take a step in the steepest downward direction.

### 5. Visual Explanation
A 3D bowl-shaped surface where a ball starts at the rim and rolls down, following the path of steepest descent until it reaches the bottom.

### 6. Step-by-Step Calculation
1. **Function**: $f(x) = x^2$. Target: Find $x$ that minimizes $f(x)$.
2. **Gradient**: $f'(x) = 2x$.
3. **Initialization**: $x_0 = 5$, $\eta = 0.1$.
4. **Step 1**: $x_1 = 5 - 0.1(2 \times 5) = 5 - 1 = 4$.
5. **Step 2**: $x_2 = 4 - 0.1(2 \times 4) = 4 - 0.8 = 3.2$.
6. **Result**: $x$ gradually approaches $0$.

### 7. Shortcuts
- **Momentum**: $\Delta \theta_t = \gamma \Delta \theta_{t-1} + \eta \nabla J(\theta)$. Accelerates descent in the right direction.
- **RMSProp/Adam**: Adaptive learning rates that handle different scales of features automatically.

### 8. Common Mistakes
- **Learning rate too high**: Overshooting the minimum (divergence).
- **Learning rate too low**: Extremely slow convergence.
- **Not normalizing data**: Leads to "elongated" cost surfaces where gradients are inefficient.

### 9. Competitive Programming Applications
- Finding optimal parameters in geometry problems.
- Curve fitting for sequence prediction.

### 10. DSA Applications
- Used in training **Neural Networks** (which are essentially complex data structures).
- Adaptive load balancing in distributed systems.

### 11. AI/ML Applications
- **The Core Engine**: Every model from Linear Regression to GPT-4 is trained using a variant of Gradient Descent.

### 12. Real-World Applications
- **Logistics**: Route optimization.
- **Finance**: Portfolio optimization.
- **Engineering**: Structural stress minimization.

### 13. Practice Questions
- Perform 3 steps of GD for $f(x, y) = x^2 + y^2$ starting at $(1, 1)$ with $\eta=0.1$.
- What happens to GD if the function is $f(x) = |x|$?

### 14. Advanced Questions
- Prove the convergence rate of Gradient Descent for $L$-smooth, strongly convex functions.
- Explain the "Vanishing Gradient" problem in deep networks.

### 15. Research-Level Extensions
- **Second-Order Methods**: Newton's Method and Quasi-Newton (L-BFGS).
- **Stochastic Gradient MCMC**: Combining optimization with Bayesian sampling.
- **Natural Gradient**: Using the Fisher Information Matrix to account for the curvature of the probability space.

---

## 📂 Other Optimization Topics
- [Linear Programming](./OPTIMIZATION.md#linear-programming)
- [Convex Optimization](./OPTIMIZATION.md#convex)
- [Stochastic Optimization](./OPTIMIZATION.md#stochastic)
