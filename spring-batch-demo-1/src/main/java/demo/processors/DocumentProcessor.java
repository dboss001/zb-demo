package demo.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import demo.domain.Document;

@Component
public class DocumentProcessor implements ItemProcessor<Document, Document> {

    private static final Logger LOG = LoggerFactory.getLogger(DocumentProcessor.class);
    

    @Override
    public Document process(final Document input) throws Exception {
        
    	final String name = input.getName().toUpperCase();

        final Document output = new Document();
        output.setName(name);

        LOG.info("Converting (" + input + ") into (" + output + ")");

        return output;
    }
    
    
    
    
   
}
