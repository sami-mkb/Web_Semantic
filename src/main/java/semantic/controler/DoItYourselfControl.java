package semantic.controler;

import java.util.List;

import semantic.model.IConvenienceInterface;
import semantic.model.IModelFunctions;
import semantic.model.ObservationEntity;

public class DoItYourselfControl implements IControlFunctions
{
	private IConvenienceInterface model;
	private IModelFunctions cusotmModel;
	
	public DoItYourselfControl(IConvenienceInterface model, IModelFunctions customModel)
	{
		this.model = model;
		this.cusotmModel = customModel;
	}
	
	@Override
	public void instantiateObservations(List<ObservationEntity> obsList,
			String paramURI) {
		// TODO Auto-generated method stub
	}
}
