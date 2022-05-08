package o0pavel0o.buycars;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;


@Configuration
@EnableHazelcastHttpSession
@EnableCaching
@SpringBootApplication
public class Application {

	
	
	private static final Log LOG = LogFactory.getLog(Application.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	    
	  
	}
	  
	  @Bean
	    public CacheManager cacheManager() {
	    	LOG.info("Activating cache...");
	    	return new ConcurrentMapCacheManager("anuncios");
	    
	    }
	  
	  
	  
	 @Bean
	    public Config config() {

	        Config config = new Config();

	        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
            ArrayList<String> listaIp = new ArrayList<>();
            
            listaIp.add("10.0.0.6");
            listaIp.add("10.0.0.7");
          
	        joinConfig.getMulticastConfig().setEnabled(false);
	        joinConfig.getTcpIpConfig().setEnabled(true).setMembers(listaIp);
	        //joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("127.0.0.1"));
	 
	        return config ;
	    }
	  
	  
}