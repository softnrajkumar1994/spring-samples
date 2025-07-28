package azure.cosmos;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
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
