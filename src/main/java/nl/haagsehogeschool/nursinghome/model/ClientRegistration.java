package nl.haagsehogeschool.nursinghome.model;

import java.util.ArrayList;
import java.util.List;

public class ClientRegistration {
    static final int MAXIMUM_CAPACITY = 15;

    private List<Client> activeClients = new ArrayList<>();
    private List<Client> waitingClients = new ArrayList<>();

    public void addWaitingClient(Client client) {
        waitingClients.add(client);
    }

    public boolean removeWaitingClient(Client client) {
        return waitingClients.remove(client);
    }

    public boolean moveWaitingClientToActive(Client client) {
//        // Unit test.
//        for (int clientIndex = 0; clientIndex < MAXIMUM_CAPACITY; clientIndex++) {
//            clientRegistration.addWaitingClient(client);
//            Assertions.assertTrue(clientRegistration.moveWaitingClientToActive(client));
//        }
//
//        clientRegistration.addWaitingClient(client16);
//        Assertions.assertFalse(clientRegistration.moveWaitingClientToActive(client16));


        if (waitingClients.contains(client) && activeClients.size() < MAXIMUM_CAPACITY) {
            waitingClients.remove(client);
            activeClients.add(client);

            return true;
        } else {
            return false;
        }
    }

    public boolean removeActiveClient(Client client) {
        return activeClients.remove(client);
    }
}
