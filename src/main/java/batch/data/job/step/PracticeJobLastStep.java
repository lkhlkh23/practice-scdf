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
public class PracticeJobLastStep {

	private final JobRepository jobRepository;
	private final PlatformTransactionManager transactionManager;

	@Bean
	@JobScope
	public Step practiceJobLast() {
		return new StepBuilder("practiceJobLast", jobRepository)
			.<String, String>chunk(1, transactionManager)
			.reader(readLast())
			.writer(saveLast())
			.build();
	}

	@Bean
	@StepScope
	public ItemReader<String> readLast() {
		return () -> {
			final int random = new Random().nextInt(6);
			log.info("readLast : {}", random);
			return random > 3 ? "success" : null;
		};
	}

	@Bean
	@StepScope
	public ItemWriter<String> saveLast() {
		return chunk -> log.info("saveLast : {}", chunk);
	}

}
