package semantic.model;

public class DoItYourselfModel implements IModelFunctions
{
	IConvenienceInterface model;
	
	public DoItYourselfModel(IConvenienceInterface m) {
		this.model = m;
	}

	@Override
	public String createPlace(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createInstant(TimestampEntity instant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstantURI(TimestampEntity instant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstantTimestamp(String instantURI)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createObs(String value, String paramURI, String instantURI) {
		// TODO Auto-generated method stub
		return null;
	}
}
