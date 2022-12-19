package randomized;

import java.util.*;

public class LoadBalancing {

    /**
     * use a random number to select a server
     *
     * @param generator
     * @param serverList
     * @return the server
     */
    private Integer loadBalance(Random generator, List<Integer> serverList) {
        // the upper bound is the server amount
        int index = generator.nextInt(serverList.size());
        return serverList.get(index);
    }

    /**
     * using current system time to generator a random
     *
     * @return
     */
    private Random init() {
        return new Random(System.currentTimeMillis());
    }

    public static void main(String[] args) {
        Map<Integer, Integer> serverSelectMapping = new HashMap<>();
        int serverCount = 5;
        for (int i = 1; i <= serverCount; i++) {
            serverSelectMapping.put(i, 0);
        }

        LoadBalancing loadBalancing = new LoadBalancing();
        Random generator = loadBalancing.init();
        int maxCount = 2000000;
        List<Integer> serverList = Arrays.asList(1, 2, 3, 4, 5);
        for (int i = 0; i < maxCount; i++) {
            int server = loadBalancing.loadBalance(generator, serverList);
            Integer selectCount = serverSelectMapping.get(server);
            if (selectCount != null) {
                selectCount = selectCount + 1;
                serverSelectMapping.put(server, selectCount);
            }
        }
        for (int i = 1; i <= serverList.size(); i++) {
            int count = serverSelectMapping.get(i);
            float p = (float) (count) / maxCount;
            System.out.println("Server[" + i + "] was selected " + count + " times. Probability=" + p);
        }
    }
}
