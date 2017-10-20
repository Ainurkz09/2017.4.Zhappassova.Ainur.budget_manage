package kz.sdu.controller.controller;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;
import kz.sdu.controller.model.ClientModel;
import kz.sdu.controller.register.ClientRegister;
import kz.sdu.controller.utils.Controller;

import java.util.List;
import java.util.UUID;

@Bean
@Mapping("/client")
public class ClientController implements Controller {
    public BeanGetter<ClientRegister> clientRegister;

    @ToJson
    @Mapping("/getClientById")
    public ClientModel getClientByThisId(@Par("id") String id){
        return clientRegister.get().getClientById(id);
    }

    @ToJson
    @Mapping("/getClients")
    public List<ClientModel> getClients(){
        return clientRegister.get().getClientsList();
    }

    @ToJson
    @Mapping("/saveClient")
    public String saveClient(@Par("name") String name, @Par("surname") String surname,
                             @Par("patronymic") String patronymic, @Par("age") String age){
        String uuid = "";
        ClientModel cl = new ClientModel(uuid,surname, name, patronymic, age);
        return clientRegister.get().saveClient(uuid, cl);
    }

    @ToJson
    @Mapping("/updateClient")
    public String updateClient(@Par("id") String id,@Par("name") String name, @Par("surname") String surname,
                               @Par("patronymic") String patronymic, @Par("age") String age){
        ClientModel cl = new ClientModel(id, surname, name, patronymic, age);
        return clientRegister.get().saveClient(id, cl);
    }

    @ToJson
    @Mapping("/deleteClient")
    public String deleteClient(@Par("id") String id){
        return clientRegister.get().deleteClient(id);
    }

}
