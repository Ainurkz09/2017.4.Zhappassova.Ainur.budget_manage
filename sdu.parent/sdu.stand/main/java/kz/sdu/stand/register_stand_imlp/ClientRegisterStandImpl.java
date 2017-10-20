package kz.sdu.stand.register_stand_imlp;

import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.controller.model.ClientModel;
import kz.sdu.controller.register.ClientRegister;
import kz.sdu.stand.register_stand_imlp.db.Db;
import kz.sdu.stand.register_stand_imlp.model.ClientModelServer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Bean
public class ClientRegisterStandImpl implements ClientRegister{

    public BeanGetter<Db> db;

    @Override
    public ClientModel getClientById(String id) {
        ClientModelServer cl =  db.get().clientsList.get(id);
        ClientModel x = new ClientModel(cl.id,cl.surname,cl.name,cl.patronymic,cl.age);
        return x;
    }

    @Override
    public List<ClientModel> getClientsList(){
        List<ClientModel> list = new ArrayList<ClientModel>();
        for (String id : db.get().clientsList.keySet()){
            ClientModelServer cl =  db.get().clientsList.get(id);
            ClientModel x = new ClientModel(cl.id,cl.surname,cl.name,cl.patronymic,cl.age);
            list.add(x);
        }
        return list;
    }

    @Override
    public String saveClient(String uuid,ClientModel cl){
        if(uuid == ""){
            ClientModelServer x = new ClientModelServer(uuid, cl.surname,cl.name, cl.patronymic,cl.age);
            uuid = UUID.randomUUID().toString();
            db.get().clientsList.put(uuid, x);
            return "Ok, saved";
        }else{
            ClientModelServer x = new ClientModelServer(uuid, cl.surname,cl.name, cl.patronymic,cl.age);
            db.get().clientsList.remove(uuid);
            db.get().clientsList.put(uuid, x);
            return "Ok, updated";
        }



    }


    public String deleteClient(String uuid){
        db.get().clientsList.remove(uuid);
        return "Ok, deleted";
    }


}
