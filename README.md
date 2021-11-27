received a grade of 93% along with Assignment1

## Problem Statement

Using the principles, mechanisms, and techniques seen in Chapter 3 of the book, design and write the code necessary to enhance the movie library design realized in Assignment 1 to meet the following requirements. *Your solution should continue to respect principles of good design seen in prior chapters.*

1. Add to your library support for TV shows, which are composed of episodes. Each episode corresponds to a specific file path and can capture custom information, similarly to movies. It should be possible to identify an episode by its sequential number. Then, use **interfaces** to support multiple implementations of the following domain concepts: something that can be *watched* (e.g., a movie, an episode, a whole TV show), something that can be *binged* (watchlists and TV shows), and something that can be preceded or followed by related elements (movies can have sequels and episodes are in a sequence). Add relevant methods to your interfaces to show how they differ, and design your interfaces carefully using the **Interface Segregation Principle**. [5 points]
2. Provide a way to access the elements in any *bingeable* object, using good design principles. Keep the solution as general as possible. [5 points]
3. Add a **watchlist generation feature** to your Library class. This feature allows client code to automatically generate watchlists based on algorithms specified by the client. For example, a client may want to include create a watchlist of all English movies from a set of studios, or ten random episodes from a TV show. To illustrate your design, use this feature to generate two different watchlists in your Driver code. [5 points]

