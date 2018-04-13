package demo.skip.policy;

import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.stereotype.Component;

import demo.domain.Input;
import demo.processors.GroupProcessor;

@Component
public class DemoSkipPolicy implements SkipPolicy {

	private static final Logger LOG = LoggerFactory.getLogger(GroupProcessor.class);

	@Override
	public boolean shouldSkip(Throwable exception, int skipCount) throws SkipLimitExceededException {

		if (exception instanceof FileNotFoundException) {
			return false;
			
		} else if (exception instanceof NumberFormatException && skipCount <= 1000) {

			BadDataException excp = (BadDataException) exception;
			
			Input input = (Input) excp.getData();

			LOG.error("BAD DATA: " + input.toString());

			return true;
			
		} else {
			return false;
		}
	}

}
