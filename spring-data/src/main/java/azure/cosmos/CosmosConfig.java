package azure.cosmos;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.spring.data.cosmos.CosmosFactory;
import com.azure.spring.data.cosmos.config.CosmosConfigurationSupport;
import com.azure.spring.data.cosmos.core.CosmosTemplate;
import com.azure.spring.data.cosmos.core.mapping.CosmosMappingContext;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCosmosRepositories(basePackages = "azure.cosmos")
public class CosmosConfig {

    @Value("${spring.cloud.azure.cosmos.endpoint}")
    private String uri;

    @Value("${spring.cloud.azure.cosmos.key}")
    private String key;

    @Value("${spring.cloud.azure.cosmos.database}")
    private String databaseName;

    @Bean
    public CosmosAsyncClient cosmosAsyncClient() {
        return new CosmosClientBuilder()
                .endpoint(uri)
                .key(key)
                .consistencyLevel(ConsistencyLevel.EVENTUAL)
                .buildAsyncClient();
    }

    @Bean
    public CosmosFactory cosmosFactory(CosmosAsyncClient cosmosAsyncClient) {
        return new CosmosFactory(cosmosAsyncClient, databaseName);
    }

    @Bean
    public CosmosMappingContext cosmosMappingContext() {
        return new CosmosMappingContext();
    }

    @Bean
    public CosmosConfigurationSupport cosmosConfigurationSupport() {
        return new CosmosConfigurationSupport() {
            @Override
            protected String getDatabaseName() {
                return databaseName;
            }
        };
    }

}
