# 🤖 AI & Machine Learning Knowledge Module

From intelligent agents to Large Language Models (LLMs).

## 📌 Core Taxonomy

### 1. Artificial Intelligence (AI)
- **Fundamentals**: Search (BFS, DFS, A*), Knowledge Representation, Planning. (48-100+ Graph/Search algorithms).
- **Reasoning**: Fuzzy Logic, Expert Systems, Bayesian Networks.
- **Agents**: Multi-Agent Systems, Agentic AI, MCP (Model Context Protocol). (2.5M+ Public AI models).

### 2. Machine Learning (ML)
- **Supervised**: Linear/Logistic Regression, SVMs, Decision Trees, Ensembles (XGBoost). (50-100 core algorithms).
- **Unsupervised**: Clustering (K-Means), Dimensionality Reduction (PCA, t-SNE).
- **Reinforcement Learning**: Q-Learning, PPO, Actor-Critic. (30-50 major algorithms).

### 3. Deep Learning (DL)
- **Architectures**: CNN (Vision), RNN/LSTM (Sequences), Transformers (The standard). (79+ major architectures).
- **Mechanisms**: Attention, Self-Attention, Multi-head Attention.
- **Generative AI**: GANs, Diffusion Models, VAEs.

### 4. Modern NLP & LLMs
- **LLMs**: GPT, Llama, BERT. (10,000+ models on Hugging Face).
- **Techniques**: RAG (Retrieval Augmented Generation), Fine-Tuning (LoRA), Quantization.
- **Frameworks**: LangChain, LangGraph, CrewAI.

---

## 🔍 Detailed Node: Transformers (L4 - Expert)

1. **Definition**: A deep learning architecture based on the "Attention" mechanism, designed to handle sequential data without the need for recurrence (RNNs) or convolutions (CNNs).
2. **Intuition**: Imagine reading a sentence where every word can "look" at every other word simultaneously to understand its context, rather than reading one word at a time from left to right.
3. **Theory**: Transformers utilize **Self-Attention** and **Positional Encodings**. The architecture consists of an Encoder (to understand input) and a Decoder (to generate output), though many modern LLMs use Decoder-only or Encoder-only variants.
4. **Mathematical Foundation**: 
   - **Scaled Dot-Product Attention**: $Attention(Q, K, V) = softmax(\frac{QK^T}{\sqrt{d_k}})V$.
   - **Positional Encoding**: $PE_{(pos, 2i)} = \sin(pos / 10000^{2i/d_{model}})$.
5. **Complexity Analysis**:
   - **Time**: $O(L^2 \cdot d)$ per layer (quadratic with sequence length $L$).
   - **Space**: $O(L^2 + L \cdot d)$ (due to the attention matrix).
6. **Advantages**: Parallelizable training (faster than RNNs), handles long-range dependencies better than LSTMs.
7. **Disadvantages**: Quadratic memory complexity with sequence length (limited context window).
8. **Real World Applications**: Google Search, Translation (DeepL), Protein folding (AlphaFold).
9. **Industry Use Cases**: Customer support bots, Content generation, Code completion (GitHub Copilot).
10. **Interview Relevance**: **Critical**. Expected to know multi-head attention, layer normalization, and positional encodings.
11. **Competitive Programming Relevance**: **Low**. Rarely used in standard CP, but relevant for "AI in CP" research.
12. **Research Relevance**: **Maximum**. The foundation of almost all current SOTA models in NLP and Vision (ViT).
13. **Visual Explanation**: 
    `Input -> Positional Encoding -> Multi-Head Attention -> Add & Norm -> Feed Forward -> Add & Norm -> Output`
14. **Pseudocode**:
    ```text
    def self_attention(Q, K, V):
        scores = dot_product(Q, K.T) / sqrt(d_k)
        weights = softmax(scores)
        return dot_product(weights, V)
    ```
15. **Java Implementation**: (Conceptual using ND-Arrays libraries like ND4J)
    ```java
    // Multi-head attention pseudo-code
    INDArray q = ...; INDArray k = ...; INDArray v = ...;
    INDArray scores = q.mmul(k.transpose()).div(Math.sqrt(dk));
    INDArray weights = Transforms.softmax(scores);
    INDArray output = weights.mmul(v);
    ```
16. **Python Implementation**:
    ```python
    import torch
    import torch.nn as nn

    class MultiHeadAttention(nn.Module):
        def __init__(self, d_model, num_heads):
            super().__init__()
            self.mha = nn.MultiheadAttention(d_model, num_heads)
        def forward(self, x):
            return self.mha(x, x, x)
    ```
17. **C++ Implementation**: (Using LibTorch)
    ```cpp
    auto options = torch::nn::MultiheadAttentionOptions(d_model, num_heads);
    torch::nn::MultiheadAttention mha(options);
    auto output = mha->forward(x, x, x);
    ```
18. **Common Mistakes**: Forgetting to scale the dot product by $\sqrt{d_k}$ (leads to vanishing gradients in softmax).
19. **Best Practices**: Use Layer Normalization *before* the attention block (Pre-LN) for more stable training of deep models.
20. **Practice Problems**: [Implement a toy Transformer from scratch in PyTorch](https://github.com/karpathy/minGPT).
21. **Advanced Problems**: Efficient Transformers (Linformer, Reformer, FlashAttention).
22. **Research Papers**: *Vaswani et al., "Attention Is All You Need" (2017)*.
23. **Books**: *Dive into Deep Learning (d2l.ai)*, *Deep Learning (Goodfellow et al.)*.
24. **Learning Resources**: [The Illustrated Transformer (Jay Alammar)](https://jalammar.github.io/illustrated-transformer/).
25. **Related Topics**: [LLMs](#llms), [Vision Transformers (ViT)](#vit), [Attention Mechanisms](#attention-mechanisms).
26. **Prerequisites**: [Linear Algebra](#linear-algebra), [Neural Networks](#neural-networks), [Softmax](#softmax).
27. **Next Topics to Learn**: [BERT](#bert), [GPT Architecture](#gpt), [Diffusion Models](#diffusion-models).

---

## 🔗 Interconnections
- **AI ↔ Mathematics**: Neural networks are just high-dimensional **Linear Algebra** and **Calculus** (Backpropagation).
- **AI ↔ CS**: **Distributed Systems** are required to train and serve massive models.
- **AI ↔ DSA**: **Vector Databases** use **KD-Trees** or **HNSW Graphs** for efficient retrieval.

---

## 🚀 Learning Path
1. **The Math**: Linear Algebra, Calculus, Probability.
2. **The ML**: Scikit-learn, Regression, Classification.
3. **The DL**: PyTorch/TensorFlow, CNNs, RNNs.
4. **The Modern Era**: Transformers, LLMs, RAG.
