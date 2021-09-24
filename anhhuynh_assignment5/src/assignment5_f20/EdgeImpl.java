package assignment5_f20;

public class EdgeImpl implements Edge {
	private long id;
	private String eLabel;
	private String sLabel;
	private String dLabel;
	
	private long weight;
	
	public EdgeImpl(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		this.id = idNum;
		this.sLabel = sLabel;
		this.dLabel = dLabel;
		this.eLabel = eLabel;
		this.weight = weight;
	}
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return this.eLabel;
	}

	@Override
	public long getWeight() {
		// TODO Auto-generated method stub
		return this.weight;
	}

	@Override
	public String getSourceLabel() {
		// TODO Auto-generated method stub
		return this.sLabel;
	}

	@Override
	public String getDestinationLabel() {
		// TODO Auto-generated method stub
		return this.dLabel;
	}
	@Override
	public String toString() {
		return "(" + this.id + ")" + "--" + this.weight + "--> " + this.dLabel;
	}
	

}
