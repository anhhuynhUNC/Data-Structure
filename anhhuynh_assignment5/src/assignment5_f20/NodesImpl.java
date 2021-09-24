package assignment5_f20;

import java.util.HashMap;
import java.util.LinkedList;

public class NodesImpl implements Nodes{
	private long id;
	private String label;
	LinkedList<EdgeImpl> edgeList;
	HashMap<String, NodesImpl> inNodes;
	private long numOutEdges;
	
	private boolean isKnown;
	private long dv;
	private Nodes pv;
	
	public NodesImpl(long id, String label) {
		this.id = id;
		this.label = label;
		
		this.numOutEdges = 0;
		
		this.edgeList = new LinkedList<EdgeImpl>();
		this.inNodes = new HashMap<String, NodesImpl>();
		
		isKnown = false;
		dv = Long.MAX_VALUE;
		pv = null;
	
	}
	
	public LinkedList<EdgeImpl> getEdgeList() {
		return edgeList;
	}
	public HashMap<String, NodesImpl> getInNodes() {
		return this.inNodes;
	}
	
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}
	public long getOutEdges() {
		for(EdgeImpl edge : this.edgeList) {
			numOutEdges ++;
		}
		return numOutEdges;
	}
	
	@Override
	public String toString() {
		return "(" + id + ")"  + label;
	}

	@Override
	public boolean isKnown() {
		// TODO Auto-generated method stub
		return this.isKnown;
	}

	@Override
	public long getDV() {
		// TODO Auto-generated method stub
		return this.dv;
	}

	@Override
	public Nodes getPV() {
		// TODO Auto-generated method stub
		return this.pv;
	}

	@Override
	public void setKnown(boolean bool) {
		// TODO Auto-generated method stub
		isKnown = bool;
	}

	@Override
	public void setDV(long distance) {
		// TODO Auto-generated method stub
		dv = distance;
	}

	@Override
	public void setPV(Nodes previous) {
		// TODO Auto-generated method stub
		pv = previous;
	}
}
