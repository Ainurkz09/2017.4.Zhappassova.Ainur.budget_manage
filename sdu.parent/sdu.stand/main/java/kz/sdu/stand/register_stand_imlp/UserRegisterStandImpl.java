package kz.sdu.stand.register_stand_imlp;

import com.google.common.base.Strings;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.sdu.controller.model.UserInfo;
import kz.sdu.controller.register.UserRegister;
import kz.sdu.stand.register_stand_imlp.db.Db;

import java.util.ArrayList;

@Bean
public class UserRegisterStandImpl implements UserRegister {
    public BeanGetter<Db> db;

    @Override
    public UserInfo getUserInfo(String personId) {
        UserInfo userInfo = new UserInfo();

        String role = db.get().personRoleMapping.get(personId);

        if(!Strings.isNullOrEmpty(role)){
            userInfo.cans.addAll(db.get().roleFuncMapping.get(role)==null?
                    new ArrayList<>():db.get().roleFuncMapping.get(role));
        }

        return userInfo;
    }
}
