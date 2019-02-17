package com.kingshuk.springboot.multimodulespringboot.model.sequencegenerators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CustomerSequenceGenerator implements IdentifierGenerator{
	
	
	@Override
	@Transactional
	public Serializable generate(SharedSessionContractImplementor session, Object object){
		
		@SuppressWarnings("unchecked")
		Query<String> sequenceValue = session.createNativeQuery("SELECT LPAD(customer_sequence.nextval,10, '0') FROM dual");
		
		
		String nextSequenceValue = String.valueOf(sequenceValue.getSingleResult());
		
		return "CUST".concat(nextSequenceValue);
	}

}
