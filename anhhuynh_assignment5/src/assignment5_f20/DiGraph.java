package assignment5_f20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DiGraph implements DiGraphInterface {

	// in here go all your data and methods for the graph

	HashMap<String, NodesImpl> map;
	LinkedList<Nodes> EdgeList;
	ShortestPathInfo[] shortestPaths;
	PriorityQueue<NodesImpl> PQ;
	

	private long numNodes;
	private long numEdges;

	public DiGraph() { // default constructor
		// explicitly include this
		// we need to have the default constructor
		// if you then write others, this one will still be there
		this.map = new HashMap<String, NodesImpl>();
		this.PQ = new PriorityQueue<>((node1,node2) ->	{
			if (node1.getDV() < node2.getDV()) return -1;
			if (node1.getDV() > node2.getDV()) return  1;
			return 0;
		});
		
			
		numNodes = 0;
		numEdges = 0;
		
	}

	public HashMap getHashMap() {
		return this.map;
	}

	@Override
	public boolean addNode(long idNum, String label) {
		// TODO Auto-generated method stub
		if (idNum < 0) {
			return false;
		}
		if (this.map.containsKey(label) || label == null) {
			return false;
		}
		NodesImpl newNode = new NodesImpl(idNum, label);
		this.map.put(label, newNode);
		numNodes++;

		return true;
	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		// TODO Auto-generated method stub
		if (idNum < 0) {
			return false;
		}
		if (!this.map.containsKey(sLabel) || !this.map.containsKey(dLabel)) {
			return false;
		}
		NodesImpl currentNode = map.get(sLabel);
		NodesImpl destNode = map.get(dLabel);
		for (EdgeImpl edge : currentNode.getEdgeList()) {
			if (edge.getDestinationLabel().compareTo(dLabel) == 0) {
				return false;
			}
		}

		EdgeImpl newEdge = new EdgeImpl(idNum, sLabel, dLabel, weight, eLabel);

		currentNode.getEdgeList().add(newEdge);
		destNode.getInNodes().put(sLabel, currentNode);
		numEdges++;

		return true;
	}

	@Override
	public boolean delNode(String label) {
		// TODO Auto-generated method stub
		if (!this.map.containsKey(label)) {
			return false;
		}
		NodesImpl currentNode = map.get(label);
		this.numEdges -= currentNode.getOutEdges();
		this.numNodes--;

		for (Object key : currentNode.getInNodes().keySet()) {
			NodesImpl useNode = (NodesImpl) this.getHashMap().get(key);
			for (EdgeImpl edge : useNode.getEdgeList()) {
				if (edge.getDestinationLabel().compareTo(label) == 0
						&& edge.getDestinationLabel().compareTo(edge.getSourceLabel()) != 0) {
					useNode.getEdgeList().remove(edge);
					this.numEdges--;
					break;
				}
			}

		}

		for (EdgeImpl useEdge : currentNode.getEdgeList()) {
			NodesImpl useNode = (NodesImpl) this.getHashMap().get(useEdge.getDestinationLabel());
			if (useNode.getInNodes().containsKey(label)) {
				useNode.getInNodes().remove(label);
			}

		}

		this.map.remove(label);
		return true;
	}

	@Override
	public boolean delEdge(String sLabel, String dLabel) {
		// TODO Auto-generated method stub
		if (!this.map.containsKey(sLabel) || !this.map.containsKey(dLabel)) {
			return false;
		}
		NodesImpl current = map.get(sLabel);

		for (EdgeImpl edge : current.getEdgeList()) {
			if (edge.getDestinationLabel().compareTo(dLabel) == 0) {
				current.getEdgeList().remove(edge);

				NodesImpl dest = map.get(dLabel);
				dest.getInNodes().remove(current);
				this.numEdges--;
				return true;
			}
		}

		return false;
	}

	@Override
	public long numNodes() {
		// TODO Auto-generated method stub
		return numNodes;
	}

	@Override
	public long numEdges() {
		// TODO Auto-generated method stub
		return numEdges;
	}

	@Override
	public ShortestPathInfo[] shortestPath(String label) {
		// TODO Auto-generated method stub
		if(!this.map.containsKey(label)) {
			return null;
		}
		shortestPaths = new ShortestPathInfo[(int) this.numNodes];
		int index = 0;
	
		for(Object key : this.map.keySet()) {
			this.map.get(key).setKnown(false);
			this.map.get(key).setDV(Long.MAX_VALUE);
		}
		
		NodesImpl targetNode = this.map.get(label); //(0,s) into PQ
		targetNode.setDV(0);
		PQ.add(targetNode);
		
		
		while(PQ.size() > 0) {					//while PQ is Not empty
			NodesImpl current = PQ.peek();		//put d = node.dist
			long distance = current.getDV();			
			PQ.poll();
			
			if(current.isKnown()) {						//if node known skip
				continue;
			} else
				shortestPaths[index] = new ShortestPathInfo(current.getLabel(),current.getDV());
				index++;
				current.setKnown(true);
			
			for(EdgeImpl edge: current.getEdgeList()) {
				NodesImpl adjacentNode = this.map.get(edge.getDestinationLabel());
				if (adjacentNode.isKnown()) {
					continue;
				}
				if(adjacentNode.getDV() > distance + edge.getWeight()) {
					adjacentNode.setDV(distance + edge.getWeight());
					adjacentNode.setPV(current);
					PQ.add(adjacentNode);
				}
				
			}
		}
			
			for(Object key : this.map.keySet()) {
				if(!this.map.get(key).isKnown()) {
					shortestPaths[index] = new ShortestPathInfo((String) key,-1);
				
					index ++;
				}
			}
			//current.setDV(distance);
			//current
		return shortestPaths;
	}

	// rest of your code to implement the various operations
}