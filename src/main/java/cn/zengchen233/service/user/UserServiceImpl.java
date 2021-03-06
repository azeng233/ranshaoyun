package cn.zengchen233.service.user;

import cn.zengchen233.dao.user.UserMapper;
import cn.zengchen233.pojo.Comment;
import cn.zengchen233.pojo.User;
import cn.zengchen233.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    private MybatisUtils mybatisUtils;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean userRegister(Map<String, Object> map) {
        boolean flag = false;
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int add = mapper.userRegister(map);

        if (add > 0) {
            flag = true;
        }

        sqlSession.close();
        return flag;
    }

    @Override
    public User userLogin(String usercode) {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User loginUser = mapper.userLogin(usercode);

        sqlSession.close();
        return loginUser;
    }

    @Override
    public boolean userComment(Map<String, Object> map) {
        boolean flag = false;
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int add = mapper.userComment(map);

        if (add > 0) {
            flag = true;
        }

        sqlSession.close();
        return flag;
    }

    @Override
    public List<Comment> queryComment() {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<Comment> commentList = mapper.queryComment();

        sqlSession.close();
        return commentList;
    }

    @Override
    public List<User> queryUserList(Map<String, Object> map) {
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.queryUserList(map);

        sqlSession.close();
        return userList;
    }

    @Override
    public boolean updatePwd(String usercode, String password) {
        boolean flag = false;
        SqlSession sqlSession = mybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.updatePwd(usercode, password);

        if (i > 0) {
            flag = true;
        }
        sqlSession.close();
        return flag;
    }

    @Test
    public void test() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.queryComment();
    }
}

