package batch.data.job.step;

import java.util.Random;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Configuration
@Slf4j
public class PracticeJobFirstStep {

	private final JobRepository jobRepository;
	private final PlatformTransactionManager transactionManager;

	@Bean
	@JobScope
	public Step practiceJobFirst() {
		return new StepBuilder("practiceJobFirst", jobRepository)
			.<String, String>chunk(1, transactionManager)
			.reader(readFirst())
			.writer(saveFirst())
			.build();
	}

	@Bean
	@StepScope
	public ItemReader<String> readFirst() {
		return () -> {
			final int random = new Random().nextInt(6);
			log.info("readFirst : {}", random);
			return random > 4 ? "success" : null;
		};
	}
	@Bean
	@StepScope
	public ItemWriter<String> saveFirst() {
		return chunk -> log.info("saveFirst : {}", chunk);
	}

}
