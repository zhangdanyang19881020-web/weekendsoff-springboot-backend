@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Result<Long> register(
            @Valid @RequestBody UserRegisterDTO dto
    ) {

        Long userId = userService.register(dto);

        return Result.success(userId);
    }
}