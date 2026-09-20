@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Long register(UserRegisterDTO dto) {

        User existUser =
                userMapper.getByUsername(dto.getUsername());

        if (existUser != null) {
            throw new BusinessException("用户名已存在");
        }

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setNickname(dto.getNickname());

        userMapper.insert(user);

        return user.getId();
    }
}