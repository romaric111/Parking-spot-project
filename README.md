Parking Spot Project
Introduction
This project addresses parking congestion within smart cities using event-driven programming in an object-oriented environment. Developed during the Winter 2023 session, it focuses on intelligent parking management to optimize routes and resources for drivers.

Features
Interactive city interface: Visual representation of routes, intersections, parking spots, and driver movements.

Dynamic parking system: Real-time updates on parking availability.

Optimal path calculation: Determines the shortest route to available parking spots.

Error handling: Implements user-friendly feedback for invalid inputs or actions.

Technologies Used
Java: The core programming language for the application.

Object-Oriented Design: Classes like Node, Edge, Graph, and Server were utilized to structure the city's components and logic.

Graphics API: Libraries like JFrame and Graphics2D for designing the interface.

Dijkstra's Algorithm: Applied for finding the shortest paths to parking stations.

How It Works
Users input their coordinates via the interface.

The server calculates the optimal route using real-time data from parking stations.

The interface dynamically updates to display the chosen route and station details.

Testing
Extensive testing was performed to ensure:

Proper handling of exceptions (e.g., invalid input formats).

Accurate pathfinding and parking spot allocation.

Real-time updates on parking availability.
