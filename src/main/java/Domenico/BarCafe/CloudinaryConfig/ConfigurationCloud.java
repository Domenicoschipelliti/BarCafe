package Domenico.BarCafe.CloudinaryConfig;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigurationCloud {
    @Bean
  public Cloudinary configuration(@Value("{cloudinary.name}")String name,@Value("{cloudinary.apikey}")String apekey,@Value("{cloudinary.secret}")String secret){
      Map<String,String> config=new HashMap<>();
      config.put("cloud_name",name);
      config.put("apy_key",apekey);
      config.put("secret_key",secret);
      return new Cloudinary(config);

    }

}
