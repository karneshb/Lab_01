public class Product {
    private String ID;
    private String fullName;
    private String description;
    private double cost;

    public Product(String ID, String fullName, String description, double cost) {
        this.ID = ID;
        this.fullName = fullName;
        this.description = description;
        this.cost = cost;
    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }


    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", fullName='" + fullName + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }

    public String toCSV(){
        return ID + ", " + fullName + ", " + description + ", " + cost;
    }

    public String toJSON(){
        return "{ \"ID\": \"" + ID + "\", \"fullName\": \"" + fullName + "\", \"description\": \"" + description + "\", \"cost\": " + cost + " }";
    }

    public String toXML(){
        return "<Product><ID>" + ID + "</ID><fullName>" + fullName + "</fullName><description>" + description + "</description><cost>" + cost + "</cost></Product>";
    }
}
