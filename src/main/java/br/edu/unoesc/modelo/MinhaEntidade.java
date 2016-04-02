package br.edu.unoesc.modelo;

import org.bson.types.ObjectId;
import org.jongo.marshall.jackson.oid.MongoObjectId;

public abstract class MinhaEntidade{
	
	@MongoObjectId
	protected String _id;
	
	public ObjectId getObjectId() {
		if (_id == null){
			return null;
		}
		return new ObjectId(_id);
	}

}
