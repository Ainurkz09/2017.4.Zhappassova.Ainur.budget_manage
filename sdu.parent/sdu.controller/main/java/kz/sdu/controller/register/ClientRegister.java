package kz.sdu.controller.register;

import kz.sdu.controller.model.ClientModel;

import java.util.HashMap;
import java.util.List;

public interface ClientRegister {
    ClientModel getClientById(String id);
    List<ClientModel> getClientsList();
    String saveClient(String uuid,ClientModel cl);
    String deleteClient(String id);
}
