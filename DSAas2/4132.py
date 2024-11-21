def count_parallel_edges(edges):
    # Dictionary to store edge counts
    edge_counts = {}
    
    # Step 1: Count occurrences of each edge
    for u, v in edges:
        # Normalize the edge (min, max) for undirected graph
        edge = (min(u, v), max(u, v))
        if edge in edge_counts:
            edge_counts[edge] += 1
        else:
            edge_counts[edge] = 1
    
    # Step 2: Count the number of parallel edges
    parallel_count = 0
    for count in edge_counts.values():
        if count > 1:
            # Add the extra occurrences as parallel edges
            parallel_count += count - 1
    
    return parallel_count
