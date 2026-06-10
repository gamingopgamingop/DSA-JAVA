# 🔢 Number Theory

The study of integers and integer-valued functions—primes, divisibility, modular arithmetic.

---

## 🔍 Deep Dive: Modular Arithmetic

### 1. Key Formulas
- **Congruence**: $a \equiv b \pmod{m}$ means $m$ divides $a-b$.
- **Addition**: $(a + b) \mod m = [(a \mod m) + (b \mod m)] \mod m$
- **Multiplication**: $(a \times b) \mod m = [(a \mod m) \times (b \mod m)] \mod m$
- **Modular Inverse**: $a \times a^{-1} \equiv 1 \pmod{m}$ (exists iff gcd(a,m)=1).

### 2. Derivation
Modular arithmetic is arithmetic "clock arithmetic" where numbers wrap around modulo $m$.

### 3. Mathematical Proof
Using basic divisibility properties.

### 4. Intuition
Think of a clock (mod 12): 10 + 4 = 14 ≡ 2 mod 12.

### 5. Visual Explanation
A clock face where numbers wrap around from 12 back to 1.

### 6. Step-by-Step Calculation
1. **Problem**: Compute $(7 \times 9) \mod 5$
2. $7 \mod 5 = 2$, $9 \mod 5 = 4$
3. $(2 \times 4) \mod 5 = 8 \mod 5 = 3$

### 7. Shortcuts
- **Fermat's Little Theorem**: If $p$ is prime, $a^{p-1} \equiv 1 \pmod{p}$.
- **Euler's Theorem**: Generalization: $a^{\phi(m)} \equiv 1 \pmod{m}$ (gcd(a,m)=1).
- **Modular Exponentiation**: Fast exponentiation using binary exponentiation.

### 8. Common Mistakes
- Forgetting that the inverse only exists when a and m are coprime.
- Overflow when multiplying large numbers (use modular exponentiation).

### 9. Competitive Programming Applications
- **Hashing**: String hashing (Rabin-Karp).
- **Number theory problems**: Divisibility, primes, Chinese Remainder Theorem.

### 10. DSA Applications
- **Hash tables**: Hash functions.
- **Bloom filters**: False positive calculations.
- **Public-key cryptography**: RSA, Elliptic Curves.

### 11. AI/ML Applications
- **Cryptography for AI**: Secure AI models (encrypted inference).
- **Hashing for data**: Efficient data storage/retrieval.

### 12. Real-World Applications
- **Cryptography**: RSA, AES, SSL/TLS.
- **Error correction**: Hamming codes.
- **Clocks/Calendars**: Calculating dates/times.

### 13. Practice Questions
- Find $1234 \times 5678 \mod 1000$.
- Find the inverse of 7 mod 11.

### 14. Advanced Questions
- Implement the **Chinese Remainder Theorem (CRT)**.
- Prove Fermat's Little Theorem.

### 15. Research-Level Extensions
- **Post-quantum cryptography**: Lattice-based cryptography (uses number theory).
- **Analytic number theory**: Prime distribution, Riemann hypothesis.
- **Elliptic curve cryptography**: Used in modern security (Bitcoin).

---

## 📂 Other Number Theory Topics
- [Prime Numbers](./NUMBER_THEORY.md#primes)
- [GCD & LCM](./NUMBER_THEORY.md#gcd)
- [Chinese Remainder Theorem](./NUMBER_THEORY.md#crt)
- [Euler's Totient Function](./NUMBER_THEORY.md#totient)
- [Advanced Number Theory](./NUMBER_THEORY.md#advanced)
