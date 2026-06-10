# 🔐 Cryptography Mathematics

The math behind secure communication—modular exponentiation, prime factorization, elliptic curves.

---

## 🔍 Deep Dive: RSA Mathematics

### 1. Key Formulas
- **Key Generation**:
  1. Choose two large primes $p$ and $q$.
  2. Compute $n = p \times q$.
  3. Compute Euler's totient function: $\phi(n) = (p-1)(q-1)$.
  4. Choose $e$ such that $1 < e < \phi(n)$ and $\gcd(e, \phi(n)) = 1$.
  5. Compute $d$ such that $e \times d \equiv 1 \pmod{\phi(n)}$.
- **Encryption**: $c = m^e \mod n$
- **Decryption**: $m = c^d \mod n$

### 2. Derivation
Based on Euler's theorem: $m^{\phi(n)} \equiv 1 \pmod{n}$ if $\gcd(m,n)=1$. Thus, $m^{ed} = m^{k\phi(n)+1} \equiv m \pmod{n}$.

### 3. Mathematical Proof
Using Euler's theorem and modular arithmetic.

### 4. Intuition
RSA is secure because it's hard to factor $n$ into $p$ and $q$ (integer factorization problem).

### 5. Visual Explanation
Two keys (public and private). Public key locks the message, only private key can unlock it.

### 6. Step-by-Step Calculation
1. **Key Gen**:
   - $p=3$, $q=11$ → $n=33$, $\phi(n)=20$
   - $e=3$ (coprime with 20)
   - $d=7$ (3*7=21 ≡1 mod 20)
2. **Encrypt**: $m=4$ → $c=4^3 mod 33 = 64 mod 33 = 31$
3. **Decrypt**: $31^7 mod 33 = 4$

### 7. Shortcuts
- **Modular Exponentiation**: Fast exponentiation (binary exponentiation) for large exponents.
- **Euler's Totient Function**: $\phi(pq) = (p-1)(q-1)$ for primes $p,q$.

### 8. Common Mistakes
- Using small primes (easy to factor).
- Not checking that $e$ and $\phi(n)$ are coprime.

### 9. Competitive Programming Applications
- **Modular exponentiation**: Common CP problem.
- **Prime factorization**: Pollard's Rho algorithm.

### 10. DSA Applications
- **Hash functions**: SHA-256 used in blockchain.
- **Public-key infrastructure**: Digital signatures.

### 11. AI/ML Applications
- **Secure AI**: Homomorphic encryption (related to RSA).
- **Privacy-preserving ML**: Encrypted model inference.

### 12. Real-World Applications
- **HTTPS/SSL**: RSA used in key exchange.
- **Blockchain**: Bitcoin uses ECC (related to number theory).
- **Digital signatures**: RSA signatures.

### 13. Practice Questions
- Implement RSA with $p=5$, $q=7$.
- Encrypt $m=6$ with public key $(e=5, n=35)$.

### 14. Advanced Questions
- Prove Euler's theorem.
- Explain Pollard's Rho algorithm for factorization.

### 15. Research-Level Extensions
- **Post-quantum cryptography**: Lattice-based, code-based cryptography (quantum computers can break RSA).
- **Elliptic Curve Cryptography (ECC)**: More secure than RSA for same key size.
- **Homomorphic encryption**: Computation on encrypted data.

---

## 📂 Other Cryptography Math Topics
- [Modular Exponentiation](./CRYPTOGRAPHY_MATH.md#mod-exp)
- [Prime Factorization](./CRYPTOGRAPHY_MATH.md#factorization)
- [Elliptic Curves](./CRYPTOGRAPHY_MATH.md#elliptic)
- [Hash Functions](./CRYPTOGRAPHY_MATH.md#hashes)
