package model;

import java.util.*;

public class Router implements Comparable<Router> {
    private String id;
    private List<Link> links;

    public Router(Integer id) {
        this.id = id.toString();
        this.links = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    @Override
    public int compareTo(Router other) {
        return this.id.compareTo(other.id);
    }
}