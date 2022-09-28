package co.kevingomez;

class Box{
    public int getSize() {
        return size;
    }

    public int getEdges() {
        return edges;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    private int size;
    private int edges;
    public Box(int size, int edges){
        this.size = size;
        this.edges = edges;
    }


    public static Box boxBuilder(int size, int edges){
        return new Box(size, edges);
    }
    @Override
    public String toString(){
        return "[size] " + this.size + " [edges] " + this.edges;
    }
}
