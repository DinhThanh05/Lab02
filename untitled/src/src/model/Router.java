package model;

import java.util.ArrayList;
import java.util.List;

public class Router {
    private String name;
    private double x, y;  // Tọa độ x, y
    private List<Link> links;

    public Router(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.links = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void addLink(Link link) {
        links.add(link);
    }
}
