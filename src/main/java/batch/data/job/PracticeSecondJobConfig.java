package batch.data.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableTask
@RequiredArgsConstructor
public class PracticeSecondJobConfig {

	private final JobRepository jobRepository;

	@Bean
	public Job practiceSecondJob(final Step practiceSecond) {
		return new JobBuilder("practiceSecondJob", jobRepository)
			.incrementer(new RunIdIncrementer())
			.start(practiceSecond)
			.build();
	}

}
