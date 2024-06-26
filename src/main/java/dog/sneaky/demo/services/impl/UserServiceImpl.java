package dog.sneaky.demo.services.impl;

import dog.sneaky.demo.controllers.controller.dto.RecoverPasswordCommand;
import dog.sneaky.demo.controllers.controller.dto.UserDTO;
import dog.sneaky.demo.data.eneity.CustomUser;
import dog.sneaky.demo.data.eneity.UserRoleRef;
import dog.sneaky.demo.data.repository.CustomUserRepository;
import dog.sneaky.demo.data.repository.UserRoleRefRepository;
import dog.sneaky.demo.services.UserService;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final RedisTemplate<Object, Object> redisTemplate;
    private final PasswordEncoder passwordEncoder;
//    private final RedissonClient redissonClient;
    private final CustomUserRepository customUserRepository;
    private final UserRoleRefRepository userRoleRefRepository;



    @Override
    public UserDTO listsUser(UserDTO userDTO) {
//        MyUserDO myUser = new MyUserDO();
//        myUser.setPageNum(userDTO.getPageNum());
//        myUser.setPageSize(userDTO.getPageSize());
//        myUser.setUsername(userDTO.getUsername());
//        List<MyUserDO> myUserPage = myUserDAO.list(myUser);

        UserDTO r = new UserDTO();
//        r.setTotal(myUserPage.getTotal());
//        r.setRows(myUserPage.stream().map(this::convert).collect(Collectors.toList()));
        return null;
    }


//    private UserDTO convert(MyUserDO user) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUsername(user.getUsername());
//        userDTO.setEmail(user.getUsername());
//        userDTO.setAge(111);
//        return userDTO;
//    }


    @Transactional
    public void restPassword(RecoverPasswordCommand recoverPasswordCommand) {
        String uuid = recoverPasswordCommand.getUuid();
        if (!StringUtils.hasLength(uuid)){
            throw new IllegalArgumentException("Param Error.");
        }

        Boolean hasKey = redisTemplate.hasKey(uuid);
        if (hasKey == null || !hasKey) {
            throw new IllegalArgumentException("Param Error.");
        }

        String username = (String) redisTemplate.opsForValue().get(uuid);
        if (!StringUtils.hasLength(username)) {
            throw new IllegalArgumentException("Param Error.");
        }

        String newPassword = recoverPasswordCommand.getRecoverPasswordDTO().getPassword();
//        int i = myUserDAO.resetPasswd(username, passwordEncoder.encode(newPassword));
//        if(i > 0){
//            redisTemplate.delete(uuid);
//        }

    }


    @Transactional
    @Override
    public int create() {
        String username = "zhangsan";
//        RLock lock = redissonClient.getLock(username);
//        try {
//            lock.lock();
//            MyUser myUser = myUserDAO.loadByUsername(username);
//            if (myUser == null) {
//                myUser = new MyUser();
//                myUser.setUsername(username);
//                myUser.setPassword("12313");
//                myUser.setEnabled("0");
//                myUserDAO.insert(myUser);
//            }
//        } finally {
//            if (lock.isHeldByCurrentThread()) {
//                lock.unlock();
//            }
//        }

        return 0;
    }


    @Transactional
    @Override
    public int createUser(CustomUser customUser) {
        customUser.setPassword(passwordEncoder.encode(customUser.getPassword()));
        customUserRepository.save(customUser);
        userRoleRefRepository.save(new UserRoleRef(customUser.getId(), 2L));
        return 0;
    }

}
