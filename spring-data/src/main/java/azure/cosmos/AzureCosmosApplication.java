package azure.cosmos;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AzureCosmosApplication {

    public static void main(String[] args) {
        SpringApplication.run(AzureCosmosApplication.class, args);
    }

}
