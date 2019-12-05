package stc21.project.reducto.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NonNull private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
