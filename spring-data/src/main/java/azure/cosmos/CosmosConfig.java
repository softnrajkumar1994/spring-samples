package azure.cosmos;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCosmosRepositories(basePackages = "com.example.repository")
public class CosmosConfig {
}
