import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1, p2, p3;

    @BeforeEach
    void setUp() {
        p1 = new Product("000001", "Widget", "A useful device for many things", 19.99);
        p2 = new Product("000002", "Gadget", "Another useful device", 29.99);
        p3 = new Product("000003", "Doohickey", "A peculiar but functional item", 39.99);
    }

    @Test
    void setID() {
        p1.setID("000004");
        assertEquals("000004", p1.getID());
    }

    @Test
    void setFullName() {
        p1.setFullName("Super Widget");
        assertEquals("Super Widget", p1.getFullName());
    }

    @Test
    void setDescription() {
        p1.setDescription("An enhanced version of the original widget");
        assertEquals("An enhanced version of the original widget", p1.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(24.99);
        assertEquals(24.99, p1.getCost());
    }

    @Test
    void testToString() {
        String expected = "Product{ID='000001', fullName='Widget', description='A useful device for many things', cost=19.99}";
        assertEquals(expected, p1.toString());
    }

    @Test
    void toCSV() {
        String expected = "000001, Widget, A useful device for many things, 19.99";
        assertEquals(expected, p1.toCSV());
    }

    @Test
    void toJSON() {
        String expected = "{ \"ID\": \"" + p1.getID() + "\", \"fullName\": \"" + p1.getFullName() + "\", \"description\": \"" + p1.getDescription() + "\", \"cost\": " + p1.getCost() + " }";
        assertEquals(expected, p1.toJSON());
    }

    @Test
    void toXML() {
        String expected = "<Product><ID>000001</ID><fullName>Widget</fullName><description>A useful device for many things</description><cost>19.99</cost></Product>";
        assertEquals(expected, p1.toXML());
    }
}