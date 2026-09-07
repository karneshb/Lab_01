import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp() {
        p1 = new Person("00000A", "Bob", "Tester 1", "Mr.", "1990");
        p2 = new Person("00000B", "Sally", "Tester 2", "Ms.", "1995");
        p3 = new Person("00000C", "John", "Tester 3", "Dr.", "1985");
        p4 = new Person("00000D", "Jane", "Tester 4", "Mrs.", "1992");
        p5 = new Person("00000E", "Mike", "Tester 5", "Mr.", "1988");
        p6 = new Person("00000F", "Lisa", "Tester 6", "Ms.", "1997");
    }

    @Test
    void setIDnum() {
        p1.setIDnum("00000Z");
        assertEquals("00000Z", p1.getIDnum());
    }

    @Test
    void setTitle() {
        p1.setTitle("Dr.");
        assertEquals("Dr.", p1.getTitle());
    }

    @Test
    void setFirstName() {
        p1.setFirstName("Robert");
        assertEquals("Robert", p1.getFirstName());
    }

    @Test
    void setLastName() {
        p1.setLastName("Smith");
        assertEquals("Smith", p1.getLastName());
    }

    @Test
    void setBirthYear() {
        p1.setBirthYear("1990");
        assertEquals("1990", p1.getBirthYear());
    }

    @Test
    void fullName() {
        assertEquals("Bob Tester 1", p1.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr. Bob Tester 1", p1.formalName());
    }

    @Test
    void getAge() {
        assertEquals("36", p1.getAge());
    }

    @Test
    void testGetAge() {
        assertEquals("30", p1.getAge(2020));
    }

    @Test
    void testToString() {
        assertEquals("Person{IDnum='00000A', firstName='Bob', lastName='Tester 1', title='Mr.', birthYear='1990'}", p1.toString());
    }

    @Test
    void toCSV() {
        assertEquals("00000A, Bob, Tester 1, Mr., 1990", p1.toCSV());
    }

    @Test
    void toJSON() {
        assertEquals("{ \"IDnum\": \"" + p1.getIDnum() + "\", \"firstName\": \"" + p1.getFirstName() + "\", \"lastName\": \"" + p1.getLastName() + "\", \"title\": \"" + p1.getTitle() + "\", \"birthYear\": \"" + p1.getBirthYear() + "\" }", p1.toJSON());
    }

    @Test
    void toXML() {
        assertEquals("<Person><IDnum>00000A</IDnum><firstName>Bob</firstName><lastName>Tester 1</lastName><title>Mr.</title><birthYear>1990</birthYear></Person>", p1.toXML());
    }
}