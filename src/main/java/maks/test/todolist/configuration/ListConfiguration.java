package maks.test.todolist.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        //Configuration to make it easier to work with classes
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                //telling to modelMapper to work with fields, not with methods
                .setFieldMatchingEnabled(true)
                //access for modelMapper to work with private fields
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                //to set matching strategy to match source and destination properties to each other
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}
