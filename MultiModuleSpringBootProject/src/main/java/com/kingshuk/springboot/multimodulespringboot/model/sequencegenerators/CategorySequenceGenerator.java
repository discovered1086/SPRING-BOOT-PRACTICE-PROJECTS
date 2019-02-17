package com.kingshuk.springboot.multimodulespringboot.model.sequencegenerators;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CategorySequenceGenerator implements IdentifierGenerator{
	
	
	@Override
	@Transactional
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		
		@SuppressWarnings("unchecked")
		Query<String> sequenceValue = session.createNativeQuery("SELECT LPAD(category_sequence.nextval,7, '0') FROM dual");
		
		
		String nextSequenceValue = String.valueOf(sequenceValue.getSingleResult());
		
		return "CAT".concat(nextSequenceValue);
	}

}
