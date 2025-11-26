# Question 2 — MyRectangle and overlap checking

This document explains the code in `Lab_06/src/question2`: `MyRectangle.java` and `Lab6Ex2.java`.

## Overview
- `MyRectangle` is a small utility class representing an axis-aligned rectangle in 2D using two `Point2D.Double` points: a normalized bottom-left and top-right corner.
- `Lab6Ex2` contains helper methods to read rectangles from the console, determine overlap between two rectangles, and print the overlap status and area when appropriate.

## `MyRectangle` details
- Fields: two `private Point2D.Double` fields: `bottomLeftPoint` and `topRightPoint`.
- Constructor: `MyRectangle(Point2D.Double pt1, Point2D.Double pt2)` normalizes the provided pair of points. It computes the minima and maxima for X and Y and stores those as `bottomLeftPoint` and `topRightPoint` respectively. This invariant ensures `bottomLeftPoint.x <= topRightPoint.x` and `bottomLeftPoint.y <= topRightPoint.y`.
- Accessors/Mutators: `getBottomLeftPoint()`, `getTopRightPoint()`, `setBottomLeftPoint(...)`, `setTopRightPoint(...)` allow reading or replacing the stored points. The convenience getters `getXmin()`, `getYmin()`, `getXmax()`, `getYmax()` return the respective coordinate values directly.
- `toString()`: delegates to the points' `toString()` implementations and prints the two corner points for easy debugging.

## `Lab6Ex2` details
- Purpose: read two rectangles from standard input and determine whether they overlap, touch, or are disjoint. If they overlap, the program computes and prints the area of the overlapping region.

- Input helpers:
  - `readPoint2Double(Scanner sc)`: reads two `double` values from the scanner (x then y) and returns a `Point2D.Double`.
  - `readRectangle(Scanner sc)`: reads two points (four doubles) and returns a `MyRectangle` created from those points.

- Overlap logic (`overlapCheck(MyRectangle rec1, MyRectangle rec2)`):
  1. Compute the intersection candidate: `xMin = max(rec1.xmin, rec2.xmin)`, `yMin = max(rec1.ymin, rec2.ymin)`, `xMax = min(rec1.xmax, rec2.xmax)`, `yMax = min(rec1.ymax, rec2.ymax)`.
  2. If `xMin < xMax && yMin < yMax` then the rectangles have a positive-area intersection. The code computes `deltaX = xMax - xMin`, `deltaY = yMax - yMin` and prints the overlapping area `deltaX * deltaY`.
  3. Otherwise the rectangles do not overlap with positive area. The code then checks whether they are disjoint by evaluating four comparisons. If not disjoint, it reports that they touch.

- Notes on the disjoint test: the boolean expression uses comparisons of `getXmax()/getXmin()` and `getYmax()/getYmin()` to decide if the rectangles are separated on at least one axis. The current implementation is a simple check but can be simplified or clarified for readability (see suggestions below).

- `main(String[] args)`: constructs a `Scanner(System.in)`, prompts the user for two rectangles (each rectangle requires two points, each point consists of `x y` on the same line or separated by whitespace), prints the rectangle representations, runs `overlapCheck(...)`, and closes the scanner.

## Example interaction
```
Enter first rectangle
0 0  5 4
Enter second rectangle
3 2  8 6
[0.0, 0.0][5.0, 4.0]
[3.0, 2.0][8.0, 6.0]
The two rectangle overlap
The area of the 2 rectangle is: 6.0
```
(First rectangle is bottom-left `(0,0)` to top-right `(5,4)`. Second rectangle overlaps from x = 3..5 and y = 2..4 giving width 2 and height 3 → area 6.)

## Design notes and suggested improvements
- Input validation: The `readPoint2Double` method expects valid doubles; the `main` method does not currently guard against malformed input or EOF. Consider adding try/catch around `nextDouble()` and re-prompting when parsing fails.
- Clarify disjoint logic: The `isDisjoint` boolean expression currently mixes `<` checks in a way that can be confusing. A clearer test is:
  - disjoint if `(rec1.xmax < rec2.xmin) || (rec2.xmax < rec1.xmin) || (rec1.ymax < rec2.ymin) || (rec2.ymax < rec1.ymin)`
  This directly checks whether one rectangle lies completely to the left/right/above/below the other.
- Touch vs overlap: The current code reports "touch" when rectangles are neither overlapping nor disjoint. This will include edge-touching and corner-touching. If you want to distinguish edge-touch from corner-touch, add additional checks (e.g., check whether both xMin == xMax or yMin == yMax for edge/corner cases).
- Return values and API: Consider converting `overlapCheck` to return an enum (e.g., `DISJOINT`, `TOUCHING`, `OVERLAP`) and optionally the intersection area, instead of printing directly. This makes the logic reusable and testable.
- Unit tests: Add small unit tests that exercise overlapping, touching, and disjoint cases with known results.

## Compile and run
From the repository root, compile the package and run the main program:
```bash
javac -d bin Lab_06/src/question2/*.java
java -cp bin question2.Lab6Ex2
```
Then type the coordinates on the console as prompted (four doubles per rectangle: x1 y1 x2 y2).

## Next steps I can help with
- Add robust input validation and re-prompting logic.
- Replace console input with a small GUI dialog to enter rectangle coordinates.
- Implement unit tests (JUnit) for the `overlapCheck` logic.

Which of these would you like me to do next?