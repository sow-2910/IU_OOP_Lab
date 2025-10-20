package question3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

enum Direction {
    N(0, -1),
    NE(1, -1),
    E(1, 0),
    SE(1, 1),
    S(0, 1),
    SW(-1, 1),
    W(-1, 0),
    NW(-1, -1);

    public final int dx;
    public final int dy;

    Direction(int x, int y) {
        this.dx = x;
        this.dy = y;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

}

class Particle {
    private int x;
    private int y;
    private static final Random random = new Random();

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int maxWidth, int maxHeight) {
        Direction[] directions = Direction.values();
        Direction direction = directions[random.nextInt(directions.length)];

        int NX = x + direction.getDx();
        int NY = y + direction.getDy();

        if (NX > 0 && NX < maxWidth) {
            x = NX;
        }
        if (NY > 0 && NY < maxHeight) {
            y = NY;
        }
    }

    public boolean collidesWith(Particle other) {
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public String toString() {
        return "Particle at (" + x + ", " + y + ")";
    }

}

class Box {
    private static Box instance = null;
    private final int width;
    private final int height;
    private ArrayList<Particle> particles;
    private static final Random random = new Random();

    private Box(int width, int height) {
        this.width = width;
        this.height = height;
        this.particles = new ArrayList<>();
    }

    public static Box getInstance(int width, int height) {
        if (instance == null) {
            instance = new Box(width, height);
        }
        return instance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getParticleCount() {
        return particles.size();
    }

    public void addRandomParticle() {
        int x = random.nextInt(width + 1);
        int y = random.nextInt(height + 1);
        particles.add(new Particle(x, y));
    }

    public void initializeParticles(int count) {
        particles.clear();
        for (int i = 0; i < count; i++) {
            addRandomParticle();
        }
    }

    public void step() {
        for (Particle particle : particles) {
            particle.move(width, height);
        }
        ArrayList<Particle> newParticles = new ArrayList<>();
        for (int i = 0; i < particles.size(); i++) {
            for (int j = i + 1; j < particles.size(); j++) {
                if (particles.get(i).collidesWith(particles.get(j))) {
                    int x = random.nextInt(width + 1);
                    int y = random.nextInt(height + 1);
                    newParticles.add(new Particle(x, y));
                }
            }
        }
        particles.addAll(newParticles);
    }
}

public class Simulation {
    public static void main(String[] args) {
        System.out.println("test");

    }
}
