import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + t);

        // assign gives back a new ticket, old one doesnt change
        IncidentTicket t2 = service.assign(t, "agent@example.com");
        System.out.println("\nAfter assign (new obj): " + t2);
        System.out.println("Original still same: " + t);

        // escalate also gives new ticket
        IncidentTicket t3 = service.escalateToCritical(t2);
        System.out.println("\nAfter escalate (new obj): " + t3);

        // trying to mess with tags from outside wont work
        List<String> tags = t3.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("this should not print");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nCant modify tags from outside! tags are safe: " + t3.getTags());
        }
    }
}
