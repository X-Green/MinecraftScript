package dev.eeasee.minecraft_script.utils;

public class Pair<A, B> {
    public final A left;
    public final B right;

    public Pair(A left, B right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Left: " + left.toString() + "; Right: " + right.toString() + ";";
    }
}
