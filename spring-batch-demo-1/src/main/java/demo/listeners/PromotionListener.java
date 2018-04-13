package demo.listeners;

import org.springframework.batch.core.listener.ExecutionContextPromotionListener;
import org.springframework.stereotype.Component;

@Component
public class PromotionListener extends ExecutionContextPromotionListener {
	
	public PromotionListener() {
		setKeys(
			new String[]{
				"DOCUMENT_ID"
		});
	}

}
