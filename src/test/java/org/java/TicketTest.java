package org.java;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.java.exceptions.AgeException;
import org.java.exceptions.KmsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketTest {
	
    private Ticket ticket;
    private final static double DELTA_ERROR = 0.001;

    @BeforeEach
    void init() {
        try {
            ticket = new Ticket(50, 25);
        } catch (KmsException e) {
			System.out.println("Kms Error: " + e.getMessage());
		} catch (AgeException e) {
			System.out.println("Age Error: " + e.getMessage());
		}
    }
    
    // Test Getters and Setters
    @Test
    void testGettersAndSetters() {
        // Test getters
        assertEquals(50, ticket.getKms(), "Getter for kms is incorrect");
        assertEquals(25, ticket.getAge(), "Getter for age is incorrect");
        assertEquals(0.0, ticket.getSale(), "Getter for sale is incorrect");

        // Test setters
        ticket.setKms(100);
        ticket.setAge(12);
        ticket.setSale(0.2);
        assertEquals(100, ticket.getKms(), "Setter for kms is incorrect");
        assertEquals(12, ticket.getAge(), "Setter for age is incorrect");
        assertEquals(0.2, ticket.getSale(), "Setter for sale is incorrect");
    }
    
    // Test kms
    @Test
    void testValidKms() {
        // kms valid value
        assertDoesNotThrow(() -> new Ticket(50, 25), "Valid kms threw unexpected exception");
    }
    @Test
    void testInvalidKms() {
    	// kms < 1
        assertThrows(KmsException.class, () -> new Ticket(0, 25), "Invalid kms did not throw KmsException");
    }

    // Test age
    @Test
    void testValidAge() {
        // age valid value
        assertDoesNotThrow(() -> new Ticket(50, 25), "Valid age threw unexpected exception");
    }
    @Test
    void testInvalidAge() {
    	// age < 0
        assertThrows(AgeException.class, () -> new Ticket(50, -5), "Invalid age did not throw AgeException");
    }
    
    // Test Ticket Price
    void testPriceCalculation() throws KmsException, AgeException {
        // Regular ticket, sale = 0.0
        assertEquals(21.0, ticket.getPrice(), DELTA_ERROR, "Price calculation for a regular ticket is incorrect");

        // Young ticket, sale = 0.2
        Ticket discountedTicket = new Ticket(100, 17); // age < 18, 20% sale
        assertEquals(16.8, discountedTicket.getPrice(), DELTA_ERROR, "Price calculation for a discounted ticket is incorrect");

        // Old ticket, sale = 0.4
        Ticket seniorTicket = new Ticket(100, 70); // age > 65, 40% sale
        assertEquals(12.6, seniorTicket.getPrice(), DELTA_ERROR, "Price calculation for a senior ticket is incorrect");
    }
}
