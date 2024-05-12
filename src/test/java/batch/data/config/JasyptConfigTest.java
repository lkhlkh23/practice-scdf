package batch.data.config;

import static org.junit.jupiter.api.Assertions.*;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("h2")
class JasyptConfigTest {

	@Autowired
	private StandardPBEStringEncryptor encryptor;

	@Test
	void test_standardPBEStringEncryptor() {
		System.out.println(encryptor.decrypt(""));
	}
}