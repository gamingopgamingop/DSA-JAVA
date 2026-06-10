# 📊 Probability & Statistics

The science of uncertainty and data analysis.

---

## 🔍 Deep Dive: Bayes' Theorem

### 1. Formula
$$P(A|B) = \frac{P(B|A) \cdot P(A)}{P(B)}$$
Where:
- $P(A|B)$: **Posterior** probability (Probability of hypothesis $A$ given evidence $B$).
- $P(B|A)$: **Likelihood** (Probability of evidence $B$ given hypothesis $A$).
- $P(A)$: **Prior** probability (Initial probability of hypothesis $A$).
- $P(B)$: **Evidence** (Total probability of evidence $B$ occurring).

### 2. Derivation
From the definition of conditional probability:
1. $P(A \cap B) = P(A|B)P(B)$
2. $P(A \cap B) = P(B|A)P(A)$
Equating the two:
$P(A|B)P(B) = P(B|A)P(A)$
Dividing by $P(B)$ yields the theorem.

### 3. Mathematical Proof
Bayes' Theorem is a direct consequence of the axioms of probability (specifically the product rule). For a partition of the sample space $A_1, A_2, \dots, A_n$, the denominator can be expanded using the **Law of Total Probability**:
$$P(B) = \sum_{i} P(B|A_i)P(A_i)$$

### 4. Intuition
It is the mathematical way of **updating your beliefs** as you encounter new evidence. You start with a "Prior" belief and adjust it based on how likely the "Evidence" is under your hypothesis.

### 5. Visual Explanation
Think of two overlapping circles (Sets $A$ and $B$). Bayes' Theorem calculates what fraction of circle $B$ is occupied by the overlap with $A$.

### 6. Step-by-Step Calculation
1. **Problem**: A test for a disease is 99% accurate ($P(B|A)$). The disease affects 1% of the population ($P(A)$). If you test positive ($B$), what is the probability you have the disease ($P(A|B)$)?
2. **Prior**: $P(A) = 0.01$, $P(\text{not } A) = 0.99$.
3. **Likelihood**: $P(B|A) = 0.99$, $P(B|\text{not } A) = 0.01$ (false positive).
4. **Total Evidence**: $P(B) = (0.99 \times 0.01) + (0.01 \times 0.99) = 0.0198$.
5. **Posterior**: $P(A|B) = (0.99 \times 0.01) / 0.0198 = 0.5$.
6. **Result**: Even with a 99% accurate test, there is only a 50% chance you have the disease due to the low prior.

### 7. Shortcuts
- **Odds Form**: $\text{Posterior Odds} = \text{Prior Odds} \times \text{Bayes Factor}$.
- **Likelihood Ratio**: Useful for medical diagnosis and forensic evidence.

### 8. Common Mistakes
- **Base Rate Fallacy**: Ignoring the prior probability ($P(A)$) and focusing only on the likelihood.
- **Confusion of the Inverse**: Assuming $P(A|B) = P(B|A)$.

### 9. Competitive Programming Applications
- Probability-based DP problems.
- Expected value calculations in randomized algorithms.

### 10. DSA Applications
- **Bloom Filters**: Calculating the probability of false positives.
- **Hashing**: Analyzing collision probabilities.

### 11. AI/ML Applications
- **Naive Bayes Classifier**: Foundation of spam filtering and sentiment analysis.
- **Bayesian Networks**: Modeling complex causal relationships.
- **Bayesian Optimization**: Used for hyperparameter tuning.

### 12. Real-World Applications
- **Spam Filtering**: Is this email spam ($A$) given it contains "Free Money" ($B$)?
- **Medical Diagnosis**: Interpreting test results.
- **Legal Systems**: Evaluating the strength of DNA evidence.

### 13. Practice Questions
- A bag has 2 fair coins and 1 double-headed coin. You pick one and flip heads. What is the probability it's the double-headed coin?
- Explain the **Monty Hall Problem** using Bayes' Theorem.

### 14. Advanced Questions
- Derive the **Bayesian Information Criterion (BIC)**.
- Explain the relationship between Bayes' Theorem and **Maximum A Posteriori (MAP)** estimation.

### 15. Research-Level Extensions
- **Variational Inference**: Approximating complex posterior distributions in deep learning.
- **Bayesian Non-parametrics**: Models that grow with the amount of data.
- **Causal Inference**: Distinguishing between correlation and causation using Bayesian frameworks.
