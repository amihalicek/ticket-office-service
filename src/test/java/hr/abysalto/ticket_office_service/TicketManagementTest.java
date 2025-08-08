package hr.abysalto.ticket_office_service;

import hr.abysalto.ticket_office_service.ticket.dto.TicketListDto;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class TicketManagementTest extends AbstractIntegrationTest {
    @Test
    public void getListOfTickets_withAuth_shouldReturnListOfTicketsWithStatus200() throws Exception {

        List<TicketListDto> result = performHttpGet("/api/v1/tickets", 200, new TypeReference<>() {});
        Assert.isTrue(result.size() == 2, "The result should return 2 tickets");

    }
}
