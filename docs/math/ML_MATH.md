# 🧠 Machine Learning Mathematics

The mathematical foundation of machine learning—loss functions, gradient descent, information theory.

---

## 🔍 Deep Dive: Entropy & Kullback-Leibler (KL) Divergence

### 1. Formulas
- **Shannon Entropy**: $H(X) = -\sum_{x} P(x) \log_b P(x)$ (or integral for continuous $X$)
- **KL Divergence**: $D_{KL}(P || Q) = \sum_{x} P(x) \log_b \frac{P(x)}{Q(x)}$

### 2. Derivation
Entropy quantifies uncertainty. KL divergence quantifies how different two probability distributions are.

### 3. Mathematical Proof
KL divergence is always non-negative (Gibbs' inequality).

### 4. Intuition
- **Entropy**: The "surprise" of a distribution (more uniform = more entropy).
- **KL Divergence**: The "loss" when approximating $P$ with $Q$.

### 5. Visual Explanation
Two overlapping probability distributions (e.g., two normal distributions). KL divergence is the area of the log-ratio weighted by $P$.

### 6. Step-by-Step Calculation
1. **Problem**: Compute $H(X)$ for $P(X) = [0.5, 0.25, 0.25]$ (b=2)
2. $H(X) = -(0.5 \log_2 0.5 + 0.25 \log_2 0.25 + 0.25 \log_2 0.25)$
3. $H(X) = -(0.5 \times -1 + 0.25 \times -2 + 0.25 \times -2) = -( -0.5 -0.5 -0.5 ) = 1.5$

### 7. Shortcuts
- Use base 2 for bits, base $e$ for nats.
- Cross-entropy: $H(P,Q) = H(P) + D_{KL}(P||Q)$ (used in classification).

### 8. Common Mistakes
- Confusing $D_{KL}(P||Q)$ with $D_{KL}(Q||P)$ (KL divergence is not symmetric).
- Forgetting that entropy is non-negative.

### 9. Competitive Programming Applications
- **Information theory problems**: Code optimization, data compression.
- **Entropy-based partitioning**: Decision trees.

### 10. DSA Applications
- **Huffman Coding**: Uses entropy for optimal compression.
- **Decision trees**: Uses information gain (entropy reduction) for splitting.

### 11. AI/ML Applications
- **Classification**: Cross-entropy loss (softmax regression).
- **Generative models**: VAEs, GANs use KL divergence.
- **Reinforcement learning**: Policy gradients.

### 12. Real-World Applications
- **Data compression**: ZIP, JPEG use entropy encoding.
- **Machine translation**: Attention mechanisms use information theory.
- **Finance**: Risk assessment using entropy.

### 13. Practice Questions
- Compute $H(X)$ for a fair coin.
- Compute $D_{KL}(P||Q)$ for $P=[0.5,0.5]$ and $Q=[0.25,0.75]$.

### 14. Advanced Questions
- Prove Gibbs' inequality.
- Derive cross-entropy loss from maximum likelihood.

### 15. Research-Level Extensions
- **Mutual information**: $I(X,Y) = H(X) - H(X|Y)$ (used in feature selection).
- **Tsallis entropy**: Generalization of Shannon entropy.
- **Information geometry**: Geometric study of probability distributions (used in optimization).

---

## 📂 Other ML Math Topics
- [Cost & Loss Functions](./ML_MATH.md#loss)
- [Gradient Descent (from OPTIMIZATION.md)](../OPTIMIZATION.md)
- [Backpropagation](./ML_MATH.md#backprop)
- [Probability Models](./ML_MATH.md#prob-models)
- [More Information Theory](./ML_MATH.md#info-theory)
