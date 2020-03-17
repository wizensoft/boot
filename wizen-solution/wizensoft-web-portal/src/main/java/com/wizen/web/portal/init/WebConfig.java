package com.wizen.web.portal.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.wizen.infrastructure.util.JarFileResourcesExtractor;

@Configuration
public class WebConfig {
	// tiles 셋팅
	@Bean(name="tilesConfigure")
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] { 
				"/WEB-INF/tiles/tiles_aa/tiles.xml"
				//, "classpath:/META-INF/resources/infrastructure/**/views.xml"
				, "classpath:/META-INF/resources/infrastructure/tiles/shared_tiles.xml"
		});
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
	// tiles 셋팅
	@Bean(name="viewResolver")
	public TilesViewResolver tilesViewResolver() {
		TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(1);
		return resolver;

	}
	
	 @Bean 
    public JarFileResourcesExtractor jspSupport(){
        final JarFileResourcesExtractor extractor = new JarFileResourcesExtractor("META-INF/resources/*.jsp"
        		,"wizensoft-library-infrastructure-1.0.0-SNAPSHOT.jar"
        		//,"WEB-INF/dest/infrastructure/jsp" 
        		,"WEB-INF/views/common"
        		);
        return extractor;
    }
}
