package demo.processors;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import demo.domain.Input;
import demo.domain.Item;

@Component
@StepScope
public class ItemsProcessor implements ItemProcessor<Input, Item> {

    private static final Logger LOG = LoggerFactory.getLogger(ItemsProcessor.class);
    
    @Autowired
	private JdbcTemplate jdbcTemplate;
    
    @Value("#{jobExecutionContext[DOCUMENT_ID]}")
    private Long documentId;
   

    @Override
    public Item process(final Input input) throws Exception {
        
    	final String name = input.getItemName().toUpperCase();
    	final BigDecimal amount = input.getAmount();
    	
        final Item output = new Item();
        output.setName(name);
        output.setAmount(amount);
        output.setDocumentId(documentId);
        
        Long groupId = (Long) jdbcTemplate.queryForObject(
    			"SELECT id FROM output_group WHERE document_id = ? and name=?", 
    			new Object[] { documentId, input.getGroupName().toUpperCase() }, 
    			Long.class);
        
        output.setGroupId(groupId);

        LOG.info("Converting (" + input + ") into (" + output + ")");

        return output;
    }
    
   
}
