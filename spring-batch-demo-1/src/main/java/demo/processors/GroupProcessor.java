package demo.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import demo.domain.Group;

@Component
@StepScope
public class GroupProcessor implements ItemProcessor<Group, Group> {

    private static final Logger LOG = LoggerFactory.getLogger(GroupProcessor.class);
    
    @Value("#{jobExecutionContext[DOCUMENT_ID]}")
    private Long documentId;
   
    @Override
    public Group process(final Group input) throws Exception {
        
    	final String name = input.getName().toUpperCase();

        final Group output = new Group();
        output.setName(name);
        output.setDocumentId(documentId);
        
        LOG.info("Converting (" + input + ") into (" + output + ")");

        return output;
    }
 
}
