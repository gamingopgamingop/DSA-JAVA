# 🗺️ Ultimate Computer Science & AI Roadmap

This document outlines the hierarchical progression from an absolute beginner to a world-class researcher. The system is divided into five proficiency levels, with strict dependency ordering.

## 📈 Proficiency Levels

| Level | Description | Focus |
| :--- | :--- | :--- |
| **L1: Beginner** | The Building Blocks | Syntax, Basic Logic, Arithmetic, Linear DS |
| **L2: Intermediate** | Algorithmic Thinking | Complexity, Recursion, Standard Algorithms, OOP |
| **L3: Advanced** | System & Pattern Mastery | DP, Graphs, System Design, ML Foundations |
| **L4: Expert** | Optimization & Scale | Distributed Systems, Deep Learning, OS Internals |
| **L5: Research** | Pushing the Frontier | SOTA Architectures, Quantum, Formal Proofs, Novel DS |

---

## ⛓️ Global Dependency Graph

```mermaid
graph TD
    %% Level 1: Beginner
    MATH1[Math: Algebra & Logic] --> DSA1[DSA: Arrays & Strings]
    DSA1 --> CP1[CP: Basic Patterns]
    CS1[CS: Basic Hardware/OS] --> DEV1[Dev: Simple Scripting]

    %% Level 2: Intermediate
    MATH1 --> MATH2[Math: Discrete & Calculus]
    DSA1 --> DSA2[DSA: Linked Lists, Stacks, Queues]
    DSA2 --> ALG1[Alg: Sorting & Searching]
    ALG1 --> CP2[CP: Two Pointers/Sliding Window]
    CS1 --> CS2[CS: Memory & Processes]

    %% Level 3: Advanced
    MATH2 --> ML1[ML: Supervised Learning]
    DSA2 --> DSA3[DSA: Trees & Graphs]
    ALG1 --> ALG2[Alg: DP & Greedy]
    DSA3 --> SYS1[System Design: Scalability]
    CS2 --> CS3[CS: Networking & Security]

    %% Level 4: Expert
    ML1 --> DL1[DL: Neural Networks]
    DL1 --> AI1[AI: Agents & Planning]
    DSA3 --> DSA4[DSA: Advanced Trees & Strings]
    SYS1 --> DIST1[Distributed Systems]
    CS3 --> CYBER1[Cybersecurity: Cryptography]

    %% Level 5: Research
    DL1 --> GENAI[Generative AI & LLMs]
    AI1 --> ROBOTICS[Robotics & RL]
    DIST1 --> HPC[High Performance Computing]
    CYBER1 --> QUANTUM[Quantum Cryptography]
    DSA4 --> RDS[Research-Level Data Structures]
```

---

## 🚦 Phase 1: Foundations (L1 - L2)
1. **Mathematics**: [Arithmetic, Basic Algebra, Set Theory]
2. **Programming**: [Syntax, Variables, Control Flow, Functions]
3. **Data Structures**: [Arrays, Strings, Matrices]
4. **Algorithms**: [Linear Search, Bubble Sort, Selection Sort]

## 🚦 Phase 2: Mastery (L3)
1. **Data Structures**: [Linked Lists, Stacks, Queues, Binary Trees, Heaps]
2. **Algorithms**: [Binary Search, Quick Sort, Merge Sort, Recursion]
3. **Computer Science**: [OS Basics, DBMS Foundations, Networking Models]

## 🚦 Phase 3: Specialization (L4)
1. **AI/ML**: [Regression, SVM, CNN, RNN, Reinforcement Learning]
2. **Systems**: [Microservices, Load Balancing, Consistency Algorithms]
3. **Advanced DSA**: [Segment Trees, Fenwick Trees, Suffix Arrays, Graphs]

## 🚦 Phase 4: Frontier (L5)
1. **Modern AI**: [Transformers, Diffusion Models, AI Agents, RAG]
2. **Advanced Systems**: [Parallel Computing, Consensus (Raft/Paxos), Kernel Dev]
3. **Research**: [Quantum Computing, Computational Complexity, Bio-Computing]

---

## 🔗 Navigation
- [Detailed DSA Module](./dsa/MASTER.md)
- [Detailed AI/ML Module](./ai_ml/MASTER.md)
- [Detailed Systems Module](./cs/MASTER.md)
- [Detailed Mathematics Module](./math/MASTER.md)
