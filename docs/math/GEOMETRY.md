# 📏 Geometry & Trigonometry

The study of shapes, sizes, positions, and properties of space.

---

## 🔍 Deep Dive: Distance Formula (Coordinate Geometry)

### 1. Formula
Between points $(x_1, y_1)$ and $(x_2, y_2)$:
$$d = \sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}$$
3D version: $d = \sqrt{(x_2-x_1)^2 + (y_2-y_1)^2 + (z_2-z_1)^2}$

### 2. Derivation
From the **Pythagorean Theorem**:
1. Let $\Delta x = x_2 - x_1$, $\Delta y = y_2 - y_1$
2. The distance is the hypotenuse of a right triangle with legs $\Delta x$ and $\Delta y$.
3. Thus, $d^2 = \Delta x^2 + \Delta y^2$.

### 3. Mathematical Proof
By applying the Pythagorean theorem in Cartesian coordinates. Holds for all real $x_1, y_1, x_2, y_2$.

### 4. Intuition
It's just the straight-line distance between two points on a graph paper.

### 5. Visual Explanation
Two points connected by a diagonal line, with vertical and horizontal lines forming a right triangle.

### 6. Step-by-Step Calculation
1. **Problem**: Distance between $(2, 3)$ and $(5, 7)$
2. Compute $\Delta x = 5-2=3$, $\Delta y=7-3=4$
3. $d = \sqrt{3^2 + 4^2} = \sqrt{9+16} = 5$

### 7. Shortcuts
- Use squared distance (avoid square root for comparisons (faster in code).
- Manhattan distance: $|x_2-x_1| + |y_2-y_1|$.
- Chebyshev distance: $\max(|x_2-x_1|, |y_2-y_1|)$.

### 8. Common Mistakes
- Swapping points (order doesn't matter due to squaring, but don't forget to square the differences.
- Confusing 2D vs 3D formulas.

### 9. Competitive Programming Applications
- **Computational geometry**: Closest pair problem.
- **Graph theory**: Weighted graph edge lengths.
- **Pathfinding**: A* heuristic (Euclidean distance).

### 10. DSA Applications
- **Spatial data structures**: K-D trees, Quadtrees, R-trees.
- **Collision detection**: In games/simulations.

### 11. AI/ML Applications
- **Clustering**: K-Means uses Euclidean distance.
- **Feature engineering**: Distance-based features.
- **Computer vision**: Object tracking.

### 12. Real-World Applications
- **GPS**: Calculating distances on Earth (great circle distance).
- **Aviation**: Flight path planning.
- **Architecture**: Structural design.

### 13. Practice Questions
- Find distance between $(0, 0)$ and $(3, 4)$.
- Find the third vertex of a right triangle given two vertices.

### 14. Advanced Questions
- Prove the **triangle inequality using the distance formula.
- Derive the great circle distance formula for Earth (spherical geometry).

### 15. Research-Level Extensions
- **Riemannian geometry**: Curved spaces.
- **Metric learning**: Learning distance metrics from data (ML).
- **Computational topology**: Persistent homology.

---

## 📂 Other Geometry Topics
- [2D Geometry](./GEOMETRY.md#2d)
- [3D Geometry](./GEOMETRY.md#3d)
- [Trigonometry](./GEOMETRY.md#trig)
- [Mensuration](./GEOMETRY.md#mensuration)
- [Computational Geometry](./GEOMETRY.md#comp-geo)
