package dao;

import entity.LoginEntity;

public interface LoginEntityDao extends BaseDao<LoginEntity> {
    LoginEntity findByUname(String u);
}
