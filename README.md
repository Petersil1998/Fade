# Thresh

Fade is an Object-Oriented Java Library, which takes over the Communication with the Valorant API. It supports In-Memory caching and uses a (blocking) Rate Limiter. It makes retrieving Match History, Leaderboards
and static Data like Weapons, Maps, Player cards, etc. much easier.

Other Projects:
- [Thresh](https://github.com/Petersil1998/Thresh) for League of Legends
- [Spatula](https://github.com/Petersil1998/Spatula) for Teamfight Tactics
- [Scuttlegeist](https://github.com/Petersil1998/Scuttlegeist) for Legends of Runeterra

## Usage

In Order for Fade to work properly there are a few things you need to set up
at the beginning of your application.

```JAVA
public class Example {
    public static void main(String[] args) {
        // First we need to provide our Riot API Key. Ideally the API Key is encrypted
        Settings.setAPIKey(() -> EncryptionUtil.encrypt(System.getenv("API_KEY")));
        // If the provided API Key is encrypted, we need to provide a function to decrypt the API Key
        Settings.setDecryptor(EncryptionUtil::decrypt);
        // We also need to provide a language. The language is used to static Data like Champions, Item, etc.
        // NOTE: Not all Languages are supported. A list of supported Languages is available at https://dash.valorant-api.com
        Settings.setLanguage(Language.EN_US);
        // If we want to use caching we can enable it in the Settings. Caching is disabled by default
        Settings.useCache(true);
        // We also need to add the Loader for the static Valorant Data
        Loader.addLoader(new ValLoader());
        // Lastly we need to initialize the static Data
        Loader.init();
    }
}
```

Now Fade is ready and set up!

## Examples

- **Leaderboards**

    ```JAVA
    public class Example {
        public static void main(String[] args) {
            // Setup code...
            
            // First we get the Act ID of an act in a specific Episode.
            // In this example we get Act 1 of Episode 2
            String actId = Seasons.getEpisodeAct(2, 1).getId();
            // Now we can get the Leaderboard for a specific Region
            Leaderboard leaderboard = ValRanked.getLeaderboard(ValRegion.EU, actId);
            // We can get the total amount of Players in this Leaderboard
            int totalPlayer = leaderboard.getTotalPlayers();
            // We can also Iterate over the Players
            for(RankEntry player: leaderboard.getPlayers()) {
                // Get the Players rank
                int rank = player.getLeaderboardRank();
                // Get the Players Name
                String name = player.getName();
                // Get the Players Ranked Rating (LP)
                int rr = player.getRankedRating();
            }
        }
    } 
    ```
    Optionally we can pass a **Filter** Argument to the Leaderboard, which can have the following values:

  | Key        | Description                                                                                                                                                                                                    | Type |
  |------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------|
  | size       | Number of Rank Entries (Players) returned. Has to be between 1 and 200, defaults to 200.                                                                                                                       | int  | 
  | startIndex | The Start Index (Offset) for the Rank Entries (Players). Defaults to 0.                                                                                                                                        | int  |

  **Note**: *All values need to be passed as **Strings** in the filter*


- **Match Details**

    ```JAVA
    public class Example { 
        public static void main(String[] args) {
            // Setup code...
            
            // First we get the Player's Account
            Account me = Account.getAccountByRiotId("Destroyer", "boom", Region.EUROPE);
            // Now we can get the Player's Match History
            List<MatchDetails> matchHistory = MatchDetails.getMatchHistory(me.getPuuid(), ValRegion.EU);
            // Or we can also get a List of Recent Matches in a specific Queue
            List<MatchDetails> recentMatches = MatchDetails.getRecentMatches(QueueType.COMPETITIVE, ValRegion.NA);

            // Now we can iterate over the Match Details
            for(MatchDetails details: matchHistory) {
                // This allows us to get game-specific information like Map played, the Season in which the game was played or the start time
                Map map = details.getMap();
                Season season = details.getSeason();
                long startTime = details.getGameStartMillis();
                // But we can also get Information about the Players
                List<Player> players = details.getPlayers();

                for (Player player: players) {
                    // Now we can get Player-specific Data like Agent, Player Card and Title
                   Agent agent = player.getAgent();
                    PlayerCard card = player.getPlayerCard();
                    PlayerTitle title = player.getPlayerTitle();

                    // It also provides additional Data like kill, deaths, assists
                    Player.Stats stats = player.getStats();
                    int kills = stats.getKills();
                    int deaths = stats.getDeaths();
                    int assists = stats.getAssists();
                }

                // We can also get data about each Round in the Game
                List<RoundResult> roundResults = details.getRoundResults();
                for (RoundResult roundResult: roundResults) {
                    int round = roundResult.getRoundNum();
                    Player planter = roundResult.getBombPlanter();
                    Team team = roundResult.getWinningTeam();
                }
            }
        }
    } 
    ```

- **Collections**

    The package [collection](https://github.com/Petersil1998/Fade/blob/master/src/main/java/net/petersil98/fade/collection/) contains a bunch of Collections for static Data including:
  
    - Agents
    - Bundles
    - Competitive Tiers
    - Contracts
    - Events
    - Maps
    - Player Cards and Titles
    - Seasons
    - Sprays
    - Weapons
    - ...

### Feel free to give Feedback and add suggestions on how this library can be improved. <br>Thank you for using Thresh, you're awesome!
