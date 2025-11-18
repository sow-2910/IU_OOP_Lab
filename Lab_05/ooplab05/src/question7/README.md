# Question 7: Random Shapes

## Overview
This program draws **10 random filled shapes** in random colors, positions, and sizes on a Java Swing panel.

## What It Does
- Draws 10 iterations, each creating:
  - A **random filled shape** (either a rectangle or an oval)
  - A **random color** (RGB values 0-255 for each channel)
  - A **random position** within the panel bounds
  - A **random size** (width and height limited to half the panel dimensions)

## Visual Output
The result is a composition of randomly placed and colored geometric shapes, as shown in the screenshot:
- Multiple rectangles in various colors (green, blue, teal, etc.)
- Multiple ovals in various colors (yellow, cyan, green, etc.)
- All shapes fit within the panel window
- No overlaps are guaranteed to be avoided (shapes can overlap)

## Technical Implementation

### Key Classes
- **RandomShapesPanel**: A JPanel subclass that overrides `paintComponent()` to draw the random shapes
- **Main**: A simple JFrame launcher

### Algorithm
```
for each of 10 shapes:
    1. Generate random RGB color
    2. Generate random width (1 to w/2) and height (1 to h/2)
    3. Generate random x position (0 to w - width)
    4. Generate random y position (0 to h - height)
    5. Randomly choose: rectangle or oval
    6. Draw filled shape with chosen color
```

### Code Snippet
```java
for (int i = 0; i < NUM_SHAPES; i++) {
    Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    g2.setColor(color);
    
    int width = random.nextInt(w / 2) + 1;
    int height = random.nextInt(h / 2) + 1;
    int x = random.nextInt(w - width);
    int y = random.nextInt(h - height);
    
    if (random.nextBoolean()) {
        g2.fillRect(x, y, width, height);
    } else {
        g2.fillOval(x, y, width, height);
    }
}
```

## How to Run
```bash
java -cp /media/phat/DATA/Java_IU/Lab_05/ooplab05/bin question7.Main
```

## Features
- ✅ 10 random shapes per render
- ✅ Random colors (full RGB spectrum)
- ✅ Random positions (within bounds)
- ✅ Random sizes (limited to half width/height)
- ✅ Mix of rectangles and ovals
- ✅ Anti-aliased rendering for smooth edges
- ✅ Shapes stay completely within panel bounds

## Each Run is Different
Since the shapes are randomly generated, each time you run the program or resize the window, you'll see a completely different arrangement of colors, positions, and shapes.
