package model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Router> routers;
    private List<Link> links;

    public Graph() {
        this.routers = new ArrayList<>();
        this.links = new ArrayList<>();
    }

    public List<Router> getRouters() {
        return routers;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void addRouter(Router router) {
        routers.add(router);
    }

    public void addLink(Link link) {
        links.add(link);
    }
}
