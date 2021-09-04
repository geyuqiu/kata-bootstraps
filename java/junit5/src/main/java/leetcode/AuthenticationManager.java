package leetcode;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private final int timeToLive;
    Map<String, Integer> tokenIsAliveUntil = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokenIsAliveUntil.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (tokenIsAliveUntil.containsKey(tokenId)
                && tokenIsAliveUntil.get(tokenId) > currentTime
        ) {
            tokenIsAliveUntil.replace(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int result = 0;
        for (Map.Entry<String, Integer> entry: tokenIsAliveUntil.entrySet()) {
            if (entry.getValue() > currentTime) {
                result++;
            }
        }

        return result;
    }
}