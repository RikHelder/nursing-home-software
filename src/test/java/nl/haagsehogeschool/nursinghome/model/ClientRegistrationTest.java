package nl.haagsehogeschool.nursinghome.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientRegistrationTest {
    private ClientRegistration clientRegistration;
    private Client testClient;

    @BeforeEach
    void setup() {
        clientRegistration = new ClientRegistration();
        testClient = createFakeClient("Fabel");
    }

    @Test
    void testMoveWaitingClientToActiveUnknownClient() {
        Assertions.assertFalse(clientRegistration.moveWaitingClientToActive(testClient));
    }

    @Test
    void testMoveWaitingClientToActiveFullHouse() {
        for (int clientIndex = 0; clientIndex < ClientRegistration.MAXIMUM_CAPACITY; clientIndex++) {
            Client activeClient = createFakeClient("Client " + (clientIndex + 1));
            clientRegistration.addWaitingClient(activeClient);
            Assertions.assertTrue(clientRegistration.moveWaitingClientToActive(activeClient));
        }

        clientRegistration.addWaitingClient(testClient);
        Assertions.assertFalse(clientRegistration.moveWaitingClientToActive(testClient));
    }

    private Client createFakeClient(String firstName) {
        return new Client(firstName, "Poterboter", "dhr", null,
                null, null, null, true);
    }
}
