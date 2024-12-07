package model;

public class Link {
    private Router startRouter;
    private Router endRouter;
    private double weight;

    public Link(Router startRouter, Router endRouter, double weight) {
        this.startRouter = startRouter;
        this.endRouter = endRouter;
        this.weight = weight;
    }

    public Router getStartRouter() {
        return startRouter;
    }

    public Router getEndRouter() {
        return endRouter;
    }

    public double getWeight() {
        return weight;
    }
}
