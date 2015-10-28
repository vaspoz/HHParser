package findr.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by v.pozdeev on 22.10.2015.
 */
@Configuration
@ComponentScan(basePackages = "findr",
    excludeFilters = {
            @ComponentScan.Filter(
                    type = FilterType.ANNOTATION,
                    value = EnableWebMvc.class)})
public class RootConfig {
}
