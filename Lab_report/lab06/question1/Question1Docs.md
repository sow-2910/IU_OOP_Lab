# Question 1 — MyPoint3D and MyCuboid

This document explains how the two classes in `Lab_06/src/question1` work: `MyPoint3D.java` and `MyCuboid.java`.

## Overview
- `MyPoint3D` represents a point in 3D integer coordinates (x, y, z). It provides a default constructor, a parameterized constructor, standard getters and setters for each axis, and a `toString()` method that formats the coordinates as `[x, y, z]`.
- `MyCuboid` represents an axis-aligned cuboid (rectangular box) in 3D defined by two opposing corner vertices. Internally it stores two `MyPoint3D` objects named `Vertex1` and `Vertex2` and exposes convenience getters for the min/max of each axis.

## `MyPoint3D` details
- Fields: three `private int` fields: `x`, `y`, and `z`.
- Constructors: a no-argument constructor and a constructor accepting `(int x, int y, int z)` which sets the coordinate values.
- Accessors/mutators: `getX()`, `getY()`, `getZ()` and `setX(int)`, `setY(int)`, `setZ(int)` provide read/write access to each coordinate.
- `toString()`: returns a short human-readable form like `[1, 2, 3]` which is handy for debugging and logging.

## `MyCuboid` details
- Fields: two `private MyPoint3D` fields, `Vertex1` and `Vertex2`, representing opposite corners of the cuboid.
- Constructors:
  - The no-argument constructor leaves the vertices `null` (as written).
  - The two-argument constructor `MyCuboid(MyPoint3D vertex1, MyPoint3D vertex2)` normalizes the input: it computes `xMin`, `yMin`, `zMin` as the minima of the supplied points and `xMax`, `yMax`, `zMax` as the maxima. It then stores `Vertex1 = new MyPoint3D(xMin, yMin, zMin)` and `Vertex2 = new MyPoint3D(xMax, yMax, zMax)`.
  - This normalization guarantees the invariant that `Vertex1` holds the minimum x, y, z and `Vertex2` holds the maximum x, y, z, making other operations (like intersection, containment, volume) straightforward.
- Accessors/mutators: `getVertex1()`, `getVertex2()`, `setVertex1(...)`, `setVertex2(...)`.
- Convenience axis getters: `getXmin()`, `getXmax()`, `getYmin()`, `getYmax()`, `getZmin()`, `getZmax()` return the corresponding integer values from the stored vertices.
- `toString()`: prints the cuboid as `[(x1, y1, z1) ; (x2, y2, z2)]` by delegating to the `toString()` of the `MyPoint3D` instances.

## Example usage
```java
MyPoint3D p1 = new MyPoint3D(2, 3, 1);
MyPoint3D p2 = new MyPoint3D(5, 1, 4);
MyCuboid box = new MyCuboid(p1, p2);
System.out.println(box); // prints something like: [ [2,1,1] ; [5,3,4] ]
int xmin = box.getXmin(); // guaranteed to be the smaller x
int zmax = box.getZmax(); // guaranteed to be the larger z
```

## Design notes and suggestions
- Normalization: The constructor's normalization step (using `Math.min` / `Math.max`) is a good defensive technique to ensure `Vertex1` is always the min-corner and `Vertex2` the max-corner. This simplifies downstream logic (volume calculation, contains tests, intersection tests, etc.).
- Defensive copies: Currently `setVertex1()` and `setVertex2()` assign the passed `MyPoint3D` objects directly. If you want `MyCuboid` to be immune to external mutation, consider making defensive copies (e.g., `this.Vertex1 = new MyPoint3D(vertex1.getX(), vertex1.getY(), vertex1.getZ())`). Likewise, `getVertex1()`/`getVertex2()` could return copies if you want full immutability.
- Null handling: The no-argument constructor leaves `Vertex1`/`Vertex2` null. Consider initializing them to default `MyPoint3D(0,0,0)` or throwing an exception on `setVertex*` if `null` is passed. Also add `Objects.requireNonNull(...)` checks in the two-argument constructor if `null` inputs should be rejected.
- Extra helper methods: Implement `volume()` (product of (xmax-xmin), (ymax-ymin), (zmax-zmin)), `contains(MyPoint3D p)`, `intersects(MyCuboid other)`, `equals()` and `hashCode()` for logical equality, and possibly `translate(dx,dy,dz)`.

## Testing and compilation
- Compile the two files in `Lab_06/src/question1` along with any small test harness. The classes are plain Java POJOs and compile with `javac`:
```bash
javac -d bin Lab_06/src/question1/MyPoint3D.java Lab_06/src/question1/MyCuboid.java
```
- Add small unit tests or a `main` method that constructs a few `MyPoint3D` and `MyCuboid` instances and prints results to verify invariants.

If you want, I can: add `volume()` and `contains()` methods to `MyCuboid`, make the class immutable by returning defensive copies, or write a small JUnit test file that validates the normalization behavior. Which would you like next?