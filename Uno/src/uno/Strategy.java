package uno;

// have all strategies implement strategy so they "is a" strategy
// then to run the game we can pass a strategy to the game simulator
// and we know they all will be strategies and have this method

public interface Strategy 
{
    public void drawCard();
}
