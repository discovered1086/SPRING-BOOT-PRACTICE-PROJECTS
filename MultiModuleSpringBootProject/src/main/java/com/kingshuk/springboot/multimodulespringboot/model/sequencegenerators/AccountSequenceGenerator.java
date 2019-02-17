package com.kingshuk.springboot.multimodulespringboot.model.sequencegenerators;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AccountSequenceGenerator implements IdentifierGenerator{
	
	
	@Override
	@Transactional
	public Serializable generate(SharedSessionContractImplementor session, Object object) 
			throws HibernateException {
		
		@SuppressWarnings("unchecked")
		Query<String> sequenceValue = session.createNativeQuery("SELECT LPAD(account_sequence.nextval,12, '0') FROM dual");
		
		
		String nextSequenceValue = String.valueOf(sequenceValue.getSingleResult());
		
		return "ACC".concat(nextSequenceValue);
	}

}
