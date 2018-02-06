package arraysAndStrings;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

// class for storing the details related to cities
class City {
	public String name;
	public String status = "unvisited";
	public double lattitude, longitute;
	public HashMap<String, Integer> adjacent_cities;
	public City(int lat, int lng) {
		this.lattitude = lat;
		this.longitute = lng;
	}

	public City(String name) {
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

	public void setAdjacentNodes(City dest, int weight) {
		this.adjacent_cities.put(dest.name, weight);
	}
}
// class for storing the details related to the roads connecting 2 cities
class Road {
	public City source, dest;
	int weight;
	
	public Road(City source, City dest, int cost) {
		this.source = source;
		this.dest = dest;
		this.weight = cost;
		source.setAdjacentNodes(dest, cost);
		dest.setAdjacentNodes(source, cost);
	}
}

public class BfsDfsAstar {
	static HashMap<String, City> road_map = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner scan = new Scanner(new FileInputStream("resources/roads.txt"));
			
		ArrayList<String> longLat = new ArrayList<>();
		String line = scan.nextLine();
		while(!line.contains("Cities")) {
			line = scan.nextLine();
		}
		line = scan.nextLine();
		line = scan.nextLine();
		while(!line.isEmpty()) {
			longLat.add(line);
			line = scan.nextLine();
		}
		line = scan.nextLine();
		line = scan.nextLine();
		line = scan.nextLine();
		
		ArrayList<String> distance = new ArrayList<>();
		while(scan.hasNextLine()) {
			distance.add(line);
			line = scan.nextLine();
		}
		distance.add(line);
		scan.close();
		int l = distance.size();
		for (int i = 0; i < l; i++) {
			String[] cities = distance.get(i).split(",");
			for (int k = 0; k < 2; k++) {
				cities[k] = cities[k].trim();
				if (!road_map.containsKey(cities[k])) {
					City city1 = new City(cities[k]);
					road_map.put(cities[k], city1);
				}
			}
			City city1 = road_map.get(cities[0].trim());
			City city2 = road_map.get(cities[1].trim());
			Road new_edge = new Road(city1, city2, Integer.parseInt(cities[2].trim()));
		}

		for (int i = 0; i < longLat.size(); i++) {
			String[] cities = longLat.get(i).split(",");
			City city1 = road_map.get(cities[0].trim());
			city1.lattitude = Double.parseDouble(cities[1].trim());
			city1.longitute = Double.parseDouble(cities[2].trim());
		}

		// validating format of input parameters
		if (args.length != 3) {
			System.out.println("Please provide arguments in the mentioned format:  \nsearch_type(bfs, dfs, astar) source destination");
			return;
		}
		if (!(road_map.containsKey(args[1]) && road_map.containsKey(args[2]))) {
			System.out.println("Incorrect format or city not found. \nPlease enter:  	search_type(bfs, dfs, astar) source destination");
			return;
		}

		// calling method based on the type of arguments entered
		switch (args[0]) {
			case "astar":
				System.out.println(astar(road_map.get(args[1]), road_map.get(args[2])));
				break;
			case "dfs":
				dfs(road_map.get(args[1]), road_map.get(args[2]));
				break;
			case "bfs":
				bfs(road_map.get(args[1]), road_map.get(args[2]));
				break;
			default:
				System.out.println("Please provide correct input.");
		}
	}

	// returns the total distance of solution path
	public static String astar(City source, City destination) {
		ArrayList<ArrayList> heuristic_map = new ArrayList<>();
		ArrayList heuristic = new ArrayList<>();
		heuristic.add(source.name);
		heuristic.add(0);
		heuristic.add(0 + calcHeuristics(road_map.get(source.name), destination));
		heuristic_map.add(heuristic);
		ArrayList<String> expanded_nodes = new ArrayList<String>();

		while (!heuristic_map.isEmpty()) {
			int min_value = 0;
			for (int i = 0; i < heuristic_map.size(); i++) {
				if ((double) heuristic_map.get(i).get(2) < (double) heuristic_map.get(min_value).get(2)) {
					min_value = i;
				}
			}
			ArrayList min_path = heuristic_map.remove(min_value);
			String tokens[] = min_path.get(0).toString().split("-");
			String vertex = tokens[tokens.length - 1];
			City node = road_map.get(vertex);
			node.status = "visited";
			expanded_nodes.add(node.name);
			
			// if destination is reached, print the solution path and cost
			if (node.name == destination.name) {
				String[] solution_nodes = min_path.get(0).toString().split("-");
				ArrayList<String> sol_nodes = new ArrayList<String>();
				for (String c : solution_nodes)
					sol_nodes.add(c);
				System.out.println("\nSolution path: \t" + sol_nodes);
				System.out.println("\nLength of the solution path: \t" + sol_nodes.size() + "\n");
				System.out.println("Expanded Nodes: \t" + expanded_nodes);
				System.out.println("\nNumber of Expanded Nodes: \t" + expanded_nodes.size() + "\n");
				
				return "\nTotal distance of solution path: \t" + min_path.get(1);
			}
			
			// if city is unvisited, calculate the heuristic from source to present city
			for (Map.Entry<String, Integer> entry : node.adjacent_cities.entrySet()) {
				if (road_map.get(entry.getKey()).status == "unvisited") {
					String current_path = min_path.get(0).toString() + "-" + entry.getKey().toString();
					int prev_heuristic = (int) (min_path.get(1)) + entry.getValue();
					double current_heuristic = calcHeuristics(road_map.get(entry.getKey()), destination);
					double total_heuristic = prev_heuristic + current_heuristic;
					heuristic = new ArrayList();
					heuristic.add(current_path);
					heuristic.add(prev_heuristic);
					heuristic.add(total_heuristic);
					heuristic_map.add(heuristic);
				}
			}
		}
		return "Path not found.";
	}

	// returns the heuristics for given pair of source and destination nodes
	public static double calcHeuristics(City source, City dest) {
		return Math.sqrt(Math.pow((69.5 * (source.lattitude - dest.lattitude)), 2) + Math.pow((69.5 * Math.cos((source.lattitude + dest.lattitude) / 360 * 3.14) * (source.longitute - dest.longitute)), 2));
	}

	// returns the dfs path
	public static String dfs(City source, City destination) {
		Stack<String> list_of_cities = new Stack<>();
		list_of_cities.push(source.getName());
		ArrayList<String> expanded_nodes = new ArrayList<String>();
		while (!list_of_cities.empty()) {
			SortedSet<String> sorted_path = new TreeSet<String>(Collections.reverseOrder());
			String solution_path = list_of_cities.pop();
			String tokens[] = solution_path.split("-");
			City city = road_map.get(tokens[tokens.length - 1]);
			
			// check if the destination city is reached
			if (city.getName() == destination.getName()) {
				System.out.println("\nThe solution path is: \t" + solution_path);
				System.out.println("\nThe length of the solution path is: \t" + solution_path.split("-").length);
				System.out.println("\nList of expanded DFS nodes \t" + expanded_nodes);
				System.out.println("\nNumber of expanded_nodes \t" + expanded_nodes.size());
				return solution_path;
			}
			
			// if new city is found, expand the nodes and add to the list
			if (city.getStatus() == "unvisited") {
				city.setStatus("visited");
				expanded_nodes.add(city.name);
				for (String s : city.adjacent_cities.keySet()) {
					City c = road_map.get(s);
					if (c.getStatus() == "unvisited") {
						String new_path = solution_path + "-" + c.getName();
						sorted_path.add(new_path);
					}
				}
				Iterator<String> iterator = sorted_path.iterator();
				while (iterator.hasNext()) {
					String next = iterator.next().toString();
					list_of_cities.push(next);
				}
			}
		}
		return "Path not found.";
	}

	// returns bfs path
	public static String bfs(City source, City destination) {
		Queue<String> list_of_cities = new LinkedList<>();
		list_of_cities.add(source.getName());
		ArrayList<String> expanded_nodes = new ArrayList<String>();
		while (!list_of_cities.isEmpty()) {
			String solution_path = list_of_cities.remove();
			SortedSet<String> sorted_path = new TreeSet<String>();
			String tokens[] = solution_path.split("-");
			String vertex = tokens[tokens.length - 1];
			City city = road_map.get(vertex);
			
			// check if the destination city is reached
			if (city.getName() == destination.getName()) {
				System.out.println("\nThe solution path is: \t"+ solution_path);
				System.out.println("\nThe length of the solution path is: \t"+ solution_path.split("-").length);
				System.out.println("\nList of expanded nodes \t" + expanded_nodes);
				System.out.println("\nNumber of expanded_nodes \t" + expanded_nodes.size());
				return solution_path;
			}
			
			// if new city is found, expand the nodes and add to the list
			if (city.getStatus() == "unvisited") {
				city.setStatus("visited");
				expanded_nodes.add(city.name);
				for (String s : city.adjacent_cities.keySet()) {
					City n = road_map.get(s);
					if (n.getStatus() == "unvisited") {
						String new_path = solution_path + "-" + n.getName();
						sorted_path.add(new_path);
					}
				}
				Iterator<String> iterator = sorted_path.iterator();
				while (iterator.hasNext()) {
					String next = iterator.next().toString();
					list_of_cities.add(next);
				}
			}
		}
		return "Path not found.";
	}
}
