public class VirtualThreadExample {

    public static void main(String[] args)
            throws Exception {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {

            Thread.startVirtualThread(() -> {

                System.out.println(
                        "Running Virtual Thread");
            });
        }

        Thread.sleep(2000);

        long end = System.currentTimeMillis();

        System.out.println(
                "Time Taken: "
                + (end - start)
                + " ms");
    }
}