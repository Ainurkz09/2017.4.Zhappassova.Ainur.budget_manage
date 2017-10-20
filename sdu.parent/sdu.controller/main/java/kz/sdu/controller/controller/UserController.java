package kz.sdu.controller.controller;


import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.mvc.annotations.Mapping;
import kz.greetgo.mvc.annotations.Par;
import kz.greetgo.mvc.annotations.ToJson;
import kz.sdu.controller.model.UserInfo;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.controller.utils.Controller;

@Bean
@Mapping("/user")
public class UserController implements Controller {

    public BeanGetter<UserRegister> userRegister;

    @ToJson
    @Mapping("/info")
    public UserInfo getUserInfo(@Par("personId") String personId) {
        System.out.println(personId);
        return userRegister.get().getUserInfo(personId);
    }

}