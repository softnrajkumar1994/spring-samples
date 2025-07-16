package azure.cosmos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Container(containerName = "users")
public class User {
    @Id
    private String id;
    private String name;
    private int age;
}
