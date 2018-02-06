package arraysAndStrings;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class USMap {
	static HashMap<String, Node> city_map = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner inFile = new Scanner(new FileInputStream("resources/roads.txt"));
			
		ArrayList<String> longLat = new ArrayList<>();
		String line = inFile.nextLine();
		while(!line.contains("Cities")) {
			
			line = inFile.nextLine();
			
			}
		line = inFile.nextLine();
		line = inFile.nextLine();
		while(!line.isEmpty()) {
			longLat.add(line);
			line = inFile.nextLine();
		}
		line = inFile.nextLine();
		//System.out.println(line);
		line = inFile.nextLine();
		line = inFile.nextLine();
		//line = inFile.nextLine();
		
		ArrayList<String> distance = new ArrayList<>();
		while(inFile.hasNextLine()) {
			distance.add(line);
			line = inFile.nextLine();
		}
		distance.add(line);

		int l = distance.size();
		for (int i = 0; i < l; i++) {
			String[] cities = distance.get(i).split(",");
			for (int k = 0; k < 2; k++) {
				cities[k] = cities[k].trim();
				if (!city_map.containsKey(cities[k])) {
					Node n1 = new Node(cities[k]);
					city_map.put(cities[k], n1);

				}
			}
			
			Node n1 = city_map.get(cities[0].trim());
			Node n2 = city_map.get(cities[1].trim());
			Edge new_edge = new Edge(n1, n2, Integer.parseInt(cities[2].trim()));

		}

		int x = longLat.size();
		for (int i = 0; i < x; i++) {
			String[] cities = longLat.get(i).split(",");
			Node n1 = city_map.get(cities[0].trim());
			n1.lattitude = Double.parseDouble(cities[1].trim());
			n1.longitute = Double.parseDouble(cities[2].trim());

		}
		if (args.length < 3) {
			System.out.println("Please provide valid command line arguments (search type,source,destination)");
			return;
		}
		if (!(city_map.containsKey(args[1]) && city_map.containsKey(args[2]))) {
			System.out.println("incorrect city names");
			return;
		}

		switch (args[0]) {
		case "astar":
			System.out.println("Astar: "+Astar(city_map.get(args[1]), city_map.get(args[2])));
			break;

		case "dfs":
					System.out.println("dfs");
					dFS(city_map.get(args[1]), city_map.get(args[2]));
			break;
		case "bfs":
			System.out.println("bfs");
					bFS(city_map.get(args[1]), city_map.get(args[2]));
			break;
		default:
			System.out.println("incorrect input");
		}

	}

	public static String Astar(Node start, Node goal) {
		ArrayList<ArrayList> al = new ArrayList<>();
		ArrayList a = new ArrayList<>();
		a.add(start.name);
		a.add(0);
		a.add(0 + getHeuristics(city_map.get(start.name), goal));
		al.add(a);
		ArrayList<String> expanded_nodes = new ArrayList<String>();

		while (!al.isEmpty()) {
			int min_index = 0;
			for (int i = 0; i < al.size(); i++) {
				if ((double) al.get(i).get(2) < (double) al.get(min_index).get(2)) {
					min_index = i;
				}
			}
			ArrayList min_cost_path = al.remove(min_index);
			String tokens[] = min_cost_path.get(0).toString().split("-");
			String vertex = tokens[tokens.length - 1];
			Node node = city_map.get(vertex);
			node.status = "visited";
			expanded_nodes.add(node.name);
			if (node.name == goal.name) {
				System.out.println("List of expanded nodes " + expanded_nodes);
				System.out.println("Number of expanded_nodes " + expanded_nodes.size());
				String[] solution_nodes = min_cost_path.get(0).toString().split("-");
				ArrayList<String> sol_nodes = new ArrayList<String>();
				for (String c : solution_nodes)
					sol_nodes.add(c);
				System.out.println("Solution path: " + sol_nodes);
				System.out.println("Length of the solution path: " + sol_nodes.size());
				return "\nCost of solution path(Total distance)="
						+ min_cost_path.get(1);
			}
			for (Map.Entry<String, Integer> entry : node.adjacent_cities.entrySet()) {
				if (city_map.get(entry.getKey()).status == "unvisited") {
					String new_path = min_cost_path.get(0).toString() + "-" + entry.getKey().toString();
					int g = (int) (min_cost_path.get(1)) + entry.getValue();
					double h = getHeuristics(city_map.get(entry.getKey()), goal);
					double f = g + h;
					a = new ArrayList();
					a.add(new_path);
					a.add(g);
					a.add(f);
					al.add(a);
				}

			}

		}
		return "no path";
	}

	
	public static double getHeuristics(Node start, Node goal) {

		return Math.sqrt(Math.pow((69.5 * (start.lattitude - goal.lattitude)), 2) + Math.pow(
				(69.5 * Math.cos((start.lattitude + goal.lattitude) / 360 * 3.14) * (start.longitute - goal.longitute)),
				2));

	}

	public static String dFS(Node start, Node destination) {
		Stack<String> stack = new Stack<>();
		stack.push(start.getName());
		ArrayList<String> expanded_nodes = new ArrayList<String>();
		while (!stack.empty()) {

			String popped_path = stack.pop();
			//System.out.println(popped_path);

			SortedSet<String> paths_for_sort = new TreeSet<String>(Collections.reverseOrder());

			String tokens[] = popped_path.split("-");
			String vertex = tokens[tokens.length - 1];
			Node node = city_map.get(vertex);
			if (node.getName() == destination.getName()) {
				System.out.println("List of expanded nodes " + expanded_nodes);
				System.out.println("Number of expanded_nodes " + expanded_nodes.size());
				System.out.println("The solution path is: "+popped_path);
				System.out.println("The length of the solution path is: "+popped_path.split("-").length);
				
				return popped_path;
				}
			if (node.getStatus() == "unvisited") {
				node.setStatus("visited");
				expanded_nodes.add(node.name);
				for (String s : node.adjacent_cities.keySet()) {
					Node n = city_map.get(s);
					if (n.getStatus() == "unvisited") {
						String new_path = popped_path + "-" + n.getName();
						paths_for_sort.add(new_path);
					}
				}
				Iterator iterator = paths_for_sort.iterator();
				while (iterator.hasNext())

				{
					stack.push(iterator.next().toString());

				}
			}

		}

		return "NO PATH";
	}

	public static String bFS(Node start, Node destination) {
		Queue<String> queue = new LinkedList<>();
		queue.add(start.getName());
		ArrayList<String> expanded_nodes = new ArrayList<String>();
		while (!queue.isEmpty()) {

			String popped_path = queue.remove();
			//System.out.println(popped_path);
			SortedSet<String> paths_for_sort = new TreeSet<String>();

			String tokens[] = popped_path.split("-");
			String vertex = tokens[tokens.length - 1];
			Node node = city_map.get(vertex);
			if (node.getName() == destination.getName()) {
				System.out.println("List of expanded nodes " + expanded_nodes);
				System.out.println("Number of expanded_nodes " + expanded_nodes.size());
				System.out.println("The solution path is: "+popped_path);
				System.out.println("The length of the solution path is: "+popped_path.split("-").length);
				return popped_path;
				}
			if (node.getStatus() == "unvisited") {
				node.setStatus("visited");
				expanded_nodes.add(node.name);
				for (String s : node.adjacent_cities.keySet()) {
					Node n = city_map.get(s);
					if (n.getStatus() == "unvisited") {
						String new_path = popped_path + "-" + n.getName();
						paths_for_sort.add(new_path);
					}
				}
				Iterator iterator = paths_for_sort.iterator();
				while (iterator.hasNext())

				{
					queue.add(iterator.next().toString());

				}
			}

		}

		return "NO PATH";
	}

}

class Node {

	public String name;
	public String status = "unvisited";
	public double lattitude, longitute;

	public HashMap<String, Integer> adjacent_cities;

	public Node(int lat, int lng) {

		this.lattitude = lat;
		this.longitute = lng;

	}

	public Node(String name) {
		this.name = name;

		this.adjacent_cities = new HashMap<>();

	}

	public void setStatus(String string) {

		this.status = string;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdjacentNodes(Node dest, int weight) {
		this.adjacent_cities.put(dest.name, weight);

	}

}

class Edge {
	public Node start, end;
	int weight;

	public Edge(Node s, Node d, int w) {

		this.start = s;
		this.end = d;

		this.weight = w;
		s.setAdjacentNodes(d, w);
		d.setAdjacentNodes(s, w);

	}

	public Node getS() {
		return start;
	}

	public void setS(Node s) {
		this.start = s;
	}

	public Node getD() {
		return end;
	}

	public void setD(Node d) {
		this.end = d;
	}

}
