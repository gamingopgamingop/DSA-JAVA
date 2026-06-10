# 🔢 Linear Algebra

The study of vectors, matrices, and linear transformations.

---

## 🔍 Deep Dive: Singular Value Decomposition (SVD)

### 1. Formula
Any $m \times n$ matrix $A$ can be factored as:
$$A = U \Sigma V^T$$
Where:
- $U$: $m \times m$ orthogonal matrix (Left singular vectors).
- $\Sigma$: $m \times n$ diagonal matrix (Singular values).
- $V^T$: $n \times n$ orthogonal matrix (Right singular vectors).

### 2. Derivation
SVD is derived from the eigendecomposition of symmetric matrices. Specifically, $U$ is the set of eigenvectors of $AA^T$, and $V$ is the set of eigenvectors of $A^TA$. The singular values in $\Sigma$ are the square roots of the non-zero eigenvalues of $A^TA$.

### 3. Mathematical Proof
Based on the **Spectral Theorem**, every symmetric matrix can be diagonalized. Since $A^TA$ is always symmetric and positive semi-definite, its eigenvalues are $\ge 0$. The existence of SVD follows from constructing $U$, $\Sigma$, and $V$ using these properties.

### 4. Intuition
SVD breaks down any linear transformation into three steps:
1. **Rotation** (in the input space by $V^T$).
2. **Scaling** (along the axes by $\Sigma$).
3. **Rotation** (in the output space by $U$).
It identifies the "most important" directions in the data.

### 5. Visual Explanation
Imagine a sphere being transformed into an ellipsoid. $V$ defines the original axes, $\Sigma$ defines the lengths of the new axes, and $U$ defines the orientation of the ellipsoid.

### 6. Step-by-Step Calculation
1. **Matrix**: $A = \begin{bmatrix} 3 & 2 & 2 \\ 2 & 3 & -2 \end{bmatrix}$.
2. **Compute $A^TA$**: $\begin{bmatrix} 13 & 12 & 2 \\ 12 & 13 & -2 \\ 2 & -2 & 8 \end{bmatrix}$.
3. **Find Eigenvalues of $A^TA$**: $\lambda_1 = 25, \lambda_2 = 9, \lambda_3 = 0$.
4. **Singular Values**: $\sigma_1 = 5, \sigma_2 = 3, \sigma_3 = 0$.
5. **Compute $V$**: Normalized eigenvectors of $A^TA$.
6. **Compute $U$**: Using $u_i = \frac{1}{\sigma_i} Av_i$.

### 7. Shortcuts
- **Truncated SVD**: Only keep the top $k$ singular values to approximate $A$.
- **Relation to PCA**: PCA is simply SVD applied to the mean-centered data matrix.

### 8. Common Mistakes
- **Incorrect Dimensions**: Forgetting that $\Sigma$ must match the dimensions of $A$.
- **Sign Ambiguity**: Eigenvectors (and thus singular vectors) are only unique up to a sign $(\pm 1)$.

### 9. Competitive Programming Applications
- Solving overdetermined systems of linear equations.
- Finding the rank of a matrix numerically.

### 10. DSA Applications
- Used in **Latent Semantic Analysis (LSA)** for text mining.
- Efficient matrix inversion (via Moore-Penrose Pseudoinverse).

### 11. AI/ML Applications
- **Dimensionality Reduction**: Principal Component Analysis (PCA).
- **Recommender Systems**: Collaborative filtering (Netflix Prize).
- **Image Compression**: Storing only the most significant singular values.

### 12. Real-World Applications
- **Signal Processing**: Noise reduction.
- **Geology**: Analyzing seismic data.
- **Genetics**: Identifying patterns in gene expression.

### 13. Practice Questions
- Given $A = \begin{bmatrix} 1 & 1 \\ 0 & 1 \end{bmatrix}$, find its SVD.
- Prove that the rank of $A$ equals the number of non-zero singular values.

### 14. Advanced Questions
- Explain the **Eckart-Young-Mirsky Theorem** (SVD provides the best low-rank approximation).
- How does SVD relate to the **Condition Number** of a matrix?

### 15. Research-Level Extensions
- **Randomized SVD**: For massive datasets that don't fit in memory.
- **Tensor SVD (T-SVD)**: Generalizing SVD to higher-dimensional arrays.
- **Sparse SVD**: Optimization for matrices with many zeros.
