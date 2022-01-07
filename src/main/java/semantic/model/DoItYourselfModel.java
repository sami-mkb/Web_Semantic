package semantic.model;

import java.util.Iterator;
import java.util.List;

public class DoItYourselfModel implements IModelFunctions
{
	IConvenienceInterface model;
	
	public DoItYourselfModel(IConvenienceInterface m) {
		this.model = m;
	}

	@Override
	public String createPlace(String name) {
		// Auto-generated method stub
		return model.createInstance(name, model.getEntityURI("Place").get(0));
	}

	@Override
	public String createInstant(TimestampEntity instant) {
		boolean found=false;
		List<String> liste=model.getInstancesURI(model.getEntityURI("Instant").get(0));
		for(Iterator<String> it=liste.iterator(); it.hasNext();)
		{
			if(model.listLabels(it.next()).get(0).equals(instant.getTimeStamp()))
			{
				found=true;
			}
		}

		if (!found)
		{
		String Uri = model.createInstance(instant.getTimeStamp(), model.getEntityURI("Instant").get(0));
		model.addDataPropertyToIndividual(Uri, model.getEntityURI("a pour timestamp").get(0), instant.getTimeStamp());
		return Uri;
		}
		
		return null;
	
	}

	@Override
	public String getInstantURI(TimestampEntity instant) {
		// TODO Auto-generated method stub
		boolean found=false;

		List<String> liste=model.getInstancesURI(model.getEntityURI("Instant").get(0));
		for(Iterator<String> it=liste.iterator(); it.hasNext();)
		{
			String aux=it.next();
			if(model.hasDataPropertyValue(aux, model.getEntityURI("a pour timestamp").get(0),instant.getTimeStamp())) 
			{
				found=true;
				return aux;
			}
		}
		return null;
	}

	@Override
	public String getInstantTimestamp(String instantURI)
	{
		List<String> listeInstances=model.getInstancesURI(model.getEntityURI("Instant").get(0));
		if (!listeInstances.contains(instantURI))
		{
			return null;
		}
		else{
			
			List<List<String>> liste=model.listProperties(instantURI);
			for(Iterator<List<String>> it=liste.iterator(); it.hasNext();)
			{
				List <String>aux=it.next();
				if (aux.get(0).equals(model.getEntityURI("a pour timestamp").get(0)))
				{
					return aux.get(1);
				}
			}
			
		}
		return null;
	}

	@Override
	public String createObs(String value, String paramURI, String instantURI) {
		// TODO Auto-generated method stub
		String instance=model.createInstance(paramURI.concat(instantURI),model.getEntityURI("Observation").get(0));
		model.addObjectPropertyToIndividual(instance, model.getEntityURI("a pour date").get(0), instantURI);
		model.addDataPropertyToIndividual(instance, model.getEntityURI("a pour valeur").get(0), value);
		model.addObservationToSensor(instance,model.whichSensorDidIt(getInstantTimestamp(instantURI), paramURI));
		return instance;
	}
}
