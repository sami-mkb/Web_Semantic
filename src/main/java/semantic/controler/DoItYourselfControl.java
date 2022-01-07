package semantic.controler;

import java.util.Iterator;
import java.util.List;

import semantic.model.IConvenienceInterface;
import semantic.model.IModelFunctions;
import semantic.model.ObservationEntity;

public class DoItYourselfControl implements IControlFunctions
{
	private IConvenienceInterface model;
	private IModelFunctions customModel;

	public DoItYourselfControl(IConvenienceInterface model, IModelFunctions customModel)
	{
		this.model = model;
		this.customModel = customModel;
	}

	@Override
	public void instantiateObservations(List<ObservationEntity> obsList,
			String paramURI) {
		int total=obsList.size();
		int count=0;
		for(Iterator<ObservationEntity> it=obsList.iterator(); it.hasNext();)
		{	count ++; 
		ObservationEntity aux=it.next();
		String bloup =customModel.createObs(aux.getValue().toString(), paramURI, customModel.createInstant(aux.getTimestamp()));
		System.out.print("Element ");
		System.out.print(count);
		System.out.print(" of ");
		System.out.println(total);

		}

	}
}
