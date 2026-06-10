# 📊 Discrete Mathematics

The study of mathematical structures that are discrete (not continuous)—sets, logic, graphs, combinatorics.

---

## 🔍 Deep Dive: Combinations & Permutations

### 1. Formulas
- **Permutations (order matters)**: $P(n, k) = \frac{n!}{(n-k)!}$
- **Combinations (order doesn't matter)**: $C(n, k) = \binom{n}{k} = \frac{n!}{k!(n-k)!}$

### 2. Derivation
- **Permutations**: For first position, $n$ choices; second, $n-1$; ...; k-th, $n-k+1$. Multiply them.
- **Combinations**: For each combination, there are $k!$ permutations of the same elements. Divide permutations by $k!$.

### 3. Mathematical Proof
By induction on $k$ for permutations, then derive combinations from permutations.

### 4. Intuition
- Permutations: Arranging people in a line (order matters).
- Combinations: Choosing a team from a group (order doesn't matter).

### 5. Visual Explanation
- Permutations: 3 people in a line: 3×2×1 = 6.
- Combinations: Choose 2 from 3: 3 (AB, AC, BC).

### 6. Step-by-Step Calculation
1. **Problem**: Choose 3 books from 5 (order doesn't matter).
2. $n=5, k=3$
3. $C(5,3) = \frac{5!}{3!2!} = \frac{120}{6×2} = 10$

### 7. Shortcuts
- **Pascal's Triangle**: For quick combination calculations.
- $C(n, k) = C(n, n-k)$ (symmetry).

### 8. Common Mistakes
- Confusing permutations with combinations.
- Forgetting that $0! = 1$.

### 9. Competitive Programming Applications
- **Counting problems**: Number of paths, subsets, sequences.
- **Dynamic programming**: Binomial coefficients as base cases.

### 10. DSA Applications
- **Probability**: Bloom filter false positive rate.
- **Hashing**: Collision probability.
- **Graphs**: Number of edges in a complete graph: $C(n, 2)$.

### 11. AI/ML Applications
- **Feature selection**: Number of ways to choose $k$ features from $n$.
- **Probability**: Bayesian networks, combinatorial optimization.

### 12. Real-World Applications
- **Lottery**: Number of possible combinations.
- **Genetics**: DNA sequence combinations.
- **Business**: Choosing products for a bundle.

### 13. Practice Questions
- How many permutations of "CAT" are there?
- How many ways to choose 4 players from 10?

### 14. Advanced Questions
- Prove the binomial theorem using combinations.
- Solve combinations modulo a prime (Lucas theorem).

### 15. Research-Level Extensions
- **Combinatorics on words**: String algorithms.
- **Algebraic combinatorics**: Links to group theory.
- **Extremal combinatorics**: Used in CS (e.g., Ramsey theory).

---

## 📂 Other Discrete Math Topics
- [Logic & Propositions](./DISCRETE_MATH.md#logic)
- [Set Theory](./DISCRETE_MATH.md#sets)
- [Relations & Functions](./DISCRETE_MATH.md#relations)
- [Recurrence Relations](./DISCRETE_MATH.md#recurrence)
- [Graph Theory](./DISCRETE_MATH.md#graphs)
