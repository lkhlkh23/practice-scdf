package batch.data;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@ServletComponentScan
@EnableEncryptableProperties
public class DataApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(new SpringApplication(DataApplication.class).run(args)));
	}

}
