package assignment5_f20;

import java.util.PriorityQueue;

public class DiGraphPlayground {

	public static void main(String[] args) {

		// thorough testing is your responsibility
		//
		// you may wish to create methods like
		// -- print
		// -- sort
		// -- random fill
		// -- etc.
		// in order to convince yourself your code is producing
		// the correct behavior
		exTest();
	}

	public static void exTest() {
		DiGraph d = new DiGraph();

		DiGraph a = new DiGraph();

		DiGraph s = new DiGraph();

		PriorityQueue<Nodes> PQ = new PriorityQueue<>((node1, node2) -> {
			if (node1.getDV() < node2.getDV())
				return -1;
			if (node1.getDV() > node2.getDV())
				return 1;
			return 0;
		});

		Nodes nodesA = new NodesImpl(1, "mot");
		nodesA.setDV(100);
		Nodes nodesB = new NodesImpl(1, "hai");
		nodesB.setDV(10);
		Nodes nodesC = new NodesImpl(1, "ba");
		nodesC.setDV(1);

		PQ.add(nodesA);
		PQ.add(nodesB);
		PQ.add(nodesC);

		System.out.println(PQ.peek());

		System.out.println("PRIORITY CHECK");

		s.addNode(1, "0");
		s.addNode(1, "1");
		s.addNode(1, "2");
		s.addNode(1, "3");
		s.addNode(1, "4");
		s.addNode(1, "5");
		s.addNode(1, "6");
		s.addNode(1, "7");
		s.addNode(1, "8");
		s.addNode(1, "9");
		s.addNode(1, "10");
		s.addNode(1, "11");
		s.addNode(1, "12");
		s.addNode(1, "13");
		s.addNode(1, "14");
		s.addNode(1, "15");
		s.addNode(1, "16");
		s.addNode(1, "17");

		s.addEdge(1, "0", "4", 6, null);
		s.addEdge(1, "0", "7", 2, null);
		s.addEdge(1, "1", "4", 3, null);
		s.addEdge(1, "3", "2", 8, null);
		s.addEdge(1, "3", "6", 4, null);
		s.addEdge(1, "3", "10", 1, null);
		s.addEdge(1, "3", "17", 7, null);
		s.addEdge(1, "4", "5", 1, null);
		s.addEdge(1, "5", "4", 6, null);
		s.addEdge(1, "5", "9", 5, null);
		s.addEdge(1, "6", "9", 8, null);
		s.addEdge(1, "7", "0", 4, null);
		s.addEdge(1, "7", "8", 3, null);
		s.addEdge(1, "8", "7", 2, null);
		s.addEdge(1, "8", "9", 7, null);
		s.addEdge(1, "8", "12", 5, null);
		s.addEdge(1, "9", "13", 1, null);
		s.addEdge(1, "9", "10", 9, null);
		s.addEdge(1, "10", "6", 9, null);
		s.addEdge(1, "10", "17", 6, null);
		s.addEdge(1, "11", "7", 3, null);
		s.addEdge(1, "11", "12", 2, null);
		s.addEdge(1, "12", "13", 8, null);
		s.addEdge(1, "12", "16", 3, null);
		s.addEdge(1, "15", "14", 8, null);
		s.addEdge(1, "15", "11", 1, null);
		s.addEdge(1, "15", "12", 2, null);
		s.addEdge(1, "15", "17", 7, null);
		s.addEdge(1, "16", "17", 1, null);

		s.addEdge(1, "Raleigh", "Durham", 14, null);
		s.addEdge(1, "Durham", "Hillsborough", 9, null);
		s.addEdge(1, "Chapel_hill", "Graham", 25, null);
		s.addEdge(1, "Chapel_hill", "Carrboro", 1, null);
		s.addEdge(1, "Carrboro", "Cary", 32, null);
		s.addEdge(1, "Cary", "Raleigh", 3, null);
		s.addEdge(1, "Pittsboro", "Cary", 17, null);
		s.addEdge(1, "Pittsboro", "Sanford", 15, null);
		s.addEdge(1, "Sanford", "Los_angeles", 3012, null);
		// s.addEdge(1, "5", "7", 3, null);
		// s.addEdge(1, "6", "5", 1, null);

		printGraph(s);
		System.out.println("numEdges: " + s.numEdges());
		System.out.println("numNodes: " + s.numNodes());
		// s.shortestPath("A");
		for (int i = 0; i < 18; i++) {
			ShortestPathInfo[] paths = s.shortestPath("15");
			System.out.println(paths[i]);
		}

		System.out.println("SHORTEST PATH CHECK");

		d.addNode(1, "a");
		d.addNode(3, "b");
		d.addNode(7, "c");
		d.addNode(0, "d");
		d.addNode(4, "e");
		d.addNode(6, "si");

		d.addEdge(0, "a", "a", 3, null);
		d.addEdge(0, "b", "b", 1, null);
		d.addEdge(0, "c", "c", 23, null);
		d.addEdge(0, "a", "d", 1, null);
		d.addEdge(0, "a", "e", 6, null);

		d.addEdge(0, "b", "a", 2, null);
		d.addEdge(1, "c", "a", 5, null);
		d.addEdge(2, "d", "a", 7, null);
		d.addEdge(3, "b", "a", 9, null);
		d.addEdge(4, "e", "a", 1, null);
		d.addEdge(5, "si", "a", 6, null);
		d.addEdge(0, "c", "b", 3, null);
		d.addEdge(1, "b", "e", 5, null);
		d.addEdge(0, "e", "b", 0, null);
		d.addEdge(1, "b", "c", 0, null);
	//	d.delNode("a");
	//	d.delNode("e");

//		d.delNode("c");
	//	d.delNode("d");
		//d.delNode("si");
		//d.delNode("b");
		// d.delEdge("c", "a");
		// d.delEdge("c", "e");

		// d.delEdge("c", "b");
		// d.delEdge("b", "c");

		// d.addNode(5,"fggg");

		System.out.println("numEdges: " + d.numEdges());
		System.out.println("numNodes: " + d.numNodes());

		for (Object key : d.getHashMap().keySet()) {

			NodesImpl testNode = (NodesImpl) d.getHashMap().get(key);

			System.out.println(testNode.toString());

			for (EdgeImpl item : testNode.getEdgeList()) {
				System.out.println("   " + item);
			}

		}

		// SUPER TEST

		// String x = MyRandom.nextString(1, 2);
		long startTime = System.currentTimeMillis();
		long elapsedTime;

		// a.addNode(1, "Base");
		int c = 0;
		for (int i = 0; i < 1000000; i++) {
			String x = Integer.toString(i);
			// String y = Integer.toString(i -1);
			// String z = Integer.toString(i -2);
			// String x = MyRandom.nextString(1, 5);

			String y1 = Integer.toString((int) (Math.random() * 1000000));
			String y2 = Integer.toString((int) (Math.random() * 1000000));
			String y3 = Integer.toString((int) (Math.random() * 1000000));
			String y4 = Integer.toString((int) (Math.random() * 1000000));

			// a.addNode(1,y);
			a.addNode(1, x);

			// a.addEdge(1, y, x, 1, null);
			// a.addEdge(1, z, x, 1, null);

			a.addEdge(1, y2, y3, 2, null);
			a.addEdge(1, x, y2, 2, null);
			a.addEdge(1, y1, y4, 3, null);
			a.addEdge(1, y3, y1, 4, null);
			a.addEdge(1, y1, y2, 3, null);
			a.addEdge(1, y2, y4, 3, null);
			// a.addEdge(1, x, "Base", 5, null);
			// a.addEdge(1, y, "Base", 5, null);

		}

		System.out.println("numEdges: " + a.numEdges());
		System.out.println("numNodes: " + a.numNodes());
		/*
		for (Object key : a.getHashMap().keySet()) {

			NodesImpl testNode = (NodesImpl) a.getHashMap().get(key);

			System.out.println(testNode.toString());

			for (EdgeImpl item : testNode.getEdgeList()) {
				System.out.println("   " + item);
			}

			for (int i = 0; i < 4000; i++) {

				a.delNode(Integer.toString(i));
			}

			a.delNode("Base");
		}*/
		
		a.shortestPath("0");
		for (int i = 0; i < 20; i++) {
			System.out.println(a.shortestPath("0")[i]);
		}
		elapsedTime = System.currentTimeMillis() - startTime;

		System.out.println("TIME: " + elapsedTime);

		System.out.println("numEdges: " + a.numEdges());
		System.out.println("numNodes: " + a.numNodes());

		/*
		 * NodesImpl testNode = (NodesImpl) d.getHashMap().get("a");
		 * 
		 * for(EdgeImpl item : testNode.getEdgeList()) { System.out.println(item); }
		 */

	}

	static void printGraph(DiGraph d) {
		for (Object key : d.getHashMap().keySet()) {

			NodesImpl testNode = (NodesImpl) d.getHashMap().get(key);

			System.out.println(testNode.toString());

			for (EdgeImpl item : testNode.getEdgeList()) {
				System.out.println("   " + item);
			}

		}
	}
}