package service;

import dao.Impl.LoginEntityDaoImpl;
import dao.LoginEntityDao;
import entity.LoginEntity;

import java.util.List;

public class LoginService implements BaseService<LoginEntity> {
    LoginEntityDao Dao;

    public LoginService(){
        Dao = new LoginEntityDaoImpl();
    }

    @Override
    public LoginEntity insert(LoginEntity entity) {
        return Dao.insert(entity);
    }

    @Override
    public LoginEntity update(LoginEntity entity) {
        return Dao.update(entity);
    }

    @Override
    public Boolean delete(LoginEntity entity) {
        return Dao.delete(entity);
    }

    @Override
    public LoginEntity findById(int id) {
        return Dao.findById(id);
    }

    @Override
    public List<LoginEntity> find() {
        return Dao.find();
    }

    public LoginEntity findByUname(String u){
        return Dao.findByUname(u);
    }
}
