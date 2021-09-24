package assignment5_f20;

public interface Edge {
	long getId();
	String getLabel();
	long getWeight();
	
	String getSourceLabel();
	String getDestinationLabel();
}
