package assignment5_f20;

public interface Nodes {
	long getId();
	String getLabel();
	
	boolean isKnown();
	long getDV();
	Nodes getPV();
	
	void setKnown(boolean bool);
	void setDV(long distance);
	void setPV(Nodes previous);
}
