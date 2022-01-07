package semantic.controler;

import java.io.IOException;
import java.util.List;

import semantic.model.DoItYourselfModel;
import semantic.model.IModelFunctions;
import semantic.model.ObservationEntity;
import semantic.model.SemanticModel;
import semantic.view.JSONEndpoint;

public class Controler
{
	private SemanticModel model;
	private IModelFunctions customModel;
	private IControlFunctions customControl;
	
	public Controler()
	{
		// TODO : Change the path to the one to your own ontology
		this.model = new SemanticModel("tp-iss.ttl");
		this.customModel = new DoItYourselfModel(this.model);
		this.customControl = new DoItYourselfControl(this.model, this.customModel);
		this.initializeContext();
	}
	
	private void initializeContext()
	{
		this.customModel.createPlace("Aarhus");
	}
	
	public void exportModel(String path)
	{
		this.model.exportModel(path);
	}
	
	public SemanticModel getModel()
	{
		return this.model;
	}
	
	public IModelFunctions getCustomModel()
	{
		return this.customModel;
	}
	
	public IControlFunctions getCustomControl()
	{
		return this.customControl;
	}
	
	public static void main(String[] args) 
	{
		Controler c = new Controler();
		try
		{
			// TODO : Change the path to the one of the file you downloaded
			List<ObservationEntity> obsList = JSONEndpoint.parseObservations("C:\\Users\\khali\\OneDrive\\Desktop\\INSA\\Semantic_web_of_things\\tempm.txt");
			String tempURI = c.model.getEntityURI("Temperature").get(0);
			c.getCustomControl().instantiateObservations(obsList, tempURI);
			// TODO : Same thing, for humidity
			/*obsList = JSONEndpoint.parseObservations("hum.txt");
			String humidityURI = c.model.getEntityURI("Humidity").get(0);
			c.getCustomControl().instantiateObservations(obsList, humidityURI);
			*/
			// TODO : Change the path so that it points where you want the export to be done
			c.exportModel("export.ttl");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
